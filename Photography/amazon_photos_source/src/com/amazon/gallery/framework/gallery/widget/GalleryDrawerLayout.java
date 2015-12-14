// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryViewPager

public class GalleryDrawerLayout extends DrawerLayout
{

    private static final String TAG = com/amazon/gallery/framework/gallery/widget/GalleryViewPager.getName();

    public GalleryDrawerLayout(Context context)
    {
        super(context);
    }

    public GalleryDrawerLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public GalleryDrawerLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag = super.onInterceptTouchEvent(motionevent);
        return flag;
        motionevent;
_L2:
        GLogger.d(TAG, "Caught an exception in DrawerLayout#onInterceptTouchEvent: %s", new Object[] {
            motionevent
        });
        return false;
        motionevent;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
