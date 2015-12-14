// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import com.amazon.device.utils.DetUtil;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactProcessor, Artifact

abstract class AbstractDetArtifactProcessor
    implements ArtifactProcessor
{

    private static final DPLogger log = new DPLogger("AbstractDetArtifactProcessor");
    private final com.amazon.device.utils.DetUtil.BodyWriter mBodyWriter;
    protected final char mBuffer[] = new char[25600];
    protected final com.amazon.device.utils.DetUtil.HeaderProcessor mDefaultHeaderProcessor;
    protected final DetUtil mDetUtil;
    protected final String mDeviceSerialNumber;
    protected final String mDeviceType;
    protected final Map mExtraInfo;
    protected final com.amazon.device.utils.DetUtil.HeaderWriter mHeaderWriter;

    public AbstractDetArtifactProcessor(DetUtil detutil, String s, String s1, Map map)
    {
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
            mBodyWriter = new com.amazon.device.utils.DetUtil.PlainBodyWriter();
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

    public byte[] processArtifact(Artifact artifact)
        throws Exception
    {
        byte abyte0[];
        Object obj;
        InputStream inputstream = artifact.getInputStream();
        int i = inputstream.available();
        abyte0 = new BufferedReader(new InputStreamReader(inputstream), 25600);
        obj = new StringWriter(i + 5120);
        mDetUtil.addMetadataSectionHeader(mDefaultHeaderProcessor, mDeviceType, mDeviceSerialNumber, mExtraInfo, ((Writer) (obj)));
        addHeaders(artifact, abyte0, ((Writer) (obj)));
        mDetUtil.addEventsSectionHeader(((Writer) (obj)));
        mBodyWriter.write(abyte0, ((Writer) (obj)));
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (Artifact artifact)
        {
            log.warn("constructCrashUploadMessage", "Failed to close crash entry input stream.", new Object[] {
                artifact
            });
        }
        artifact = ((StringWriter) (obj)).toString().getBytes();
        artifact = mDetUtil.compressMessage(artifact);
        abyte0 = mDetUtil.createDetMfbsHeader(new Long(artifact.length)).getBytes();
        obj = ByteBuffer.allocate(abyte0.length + artifact.length);
        ((ByteBuffer) (obj)).put(abyte0);
        ((ByteBuffer) (obj)).put(artifact);
        return ((ByteBuffer) (obj)).array();
        artifact;
        try
        {
            abyte0.close();
        }
        catch (IOException ioexception)
        {
            log.warn("constructCrashUploadMessage", "Failed to close crash entry input stream.", new Object[] {
                ioexception
            });
        }
        throw artifact;
    }

}
