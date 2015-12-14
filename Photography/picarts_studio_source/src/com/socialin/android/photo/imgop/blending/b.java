// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop.blending;

import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.PyramidBlender;
import java.nio.ByteBuffer;

// Referenced classes of package com.socialin.android.photo.imgop.blending:
//            BlendingActivity

public final class b
    implements Runnable
{

    public volatile boolean a;
    ByteBuffer b;
    ByteBuffer c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    private Thread j;
    private ByteBuffer k;
    private ByteBuffer l;
    private int m;
    private int n;
    private BlendingActivity o;

    public b(BlendingActivity blendingactivity)
    {
        j = new Thread(this);
        a = true;
        f = 0;
        g = 0;
        h = 0;
        new PyramidBlender();
        i = false;
        o = blendingactivity;
        j.setName("Pyramid Blender Thread");
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        ByteBuffer bytebuffer;
        ByteBuffer bytebuffer1;
        int j1;
        int k1;
        int l1;
        j1 = o.a;
        bytebuffer = b;
        bytebuffer1 = k;
        k1 = m;
        l1 = n;
        int i1 = 0;
_L2:
        if (i1 >= k1 * l1)
        {
            break; /* Loop/switch isn't completed */
        }
        byte byte1 = bytebuffer.get(i1);
        byte byte0;
        byte0 = byte1;
        if (byte1 > 0)
        {
            byte0 = -1;
        }
        bytebuffer1.put(i1 * 4 + 3, byte0);
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        l = ImageOp.a(d * 4 * e);
        PyramidBlender.putOverlay(c, d, e, k, m, n, l, d, e, f, g, h, j1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(ByteBuffer bytebuffer, int i1, int j1)
    {
        k = bytebuffer;
        m = i1;
        n = j1;
    }

    public final void run()
    {
        a = false;
        a();
        o.a(l, i);
        a = true;
    }
}
