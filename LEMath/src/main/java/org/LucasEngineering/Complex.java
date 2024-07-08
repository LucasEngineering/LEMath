/*
Copyright 2024 Lucas Engineering

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

/* Authorship and Modification Information:
Date Created: 2024-07-07
Author: Alexander Lucas

Date Modified: 2024-07-07
Modifier: Alexander Lucas
Description: Create the Complex class.
 */

/* Version History:
Version: 1.0.0
Version Date: 2024-07-07
Modifier: Alexander Lucas
Description: Create first version of this class.
 */

package org.LucasEngineering;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

/**
 * A class that represents a complex number.
 *
 * <p> A complex number is a number that can be expressed in the form z = x + iy, where x and y are real numbers, and i
 * is the imaginary unit sqrt(-1). The real part of the complex number is x, the imaginary part is y, and the complex
 * number is denoted by z. The real part of the complex number is the x-coordinate on the complex plane, and the
 * imaginary part is the y-coordinate on the complex plane. The complex number also has a polar form
 * z = r(cos(θ) + i sin(θ)), where r is the absolute value of the complex number and θ is the angle of the
 * complex number in radians. The absolute value of the complex number is the distance from the origin on the complex
 * plane, and the angle is the direction from the positive x-axis on the complex plane to the complex number. </p>
 *
 * <p> This class stores the real and imaginary components of a complex number as private final doubles. It mimics the
 * behavior of value types by being immutable. This means that the value of a complex number cannot be changed after it
 * is created. All arithmetic operations return a new instance of Complex with the result of the operation. This class
 * is serializable, meaning that it can be converted to a byte stream and saved to a file. </p>
 *
 * <p> This class provides factory constructors to create new instances of Complex with real and imaginary components,
 * real component only, imaginary component only, and polar coordinates. It also provides factory constructors to create
 * new instances of Complex with random real and imaginary components between 0 and 1. This class also provides
 * methods to access the real and imaginary fields, as well as calculate properties of the complex number such as the
 * absolute value, angle, conjugate, negative, normalization, and more. </p>
 *
 * <p> This class provides methods to add, subtract, multiply, and divide instances of complex numbers with other
 * complex numbers and real numbers. It also provides methods for boolean operations such as checking if a complex
 * number is zero, equal to, greater than, or less than another complex number or real number. Because double precision
 * is used for comparisons, the class provides a default tolerance of 1E-12 for comparing double values. </p>
 *
 * <p> Lastly, this class provides some useful complex numbers as constants such as ZERO, ONE, I, and more. </p>
 *
 * <p> Version Notes: create first version of this class. </p>
 *
 *
 * @author Alexander Lucas
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/Complex_number">Complex Number - Wikipedia</a>
 */
