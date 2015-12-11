// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;

public class AnimatedExpandableListView extends ExpandableListView
{
    public static abstract class AnimatedExpandableListAdapter extends BaseExpandableListAdapter
    {

        private static final int STATE_COLLAPSING = 2;
        private static final int STATE_EXPANDING = 1;
        private static final int STATE_IDLE = 0;
        private SparseArray groupInfo;
        private AnimatedExpandableListView parent;

        private GroupInfo getGroupInfo(int i)
        {
            GroupInfo groupinfo1 = (GroupInfo)groupInfo.get(i);
            GroupInfo groupinfo = groupinfo1;
            if (groupinfo1 == null)
            {
                groupinfo = new GroupInfo();
                groupInfo.put(i, groupinfo);
            }
            return groupinfo;
        }

        private void setParent(AnimatedExpandableListView animatedexpandablelistview)
        {
            parent = animatedexpandablelistview;
        }

        private void startCollapseAnimation(int i, int j)
        {
            GroupInfo groupinfo = getGroupInfo(i);
            groupinfo.animating = true;
            groupinfo.firstChildPosition = j;
            groupinfo.expanding = false;
        }

        private void startExpandAnimation(int i, int j)
        {
            GroupInfo groupinfo = getGroupInfo(i);
            groupinfo.animating = true;
            groupinfo.firstChildPosition = j;
            groupinfo.expanding = true;
        }

        private void stopAnimation(int i)
        {
            getGroupInfo(i).animating = false;
        }

        public final int getChildType(int i, int j)
        {
            if (getGroupInfo(i).animating)
            {
                return 0;
            } else
            {
                return getRealChildType(i, j) + 1;
            }
        }

        public final int getChildTypeCount()
        {
            return getRealChildTypeCount() + 1;
        }

        public final View getChildView(final int groupPosition, int i, boolean flag, View view, ViewGroup viewgroup)
        {
            Object obj;
            final GroupInfo info;
            final ExpandableListView listView;
            View view1;
            int j;
            int k;
            int k1;
            info = getGroupInfo(groupPosition);
            if (info.animating)
            {
                obj = view;
                if (view == null)
                {
                    obj = new DummyView(viewgroup.getContext());
                    ((View) (obj)).setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 0));
                }
                if (i < info.firstChildPosition)
                {
                    ((View) (obj)).getLayoutParams().height = 0;
                    return ((View) (obj));
                }
                listView = (ExpandableListView)viewgroup;
                view = (DummyView)obj;
                view.clearViews();
                view.setDivider(listView.getDivider(), viewgroup.getMeasuredWidth(), listView.getDividerHeight());
                int l = android.view.View.MeasureSpec.makeMeasureSpec(viewgroup.getWidth(), 0x40000000);
                int i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                i = 0;
                int j1 = viewgroup.getHeight();
                k1 = getRealChildrenCount(groupPosition);
                k = info.firstChildPosition;
                do
                {
label0:
                    {
                        j = i;
                        if (k >= k1)
                        {
                            break MISSING_BLOCK_LABEL_257;
                        }
                        if (k == k1 - 1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        view1 = getRealChildView(groupPosition, k, flag, null, viewgroup);
                        view1.measure(l, i1);
                        i += view1.getMeasuredHeight();
                        if (i >= j1)
                        {
                            break label0;
                        }
                        view.addFakeView(view1);
                        k++;
                    }
                } while (true);
            }
              goto _L1
            view.addFakeView(view1);
            j = i + (k1 - k - 1) * (i / (k + 1));
            viewgroup = ((ViewGroup) (view.getTag()));
            if (viewgroup == null)
            {
                i = 0;
            } else
            {
                i = ((Integer)viewgroup).intValue();
            }
            if (!info.expanding || i == 1) goto _L3; else goto _L2
_L2:
            viewgroup = new ExpandAnimation(view, 0, j, info);
            viewgroup.setDuration(parent.getAnimationDuration());
            viewgroup.setAnimationListener(view. new android.view.animation.Animation.AnimationListener() {

                final AnimatedExpandableListAdapter this$0;
                final DummyView val$dummyView;
                final int val$groupPosition;

                public void onAnimationEnd(Animation animation)
                {
                    stopAnimation(groupPosition);
                    notifyDataSetChanged();
                    dummyView.setTag(Integer.valueOf(0));
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = final_animatedexpandablelistadapter;
                groupPosition = i;
                dummyView = DummyView.this;
                super();
            }
            });
            view.startAnimation(viewgroup);
            view.setTag(Integer.valueOf(1));
_L4:
            return ((View) (obj));
_L3:
            if (!info.expanding && i != 2)
            {
                if (info.dummyHeight == -1)
                {
                    info.dummyHeight = j;
                }
                viewgroup = new ExpandAnimation(view, info.dummyHeight, 0, info);
                viewgroup.setDuration(parent.getAnimationDuration());
                viewgroup.setAnimationListener(view. new android.view.animation.Animation.AnimationListener() {

                    final AnimatedExpandableListAdapter this$0;
                    final DummyView val$dummyView;
                    final int val$groupPosition;
                    final GroupInfo val$info;
                    final ExpandableListView val$listView;

                    public void onAnimationEnd(Animation animation)
                    {
                        stopAnimation(groupPosition);
                        listView.collapseGroup(groupPosition);
                        notifyDataSetChanged();
                        info.dummyHeight = -1;
                        dummyView.setTag(Integer.valueOf(0));
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                this$0 = final_animatedexpandablelistadapter;
                groupPosition = i;
                listView = expandablelistview;
                info = groupinfo;
                dummyView = DummyView.this;
                super();
            }
                });
                view.startAnimation(viewgroup);
                view.setTag(Integer.valueOf(2));
            }
            if (true) goto _L4; else goto _L1
_L1:
            return getRealChildView(groupPosition, i, flag, view, viewgroup);
        }

