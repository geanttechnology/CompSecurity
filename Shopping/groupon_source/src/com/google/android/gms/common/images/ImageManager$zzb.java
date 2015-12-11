// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import com.google.android.gms.internal.zzku;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager

private static final class  extends zzku
{

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        zza(flag, (zza)obj, (Bitmap)obj1, (Bitmap)obj2);
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return zza((zza)obj, (Bitmap)obj1);
    }

    protected int zza(zza zza1, Bitmap bitmap)
    {
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    protected void zza(boolean flag, zza zza1, Bitmap bitmap, Bitmap bitmap1)
    {
        super.entryRemoved(flag, zza1, bitmap, bitmap1);
    }
}
