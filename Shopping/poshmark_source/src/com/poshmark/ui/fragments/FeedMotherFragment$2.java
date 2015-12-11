// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import com.poshmark.http.api.PMApi;

// Referenced classes of package com.poshmark.ui.fragments:
//            FeedMotherFragment

class this._cls0
    implements android.widget.stener
{

    final FeedMotherFragment this$0;

    public void onTabChanged(String s)
    {
        int i = FeedMotherFragment.access$000(FeedMotherFragment.this).getCurrentTab();
        i;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 116
    //                   1 164
    //                   2 212;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_212;
_L5:
        int j = FeedMotherFragment.access$300(FeedMotherFragment.this).getCurrentItem();
        if (i != FeedMotherFragment.access$100(FeedMotherFragment.this))
        {
            if (i == 0 && !FeedMotherFragment.access$400(FeedMotherFragment.this))
            {
                PMApi.getViewTrackingInfo("mlk");
                FeedMotherFragment.access$402(FeedMotherFragment.this, true);
            } else
            {
                FeedMotherFragment.access$402(FeedMotherFragment.this, false);
            }
        }
        if (j != i)
        {
            FeedMotherFragment.access$300(FeedMotherFragment.this).setCurrentItem(i);
            FeedMotherFragment.access$102(FeedMotherFragment.this, i);
        }
        return;
_L2:
        FeedMotherFragment.access$200(FeedMotherFragment.this, myLikesTextView, true);
        FeedMotherFragment.access$200(FeedMotherFragment.this, feedTextView, false);
        FeedMotherFragment.access$200(FeedMotherFragment.this, peopleTextView, false);
          goto _L5
_L3:
        FeedMotherFragment.access$200(FeedMotherFragment.this, myLikesTextView, false);
        FeedMotherFragment.access$200(FeedMotherFragment.this, feedTextView, true);
        FeedMotherFragment.access$200(FeedMotherFragment.this, peopleTextView, false);
          goto _L5
        FeedMotherFragment.access$200(FeedMotherFragment.this, myLikesTextView, false);
        FeedMotherFragment.access$200(FeedMotherFragment.this, feedTextView, false);
        FeedMotherFragment.access$200(FeedMotherFragment.this, peopleTextView, true);
          goto _L5
    }

    ()
    {
        this$0 = FeedMotherFragment.this;
        super();
    }
}
