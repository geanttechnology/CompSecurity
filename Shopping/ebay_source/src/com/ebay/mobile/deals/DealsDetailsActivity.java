// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.deals:
//            DealsContentAdapter

public class DealsDetailsActivity extends BaseActivity
    implements com.ebay.mobile.common.view.ViewModel.OnClickListener, com.ebay.nautilus.domain.content.dm.UssContentsDataManager.Observer
{

    public static final String EXTRA_CONTENT_ID = "contentId";
    public static final String EXTRA_DEALS_TITLE = "dealsTitle";
    public static final String EXTRA_IS_DEALS_CATEGORY = "isDealsCategory";
    private static String contentId;
    private static String dealsTitle;
    private DealsContentAdapter adapter;
    private boolean isDealsCategory;
    private View progressView;
    private RecyclerView recyclerView;

    public DealsDetailsActivity()
    {
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
        obj = recyclerView;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((RecyclerView) (obj)).setVisibility(i);
    }

    public static void startActivity(Activity activity, String s, String s1, boolean flag)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/deals/DealsDetailsActivity);
        intent.putExtra("contentId", s1);
        intent.putExtra("isDealsCategory", flag);
        intent.putExtra("dealsTitle", s);
        activity.startActivity(intent);
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof ListingViewModel)
        {
            ItemViewActivity.StartActivity(this, Long.parseLong(((ListingViewModel)viewmodel).listingId), com.ebay.common.ConstantsCommon.ItemKind.Deals);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        contentId = bundle.getStringExtra("contentId");
        if (contentId == null)
        {
            finish();
        }
        dealsTitle = bundle.getStringExtra("dealsTitle");
        isDealsCategory = bundle.getBooleanExtra("isDealsCategory", false);
        setContentView(0x7f030086);
        recyclerView = (RecyclerView)findViewById(0x102000a);
        progressView = findViewById(0x7f1000ca);
        showProgress(true);
        adapter = new DealsContentAdapter(this, dealsTitle, Boolean.valueOf(true));
        adapter.setOnClickListener(this, new int[0]);
        recyclerView.setAdapter(adapter);
        bundle = new GridLayoutManager(this, adapter.getNumSpans());
        bundle.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

            final DealsDetailsActivity this$0;

            public int getSpanSize(int i)
            {
                switch (adapter.getItemViewType(i))
                {
                default:
                    return 1;

                case 45: // '-'
                    return adapter.getNumSpans();
                }
            }

            
            {
                this$0 = DealsDetailsActivity.this;
                super();
            }
        });
        recyclerView.setLayoutManager(bundle);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        com.ebay.nautilus.domain.content.dm.UssContentsDataManager.KeyParams keyparams;
        if (isDealsCategory)
        {
            keyparams = UssContentsDataManager.getDealDetailsKeyParams(contentId);
        } else
        {
            keyparams = UssContentsDataManager.getDealDepartmentKeyParams(contentId);
        }
        datamanagercontainer.initialize(keyparams, this);
    }

    public void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1)
    {
        showProgress(false);
        usscontentsdatamanager = content.getStatus();
        if (usscontentsdatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, usscontentsdatamanager);
        } else
        if (content.getData() != null)
        {
            adapter.setContents((Contents)content.getData());
            return;
        }
    }

}
