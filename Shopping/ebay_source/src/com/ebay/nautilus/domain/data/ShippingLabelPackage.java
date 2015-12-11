// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.ArrayList;

public class ShippingLabelPackage
{
    public static class Manifest
    {

        public ArrayList orderInfo;

        public Manifest()
        {
            orderInfo = new ArrayList();
        }
    }

    public static final class PackageShapeType extends Enum
    {

        private static final PackageShapeType $VALUES[];
        public static final PackageShapeType IRREGULAR;
        public static final PackageShapeType REGULAR;

        public static PackageShapeType valueOf(String s)
        {
            return (PackageShapeType)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelPackage$PackageShapeType, s);
        }

        public static PackageShapeType[] values()
        {
            return (PackageShapeType[])$VALUES.clone();
        }

        static 
        {
            REGULAR = new PackageShapeType("REGULAR", 0);
            IRREGULAR = new PackageShapeType("IRREGULAR", 1);
            $VALUES = (new PackageShapeType[] {
                REGULAR, IRREGULAR
            });
        }

        private PackageShapeType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Specs
    {

        public Dimension dimensionMeasure;
        public PackageShapeType packageShape;
        public Weight weight;

        public Specs()
        {
        }
    }

    public static class Specs.Dimension
    {

        public double height;
        public double length;
        public String unit;
        public double width;

        public Specs.Dimension()
        {
        }
    }

    public static class Specs.Weight
    {

        public String unit;
        public double value;

        public Specs.Weight()
        {
        }
    }


    public ShippingOption.ShippingCostPlan.Cost declaredValue;
    public Manifest manifest;
    public Specs spec;

    public ShippingLabelPackage()
    {
    }
}
