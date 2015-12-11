// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.viewitem.ViewItemViewData;

public class ViewItemBaseFragment extends BaseFragment
    implements android.view.View.OnClickListener
{
    public static interface ActivityRefreshListener
    {

        public static final String MEB_FLAGS = "meb_flags";

        public abstract void deleteCachedItem();

        public abstract void reloadItemFromNetwork(Intent intent);
    }

    public static final class ExpandState extends Enum
    {

        private static final ExpandState $VALUES[];
        public static final ExpandState COLLAPSED;
        public static final ExpandState EXPANDED;
        public static final ExpandState EXPANDED_ALL;
        public static final ExpandState NONE;

        public static ExpandState valueOf(String s)
        {
            return (ExpandState)Enum.valueOf(com/ebay/mobile/viewitem/fragments/ViewItemBaseFragment$ExpandState, s);
        }

        public static ExpandState[] values()
        {
            return (ExpandState[])$VALUES.clone();
        }

        static 
        {
            NONE = new ExpandState("NONE", 0);
            COLLAPSED = new ExpandState("COLLAPSED", 1);
            EXPANDED = new ExpandState("EXPANDED", 2);
            EXPANDED_ALL = new ExpandState("EXPANDED_ALL", 3);
            $VALUES = (new ExpandState[] {
                NONE, COLLAPSED, EXPANDED, EXPANDED_ALL
            });
        }

        private ExpandState(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface ItemEndedListener
    {

        public abstract void onItemEnded();
    }

    public static interface ProgressIndicatorListener
    {

        public abstract void hideProgress();

        public abstract void showProgress();
    }


    public static final int DEFAULT_COLLAPSED_SIZE = 2;
    public static final int DEFAULT_EXPANDED_SIZE = 200;
    public static final String PARAM_COLLAPSED_SIZE = "collapsed_size";
    public static final String PARAM_EXPANDABLE = "expandable";
    public static final String PARAM_EXPANDED_SIZE = "expanded_size";
    public static final String PARAM_EXPAND_STATE = "expanded_state";
    public static final String PARAM_FULL_EXPANSION = "full_expansion";
    public static final String PARAM_SEE_ALL = "see_all";
    protected static Animation animationSlideDown;
    protected static Animation animationSlideUp;
    protected ActivityRefreshListener activityRefreshListener;
    protected View chevronIcon;
    protected int collapsedSize;
    protected ExpandState expandState;
    protected int expandedSize;
    protected boolean fullExpansion;
    protected LayoutInflater inflater;
    protected boolean isExpandable;
    protected Item item;
    protected ItemEndedListener itemEndedListener;
    protected ProgressIndicatorListener progressListener;
    protected Resources resources;
    protected boolean seeAll;
    protected View seeAllDivider;
    protected TextView seeAllTextView;
    protected View seeAllView;
    private View showLessView;
    private View showMoreView;
    protected View view;
    protected ViewItemViewData viewData;

    public ViewItemBaseFragment()
    {
    }

    public boolean hasContent()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (view.getVisibility() == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isCollapsed()
    {
        return !isExpandable || expandState == ExpandState.COLLAPSED;
    }

    public boolean isExpanded()
    {
        return isExpandable && (expandState == ExpandState.EXPANDED || expandState == ExpandState.EXPANDED_ALL);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        resources = bundle.getResources();
        if (isExpandable)
        {
            if (animationSlideUp == null)
            {
                animationSlideUp = AnimationUtils.loadAnimation(bundle, 0x7f040018);
            }
            if (animationSlideDown == null)
            {
                animationSlideDown = AnimationUtils.loadAnimation(bundle, 0x7f040015);
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            progressListener = (ProgressIndicatorListener)activity;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ProgressListener").toString());
        }
        try
        {
            activityRefreshListener = (ActivityRefreshListener)activity;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ActivityRefreshListener").toString());
        }
        try
        {
            itemEndedListener = (ItemEndedListener)activity;
            return;
        }
        catch (ClassCastException classcastexception2)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ItemEndedListener").toString());
        }
    }

    public void onClick(View view1)
    {
        switch (view1.getId())
        {
        default:
            return;

        case 2131757224: 
            render(item, viewData, trackExpansion(ExpandState.EXPANDED));
            return;

        case 2131757225: 
            render(item, viewData, trackExpansion(ExpandState.COLLAPSED));
            return;

        case 2131755561: 
            seeAllClicked();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        inflater = (LayoutInflater)getActivity().getSystemService("layout_inflater");
        if (bundle != null)
        {
            Object obj = bundle.getString("expanded_state");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj = ExpandState.valueOf(((String) (obj)));
            } else
            {
                obj = ExpandState.COLLAPSED;
            }
            expandState = ((ExpandState) (obj));
            collapsedSize = bundle.getInt("collapsed_size", 2);
            expandedSize = bundle.getInt("expanded_size", 200);
            isExpandable = bundle.getBoolean("expandable", false);
            seeAll = bundle.getBoolean("see_all", false);
            fullExpansion = bundle.getBoolean("full_expansion", false);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (expandState != null)
        {
            bundle.putString("expanded_state", expandState.name());
        }
        bundle.putInt("collapsed_size", collapsedSize);
        bundle.putInt("expanded_size", expandedSize);
        bundle.putBoolean("expandable", isExpandable);
        bundle.putBoolean("see_all", seeAll);
        bundle.putBoolean("full_expansion", fullExpansion);
        super.onSaveInstanceState(bundle);
    }

    public void render(Item item1, ViewItemViewData viewitemviewdata)
    {
        if (getActivity() != null && !getActivity().isFinishing())
        {
            ExpandState expandstate = expandState;
            if (fullExpansion)
            {
                expandstate = ExpandState.EXPANDED_ALL;
            }
            ExpandState expandstate1 = expandstate;
            if (expandstate == null)
            {
                expandstate1 = ExpandState.COLLAPSED;
            }
            expandState = expandstate1;
            render(item1, viewitemviewdata, expandstate1);
            if (fullExpansion && chevronIcon != null)
            {
                chevronIcon.setVisibility(8);
            }
        }
    }

    protected void render(Item item1, ViewItemViewData viewitemviewdata, ExpandState expandstate)
    {
        item = item1;
        viewData = viewitemviewdata;
        expandState = expandstate;
        if (isExpandable && !fullExpansion)
        {
            boolean flag;
            if (expandstate == ExpandState.COLLAPSED)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showMoreOrLess(Boolean.valueOf(flag));
        }
    }

    protected void seeAllClicked()
    {
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
        collapsedSize = bundle.getInt("collapsed_size", 2);
        expandedSize = bundle.getInt("expanded_size", 200);
        isExpandable = bundle.getBoolean("expandable", false);
        seeAll = bundle.getBoolean("see_all", false);
        fullExpansion = bundle.getBoolean("full_expansion", false);
    }

    protected void setSeeAllVisibility(boolean flag)
    {
        if (seeAll && seeAllView != null)
        {
            View view1 = seeAllView;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view1.setVisibility(i);
        }
    }

    protected void setupFragment(View view1)
    {
        if (view1 != null)
        {
            showMoreView = view1.findViewById(0x7f1008a8);
            showLessView = view1.findViewById(0x7f1008a9);
            chevronIcon = view1.findViewById(0x7f100874);
            if (isExpandable)
            {
                if (showMoreView != null)
                {
                    showMoreView.setOnClickListener(this);
                    showMoreView.setVisibility(0);
                }
                if (showLessView != null)
                {
                    showLessView.setOnClickListener(this);
                }
            }
            if (seeAll)
            {
                seeAllView = view1.findViewById(0x7f100229);
                seeAllDivider = view1.findViewById(0x7f1008a6);
                if (seeAllView != null)
                {
                    seeAllView.setOnClickListener(this);
                }
                seeAllTextView = (TextView)view1.findViewById(0x7f1008a7);
                return;
            }
        }
    }

    protected void showMoreOrLess(Boolean boolean1)
    {
        byte byte2 = 8;
        byte byte3 = 8;
        byte byte0 = byte3;
        byte byte1 = byte2;
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
            {
                byte1 = 0;
                byte0 = byte3;
            } else
            {
                byte0 = 0;
                byte1 = byte2;
            }
        }
        if (showMoreView != null)
        {
            showMoreView.setVisibility(byte1);
        }
        if (showLessView != null)
        {
            showLessView.setVisibility(byte0);
        }
    }

    public ExpandState trackExpansion(ExpandState expandstate)
    {
        TrackingData trackingdata = new TrackingData("ViewItemContainerExpansion", "ViewItemFlags", TrackingType.EVENT);
        trackingdata.addKeyValuePair("ces", expandstate.name());
        trackingdata.addKeyValuePair("cesn", getClass().getSimpleName());
        trackingdata.send(getActivity());
        return expandstate;
    }
}
