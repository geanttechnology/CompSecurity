// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.io.Writer;
import java.util.Map;

// Referenced classes of package com.amazon.device.utils:
//            DetUtil

public static class mDefaultHeaderProcessor
    implements mDefaultHeaderProcessor
{

    private final  mDefaultHeaderProcessor;
    private final Map mHeaderProcessors;

    public void process(String s, String s1, Writer writer)
        throws Exception
    {
        mDefaultHeaderProcessor mdefaultheaderprocessor = (mDefaultHeaderProcessor)mHeaderProcessors.get(s);
        if (mdefaultheaderprocessor != null)
        {
            mdefaultheaderprocessor.(s, s1, writer);
            return;
        } else
        {
            mDefaultHeaderProcessor.(s, s1, writer);
            return;
        }
    }

    public (Map map,  )
    {
        mHeaderProcessors = map;
        mDefaultHeaderProcessor = ;
    }
}
