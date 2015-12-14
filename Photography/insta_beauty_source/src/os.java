// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityContinousPhotoViewer;
import com.fotoable.beautyui.gpuimage.sample.activity.ContinuousPhotoViewPager;

public class os
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    final ActivityContinousPhotoViewer a;

    public os(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        a = activitycontinousphotoviewer;
        super();
    }

    public void onPageScrollStateChanged(int i)
    {
        ActivityContinousPhotoViewer.a(a, ActivityContinousPhotoViewer.a(a).getCurrentItem() + 1);
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
    }
}
