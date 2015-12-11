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

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            AbstractDetArtifactProcessor, MetricsHeaderProcessorFactory, ExtractJavaVersionHeaderProcessor, MetricsHeaderProcessor

public class SmvArtifactProcessor extends AbstractDetArtifactProcessor
{

    public static final Set SMV_ARTIFACT_TAGS;
    private static final DPLogger log = new DPLogger("SmvArtifactProcessor");
    private final CrashDescriptorDedupeUtil mCrashDedupeUtil;
    private final MetricsHeaderProcessor mMetricsHeaderProcessor;
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mSmvHeaderProcessor;

    public SmvArtifactProcessor(DetUtil detutil, String s, String s1, Map map, MetricsHeaderProcessorFactory metricsheaderprocessorfactory, CrashDescriptorDedupeUtil crashdescriptordedupeutil)
    {
        super(detutil, s, s1, map);
        if (metricsheaderprocessorfactory == null)
        {
            throw new IllegalArgumentException("Metrics header processor factory must not be null.");
        }
        if (crashdescriptordedupeutil == null)
        {
            throw new IllegalArgumentException("CrashDedupeUTil must not be null.");
        } else
        {
            mMetricsHeaderProcessor = metricsheaderprocessorfactory.construct(mHeaderWriter);
            detutil = new HashMap(3);
            detutil.put("Process", mMetricsHeaderProcessor);
            detutil.put("hasForegroundActivities", mMetricsHeaderProcessor);
            detutil.put("Package", new ExtractJavaVersionHeaderProcessor(mHeaderWriter));
            mSmvHeaderProcessor = new com.amazon.device.utils.DetUtil.DefaultHeaderProcessor(detutil, mHeaderWriter);
            mCrashDedupeUtil = crashdescriptordedupeutil;
            return;
        }
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mMetricsHeaderProcessor.setProcessTag(artifact.getTag());
        mSmvHeaderProcessor.process("ContentType", "JavaCrash", writer);
        mDetUtil.processHeaders(bufferedreader, writer, mSmvHeaderProcessor);
        bufferedreader = extractSmvInfoFromCrashBody(bufferedreader, writer, mSmvHeaderProcessor);
        if (bufferedreader != null)
        {
            Integer integer = Integer.valueOf(mCrashDedupeUtil.getCount(bufferedreader));
            if (integer != null && integer.intValue() > 1)
            {
                mSmvHeaderProcessor.process("CrashDuplicateCount", integer.toString(), writer);
            }
        }
        artifact.setCrashDescriptor(bufferedreader);
    }

    public boolean canProcessTag(String s)
    {
        return SMV_ARTIFACT_TAGS.contains(s);
    }

    protected String extractSmvInfoFromCrashBody(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
        throws Exception
    {
        this;
        JVM INSTR monitorenter ;
        bufferedreader.mark(25600);
        bufferedreader.read(mBuffer, 0, 25600);
        StringBuilder stringbuilder;
        bufferedreader.reset();
        bufferedreader = new BufferedReader(new CharArrayReader(mBuffer), 1);
        stringbuilder = new StringBuilder();
_L4:
        String s = bufferedreader.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.trim().equals("")) goto _L3; else goto _L2
_L2:
        if (stringbuilder.length() > 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        log.warn("extractSmvInfoFromCrashBody", "No stack trace.", new Object[0]);
        bufferedreader = null;
_L5:
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
_L3:
        stringbuilder.append(s);
          goto _L4
        bufferedreader = CrashDescriptorUtil.calculateCrashDescriptor(stringbuilder);
        headerprocessor.process("CrashDescriptor", bufferedreader, writer);
          goto _L5
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

    static 
    {
        HashSet hashset = new HashSet(2);
        hashset.add("system_app_strictmode");
        hashset.add("data_app_strictmode");
        SMV_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
    }
}
