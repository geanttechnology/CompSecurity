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
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzhe;
import com.google.android.gms.internal.zzhg;

public abstract class zza
{

    final zza zzSg;
    protected int zzSh;
    protected int zzSi;
    protected boolean zzSj;
    protected ImageManager.OnImageLoadedListener zzSk;
    private boolean zzSl;
    private boolean zzSm;
    private boolean zzSn;
    protected int zzSo;

    public com.google.android.gms.common.images.zza(Uri uri, int i)
    {
        zzSh = 0;
        zzSi = 0;
        zzSj = false;
        zzSl = true;
        zzSm = false;
        zzSn = true;
        zzSg = new zza(uri);
        zzSi = i;
    }

    private Drawable zza(Context context, zzhg zzhg1, int i)
    {
        Resources resources = context.getResources();
        if (zzSo > 0)
        {
            com.google.android.gms.internal.zzhg.zza zza1 = new com.google.android.gms.internal.zzhg.zza(i, zzSo);
            Drawable drawable = (Drawable)zzhg1.get(zza1);
            context = drawable;
            if (drawable == null)
            {
                Drawable drawable1 = resources.getDrawable(i);
                context = drawable1;
                if ((zzSo & 1) != 0)
                {
                    context = zza(resources, drawable1);
                }
                zzhg1.put(zza1, context);
            }
            return context;
        } else
        {
            return resources.getDrawable(i);
        }
    }

    protected Drawable zza(Resources resources, Drawable drawable)
    {
        return zzhe.zza(resources, drawable);
    }

    protected zzhd zza(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof zzhd)
            {
                drawable2 = ((zzhd)drawable).zzlA();
            }
        } else
        {
            drawable2 = null;
        }
        return new zzhd(drawable2, drawable1);
    }

    void zza(Context context, Bitmap bitmap, boolean flag)
    {
        com.google.android.gms.common.internal.zzb.zzn(bitmap);
        Bitmap bitmap1 = bitmap;
        if ((zzSo & 1) != 0)
        {
            bitmap1 = zzhe.zza(bitmap);
        }
        context = new BitmapDrawable(context.getResources(), bitmap1);
        if (zzSk != null)
        {
            zzSk.onImageLoaded(zzSg.uri, context, true);
        }
        zza(((Drawable) (context)), flag, false, true);
    }

    void zza(Context context, zzhg zzhg1)
    {
        if (zzSn)
        {
            Drawable drawable = null;
            if (zzSh != 0)
            {
                drawable = zza(context, zzhg1, zzSh);
            }
            zza(drawable, false, true, false);
        }
    }

    void zza(Context context, zzhg zzhg1, boolean flag)
    {
        Drawable drawable = null;
        if (zzSi != 0)
        {
            drawable = zza(context, zzhg1, zzSi);
        }
        if (zzSk != null)
        {
            zzSk.onImageLoaded(zzSg.uri, drawable, false);
        }
        zza(drawable, flag, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2);

    public void zzaI(int i)
    {
        zzSi = i;
    }

    protected boolean zzb(boolean flag, boolean flag1)
    {
        return zzSl && !flag1 && (!flag || zzSm);
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
                return zzu.equal(((zza)obj).uri, uri);
            }
        }

        public int hashCode()
        {
            return zzu.hashCode(new Object[] {
                uri
            });
        }

        public zza(Uri uri1)
        {
            uri = uri1;
        }
    }

}
