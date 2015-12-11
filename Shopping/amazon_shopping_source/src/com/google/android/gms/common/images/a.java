// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.lang.ref.WeakReference;

public abstract class com.google.android.gms.common.images.a
{
    static final class a
    {

        public final Uri uri;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof a))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            } else
            {
                return hk.equal(((a)obj).uri, uri);
            }
        }

        public int hashCode()
        {
            return hk.hashCode(new Object[] {
                uri
            });
        }

        public a(Uri uri1)
        {
            uri = uri1;
        }
    }

    public static final class c extends com.google.android.gms.common.images.a
    {

        private WeakReference Ft;

        protected void a(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
        {
            if (!flag1)
            {
                ImageManager.OnImageLoadedListener onimageloadedlistener = (ImageManager.OnImageLoadedListener)Ft.get();
                if (onimageloadedlistener != null)
                {
                    onimageloadedlistener.onImageLoaded(Fm.uri, drawable, flag2);
                }
            }
        }

        public boolean equals(Object obj)
        {
            if (!(obj instanceof c))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (c)obj;
            ImageManager.OnImageLoadedListener onimageloadedlistener = (ImageManager.OnImageLoadedListener)Ft.get();
            ImageManager.OnImageLoadedListener onimageloadedlistener1 = (ImageManager.OnImageLoadedListener)((c) (obj)).Ft.get();
            boolean flag;
            if (onimageloadedlistener1 != null && onimageloadedlistener != null && hk.equal(onimageloadedlistener1, onimageloadedlistener) && hk.equal(((c) (obj)).Fm, Fm))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }

        public int hashCode()
        {
            return hk.hashCode(new Object[] {
                Fm
            });
        }
    }


    final a Fm;
    protected int Fo;
    protected int Fr;

    private Drawable a(Context context, gw gw1, int i)
    {
        Resources resources = context.getResources();
        if (Fr > 0)
        {
            com.google.android.gms.internal.gw.a a1 = new com.google.android.gms.internal.gw.a(i, Fr);
            Drawable drawable = (Drawable)gw1.get(a1);
            context = drawable;
            if (drawable == null)
            {
                Drawable drawable1 = resources.getDrawable(i);
                context = drawable1;
                if ((Fr & 1) != 0)
                {
                    context = a(resources, drawable1);
                }
                gw1.put(a1, context);
            }
            return context;
        } else
        {
            return resources.getDrawable(i);
        }
    }

    protected Drawable a(Resources resources, Drawable drawable)
    {
        return gu.a(resources, drawable);
    }

    void a(Context context, Bitmap bitmap, boolean flag)
    {
        gx.c(bitmap);
        Bitmap bitmap1 = bitmap;
        if ((Fr & 1) != 0)
        {
            bitmap1 = gu.a(bitmap);
        }
        a(((Drawable) (new BitmapDrawable(context.getResources(), bitmap1))), flag, false, true);
    }

    void a(Context context, gw gw1, boolean flag)
    {
        Drawable drawable = null;
        if (Fo != 0)
        {
            drawable = a(context, gw1, Fo);
        }
        a(drawable, flag, false, false);
    }

    protected abstract void a(Drawable drawable, boolean flag, boolean flag1, boolean flag2);
}
