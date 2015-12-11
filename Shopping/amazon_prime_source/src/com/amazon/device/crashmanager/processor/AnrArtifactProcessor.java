// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.Artifact;
import com.amazon.device.crashmanager.utils.CrashDescriptorDedupeUtil;
import com.amazon.device.crashmanager.utils.CrashDescriptorUtil;
import com.amazon.device.utils.DetUtil;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.InputStream;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            AbstractDetArtifactProcessor, MetricsHeaderProcessorFactory, ExtractJavaVersionHeaderProcessor, MetricsHeaderProcessor

public class AnrArtifactProcessor extends AbstractDetArtifactProcessor
{

    public static final Set ANR_ARTIFACT_TAGS;
    private static final Pattern REGEX_STACK_TRACE_PATTERN = Pattern.compile("(at\\s.*\\(.*\\))");
    private static final DPLogger log = new DPLogger("AnrArtifactProcessor");
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mAnrHeaderProcessor;
    private final CrashDescriptorDedupeUtil mCrashDedupeUtil;
    private final MetricsHeaderProcessor mMetricsHeaderProcessor;

    public AnrArtifactProcessor(DetUtil detutil, String s, String s1, Map map, MetricsHeaderProcessorFactory metricsheaderprocessorfactory, CrashDescriptorDedupeUtil crashdescriptordedupeutil)
    {
        super(detutil, s, s1, map);
        if (metricsheaderprocessorfactory == null)
        {
            throw new IllegalArgumentException("Metrics header processor factory must not be null.");
        }
        if (crashdescriptordedupeutil == null)
        {
            throw new IllegalArgumentException("Duplicate count must not be null.");
        } else
        {
            mMetricsHeaderProcessor = metricsheaderprocessorfactory.construct(mHeaderWriter);
            detutil = new HashMap(3);
            detutil.put("Process", mMetricsHeaderProcessor);
            detutil.put("hasForegroundActivities", mMetricsHeaderProcessor);
            detutil.put("Package", new ExtractJavaVersionHeaderProcessor(mHeaderWriter));
            mAnrHeaderProcessor = new com.amazon.device.utils.DetUtil.DefaultHeaderProcessor(detutil, mHeaderWriter);
            mCrashDedupeUtil = crashdescriptordedupeutil;
            return;
        }
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mMetricsHeaderProcessor.setProcessTag(artifact.getTag());
        mAnrHeaderProcessor.process("ContentType", "JavaCrash", writer);
        mDetUtil.processHeaders(bufferedreader, writer, mAnrHeaderProcessor);
        bufferedreader = extractAnrInfoFromCrashBody(bufferedreader, writer, mAnrHeaderProcessor);
        if (bufferedreader != null)
        {
            Integer integer = Integer.valueOf(mCrashDedupeUtil.getCount(bufferedreader));
            if (integer != null && integer.intValue() > 1)
            {
                mAnrHeaderProcessor.process("CrashDuplicateCount", integer.toString(), writer);
            }
        }
        artifact.setCrashDescriptor(bufferedreader);
    }

    public boolean canProcessTag(String s)
    {
        return ANR_ARTIFACT_TAGS.contains(s);
    }

    protected String extractAnrInfoFromCrashBody(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
        throws Exception
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        bufferedreader.mark(25600);
        bufferedreader.read(mBuffer, 0, 25600);
        bufferedreader.reset();
        bufferedreader = new BufferedReader(new CharArrayReader(mBuffer), 1);
_L2:
        Object obj1 = bufferedreader.readLine();
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((String) (obj1)).startsWith("Cmd line: ")) goto _L2; else goto _L1
_L1:
        bufferedreader.readLine();
        obj1 = bufferedreader.readLine();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj1)).startsWith("DALVIK THREADS")) goto _L5; else goto _L4
_L4:
        headerprocessor.process("CrashDescriptor", "", writer);
        bufferedreader = obj;
_L6:
        this;
        JVM INSTR monitorexit ;
        return bufferedreader;
        writer;
        bufferedreader.reset();
        throw writer;
        bufferedreader;
        this;
        JVM INSTR monitorexit ;
        throw bufferedreader;
_L5:
        obj1 = new StringBuilder();
        if (mMetricsHeaderProcessor.getProcessName() != null)
        {
            ((StringBuilder) (obj1)).append(mMetricsHeaderProcessor.getProcessName());
        }
        break MISSING_BLOCK_LABEL_313;
_L8:
        String s = bufferedreader.readLine();
        int i;
        int j;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        j = i + 1;
        if (!s.isEmpty() && s.charAt(0) != '\n' && s.charAt(0) != '\r')
        {
            break MISSING_BLOCK_LABEL_261;
        }
        if (j >= 10)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        if (((StringBuilder) (obj1)).toString().equals(mMetricsHeaderProcessor.getProcessName()))
        {
            break MISSING_BLOCK_LABEL_261;
        }
        if (((StringBuilder) (obj1)).length() > 0)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        log.warn("extractAnrInfoFromCrashBody", "No stack trace.", new Object[0]);
        bufferedreader = obj;
          goto _L6
        i = j;
        if (!REGEX_STACK_TRACE_PATTERN.matcher(s).find()) goto _L8; else goto _L7
_L7:
        ((StringBuilder) (obj1)).append(s);
        i = j;
          goto _L8
        bufferedreader = CrashDescriptorUtil.calculateCrashDescriptor(((StringBuilder) (obj1)));
        headerprocessor.process("CrashDescriptor", bufferedreader, writer);
          goto _L6
        i = 0;
          goto _L8
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

    static 
    {
        HashSet hashset = new HashSet(8);
        hashset.add("system_app_anr");
        hashset.add("data_app_anr");
        ANR_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
    }
}
