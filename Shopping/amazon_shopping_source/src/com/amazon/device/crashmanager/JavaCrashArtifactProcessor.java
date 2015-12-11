// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import com.amazon.device.utils.DetUtil;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.device.crashmanager:
//            AbstractDetArtifactProcessor, MetricsHeaderProcessorFactory, ExtractJavaVersionHeaderProcessor, Artifact, 
//            MetricsHeaderProcessor, CrashDescriptorStorageUtil

class JavaCrashArtifactProcessor extends AbstractDetArtifactProcessor
{

    public static final Set JAVA_CRASH_ARTIFACT_TAGS;
    public static final Set JAVA_STACK_TRACE_TAGS;
    private static final Pattern REGEX_STACK_TRACE_PATTERN = Pattern.compile("([a-zA-Z0-9_\\.]+(Exception|Error))|(at\\s.*\\(.*\\))");
    private static final DPLogger log = new DPLogger("JavaCrashArtifactProcessor");
    private final CrashDescriptorStorageUtil mCrashDuplicateCount;
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mJavaHeaderProcessor;
    private final MetricsHeaderProcessor mMetricsHeaderProcessor;

    public JavaCrashArtifactProcessor(DetUtil detutil, String s, String s1, Map map, MetricsHeaderProcessorFactory metricsheaderprocessorfactory, CrashDescriptorStorageUtil crashdescriptorstorageutil)
    {
        super(detutil, s, s1, map);
        if (metricsheaderprocessorfactory == null)
        {
            throw new IllegalArgumentException("Metrics header processor factory must not be null.");
        }
        if (crashdescriptorstorageutil == null)
        {
            throw new IllegalArgumentException("Duplicate count must not be null.");
        } else
        {
            mMetricsHeaderProcessor = metricsheaderprocessorfactory.construct(mHeaderWriter);
            detutil = new HashMap(3);
            detutil.put("Process", mMetricsHeaderProcessor);
            detutil.put("hasForegroundActivities", mMetricsHeaderProcessor);
            detutil.put("Package", new ExtractJavaVersionHeaderProcessor(mHeaderWriter));
            mJavaHeaderProcessor = new com.amazon.device.utils.DetUtil.DefaultHeaderProcessor(detutil, mHeaderWriter);
            mCrashDuplicateCount = crashdescriptorstorageutil;
            return;
        }
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mMetricsHeaderProcessor.setProcessTag(artifact.getTag());
        mJavaHeaderProcessor.process("ContentType", "JavaCrash", writer);
        mDetUtil.processHeaders(bufferedreader, writer, mJavaHeaderProcessor);
        if (JAVA_STACK_TRACE_TAGS.contains(artifact.getTag()))
        {
            bufferedreader = extractJavaCrashInfoFromCrashBody(bufferedreader, writer, mJavaHeaderProcessor);
            if (bufferedreader != null)
            {
                Integer integer = mCrashDuplicateCount.getCount(bufferedreader);
                if (integer != null && integer.intValue() > 1)
                {
                    mJavaHeaderProcessor.process("CrashDuplicateCount", integer.toString(), writer);
                }
            }
            artifact.setCrashDescriptor(bufferedreader);
        }
    }

    public boolean canProcessTag(String s)
    {
        return JAVA_CRASH_ARTIFACT_TAGS.contains(s);
    }

    protected String extractJavaCrashInfoFromCrashBody(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
        throws Exception
    {
        bufferedreader.mark(25600);
        bufferedreader.read(mBuffer, 0, 25600);
        StringBuilder stringbuilder;
        bufferedreader.reset();
        bufferedreader = new BufferedReader(new CharArrayReader(mBuffer), 1);
        stringbuilder = new StringBuilder();
        if (mMetricsHeaderProcessor.getProcessName() != null)
        {
            stringbuilder.append(mMetricsHeaderProcessor.getProcessName());
        }
_L2:
        Object obj = bufferedreader.readLine();
        if (obj != null)
        {
            obj = REGEX_STACK_TRACE_PATTERN.matcher(((CharSequence) (obj)));
            if (((Matcher) (obj)).find())
            {
                break MISSING_BLOCK_LABEL_136;
            }
        }
        if (stringbuilder.length() <= 0)
        {
            log.warn("extractJavaCrashInfoFromCrashBody", "No stack trace.", new Object[0]);
            return null;
        } else
        {
            bufferedreader = (new BigInteger(MessageDigest.getInstance("SHA1").digest(stringbuilder.toString().getBytes()))).abs().toString(16);
            headerprocessor.process("CrashDescriptor", bufferedreader, writer);
            return bufferedreader;
        }
        writer;
        bufferedreader.reset();
        throw writer;
        stringbuilder.append(((Matcher) (obj)).group());
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        HashSet hashset = new HashSet(8);
        hashset.add("system_app_crash");
        hashset.add("data_app_crash");
        hashset.add("system_app_wtf");
        hashset.add("system_server_crash");
        hashset.add("system_server_watchdog");
        JAVA_CRASH_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
        hashset = new HashSet(4);
        hashset.add("system_app_crash");
        hashset.add("data_app_crash");
        hashset.add("system_server_crash");
        hashset.add("system_app_wtf");
        JAVA_STACK_TRACE_TAGS = Collections.unmodifiableSet(hashset);
    }
}
