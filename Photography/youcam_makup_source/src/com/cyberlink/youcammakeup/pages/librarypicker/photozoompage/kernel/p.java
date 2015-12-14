// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a.b;
import java.lang.ref.WeakReference;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            AsyncTask, n, j

class p extends AsyncTask
{

    final n d;
    private Object e;
    private Object f;
    private final WeakReference g;

    public p(n n1, ImageView imageview)
    {
        d = n1;
        super();
        g = new WeakReference(imageview);
    }

    static Object a(p p1)
    {
        return p1.e;
    }

    private ImageView d()
    {
        ImageView imageview = (ImageView)g.get();
        if (this == n.a(imageview))
        {
            return imageview;
        } else
        {
            return null;
        }
    }

    protected Object a(Object aobj[])
    {
        return d(aobj);
    }

    protected void a(BitmapDrawable bitmapdrawable)
    {
        if (c() || n.c(d))
        {
            bitmapdrawable = null;
        }
        ImageView imageview = d();
        if (bitmapdrawable != null && imageview != null)
        {
            n.a(d, imageview, bitmapdrawable);
        }
    }

    protected volatile void a(Object obj)
    {
        a((BitmapDrawable)obj);
    }

    protected void b(BitmapDrawable bitmapdrawable)
    {
        super.b(bitmapdrawable);
        synchronized (n.a(d))
        {
            n.a(d).notifyAll();
        }
        return;
        exception;
        bitmapdrawable;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected volatile void b(Object obj)
    {
        b((BitmapDrawable)obj);
    }

    protected transient BitmapDrawable d(Object aobj[])
    {
        String s;
        boolean flag;
        e = aobj[0];
        f = aobj[1];
        s = String.valueOf(e);
        flag = ((Boolean)f).booleanValue();
        Object obj = n.a(d);
        obj;
        JVM INSTR monitorenter ;
_L4:
        if (!d.c) goto _L2; else goto _L1
_L1:
        boolean flag1 = c();
        if (flag1) goto _L2; else goto _L3
_L3:
        try
        {
            n.a(d).wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L4; else goto _L2
_L2:
        obj;
        JVM INSTR monitorexit ;
        if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.n.b(d) != null && !c() && d() != null && !n.c(d))
        {
            obj = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.n.b(d).b(n.a(s));
        } else
        {
            obj = null;
        }
        if (obj == null && !c() && d() != null && !n.c(d))
        {
            aobj = d.a(aobj[0], flag);
        } else
        {
            aobj = ((Object []) (obj));
        }
        if (aobj != null)
        {
            if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a.b.e())
            {
                aobj = new BitmapDrawable(d.d, ((android.graphics.Bitmap) (aobj)));
            } else
            {
                aobj = new com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view.b(d.d, ((android.graphics.Bitmap) (aobj)));
            }
            if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.n.b(d) != null)
            {
                com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.n.b(d).a(n.a(s), ((BitmapDrawable) (aobj)));
            }
            return ((BitmapDrawable) (aobj));
        } else
        {
            return null;
        }
        obj;
        JVM INSTR monitorexit ;
        throw aobj;
    }
}
