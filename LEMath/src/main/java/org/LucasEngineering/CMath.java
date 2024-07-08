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
Description: Create the CMath class.
 */

/* Version History:
Version: 1.0.0
Version Date: 2024-07-07
Modifier: Alexander Lucas
Description: Create first version of this class.
 */

package org.LucasEngineering;

import static org.LucasEngineering.Complex.*;


/**
 * A class that provides static methods for performing complex number operations.
 *
 * <p> The methods in this class are meant to be an extension of the {@link Math} class for double types extended to complex numbers.
 * The methods in this class are static and should be called using the class name, e.g., {@code CMath.sin(z)}. </p>
 *
 * <p> The class also provides some useful constants, such as {@link #E}, {@link #PI}, and {@link #TAU} as a Complex type. </p>
 *
 * <p>Version Notes: created first version of this class.</p>
 *
 * @author Alexander Lucas
 * @version 1.0.0
 * @see Complex
 * @see Math
 */
@SuppressWarnings("unused")
public final class CMath {

    // Some useful constants.
    public static final Complex E = valueOfReal(Math.E);
    public static final Complex PHI = valueOfReal((1.0 + Math.sqrt(5.0)) / 2.0);
    public static final Complex PI = valueOfReal(Math.PI);
    public static final Complex TAU = valueOfReal(Math.TAU);

    /**
     * Calculate the absolute value (r) of a complex number. The absolute value is the distance from the origin on the complex plane.
     *
     * <p> The absolute value calculated by taking the square root of the sum of the squares of the real and imaginary parts. </p>
     * <p> r = sqrt(x^2 + y^2) </p>
     *
     * <p> The absolute value is also known as the magnitude or modulus. </p>
     *
     * @param z the complex number.
     * @return the absolute value of z complex number.
     * @since 1.0.0
     */
    public static double abs(Complex z) {
        return z.getAbs();
    }

    /**
     * Get the arc-cosine of a complex number.
     *
     * <p> acos(z) = -i * log(z + sqrt(z * z - 1)) </p>
     *
     * @param z the complex number.
     * @return the arc-cosine of z.
     * @since 1.0.0
     */
    public static Complex acos(Complex z) {
        return NEGATIVE_I.times(log(z.plus(sqrt(z.times(z).minus(1.0)))));
    }

    /**
     * Get the hyperbolic arc-cosine of a complex number.
     *
     * <p> acosh(z) = log(z + sqrt(z * z - 1)) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic arc-cosine of z.
     * @since 1.0.0
     */
    public static Complex acosh(Complex z) {
        return log(z.plus(sqrt(z.times(z).minus(1.0))));
    }

    /**
     * Get the arc-cotangent of a complex number.
     *
     * <p> acot(z) = i * log((z - i) / (z + i)) / 2 </p>
     *
     * @param z the complex number.
     * @return the arc-cotangent of z.
     * @since 1.0.0
     */
    public static Complex acot(Complex z) {
        return I.times(log(z.minus(I).div(z.plus(I)))).div(2.0);
    }

    /**
     * Get the hyperbolic arc-cotangent of a complex number.
     *
     * <p> acoth(z) = log((z + 1) / (z - 1)) / 2 </p>
     *
     * @param z the complex number.
     * @return the hyperbolic arc-cotangent of z.
     * @since 1.0.0
     */
    public static Complex acoth(Complex z) {
        return log(z.plus(1.0).div(z.minus(1.0))).div(2.0);
    }

    /**
     * Get the arc-cosecant of a complex number.
     *
     * <p> acsc(z) = asin(1 / z) </p>
     *
     * @param z the complex number.
     * @return the arc-cosecant of z.
     * @since 1.0.0
     */
    public static Complex acsc(Complex z) {
        return asin(ONE.div(z));
    }

    /**
     * Get the hyperbolic arc-cosecant of a complex number.
     *
     * <p> acsch(z) = log((1 + sqrt(1 + z * z)) / z) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic arc-cosecant of z.
     * @since 1.0.0
     */
    public static Complex acsch(Complex z) {
        return log(ONE.plus(sqrt(ONE.plus(z.times(z)))).div(z));
    }

    /**
     * Calculate the angle (θ) of a complex number in radians. The angle is the direction from the
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
     * @param z the complex number.
     * @return the angle of the z in radians.
     * @see AngleUnit
     * @since 1.0.0
     */
    public static double ang(Complex z) {
        return z.getAng();
    }

