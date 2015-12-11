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
//            AbstractDetArtifactProcessor, MetricsHeaderProcessorFactory, MetricsHeaderProcessor

public class NativeCrashArtifactProcessor extends AbstractDetArtifactProcessor
{

    private static final Pattern NATIVE_APP_NAME_REGEX = Pattern.compile("^pid: .+>>> (.+?) <<<.*$");
    public static final Set NATIVE_CRASH_ARTIFACT_TAGS;
    private static final Pattern STACKFRAME_IDENTIFIER = Pattern.compile("#\\d+\\s+pc\\s+[\\w\\d]+\\s+([^\\+^\\r^\\n]+)");
    private static final DPLogger log = new DPLogger("NativeCrashArtifactProcessor");
    private final CrashDescriptorDedupeUtil mCrashDedupeUtil;
    private final MetricsHeaderProcessor mMetricsHeaderProcessor;
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mNativeHeaderProcessor;

    public NativeCrashArtifactProcessor(DetUtil detutil, String s, String s1, Map map, MetricsHeaderProcessorFactory metricsheaderprocessorfactory, CrashDescriptorDedupeUtil crashdescriptordedupeutil)
    {
        super(detutil, s, s1, map);
        if (metricsheaderprocessorfactory == null)
        {
            throw new IllegalArgumentException("Metrics header processor factory must not be null.");
        }
        if (crashdescriptordedupeutil == null)
        {
            throw new IllegalArgumentException("CrashDedupeUtil must not be null.");
        } else
        {
            mMetricsHeaderProcessor = metricsheaderprocessorfactory.construct(mHeaderWriter);
            detutil = new HashMap(2);
            detutil.put("Process", mMetricsHeaderProcessor);
            detutil.put("hasForegroundActivities", mMetricsHeaderProcessor);
            mNativeHeaderProcessor = new com.amazon.device.utils.DetUtil.DefaultHeaderProcessor(detutil, mHeaderWriter);
            mCrashDedupeUtil = crashdescriptordedupeutil;
            return;
        }
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mMetricsHeaderProcessor.setProcessTag(artifact.getTag());
        mNativeHeaderProcessor.process("ContentType", "NativeCrash", writer);
        mDetUtil.processHeaders(bufferedreader, writer, mNativeHeaderProcessor);
        bufferedreader = extractNativeCrashInfoFromCrashBody(bufferedreader, writer, mNativeHeaderProcessor);
        if (bufferedreader != null)
        {
            Integer integer = Integer.valueOf(mCrashDedupeUtil.getCount(bufferedreader));
            if (integer != null && integer.intValue() > 1)
            {
                mNativeHeaderProcessor.process("CrashDuplicateCount", integer.toString(), writer);
            }
        }
        artifact.setCrashDescriptor(bufferedreader);
    }

    public boolean canProcessTag(String s)
    {
        return NATIVE_CRASH_ARTIFACT_TAGS.contains(s);
    }

    protected String extractNativeCrashInfoFromCrashBody(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
        throws Exception
    {
        bufferedreader.mark(25600);
        bufferedreader.read(mBuffer, 0, 25600);
        BufferedReader bufferedreader1;
        bufferedreader.reset();
        bufferedreader1 = new BufferedReader(new CharArrayReader(mBuffer), 1);
        if (bufferedreader1.readLine() == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_62;
        writer;
        bufferedreader.reset();
        throw writer;
        Object obj;
        int i;
        if (bufferedreader1.readLine() == null)
        {
            return null;
        }
        obj = bufferedreader1.readLine();
        if (obj == null)
        {
            log.warn("extractNativeCrashInfoFromCrashBody", "Could not find process information from native crash.", new Object[0]);
            return null;
        }
        bufferedreader = ((BufferedReader) (obj));
        if (((String) (obj)).startsWith("Revision"))
        {
            obj = bufferedreader1.readLine();
            bufferedreader = ((BufferedReader) (obj));
            if (obj == null)
            {
                log.warn("extractNativeCrashInfoFromCrashBody", "Could not find process information from native crash.", new Object[0]);
                return null;
            }
        }
        obj = new StringBuilder();
        bufferedreader = NATIVE_APP_NAME_REGEX.matcher(bufferedreader);
        if (bufferedreader.matches())
        {
            bufferedreader = bufferedreader.group(1);
            ((StringBuilder) (obj)).append(bufferedreader);
            headerprocessor.process("Process", bufferedreader, writer);
        } else
        {
            log.warn("extractNativeCrashInfoFromCrashBody", "Could not extract 'Process' from native crash.", new Object[0]);
        }
        i = 0;
_L8:
label0:
        {
            if (i < 100)
            {
                bufferedreader = bufferedreader1.readLine();
                if (bufferedreader != null)
                {
                    break label0;
                }
            }
            log.warn("extractNativeCrashInfoFromCrashBody", "Could not find stack trace in native crash.", new Object[0]);
            return null;
        }
        bufferedreader = STACKFRAME_IDENTIFIER.matcher(bufferedreader);
        if (!bufferedreader.find()) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append(bufferedreader.group(1));
_L6:
        bufferedreader = bufferedreader1.readLine();
        if (bufferedreader != null) goto _L4; else goto _L3
_L3:
        bufferedreader = CrashDescriptorUtil.calculateCrashDescriptor(((StringBuilder) (obj)));
        headerprocessor.process("CrashDescriptor", bufferedreader, writer);
        return bufferedreader;
_L4:
        if (!(bufferedreader = STACKFRAME_IDENTIFIER.matcher(bufferedreader)).find()) goto _L3; else goto _L5
_L5:
        ((StringBuilder) (obj)).append(bufferedreader.group(1));
        if (true) goto _L6; else goto _L2
_L2:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

    static 
    {
        HashSet hashset = new HashSet(1);
        hashset.add("SYSTEM_TOMBSTONE");
        NATIVE_CRASH_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
    }
}
