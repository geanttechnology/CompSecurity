// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class anw extends aou
{

    private boolean A;
    private boolean B;
    private boolean C;
    private long D;
    private final ara a;
    public final ane b = new ane();
    final aoa c;
    public final Handler d;
    MediaCodec e;
    int f;
    private final boolean h;
    private final aor i;
    private final aoq j = new aoq(0);
    private final aoo k = new aoo();
    private final List l = new ArrayList();
    private final android.media.MediaCodec.BufferInfo m = new android.media.MediaCodec.BufferInfo();
    private aon n;
    private Map o;
    private boolean p;
    private ByteBuffer q[];
    private ByteBuffer r[];
    private long s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private boolean z;

    public anw(aor aor1, ara ara1, boolean flag, Handler handler, aoa aoa)
    {
        boolean flag1;
        if (atp.a >= 16)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a.b(flag1);
        i = aor1;
        a = ara1;
        h = flag;
        d = handler;
        c = aoa;
    }

    private void a(android.media.MediaCodec.CryptoException cryptoexception)
    {
        if (d != null && c != null)
        {
            d.post(new any(this, cryptoexception));
        }
    }

    private void a(anz anz1)
    {
        if (d != null && c != null)
        {
            d.post(new anx(this, anz1));
        }
        throw new ank(anz1);
    }

    private boolean a(boolean flag)
    {
        if (z)
        {
            return false;
        }
        if (t < 0)
        {
            t = e.dequeueInputBuffer(0L);
            if (t < 0)
            {
                return false;
            }
            j.b = q[t];
            j.b.clear();
        }
        if (!B) goto _L2; else goto _L1
_L1:
        int i1 = -3;
_L4:
        if (i1 == -2)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (x == 1)
        {
            for (i1 = 0; i1 < n.k.size(); i1++)
            {
                byte abyte0[] = (byte[])n.k.get(i1);
                j.b.put(abyte0);
            }

            x = 2;
        }
        int j1 = i.a(y, D, k, j, false);
        i1 = j1;
        if (flag)
        {
            i1 = j1;
            if (f == 1)
            {
                i1 = j1;
                if (j1 == -2)
                {
                    f = 2;
                    i1 = j1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag1;
        int k1;
        if (i1 == -5)
        {
            t();
            return true;
        }
        if (i1 == -4)
        {
            if (x == 2)
            {
                j.b.clear();
                x = 1;
            }
            a(k);
            return true;
        }
        if (i1 == -1)
        {
            if (x == 2)
            {
                j.b.clear();
                x = 1;
            }
            z = true;
            try
            {
                e.queueInputBuffer(t, 0, 0, 0L, 4);
                t = -1;
            }
            catch (android.media.MediaCodec.CryptoException cryptoexception)
            {
                a(cryptoexception);
                throw new ank(cryptoexception);
            }
            return false;
        }
        if (C)
        {
            if ((j.d & 1) == 0)
            {
                j.b.clear();
                if (x == 2)
                {
                    x = 1;
                }
                return true;
            }
            C = false;
        }
        if ((j.d & 2) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!v) goto _L6; else goto _L5
_L5:
        k1 = a.b();
        if (k1 == 0)
        {
            throw new ank(a.d());
        }
        if (k1 == 4 || !flag1 && h) goto _L6; else goto _L7
_L7:
        flag = true;
_L9:
        B = flag;
        if (B)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L6:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
        long l2;
        android.media.MediaCodec.CryptoInfo cryptoinfo;
        int ai[];
        int l1;
        try
        {
            k1 = j.b.position();
            l1 = k1 - j.c;
            l2 = j.e;
            if (j.f)
            {
                l.add(Long.valueOf(l2));
            }
        }
        catch (android.media.MediaCodec.CryptoException cryptoexception1)
        {
            a(cryptoexception1);
            throw new ank(cryptoexception1);
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_656;
        }
        cryptoinfo = j.a.g;
        if (l1 != 0) goto _L11; else goto _L10
_L10:
        e.queueSecureInputBuffer(t, 0, cryptoinfo, l2, 0);
_L12:
        t = -1;
        x = 0;
        return true;
_L11:
        if (cryptoinfo.numBytesOfClearData == null)
        {
            cryptoinfo.numBytesOfClearData = new int[1];
        }
        ai = cryptoinfo.numBytesOfClearData;
        ai[0] = l1 + ai[0];
          goto _L10
        e.queueInputBuffer(t, 0, k1, l2, 0);
          goto _L12
    }

    private void t()
    {
        s = -1L;
        t = -1;
        u = -1;
        C = true;
        l.clear();
        if (atp.a >= 18)
        {
            e.flush();
        } else
        {
            k();
            i();
        }
        if (w && n != null)
        {
            x = 1;
        }
    }

    protected void a(long l1)
    {
        D = l1;
        i.b(l1);
        f = 0;
        z = false;
        A = false;
        B = false;
    }

    protected final void a(long l1, long l2)
    {
        MediaCodec mediacodec;
        ByteBuffer bytebuffer;
        android.media.MediaCodec.BufferInfo bufferinfo;
        int i1;
        int j1;
        long l3;
        boolean flag;
        if (i.a(l1))
        {
            if (f == 0)
            {
                i1 = 1;
            } else
            {
                try
                {
                    i1 = f;
                }
                catch (IOException ioexception)
                {
                    throw new ank(ioexception);
                }
            }
        } else
        {
            i1 = 0;
        }
        f = i1;
        if (e != null && i.a(y, D, k, j, true) == -5)
        {
            t();
        }
        if (n != null) goto _L2; else goto _L1
_L1:
        if (i.a(y, D, k, j, false) == -4)
        {
            a(k);
        }
_L4:
        b.a();
        return;
_L2:
        if (e != null || j() || super.g != 3)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        j.b = null;
        i1 = -3;
_L7:
        if (i1 != -3) goto _L4; else goto _L3
_L3:
        if (D > l1) goto _L4; else goto _L5
_L5:
        j1 = i.a(y, D, k, j, false);
        if (j1 != -3)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        i1 = j1;
        if (j.f) goto _L7; else goto _L6
_L6:
        D = j.e;
        i1 = j1;
          goto _L7
        i1 = j1;
        if (j1 != -4) goto _L7; else goto _L8
_L8:
        a(k);
        i1 = j1;
          goto _L7
        if (e == null && j())
        {
            i();
        }
        if (e == null) goto _L4; else goto _L9
_L9:
        if (A) goto _L11; else goto _L10
_L10:
        if (u < 0)
        {
            u = e.dequeueOutputBuffer(m, 0L);
        }
        if (u != -2) goto _L13; else goto _L12
_L12:
        a(e.getOutputFormat());
        ane ane1 = b;
        ane1.c = ane1.c + 1;
        i1 = 1;
_L16:
        if (i1 != 0) goto _L9; else goto _L14
_L14:
        if (!a(true)) goto _L4; else goto _L15
_L15:
        while (a(false)) ;
          goto _L4
_L13:
        if (u != -3)
        {
            break MISSING_BLOCK_LABEL_453;
        }
        r = e.getOutputBuffers();
        ane ane2 = b;
        ane2.d = ane2.d + 1;
        i1 = 1;
          goto _L16
        if (u < 0) goto _L11; else goto _L17
_L17:
        if ((m.flags & 4) == 0) goto _L19; else goto _L18
_L18:
        A = true;
          goto _L11
_L19:
        l3 = m.presentationTimeUs;
        j1 = l.size();
        i1 = 0;
_L24:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_654;
        }
        if (((Long)l.get(i1)).longValue() != l3) goto _L21; else goto _L20
_L20:
        mediacodec = e;
        bytebuffer = r[u];
        bufferinfo = m;
        j1 = u;
        if (i1 != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!a(l1, l2, mediacodec, bytebuffer, bufferinfo, j1, flag)) goto _L11; else goto _L22
_L22:
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_619;
        }
        l.remove(i1);
_L23:
        u = -1;
        i1 = 1;
          goto _L16
        D = m.presentationTimeUs;
          goto _L23
_L11:
        i1 = 0;
          goto _L16
_L21:
        i1++;
          goto _L24
        i1 = -1;
          goto _L20
    }

    protected void a(long l1, boolean flag)
    {
        i.a(y, l1);
        f = 0;
        z = false;
        A = false;
        B = false;
        D = l1;
    }

    protected void a(MediaCodec mediacodec, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        mediacodec.configure(mediaformat, null, mediacrypto, 0);
    }

    protected void a(MediaFormat mediaformat)
    {
    }

    protected void a(aoo aoo1)
    {
        aon aon1 = n;
        n = aoo1.a;
        o = aoo1.b;
        if (e != null && a(e, p, aon1, n))
        {
            w = true;
            x = 1;
            return;
        } else
        {
            k();
            i();
            return;
        }
    }

    protected abstract boolean a(long l1, long l2, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i1, boolean flag);

    public boolean a(MediaCodec mediacodec, boolean flag, aon aon1, aon aon2)
    {
        return false;
    }

    protected boolean a(String s1)
    {
        return true;
    }

    protected void b()
    {
    }

    protected void c()
    {
    }

    protected boolean d()
    {
        return A;
    }

    protected boolean e()
    {
label0:
        {
            if (n == null || B)
            {
                break label0;
            }
            if (f == 0 && u < 0)
            {
                boolean flag;
                if (SystemClock.elapsedRealtime() < s + 1000L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    protected long f()
    {
        return D;
    }

    protected void g()
    {
        n = null;
        o = null;
        k();
        if (v)
        {
            a.a();
            v = false;
        }
        i.b(y);
        return;
        Exception exception;
        exception;
        i.b(y);
        throw exception;
        exception;
        if (v)
        {
            a.a();
            v = false;
        }
        i.b(y);
        throw exception;
        exception;
        i.b(y);
        throw exception;
    }

    protected final int h()
    {
        int i1;
        try
        {
            i.a();
        }
        catch (IOException ioexception)
        {
            throw new ank(ioexception);
        }
        for (i1 = 0; i1 < i.b(); i1++)
        {
            if (a(i.a(0).a))
            {
                y = 0;
                return 1;
            }
        }

        return -1;
    }

    protected final void i()
    {
        boolean flag = false;
        if (j()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1 = n.a;
        if (o == null) goto _L4; else goto _L3
_L3:
        int i1;
        if (a == null)
        {
            throw new ank("Media requires a DrmSessionManager");
        }
        if (!v)
        {
            a.a(o, ((String) (obj1)));
            v = true;
        }
        i1 = a.b();
        if (i1 == 0)
        {
            throw new ank(a.d());
        }
        if (i1 != 3 && i1 != 4) goto _L1; else goto _L5
_L5:
        Object obj;
        boolean flag1;
        obj = a.c();
        flag1 = a.a(((String) (obj1)));
_L10:
        String s1;
        aon aon1;
        MediaFormat mediaformat;
        float f1;
        int j1;
        try
        {
            obj1 = aob.a(((String) (obj1)), flag1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            a(new anz(n, ((Throwable) (obj1)), -49998));
            obj1 = null;
        }
        if (obj1 == null)
        {
            a(new anz(n, null, -49999));
        }
        s1 = ((ang) (obj1)).a;
        p = ((ang) (obj1)).b;
        e = MediaCodec.createByCodecName(s1);
        obj1 = e;
        aon1 = n;
        if (aon1.l != null)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        mediaformat = new MediaFormat();
        mediaformat.setString("mime", aon1.a);
        aon.a(mediaformat, "max-input-size", aon1.b);
        aon.a(mediaformat, "width", aon1.c);
        aon.a(mediaformat, "height", aon1.d);
        aon.a(mediaformat, "channel-count", aon1.f);
        aon.a(mediaformat, "sample-rate", aon1.g);
        aon.a(mediaformat, "bitrate", aon1.h);
        f1 = aon1.e;
        j1 = ((flag) ? 1 : 0);
        if (f1 == -1F)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        mediaformat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f1);
        j1 = ((flag) ? 1 : 0);
_L7:
        if (j1 >= aon1.k.size())
        {
            break; /* Loop/switch isn't completed */
        }
        mediaformat.setByteBuffer((new StringBuilder(15)).append("csd-").append(j1).toString(), ByteBuffer.wrap((byte[])aon1.k.get(j1)));
        j1++;
        if (true) goto _L7; else goto _L6
_L6:
        aon1.a(mediaformat);
        aon1.l = mediaformat;
        a(((MediaCodec) (obj1)), aon1.l, ((MediaCrypto) (obj)));
        e.start();
        q = e.getInputBuffers();
        r = e.getOutputBuffers();
_L8:
        long l1;
        if (super.g == 3)
        {
            l1 = SystemClock.elapsedRealtime();
        } else
        {
            l1 = -1L;
        }
        s = l1;
        t = -1;
        u = -1;
        C = true;
        obj = b;
        obj.a = ((ane) (obj)).a + 1;
        return;
        obj;
        a(new anz(n, ((Throwable) (obj)), s1));
          goto _L8
_L4:
        flag1 = false;
        obj = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected boolean j()
    {
        return e == null && n != null;
    }

    protected final void k()
    {
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        s = -1L;
        t = -1;
        u = -1;
        l.clear();
        q = null;
        r = null;
        w = false;
        p = false;
        x = 0;
        ane ane1 = b;
        ane1.b = ane1.b + 1;
        e.stop();
        e.release();
        e = null;
        return;
        Exception exception;
        exception;
        e = null;
        throw exception;
        exception;
        e.release();
        e = null;
        throw exception;
        exception;
        e = null;
        throw exception;
    }

    protected final void l()
    {
        i.d();
    }

    protected final long m()
    {
        return i.a(y).b;
    }

    protected final long n()
    {
        long l1 = i.c();
        if (l1 == -1L || l1 == -3L)
        {
            return l1;
        } else
        {
            return Math.max(l1, f());
        }
    }
}