    /**
     * Get the arc-secant of a complex number.
     *
     * <p> asec(z) = acos(1 / z) </p>
     *
     * @param z the complex number.
     * @return the arc-secant of z.
     * @since 1.0.0
     */
    public static Complex asec(Complex z) {
        return acos(ONE.div(z));
    }

    /**
     * Get the hyperbolic arc-secant of a complex number.
     *
     * <p> asech(z) = log((1 + sqrt(1 - z * z)) / z) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic arc-secant of z.
     * @since 1.0.0
     */
    public static Complex asech(Complex z) {
        return log(ONE.plus(sqrt(ONE.minus(z.times(z)))).div(z));
    }

    /**
     * Get the arc-sine of a complex number.
     *
     * <p> asin(z) = -i * log(iz + sqrt(1 - z * z)) </p>
     *
     * @param z the complex number.
     * @return the arc-sine of z.
     * @since 1.0.0
     */
    public static Complex asin(Complex z) {
        return NEGATIVE_I.times(log(I.times(z).plus(sqrt(ONE.minus(z.times(z))))));
    }

    /**
     * Get the hyperbolic arc-sine of a complex number.
     *
     * <p> asinh(z) = log(z + sqrt(z * z + 1)) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic arc-sine of z.
     * @since 1.0.0
     */
    public static Complex asinh(Complex z) {
        return log(z.plus(sqrt(z.times(z).plus(1.0))));
    }

    /**
     * Get the arc-tangent of a complex number.
     *
     * <p> atan(z) = i * log((i + z) / (i - z)) / 2 </p>
     *
     * @param z the complex number.
     * @return the arc-tangent of z.
     * @since 1.0.0
     */
    public static Complex atan(Complex z) {
        return I.times(log(I.plus(z).div(I.minus(z)))).div(2.0);
    }

    /**
     * Get the hyperbolic arc-tangent of a complex number.
     *
     * <p> atanh(z) = log((1 + z) / (1 - z)) / 2 </p>
     *
     * @param z the complex number.
     * @return the hyperbolic arc-tangent of z.
     * @since 1.0.0
     */
    public static Complex atanh(Complex z) {
        return (log(ONE.plus(z).div(ONE.minus(z))).div(2.0));
    }

    /**
     * Get the cube root of a complex number.
     *
     * <p> cbrt(z) = cbrt(r) ∠ (θ / 3) </p>
     *
     * @param z the complex number.
     * @return the cube root of z.
     * @since 1.0.0
     */
    public static Complex cbrt(Complex z) {
        return valueOfPolar(Math.cbrt(z.getAbs()), z.getAng() / 3.0);
    }

    /**
     * Calculate the complex conjugate (z*) of a complex number. The complex conjugate is the reflection of the
     * complex number across the real axis.
     *
     * <p> The complex conjugate is calculated by multiplying the imaginary part by -1. </p>
     *
     * <p> z* = x - iy </p>
     *
     * @param z the complex number.
     * @return the conjugate of z.
     * @since 1.0.0
     */
    public static Complex conj(Complex z) {
        return z.getConj();
    }

    /**
     * Get the cosine of a complex number.
     *
     * <p> cos(z) = (exp(iz) + exp(-iz)) / 2 </p>
     *
     * @param z the complex number.
     * @return the cosine of z.
     * @since 1.0.0
     */
    public static Complex cos(Complex z) {
        Complex iz = I.times(z);
        return exp(iz).plus(exp(iz.getNeg())).div(2.0);
    }

    /**
     * Get the hyperbolic cosine of a complex number.
     *
     * <p> cosh(z) = (exp(z) + exp(-z)) / 2 </p>
     *
     * @param z the complex number.
     * @return the hyperbolic cosine of z.
     * @since 1.0.0
     */
    public static Complex cosh(Complex z) {
        return exp(z).plus(exp(z.getNeg())).div(2.0);
    }

    /**
     * Get the cotangent of a complex number. The cotangent is the reciprocal of the tangent.
     *
     * <p> cot(z) = cos(z) / sin(z) </p>
     *
     * @param z the complex number.
     * @return the cotangent of z.
     * @since 1.0.0
     */
    public static Complex cot(Complex z) {
        return cos(z).div(sin(z));
    }

