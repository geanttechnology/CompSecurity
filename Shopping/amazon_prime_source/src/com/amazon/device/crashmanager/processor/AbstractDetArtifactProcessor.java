// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.Artifact;
import com.amazon.device.utils.DetUtil;
import com.amazon.device.utils.MfbsInputStream;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            ArtifactProcessor

abstract class AbstractDetArtifactProcessor
    implements ArtifactProcessor
{

    protected static final int ARTIFACT_BUFFER_SIZE = 25600;
    private static final DPLogger log = new DPLogger("AbstractDetArtifactProcessor");
    protected final char mBuffer[];
    protected final com.amazon.device.utils.DetUtil.HeaderProcessor mDefaultHeaderProcessor;
    protected final DetUtil mDetUtil;
    protected final String mDeviceSerialNumber;
    protected final String mDeviceType;
    protected final Map mExtraInfo;
    protected final com.amazon.device.utils.DetUtil.HeaderWriter mHeaderWriter;

    public AbstractDetArtifactProcessor(DetUtil detutil, String s, String s1)
    {
        this(detutil, s, s1, null);
    }

    public AbstractDetArtifactProcessor(DetUtil detutil, String s, String s1, Map map)
    {
        mBuffer = new char[25600];
        if (detutil == null)
        {
            throw new IllegalArgumentException("DetUtil must not be null.");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("DeviceType must not be null.");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("DeviceSerialNumber must not be null.");
        } else
        {
            mDetUtil = detutil;
            mDeviceType = s;
            mDeviceSerialNumber = s1;
            mExtraInfo = map;
            mHeaderWriter = new com.amazon.device.utils.DetUtil.HeaderWriter();
            mDefaultHeaderProcessor = new com.amazon.device.utils.DetUtil.DefaultHeaderProcessor(Collections.EMPTY_MAP, mHeaderWriter);
            return;
        }
    }

    protected void addHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        long l = artifact.getCreationTimeUTCMillis();
        String s = mDetUtil.formatDate(l);
        mDefaultHeaderProcessor.process("StartTime", s, writer);
        mDefaultHeaderProcessor.process("EndTime", s, writer);
        mDefaultHeaderProcessor.process("CrashTimeUTC", Long.toString(l), writer);
        mDefaultHeaderProcessor.process("CrashType", artifact.getTag(), writer);
        mDefaultHeaderProcessor.process("OsBuildNumber", android.os.Build.VERSION.INCREMENTAL, writer);
        addSpecificHeaders(artifact, bufferedreader, writer);
    }

    protected abstract void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception;

    public abstract boolean canProcessTag(String s);

    public InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(artifact.getInputStream()), 25600);
        MfbsInputStream mfbsinputstream;
        mfbsinputstream = new MfbsInputStream(bufferedreader);
        Writer writer = mfbsinputstream.getLogFileWriter();
        mDetUtil.addMetadataSectionHeader(mDefaultHeaderProcessor, mDeviceType, mDeviceSerialNumber, mExtraInfo, writer);
        addHeaders(artifact, bufferedreader, writer);
        mDetUtil.addEventsSectionHeader(writer);
        mfbsinputstream.pump();
        try
        {
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (Artifact artifact)
        {
            log.warn("constructCrashUploadMessage", "Error closing crash report file", new Object[] {
                artifact
            });
            return mfbsinputstream;
        }
        return mfbsinputstream;
        artifact;
        try
        {
            bufferedreader.close();
        }
        catch (IOException ioexception)
        {
            log.warn("constructCrashUploadMessage", "Error closing crash report file", new Object[] {
                ioexception
            });
        }
        throw artifact;
    }

}
