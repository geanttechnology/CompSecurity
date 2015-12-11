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
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            AbstractDetArtifactProcessor

public class DiagnosticArtifactProcessor extends AbstractDetArtifactProcessor
{

    public static final Set DIAGNOSTIC_ARTIFACT_TAGS;
    private static final DPLogger log = new DPLogger("DiagnosticArtifactProcessor");
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mDiagnosticHeaderProcessor;

    public DiagnosticArtifactProcessor(DetUtil detutil, String s, String s1, Map map)
    {
        super(detutil, s, s1, map);
        mDiagnosticHeaderProcessor = mDefaultHeaderProcessor;
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mDiagnosticHeaderProcessor.process("ContentType", "Diagnostic", writer);
        mDetUtil.processHeaders(bufferedreader, writer, mDiagnosticHeaderProcessor);
    }

    public boolean canProcessTag(String s)
    {
        return DIAGNOSTIC_ARTIFACT_TAGS.contains(s);
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

    static 
    {
        HashSet hashset = new HashSet(4);
        hashset.add("SYSTEM_BOOT");
        hashset.add("SYSTEM_LAST_KMSG");
        hashset.add("SYSTEM_RECOVERY_LOG");
        hashset.add("SYSTEM_RESTART");
        DIAGNOSTIC_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
    }
}
