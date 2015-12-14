// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

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

    private static int REGEX_GROUP_ID = 0;
    private static final Pattern REGEX_STACK_TRACE_PATTERN = Pattern.compile("([a-zA-Z0-9_\\.\\$]+(Exception|Error|TerribleFailure))|(at\\s.*\\(.*\\))|#\\d+\\s+pc\\s+[\\w\\d]+\\s+([^\\+^\\r^\\n]+)");
    private static final DPLogger log = new DPLogger("CrashDescriptorUtil");

    public static String calculateCrashDescriptor(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor, String s)
        throws Exception
    {
        bufferedreader.mark(25600);
        writer = new char[25600];
        bufferedreader.read(writer, 0, 25600);
        int i;
        bufferedreader.reset();
        bufferedreader = new BufferedReader(new CharArrayReader(writer), 1);
        writer = new StringBuilder();
        if (s != null)
        {
            writer.append(s);
        }
        i = 0;
_L2:
        headerprocessor = bufferedreader.readLine();
        if (headerprocessor == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (headerprocessor.startsWith("***"))
        {
            REGEX_GROUP_ID = 4;
            int j = i;
            do
            {
                i = j;
                if (bufferedreader.readLine().startsWith("backtrace:"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                i = j;
                if (j >= 50)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j++;
            } while (true);
        }
        break MISSING_BLOCK_LABEL_134;
        writer;
        bufferedreader.reset();
        throw writer;
        headerprocessor = REGEX_STACK_TRACE_PATTERN.matcher(headerprocessor);
        if (headerprocessor.find())
        {
            break MISSING_BLOCK_LABEL_172;
        }
        if (writer.length() <= 0)
        {
            log.warn("extractJavaCrashInfoFromCrashBody", "No stack trace.", new Object[0]);
            return null;
        } else
        {
            return calculateCrashDescriptor(((StringBuilder) (writer)));
        }
        writer.append(headerprocessor.group(REGEX_GROUP_ID));
        if (true) goto _L2; else goto _L1
_L1:
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
