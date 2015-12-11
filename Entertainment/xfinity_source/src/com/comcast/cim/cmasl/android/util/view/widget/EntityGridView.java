// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            HeaderGridView, CompositeOnScrollListener, ViewHolderBaseAdapter

public class EntityGridView extends HeaderGridView
    implements android.widget.AbsListView.OnScrollListener
{
    public static abstract class EntityGridViewAdapter extends ViewHolderBaseAdapter
    {

        private List entities;

        public int getCount()
        {
            return entities.size();
        }

        public Object getItem(int i)
        {
            return entities.get(i);
        }

        public void setEntities(List list)
        {
            entities = list;
        }

        public EntityGridViewAdapter(LayoutInflater layoutinflater)
        {
            super(layoutinflater);
            entities = new ArrayList();
        }
    }

    public static interface OnScrollChangedListener
    {

        public abstract void onScrollChanged(float f, float f1);
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/view/widget/EntityGridView);
    private CompositeOnScrollListener compositeScrollListener;
    private LayoutInflater inflater;
    private boolean isAccessibilityEnabled;
    private boolean isFlinging;
    private View mTrackedChild;
    private int mTrackedChildPrevLeft;
    private int mTrackedChildPrevPosition;
    private int mTrackedChildPrevTop;
    private View noResultsText;
    private OnScrollChangedListener onScrollChangedListener;
    private View scrollingShadow;

    protected EntityGridView(Context context)
    {
        super(context);
        compositeScrollListener = new CompositeOnScrollListener();
        isFlinging = false;
        initialize(context);
    }

    public EntityGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        compositeScrollListener = new CompositeOnScrollListener();
        isFlinging = false;
        initialize(context);
    }

    private View getChildInTheMiddle()
    {
        return getChildAt(getChildCount() / 2);
    }

    private void initialize(Context context)
    {
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public int computeVerticalScrollRange()
    {
        return super.computeVerticalScrollRange();
    }

    public int getContentHeight()
    {
        return getLayoutParams().height;
    }

    public String getStateDescription(CharSequence charsequence, int i, int j, int k)
    {
        if (i + j > k)
        {
            j = k;
        } else
        {
            j = i + j;
        }
        return getContext().getString(com.comcast.cim.cmasl.android.util.R.string.content_description_entity_grid_view, new Object[] {
            charsequence, Integer.valueOf(i + 1), Integer.valueOf(j), Integer.valueOf(k)
        });
    }

    public void initialize(ListAdapter listadapter)
    {
        noResultsText = inflater.inflate(com.comcast.cim.cmasl.android.util.R.layout.entity_grid_emtpy_view, (ViewGroup)getParent(), false);
        setEmptyView(noResultsText);
        setAdapter(listadapter);
        setOnScrollListener(this);
        setScrollingCacheEnabled(false);
    }

    public boolean isFlinging()
    {
        return isFlinging;
    }

    public boolean isScrolledToTop()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (getFirstVisiblePosition() != 0)
            {
                break label0;
            }
            if (getChildAt(0) != null)
            {
                flag = flag1;
                if (getChildAt(0).getTop() != 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (isAccessibilityEnabled)
        {
            String s = getStateDescription(getContentDescription(), i, j, k);
            if (getAdapter() != null && getAdapter().getCount() > 0)
            {
                abslistview.setContentDescription(s);
            }
        }
        if (scrollingShadow != null)
        {
            View view = scrollingShadow;
            byte byte0;
            if (isScrolledToTop())
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        }
        compositeScrollListener.onScroll(abslistview, i, j, k);
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        float f2 = 0.0F;
        float f3 = 0.0F;
        if (onScrollChangedListener != null)
        {
            float f;
            float f1;
            if (mTrackedChild == null)
            {
                f = f2;
                f1 = f3;
                if (getChildCount() > 0)
                {
                    mTrackedChild = getChildInTheMiddle();
                    mTrackedChildPrevTop = mTrackedChild.getTop();
                    mTrackedChildPrevLeft = mTrackedChild.getLeft();
                    mTrackedChildPrevPosition = getPositionForView(mTrackedChild);
                    f1 = f3;
                    f = f2;
                }
            } else
            {
                if (mTrackedChild.getParent() == this && getPositionForView(mTrackedChild) == mTrackedChildPrevPosition)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = mTrackedChild.getTop();
                    j = mTrackedChild.getLeft();
                    f = mTrackedChildPrevLeft - j;
                    f1 = mTrackedChildPrevTop - i;
                    mTrackedChildPrevTop = i;
                    mTrackedChildPrevLeft = j;
                } else
                {
                    mTrackedChild = null;
                    f = f2;
                    f1 = f3;
                }
            }
            onScrollChangedListener.onScrollChanged(f, f1);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        boolean flag = isFlinging;
        i;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 68
    //                   1 76
    //                   2 84;
           goto _L1 _L2 _L3 _L4
_L1:
        if (!isFlinging() && flag != isFlinging)
        {
            LOG.debug("notifyDataSetChanged because we are no longer flinging");
            ((BaseAdapter)getWrappedAdapter()).notifyDataSetChanged();
        }
        return;
_L2:
        isFlinging = false;
        continue; /* Loop/switch isn't completed */
_L3:
        isFlinging = true;
        continue; /* Loop/switch isn't completed */
_L4:
        isFlinging = true;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void reset()
    {
        stopIfFlinging();
        setAdapter(getWrappedAdapter());
    }

    public void setAccessibilityEnabled(boolean flag)
    {
        isAccessibilityEnabled = flag;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onscrollchangedlistener)
    {
        onScrollChangedListener = onscrollchangedlistener;
    }

    public void setScrollingShadow(View view)
    {
        scrollingShadow = view;
    }

    public void stopIfFlinging()
    {
        MotionEvent motionevent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
        dispatchTouchEvent(motionevent);
        motionevent.recycle();
    }

    public void update()
    {
        BaseAdapter baseadapter = (BaseAdapter)getWrappedAdapter();
        if (baseadapter != null)
        {
            if (baseadapter.getCount() > 0)
            {
                baseadapter.notifyDataSetChanged();
                if (noResultsText != null)
                {
                    noResultsText.setVisibility(8);
                }
            } else
            {
                baseadapter.notifyDataSetInvalidated();
                if (noResultsText != null)
                {
                    noResultsText.setVisibility(0);
                    return;
                }
            }
        }
    }

}
