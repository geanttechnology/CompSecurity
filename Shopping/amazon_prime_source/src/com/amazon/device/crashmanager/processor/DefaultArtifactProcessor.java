// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.Artifact;
import com.amazon.device.utils.DetUtil;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.Writer;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            AbstractDetArtifactProcessor

class DefaultArtifactProcessor extends AbstractDetArtifactProcessor
{

    private static final DPLogger log = new DPLogger("DefaultArtifactProcessor");

    public DefaultArtifactProcessor(DetUtil detutil, String s, String s1, Map map)
    {
        super(detutil, s, s1, map);
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
    }

    public boolean canProcessTag(String s)
    {
        return true;
    }

}