        public final int getChildrenCount(int i)
        {
            GroupInfo groupinfo = getGroupInfo(i);
            if (groupinfo.animating)
            {
                return groupinfo.firstChildPosition + 1;
            } else
            {
                return getRealChildrenCount(i);
            }
        }

        public int getGroupType(int i)
        {
            return getRealGroupType(i);
        }

        public int getGroupTypeCount()
        {
            return getRealGroupTypeCount();
        }

        public int getRealChildType(int i, int j)
        {
            return 0;
        }

        public int getRealChildTypeCount()
        {
            return 1;
        }

        public abstract View getRealChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup);

        public abstract int getRealChildrenCount(int i);

        public int getRealGroupType(int i)
        {
            return 0;
        }

        public int getRealGroupTypeCount()
        {
            return 1;
        }

        public void notifyGroupExpanded(int i)
        {
            getGroupInfo(i).dummyHeight = -1;
        }





        public AnimatedExpandableListAdapter()
        {
            groupInfo = new SparseArray();
        }
    }

    private static class DummyView extends View
    {

        private Drawable divider;
        private int dividerHeight;
        private int dividerWidth;
        private List views;

        public void addFakeView(View view)
        {
            view.layout(0, 0, getWidth(), getHeight());
            views.add(view);
        }

        public void clearViews()
        {
            views.clear();
        }

        public void dispatchDraw(Canvas canvas)
        {
            canvas.save();
            divider.setBounds(0, 0, dividerWidth, dividerHeight);
            int j = views.size();
            for (int i = 0; i < j; i++)
            {
                View view = (View)views.get(i);
                view.draw(canvas);
                canvas.translate(0.0F, view.getMeasuredHeight());
                divider.draw(canvas);
                canvas.translate(0.0F, dividerHeight);
            }

            canvas.restore();
        }

        protected void onLayout(boolean flag, int i, int j, int k, int l)
        {
            super.onLayout(flag, i, j, k, l);
            int j1 = views.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                ((View)views.get(i1)).layout(i, j, k, l);
            }

        }

        public void setDivider(Drawable drawable, int i, int j)
        {
            divider = drawable;
            dividerWidth = i;
            dividerHeight = j;
            drawable.setBounds(0, 0, i, j);
        }

        public DummyView(Context context)
        {
            super(context);
            views = new ArrayList();
        }
    }

    private static class ExpandAnimation extends Animation
    {

        private int baseHeight;
        private int delta;
        private GroupInfo groupInfo;
        private View view;

        protected void applyTransformation(float f, Transformation transformation)
        {
            super.applyTransformation(f, transformation);
            if (f < 1.0F)
            {
                int i = baseHeight + (int)((float)delta * f);
                view.getLayoutParams().height = i;
                groupInfo.dummyHeight = i;
                view.requestLayout();
                return;
            } else
            {
                int j = baseHeight + delta;
                view.getLayoutParams().height = j;
                groupInfo.dummyHeight = j;
                view.requestLayout();
                return;
            }
        }

        private ExpandAnimation(View view1, int i, int j, GroupInfo groupinfo)
        {
            baseHeight = i;
            delta = j - i;
            view = view1;
            groupInfo = groupinfo;
            view.getLayoutParams().height = i;
            view.requestLayout();
        }

    }

    private static class GroupInfo
    {

        boolean animating;
        int dummyHeight;
        boolean expanding;
        int firstChildPosition;

        private GroupInfo()
        {
            animating = false;
            expanding = false;
            dummyHeight = -1;
        }

    }


    private static final int ANIMATION_DURATION = 300;
    private AnimatedExpandableListAdapter adapter;

    public AnimatedExpandableListView(Context context)
    {
        super(context);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private int getAnimationDuration()
    {
        return 300;
    }

    public boolean collapseGroupWithAnimation(int i)
    {
        int l = getFlatListPosition(getPackedPositionForGroup(i));
        int k = 0;
        int j = k;
        if (l != -1)
        {
            j = l - getFirstVisiblePosition();
            if (j >= 0 && j < getChildCount())
            {
                View view = getChildAt(j);
                j = k;
                if (view != null)
                {
                    j = k;
                    if (view.getBottom() >= getHeight())
                    {
                        j = 1;
                    }
                }
            } else
            {
                j = 1;
            }
        }
        if (j != 0)
        {
            return collapseGroup(i);
        }
        long l1 = getExpandableListPosition(getFirstVisiblePosition());
        j = getPackedPositionChild(l1);
        k = getPackedPositionGroup(l1);
        if (j == -1 || k != i)
        {
            j = 0;
        }
        adapter.startCollapseAnimation(i, j);
        adapter.notifyDataSetChanged();
        return isGroupExpanded(i);
    }

    public boolean expandGroupWithAnimation(int i)
    {
        int j = getFlatListPosition(getPackedPositionForGroup(i));
        if (j != -1)
        {
            j -= getFirstVisiblePosition();
            if (j < getChildCount())
            {
                View view = getChildAt(j);
                if (view != null && view.getBottom() >= getHeight())
                {
                    adapter.notifyGroupExpanded(i);
                    return expandGroup(i);
                }
            }
        }
        adapter.startExpandAnimation(i, 0);
        return expandGroup(i);
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter)
    {
        super.setAdapter(expandablelistadapter);
        if (expandablelistadapter instanceof AnimatedExpandableListAdapter)
        {
            adapter = (AnimatedExpandableListAdapter)expandablelistadapter;
            adapter.setParent(this);
            return;
        } else
        {
            throw new ClassCastException((new StringBuilder()).append(expandablelistadapter.toString()).append(" must implement AnimatedExpandableListAdapter").toString());
        }
    }

}