    /**
     * Get the hyperbolic cotangent of a complex number. The hyperbolic cotangent is the reciprocal of the hyperbolic tangent.
     *
     * <p> coth(z) = cosh(z) / sinh(z) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic cotangent of z.
     * @since 1.0.0
     */
    public static Complex coth(Complex z) {
        return cosh(z).div(sinh(z));
    }

    /**
     * Get the cosecant of a complex number. The cosecant is the reciprocal of the sine.
     *
     * <p> csc(z) = 1 / sin(z) </p>
     *
     * @param z the complex number.
     * @return the cosecant of z.
     * @since 1.0.0
     */
    public static Complex csc(Complex z) {
        return ONE.div(sin(z));
    }

    /**
     * Get the hyperbolic cosecant of a complex number. The hyperbolic cosecant is the reciprocal of the hyperbolic sine.
     *
     * <p> csch(z) = 1 / sinh(z) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic cosecant of z.
     * @since 1.0.0
     */
    public static Complex csch(Complex z) {
        return ONE.div(sinh(z));
    }

    /**
     * Get the exponential of a complex number.
     *
     * <p> exp(z) = exp(x) ∠ y </p>
     *
     * @param z the complex number.
     * @return the exponential of z.
     * @since 1.0.0
     */
    public static Complex exp(Complex z) {
        return valueOfPolar(Math.exp(z.getReal()), z.getImag());
    }

    /**
     * Get the imaginary part (y) of this complex number. The imaginary part is the y-coordinate on the complex plane.
     *
     * @param z the complex number.
     * @return the imaginary part of z.
     * @since 1.0.0
     */
    public static double imag(Complex z) {
        return z.getImag();
    }

    /**
     * Get the natural logarithm of a complex number.
     *
     * <p> log(z) = ln(r) + iθ </p>
     *
     * @param z the complex number.
     * @return the natural logarithm of z.
     * @since 1.0.0
     */
    public static Complex log(Complex z) {
        return valueOf(Math.log(z.getAbs()), z.getAng());
    }

    /**
     * Get the log of a complex number with a specified real base.
     *
     * <p> log(z, base) = log(z) / ln(base) </p>
     *
     * @param z the complex number.
     * @param base the real base.
     * @return the log of z with the specified base.
     * @since 1.0.0
     */
    public static Complex log(Complex z, double base) {
        return log(z).div(Math.log(base));
    }

    /**
     * Get the log of a complex number with a specified complex base.
     *
     * <p> log(z, base) = log(z) / log(base) </p>
     *
     * @param z the complex number.
     * @param base the complex base.
     * @return the log of z with the specified base.
     * @since 1.0.0
     */
    public static Complex log(Complex z, Complex base) {
        return log(z).div(log(base));
    }

    /**
     * Get the maximum of two complex numbers by comparing their absolute values. If the absolute values are equal,
     * the result will be the first argument.
     *
     * @param z1 the first complex number.
     * @param z2 the second complex number.
     * @return the maximum of z1 and z2.
     * @since 1.0.0
     */
    public static Complex max(Complex z1, Complex z2) {
        return z1.isGreaterOrEqualTo(z2) ? z1 : z2;
    }

    /**
     * Get the minimum of two complex numbers by comparing their absolute values. If the absolute values are equal,
     * the result will be the first argument.
     *
     * @param z1 the first complex number.
     * @param z2 the second complex number.
     * @return the minimum of z1 and z2.
     * @since 1.0.0
     */
    public static Complex min(Complex z1, Complex z2) {
        return z1.isLesserOrEqualTo(z2) ? z1 : z2;
    }

    /**
     * Calculate the negative of a complex number (-z). The negative is the reflection of the complex number across the
     * origin on the complex plane and is meant to represent the unary minus operation.
     *
     * <p> The negative calculated by multiplying the real and imaginary parts by -1. </p>
     *
     * <p> -z = -x - iy </p>
     *
     * <p> The negative is also known as the additive inverse or negation. </p>
     *
     * @param z the complex number.
     * @return the negative of z.
     * @since 1.0.0
     */
    public static Complex neg(Complex z) {
        return z.getNeg();
    }

