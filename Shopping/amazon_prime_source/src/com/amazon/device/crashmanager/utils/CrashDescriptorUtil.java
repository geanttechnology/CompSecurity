// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.utils;

import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrashDescriptorUtil
{

    static final int ARTIFACT_BUFFER_SIZE = 25600;
    private static int REGEX_GROUP_ID = 0;
    private static final Pattern REGEX_STACK_TRACE_PATTERN = Pattern.compile("([a-zA-Z0-9_\\.\\$]+(Exception|Error|TerribleFailure))|(at\\s.*\\(.*\\))|#\\d+\\s+pc\\s+[\\w\\d]+\\s+([^\\+^\\r^\\n]+)");
    private static final DPLogger log = new DPLogger("CrashDescriptorUtil");

    public CrashDescriptorUtil()
    {
    }

    public static String calculateCrashDescriptor(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor, String s)
        throws Exception
    {
        bufferedreader.mark(25600);
        writer = new char[25600];
        bufferedreader.read(writer, 0, 25600);
        StringBuilder stringbuilder;
        bufferedreader.reset();
        headerprocessor = new BufferedReader(new CharArrayReader(writer), 1);
        stringbuilder = new StringBuilder();
        if (s != null)
        {
            stringbuilder.append(s);
        }
        int i = 0;
        writer = headerprocessor.readLine();
        REGEX_GROUP_ID = 0;
        if (writer != null)
        {
            bufferedreader = writer;
            if (!writer.startsWith("***"))
            {
                break MISSING_BLOCK_LABEL_135;
            }
            REGEX_GROUP_ID = 4;
            for (; !headerprocessor.readLine().startsWith("backtrace:") && i < 50; i++) { }
            break MISSING_BLOCK_LABEL_130;
        }
          goto _L1
        writer;
        bufferedreader.reset();
        throw writer;
        bufferedreader = headerprocessor.readLine();
_L3:
        bufferedreader = REGEX_STACK_TRACE_PATTERN.matcher(bufferedreader);
        if (bufferedreader.find()) goto _L2; else goto _L1
_L1:
        if (stringbuilder.length() <= 0)
        {
            log.warn("extractJavaCrashInfoFromCrashBody", "No stack trace.", new Object[0]);
            return null;
        } else
        {
            return calculateCrashDescriptor(stringbuilder);
        }
_L2:
        stringbuilder.append(bufferedreader.group(REGEX_GROUP_ID));
        writer = headerprocessor.readLine();
        bufferedreader = writer;
        if (writer != null) goto _L3; else goto _L1
    }

    public static String calculateCrashDescriptor(StringBuilder stringbuilder)
        throws Exception
    {
        return (new BigInteger(MessageDigest.getInstance("SHA1").digest(stringbuilder.toString().getBytes()))).abs().toString(16);
    }

    public static String calulcateCrashDescriptor(Throwable throwable, String s)
        throws Exception
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        throwable = new StringBuilder();
        throwable.append(stringwriter);
        if (s != null)
        {
            throwable.append(s);
        }
        return calculateCrashDescriptor(throwable);
    }

}
