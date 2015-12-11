// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.io.Writer;

// Referenced classes of package com.amazon.device.utils:
//            DetUtil

public static class mNextProcessor
    implements r
{

    private String mNewHeader;
    private r mNextProcessor;

    public void process(String s, String s1, Writer writer)
        throws Exception
    {
        mNextProcessor.process(mNewHeader, s1, writer);
    }

    public r(String s, r r)
    {
        mNewHeader = s;
        mNextProcessor = r;
    }
}
