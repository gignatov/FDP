import java.util.ArrayList;
import java.util.List;

public interface Question {
	public void nextQuestion();
	public void previousQuestion();
	public void newQuestion(String q);
	public void deleteQuestion(String q);
	public void displayQuestion();
	public void displayAllQuestions();
}

public class JavaQuestions implements Question {
	private List <String> questions = new ArrayList<String>();
	private int current = 0;
	public JavaQuestions() {
		questions.add("What is class? ");
		questions.add("What is interface? ");
		questions.add("How multiple polymorphism is achieved in java? ");
		questions.add("How many types of excepiton handling are there in java? ");
		questions.add("Define the keyword final for variable, method, and class in java? ");
		questions.add("What is abstract class? ");
		questions.add("What is multi-threading? ");
	}
	public void nextQuestion() {
		if(current <= questions.size()-1)
			current++;
	}
	public void previousQuestion() {
		if(current > 0)
			current--;
	}
	public void newQuestion(String quest) {
		questions.add(quest);
	}
	public void deleteQuestion(String quest) {
		questions.remove(quest);
	}
	public void displayQuestion() {
		System.out.println(questions.get(current));
	}
	public void displayAllQuestions() {
		for(String quest : questions) {
			System.out.println(quest);
		}
	}
}

public class QuestionManager {
	protected Question q;
	public String catalog;
	public QuestionManager(String catalog) {
		this.catalog = catalog;
	}
	public void next() {
		q.nextQuestion();
	}
	public void previous() {
		q.previousQuestion();
	}
	public void newOne(String quest) {
		q.newQuestion(quest);
	}
	public void delete(String quest) {
		q.deleteQuestion(quest);
	}
	public void display() {
		q.displayQuestion();
	}
	public void displayAll() {
		System.out.println("Question Paper: "+catalog);
		q.displayAllQuestions();
	}
}

public class QuestionFormat extends QuestionManager {
	public QuestionFormat(String catalog) {
		super(catalog);
	}
	public void displayAll() {
		System.out.println("\n---------------------------------------------");
		super.displayAll();
		System.out.println("-----------------------------------------------");
	}
}

public clas BridgePatternDemo {
	public static void main(String args[]) {
		QuestionFormat questions = new QuestionFromat("Java Programming Language");
		questions.q = new JavaQuestions();
		questions.next();
		questions.display();
		questions.delete("What is class?");
		questions.newOne("What is inheritance? ");
		questions.newOne("How many types of inheritance are there in Java? ");
		questions.displayAll();
	}
}