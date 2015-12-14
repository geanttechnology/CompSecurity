// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.nhaarman.listviewanimations.ArrayAdapter;
import com.nhaarman.listviewanimations.ListViewSetter;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            ExpandCollapseListener

public abstract class ExpandableListItemAdapter extends ArrayAdapter
    implements ListViewSetter
{
    private static class ExpandCollapseHelper
    {

        public static void animateCollapsing(View view)
        {
            ValueAnimator valueanimator = createHeightAnimator(view, view.getHeight(), 0);
            valueanimator.addListener(new AnimatorListenerAdapter(view) {

                final View val$view;

                public void onAnimationEnd(Animator animator)
                {
                    view.setVisibility(8);
                }

            
            {
                view = view1;
                super();
            }
            });
            valueanimator.start();
        }

        public static void animateExpanding(View view, AbsListView abslistview)
        {
            view.setVisibility(0);
            Object obj = (View)view.getParent();
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(((View) (obj)).getMeasuredWidth() - ((View) (obj)).getPaddingLeft() - ((View) (obj)).getPaddingRight(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            obj = createHeightAnimator(view, 0, view.getMeasuredHeight());
            ((ValueAnimator) (obj)).addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener(abslistview, view) {

                final int listViewBottomPadding;
                final int listViewHeight;
                final View v;
                final AbsListView val$listView;
                final View val$view;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    int i = v.getBottom();
                    if (i > listViewHeight)
                    {
                        int j = v.getTop();
                        if (j > 0)
                        {
                            listView.smoothScrollBy(Math.min((i - listViewHeight) + listViewBottomPadding, j), 0);
                        }
                    }
                }

            
            {
                listView = abslistview;
                view = view1;
                super();
                listViewHeight = listView.getHeight();
                listViewBottomPadding = listView.getPaddingBottom();
                v = ExpandCollapseHelper.findDirectChild(view, listView);
            }
            });
            ((ValueAnimator) (obj)).start();
        }

        public static ValueAnimator createHeightAnimator(View view, int i, int j)
        {
            ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
                i, j
            });
            valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener(view) {

                final View val$view;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    int i = ((Integer)valueanimator.getAnimatedValue()).intValue();
                    valueanimator = view.getLayoutParams();
                    valueanimator.height = i;
                    view.setLayoutParams(valueanimator);
                }

            
            {
                view = view1;
                super();
            }
            });
            return valueanimator;
        }

        private static View findDirectChild(View view, AbsListView abslistview)
        {
            View view2 = (View)view.getParent();
            View view1 = view;
            for (view = view2; view != abslistview; view = (View)view1.getParent())
            {
                view1 = view;
            }

            return view1;
        }


        private ExpandCollapseHelper()
        {
        }
    }

    private static class RootView extends LinearLayout
    {

        private ViewGroup mContentViewGroup;
        private ViewGroup mTitleViewGroup;

        private void init()
        {
            setOrientation(1);
            mTitleViewGroup = new FrameLayout(getContext());
            mTitleViewGroup.setId(10000);
            addView(mTitleViewGroup);
            mContentViewGroup = new FrameLayout(getContext());
            mContentViewGroup.setId(10001);
            addView(mContentViewGroup);
        }

        public RootView(Context context)
        {
            super(context);
            init();
        }
    }

    private class TitleViewOnClickListener
        implements android.view.View.OnClickListener
    {

        private final View mContentParent;
        final ExpandableListItemAdapter this$0;

        public void onClick(View view)
        {
            toggle(mContentParent);
        }

        private TitleViewOnClickListener(View view)
        {
            this$0 = ExpandableListItemAdapter.this;
            super();
            mContentParent = view;
        }

    }

    private static class ViewHolder
    {

        ViewGroup contentParent;
        View contentView;
        ViewGroup titleParent;
        View titleView;

        private ViewHolder()
        {
        }

    }


    private static final int DEFAULTCONTENTPARENTRESID = 10001;
    private static final int DEFAULTTITLEPARENTRESID = 10000;
    private AbsListView mAbsListView;
    private int mActionViewResId;
    private final int mContentParentResId;
    private final Context mContext;
    private ExpandCollapseListener mExpandCollapseListener;
    private final List mExpandedIds;
    private int mLimit;
    private final int mTitleParentResId;
    private int mViewLayoutResId;

    public ExpandableListItemAdapter(Context context)
    {
        this(context, null);
    }

    public ExpandableListItemAdapter(Context context, int i, int j, int k)
    {
        this(context, i, j, k, null);
    }

    public ExpandableListItemAdapter(Context context, int i, int j, int k, List list)
    {
        super(list);
        mContext = context;
        mViewLayoutResId = i;
        mTitleParentResId = j;
        mContentParentResId = k;
        mExpandedIds = new ArrayList();
    }

    public ExpandableListItemAdapter(Context context, List list)
    {
        super(list);
        mContext = context;
        mTitleParentResId = 10000;
        mContentParentResId = 10001;
        mExpandedIds = new ArrayList();
    }

    private ViewGroup createView(ViewGroup viewgroup)
    {
        if (mViewLayoutResId == 0)
        {
            return new RootView(mContext);
        } else
        {
            return (ViewGroup)LayoutInflater.from(mContext).inflate(mViewLayoutResId, viewgroup, false);
        }
    }

    private int findPositionForId(long l)
    {
        for (int i = 0; i < getCount(); i++)
        {
            if (getItemId(i) == l)
            {
                return i;
            }
        }

        return -1;
    }

    private View findViewForPosition(int i)
    {
        View view = null;
        for (int j = 0; j < mAbsListView.getChildCount() && view == null; j++)
        {
            View view1 = mAbsListView.getChildAt(j);
            if (AdapterViewUtil.getPositionForView(mAbsListView, view1) == i)
            {
                view = view1;
            }
        }

        return view;
    }

    private View getContentParent(int i)
    {
        Object obj = null;
        Object obj1 = findViewForPosition(i);
        ViewGroup viewgroup = obj;
        if (obj1 != null)
        {
            obj1 = ((View) (obj1)).getTag();
            viewgroup = obj;
            if (obj1 instanceof ViewHolder)
            {
                viewgroup = ((ViewHolder)obj1).contentParent;
            }
        }
        return viewgroup;
    }

    private void toggle(View view)
    {
        int i = 1;
        Long long2;
        boolean flag;
        if (view.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || mLimit <= 0 || mExpandedIds.size() < mLimit)
        {
            i = 0;
        }
        if (i != 0)
        {
            Long long1 = (Long)mExpandedIds.get(0);
            i = findPositionForId(long1.longValue());
            View view1 = getContentParent(i);
            if (view1 != null)
            {
                ExpandCollapseHelper.animateCollapsing(view1);
            }
            mExpandedIds.remove(long1);
            if (mExpandCollapseListener != null)
            {
                mExpandCollapseListener.onItemCollapsed(i);
            }
        }
        long2 = (Long)view.getTag();
        i = findPositionForId(long2.longValue());
        if (flag)
        {
            ExpandCollapseHelper.animateCollapsing(view);
            mExpandedIds.remove(long2);
            if (mExpandCollapseListener != null)
            {
                mExpandCollapseListener.onItemCollapsed(i);
            }
        } else
        {
            ExpandCollapseHelper.animateExpanding(view, mAbsListView);
            mExpandedIds.add(long2);
            if (mExpandCollapseListener != null)
            {
                mExpandCollapseListener.onItemExpanded(i);
                return;
            }
        }
    }

    public void collapse(int i)
    {
        long l = getItemId(i);
        if (!mExpandedIds.contains(Long.valueOf(l)))
        {
            return;
        } else
        {
            toggle(i);
            return;
        }
    }

    public void expand(int i)
    {
        long l = getItemId(i);
        if (mExpandedIds.contains(Long.valueOf(l)))
        {
            return;
        } else
        {
            toggle(i);
            return;
        }
    }

    public View getContentView(int i)
    {
        Object obj = null;
        Object obj1 = findViewForPosition(i);
        View view = obj;
        if (obj1 != null)
        {
            obj1 = ((View) (obj1)).getTag();
            view = obj;
            if (obj1 instanceof ViewHolder)
            {
                view = ((ViewHolder)obj1).contentView;
            }
        }
        return view;
    }

    public abstract View getContentView(int i, View view, ViewGroup viewgroup);

    public View getTitleView(int i)
    {
        View view = null;
        Object obj = findViewForPosition(i).getTag();
        if (obj instanceof ViewHolder)
        {
            view = ((ViewHolder)obj).titleView;
        }
        return view;
    }

    public abstract View getTitleView(int i, View view, ViewGroup viewgroup);

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (ViewGroup)view;
        Object obj;
        int j;
        if (view == null)
        {
            view = createView(viewgroup);
            viewgroup = new ViewHolder();
            viewgroup.titleParent = (ViewGroup)view.findViewById(mTitleParentResId);
            viewgroup.contentParent = (ViewGroup)view.findViewById(mContentParentResId);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        obj = getTitleView(i, ((ViewHolder) (viewgroup)).titleView, ((ViewHolder) (viewgroup)).titleParent);
        if (obj != ((ViewHolder) (viewgroup)).titleView)
        {
            ((ViewHolder) (viewgroup)).titleParent.removeAllViews();
            ((ViewHolder) (viewgroup)).titleParent.addView(((View) (obj)));
            if (mActionViewResId == 0)
            {
                view.setOnClickListener(new TitleViewOnClickListener(((ViewHolder) (viewgroup)).contentParent));
            } else
            {
                view.findViewById(mActionViewResId).setOnClickListener(new TitleViewOnClickListener(((ViewHolder) (viewgroup)).contentParent));
            }
        }
        viewgroup.titleView = ((View) (obj));
        obj = getContentView(i, ((ViewHolder) (viewgroup)).contentView, ((ViewHolder) (viewgroup)).contentParent);
        if (obj != ((ViewHolder) (viewgroup)).contentView)
        {
            ((ViewHolder) (viewgroup)).contentParent.removeAllViews();
            ((ViewHolder) (viewgroup)).contentParent.addView(((View) (obj)));
        }
        viewgroup.contentView = ((View) (obj));
        obj = ((ViewHolder) (viewgroup)).contentParent;
        if (mExpandedIds.contains(Long.valueOf(getItemId(i))))
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((ViewGroup) (obj)).setVisibility(j);
        ((ViewHolder) (viewgroup)).contentParent.setTag(Long.valueOf(getItemId(i)));
        obj = ((ViewHolder) (viewgroup)).contentParent.getLayoutParams();
        obj.height = -2;
        ((ViewHolder) (viewgroup)).contentParent.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        return view;
    }

    public boolean isExpanded(int i)
    {
        long l = getItemId(i);
        return mExpandedIds.contains(Long.valueOf(l));
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        HashSet hashset = new HashSet(mExpandedIds);
        for (int i = 0; i < getCount(); i++)
        {
            hashset.remove(Long.valueOf(getItemId(i)));
        }

        mExpandedIds.removeAll(hashset);
    }

    public void setAbsListView(AbsListView abslistview)
    {
        mAbsListView = abslistview;
    }

    public void setActionViewResId(int i)
    {
        mActionViewResId = i;
    }

    public void setExpandCollapseListener(ExpandCollapseListener expandcollapselistener)
    {
        mExpandCollapseListener = expandcollapselistener;
    }

    public void setLimit(int i)
    {
        mLimit = i;
        mExpandedIds.clear();
        notifyDataSetChanged();
    }

    public void toggle(int i)
    {
        long l = getItemId(i);
        boolean flag = mExpandedIds.contains(Long.valueOf(l));
        View view = getContentParent(i);
        if (view != null)
        {
            toggle(view);
        }
        if (view == null && flag)
        {
            mExpandedIds.remove(Long.valueOf(l));
        } else
        if (view == null && !flag)
        {
            mExpandedIds.add(Long.valueOf(l));
            return;
        }
    }

}
