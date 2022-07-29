package db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import dto.StudentDTO;
import util.Constant;

public class StudentManageDB {

	public static void insertStudent(StudentDTO student) {
		CSVWriter writer;

		try {
			CSVReader reader = new CSVReader (new FileReader(Constant.STUDENTINFO_FILE_PATH));
			List<String[]> csvBody = reader.readAll();

			if(csvBody.size() != 0 ) {
				int lastIndex = Integer.parseInt(csvBody.get(csvBody.size()-1)[0]);
				//				System.out.println(lastIndex);
				student.setStudentId(lastIndex +1 );
			}
			else {
				student.setStudentId(0);
			}
			//			student.printStudentinfo();

			writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_FILE_PATH, true));
			String lineArr[] = {Integer.toString(student.getStudentId()), student.getName(), String.valueOf(student.getGrade()), String.valueOf(student.getBirthday())};
			writer.writeNext(lineArr);
			writer.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}





		//		return result;




	}

	public static ArrayList<StudentDTO> selectAllStudent() {
		ArrayList<StudentDTO> studentManageList = new ArrayList<>();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_FILE_PATH));
			String[] nextLine;

			while((nextLine = reader.readNext()) != null) {
				StudentDTO tempStudent = new StudentDTO();
				tempStudent.setStudentId(nextLine[0]);
				tempStudent.setName(nextLine[1]);
				tempStudent.setGrade(nextLine[2]);
				tempStudent.setBirthday(nextLine[3]);
				studentManageList.add(tempStudent);

				//아이디, 이름, 학년, 생일

			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return studentManageList;


	}

	public static StudentDTO searchStudent(String findStudentName) {
		StudentDTO student = new StudentDTO();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_FILE_PATH));
			String[] nextLine;

			while((nextLine = reader.readNext()) != null) {
				if(nextLine[1].compareTo(findStudentName) == 0) {
					student.setStudentId(nextLine[0]);
					student.setName(nextLine[1]);
					student.setGrade(nextLine[2]);
					student.setBirthday(nextLine[3]);
					break;
					//아이디, 이름, 학년, 생일
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return student;
	}

	public static StudentDTO updateStudent(String findStudentName, StudentDTO updateinfo) {

		StudentDTO result = new StudentDTO();

		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_FILE_PATH));

			List<String[]> csvBody = reader.readAll();
			for(int i = 0 ; i<csvBody.size();i++) {
				if(csvBody.get(i)[1].compareTo(findStudentName) == 0 ) {
					csvBody.get(i)[1] = updateinfo.getName();
					csvBody.get(i)[2] = String.valueOf(updateinfo.getGrade());
					csvBody.get(i)[3] = String.valueOf(updateinfo.getBirthday());

					result.setName(updateinfo.getName());
					result.setGrade(updateinfo.getGrade());
					result.setBirthday(updateinfo.getBirthday());
					break;
				}
			}
			CSVWriter writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_FILE_PATH));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();


		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}



		return result;
	}

	public static StudentDTO deleteStudent(String findStudentName) {

		StudentDTO result = new StudentDTO();

		try {
			CSVReader reader = new CSVReader ( new FileReader(Constant.STUDENTINFO_FILE_PATH));

			List<String[]> csvBody = reader.readAll();
			for(int i = 0 ; i <csvBody.size(); i++) {
				if(csvBody.get(i)[1].compareTo(findStudentName) == 0 ) {
					result.setStudentId(csvBody.get(i)[0]);
					result.setName(csvBody.get(i)[1]);
					result.setGrade(csvBody.get(i)[2]);
					result.setBirthday(csvBody.get(i)[3]);

					csvBody.remove(i);
					break;

				}
			}
			CSVWriter writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_FILE_PATH));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}


		return result;

	}

	public static void insertStudentScore(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		CSVWriter writer;

		try {
			writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_SCORE_FILE_PATH, true));
			String lineArr[] = {String.valueOf(studentDTO.getStudentId()), studentDTO.getKoreanScore(), studentDTO.getEnglishScore(), studentDTO.getMathScore(), studentDTO.getScienceScore()};
			writer.writeNext(lineArr);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static StudentDTO searchStudentScore(String findStudentId) {
		StudentDTO student = new StudentDTO();

		
		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_SCORE_FILE_PATH)); // studentscore파일을 reader로 읽는다.
			String[] nextLine;

			while((nextLine = reader.readNext()) != null) { // 스트링값과 리더의 값이 같지 않다면
				if(nextLine[0].compareTo(String.valueOf(findStudentId)) == 0 ) { //nextLine[0]:id와 student에 있는 id값을 비교하여 같다면
					student.setStudentId(nextLine[0]);
					student.setKoreanScore(nextLine[1]); //국어, 영어, 수학, 과학을 student에 들고온다.
					student.setEnglishScore(nextLine[2]);
					student.setMathScore(nextLine[3]);
					student.setScienceScore(nextLine[4]);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return student; // studentDTO에 값이 담긴다(값: 국어, 영어, 수학, 과학 성적)

	}

	public static StudentDTO updateStudentScore(StudentDTO updateinfo) {
	
		StudentDTO result = new StudentDTO();
		
		try {
			CSVReader reader = new CSVReader(new FileReader(Constant.STUDENTINFO_SCORE_FILE_PATH));
			//스코어 파일을 다 읽겠다
			List<String[]> csvBody = reader.readAll();
			for(int i = 0 ; i<csvBody.size();i++) {
				if(csvBody.get(i)[0].compareTo(String.valueOf(updateinfo.getStudentId())) == 0 ) { // findStudentId의 값과 csvBody 0번째를 비교해서 같다면 
					csvBody.get(i)[1] = updateinfo.getKoreanScore(); // 국어, 영어, 수학, 과학을 업데이터가능한 상태로 만든다
					csvBody.get(i)[2] = updateinfo.getEnglishScore();
					csvBody.get(i)[3] = updateinfo.getMathScore();
					csvBody.get(i)[4] = updateinfo.getScienceScore();
					
					result.setKoreanScore(updateinfo.getKoreanScore()); //값을 새로 업데이트 시켜준다
					result.setEnglishScore(updateinfo.getEnglishScore());
					result.setMathScore(updateinfo.getMathScore());
					result.setScienceScore(updateinfo.getScienceScore());
					
					break;
				}
			}
			CSVWriter writer = new CSVWriter(new FileWriter(Constant.STUDENTINFO_SCORE_FILE_PATH));
			writer.writeAll(csvBody);			
			writer.flush();
			writer.close();


		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (CsvValidationException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CsvException e) {
			e.printStackTrace();
		}



		return result;
	}


}

