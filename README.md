# LEMath

This is the first release of LEMath, a Java library for creating and performing mathematical and Boolean operations with complex numbers.

This library includes a class called "Complex" that provides factory constructors for creating complex numbers with various arguments such as with real and imaginary parts, real part only, imaginary part only, with polar coordinates, and random real and imaginary values. The instances are immutable, with the intent to mimic value types, and provide various methods for accessing fields and calculating properties of the complex number such as the real, imaginary, absolute value, angle, conjugate, negative, reciprocal, and more. The class includes methods for arithmetic operations such as adding, subtracting, multiplying, and dividing with complex and real (double) numbers. Lastly, the class includes methods for Boolean comparisons such as equal to, greater than, less than, and more.

LEMath also comes with a class called "CMath" that complements the Complex class by providing static methods for more advanced arithmetic operations such as trigonometry, exponentiation, logarithm, rounding, and more. It is meant to extend the standard Java Math class for doubles to the complex numbers.

Lastly, LEMath also includes an enumerate for converting between angle units called "AngleUnit". The Complex and CMath classes calculate and return angle values exclusively in radians, so the user may have a need for working in other others. The available units are radians, degrees, gradians, and turns.

Please note that this is the first release of the library, so there may be some patches needed. But I hope you will all find it useful and provide meaningful feedback for improvements and additions
