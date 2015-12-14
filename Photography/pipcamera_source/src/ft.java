// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.comlib.util.UgentAsyncTask;
import java.lang.ref.WeakReference;

class ft extends UgentAsyncTask
{

    final fr a;
    private Object e;
    private final WeakReference f;

    public ft(fr fr1, ImageView imageview)
    {
        a = fr1;
        super();
        f = new WeakReference(imageview);
    }

    static Object a(ft ft1)
    {
        return ft1.e;
    }

    private ImageView d()
    {
        ImageView imageview = (ImageView)f.get();
        if (this == fr.b(imageview))
        {
            return imageview;
        } else
        {
            return null;
        }
    }

    protected transient BitmapDrawable a(Object aobj[])
    {
        Object obj2;
        String s;
        obj2 = null;
        e = aobj[0];
        s = a.b(e);
        Object obj = fr.a(a);
        obj;
        JVM INSTR monitorenter ;
_L4:
        if (!a.c) goto _L2; else goto _L1
_L1:
        boolean flag = c();
        if (flag) goto _L2; else goto _L3
_L3:
        try
        {
            fr.a(a).wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L4; else goto _L2
_L2:
        obj;
        JVM INSTR monitorexit ;
        Object obj1;
        if (fr.b(a) != null && !c() && d() != null && !fr.c(a))
        {
            Bitmap bitmap = fr.b(a).b(s);
            obj = bitmap;
            if (bitmap != null)
            {
                obj = bitmap;
                if (bitmap.isRecycled())
                {
                    obj = null;
                }
            }
        } else
        {
            obj = null;
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (!c())
            {
                obj1 = obj;
                if (d() != null)
                {
                    obj1 = obj;
                    if (!fr.c(a))
                    {
                        obj1 = a.a(aobj[0]);
                    }
                }
            }
        }
        obj = obj2;
        if (obj1 != null)
        {
            if (gb.c())
            {
                aobj = new fv(a.d, ((Bitmap) (obj1)));
            } else
            {
                aobj = new fw(a.d, ((Bitmap) (obj1)));
            }
            obj = ((Object) (aobj));
            if (fr.b(a) != null)
            {
                fr.b(a).a(s, ((BitmapDrawable) (aobj)));
                obj = ((Object) (aobj));
            }
        }
        return ((BitmapDrawable) (obj));
        obj;
        JVM INSTR monitorexit ;
        throw aobj;
    }

    protected void a(BitmapDrawable bitmapdrawable)
    {
        if (c() || fr.c(a))
        {
            bitmapdrawable = null;
        }
        ImageView imageview = d();
        if (bitmapdrawable != null && imageview != null)
        {
            fr.a(a, imageview, bitmapdrawable);
        }
    }

    protected void a(Object obj)
    {
        b((BitmapDrawable)obj);
    }

    protected Object b(Object aobj[])
    {
        return a(aobj);
    }

    protected void b(BitmapDrawable bitmapdrawable)
    {
        super.a(bitmapdrawable);
        synchronized (fr.a(a))
        {
            fr.a(a).notifyAll();
        }
        return;
        exception;
        bitmapdrawable;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void b(Object obj)
    {
        a((BitmapDrawable)obj);
    }
}
