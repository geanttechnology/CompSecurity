// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewTreeObserver;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import com.wantu.imagerender.ImageGLSurfaceView;

public class ru
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final contiCapturePhotoEditActivity1 a;

    public ru(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        a = conticapturephotoeditactivity1;
        super();
    }

    public void onGlobalLayout()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            contiCapturePhotoEditActivity1.k(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            contiCapturePhotoEditActivity1.k(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            return;
        }
    }
}
