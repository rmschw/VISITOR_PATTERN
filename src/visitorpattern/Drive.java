package visitorpattern;

public class Drive {
	public static void main(String args[]) {
		Class classes = buildClass();
		Visitor visitor = new printVisitor();
		visitClassStructure(classes, visitor);
	}

	private static Class buildClass() {
		Student s1 = new Student("S1", "A1");
		Student s2 = new Student("S2", "A");
		Student s3 = new Student("S3", "B");
		Student s4 = new Student("S4", "C");
		Student s5 = new Student("S5", "A");
		Student s6 = new Student("S6", "A1");
		Student s7 = new Student("S7", "A1");

		TA TA1 = new TA("TA1", s1, s2, s3);
		TA TA2 = new TA("TA21", s4, s5);
		TA TA3 = new TA("TA3", s6, s7);

		Professor p1 = new Professor("P1", TA1, TA2, TA3);
		return TA1;

	}

	private static void visitClassStructure(Class classes, Visitor visitor) {
		classes.accept(visitor);
		classes.getDirectAssignees().forEach(e -> visitClassStructure(e, visitor));
	}
}
