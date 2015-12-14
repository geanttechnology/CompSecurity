// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.gms.vision:
//            Frame

public static class zzaVf
{

    private Frame zzaVf;

    public Frame build()
    {
        if (Frame.zza(zzaVf) == null && Frame.zzb(zzaVf) == null)
        {
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        } else
        {
            return zzaVf;
        }
    }

    public zzaVf setBitmap(Bitmap bitmap)
    {
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        Frame.zza(zzaVf, bitmap);
        bitmap = zzaVf.getMetadata();
        .zza(bitmap, i);
        .zzb(bitmap, j);
        return this;
    }

    public  setId(int i)
    {
        .zzc(zzaVf.getMetadata(), i);
        return this;
    }

    public ata setImageData(ByteBuffer bytebuffer, int i, int j, int k)
    {
        if (bytebuffer == null)
        {
            throw new IllegalArgumentException("Null image data supplied.");
        }
        if (!bytebuffer.isDirect())
        {
            throw new IllegalArgumentException("Image byte buffer must be allocated as 'direct'. See ByteBuffer.allocateDirect().");
        }
        if (bytebuffer.array() == null || bytebuffer.array().length < i * j)
        {
            throw new IllegalArgumentException("Invalid image data size.");
        }
        switch (k)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported image format: ").append(k).toString());

        case 16: // '\020'
        case 17: // '\021'
        case 842094169: 
            Frame.zza(zzaVf, bytebuffer);
            break;
        }
        bytebuffer = zzaVf.getMetadata();
        .zza(bytebuffer, i);
        .zzb(bytebuffer, j);
        return this;
    }

    public  setRotation(int i)
    {
        .zzd(zzaVf.getMetadata(), i);
        return this;
    }

    public ata setTimestampMillis(long l)
    {
        .zza(zzaVf.getMetadata(), l);
        return this;
    }

    public ()
    {
        zzaVf = new Frame(null);
    }
}
