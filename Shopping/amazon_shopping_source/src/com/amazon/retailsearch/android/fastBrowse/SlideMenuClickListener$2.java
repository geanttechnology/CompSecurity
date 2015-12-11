// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListView;
import com.amazon.retailsearch.android.ui.refinements.SpinnerHiderRelativeLayout;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            SlideMenuClickListener, FastBrowseListAdapter

class this._cls0
    implements Runnable
{

    final SlideMenuClickListener this$0;

    public void run()
    {
        SlideMenuClickListener.access$400(SlideMenuClickListener.this).notifyDataSetChanged();
        SlideMenuClickListener.access$700(SlideMenuClickListener.this).setSelectionAfterHeaderView();
        SlideMenuClickListener.access$800(SlideMenuClickListener.this).hide();
        SlideMenuClickListener.access$900(SlideMenuClickListener.this).setVisibility(8);
        if (SlideMenuClickListener.access$1000(SlideMenuClickListener.this) != 0)
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.1F, 1.0F);
            alphaanimation.setDuration(1500L);
            SlideMenuClickListener.access$900(SlideMenuClickListener.this).setAnimation(alphaanimation);
            SlideMenuClickListener.access$900(SlideMenuClickListener.this).setVisibility(0);
            return;
        } else
        {
            AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.1F);
            alphaanimation1.setDuration(1500L);
            SlideMenuClickListener.access$900(SlideMenuClickListener.this).setAnimation(alphaanimation1);
            SlideMenuClickListener.access$900(SlideMenuClickListener.this).setVisibility(8);
            return;
        }
    }

    ayout()
    {
        this$0 = SlideMenuClickListener.this;
        super();
    }
}