    /**
     * Calculate the negative complex conjugate (-z*) of a complex number. The negative complex conjugate is the
     * reflection of the complex number across the imaginary axis.
     *
     * <p> The negative complex conjugate is calculated by multiplying the real part by -1. </p>
     *
     * <p> -z* = -x + iy </p>
     *
     * @param z the complex number.
     * @return the negative conjugate of z.
     * @since 1.0.0
     */
    public static Complex negConj(Complex z) {
        return z.getNegConj();
    }

    /**
     * Calculate the negative reciprocal (-1/z) of a complex number. The negative reciprocal is the complex number
     * that when multiplied by this complex number equals -1.
     *
     * <p> The negative reciprocal is calculated by dividing -1 by the complex number. If the complex number is 0, the
     * result will be NaN. </p>
     *
     * <p> -1/z = -1 / (x + iy) = -x / (x^2 + y^2) + iy / (x^2 + y^2) </p>
     *
     * @param z the complex number.
     * @return the negative reciprocal of z.
     * @since 1.0.0
     */
    public static Complex negReciprocal(Complex z) {
        return z.getNegReciprocal();
    }

    /**
     * Get the power of a complex number raised to a complex exponent.
     *
     * <p> Let r = abs(z), θ = ang(z), x = real(c), y = imag(c): <br>
     * pow(z, c) = pow(r,x) * exp(-θy) ∠ ln(r)y + θx </p>
     *
     * <p> If r is 0, then the result is 0. Otherwise, the above function applies.</p>
     *
     * @param z the complex number.
     * @param c the complex exponent.
     * @return the power of z raised to the complex exponent.
     * @since 1.0.0
     */
    public static Complex pow(Complex z, Complex c) {
        double r = z.getAbs();
        if (r == 0.0) {
            return ZERO;
        }
        double t = z.getAng();
        return valueOfPolar(
                Math.pow(r, c.getReal()) * Math.exp(-t * c.getImag()),
                Math.log(r) * c.getImag() + t * c.getReal()
        );
    }

    /**
     * Get the power of a complex number raised to a real exponent.
     *
     * <p> pow(z, c) = pow(r, c) ∠ (θ * c) </p>
     *
     * @param z the complex number.
     * @param exp the real exponent.
     * @return the power of z raised to the real exponent.
     * @since 1.0.0
     */
    public static Complex pow(Complex z, double exp) {
        return valueOfPolar(Math.pow(z.getAbs(), exp), z.getAng() * exp);
    }

    /**
     * Get the power of a real number raised to a complex exponent.
     *
     * <p> This is calculated by converting the real number to a complex number and calls the pow method for complex
     * exponentiation. </p>
     *
     * <p> If a is 0, then the result is 0. Otherwise, the above function applies.</p>
     *
     * @param a the real number.
     * @param exp the complex exponent.
     * @return the power of a raised to the complex exponent.
     * @since 1.0.0
     */
    public static Complex pow(double a, Complex exp) {
        return pow(valueOfReal(a), exp);
    }

    /**
     * Get the real part (x) of this complex number. The real part is the x-coordinate on the complex plane.
     *
     * @param z the complex number.
     * @return the real part of z.
     * @since 1.0.0
     */
    public static double real(Complex z) {
        return z.getReal();
    }

    /**
     * Calculate the reciprocal (1/z) of a complex number. The reciprocal is the complex number that when multiplied
     * by this complex number equals 1.
     *
     * <p> The reciprocal is calculated by dividing 1 by the complex number. If the complex number is 0, the result
     * will be NaN. </p>
     *
     * <p> 1/z = 1 / (x + iy) = x / (x^2 + y^2) - iy / (x^2 + y^2) </p>
     *
     * @param z the complex number.
     * @return the reciprocal of z.
     * @since 1.0.0
     */
    public static Complex reciprocal(Complex z) {
        return z.getReciprocal();
    }

    /**
     * Create a new instance of Complex with random real and imaginary parts between 0 and 1.
     *
     * @return the new complex number.
     * @since 1.0.0
     */
    public static Complex random() {
        return valueOfRandom();
    }

