// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;
import java.util.Map;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            FFmpegExecuteResponseHandler, FFmpegLoadBinaryResponseHandler

interface FFmpegInterface
{

    public abstract void execute(Map map, String as[], FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
        throws FFmpegCommandAlreadyRunningException;

    public abstract void execute(String as[], FFmpegExecuteResponseHandler ffmpegexecuteresponsehandler)
        throws FFmpegCommandAlreadyRunningException;

    public abstract String getDeviceFFmpegVersion()
        throws FFmpegCommandAlreadyRunningException;

    public abstract String getLibraryFFmpegVersion();

    public abstract boolean isFFmpegCommandRunning();

    public abstract boolean killRunningProcesses();

    public abstract void loadBinary(FFmpegLoadBinaryResponseHandler ffmpegloadbinaryresponsehandler)
        throws FFmpegNotSupportedException;

    public abstract void setTimeout(long l);
}
