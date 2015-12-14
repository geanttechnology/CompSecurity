// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;
import com.pf.common.utility.Bitmaps;
import com.pf.common.utility.d;
import com.pf.common.utility.m;
import com.pf.common.utility.s;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pf.common.a:
//            j, c, h

class l extends j
{

    final File g;
    boolean h;
    final c i;
    private String j;

    private l(c c1, String s1)
    {
        i = c1;
        super(c1, s1);
        j = "";
        g = new File(com.pf.common.a.c.d(c1), (new StringBuilder()).append(a).append(com.pf.common.a.c.e(c1).a()).toString());
    }

    l(c c1, String s1, c._cls1 _pcls1)
    {
        this(c1, s1);
    }

    private void f()
    {
        File file = g.getParentFile();
        if (file.mkdirs() || file.isDirectory())
        {
            (new File(file, ".nomedia")).createNewFile();
        }
    }

    void a(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        if (!h) goto _L2; else goto _L1
_L1:
        m.b("BitmapSwap", (new StringBuilder()).append("swapOut (skipped) ").append(a).append(" => ").append(g.getAbsolutePath()).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        m.b("BitmapSwap", (new StringBuilder()).append("swapOut ").append(a).append(" => ").append(g.getAbsolutePath()).toString());
        f();
        com.pf.common.a.c.e(i).a(bitmap, g);
        h = true;
        if (true) goto _L4; else goto _L3
_L3:
        bitmap;
        throw s.a(bitmap);
        bitmap;
        this;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    public void b(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        d();
        c();
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        com.pf.common.a.c.c(i).put(this, bitmap);
        b = new WeakReference(bitmap);
        j = m.a(new Throwable());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        com.pf.common.a.c.c(i).remove(this);
        if (true) goto _L4; else goto _L3
_L3:
        bitmap;
        throw bitmap;
    }

    void c()
    {
        if (g.delete())
        {
            m.b("BitmapSwap", (new StringBuilder()).append("deleteSwap ").append(a).append(" => ").append(g.getAbsolutePath()).toString());
        }
        h = false;
    }

    Bitmap e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = h;
        if (flag) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return bitmap;
_L2:
        m.b("BitmapSwap", (new StringBuilder()).append("swapIn ").append(a).append(" => ").append(g.getAbsolutePath()).toString());
        bitmap = com.pf.common.a.c.e(i).a(g, Bitmaps.a);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        return (new StringBuilder()).append("BitmapSwap.SwapFileEntity [mID=").append(a).append(", mSwapFile=").append(g).append(", mSwapped=").append(h).append(", mDeleted=").append(c).append(", mCreatedBy=").append(d).append(", mSetBy=").append(j).append("]").toString();
    }
}
