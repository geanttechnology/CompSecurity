// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            RecommendedShippingService, ShippingZonalCost

public class ShippingRecommendation
    implements Serializable
{

    private static final int GRAMS_IN_KG = 1000;
    private static final int OZ_IN_LB = 16;
    public final ArrayList costs = new ArrayList();
    public String dimensionUnitType;
    public double height;
    public double length;
    public String packageType;
    public boolean requireWeighDimensionValidation;
    public final RecommendedShippingService shippingService = new RecommendedShippingService();
    private boolean sorted;
    public double weight;
    public String weightUnitType;
    public double width;

    public ShippingRecommendation()
    {
        sorted = false;
    }

    private int getMajorWeightInteger()
    {
        if (weightUnitType.equals("oz"))
        {
            return (int)Math.floor(weight / 16D);
        } else
        {
            return (int)Math.floor(weight / 1000D);
        }
    }

    private int getMinorWeightInteger()
    {
        if (weightUnitType.equals("oz"))
        {
            return (int)(weight - 16D * Math.floor(getMajorWeightInteger()));
        } else
        {
            return (int)(weight - Math.floor(weight / 1000D) * 1000D);
        }
    }

    protected String getMajorWeightUnit()
    {
        if (Integer.parseInt(getWeightMajor()) > 1)
        {
            if (weightUnitType.equals("oz"))
            {
                return "lbs";
            } else
            {
                return "kgs";
            }
        }
        if (weightUnitType.equals("oz"))
        {
            return "lb";
        } else
        {
            return "kg";
        }
    }

    protected ShippingZonalCost getMaximumShippingCost()
    {
        if (!sorted)
        {
            Collections.sort(costs);
            sorted = true;
        }
        if (costs.size() > 0)
        {
            return (ShippingZonalCost)costs.get(costs.size() - 1);
        } else
        {
            return new ShippingZonalCost();
        }
    }

    protected ShippingZonalCost getMinimumShippingCost()
    {
        if (!sorted)
        {
            Collections.sort(costs);
            sorted = true;
        }
        if (costs.size() > 0)
        {
            return (ShippingZonalCost)costs.get(0);
        } else
        {
            return new ShippingZonalCost();
        }
    }

    public String getWeightMajor()
    {
        return Integer.toString((int)Math.floor(getMajorWeightInteger()));
    }

    public String getWeightMinor()
    {
        return Integer.toString(getMinorWeightInteger());
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Weight: ").append(weight).append("\n");
        stringbuilder.append("unitType: ").append(weightUnitType).append("\n");
        stringbuilder.append("length: ").append(length).append("\n");
        stringbuilder.append("width: ").append(width).append("\n");
        stringbuilder.append("height: ").append(height).append("\n");
        stringbuilder.append("dimensionUnitType: ").append(dimensionUnitType).append("\n");
        stringbuilder.append("requireWeighDimensionValidation: ").append(requireWeighDimensionValidation).append("\n");
        for (Iterator iterator = costs.iterator(); iterator.hasNext(); stringbuilder.append(((ShippingZonalCost)iterator.next()).toString()).append("\n")) { }
        stringbuilder.append(shippingService);
        return stringbuilder.toString();
    }
}
