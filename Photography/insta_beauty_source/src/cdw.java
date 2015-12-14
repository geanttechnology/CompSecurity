// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;

public class cdw
{

    public bzu a;
    private String b;
    private final MediaMuxer c;
    private int d;
    private int e;
    private boolean f;
    private cdu g;
    private cdu h;

    public cdw(String s, bzu bzu1)
    {
        g = null;
        h = null;
        try
        {
            b = s;
            a = bzu1;
            Log.e("MediaMuxerWrapper", (new StringBuilder()).append("mOutputPath=").append(b).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
        c = new MediaMuxer(b, 0);
        e = 0;
        d = 0;
        f = false;
    }

    int a(MediaFormat mediaformat)
    {
        this;
        JVM INSTR monitorenter ;
        if (f)
        {
            throw new IllegalStateException("muxer already started");
        }
        break MISSING_BLOCK_LABEL_24;
        mediaformat;
        this;
        JVM INSTR monitorexit ;
        throw mediaformat;
        int i = c.addTrack(mediaformat);
        this;
        JVM INSTR monitorexit ;
        return i;
    }

    public cdx a()
    {
        return (cdx)g;
    }

    void a(int i, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo)
    {
        this;
        JVM INSTR monitorenter ;
        if (e > 0)
        {
            c.writeSampleData(i, bytebuffer, bufferinfo);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer;
        throw bytebuffer;
    }

    void a(cdu cdu1)
    {
        int j = 1;
        int i;
        if (cdu1 instanceof cdx)
        {
            if (g != null)
            {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            g = cdu1;
        } else
        if (cdu1 instanceof cdq)
        {
            if (h != null)
            {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            h = cdu1;
        } else
        {
            throw new IllegalArgumentException("unsupported encoder");
        }
        if (g != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (h == null)
        {
            j = 0;
        }
        d = i + j;
    }

    public boolean b()
    {
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (g != null)
        {
            flag = g.a();
        } else
        {
            flag = false;
        }
        if (h != null)
        {
            flag1 = h.a();
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag)
        {
            flag2 = flag3;
            if (flag1)
            {
                flag2 = true;
            }
        }
        return flag2;
    }

    public void c()
    {
        if (g != null)
        {
            g.b();
        }
        if (h != null)
        {
            h.b();
        }
    }

    public void d()
    {
        Log.e("MediaMuxerWrapper", (new StringBuilder()).append("stopRecording mVideoEncoder=").append(g).append(", mAudioEncoder=").append(h).toString());
        if (g != null)
        {
            g.g();
        }
        g = null;
        if (h != null)
        {
            h.g();
        }
        h = null;
    }

    public void e()
    {
        if (g != null)
        {
            g.d();
        }
        if (h != null)
        {
            h.d();
        }
    }

    public boolean f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    boolean g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        e = e + 1;
        if (d > 0 && e == d)
        {
            c.start();
            f = true;
            notifyAll();
        }
        flag = f;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    void h()
    {
        this;
        JVM INSTR monitorenter ;
        e = e - 1;
        if (d <= 0 || e > 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        Boolean boolean1 = Boolean.valueOf(false);
        try
        {
            c.stop();
            c.release();
        }
        catch (Exception exception)
        {
            exception = Boolean.valueOf(true);
        }
        f = false;
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
