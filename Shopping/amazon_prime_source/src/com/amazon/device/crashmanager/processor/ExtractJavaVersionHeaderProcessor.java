// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExtractJavaVersionHeaderProcessor
    implements com.amazon.device.utils.DetUtil.HeaderProcessor
{

    private static final Pattern JAVA_APP_VERSION_REGEX = Pattern.compile("^\\S+\\s+v(\\d+)\\s+\\((.+)\\)$");
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mNextProcessor;

    public ExtractJavaVersionHeaderProcessor(com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
    {
        mNextProcessor = headerprocessor;
    }

    public void process(String s, String s1, Writer writer)
        throws Exception
    {
        Matcher matcher = JAVA_APP_VERSION_REGEX.matcher(s1);
        if (matcher.matches())
        {
            mNextProcessor.process("Version", matcher.group(1), writer);
        }
        mNextProcessor.process(s, s1, writer);
    }

}