    /**
     * Rotate a complex number by a specified angle in radians about the origin. A positive angle rotates the complex
     * number counter-clockwise, and a negative angle rotates the complex number clockwise. Use the {@link AngleUnit}
     * enum to convert the angle to radians if needed.
     *
     * <p> The rotation is calculated by adding the change in angle to the current angle of the complex number. </p>
     *
     * <p> z' = r ∠ (θ + dAng) </p>
     *
     * <p> The rotation is also known as the phase shift. </p>
     *
     * @param z the complex number
     * @param dAng the change in the angle in radians
     * @return the rotated complex number
     * @see AngleUnit
     * @since 1.0.0
     */
    public static Complex rotate(Complex z, double dAng) {
        return valueOfPolar(z.getAbs(), z.getAng() + dAng);
    }

    /**
     * Rotate a complex number by a specified angle in radians about a specified point. A positive angle rotates the complex
     * number counter-clockwise, and a negative angle rotates the complex number clockwise. Use the {@link AngleUnit}
     * enum to convert the angle to radians if needed.
     *
     * <p> The rotation is calculated by subtracting the point from the complex number, rotating the complex number, and
     * then adding the point back to the result. </p>
     *
     * <p> z' = rotate(z - point, dAng) + point </p>
     *
     * <p> The rotation is also known as the phase shift. </p>
     *
     * @param z the complex number
     * @param dAng the change in the angle in radians
     * @param point the point to rotate about
     * @return the rotated complex number
     * @see AngleUnit
     * @since 1.0.0
     */
    public static Complex rotate(Complex z, double dAng, Complex point) {
        return rotate(z.minus(point), dAng).plus(point);
    }

    /**
     * Rotate a complex number by a specified angle in radians about a specified point. A positive angle rotates the complex
     * number counter-clockwise, and a negative angle rotates the complex number clockwise. Use the {@link AngleUnit}
     * enum to convert the angle to radians if needed.
     *
     * <p> The rotation is calculated by subtracting the point from the complex number, rotating the complex number, and
     * then adding the point back to the result. </p>
     *
     * <p> z' = rotate(z - (xPoint + iyPoint), dAng) + (xPoint + iyPoint) </p>
     *
     * <p> The rotation is also known as the phase shift. </p>
     *
     * @param z the complex number
     * @param dAng the change in the angle in radians
     * @param xPoint the x-coordinate of the point to rotate about
     * @param yPoint the y-coordinate of the point to rotate about
     * @return the rotated complex number
     * @see AngleUnit
     * @since 1.0.0
     */
    public static Complex rotate(Complex z, double dAng, double xPoint, double yPoint) {
        return rotate(z, dAng, valueOf(xPoint, yPoint));
    }

    /**
     * Round the real and imaginary parts of a complex number to the nearest integer.
     *
     * @param z the complex number.
     * @return the complex number with rounded parts.
     * @since 1.0.0
     */
    public static Complex round(Complex z) {
        return valueOf(Math.round(z.getReal()), Math.round(z.getImag()));
    }

    /**
     * Round the real and imaginary parts of a complex number to a specified number of digits.
     *
     * @param z the complex number.
     * @param digits the number of digits to round to.
     * @return the complex number with rounded parts.
     * @throws IllegalArgumentException if the number of digits is less than zero.
     * @since 1.0.0
     */
    public static Complex round(Complex z, int digits) {
        if (digits < 0) {
            throw new IllegalArgumentException("Number of digits must be greater than or equal to zero.");
        }
        double factor = Math.pow(10, digits);
        return valueOf(
                Math.round(z.getReal() * factor) / factor,
                Math.round(z.getImag() * factor) / factor
        );
    }

    /**
     * Scale a complex number by a specified factor about the origin.
     *
     * <p> The scaling is calculated by multiplying the real and imaginary parts by the factor. </p>
     *
     * <p> z' = z * factor </p>
     *
     * @param z the complex number.
     * @param factor the scaling factor.
     * @return the scaled complex number.
     * @since 1.0.0
     */
    public static Complex scale(Complex z, double factor) {
        return z.times(factor);
    }

    /**
     * Scale a complex number by a specified factor about a specified point.
     *
     * <p> The scaling is calculated by subtracting the point from the complex number, scaling the complex number, and
     * then adding the point back to the result. </p>
     *
     * <p> z' = (z - point) * factor + point </p>
     *
     * @param z the complex number.
     * @param factor the scaling factor.
     * @param point the point to scale about.
     * @return the scaled complex number.
     * @since 1.0.0
     */
    public static Complex scale(Complex z, double factor, Complex point) {
        return z.minus(point).times(factor).plus(point);
    }

