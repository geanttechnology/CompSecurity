// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.widget.ListAdapter;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

private class <init> extends le
    implements Runnable
{

    int mClickMotionPosition;
    final AbsHListView this$0;

    public void run()
    {
        if (!mDataChanged)
        {
            ListAdapter listadapter = mAdapter;
            int i = mClickMotionPosition;
            if (listadapter != null && mItemCount > 0 && i != -1 && i < listadapter.getCount() && sameWindow())
            {
                android.view.View view = getChildAt(i - mFirstPosition);
                if (view != null)
                {
                    performItemClick(view, i, listadapter.getItemId(i));
                    return;
                }
            }
        }
    }

    private le()
    {
        this$0 = AbsHListView.this;
        super(AbsHListView.this, null);
    }

    le(le le)
    {
        this();
    }
}
