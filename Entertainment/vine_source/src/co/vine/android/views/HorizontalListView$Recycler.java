// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

private class this._cls0
{

    private View mActiveViews[];
    private int mFirstActivePos;
    private final ArrayList mRecycleViews = new ArrayList();
    final HorizontalListView this$0;

    private void pruneRecycleViews()
    {
        int k = mActiveViews.length;
        ArrayList arraylist = mRecycleViews;
        int l = arraylist.size();
        int j = l - 1;
        for (int i = 0; i < l - k; i++)
        {
            HorizontalListView.access$600(HorizontalListView.this, (View)arraylist.remove(j), false);
            j--;
        }

    }

    public void addRecycleView(View view, int i)
    {
        ams ams = (ams)view.getLayoutParams();
        if (ams == null)
        {
            return;
        } else
        {
            ams.recycledPosition = i;
            ams.recycled = true;
            mRecycleViews.add(view);
            return;
        }
    }

    public void clear()
    {
        ArrayList arraylist = mRecycleViews;
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            HorizontalListView.access$700(HorizontalListView.this, (View)arraylist.remove(i), false);
        }

    }

    public void fillActiveViews(int i, int j)
    {
        View aview[];
label0:
        {
            View aview1[] = mActiveViews;
            if (aview1 != null)
            {
                aview = aview1;
                if (aview1.length >= j)
                {
                    break label0;
                }
            }
            mActiveViews = new View[j];
            aview = mActiveViews;
        }
        mFirstActivePos = i;
        for (i = 0; i < j; i++)
        {
            aview[i] = getChildAt(i);
        }

    }

    public View getActiveView(int i)
    {
        if (mActiveViews != null)
        {
            i -= mFirstActivePos;
            View aview[] = mActiveViews;
            if (i >= 0 && i < aview.length)
            {
                View view = aview[i];
                aview[i] = null;
                return view;
            }
        }
        return null;
    }

    public void recycleActiveViews()
    {
        View aview[] = mActiveViews;
        if (aview == null)
        {
            return;
        }
        ArrayList arraylist = mRecycleViews;
        for (int i = aview.length - 1; i >= 0; i--)
        {
            View view = aview[i];
            if (view != null)
            {
                ams ams = (ams)view.getLayoutParams();
                aview[i] = null;
                ams.recycledPosition = mFirstActivePos + i;
                arraylist.add(view);
            }
        }

        pruneRecycleViews();
    }

    public View removeRecycleView(int i)
    {
        ArrayList arraylist = mRecycleViews;
        if (arraylist.isEmpty())
        {
            return null;
        }
        int k = arraylist.size();
        for (int j = 0; j < k; j++)
        {
            View view = (View)arraylist.get(j);
            if (((ams)view.getLayoutParams()).recycledPosition == i)
            {
                arraylist.remove(j);
                return view;
            }
        }

        return (View)arraylist.remove(k - 1);
    }

    public ams()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
