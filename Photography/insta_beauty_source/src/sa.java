// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;

class sa
    implements Runnable
{

    final contiCapturePhotoEditActivity1 a;
    final Bitmap b;
    final rz c;

    sa(rz rz1, contiCapturePhotoEditActivity1 conticapturephotoeditactivity1, Bitmap bitmap)
    {
        c = rz1;
        a = conticapturephotoeditactivity1;
        b = bitmap;
        super();
    }

    public void run()
    {
        String s = contiCapturePhotoEditActivity1.a(a, b);
        rz.a(c).sendMessage(rz.a(c).obtainMessage(0, s));
    }
}
