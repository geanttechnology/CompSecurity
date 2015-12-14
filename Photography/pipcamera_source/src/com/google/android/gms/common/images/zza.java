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
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkj;

public abstract class zza
{

    final zza zzZc;
    protected int zzZd;
    protected int zzZe;
    protected boolean zzZf;
    protected ImageManager.OnImageLoadedListener zzZg;
    private boolean zzZh;
    private boolean zzZi;
    private boolean zzZj;
    protected int zzZk;

    public com.google.android.gms.common.images.zza(Uri uri, int i)
    {
        zzZd = 0;
        zzZe = 0;
        zzZf = false;
        zzZh = true;
        zzZi = false;
        zzZj = true;
        zzZc = new zza(uri);
        zzZe = i;
    }

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

    protected zzkg zza(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof zzkg)
            {
                drawable2 = ((zzkg)drawable).zznp();
            }
        } else
        {
            drawable2 = null;
        }
        return new zzkg(drawable2, drawable1);
    }

    void zza(Context context, Bitmap bitmap, boolean flag)
    {
        com.google.android.gms.common.internal.zzb.zzq(bitmap);
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

    void zza(Context context, zzkj zzkj1)
    {
        if (zzZj)
        {
            Drawable drawable = null;
            if (zzZd != 0)
            {
                drawable = zza(context, zzkj1, zzZd);
            }
            zza(drawable, false, true, false);
        }
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

    protected boolean zzb(boolean flag, boolean flag1)
    {
        return zzZh && !flag1 && (!flag || zzZi);
    }

    public void zzbm(int i)
    {
        zzZe = i;
    }

    private class zza
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

}
