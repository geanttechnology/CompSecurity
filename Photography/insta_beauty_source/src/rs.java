// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ContinuousPhotoViewPager;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;

public class rs
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    final contiCapturePhotoEditActivity1 a;

    public rs(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        a = conticapturephotoeditactivity1;
        super();
    }

    public void onPageScrollStateChanged(int i)
    {
        contiCapturePhotoEditActivity1.a(a, contiCapturePhotoEditActivity1.a(a).getCurrentItem() + 1);
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
    }
}
