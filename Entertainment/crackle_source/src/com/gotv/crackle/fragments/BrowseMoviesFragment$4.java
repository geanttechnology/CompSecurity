// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseMoviesFragment

class this._cls0
    implements android.widget.tedListener
{

    final BrowseMoviesFragment this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (view != null)
        {
            view.startAnimation(AnimationUtils.loadAnimation(BrowseMoviesFragment.access$000(BrowseMoviesFragment.this), 0x7f040006));
        }
        if (mLastAnimatedView != null && mLastAnimatedView != view)
        {
            mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(BrowseMoviesFragment.access$000(BrowseMoviesFragment.this), 0x7f040007));
        }
        mLastAnimatedView = view;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        if (mLastAnimatedView != null)
        {
            mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(BrowseMoviesFragment.access$000(BrowseMoviesFragment.this), 0x7f040007));
        }
    }

    ()
    {
        this$0 = BrowseMoviesFragment.this;
        super();
    }
}
