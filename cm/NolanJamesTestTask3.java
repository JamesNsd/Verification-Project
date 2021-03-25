/*
James Nolan - C00226267
24/03/2021
 */

package cm;

import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.math.RoundingMode;

public class NolanJamesTestTask3 {

    // Test case 1
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void negativeNormalRate() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(3), reducedPeriod, normalPeriod);
    }

    // Test Case 2
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void negativeReducedRate() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(-1), reducedPeriod, normalPeriod);
    }

    // Test Case 3
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedGreaterThanNormal() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(6), reducedPeriod, normalPeriod);
    }

    // Test Case 4
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void ratesAreEqual() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), reducedPeriod, normalPeriod);
    }

    // Test Case 5
    @org.junit.Test
    public void normalRateIsLetter() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal('f'), new BigDecimal(3), reducedPeriod, normalPeriod);
    }

    // Test Case 6
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateIsLetter() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal('g'), reducedPeriod, normalPeriod);
    }

    // Test Case 7
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateIsNull() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, null, new BigDecimal(3), reducedPeriod, normalPeriod);
    }

    // Test Case 8
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateIsNull() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), null, reducedPeriod, normalPeriod);
    }

    // Test Case 9
    @org.junit.Test
    public void carParkKindIsNull() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(null, new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod);
    }

    // Test Case 10
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void carParkKindDoesNotExist() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.valueOf("UnKnown"), new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod);
    }

    // Test Case 11
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedOverlapsNormalPeriod() {

        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        ArrayList<Period> newReducedPeriod = new ArrayList<Period>();

        newReducedPeriod.add(new Period(9, 13));
        newReducedPeriod.add(new Period(19, 22));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), newReducedPeriod, normalPeriod);
    }

    // Test Case 12
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalOverlapsReducedPeriod() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));

        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newNormalPeriod.add(new Period(12, 20));
        newNormalPeriod.add(new Period(0, 8));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, newNormalPeriod);
    }

    // Test Case 13
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsOverlap() {

        ArrayList<Period> newReducedPeriod = new ArrayList<Period>();
        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newReducedPeriod.add(new Period(16, 19));
        newReducedPeriod.add(new Period(18, 22));
        newNormalPeriod.add(new Period(12, 15));
        newNormalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), newReducedPeriod, newNormalPeriod);
    }

    // Test Case 14
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsOverlap() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));

        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newNormalPeriod.add(new Period(12, 16));
        newNormalPeriod.add(new Period(15, 18));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, newNormalPeriod);
    }

    // Test Case 15
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void negativeReducedPeriod() {

        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        ArrayList<Period> newReducedPeriod = new ArrayList<Period>();

        newReducedPeriod.add(new Period(-1, 11));
        newReducedPeriod.add(new Period(17, 22));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), newReducedPeriod, normalPeriod);
    }

    // Test Case 16
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void negativeNormalPeriod() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));

        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newNormalPeriod.add(new Period(-1, 18));
        newNormalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, newNormalPeriod);
    }

    // Test Case 17
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodEqualTo24() {

        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        ArrayList<Period> newReducedPeriod = new ArrayList<Period>();

        newReducedPeriod.add(new Period(9, 11));
        newReducedPeriod.add(new Period(19, 24));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), newReducedPeriod, normalPeriod);
    }

    // Test Case 18
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodEqualTo24() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));

        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newNormalPeriod.add(new Period(12, 18));
        newNormalPeriod.add(new Period(24, 8));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, newNormalPeriod);
    }

    // Test Case 19
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodGreaterThan24() {

        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        ArrayList<Period> newReducedPeriod = new ArrayList<Period>();

        newReducedPeriod.add(new Period(9, 11));
        newReducedPeriod.add(new Period(19, 25));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), newReducedPeriod, normalPeriod);
    }

    // Test Case 20
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodGreaterThan24() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));

        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newNormalPeriod.add(new Period(12, 18));
        newNormalPeriod.add(new Period(25, 8));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, newNormalPeriod);
    }

    // Test Case 21
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodIsLetter() {

        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        ArrayList<Period> newReducedPeriod = new ArrayList<Period>();

        newReducedPeriod.add(new Period(9, 11));
        newReducedPeriod.add(new Period('s', 22));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), newReducedPeriod, normalPeriod);
    }

    // Test Case 22
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodIsLetter() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));

        ArrayList<Period> newNormalPeriod = new ArrayList<Period>();

        newNormalPeriod.add(new Period('t', 18));
        newNormalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, newNormalPeriod);
    }

    // Calculation tests begin here

    // Test Case 23
    @org.junit.Test
    public void calcTest() {

        ArrayList<Period> calcReducedPeriods = new ArrayList<Period>();
        ArrayList<Period> calcNormalPeriods = new ArrayList<Period>();

        calcReducedPeriods.add(new Period(7, 9));
        calcReducedPeriods.add(new Period(17, 22));
        calcNormalPeriods.add(new Period(10, 16));
        calcNormalPeriods.add(new Period(0, 6));

        Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), calcReducedPeriods, calcNormalPeriods);

        assertEquals(new BigDecimal(6.00), rate.calculate(new Period(7, 9)));
    }

    // Test Case 24
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void negativePeriod() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod).calculate(new Period(-1, 18));
    }

    // Test Case 25
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void periodGreaterThan24() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod).calculate(new Period(7, 25));
    }

    // Test Case 26
    @org.junit.Test
    public void periodEqualTo24() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod).calculate(new Period(7, 24));
    }

    //White Box Tests
    // Test Case 27
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void nullReducedPeriod() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), null, normalPeriod);
    }

    // Test Case 28
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void nullNormalPeriod() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), reducedPeriod, null);
    }

    // Test Case 29
    @org.junit.Test
    public void lessThan2PeriodsEach() {
        ArrayList<Period> singleReducedList = new ArrayList<Period>();
        ArrayList<Period> singleNormalList = new ArrayList<Period>();

        singleReducedList.add(new Period(11, 12));
        singleNormalList.add(new Period(13, 14));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), singleReducedList, singleNormalList);
    }

    // Test Case 30
    @org.junit.Test
    public void multiplePeriods() {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(4, 7));
        reducedPeriods.add(new Period(8, 10));
        normalPeriods.add(new Period(11, 12));
        normalPeriods.add(new Period(13, 19));
        normalPeriods.add(new Period(20, 23));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriods, normalPeriods);
    }

    // Test Case 31
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void overlappingMultiplePeriods() {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods= new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(2, 7));
        reducedPeriods.add(new Period(5, 10));
        normalPeriods.add(new Period(8, 12));
        normalPeriods.add(new Period(11, 14));
        normalPeriods.add(new Period(15, 18));

        new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriods, normalPeriods);
    }

    //Spec Change

    //Result without discount being applied
    @org.junit.Test(expected = AssertionError.class)
    public void visitorNoDiscountApplied() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod);

        assertEquals(new BigDecimal(6.00), rate.calculate(new Period(7, 9)));

    }

    // Visitor rate under 8
    @org.junit.Test
    public void visitorUnder8() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(5), new BigDecimal(3), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP), rate.calculate(new Period(9, 11)));
    }

    // Visitor rate over 8
    @org.junit.Test
    public void visitorOver8() {

        ArrayList<Period> reducedPeriod = new ArrayList<Period>();
        ArrayList<Period> normalPeriod = new ArrayList<Period>();

        reducedPeriod.add(new Period(7, 9));
        reducedPeriod.add(new Period(17, 22));
        normalPeriod.add(new Period(10, 16));
        normalPeriod.add(new Period(0, 6));

        Rate rate = new Rate(CarParkKind.VISITOR, new BigDecimal(6), new BigDecimal(5), reducedPeriod, normalPeriod);
        assertEquals(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP), rate.calculate(new Period(7, 9)));
    }


}