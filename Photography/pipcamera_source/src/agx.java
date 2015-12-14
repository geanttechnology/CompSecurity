// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class agx
    implements Runnable
{

    protected final Object a;
    protected volatile boolean b;
    protected volatile boolean c;
    protected volatile boolean d;
    protected boolean e;
    protected boolean f;
    protected int g;
    protected MediaCodec h;
    protected final WeakReference i;
    protected final agy j;
    private int k;
    private android.media.MediaCodec.BufferInfo l;
    private long m;

    protected void a(ByteBuffer bytebuffer, int i1, long l1)
    {
        if (b)
        {
            ByteBuffer abytebuffer[] = h.getInputBuffers();
            while (b) 
            {
                int j1 = h.dequeueInputBuffer(10000L);
                if (j1 >= 0)
                {
                    ByteBuffer bytebuffer1 = abytebuffer[j1];
                    bytebuffer1.clear();
                    if (bytebuffer != null)
                    {
                        bytebuffer1.put(bytebuffer);
                    }
                    if (i1 <= 0)
                    {
                        e = true;
                        h.queueInputBuffer(j1, 0, 0, l1, 4);
                        return;
                    }
                    try
                    {
                        h.queueInputBuffer(j1, 0, i1, l1, 0);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ByteBuffer bytebuffer)
                    {
                        Log.e("MediaEncoder", bytebuffer.toString());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ByteBuffer bytebuffer)
                    {
                        Log.e("MediaEncoder", bytebuffer.toString());
                    }
                    return;
                }
                if (j1 != -1);
            }
        }
    }

    public boolean a()
    {
label0:
        {
            synchronized (a)
            {
                if (b && !c && !d)
                {
                    break label0;
                }
            }
            return false;
        }
        k = k + 1;
        a.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void b()
    {
label0:
        {
            synchronized (a)
            {
                if (b && !c)
                {
                    break label0;
                }
            }
            return;
        }
        c = true;
        a.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void c()
    {
        try
        {
            j.a(this);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("MediaEncoder", "failed onStopped", ((Throwable) (obj)));
        }
        b = false;
        if (h != null)
        {
            try
            {
                h.stop();
                h.release();
                h = null;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("MediaEncoder", "failed releasing MediaCodec", ((Throwable) (obj)));
            }
        }
        if (f)
        {
            Object obj;
            if (i != null)
            {
                obj = (agz)i.get();
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                try
                {
                    ((agz) (obj)).d();
                }
                catch (Exception exception)
                {
                    Log.e("MediaEncoder", "failed stopping muxer", exception);
                }
            }
        }
        l = null;
    }

    protected void d()
    {
        a(null, 0, f());
    }

    protected void e()
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        agz agz1;
        try
        {
            obj = h.getOutputBuffers();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("MediaEncoder", (new StringBuilder()).append("getOutputBuffers exception:").append(((Exception) (obj)).toString()).toString());
            obj = null;
        }
        agz1 = (agz)i.get();
        if (agz1 == null)
        {
            Log.w("MediaEncoder", "muxer is unexpectedly null");
            return;
        }
        break MISSING_BLOCK_LABEL_462;
_L9:
        agz1;
        JVM INSTR monitorexit ;
        int j1;
        int k1 = j1;
_L5:
        if (!b) goto _L1; else goto _L3
_L3:
        int i1;
label0:
        {
            try
            {
                j1 = h.dequeueOutputBuffer(l, 10000L);
            }
            catch (Exception exception)
            {
                Log.e("MediaEncoder", (new StringBuilder()).append("dequeueOutputBuffer exception:").append(exception.toString()).toString());
                j1 = k1;
            }
            if (j1 != -1)
            {
                break label0;
            }
            k1 = j1;
            if (!e)
            {
                int l1 = i1 + 1;
                i1 = l1;
                k1 = j1;
                if (l1 > 5)
                {
                    return;
                }
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
label1:
        {
            if (j1 != -3)
            {
                break label1;
            }
            obj = h.getOutputBuffers();
            k1 = j1;
        }
        if (true) goto _L5; else goto _L6
_L6:
        if (j1 != -2)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        if (f)
        {
            throw new RuntimeException("format changed twice");
        }
        g = agz1.a(h.getOutputFormat());
        f = true;
        k1 = j1;
        if (agz1.c()) goto _L5; else goto _L7
_L7:
        agz1;
        JVM INSTR monitorenter ;
_L10:
        boolean flag = agz1.b();
        if (flag) goto _L9; else goto _L8
_L8:
        agz1.wait(100L);
          goto _L10
        obj;
        agz1;
        JVM INSTR monitorexit ;
        return;
        obj;
        agz1;
        JVM INSTR monitorexit ;
        throw obj;
        k1 = j1;
        if (j1 < 0) goto _L5; else goto _L11
_L11:
        if (obj == null) goto _L1; else goto _L12
_L12:
        ByteBuffer bytebuffer = obj[j1];
        if (bytebuffer == null)
        {
            throw new RuntimeException((new StringBuilder()).append("encoderOutputBuffer ").append(j1).append(" was null").toString());
        }
        if ((l.flags & 2) != 0)
        {
            l.size = 0;
        }
        if (l.size != 0)
        {
            if (!f)
            {
                throw new RuntimeException("drain:muxer hasn't started");
            }
            l.presentationTimeUs = f();
            agz1.a(g, bytebuffer, l);
            m = l.presentationTimeUs;
            i1 = 0;
        }
        try
        {
            h.releaseOutputBuffer(j1, false);
        }
        catch (Exception exception1) { }
        k1 = j1;
        if ((l.flags & 4) == 0) goto _L5; else goto _L13
_L13:
        b = false;
        return;
        k1 = 0;
        i1 = 0;
          goto _L5
    }

    protected long f()
    {
        long l2 = System.nanoTime() / 1000L;
        long l1 = l2;
        if (l2 < m)
        {
            l1 = l2 + (m - l2);
        }
        return l1;
    }

    public void run()
    {
        synchronized (a)
        {
            c = false;
            d = true;
            k = 0;
            a.notify();
        }
_L6:
        obj = a;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1;
        flag1 = c;
        boolean flag2 = d;
        boolean flag;
        if (k > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        k = k - 1;
        obj;
        JVM INSTR monitorexit ;
        if (!flag1) goto _L2; else goto _L1
_L1:
        e();
        d();
        e();
        c();
_L4:
        synchronized (a)
        {
            c = true;
            d = true;
            b = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L2:
        if (flag && !d)
        {
            e();
        } else
        if (!flag)
        {
            synchronized (a)
            {
                a.wait();
            }
        }
        continue; /* Loop/switch isn't completed */
        JVM INSTR monitorenter ;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L4; else goto _L3
_L3:
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
