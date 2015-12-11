// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.widget.ListAdapter;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

private class this._cls0
    implements Runnable
{

    public int clickMotionPosition;
    private int mOriginalAttachCount;
    final HorizontalListView this$0;

    public void rememberWindowAttachCount()
    {
        mOriginalAttachCount = HorizontalListView.access$1600(HorizontalListView.this);
    }

    public void run()
    {
        if (!HorizontalListView.access$100(HorizontalListView.this))
        {
            ListAdapter listadapter = HorizontalListView.access$500(HorizontalListView.this);
            int i = clickMotionPosition;
            if (listadapter != null && HorizontalListView.access$400(HorizontalListView.this) > 0 && i != -1 && i < listadapter.getCount() && sameWindow())
            {
                android.view.View view = getChildAt(i - HorizontalListView.access$800(HorizontalListView.this));
                if (view != null)
                {
                    performItemClick(view, i, listadapter.getItemId(i));
                    return;
                }
            }
        }
    }

    public boolean sameWindow()
    {
        return hasWindowFocus() && HorizontalListView.access$1700(HorizontalListView.this) == mOriginalAttachCount;
    }

    public ()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