@SuppressWarnings("unused")
public final class Complex implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //region Constants.
    /**
     * A complex number with the real and imaginary parts set to 0.
     *
     * @since 1.0.0
     */
    public static final Complex ZERO = new Complex(0.0, 0.0);
    /**
     * A complex number with the real part set to 1 and the imaginary part set to 0.
     *
     * @since 1.0.0
     */
    public static final Complex ONE = new Complex(1.0, 0.0);
    /**
     * A complex number with the real part set to -1 and the imaginary part set to 0.
     *
     * @since 1.0.0
     */
    public static final Complex NEGATIVE_ONE = new Complex(-1.0, 0.0);
    /**
     * A complex number with the real part set to 0 and the imaginary part set to 1.
     *
     * @since 1.0.0
     */
    public static final Complex I = new Complex(0.0, 1.0);
    /**
     * A complex number with the real part set to 0 and the imaginary part set to -1.
     *
     * @since 1.0.0
     */
    public static final Complex NEGATIVE_I = new Complex(0.0, -1.0);
    //endregion

    //region Helper fields.
    /**
     * The default tolerance for comparing double values.
     *
     * @since 1.0.0
     */
    private static final double DEFAULT_TOLERANCE = 1E-12;

    /**
     * A random number generator for creating random complex numbers.
     *
     * @since 1.0.0
     */
    private static final Random random = new Random();
    //endregion

    //region Factory constructors.
    /**
     * Create a new instance of Complex with real and imaginary parts.
     *
     * @param real the real part of the complex number.
     * @param imag the imaginary part of the complex number.
     * @return the new complex number.
     * @since 1.0.0
     */
    public static Complex valueOf(double real, double imag) {
        return new Complex (real, imag);
    }

    /**
     * Create a new instance of Complex with real part only, set the imaginary part to 0.
     *
     * @param real the real part of the complex number.
     * @return the new complex number.
     * @since 1.0.0
     */
    public static Complex valueOfReal(double real) {
        return new Complex(real, 0.0);
    }

    /**
     * Create a new instance of Complex with imaginary part only, set the real part to 0.
     *
     * @param imag the imaginary part of the complex number.
     * @return the new complex number.
     * @since 1.0.0
     */
    public static Complex valueOfImag(double imag) {
        return new Complex(0.0, imag);
    }

    /**
     * Create a new instance of Complex with polar coordinates.
     *
     * @param abs the absolute value of the complex number.
     * @param ang the angle of the complex number in radians.
     * @return the new complex number.
     * @throws IllegalArgumentException if the absolute value is less than 0.
     * @since 1.0.0
     */
    public static Complex valueOfPolar(double abs, double ang) {
        if (abs < 0.0) {
            throw new IllegalArgumentException("Absolute value cannot be negative.");
        }
        return new Complex(abs * Math.cos(ang), abs * Math.sin(ang));
    }

    /**
     * Create a new instance of Complex with random real and imaginary parts between 0 and 1.
     *
     * @return the new complex number.
     * @since 1.0.0
     */
    public static Complex valueOfRandom() {
        return new Complex(random.nextDouble(), random.nextDouble());
    }
    //endregion

    //region Instance fields.
    /**
     * The real part of the complex number. The real part is the x-coordinate on the complex plane. This field is private
     * and final to make the complex number immutable. Use the getReal method to access this field outside of this class.
     *
     * @since 1.0.0
     */
    private final double real;
    /**
     * The imaginary part of the complex number. The imaginary part is the y-coordinate on the complex plane. This field
     * is private and final to make the complex number immutable. Use the getImag method to access this field outside of
     * this class.
     *
     * @since 1.0.0
     */
    private final double imag;
    //endregion

    //region Constructors.
    /**
     * Create a new instance of Complex with real and imaginary parts. This constructor is private to give more control
     * over the creation of new instances and provides the user with clearer methods for creating complex numbers with
     * different arguments. Use the factory constructors to create new instances of Complex outside of this class.
     *
     * @param real the real part of the complex number.
     * @param imag the imaginary part of the complex number.
     * @since 1.0.0
     */
    private Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    //endregion

    //region Accessors and Getters.
    /**
     * Access the default tolerance for comparing double values.
     *
     * @return the default tolerance for comparing double values.
     * @since 1.0.0
     */
    public double getDefaultTolerance() {
        return DEFAULT_TOLERANCE;
    }

    /**
     * Access the real part (x) of this complex number. The real part is the x-coordinate on the complex plane.
     *
     * @return the real part of this complex number.
     * @since 1.0.0
     */
    public double getReal() {
        return real;
    }

    /**
     * Access the imaginary part (y) of this complex number. The imaginary part is the y-coordinate on the complex plane.
     *
     * @return the imaginary part of this complex number.
     * @since 1.0.0
     */
    public double getImag() {
        return imag;
    }

    /**
     * Calculate the absolute value (r) of this complex number. The absolute value is the distance from the origin on the complex plane.
     *
     * <p> The absolute value calculated by taking the square root of the sum of the squares of the real and imaginary parts. </p>
     * <p> r = sqrt(x^2 + y^2) </p>
     *
     * <p> The absolute value is also known as the magnitude or modulus. </p>
     *
     * @return the absolute value of this complex number.
     * @since 1.0.0
     */
    public double getAbs() {
        return Math.sqrt(real * real + imag * imag);
    }

    /**
     * Calculate the angle (θ) of this complex number in radians. The angle is the direction from the
     * positive x-axis on the complex plane to the complex number and is bounded such that -π < θ ≤ π. To get the angle
     * in a unit other than radians, use the conversion methods in the {@link AngleUnit} enum.
     *
     * <p> The angle calculated by taking the arc-tangent of the imaginary part divided by the real part, accounting for
     * the quadrant of the complex number. </p>
     *
     * <p> θ = atan(y / x) </p>
     *
     * <p> The angle is also known as the phase or argument. </p>
     *
     * @return the angle of this complex number in radians.
     * @see AngleUnit
     * @since 1.0.0
     */
    public double getAng() {
        return Math.atan2(imag, real);
    }

    /**
     * Calculate the negative of this complex number (-z). The negative is the reflection of the complex number across the
     * origin on the complex plane and is meant to represent the unary minus operation.
     *
     * <p> The negative calculated by multiplying the real and imaginary parts by -1. </p>
     *
     * <p> -z = -x - iy </p>
     *
     * <p> The negative is also known as the additive inverse or negation. </p>
     *
     * @return the negative of this complex number.
     * @since 1.0.0
     */
    public Complex getNeg() {
        return new Complex(-real, -imag);
    }

    /**
     * Calculate the complex conjugate (z*) of this complex number. The complex conjugate is the reflection of the
     * complex number across the real axis.
     *
     * <p> The complex conjugate is calculated by multiplying the imaginary part by -1. </p>
     *
     * <p> z* = x - iy </p>
     *
     * @return the conjugate of this complex number.
     * @since 1.0.0
     */
    public Complex getConj() {
        return new Complex(real, -imag);
    }

    /**
     * Calculate the negative complex conjugate (-z*) of this complex number. The negative complex conjugate is the
     * reflection of the complex number across the imaginary axis.
     *
     * <p> The negative complex conjugate is calculated by multiplying the real part by -1. </p>
     *
     * <p> -z* = -x + iy </p>
     *
     * @return the negative conjugate of this complex number.
     * @since 1.0.0
     */
    public Complex getNegConj() {
        return new Complex(-real, imag);
    }

    /**
     * Calculate the reciprocal (1/z) of this complex number. The reciprocal is the complex number that when multiplied
     * by this complex number equals 1.
     *
     * <p> The reciprocal is calculated by dividing 1 by this complex number. If this complex number is 0, the result
     * will be NaN. </p>
     *
     * <p> 1/z = 1 / (x + iy) = x / (x^2 + y^2) - iy / (x^2 + y^2) </p>
     *
     * @return the reciprocal of this complex number.
     * @since 1.0.0
     */
    public Complex getReciprocal() {
        return ONE.div(this);
    }

    /**
     * Calculate the negative reciprocal (-1/z) of this complex number. The negative reciprocal is the complex number
     * that when multiplied by this complex number equals -1.
     *
     * <p> The negative reciprocal is calculated by dividing -1 by this complex number. If this complex number is 0, the
     * result will be NaN. </p>
     *
     * <p> -1/z = -1 / (x + iy) = -x / (x^2 + y^2) + iy / (x^2 + y^2) </p>
     *
     * @return the negative reciprocal of this complex number.
     * @since 1.0.0
     */
    public Complex getNegReciprocal() {
        return NEGATIVE_ONE.div(this);
    }

    /**
     * Calculate the normalization (u) of this complex number. The normalization is the complex number with the same
     * angle and an absolute value of 1.
     *
     * <p> The normalization is calculated by dividing the real and imaginary parts by the absolute value. If the
     * absolute value is 0, the normalization is 0. </p>
     *
     * <p> u = x / r + iy / r </p>
     *
     * <p> The normalization is also known as the unit vector. </p>
     *
     * @return the normalization of this complex number.
     * @since 1.0.0
     */
    public Complex getNorm() {
        double r = getAbs();
        if (r == 0.0) {
            return ZERO;
        }
        return this.div(r);
    }

    /**
     * Calculate the real ratio of this complex number. The real ratio represents the ratio of the real part to the
     * absolute value of the complex number.
     *
     * <p> The real ratio is calculated by dividing the absolute value of the real part by the absolute value of this
     * complex number. If the absolute value is 0, the result will be
     * NaN. </p>
     *
     * @return the real ratio of this complex number.
     * @since 1.0.0
     */
    public double getRealRatio() {
        return Math.abs(real) / getAbs();
    }

    /**
     * Calculate the imaginary ratio of this complex number. The imaginary ratio represents the ratio of the imaginary
     * part to the absolute value of the complex number.
     *
     * <p> It is calculated by dividing the absolute value of the imaginary part by the absolute value of this complex
     * number. If the absolute value is 0, the result will be NaN. </p>
     *
     * @return the imaginary ratio of this complex number.
     * @since 1.0.0
     */
    public double getImagRatio() {
        return Math.abs(imag) / getAbs();
    }
    //endregion

    //region Withers.
    /**
     * Create a copy of this complex number with the real part set to a specified value.
     *
     * @param real the new real part value.
     * @return the new complex number.
     * @since 1.0.0
     */
    public Complex withReal(double real) {
        return new Complex(real, imag);
    }

    /**
     * Create a copy of this complex number with the imaginary part set to a specified value.
     *
     * @param imag the new imaginary part value.
     * @return the new complex number.
     * @since 1.0.0
     */
    public Complex withImag(double imag) {
        return new Complex(real, imag);
    }

    /**
     * Create a copy of this complex number with the absolute value set to a specified value.
     *
     * @param abs the new absolute value.
     * @return the new complex number.
     * @throws IllegalArgumentException if the absolute value is less than 0.
     * @since 1.0.0
     */
    public Complex withAbs(double abs) {
        return valueOfPolar(abs, getAng());
    }

    /**
     * Create a copy of this complex number with the angle set to a specified value.
     *
     * @param ang the new angle value in radians.
     * @return the new complex number.
     * @since 1.0.0
     */
    public Complex withAng(double ang) {
        return valueOfPolar(getAbs(), ang);
    }
    //endregion

    //region Arithmetic operations.
    /**
     * Add other complex number to this complex number.
     *
     * <p> The addition of two complex numbers is calculated by adding the real parts together and the imaginary parts
     * together. </p>
     *
     * <p> Let z1 = x1 + iy1 and z2 = x2 + iy2. The sum of z1 and z2 is: <br>
     * z1 + z2 = (x1 + x2) + i(y1 + y2). </p>
     *
     * @param other the other complex number to add.
     * @return the result of adding other complex number to this complex number.
     * @since 1.0.0
     */
    public Complex plus(Complex other) {
        return new Complex(real + other.real, imag + other.imag);
    }

    /**
     * Add other real number to this complex number.
     *
     * <p> The addition of a complex number and a real number is calculated by adding the real part of the complex
     * number to the real number. </p>
     *
     * The sum of a complex number z and a real number r is: <br>
     * z + r = (x + r) + iy. </p>
     *
     * @param other the other real number to add.
     * @return the result of adding other real number to this complex number.
     * @since 1.0.0
     */
    public Complex plus(double other) {
        return new Complex(real + other, imag);
    }

    /**
     * Subtract other complex number from this complex number.
     *
     * <p> The subtraction of two complex numbers is calculated by subtracting the real parts and the imaginary parts
     * from each other. </p>
     *
     * <p> Let z1 = x1 + iy1 and z2 = x2 + iy2. The difference of z1 and z2 is: <br>
     * z1 - z2 = (x1 - x2) + i(y1 - y2). </p>
     *
     * @param other the other complex number to subtract.
     * @return the result of subtracting other complex number from this complex number.
     * @since 1.0.0
     */
    public Complex minus(Complex other) {
        return new Complex(real - other.real, imag - other.imag);
    }

    /**
     * Subtract other real number from this complex number.
     *
     * <p> The subtraction of a complex number and a real number is calculated by subtracting the real number from the
     * real part of the complex number. </p>
     *
     * <p> The difference of a complex number z and a real number r is: <br>
     * z - r = (x - r) + iy. </p>
     *
     * @param other the other real number to subtract.
     * @return the result of subtracting other real number from this complex number.
     * @since 1.0.0
     */
    public Complex minus(double other) {
        return new Complex(real - other, imag);
    }

    /**
     * Multiply this complex number by other complex number.
     *
     * <p> The multiplication of two complex numbers is calculated by multiplying the real parts together and
     * subtracting the product of the imaginary parts to create the real part of the result. The imaginary part of the
     * result is calculated by multiplying the real part of this complex number and the imaginary part of the other
     * complex number, then adding the product of the real part of the other complex number and the imaginary part of
     * this complex number. </p>
     *
     * <p> Let z1 = x1 + iy1 and z2 = x2 + iy2. The product of z1 and z2 is: <br>
     * z1 * z2 = (x1 * x2 - y1 * y2) + i(x1 * y2 + x2 * y1). </p>
     *
     * @param other the other complex number to multiply.
     * @return the result of multiplying this complex number by other complex number.
     * @since 1.0.0
     */
    public Complex times(Complex other) {
        return new Complex(
                real * other.real - imag * other.imag,
                real * other.imag + imag * other.real
        );
    }

    /**
     * Multiply this complex number by real number.
     *
     * <p> The multiplication of a complex number and a real number is calculated by multiplying the real and imaginary
     * parts by the real number. </p>
     *
     * <p> The product of a complex number z and a real number r is: <br>
     * z * r = (x * r) + i(y * r). </p>
     *
     * @param other the real number to multiply.
     * @return the result of multiplying this complex number by real number as a new instance of Complex.
     * @since 1.0.0
     */
    public Complex times(double other) {
        return new Complex(real * other, imag * other);
    }

    /**
     * Divide this complex number by other complex number.
     *
     * <p> The division of two complex numbers is calculated by multiplying the numerator and denominator by the
     * complex conjugate of the denominator and simplifying. First, the new denominator (d) is calculated by adding the
     * squares of the real part and the imaginary part. Then, real part of the result is calculated by dividing the sum
     * of the product of the real parts and the product of the imaginary parts by the new denominator. The imaginary
     * part of the result is calculated by dividing the difference of the product of the imaginary part of this complex
     * number and the real part of the other complex number and the product of the real part of this complex number and
     * the imaginary part of the other complex number by the new denominator. If the denominator is 0, both the real and
     * imaginary parts of the result will be NaN. </p>
     *
     * <p> Let z1 = x1 + iy1 and z2 = x2 + iy2. The quotient of z1 and z2 is: <br>
     * z1 / z2 = ((x1 * x2 + y1 * y2) / d) + i((y1 * x2 - x1 * y2) / d). </p>
     *
     * @param other the other complex number to divide by.
     * @return the result of dividing this complex number by other complex number as a new instance of Complex.
     * @since 1.0.0
     */
    public Complex div(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        return new Complex(
                (real * other.real + imag * other.imag) / denominator,
                (imag * other.real - real * other.imag) / denominator
        );
    }

    /**
     * Divide this complex number by real number.
     *
     * <p> The division of a complex number by a real number is calculated by dividing the real and imaginary parts by
     * the real number. If the real number is 0, both the real and imaginary parts of the result will the equivalent
     * of dividing by 0 with with a double type. </p>
     *
     * <p> The quotient of a complex number z and a real number r is: <br>
     * z / r = (x / r) + i(y / r). </p>
     *
     * @param other the real number to divide by.
     * @return the result of dividing this complex number by real number.
     * @since 1.0.0
     */
    public Complex div(double other) {
        return new Complex(real / other, imag / other);
    }
    //endregion

    //region Boolean operations.
    /**
     * Check if this complex number is 0. A complex number is zero if both the real and imaginary parts are 0.
     *
     * <p> This check is calculated by first checking if the reference of this complex number is equal to the reference
     * of the constant ZERO. If not, it will compare the real and imaginary parts of this complex number to 0 within the
     * default tolerance. </p>
     *
     * @return true if this complex number is 0, otherwise return false.
     */
    public boolean isZero() {
        return this.equals(ZERO);
    }

    /**
     * Check if this complex number's real and imaginary parts are equal to other complex number's.
     *
     * <p> This check is calculated by first checking if the reference of this complex number is equal to the reference
     * of the other complex number. If not, it will compare the real and imaginary parts of this complex number to the
     * other complex number within the default tolerance. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number is equal to other complex number, otherwise return false.
     */
    public boolean isEqualTo(Complex other) {
        return this.equals(other);
    }

    /**
     * Check if this complex number's real part is equal to other real number and imaginary part is 0.
     *
     * <p> This check is calculated by comparing the real part of this complex number to the other real number within the
     * default tolerance and the imaginary part within the default tolerance. </p>
     *
     * @param other the other real number to compare.
     * @return true if this complex number is equal to other real number, otherwise return false.
     * @since 1.0.0
     */
    public boolean isEqualTo(double other) {
        return Math.abs(real - other) < DEFAULT_TOLERANCE && Math.abs(imag) < DEFAULT_TOLERANCE;
    }

    /**
     * Check if this complex number's absolute value is equal to other complex number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other complex number within the default tolerance. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number's absolute value is equal to other complex number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isAbsEqualTo(Complex other) {
        return Math.abs(getAbs() - other.getAbs()) < DEFAULT_TOLERANCE;
    }

    /**
     * Check if this complex number's absolute value is equal to other real number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other real number within the default tolerance. </p>
     *
     * @param other the other real number to compare.
     * @return true if this complex number's absolute value is equal to other real number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isAbsEqualTo(double other) {
        return Math.abs(getAbs() - Math.abs(other)) < DEFAULT_TOLERANCE;
    }

    /**
     * Check if this complex number's absolute value is greater than other complex number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other complex number. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number's absolute value is greater than other complex number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isGreaterTo(Complex other) {
        return getAbs() > other.getAbs();
    }

    /**
     * Check if this complex number's absolute value is greater than other real number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other real number. </p>
     *
     * @param other the other real number to compare.
     * @return true if this complex number's absolute value is greater than other real number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isGreaterTo(double other) {
        return getAbs() > Math.abs(other);
    }

    /**
     * Check if this complex number's absolute value is greater than or equal to other complex number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other complex number within the default tolerance. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number's absolute value is greater than or equal to other complex number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isGreaterOrEqualTo(Complex other) {
        return getAbs() > other.getAbs() || isAbsEqualTo(other);
    }

    /**
     * Check if this complex number's absolute value is greater than or equal to other real number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other real number within the default tolerance. </p>
     *
     * @param other the other real number to compare.
     * @return true if this complex number's absolute value is greater than or equal to other real number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isGreaterOrEqualTo(double other) {
        return getAbs() > Math.abs(other) || isAbsEqualTo(other);
    }

    /**
     * Check if this complex number's absolute value is less than other complex number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other complex number. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number's absolute value is less than other complex number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isLesserTo(Complex other) {
        return getAbs() < other.getAbs();
    }

    /**
     * Check if this complex number's absolute value is less than other real number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other real number. </p>
     *
     * @param other the other real number to compare.
     * @return true if this complex number's absolute value is less than other real number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isLesserTo(double other) {
        return getAbs() < Math.abs(other);
    }

    /**
     * Check if this complex number's absolute value is less than or equal to other complex number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other complex number within the default tolerance. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number's absolute value is less than or equal to other complex number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isLesserOrEqualTo(Complex other) {
        return getAbs() < other.getAbs() || isAbsEqualTo(other);
    }

    /**
     * Check if this complex number's absolute value is less than or equal to other real number's.
     *
     * <p> This check is calculated by comparing the absolute value of this complex number to the absolute value of the
     * other real number within the default tolerance. </p>
     *
     * @param other the other complex number to compare.
     * @return true if this complex number's absolute value is less than or equal to other real number's, otherwise return false.
     * @since 1.0.0
     */
    public boolean isLesserOrEqualTo(double other) {
        return getAbs() < Math.abs(other) || isAbsEqualTo(other);
    }
    //endregion

    //region Override methods.
    /**
     * Get the string representation of this complex number. The string representation is in the form x + iy, where x is
     * the real part and y is the imaginary part. If the imaginary part is negative, the sign is - instead of +. If the
     * imaginary part is 0, the string representation will be x + i0.0. If the real part is 0, the string representation
     * will be 0.0 + iy.
     *
     * @return the string representation of this complex number.
     * @since 1.0.0
     */
    public String toString() {
        String x = Double.toString(real);
        String y = Double.toString(Math.abs(imag));

        String sign;
        if (imag >= 0.0) {
            sign = " + i";
        } else {
            sign = " - i";
        }

        return x + sign + y;
    }

    /**
     * Check if this complex number is equal to other object.
     *
     * <p> This check is calculated by first checking if the reference of this complex number is equal to the reference
     * of the other object. If not, the other object is checked to be an instance of Complex and the real and imaginary
     * parts are compared to be within the default tolerance. </p>
     *
     * @param object the other object to compare.
     * @return true if this complex number is equal to other object, otherwise return false.
     * @since 1.0.0
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object instanceof Complex other) {
            return Math.abs(real - other.real) < DEFAULT_TOLERANCE && Math.abs(imag - other.imag) < DEFAULT_TOLERANCE;
        }
        return false;
    }

    /**
     * Get the hash code of this complex number. The hash code is used to store and retrieve objects in hash-based
     * collections such as HashMap and HashSet.
     *
     * <p> The hash code is calculated by taking the XOR of the hash codes of the real and imaginary parts. </p>
     *
     * @return the hash code of this complex number.
     * @since 1.0.0
     */
    @Override
    public int hashCode() {
        return Double.hashCode(real) ^ Double.hashCode(imag);
    }
    //endregion
}
