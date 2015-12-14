// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;

public class rr
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final contiCapturePhotoEditActivity1 a;

    public rr(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        a = conticapturephotoeditactivity1;
        super();
    }

    public void onGlobalLayout()
    {
        contiCapturePhotoEditActivity1.h(a);
        int i1 = a.getResources().getDisplayMetrics().heightPixels;
        int i = a.getResources().getDisplayMetrics().widthPixels;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)a.d.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)a.a.getLayoutParams();
        int l = yp.a(a, 45F);
        android.widget.FrameLayout.LayoutParams layoutparams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams2.leftMargin = 0;
        layoutparams2.topMargin = 0;
        layoutparams2.gravity = 48;
        layoutparams2.width = i;
        layoutparams2.height = l;
        a.c.setLayoutParams(layoutparams2);
        int k = yp.a(a, 100F);
        int j = i1 - k - l;
        if ((float)i / (float)j < 1.0F / contiCapturePhotoEditActivity1.i(a))
        {
            j = (int)((float)i * contiCapturePhotoEditActivity1.i(a));
            k = i1 - j - l;
        } else
        {
            i = (int)((float)j / contiCapturePhotoEditActivity1.i(a));
        }
        layoutparams.topMargin = l;
        layoutparams.gravity = 49;
        layoutparams.height = j;
        layoutparams.width = i;
        a.d.setLayoutParams(layoutparams);
        layoutparams1.height = k;
        a.a.setLayoutParams(layoutparams1);
        a.b.setLayoutParams(layoutparams1);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            contiCapturePhotoEditActivity1.j(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            contiCapturePhotoEditActivity1.j(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            return;
        }
    }
}
