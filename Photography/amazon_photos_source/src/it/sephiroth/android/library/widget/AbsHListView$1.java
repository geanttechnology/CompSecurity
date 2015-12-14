// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.View;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

class rformClick
    implements Runnable
{

    final AbsHListView this$0;
    final View val$child;
    final rformClick val$performClick;

    public void run()
    {
        mTouchMode = -1;
        val$child.setPressed(false);
        setPressed(false);
        if (!mDataChanged)
        {
            val$performClick.run();
        }
    }

    rformClick()
    {
        this$0 = final_abshlistview;
        val$child = view;
        val$performClick = rformClick.this;
        super();
    }
}
