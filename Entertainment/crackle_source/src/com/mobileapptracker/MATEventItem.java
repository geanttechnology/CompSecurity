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

    public MATEventItem(String s, int i, double d, double d1)
    {
        itemname = null;
        quantity = 0;
        unitPrice = 0.0D;
        revenue = 0.0D;
        attribute_sub1 = null;
        attribute_sub2 = null;
        attribute_sub3 = null;
        attribute_sub4 = null;
        attribute_sub5 = null;
        itemname = s;
        quantity = i;
        unitPrice = d;
        revenue = d1;
    }

    public MATEventItem(String s, int i, double d, double d1, String s1, 
            String s2, String s3, String s4, String s5)
    {
        itemname = null;
        quantity = 0;
        unitPrice = 0.0D;
        revenue = 0.0D;
        attribute_sub1 = null;
        attribute_sub2 = null;
        attribute_sub3 = null;
        attribute_sub4 = null;
        attribute_sub5 = null;
        itemname = s;
        quantity = i;
        unitPrice = d;
        revenue = d1;
        attribute_sub1 = s1;
        attribute_sub2 = s2;
        attribute_sub3 = s3;
        attribute_sub4 = s4;
        attribute_sub5 = s5;
    }

    public MATEventItem(String s, String s1, String s2, String s3, String s4, String s5)
    {
        itemname = null;
        quantity = 0;
        unitPrice = 0.0D;
        revenue = 0.0D;
        attribute_sub1 = null;
        attribute_sub2 = null;
        attribute_sub3 = null;
        attribute_sub4 = null;
        attribute_sub5 = null;
        itemname = s;
        attribute_sub1 = s1;
        attribute_sub2 = s2;
        attribute_sub3 = s3;
        attribute_sub4 = s4;
        attribute_sub5 = s5;
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
        hashmap.put("revenue", Double.toString(revenue));
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
}
