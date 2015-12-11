// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.aio.downloader.views:
//            LTabIndicator

private class <init>
    implements android.support.v4.view.ner
{

    final LTabIndicator this$0;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            LTabIndicator.access$5(LTabIndicator.this, LTabIndicator.access$6(LTabIndicator.this).getCurrentItem(), 0);
        }
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        LTabIndicator.access$2(LTabIndicator.this, i);
        LTabIndicator.access$3(LTabIndicator.this, f);
        LTabIndicator.access$5(LTabIndicator.this, i, (int)((float)LTabIndicator.access$4(LTabIndicator.this).getChildAt(i).getWidth() * f));
        invalidate();
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        LTabIndicator.access$7(LTabIndicator.this, i);
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageSelected(i);
        }
    }

    private er()
    {
        this$0 = LTabIndicator.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
