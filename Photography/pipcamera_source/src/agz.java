// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;

public class agz
{

    public aew a;
    private final MediaMuxer b;
    private int c;
    private int d;
    private boolean e;
    private agx f;
    private agx g;

    int a(MediaFormat mediaformat)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IllegalStateException("muxer already started");
        }
        break MISSING_BLOCK_LABEL_24;
        mediaformat;
        this;
        JVM INSTR monitorexit ;
        throw mediaformat;
        int i = b.addTrack(mediaformat);
        this;
        JVM INSTR monitorexit ;
        return i;
    }

    public void a()
    {
        Log.e("MediaMuxerWrapper", (new StringBuilder()).append("stopRecording mVideoEncoder=").append(f).append(", mAudioEncoder=").append(g).toString());
        if (f != null)
        {
            f.b();
        }
        f = null;
        if (g != null)
        {
            g.b();
        }
        g = null;
    }

    void a(int i, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        this;
        JVM INSTR monitorenter ;
        if (d > 0)
        {
            b.writeSampleData(i, bytebuffer, bufferinfo);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer;
        throw bytebuffer;
    }

    public boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = e;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        d = d + 1;
        if (c > 0 && d == c)
        {
            b.start();
            e = true;
            notifyAll();
        }
        flag = e;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    void d()
    {
        this;
        JVM INSTR monitorenter ;
        d = d - 1;
        if (c <= 0 || d > 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        Boolean boolean1 = Boolean.valueOf(false);
        try
        {
            b.stop();
            b.release();
        }
        catch (Exception exception)
        {
            exception = Boolean.valueOf(true);
        }
        e = false;
        if (a != null)
        {
            a.sendMessage(a.obtainMessage(1, boolean1));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        throw exception1;
    }
}
