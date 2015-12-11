// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            AnimatedExpandableListView

public static abstract class groupInfo extends BaseExpandableListAdapter
{

    private static final int STATE_COLLAPSING = 2;
    private static final int STATE_EXPANDING = 1;
    private static final int STATE_IDLE = 0;
    private SparseArray groupInfo;
    private AnimatedExpandableListView parent;

    private groupInfo getGroupInfo(int i)
    {
        groupInfo groupinfo1 = (groupInfo)groupInfo.get(i);
        groupInfo groupinfo = groupinfo1;
        if (groupinfo1 == null)
        {
            groupinfo = new groupInfo(null);
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
        parent parent1 = getGroupInfo(i);
        parent1.getGroupInfo = true;
        parent1.getGroupInfo = j;
        parent1.getGroupInfo = false;
    }

    private void startExpandAnimation(int i, int j)
    {
        getGroupInfo getgroupinfo = getGroupInfo(i);
        getgroupinfo.getGroupInfo = true;
        getgroupinfo.getGroupInfo = j;
        getgroupinfo.getGroupInfo = true;
    }

    private void stopAnimation(int i)
    {
        getGroupInfo(i).getGroupInfo = false;
    }

    public final int getChildType(int i, int j)
    {
        if (getGroupInfo(i).getGroupInfo)
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

    public final View getChildView(final int groupPosition, int i, boolean flag, final View dummyView, ViewGroup viewgroup)
    {
        Object obj;
        final getRealChildTypeCount info;
        final ExpandableListView listView;
        View view;
        int j;
        int k;
        int k1;
        info = getGroupInfo(groupPosition);
        if (info.getGroupInfo)
        {
            obj = dummyView;
            if (dummyView == null)
            {
                obj = new getGroupInfo(viewgroup.getContext());
                ((View) (obj)).setLayoutParams(new android.widget.<init>(-1, 0));
            }
            if (i < info.getGroupInfo)
            {
                ((View) (obj)).getLayoutParams().firstChildPosition = 0;
                return ((View) (obj));
            }
            listView = (ExpandableListView)viewgroup;
            dummyView = (getGroupInfo)obj;
            dummyView.getGroupInfo();
            dummyView.getGroupInfo(listView.getDivider(), viewgroup.getMeasuredWidth(), listView.getDividerHeight());
            int l = android.view.w.setDivider(viewgroup.getWidth(), 0x40000000);
            int i1 = android.view.w.setDivider(0, 0);
            i = 0;
            int j1 = viewgroup.getHeight();
            k1 = getRealChildrenCount(groupPosition);
            k = info.getRealChildrenCount;
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
                    view = getRealChildView(groupPosition, k, flag, null, viewgroup);
                    view.measure(l, i1);
                    i += view.getMeasuredHeight();
                    if (i >= j1)
                    {
                        break label0;
                    }
                    dummyView.getRealChildView(view);
                    k++;
                }
            } while (true);
        }
          goto _L1
        dummyView.getRealChildView(view);
        j = i + (k1 - k - 1) * (i / (k + 1));
        viewgroup = ((ViewGroup) (dummyView.getRealChildView()));
        if (viewgroup == null)
        {
            i = 0;
        } else
        {
            i = ((Integer)viewgroup).intValue();
        }
        if (!info.getRealChildView || i == 1) goto _L3; else goto _L2
_L2:
        viewgroup = new getRealChildView(dummyView, 0, j, info, null);
        viewgroup.getRealChildView(AnimatedExpandableListView.access$500(parent));
        viewgroup.stener(new android.view.animation.Animation.AnimationListener() {

            final AnimatedExpandableListView.AnimatedExpandableListAdapter this$0;
            final AnimatedExpandableListView.DummyView val$dummyView;
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
                this$0 = AnimatedExpandableListView.AnimatedExpandableListAdapter.this;
                groupPosition = i;
                dummyView = dummyview;
                super();
            }
        });
        dummyView._mth1(viewgroup);
        dummyView._mth1(Integer.valueOf(1));
_L4:
        return ((View) (obj));
_L3:
        if (!info._fld1 && i != 2)
        {
            if (info._fld1 == -1)
            {
                info._fld1 = j;
            }
            viewgroup = new _cls1(dummyView, info._fld1, 0, info, null);
            viewgroup._mth1(AnimatedExpandableListView.access$500(parent));
            viewgroup.stener(new android.view.animation.Animation.AnimationListener() {

                final AnimatedExpandableListView.AnimatedExpandableListAdapter this$0;
                final AnimatedExpandableListView.DummyView val$dummyView;
                final int val$groupPosition;
                final AnimatedExpandableListView.GroupInfo val$info;
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
                this$0 = AnimatedExpandableListView.AnimatedExpandableListAdapter.this;
                groupPosition = i;
                listView = expandablelistview;
                info = groupinfo;
                dummyView = dummyview;
                super();
            }
            });
            dummyView._mth2(viewgroup);
            dummyView._mth2(Integer.valueOf(2));
        }
        if (true) goto _L4; else goto _L1
_L1:
        return getRealChildView(groupPosition, i, flag, dummyView, viewgroup);
    }

    public final int getChildrenCount(int i)
    {
        getRealChildView getrealchildview = getGroupInfo(i);
        if (getrealchildview.getGroupInfo)
        {
            return getrealchildview.getGroupInfo + 1;
        } else
        {
            return getRealChildrenCount(i);
        }
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

    public void notifyGroupExpanded(int i)
    {
        getGroupInfo(i).getGroupInfo = -1;
    }





    public _cls2.val.dummyView()
    {
        groupInfo = new SparseArray();
    }
}
