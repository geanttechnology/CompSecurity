// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.Reference;
import java.lang.reflect.Field;

// Referenced classes of package android.support.v7:
//            ajm, ajt, aix

public class ajl extends ajm
{

    public ajl(ImageView imageview)
    {
        super(imageview);
    }

    public ajl(ImageView imageview, boolean flag)
    {
        super(imageview, flag);
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
        ajt.a(((Throwable) (obj)));
        return 0;
    }

    public int a()
    {
        int i = super.a();
        if (i <= 0)
        {
            ImageView imageview = (ImageView)a.get();
            if (imageview != null)
            {
                return a(imageview, "mMaxWidth");
            }
        }
        return i;
    }

    protected void a(Bitmap bitmap, View view)
    {
        ((ImageView)view).setImageBitmap(bitmap);
    }

    protected void a(Drawable drawable, View view)
    {
        ((ImageView)view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable)
        {
            ((AnimationDrawable)drawable).start();
        }
    }

    public int b()
    {
        int i = super.b();
        if (i <= 0)
        {
            ImageView imageview = (ImageView)a.get();
            if (imageview != null)
            {
                return a(imageview, "mMaxHeight");
            }
        }
        return i;
    }

    public aix c()
    {
        ImageView imageview = (ImageView)a.get();
        if (imageview != null)
        {
            return aix.a(imageview);
        } else
        {
            return super.c();
        }
    }

    public View d()
    {
        return g();
    }

    public ImageView g()
    {
        return (ImageView)super.d();
    }
}
