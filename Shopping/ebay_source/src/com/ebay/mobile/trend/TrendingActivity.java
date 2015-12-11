// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.collections.CollectionDetailsActivity;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.TrendingDataManager;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.trend:
//            TrendTopicAdapter, TopicViewModel, TopicListingViewModel

public class TrendingActivity extends BaseActivity
    implements com.ebay.nautilus.domain.content.dm.TrendingDataManager.Observer
{

    public static final String EXTRA_TREND_TOPIC_ANCHOR = "trend_topic_anchors";
    public static final String TREND_ITEM_LIST = "trend_items";
    protected static boolean isTablet;
    private int anchorPos;
    private View progressView;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener trendItemClickClickListener;
    private List trendItemList;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener trendSeeMoreClickListener;
    private TrendTopicAdapter trendTopicAdapter;
    private RecyclerView trendingTopicView;

    public TrendingActivity()
    {
        trendSeeMoreClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final TrendingActivity this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof TopicViewModel)
                {
                    view = (TopicViewModel)viewmodel;
                    if (!TextUtils.isEmpty(((TopicViewModel) (view)).collectionId))
                    {
                        CollectionDetailsActivity.startActivity(TrendingActivity.this, ((TopicViewModel) (view)).collectionId, null, null);
                    } else
                    if (((TopicViewModel) (view)).searchParameters != null)
                    {
                        startActivity(ActivityStarter.getSearchResultListIntent(TrendingActivity.this, ((TopicViewModel) (view)).searchParameters, null));
                        return;
                    }
                }
            }

            
            {
                this$0 = TrendingActivity.this;
                super();
            }
        };
        trendItemClickClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final TrendingActivity this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof TopicListingViewModel)
                {
                    view = (TopicListingViewModel)viewmodel;
                    if (!TextUtils.isEmpty(((TopicListingViewModel) (view)).listingId))
                    {
                        long l = NumberUtil.safeParseLong(((TopicListingViewModel) (view)).listingId, -1L);
                        if (l != -1L)
                        {
                            ItemViewActivity.StartActivity(TrendingActivity.this, l, com.ebay.common.ConstantsCommon.ItemKind.CustomList);
                        }
                    }
                }
            }

            
            {
                this$0 = TrendingActivity.this;
                super();
            }
        };
    }

    private void showProgress(boolean flag)
    {
        byte byte0 = 8;
        Object obj = progressView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = trendingTopicView;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((RecyclerView) (obj)).setVisibility(i);
    }

    public String getTrackingEventName()
    {
        return "TrendingHub";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030275);
        isTablet = getResources().getBoolean(0x7f0b0006);
        trendTopicAdapter = new TrendTopicAdapter(this);
        trendTopicAdapter.setOnClickListener(trendItemClickClickListener, new int[] {
            3
        });
        trendTopicAdapter.setOnClickListener(trendSeeMoreClickListener, new int[] {
            2
        });
        trendingTopicView = (RecyclerView)findViewById(0x7f100838);
        progressView = findViewById(0x7f1000ca);
        trendingTopicView.setLayoutManager(trendTopicAdapter.createLayoutManager());
        trendingTopicView.setAdapter(trendTopicAdapter);
        trendingTopicView.addItemDecoration(trendTopicAdapter.itemDecorator);
        if (bundle != null)
        {
            trendItemList = bundle.getParcelableArrayList("trend_items");
            if (trendItemList != null)
            {
                trendTopicAdapter.setTrendItems(trendItemList);
            }
            return;
        } else
        {
            anchorPos = getIntent().getIntExtra("trend_topic_anchors", 0);
            showProgress(true);
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer.initialize(TrendingDataManager.KEY, this);
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (trendItemList != null)
        {
            bundle.putParcelableArrayList("trend_items", new ArrayList(trendItemList));
        }
    }

    public void onTrendsContentChanged(TrendingDataManager trendingdatamanager, Content content)
    {
        trendItemList = (List)content.getData();
        trendTopicAdapter.setTrendItems((List)content.getData());
        if (anchorPos > 0)
        {
            trendingTopicView.scrollToPosition(anchorPos);
            anchorPos = 0;
        }
        showProgress(false);
    }
}
