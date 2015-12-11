// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.io.Writer;
import java.util.Map;

// Referenced classes of package com.amazon.device.utils:
//            DetUtil

public static class mNextProcessor
    implements or
{

    private or mNextProcessor;
    private Map mReplaceValueMap;

    public void process(String s, String s1, Writer writer)
        throws Exception
    {
        String s2 = (String)mReplaceValueMap.get(s1);
        if (s2 == null)
        {
            mNextProcessor.process(s, s1, writer);
            return;
        } else
        {
            mNextProcessor.process(s, s2, writer);
            return;
        }
    }

    public or(Map map, or or)
    {
        mReplaceValueMap = map;
        mNextProcessor = or;
    }
}
