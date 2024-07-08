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
Description: Create the AngleUnit enumeration.
 */

/* Version History:
Version: 1.0.0
Version Date: 2024-07-07
Modifier: Alexander Lucas
Description: Create first version of this enumeration.
 */

package org.LucasEngineering;

/**
 * An enumeration of angle units that can be used to convert angles between different units and normalize them.
 *
 * <p> Available units:
 * <ul>
 *     <li>Radians</li>
 *     <li>Degrees</li>
 *     <li>Gradians</li>
 *     <li>Turns</li>
 *</ul> </p>
 *
 * @author Alexander Lucas
 * @version 1.0.0
 * @since 1.0.0
 */
public enum AngleUnit {
    RADIANS, DEGREES, GRADIANS, TURNS;

    private static final double PI = Math.PI;
    private static final double TAU = Math.TAU;

    //region Static methods.
    /**
     * Normalizes an angle (θ) in radians such that the result would range -π < θ ≤ π.
     *
     * @param angle The angle to normalize.
     * @return The normalized angle.
     * @since 1.0.0
     */
    public static double normalizeAngle(double angle) {
        angle %= TAU;
        if (angle > PI) {
            angle -= TAU;
        } else if (angle <= -PI) {
            angle += TAU;
        }
        return angle;
    }

    /**
     * Normalizes an angle (θ) in a specified unit such that the result would range -π < θ ≤ π in radians.
     *
     * @param angle The angle to normalize.
     * @param unit The unit of the angle.
     * @return The normalized angle.
     * @since 1.0.0
     */
    public static double normalizeAngle(double angle, AngleUnit unit) {
        // First, convert the angle to radians.
        angle = unit.convertToRadians(angle);

        // Then, normalize the angle to the range (-PI, PI].
        angle = normalizeAngle(angle);

        // Finally, convert the angle back to the original unit and return it.
        angle = unit.convertFromRadians(angle);
        return angle;
    }
    //endregion

    //region Instance methods.
    /**
     * Converts an angle from radians to this unit.
     *
     * @param radians The angle in radians to convert.
     * @return The angle in this unit.
     * @since 1.0.0
     */
    public double convertFromRadians(double radians) {
        return switch (this) {
            case RADIANS -> radians;
            case DEGREES -> radians * 360 / TAU;
            case GRADIANS -> radians * 400 / TAU;
            case TURNS -> radians / TAU;
        };
    }

    /**
     * Converts an angle from another unit to this unit.
     *
     * <p> This is calculated by first converting the angle to radians and then converting it to this unit. </p>
     *
     * @param value The angle in the other unit to convert.
     * @param unit The unit of the angle.
     * @return The angle in this unit.
     * @since 1.0.0
     */
    public double convertFromOtherUnit(double value, AngleUnit unit) {
        return convertFromRadians(unit.convertToRadians(value));
    }

    /**
     * Converts an angle to radians from this unit.
     *
     * @param value The angle in this unit to convert.
     * @return The angle in radians.
     * @since 1.0.0
     */
    public double convertToRadians(double value) {
        return switch (this) {
            case RADIANS -> value;
            case DEGREES -> value * TAU / 360;
            case GRADIANS -> value * TAU / 400;
            case TURNS -> value * TAU;
        };
    }

    /**
     * Converts this angle to another unit.
     *
     * <p> This is calculated by first converting the angle to radians and then converting it to the other unit. </p>
     *
     * @param value This angle to convert.
     * @param unit The new unit of the angle.
     * @return The angle in the new unit.
     * @since 1.0.0
     */
    public double convertToOtherUnit(double value, AngleUnit unit) {
        return unit.convertFromRadians(convertToRadians(value));
    }
    //endregion
}
