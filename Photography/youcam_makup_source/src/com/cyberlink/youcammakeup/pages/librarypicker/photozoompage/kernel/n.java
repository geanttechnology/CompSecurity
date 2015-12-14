// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            p, o, j, q, 
//            AsyncTask, k

public abstract class n
{

    private j a;
    private k b;
    protected boolean c;
    protected Resources d;
    private Bitmap e;
    private boolean f;
    private boolean g;
    private final Object h = new Object();

    public n(Context context)
    {
        f = true;
        g = false;
        c = false;
        d = context.getResources();
    }

    static p a(ImageView imageview)
    {
        return b(imageview);
    }

    static Object a(n n1)
    {
        return n1.h;
    }

    protected static String a(String s)
    {
        File file = new File(s);
        return (new StringBuilder(s)).append("_").append(file.lastModified()).toString();
    }

    private void a(ImageView imageview, Drawable drawable)
    {
        if (f)
        {
            drawable = new TransitionDrawable(new Drawable[] {
                new ColorDrawable(0x106000d), drawable
            });
            imageview.setBackgroundDrawable(new BitmapDrawable(d, e));
            imageview.setImageDrawable(drawable);
            drawable.startTransition(200);
        } else
        {
            imageview.setImageDrawable(drawable);
        }
        imageview.postInvalidate();
    }

    static void a(n n1, ImageView imageview, Drawable drawable)
    {
        n1.a(imageview, drawable);
    }

    public static boolean a(Object obj, ImageView imageview)
    {
label0:
        {
            imageview = b(imageview);
            if (imageview != null)
            {
                Object obj1 = p.a(imageview);
                if (obj1 != null && obj1.equals(obj))
                {
                    break label0;
                }
                imageview.a(true);
            }
            return true;
        }
        return false;
    }

    static j b(n n1)
    {
        return n1.a;
    }

    private static p b(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof o)
            {
                return ((o)imageview).a();
            }
        }
        return null;
    }

    static boolean c(n n1)
    {
        return n1.g;
    }

    protected abstract Bitmap a(Object obj, boolean flag);

    protected j a()
    {
        return a;
    }

    public void a(int i)
    {
        e = BitmapFactory.decodeResource(d, i);
    }

    public void a(FragmentManager fragmentmanager, k k)
    {
        b = k;
        a = j.a(fragmentmanager, b);
        (new q(this)).c(new Object[] {
            Integer.valueOf(1)
        });
    }

    public void a(Object obj, ImageView imageview, Object obj1)
    {
        if (obj != null)
        {
            BitmapDrawable bitmapdrawable = null;
            if (a != null)
            {
                bitmapdrawable = a.a(a(String.valueOf(obj)));
            }
            if (bitmapdrawable != null)
            {
                imageview.setImageDrawable(bitmapdrawable);
                return;
            }
            if (a(obj, imageview))
            {
                p p1 = new p(this, imageview);
                imageview.setImageDrawable(new o(d, e, p1));
                p1.a(AsyncTask.c, new Object[] {
                    obj, obj1
                });
                return;
            }
        }
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    protected void b()
    {
        if (a != null)
        {
            a.a();
        }
    }

    public void b(boolean flag)
    {
        g = flag;
        c(false);
    }

    protected void c()
    {
        if (a != null)
        {
            a.b();
        }
    }

    public void c(boolean flag)
    {
        synchronized (h)
        {
            c = flag;
            if (!c)
            {
                h.notifyAll();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void d()
    {
        if (a != null)
        {
            a.c();
        }
    }

    protected void e()
    {
        if (a != null)
        {
            a.d();
            a = null;
        }
    }

    public void f()
    {
        (new q(this)).c(new Object[] {
            Integer.valueOf(0)
        });
    }

    public void g()
    {
        (new q(this)).c(new Object[] {
            Integer.valueOf(2)
        });
    }

    public void h()
    {
        (new q(this)).c(new Object[] {
            Integer.valueOf(3)
        });
    }
}
