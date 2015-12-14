// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class aei extends aej
{

    final GPUImage a;
    private final File c;

    public aei(GPUImage gpuimage, GPUImage gpuimage1, File file)
    {
        a = gpuimage;
        super(gpuimage, gpuimage1);
        c = file;
    }

    protected int a()
    {
        switch ((new ExifInterface(c.getAbsolutePath())).getAttributeInt("Orientation", 1))
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

    protected Bitmap a(android.graphics.BitmapFactory.Options options)
    {
        return BitmapFactory.decodeFile(c.getAbsolutePath(), options);
    }
}
