// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class GalleryViewPager extends ViewPager
{

    private static final String TAG = com/amazon/gallery/framework/gallery/widget/GalleryViewPager.getName();

    public GalleryViewPager(Context context)
    {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            GLogger.d(TAG, "Caught IllegalArgumentException in ViewPager#onInterceptTouchEvent: %s", new Object[] {
                motionevent.getMessage()
            });
            return false;
        }
        return flag;
    }

}
