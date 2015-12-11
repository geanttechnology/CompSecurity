// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.View;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.gotv.crackle.fragments:
//            WatchlistsFragment

class this._cls0
    implements android.view.ener
{

    final WatchlistsFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (mLastAnimatedView != null && !flag)
        {
            mLastAnimatedView.startAnimation(AnimationUtils.loadAnimation(WatchlistsFragment.access$400(WatchlistsFragment.this), 0x7f040007));
        }
    }

    ()
    {
        this$0 = WatchlistsFragment.this;
        super();
    }
}
