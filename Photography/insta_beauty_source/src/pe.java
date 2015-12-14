// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityMediaPlayerTest;
import jp.co.cyberagent.android.gpuimage.grafika.AspectFrameLayout;

public class pe
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ActivityMediaPlayerTest a;

    public pe(ActivityMediaPlayerTest activitymediaplayertest)
    {
        a = activitymediaplayertest;
        super();
    }

    public void onGlobalLayout()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ActivityMediaPlayerTest.e(a).getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)ActivityMediaPlayerTest.f(a).getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams2 = (android.widget.FrameLayout.LayoutParams)ActivityMediaPlayerTest.b(a).getLayoutParams();
        int i1 = a.getResources().getDisplayMetrics().heightPixels;
        int i = a.getResources().getDisplayMetrics().widthPixels;
        int l = yp.a(a, 45F);
        int k = yp.a(a, 100F);
        android.widget.FrameLayout.LayoutParams layoutparams3 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams3.leftMargin = 0;
        layoutparams3.topMargin = 0;
        layoutparams3.gravity = 48;
        layoutparams3.width = i;
        layoutparams3.height = l;
        ActivityMediaPlayerTest.g(a).setLayoutParams(layoutparams3);
        int j = i1 - k - l;
        if ((double)((float)i / (float)j) < 0.75D)
        {
            j = (int)(((double)i * 4D) / 3D);
            k = i1 - j - l;
        } else
        {
            i = (int)(((double)j * 3D) / 4D);
        }
        layoutparams.topMargin = l;
        layoutparams.gravity = 49;
        layoutparams.height = j;
        layoutparams.width = i;
        ActivityMediaPlayerTest.e(a).setLayoutParams(layoutparams);
        layoutparams1.height = k;
        ActivityMediaPlayerTest.f(a).setLayoutParams(layoutparams1);
        layoutparams2.height = k;
        ActivityMediaPlayerTest.b(a).setLayoutParams(layoutparams2);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityMediaPlayerTest.e(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            ActivityMediaPlayerTest.e(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            return;
        }
    }
}
