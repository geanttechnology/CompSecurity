// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.Artifact;
import com.amazon.device.utils.DetUtil;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Writer;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            AbstractDetArtifactProcessor

public class RamDumpArtifactProcessor extends AbstractDetArtifactProcessor
{

    private static final Pattern RESET_CAUSE_REGEX = Pattern.compile("Oops -.*|(Out of memory:).*\\(([\\w\\.]+)\\)|Kernel panic -.*");
    private static final DPLogger log = new DPLogger("RamDumpArtifactProcessor");
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mRamDumpHeaderProcessor;

    public RamDumpArtifactProcessor(DetUtil detutil, String s, String s1, Map map)
    {
        super(detutil, s, s1, map);
        mRamDumpHeaderProcessor = mDefaultHeaderProcessor;
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mRamDumpHeaderProcessor.process("ContentType", "Diagnostic", writer);
        mRamDumpHeaderProcessor.process("Build", android.os.Build.VERSION.INCREMENTAL, writer);
        extractResetCauseFromKmsgLog(bufferedreader, writer, mRamDumpHeaderProcessor);
    }

    public boolean canProcessTag(String s)
    {
        return s.equals("RAMDUMP_KMSG_LOG");
    }

    protected void extractResetCauseFromKmsgLog(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
        throws Exception
    {
        bufferedreader.mark(0x40000);
_L2:
        Object obj = bufferedreader.readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj = RESET_CAUSE_REGEX.matcher(((CharSequence) (obj)));
        if (!((Matcher) (obj)).find()) goto _L2; else goto _L1
_L1:
        if (((Matcher) (obj)).group(1) == null || ((Matcher) (obj)).group(2) == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = (new StringBuilder()).append(((Matcher) (obj)).group(1)).append(((Matcher) (obj)).group(2)).toString();
_L3:
        log.verbose("extractResetCauseFromKmsgLog", "kernel panic reset cause found", new Object[] {
            "reset cause", obj
        });
        headerprocessor.process("CrashDescriptor", ((String) (obj)), writer);
        bufferedreader.reset();
        return;
        obj = ((Matcher) (obj)).group();
          goto _L3
        bufferedreader.reset();
        log.info("extractResetCauseFromKmsgLog", "No reset cause found in log file.", new Object[0]);
        return;
        writer;
        bufferedreader.reset();
        throw writer;
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

}
