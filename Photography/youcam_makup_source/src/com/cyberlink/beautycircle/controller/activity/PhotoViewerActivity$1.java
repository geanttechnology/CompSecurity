// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.view.widgetpool.common.NonSwipableViewPager;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PhotoViewerActivity

class a
    implements android.support.v4.view.Listener
{

    final PhotoViewerActivity a;

    private void a(View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            view.setTranslationX(0.0F);
            view.setTranslationY(0.0F);
            view.setScaleX(1.0F);
            view.setScaleY(1.0F);
            return;
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            i = PhotoViewerActivity.a(a).getCurrentItem();
            a(PhotoViewerActivity.a(a).findViewWithTag(Integer.valueOf(i - 1)));
            a(PhotoViewerActivity.a(a).findViewWithTag(Integer.valueOf(i + 1)));
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        int j = PhotoViewerActivity.b(a).getVisibility();
        PhotoViewerActivity.a(a, i, j);
    }

    r(PhotoViewerActivity photovieweractivity)
    {
        a = photovieweractivity;
        super();
    }
}
