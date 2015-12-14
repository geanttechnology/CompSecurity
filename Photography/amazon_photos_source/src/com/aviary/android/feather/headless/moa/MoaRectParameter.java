// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import android.graphics.RectF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter

public class MoaRectParameter extends MoaParameter
{

    private static final long serialVersionUID = 1L;

    public MoaRectParameter()
    {
        init();
        setValue(0.0F, 0.0F, 0.0F, 0.0F);
    }

    public MoaRectParameter(double d, double d1, double d2, double d3)
    {
        init();
        setValue(d, d1, d2, d3);
    }

    public MoaRectParameter(float f, float f1, float f2, float f3)
    {
        init();
        setValue(f, f1, f2, f3);
    }

    public MoaRectParameter(RectF rectf)
    {
        init();
        setValue(rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public static Object encode(float f, float f1, float f2, float f3)
    {
        JSONArray jsonarray = new JSONArray();
        double d = f;
        try
        {
            jsonarray.put(d);
            jsonarray.put(f1);
            jsonarray.put(f2);
            jsonarray.put(f3);
        }
        catch (JSONException jsonexception)
        {
            return jsonarray;
        }
        return jsonarray;
    }

    private void init()
    {
        value = new double[4];
        type = "rect";
    }

    public Object clone()
    {
        return new MoaRectParameter(((double[])value)[0], ((double[])value)[1], ((double[])value)[2], ((double[])value)[3]);
    }

    public Object encode()
    {
        JSONArray jsonarray = new JSONArray();
        try
        {
            jsonarray.put(((double[])value)[0]);
            jsonarray.put(((double[])value)[1]);
            jsonarray.put(((double[])value)[2]);
            jsonarray.put(((double[])value)[3]);
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
        double d2;
        double d3;
        try
        {
            d = jsonobject.getDouble(0);
            d1 = jsonobject.getDouble(1);
            d2 = jsonobject.getDouble(2);
            d3 = jsonobject.getDouble(3);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return (new double[] {
                0.0D, 0.0D, 0.0D, 0.0D
            });
        }
        return (new double[] {
            d, d1, d2, d3
        });
    }

    public void setValue(double d, double d1, double d2, double d3)
    {
        ((double[])value)[0] = d;
        ((double[])value)[1] = d1;
        ((double[])value)[2] = d2;
        ((double[])value)[3] = d3;
    }

    public void setValue(float f, float f1, float f2, float f3)
    {
        ((double[])value)[0] = f;
        ((double[])value)[1] = f1;
        ((double[])value)[2] = f2;
        ((double[])value)[3] = f3;
    }
}
