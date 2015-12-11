// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package se.emilsjolander.stickylistheaders:
//            StickyListHeadersListView, ExpandableStickyListHeadersAdapter, StickyListHeadersAdapter

public class ExpandableStickyListHeadersListView extends StickyListHeadersListView
{
    public static interface IAnimationExecutor
    {

        public abstract void executeAnim(View view, int i);
    }


    IAnimationExecutor mDefaultAnimExecutor = new IAnimationExecutor() {

        final ExpandableStickyListHeadersListView this$0;

        public void executeAnim(View view, int i)
        {
            if (i == 0)
            {
                view.setVisibility(0);
            } else
            if (i == 1)
            {
                view.setVisibility(8);
                return;
            }
        }

            
            {
                this$0 = ExpandableStickyListHeadersListView.this;
                super();
            }
    };
    ExpandableStickyListHeadersAdapter mExpandableStickyListHeadersAdapter;

    public ExpandableStickyListHeadersListView(Context context)
    {
        super(context);
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void animateView(View view, int i)
    {
        while (i == 0 && view.getVisibility() == 0 || 1 == i && view.getVisibility() != 0 || mDefaultAnimExecutor == null) 
        {
            return;
        }
        mDefaultAnimExecutor.executeAnim(view, i);
    }

    public void collapse(long l)
    {
        if (!mExpandableStickyListHeadersAdapter.isHeaderCollapsed(l)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mExpandableStickyListHeadersAdapter.collapse(l);
        Object obj = mExpandableStickyListHeadersAdapter.getItemViewsByHeaderId(l);
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                animateView((View)((Iterator) (obj)).next(), 1);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void expand(long l)
    {
        if (mExpandableStickyListHeadersAdapter.isHeaderCollapsed(l)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mExpandableStickyListHeadersAdapter.expand(l);
        Object obj = mExpandableStickyListHeadersAdapter.getItemViewsByHeaderId(l);
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                animateView((View)((Iterator) (obj)).next(), 0);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public ExpandableStickyListHeadersAdapter getAdapter()
    {
        return mExpandableStickyListHeadersAdapter;
    }

    public volatile StickyListHeadersAdapter getAdapter()
    {
        return getAdapter();
    }

    public boolean isHeaderCollapsed(long l)
    {
        return mExpandableStickyListHeadersAdapter.isHeaderCollapsed(l);
    }

    public void setAdapter(StickyListHeadersAdapter stickylistheadersadapter)
    {
        mExpandableStickyListHeadersAdapter = new ExpandableStickyListHeadersAdapter(stickylistheadersadapter);
        super.setAdapter(mExpandableStickyListHeadersAdapter);
    }

    public void setAnimExecutor(IAnimationExecutor ianimationexecutor)
    {
        mDefaultAnimExecutor = ianimationexecutor;
    }
}
