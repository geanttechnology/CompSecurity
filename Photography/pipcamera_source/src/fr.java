// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import com.fotoable.comlib.util.AsyncTask;
import com.fotoable.comlib.util.ImageCache;
import java.util.concurrent.Executor;

public abstract class fr
{

    private ImageCache a;
    private fo b;
    protected boolean c;
    protected Resources d;
    protected Executor e;
    private Bitmap f;
    private boolean g;
    private boolean h;
    private final Object i = new Object();

    protected fr(Context context)
    {
        g = false;
        h = false;
        c = false;
        d = context.getResources();
        e = AsyncTask.THREAD_POOL_EXECUTOR;
    }

    static Object a(fr fr1)
    {
        return fr1.i;
    }

    public static void a(ImageView imageview)
    {
        imageview = c(imageview);
        if (imageview != null)
        {
            imageview.a(true);
        }
    }

    private void a(ImageView imageview, Drawable drawable)
    {
        if (g)
        {
            drawable = new TransitionDrawable(new Drawable[] {
                new ColorDrawable(0x106000d), drawable
            });
            imageview.setBackgroundDrawable(new BitmapDrawable(d, f));
            imageview.setImageDrawable(drawable);
            drawable.startTransition(200);
            return;
        } else
        {
            imageview.setImageDrawable(drawable);
            return;
        }
    }

    static void a(fr fr1, ImageView imageview, Drawable drawable)
    {
        fr1.a(imageview, drawable);
    }

    static ImageCache b(fr fr1)
    {
        return fr1.a;
    }

    static ft b(ImageView imageview)
    {
        return c(imageview);
    }

    public static boolean b(Object obj, ImageView imageview)
    {
label0:
        {
            imageview = c(imageview);
            if (imageview != null)
            {
                Object obj1 = ft.a(imageview);
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

    private static ft c(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof fs)
            {
                return ((fs)imageview).a();
            }
        }
        return null;
    }

    static boolean c(fr fr1)
    {
        return fr1.h;
    }

    protected abstract Bitmap a(Object obj);

    protected void a()
    {
        if (a != null)
        {
            a.a();
        }
    }

    public void a(android.graphics.Bitmap.CompressFormat compressformat)
    {
        if (a != null)
        {
            a.e().d = compressformat;
        }
    }

    public void a(FragmentManager fragmentmanager, fo fo1)
    {
        b = fo1;
        a = ImageCache.a(fragmentmanager, b);
        (new fu(this)).execute(new Object[] {
            Integer.valueOf(1)
        });
    }

    public void a(Object obj, ImageView imageview)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
label0:
        {
            if (a == null)
            {
                break; /* Loop/switch isn't completed */
            }
            BitmapDrawable bitmapdrawable = a.a(b(obj));
            obj1 = bitmapdrawable;
            if (bitmapdrawable == null)
            {
                break label0;
            }
            if (bitmapdrawable.getBitmap() != null)
            {
                obj1 = bitmapdrawable;
                if (bitmapdrawable.getBitmap() == null)
                {
                    break label0;
                }
                obj1 = bitmapdrawable;
                if (!bitmapdrawable.getBitmap().isRecycled())
                {
                    break label0;
                }
            }
            obj1 = null;
        }
_L4:
        if (obj1 != null)
        {
            imageview.setImageDrawable(((Drawable) (obj1)));
            return;
        }
        if (b(obj, imageview))
        {
            obj1 = new ft(this, imageview);
            imageview.setImageDrawable(new fs(d, f, ((ft) (obj1))));
            ((ft) (obj1)).a(e, new Object[] {
                obj
            });
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj1 = null;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(boolean flag)
    {
        h = flag;
        b(false);
    }

    protected String b(Object obj)
    {
        return String.valueOf(obj);
    }

    protected void b()
    {
        if (a != null)
        {
            a.b();
        }
    }

    public void b(int k)
    {
        f = BitmapFactory.decodeResource(d, k);
    }

    public void b(boolean flag)
    {
        synchronized (i)
        {
            c = flag;
            if (!c)
            {
                i.notifyAll();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void c()
    {
        if (a != null)
        {
            a.c();
        }
    }

    protected void d()
    {
        if (a != null)
        {
            a.d();
            a = null;
        }
    }

    public final Bitmap f()
    {
        return f;
    }

    public ImageCache g()
    {
        return a;
    }

    public void h()
    {
        (new fu(this)).execute(new Object[] {
            Integer.valueOf(0)
        });
    }

    public void i()
    {
        (new fu(this)).execute(new Object[] {
            Integer.valueOf(2)
        });
    }

    public void j()
    {
        (new fu(this)).execute(new Object[] {
            Integer.valueOf(3)
        });
    }
}
