// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter

public class MoaFloatParameter extends MoaParameter
{

    private static final long serialVersionUID = 0x9a95ff39315a7676L;

    public MoaFloatParameter()
    {
        setValue(Float.valueOf(0.0F));
    }

    public MoaFloatParameter(float f)
    {
        setValue(Float.valueOf(f));
    }

    public Object clone()
    {
        return new MoaFloatParameter(((Float)value).floatValue());
    }

    public Object encode()
    {
        return value;
    }

    Float parseValue(JSONObject jsonobject, String s)
    {
        return Float.valueOf((float)jsonobject.optDouble(s, 0.0D));
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }
}
