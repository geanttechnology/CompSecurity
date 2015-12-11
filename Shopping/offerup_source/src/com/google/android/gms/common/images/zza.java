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
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlv;

public abstract class zza
{

    final zza zzadV;
    protected int zzadW;
    protected int zzadX;
    protected boolean zzadY;
    protected ImageManager.OnImageLoadedListener zzadZ;
    private boolean zzaea;
    private boolean zzaeb;
    private boolean zzaec;
    protected int zzaed;

    public com.google.android.gms.common.images.zza(Uri uri, int i)
    {
        zzadW = 0;
        zzadX = 0;
        zzadY = false;
        zzaea = true;
        zzaeb = false;
        zzaec = true;
        zzadV = new zza(uri);
        zzadX = i;
    }

    private Drawable zza(Context context, zzlv zzlv1, int i)
    {
        Resources resources = context.getResources();
        if (zzaed > 0)
        {
            com.google.android.gms.internal.zzlv.zza zza1 = new com.google.android.gms.internal.zzlv.zza(i, zzaed);
            Drawable drawable = (Drawable)zzlv1.get(zza1);
            context = drawable;
            if (drawable == null)
            {
                Drawable drawable1 = resources.getDrawable(i);
                context = drawable1;
                if ((zzaed & 1) != 0)
                {
                    context = zza(resources, drawable1);
                }
                zzlv1.put(zza1, context);
            }
            return context;
        } else
        {
            return resources.getDrawable(i);
        }
    }

    protected Drawable zza(Resources resources, Drawable drawable)
    {
        return zzlt.zza(resources, drawable);
    }

    protected zzls zza(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof zzls)
            {
                drawable2 = ((zzls)drawable).zzoF();
            }
        } else
        {
            drawable2 = null;
        }
        return new zzls(drawable2, drawable1);
    }

    void zza(Context context, Bitmap bitmap, boolean flag)
    {
        com.google.android.gms.common.internal.zzb.zzs(bitmap);
        Bitmap bitmap1 = bitmap;
        if ((zzaed & 1) != 0)
        {
            bitmap1 = zzlt.zza(bitmap);
        }
        context = new BitmapDrawable(context.getResources(), bitmap1);
        if (zzadZ != null)
        {
            zzadZ.onImageLoaded(zzadV.uri, context, true);
        }
        zza(((Drawable) (context)), flag, false, true);
    }

    void zza(Context context, zzlv zzlv1)
    {
        if (zzaec)
        {
            Drawable drawable = null;
            if (zzadW != 0)
            {
                drawable = zza(context, zzlv1, zzadW);
            }
            zza(drawable, false, true, false);
        }
    }

    void zza(Context context, zzlv zzlv1, boolean flag)
    {
        Drawable drawable = null;
        if (zzadX != 0)
        {
            drawable = zza(context, zzlv1, zzadX);
        }
        if (zzadZ != null)
        {
            zzadZ.onImageLoaded(zzadV.uri, drawable, false);
        }
        zza(drawable, flag, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2);

    protected boolean zzb(boolean flag, boolean flag1)
    {
        return zzaea && !flag1 && (!flag || zzaeb);
    }

    public void zzby(int i)
    {
        zzadX = i;
    }

    private class zza
    {

        public final Uri uri;

        public final boolean equals(Object obj)
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
                return zzw.equal(((zza)obj).uri, uri);
            }
        }

        public final int hashCode()
        {
            return zzw.hashCode(new Object[] {
                uri
            });
        }

        public zza(Uri uri1)
        {
            uri = uri1;
        }
    }

}
