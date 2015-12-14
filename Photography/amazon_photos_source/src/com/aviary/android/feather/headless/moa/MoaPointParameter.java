// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter

public class MoaPointParameter extends MoaParameter
{

    private static final long serialVersionUID = 0x650180f859a7ef78L;

    public MoaPointParameter()
    {
        init();
        setValue(0.0F, 0.0F);
    }

    public MoaPointParameter(double d, double d1)
    {
        init();
        setValue(d, d1);
    }

    public MoaPointParameter(float f, float f1)
    {
        init();
        setValue(f, f1);
    }

    public static Object encode(float f, float f1)
    {
        JSONArray jsonarray = new JSONArray();
        double d = f;
        try
        {
            jsonarray.put(d);
            jsonarray.put(f1);
        }
        catch (JSONException jsonexception)
        {
            return jsonarray;
        }
        return jsonarray;
    }

    private void init()
    {
        value = new double[2];
        type = "point";
    }

    public Object clone()
    {
        return new MoaPointParameter(((double[])value)[0], ((double[])value)[1]);
    }

    public Object encode()
    {
        JSONArray jsonarray = new JSONArray();
        try
        {
            jsonarray.put(((double[])value)[0]);
            jsonarray.put(((double[])value)[1]);
        }
        catch (JSONException jsonexception)
        {
            return jsonarray;
        }
        return jsonarray;
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }

    double[] parseValue(JSONObject jsonobject, String s)
    {
        jsonobject = jsonobject.optJSONArray(s);
        double d;
        double d1;
        try
        {
            d = jsonobject.getDouble(0);
            d1 = jsonobject.getDouble(1);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return (new double[] {
                0.0D, 0.0D
            });
        }
        return (new double[] {
            d, d1
        });
    }

    public void setValue(double d, double d1)
    {
        ((double[])value)[0] = d;
        ((double[])value)[1] = d1;
    }

    public void setValue(float f, float f1)
    {
        ((double[])value)[0] = f;
        ((double[])value)[1] = f1;
    }
}
