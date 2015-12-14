// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import android.graphics.Matrix;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter

public class MoaMatrixParameter extends MoaParameter
{

    private static final long serialVersionUID = 0xbaf01ce42dbc0569L;
    private Matrix matrix;

    public MoaMatrixParameter(Matrix matrix1)
    {
        type = "matrix";
        matrix = matrix1;
    }

    public Object clone()
    {
        return new MoaMatrixParameter(new Matrix(matrix));
    }

    public Object encode()
    {
        JSONArray jsonarray = new JSONArray();
        float af[] = new float[9];
        matrix.getValues(af);
        int i = 0;
        while (i < 9) 
        {
            try
            {
                jsonarray.put(af[i]);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            i++;
        }
        return jsonarray;
    }

    Matrix parseValue(JSONObject jsonobject, String s)
    {
        return null;
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }
}
