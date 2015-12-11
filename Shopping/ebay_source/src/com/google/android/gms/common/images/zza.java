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
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkj;
import java.lang.ref.WeakReference;

public abstract class com.google.android.gms.common.images.zza
{
    static final class zza
    {

        public final Uri uri;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof zza))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            } else
            {
                return zzt.equal(((zza)obj).uri, uri);
            }
        }

        public int hashCode()
        {
            return zzt.hashCode(new Object[] {
                uri
            });
        }

        public zza(Uri uri1)
        {
            uri = uri1;
        }
    }

    public static final class zzc extends com.google.android.gms.common.images.zza
    {

        private WeakReference zzZm;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof zzc))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (zzc)obj;
            ImageManager.OnImageLoadedListener onimageloadedlistener = (ImageManager.OnImageLoadedListener)zzZm.get();
            ImageManager.OnImageLoadedListener onimageloadedlistener1 = (ImageManager.OnImageLoadedListener)((zzc) (obj)).zzZm.get();
            boolean flag;
            if (onimageloadedlistener1 != null && onimageloadedlistener != null && zzt.equal(onimageloadedlistener1, onimageloadedlistener) && zzt.equal(((zzc) (obj)).zzZc, zzZc))
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
            return zzt.hashCode(new Object[] {
                zzZc
            });
        }

        protected void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
        {
            if (!flag1)
            {
                ImageManager.OnImageLoadedListener onimageloadedlistener = (ImageManager.OnImageLoadedListener)zzZm.get();
                if (onimageloadedlistener != null)
                {
                    onimageloadedlistener.onImageLoaded(zzZc.uri, drawable, flag2);
                }
            }
        }
    }


    final zza zzZc;
    protected int zzZe;
    protected ImageManager.OnImageLoadedListener zzZg;
    protected int zzZk;

    private Drawable zza(Context context, zzkj zzkj1, int i)
    {
        Resources resources = context.getResources();
        if (zzZk > 0)
        {
            com.google.android.gms.internal.zzkj.zza zza1 = new com.google.android.gms.internal.zzkj.zza(i, zzZk);
            Drawable drawable = (Drawable)zzkj1.get(zza1);
            context = drawable;
            if (drawable == null)
            {
                Drawable drawable1 = resources.getDrawable(i);
                context = drawable1;
                if ((zzZk & 1) != 0)
                {
                    context = zza(resources, drawable1);
                }
                zzkj1.put(zza1, context);
            }
            return context;
        } else
        {
            return resources.getDrawable(i);
        }
    }

    protected Drawable zza(Resources resources, Drawable drawable)
    {
        return zzkh.zza(resources, drawable);
    }

    void zza(Context context, Bitmap bitmap, boolean flag)
    {
        zzb.zzq(bitmap);
        Bitmap bitmap1 = bitmap;
        if ((zzZk & 1) != 0)
        {
            bitmap1 = zzkh.zza(bitmap);
        }
        context = new BitmapDrawable(context.getResources(), bitmap1);
        if (zzZg != null)
        {
            zzZg.onImageLoaded(zzZc.uri, context, true);
        }
        zza(((Drawable) (context)), flag, false, true);
    }

    void zza(Context context, zzkj zzkj1, boolean flag)
    {
        Drawable drawable = null;
        if (zzZe != 0)
        {
            drawable = zza(context, zzkj1, zzZe);
        }
        if (zzZg != null)
        {
            zzZg.onImageLoaded(zzZc.uri, drawable, false);
        }
        zza(drawable, flag, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2);
}
