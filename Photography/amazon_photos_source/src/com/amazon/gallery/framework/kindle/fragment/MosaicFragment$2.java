// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutManager;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.thor.app.ui.cab.GalleryContextBar;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            MosaicFragment

class finished extends android.support.v7.widget.rollListener
{

    private boolean finished;
    private Handler handler;
    private Runnable hideRunnable;
    final MosaicFragment this$0;
    private final int visibleThreshold = 25;

    private boolean isOnEdge()
    {
        int i = ((MosaicLayoutManager)mLayoutManager).findFirstCompletelyVisibleItemPosition();
        int j = ((MosaicLayoutManager)mLayoutManager).findLastCompletelyVisibleItemPosition();
        return i == 0 || j == mAdapter.getItemCount() - 1;
    }

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        if (!mContextBar.isContextBarActive()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = getActivity().getWindow().getDecorView().getSystemUiVisibility();
        onSystemUiVisibilityChange(j);
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            continue; /* Loop/switch isn't completed */

        case 0: // '\0'
            handler.removeCallbacks(hideRunnable);
            if (isOnEdge())
            {
                exitFullScreen();
            }
            if (!finished)
            {
                finished = checkLoadMoreItems(MosaicFragment.access$000(MosaicFragment.this));
                return;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (isOnEdge() || mScreenModeManager.isFullScreen()) goto _L1; else goto _L3
_L3:
        enterFullScreen();
        handler.removeCallbacks(hideRunnable);
        handler.postDelayed(hideRunnable, 250L);
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    _cls1.this._cls1()
    {
        this$0 = MosaicFragment.this;
        super();
        handler = new Handler();
        hideRunnable = new Runnable() {

            final MosaicFragment._cls2 this$1;

            public void run()
            {
                enterFullScreen();
            }

            
            {
                this$1 = MosaicFragment._cls2.this;
                super();
            }
        };
        finished = false;
    }
}
