// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapEditItem;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import com.wantu.imagerender.ImageGLSurfaceView;
import java.util.ArrayList;

class sd
    implements Runnable
{

    final int a;
    final Bitmap b;
    final contiCapturePhotoEditActivity1 c;
    final sc d;

    sd(sc sc1, int i, Bitmap bitmap, contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        d = sc1;
        a = i;
        b = bitmap;
        c = conticapturephotoeditactivity1;
        super();
    }

    public void run()
    {
        if (a > contiCapturePhotoEditActivity1.f(d.b).size() - 1 || a < 0)
        {
            return;
        }
        int i = ((contiCapEditItem)contiCapturePhotoEditActivity1.f(d.b).get(a)).filterFlag;
        float f;
        String s;
        if (i == 0x7f060033)
        {
            f = 1.0F;
        } else
        {
            f = 0.7F;
        }
        s = contiCapturePhotoEditActivity1.b(d.b, i);
        contiCapturePhotoEditActivity1.k(d.b).processImage(b, s, f, new rz(c, contiCapturePhotoEditActivity1.l(d.b)));
        Log.e("contiCapturePhotoEditActivity1", (new StringBuilder()).append("11111, processImage, mPhotoIndex=").append(sc.a(d)).toString());
    }
}
