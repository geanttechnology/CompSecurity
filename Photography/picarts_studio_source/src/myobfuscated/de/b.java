// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.de;

import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import myobfuscated.dd.a;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.de:
//            c

public final class b
    implements android.hardware.Camera.PreviewCallback
{

    public GLSurfaceView a;
    public a b;
    private ByteBuffer c;
    private ByteBuffer d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Object j;
    private c k;
    private Camera l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private volatile long q;

    public b()
    {
        e = 256;
        f = 240;
        g = 160;
        h = f * g;
        i = 1;
        j = new Object();
        k = null;
        m = false;
        n = false;
        o = false;
        p = false;
        a = null;
        b = null;
    }

    public static int a(List list)
    {
        list = list.iterator();
        byte byte0 = -1;
        do
        {
            Integer integer;
label0:
            {
                byte byte1 = byte0;
                if (list.hasNext())
                {
                    integer = (Integer)list.next();
                    if (integer.intValue() != 17)
                    {
                        break label0;
                    }
                    byte1 = 17;
                }
                return byte1;
            }
            if (integer.intValue() == 16)
            {
                byte0 = 16;
            }
        } while (true);
    }

    static long a(b b1)
    {
        return b1.q;
    }

    private void a(int i1)
    {
        Object obj = j;
        obj;
        JVM INSTR monitorenter ;
        i = i1;
        if (b == null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 1: default 82
    //                   0 47
    //                   1 67;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_67;
_L2:
        return;
_L4:
        b.a(6407);
          goto _L2
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        b.a(6409);
          goto _L2
    }

    static boolean a(b b1, boolean flag)
    {
        b1.o = flag;
        return flag;
    }

    static Object b(b b1)
    {
        return b1.j;
    }

    static int c(b b1)
    {
        return b1.i;
    }

    static ByteBuffer d(b b1)
    {
        return b1.d;
    }

    private void d()
    {
        if (c != null)
        {
            ImageOpCommon.freeNativeBuffer(c);
            c = null;
        }
        if (d != null)
        {
            ImageOpCommon.freeNativeBuffer(d);
            d = null;
        }
    }

    static ByteBuffer e(b b1)
    {
        return b1.c;
    }

    static boolean f(b b1)
    {
        return b1.n;
    }

    static int g(b b1)
    {
        return b1.f;
    }

    static int h(b b1)
    {
        return b1.g;
    }

    static int i(b b1)
    {
        return b1.e;
    }

    static boolean j(b b1)
    {
        return b1.p;
    }

    static void k(b b1)
    {
        b1.d();
    }

    static GLSurfaceView l(b b1)
    {
        return b1.a;
    }

    public final void a()
    {
        q = System.currentTimeMillis();
        if (k != null)
        {
            k.b = false;
        }
        k = new c(this, b, q);
        k.start();
        m = true;
    }

    public final boolean a(Camera camera)
    {
        boolean flag = true;
        byte abyte0[] = camera.getParameters();
        if (abyte0.getPreviewFormat() == 17)
        {
            a(0);
        } else
        if (abyte0.getPreviewFormat() == 16)
        {
            a(1);
        } else
        {
            a(1);
            flag = false;
        }
        abyte0 = abyte0.getPreviewSize();
        f = ((android.hardware.Camera.Size) (abyte0)).width;
        g = ((android.hardware.Camera.Size) (abyte0)).height;
        e = myobfuscated.f.m.a(Math.max(f, g));
        h = f * g;
        if (c != null)
        {
            ImageOpCommon.freeNativeBuffer(c);
            c = null;
        }
        if (d != null)
        {
            ImageOpCommon.freeNativeBuffer(d);
            d = null;
        }
        c = ImageOpCommon.allocNativeBuffer(h * 3);
        d = ImageOpCommon.allocNativeBuffer(h * 3);
        abyte0 = new byte[h * 3];
        b.a(e, f, g);
        camera.addCallbackBuffer(abyte0);
        camera.setPreviewCallbackWithBuffer(this);
        return flag;
    }

    public final void b()
    {
        if (k != null)
        {
            k.b = false;
            k = null;
        }
        m = false;
    }

    public final void c()
    {
        n = true;
        if (!o)
        {
            d();
            return;
        } else
        {
            p = true;
            return;
        }
    }

    public final void onPreviewFrame(byte abyte0[], Camera camera)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = m;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (abyte0 != null) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        c c1;
        if (l == null)
        {
            l = camera;
        }
        c1 = k;
        if (c1.getState() != Thread.State.WAITING || abyte0.length != c1.c.c.capacity()) goto _L2; else goto _L5
_L5:
        if (c1.c.c == null || c1.c.n) goto _L7; else goto _L6
_L6:
        c1.c.c.position(0);
        c1.c.c.put(abyte0);
        c1.a = true;
_L7:
        c1;
        JVM INSTR monitorenter ;
        c1.notify();
        c1;
        JVM INSTR monitorexit ;
_L2:
        camera.addCallbackBuffer(abyte0);
        if (true) goto _L3; else goto _L8
_L8:
        abyte0;
        throw abyte0;
        abyte0;
        c1;
        JVM INSTR monitorexit ;
        throw abyte0;
    }
}
