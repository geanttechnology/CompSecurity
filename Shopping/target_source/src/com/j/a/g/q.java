// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.graphics.Color;
import org.json.JSONObject;

public class q
{

    public static Integer a(Object obj)
    {
        if (obj instanceof JSONObject)
        {
            Object obj1 = (JSONObject)obj;
            obj = Double.valueOf(((JSONObject) (obj1)).optDouble("r"));
            Double double1 = Double.valueOf(((JSONObject) (obj1)).optDouble("g"));
            Double double2 = Double.valueOf(((JSONObject) (obj1)).optDouble("b"));
            obj1 = Double.valueOf(((JSONObject) (obj1)).optDouble("a"));
            if (!Double.isNaN(((Double) (obj)).doubleValue()) && !Double.isNaN(double1.doubleValue()) && !Double.isNaN(double2.doubleValue()) && !Double.isNaN(((Double) (obj1)).doubleValue()))
            {
                return Integer.valueOf(Color.argb(Double.valueOf(((Double) (obj1)).doubleValue() * 255D).intValue(), ((Double) (obj)).intValue(), double1.intValue(), double2.intValue()));
            }
        }
        return null;
    }
}
