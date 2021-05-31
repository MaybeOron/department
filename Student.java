public class Student extends Person {
    private int cardNumber;

    public Student(String firstName, String lastName, int cardNumber) {
        super(firstName, lastName);
        this.cardNumber = cardNumber;
    }

    public void print(boolean printID) {
        super.print();
        if ( printID ) {
            System.out.println("Number: " + this.cardNumber);
        }
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

}
