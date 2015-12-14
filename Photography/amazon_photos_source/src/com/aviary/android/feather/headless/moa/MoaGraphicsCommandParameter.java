// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter

public class MoaGraphicsCommandParameter extends MoaParameter
{

    public static final int COMMAND_CUBICTO = 3;
    public static final int COMMAND_LINETO = 1;
    public static final int COMMAND_MOVETO = 0;
    public static final int COMMAND_QUADTO = 2;
    static final DecimalFormat FORMATTER;
    static final DecimalFormatSymbols SYMBOLS;
    private static final long serialVersionUID = 0x11a8e22da6aaa51eL;
    private int commandType;

    public MoaGraphicsCommandParameter(int i)
    {
        init(i);
    }

    public MoaGraphicsCommandParameter(int i, float f, float f1)
    {
        init(i);
        setPoint(f, f1);
    }

    public MoaGraphicsCommandParameter(int i, float f, float f1, float f2, float f3)
    {
        init(i);
        setPoint(f, f1, f2, f3);
    }

    public MoaGraphicsCommandParameter(int i, float f, float f1, float f2, float f3, float f4, float f5)
    {
        init(i);
        setPoint(f, f1, f2, f3, f4, f5);
    }

    private void init(int i)
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 42
    //                   1 42
    //                   2 55
    //                   3 65;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException("Unsupported type");
_L2:
        value = new float[2];
_L6:
        commandType = i;
        return;
_L3:
        value = new float[4];
        continue; /* Loop/switch isn't completed */
_L4:
        value = new float[6];
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object clone()
    {
        MoaGraphicsCommandParameter moagraphicscommandparameter = new MoaGraphicsCommandParameter(commandType);
        System.arraycopy(value, 0, moagraphicscommandparameter.value, 0, ((float[])value).length);
        return moagraphicscommandparameter;
    }

    public Object encode()
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        int i;
        try
        {
            jsonobject.put("c", commandType);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        i = 0;
        if (i >= ((float[])value).length)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(FORMATTER.format(((float[])value)[i]));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        jsonobject.put("p", jsonarray);
        return jsonobject;
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }

    float[] parseValue(JSONObject jsonobject, String s)
    {
        return null;
    }

    public void setPoint(float f, float f1)
    {
        ((float[])value)[0] = f;
        ((float[])value)[1] = f1;
    }

    public void setPoint(float f, float f1, float f2, float f3)
    {
        ((float[])value)[0] = f;
        ((float[])value)[1] = f1;
        ((float[])value)[2] = f2;
        ((float[])value)[3] = f3;
    }

    public void setPoint(float f, float f1, float f2, float f3, float f4, float f5)
    {
        ((float[])value)[0] = f;
        ((float[])value)[1] = f1;
        ((float[])value)[2] = f2;
        ((float[])value)[3] = f3;
        ((float[])value)[4] = f4;
        ((float[])value)[5] = f5;
    }

    static 
    {
        SYMBOLS = new DecimalFormatSymbols();
        SYMBOLS.setDecimalSeparator('.');
        FORMATTER = new DecimalFormat("##.#####", SYMBOLS);
    }
}
