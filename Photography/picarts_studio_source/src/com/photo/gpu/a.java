// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.File;

// Referenced classes of package com.photo.gpu:
//            b, GPUImage

final class a extends b
{

    private final File a;

    public a(GPUImage gpuimage, GPUImage gpuimage1, File file)
    {
        super(gpuimage, gpuimage1);
        a = file;
    }

    protected final int a()
    {
        switch ((new ExifInterface(a.getAbsolutePath())).getAttributeInt("Orientation", 1))
        {
        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        default:
            return 0;

        case 6: // '\006'
            return 90;

        case 3: // '\003'
            return 180;

        case 8: // '\b'
            return 270;
        }
    }

    protected final Bitmap a(android.graphics.BitmapFactory.Options options)
    {
        return BitmapFactory.decodeFile(a.getAbsolutePath(), options);
    }
}
