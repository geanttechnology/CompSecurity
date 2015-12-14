// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayerManager;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class this._cls0
    implements uk.co.senab.photoview.iewTapListener
{

    final SingleViewFragment this$0;

    public void onViewTap(View view, float f, float f1)
    {
        if (mMediaItemCursorAdapter.getItem(SingleViewFragment.access$000(SingleViewFragment.this).getCurrentItem()).getType() == MediaType.VIDEO && SingleViewFragment.access$100(SingleViewFragment.this).getVisibility() == 0)
        {
            return;
        }
        if (mScreenModeManager.isFullScreen())
        {
            exitFullScreen();
            return;
        } else
        {
            enterFullScreen();
            return;
        }
    }

    layerManager()
    {
        this$0 = SingleViewFragment.this;
        super();
    }
}
