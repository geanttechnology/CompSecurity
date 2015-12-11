// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.ui.HorizontalListView;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.DataUtil;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.UniversalLink;

// Referenced classes of package com.amazon.mShop.home:
//            HomeShovelerItemsAdapter

public class HomeShovelerView extends LinearLayout
    implements HomeShovelerItemsAdapter.HomeShovelerItemsShownSubscriber
{

    private String mHomeCarouselArg;
    private HomeShoveler mHomeShoveler;
    private HorizontalListView mItemsHorizontalListView;
    private View mLeftFading1;
    private View mLeftFading2;
    private String mMoreLinkRefMarker;
    private PageMetricsObserver mPageMetricsCriticalFeatureObserver;
    private PageMetricsObserver mPageMetricsObserver;
    private PageMetricsObserver mPageMetricsRefreshCriticalFeatureObserver;
    private String mRequestId;
    private View mRightFading1;
    private View mRightFading2;
    private TextView mShovelerMoreLink;
    private TextView mShovelerTitle;
    private ViewGroup mshovelerTitleContainer;

    public HomeShovelerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void setUpTitleContainerClickListener(boolean flag)
    {
        if (flag)
        {
            mshovelerTitleContainer.setOnClickListener(new android.view.View.OnClickListener() {

                final HomeShovelerView this$0;

                public void onClick(View view)
                {
                    if (mHomeShoveler != null && mHomeShoveler.getMoreLink() != null)
                    {
                        if (!Util.isEmpty(mMoreLinkRefMarker))
                        {
                            RefMarkerObserver.logRefMarker(mMoreLinkRefMarker);
                        }
                        view = (AmazonActivity)getContext();
                        String s = mHomeShoveler.getMoreLink().getUri();
                        if (Util.isEmpty(s) || !(new AmazonNavManager()).navigate(s, view))
                        {
                            String s1 = mHomeShoveler.getMoreLink().getUrl();
                            if (!Util.isEmpty(s1))
                            {
                                if (DataUtil.isEqual(mHomeShoveler.getDisplayType(), 1))
                                {
                                    ActivityUtils.startAIVWebActivity(view, s1, false);
                                    return;
                                } else
                                {
                                    WebUtils.openWebview(view, s1);
                                    return;
                                }
                            }
                        }
                    }
                }

            
            {
                this$0 = HomeShovelerView.this;
                super();
            }
            });
            return;
        } else
        {
            mshovelerTitleContainer.setOnClickListener(null);
            return;
        }
    }

    private void updateHeight(int i)
    {
        findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview_container).getLayoutParams().height = i;
        findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview).getLayoutParams().height = i;
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_left_fading_1).getLayoutParams().height = i;
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_left_fading_2).getLayoutParams().height = i;
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_right_fading_1).getLayoutParams().height = i;
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_right_fading_2).getLayoutParams().height = i;
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_loading_placeholder).getLayoutParams().height = i;
    }

    private void updateTitleContainer()
    {
        if (mHomeShoveler != null && !Util.isEmpty(mHomeShoveler.getMoreLinkText()) && mHomeShoveler.getMoreLink() != null)
        {
            mShovelerMoreLink.setText(mHomeShoveler.getMoreLinkText());
            mShovelerMoreLink.setVisibility(0);
            setUpTitleContainerClickListener(true);
            mshovelerTitleContainer.setFocusable(true);
            mshovelerTitleContainer.setClickable(true);
            mshovelerTitleContainer.setBackgroundResource(com.amazon.mShop.android.lib.R.color.common_arrow_selector);
        } else
        {
            mShovelerMoreLink.setVisibility(8);
            setUpTitleContainerClickListener(false);
            mshovelerTitleContainer.setFocusable(false);
            mshovelerTitleContainer.setClickable(false);
            mshovelerTitleContainer.setBackgroundDrawable(null);
        }
        mshovelerTitleContainer.setPadding((int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding), (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding), (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding_icon_selector_right), (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding));
    }

    public void clear()
    {
        mHomeShoveler = null;
        updateShovelerTitle(null);
        updateTitleContainer();
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_loading_placeholder).setVisibility(0);
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_loading_progressbar).setVisibility(0);
        findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview).setVisibility(8);
        findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview_container).setVisibility(8);
        HomeShovelerItemsAdapter homeshoveleritemsadapter = (HomeShovelerItemsAdapter)mItemsHorizontalListView.getAdapter();
        if (homeshoveleritemsadapter != null)
        {
            homeshoveleritemsadapter.reset();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_loading_progressbar).setVisibility(8);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mShovelerTitle = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler_title);
        mShovelerMoreLink = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler_more_link);
        mItemsHorizontalListView = (HorizontalListView)findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview);
        mItemsHorizontalListView.setHighlightBackgroundResource(com.amazon.mShop.android.lib.R.drawable.orange_outline_sharp_corner);
        mItemsHorizontalListView.setNormalBackgroundResource(com.amazon.mShop.android.lib.R.color.transparent);
        mshovelerTitleContainer = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler_title_container);
        mLeftFading1 = findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_left_fading_1);
        mLeftFading2 = findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_left_fading_2);
        mRightFading1 = findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_right_fading_1);
        mRightFading2 = findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_right_fading_2);
    }

    public void onHomeShovelerItemsShown()
    {
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_loading_placeholder).setVisibility(8);
        findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_loading_progressbar).setVisibility(8);
        findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview).setVisibility(0);
        findViewById(com.amazon.mShop.android.lib.R.id.items_horizontal_listview_container).setVisibility(0);
    }

    public void onMostLeftItemFocused(boolean flag)
    {
        if (flag)
        {
            mLeftFading1.setVisibility(8);
            mLeftFading2.setVisibility(8);
            return;
        } else
        {
            mLeftFading1.setVisibility(0);
            mLeftFading2.setVisibility(0);
            return;
        }
    }

    public void onMostRightItemFocused(boolean flag)
    {
        if (flag)
        {
            mRightFading1.setVisibility(8);
            mRightFading2.setVisibility(8);
            return;
        } else
        {
            mRightFading1.setVisibility(0);
            mRightFading2.setVisibility(0);
            return;
        }
    }

    public void setHomeCarouselArg(String s)
    {
        mHomeCarouselArg = s;
    }

    public void setMoreLinkRefMarker(String s)
    {
        mMoreLinkRefMarker = s;
    }

    public void update(HomeShoveler homeshoveler, PageMetricsObserver pagemetricsobserver, PageMetricsObserver pagemetricsobserver1, PageMetricsObserver pagemetricsobserver2, String s)
    {
        if (homeshoveler == null)
        {
            return;
        }
        mRequestId = s;
        mPageMetricsObserver = pagemetricsobserver;
        mPageMetricsCriticalFeatureObserver = pagemetricsobserver1;
        mPageMetricsRefreshCriticalFeatureObserver = pagemetricsobserver2;
        mHomeShoveler = homeshoveler;
        updateShovelerTitle(homeshoveler.getTitle());
        updateTitleContainer();
        int i;
        if (DataUtil.isEqual(homeshoveler.getDisplayType(), 1))
        {
            i = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.home_view_shoveler_view_thumbnail_max_dimension);
        } else
        {
            i = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.home_view_shoveler_view_height);
        }
        updateHeight(i);
        pagemetricsobserver = new HomeShovelerItemsAdapter(getContext(), homeshoveler.getSlotToken(), homeshoveler.getClickStreamOrigin(), mHomeCarouselArg, mPageMetricsObserver, mPageMetricsCriticalFeatureObserver, mPageMetricsRefreshCriticalFeatureObserver, this, mRequestId, homeshoveler.getDisplayType());
        if (mPageMetricsObserver != null)
        {
            mPageMetricsObserver.startForObject(com/amazon/mShop/home/HomeShovelerView.getSimpleName());
        }
        if (mPageMetricsCriticalFeatureObserver != null)
        {
            mPageMetricsCriticalFeatureObserver.startForObject(com/amazon/mShop/home/HomeShovelerView.getSimpleName());
        }
        if (mPageMetricsRefreshCriticalFeatureObserver != null)
        {
            mPageMetricsRefreshCriticalFeatureObserver.startForObject(com/amazon/mShop/home/HomeShovelerView.getSimpleName());
        }
        mItemsHorizontalListView.setAdapter(pagemetricsobserver);
        pagemetricsobserver.setRawItems(homeshoveler.getItems());
    }

    public void updateShovelerTitle(String s)
    {
        String s1 = s;
        if (Util.isEmpty(s))
        {
            s1 = getResources().getString(com.amazon.mShop.android.lib.R.string.loading);
        }
        mShovelerTitle.setText(s1);
    }


}
