// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.Artifact;
import java.io.InputStream;

public interface ArtifactProcessor
{

    public abstract boolean canProcessTag(String s);

    public abstract InputStream processArtifact(Artifact artifact)
        throws Exception;
}
