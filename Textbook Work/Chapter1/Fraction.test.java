class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int gcd(int m, int n) {
        while (m % n != 0) {
            int saveM = m;
            m = n;
            n = saveM % n;
        }
        return n;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator +
                this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;

        int common = gcd(newNumerator, newDenominator);

        return new Fraction(newNumerator / common,
            newDenominator / common);
    }

    public static Fraction add(Fraction fracA, Fraction fracB) {
        return fracA.add(fracB);
    }

    public String toString() {
      return String.format("%d/%d", this.numerator, this.denominator);
    }

    public boolean equals(Fraction other) {
        int product1 = this.numerator * other.denominator;
        int product2 = this.denominator * other.numerator;

        return product1 == product2;
    }
    
    public Fraction subtract(Fraction other) { // subtract this fraction from other fraction
        int newNumerator = (this.numerator * other.denominator) - (this.denominator * other.numerator);
        int newDenominator = this.denominator * other.denominator;

        int common = gcd(newNumerator, newDenominator);

        return new Fraction(newNumerator / common,
            newDenominator / common);
    }
    
    public Fraction multiply(Fraction other) { // multiply this fraction to other fraction
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;

        int common = gcd(newNumerator, newDenominator);

        return new Fraction(newNumerator / common,
            newDenominator / common);
    }
    
    public Fraction divide(Fraction other) { // divide this fraction by other fraction
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        int common = gcd(newNumerator, newDenominator);

        return new Fraction(newNumerator / common,
            newDenominator / common);
    }
    
    public int compareTo(Fraction other) { // compare this fraction to other fraction
         int product1 = this.numerator * other.denominator;
         int product2 = this.denominator * other.numerator;
        
        if (product1 == product2) {
        return 0;
        }
        else if (product1 < product2) {
            return -1;
        }
        else {
            return 1;
        }
        
    }
}

public class FractionTest {
    public static void main(String[] args) {
        Fraction myFraction = new Fraction(3, 5);
        System.out.println(myFraction);

        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f1.add(f2);
        System.out.println(f3);

        Fraction f4 = new Fraction(3, 5);
        Fraction f5 = f4;
        Fraction f6 = new Fraction(3, 5);
        System.out.println(f4 == f5);       // shallow compare is true
        System.out.println(f4 == f6);       // but references aren't same
        System.out.println(f4.equals(f5)); // deep compare is true
        System.out.println(f4.equals(f6)); // and here also.

        Fraction f7 = new Fraction(1, 2);
        Fraction f8 = new Fraction(1, 3);
        Fraction f9 = Fraction.add(f7, f8);
        System.out.println(f9);
        
        // Testing new methods
        Fraction f10 = new Fraction(1, 4);
        Fraction f11 = new Fraction(3, 7);
        System.out.println(f11.compareTo(f10));
        
        Fraction f12 = new Fraction(4, 10);
        Fraction f13 = new Fraction(2, 10);
        System.out.println(f12.subtract(f13));
        
        Fraction f14 = new Fraction(3, 5);
        Fraction f15 = new Fraction(9, 10);
        System.out.println(f14.multiply(f15));
        
        Fraction f16 = new Fraction(3, 5);
        Fraction f17 = new Fraction(1, 7);
        System.out.println(f16.divide(f17));
        
    }
}
