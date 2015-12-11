// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.c.a.b.a.l;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

// Referenced classes of package com.c.a.b.e:
//            a

public class c
    implements a
{

    protected Reference a;
    protected boolean b;

    public c(ImageView imageview)
    {
        this(imageview, true);
    }

    public c(ImageView imageview, boolean flag)
    {
        a = new WeakReference(imageview);
        b = flag;
    }

    private static int a(Object obj, String s)
    {
        int i;
        s = android/widget/ImageView.getDeclaredField(s);
        s.setAccessible(true);
        i = ((Integer)s.get(obj)).intValue();
        if (i > 0 && i < 0x7fffffff)
        {
            return i;
        }
        break MISSING_BLOCK_LABEL_41;
        obj;
        com.c.a.c.c.a(((Throwable) (obj)));
        return 0;
    }

    public int a()
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = imageview.getLayoutParams();
            int i;
            int j;
            if (b && layoutparams != null && layoutparams.width != -2)
            {
                i = imageview.getWidth();
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
            if (j <= 0)
            {
                i = a(imageview, "mMaxWidth");
            } else
            {
                i = j;
            }
            com.c.a.c.c.c((new StringBuilder()).append("width = ").append(i).toString(), new Object[0]);
            return i;
        } else
        {
            return 0;
        }
    }

    public boolean a(Bitmap bitmap)
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview != null)
        {
            imageview.setImageBitmap(bitmap);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a(Drawable drawable)
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview != null)
        {
            imageview.setImageDrawable(drawable);
            return true;
        } else
        {
            return false;
        }
    }

    public int b()
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = imageview.getLayoutParams();
            int i;
            int j;
            if (b && layoutparams != null && layoutparams.height != -2)
            {
                i = imageview.getHeight();
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
            if (j <= 0)
            {
                i = a(imageview, "mMaxHeight");
            } else
            {
                i = j;
            }
            com.c.a.c.c.c((new StringBuilder()).append("height = ").append(i).toString(), new Object[0]);
            return i;
        } else
        {
            return 0;
        }
    }

    public l c()
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview != null)
        {
            return l.a(imageview);
        } else
        {
            return null;
        }
    }

    public View d()
    {
        return g();
    }

    public boolean e()
    {
        return a.get() == null;
    }

    public int f()
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview == null)
        {
            return super.hashCode();
        } else
        {
            return imageview.hashCode();
        }
    }

    public ImageView g()
    {
        return (ImageView)a.get();
    }
}