    /**
     * Scale a complex number by a specified factor about a specified point.
     *
     * <p> The scaling is calculated by subtracting the point from the complex number, scaling the complex number, and
     * then adding the point back to the result. </p>
     *
     * <p> z' = (z - (xPoint + iyPoint)) * factor + (xPoint + iyPoint) </p>
     *
     * @param z the complex number.
     * @param factor the scaling factor.
     * @param xPoint the x-coordinate of the point to scale about.
     * @param yPoint the y-coordinate of the point to scale about.
     * @return the scaled complex number.
     * @since 1.0.0
     */
    public static Complex scale(Complex z, double factor, double xPoint, double yPoint) {
        return scale(z, factor, valueOf(xPoint, yPoint));
    }

    /**
     * Get the secant of a complex number. The secant is the reciprocal of the cosine.
     *
     * <p> sec(z) = 1 / cos(z) </p>
     *
     * @param z the complex number.
     * @return the secant of z.
     * @since 1.0.0
     */
    public static Complex sec(Complex z) {
        return ONE.div(cos(z));
    }

    /**
     * Get the hyperbolic secant of a complex number. The hyperbolic secant is the reciprocal of the hyperbolic cosine.
     *
     * <p> sech(z) = 1 / cosh(z) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic secant of z.
     * @since 1.0.0
     */
    public static Complex sech(Complex z) {
        return ONE.div(cosh(z));
    }

    /**
     * Get the sine of a complex number.
     *
     * <p> sin(z) = (exp(iz) - exp(-iz)) / i2 </p>
     *
     * @param z the complex number.
     * @return the sine of z.
     * @since 1.0.0
     */
    public static Complex sin(Complex z) {
        Complex iz = I.times(z);
        return exp(iz).minus(exp(iz.getNeg())).div(valueOfImag(2.0));
    }

    /**
     * Get the hyperbolic sine of a complex number.
     *
     * <p> sinh(z) = (exp(z) - exp(-z)) / 2 </p>
     *
     * @param z the complex number.
     * @return the hyperbolic sine of z.
     * @since 1.0.0
     */
    public static Complex sinh(Complex z){
        return exp(z).minus(exp(z.getNeg())).div(2.0);
    }

    /**
     * Get the square root of a complex number.
     *
     * <p> sqrt(z) = sqrt(r) ∠ θ / 2 </p>
     *
     * @param z the complex number.
     * @return the square root of z.
     * @since 1.0.0
     */
    public static Complex sqrt(Complex z) {
        return valueOfPolar(Math.sqrt(z.getAbs()), z.getAng() / 2.0);
    }

    /**
     * Get the tangent of a complex number.
     *
     * <p> tan(z) = sin(z) / cos(z) </p>
     *
     * @param z the complex number.
     * @return the tangent of z.
     * @since 1.0.0
     */
    public static Complex tan(Complex z) {
        return sin(z).div(cos(z));
    }

    /**
     * Get the hyperbolic tangent of a complex number.
     *
     * <p> tanh(z) = sinh(z) / cosh(z) </p>
     *
     * @param z the complex number.
     * @return the hyperbolic tangent of z.
     * @since 1.0.0
     */
    public static Complex tanh(Complex z) {
        return sinh(z).div(cosh(z));
    }

    /**
     * Translate a complex number by a specified point.
     *
     * <p> The translation is calculated by adding the point to the complex number. </p>
     *
     * <p> z' = z + point </p>
     *
     * @param z the complex number.
     * @param point the point to translate by.
     * @return the translated complex number.
     * @since 1.0.0
     */
    public static Complex translate(Complex z, Complex point) {
        return z.plus(point);
    }

    /**
     * Translate a complex number by a specified point.
     *
     * <p> The translation is calculated by adding the point to the complex number. </p>
     *
     * <p> z' = z + (xPoint + iyPoint) </p>
     *
     * @param z the complex number.
     * @param xPoint the x-coordinate of the point to translate by.
     * @param yPoint the y-coordinate of the point to translate by.
     * @return the translated complex number.
     * @since 1.0.0
     */
    public static Complex translate(Complex z, double xPoint, double yPoint) {
        return z.plus(valueOf(xPoint, yPoint));
    }
}
