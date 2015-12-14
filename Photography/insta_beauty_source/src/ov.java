// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityContinousPhotoViewer;

public class ov
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ActivityContinousPhotoViewer a;

    public ov(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        a = activitycontinousphotoviewer;
        super();
    }

    public void onGlobalLayout()
    {
        ActivityContinousPhotoViewer.b(a);
        int i1 = a.getResources().getDisplayMetrics().heightPixels;
        int i = a.getResources().getDisplayMetrics().widthPixels;
        int k = a.c.getHeight();
        int l = a.e.getHeight();
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)a.f.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)a.c.getLayoutParams();
        int j = i1 - k - l;
        if ((float)i / (float)j < 1.0F / ActivityContinousPhotoViewer.c(a))
        {
            j = (int)((float)i * ActivityContinousPhotoViewer.c(a));
            k = i1 - j - l;
        } else
        {
            i = (int)((float)j / ActivityContinousPhotoViewer.c(a));
        }
        layoutparams.bottomMargin = (k - l) / 2;
        layoutparams.height = j;
        layoutparams.width = i;
        a.f.setLayoutParams(layoutparams);
        layoutparams1.height = k;
        a.c.setLayoutParams(layoutparams1);
        a.d.setLayoutParams(layoutparams1);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            a.d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            return;
        }
    }
}
