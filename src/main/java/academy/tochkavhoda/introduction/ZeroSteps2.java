package academy.tochkavhoda.introduction;

import java.util.Random;

public class ZeroSteps2 {
    public int sumSquares(int count) {
        int sum = 0;
        int i = 1;
        while (i <= count) {
            sum += i * i;
            i++;
        }
        return sum;
    }

    public int sumOdds(int count) {
        int sum = 0;
        int i = 1;
        while (i <= count) {
            sum += i;
            i += 2;
        }
        return sum;
    }

    public double sumInverses(int count) {
        double sum = 0.0;
        int i = 1;
        while (i <= count) {
            sum += 1.0 / i;
            i++;
        }
        return sum;
    }

    public long factorial(int count) {
        long result = 1;
        int i = 2;
        while (i <= count) {
            result *= i;
            i++;
        }
        return result;
    }

    public int prodDigits(int value) {
        int product = 1;
        int num = value;
        while (num > 0) {
            product *= num % 10;
            num = num / 10;
        }
        return product;
    }

    public int fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        int a = 0, b = 1;
        int i = 2;
        while (i <= number) {
            int next = a + b;
            a = b;
            b = next;
            i++;
        }
        return b;
    }

    public long sum2Powers(int max) {
        long sum = 0;
        long power = 1;
        int i = 0;
        while (i <= max) {
            sum += power;
            power *= 2;
            i++;
        }
        return sum;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        int i = 1;
        while (i <= count && sum <= barrier) {
            sum += i * i;
            i++;
        }
        return sum;
    }

    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        int i = 1;
        while (i <= count1) {
            int j = 1;
            while (j <= count2) {
                sum += i * j;
                j++;
            }
            i++;
        }
        return sum;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        int i = 1;
        while (i <= count1) {
            int j = 1;
            while (j <= count2) {
                int product = i * j;
                if (product < barrier) {
                    sum += product;
                }
                j++;
            }
            i++;
        }
        return sum;
    }

    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        int i = 1;
        while (i <= count1) {
            int j = 1;
            while (j <= count2) {
                sum += 1.0 / (i * j);
                j++;
            }
            i++;
        }
        return sum;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        int i = 1;
        while (i <= count1) {
            int j = 1;
            while (j <= count2) {
                int k = 1;
                while (k <= count3) {
                    sum += i * j * k;
                    k++;
                }
                j++;
            }
            i++;
        }
        return sum;
    }

    public double calculateE() {
        double e = 1.0;
        double factorial = 1.0;
        int n = 1;

        while (true) {
            factorial *= n;
            double term = 1.0 / factorial;
            if (term < 1E-6) {
                break;
            }
            e += term;
            n++;
        }
        return e;
    }

    public double calculatePi() {
        double pi = 0.0;
        int i = 0;
        while (i < 1000000) {
            if (i % 2 == 0) {
                pi += 1.0 / (2 * i + 1);
            } else {
                pi -= 1.0 / (2 * i + 1);
            }
            i++;
        }
        return 4 * pi;
    }

    public double calculateCircleSquare(double length, int count) {
        int k = 0;
        Random random = new Random();
        int i = 0;

        while (i < count) {
            double x = random.nextDouble() * length;
            double y = random.nextDouble() * length;
            double radius = length / 2;

            if (Math.pow(x - radius, 2) + Math.pow(y - radius, 2) <= Math.pow(radius, 2)) {
                k++;
            }
            i++;
        }

        return (length * length * k) / count;
    }
}