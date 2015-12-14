// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.support.v4.widget.CursorAdapter;
import com.aviary.android.feather.sdk.widget.EffectThumbLayout;
import it.sephiroth.android.library.widget.HListView;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

class val.position
    implements Runnable
{

    final BordersPanel this$0;
    final int val$position;

    public void run()
    {
        if (isActive() && mAdapter != null && mHList != null)
        {
            mHList.clearChoices();
            if (val$position >= mHList.getFirstVisiblePosition() && val$position < mHList.getLastVisiblePosition() && val$position < mAdapter.getCount())
            {
                android.view.View view = mHList.getChildAt(val$position - mHList.getFirstVisiblePosition());
                if (view != null && (view instanceof EffectThumbLayout))
                {
                    mHList.performItemClick(view, val$position, mAdapter.getItemId(val$position));
                    return;
                }
            }
        }
    }

    ut()
    {
        this$0 = final_borderspanel;
        val$position = I.this;
        super();
    }
}
