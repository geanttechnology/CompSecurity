// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter

public class MoaColorParameter extends MoaParameter
{

    static final int COLOR_STRING_SIZE = 8;
    private static final long serialVersionUID = 0x81e7d41df731e05dL;

    public MoaColorParameter(Integer integer)
    {
        setValue(integer);
    }

    public Object clone()
    {
        return new MoaColorParameter((Integer)getValue());
    }

    public Object encode()
    {
        return StringUtils.rightPad(Integer.toHexString(((Integer)getValue()).intValue()), 8, '0');
    }

    Integer parseValue(JSONObject jsonobject, String s)
    {
        return null;
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }
}
