// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            ajk, ajt, aix

public abstract class ajm
    implements ajk
{

    protected Reference a;
    protected boolean b;

    public ajm(View view)
    {
        this(view, true);
    }

    public ajm(View view, boolean flag)
    {
        if (view == null)
        {
            throw new IllegalArgumentException("view must not be null");
        } else
        {
            a = new WeakReference(view);
            b = flag;
            return;
        }
    }

    public int a()
    {
        View view = (View)a.get();
        if (view != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            int i;
            int j;
            if (b && layoutparams != null && layoutparams.width != -2)
            {
                i = view.getWidth();
            } else
            {
                i = 0;
            }
            j = i;
            if (i <= 0)
            {
                j = i;
                if (layoutparams != null)
                {
                    j = layoutparams.width;
                }
            }
            return j;
        } else
        {
            return 0;
        }
    }

    protected abstract void a(Bitmap bitmap, View view);

    protected abstract void a(Drawable drawable, View view);

    public boolean a(Bitmap bitmap)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            View view = (View)a.get();
            if (view != null)
            {
                a(bitmap, view);
                return true;
            }
        } else
        {
            ajt.c("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public boolean a(Drawable drawable)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            View view = (View)a.get();
            if (view != null)
            {
                a(drawable, view);
                return true;
            }
        } else
        {
            ajt.c("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public int b()
    {
        View view = (View)a.get();
        if (view != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            int i;
            int j;
            if (b && layoutparams != null && layoutparams.height != -2)
            {
                i = view.getHeight();
            } else
            {
                i = 0;
            }
            j = i;
            if (i <= 0)
            {
                j = i;
                if (layoutparams != null)
                {
                    j = layoutparams.height;
                }
            }
            return j;
        } else
        {
            return 0;
        }
    }

    public aix c()
    {
        return aix.b;
    }

    public View d()
    {
        return (View)a.get();
    }

    public boolean e()
    {
        return a.get() == null;
    }

    public int f()
    {
        View view = (View)a.get();
        if (view == null)
        {
            return super.hashCode();
        } else
        {
            return view.hashCode();
        }
    }
}
