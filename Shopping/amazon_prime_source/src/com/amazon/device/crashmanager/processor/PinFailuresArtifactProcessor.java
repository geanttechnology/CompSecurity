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

public class PinFailuresArtifactProcessor extends AbstractDetArtifactProcessor
{

    public static final Set PIN_FAILURE_ARTIFACT_TAGS;
    private static final DPLogger log = new DPLogger("PinFailuresArtifactProcessor");
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mCertificatePinFailureHeaderProcessor;

    public PinFailuresArtifactProcessor(DetUtil detutil, String s, String s1, Map map)
    {
        super(detutil, s, s1, map);
        mCertificatePinFailureHeaderProcessor = mDefaultHeaderProcessor;
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mCertificatePinFailureHeaderProcessor.process("ContentType", "PinFailure", writer);
    }

    public boolean canProcessTag(String s)
    {
        return PIN_FAILURE_ARTIFACT_TAGS.contains(s);
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

    static 
    {
        HashSet hashset = new HashSet(1);
        hashset.add("exp_det_cert_pin_failure");
        PIN_FAILURE_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
    }
}
