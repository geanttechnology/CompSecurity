// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import java.util.HashMap;
import org.json.JSONObject;

public class MATEventItem
{

    public String attribute_sub1;
    public String attribute_sub2;
    public String attribute_sub3;
    public String attribute_sub4;
    public String attribute_sub5;
    public String itemname;
    public int quantity;
    public double revenue;
    public double unitPrice;

    public MATEventItem(String s)
    {
        itemname = s;
    }

    public String getAttrStringByName(String s)
    {
        if (s.equals("itemname"))
        {
            return itemname;
        }
        if (s.equals("quantity"))
        {
            return Integer.toString(quantity);
        }
        if (s.equals("unitPrice"))
        {
            return Double.toString(unitPrice);
        }
        if (s.equals("revenue"))
        {
            return Double.toString(revenue);
        }
        if (s.equals("attribute_sub1"))
        {
            return attribute_sub1;
        }
        if (s.equals("attribute_sub2"))
        {
            return attribute_sub2;
        }
        if (s.equals("attribute_sub3"))
        {
            return attribute_sub3;
        }
        if (s.equals("attribute_sub4"))
        {
            return attribute_sub4;
        }
        if (s.equals("attribute_sub5"))
        {
            return attribute_sub5;
        } else
        {
            return null;
        }
    }

    public JSONObject toJSON()
    {
        HashMap hashmap = new HashMap();
        if (itemname != null)
        {
            hashmap.put("item", itemname);
        }
        hashmap.put("quantity", Integer.toString(quantity));
        hashmap.put("unit_price", Double.toString(unitPrice));
        if (revenue != 0.0D)
        {
            hashmap.put("revenue", Double.toString(revenue));
        }
        if (attribute_sub1 != null)
        {
            hashmap.put("attribute_sub1", attribute_sub1);
        }
        if (attribute_sub2 != null)
        {
            hashmap.put("attribute_sub2", attribute_sub2);
        }
        if (attribute_sub3 != null)
        {
            hashmap.put("attribute_sub3", attribute_sub3);
        }
        if (attribute_sub4 != null)
        {
            hashmap.put("attribute_sub4", attribute_sub4);
        }
        if (attribute_sub5 != null)
        {
            hashmap.put("attribute_sub5", attribute_sub5);
        }
        return new JSONObject(hashmap);
    }

    public MATEventItem withAttribute1(String s)
    {
        attribute_sub1 = s;
        return this;
    }

    public MATEventItem withAttribute2(String s)
    {
        attribute_sub2 = s;
        return this;
    }

    public MATEventItem withAttribute3(String s)
    {
        attribute_sub3 = s;
        return this;
    }

    public MATEventItem withAttribute4(String s)
    {
        attribute_sub4 = s;
        return this;
    }

    public MATEventItem withAttribute5(String s)
    {
        attribute_sub5 = s;
        return this;
    }

    public MATEventItem withQuantity(int i)
    {
        quantity = i;
        return this;
    }

    public MATEventItem withRevenue(double d)
    {
        revenue = d;
        return this;
    }

    public MATEventItem withUnitPrice(double d)
    {
        unitPrice = d;
        return this;
    }
}
