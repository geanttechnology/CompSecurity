// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.transition.GoodsMultiOptionTransitionController;
import com.groupon.animation.ActivityTransitionUtils;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Option;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.manager.DealSyncManager;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.util.TwoTraitOptionAdapter;
import com.groupon.view.GrouponListView;
import com.groupon.view.OneTraitMultiOptionListItem;
import java.util.ArrayList;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory

public class GoodsMultiOption extends GrouponFragmentActivity
    implements GrouponDialogListener, com.groupon.util.TwoTraitOptionAdapter.OptionClickListener, commonlib.manager.SyncManager.SyncUiCallbacks
{

    private BuyUtils buyUtil;
    Channel channel;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    String dealId;
    private DealSyncManager dealSyncManager;
    private DialogManager dialogManager;
    String goodsExtraInfo;
    private IntentFactory intentFactory;
    private boolean isOnPause;
    GrouponListView listView;
    private Logger logger;
    private LoginService loginService;
    int numDealActivitiesInStack;
    View progress;
    Integer traitCount;
    private GoodsMultiOptionTransitionController transitionController;

    public GoodsMultiOption()
    {
        numDealActivitiesInStack = 0;
        isOnPause = false;
    }

    private Intent getDealCardClickedIntent(Option option, com.groupon.util.ViewUtils.Size size)
    {
        DealSummary dealsummary = new DealSummary(deal, channel);
        return intentFactory.newDealIntentWithOption(dealsummary, option, channel, numDealActivitiesInStack, size).putExtra("goods_category_extra_info", goodsExtraInfo);
    }

    private void logStartEvent(Bundle bundle)
    {
        if (bundle == null && traitCount.intValue() == 2)
        {
            logger.logClick("", "user_interaction_multioption_2_traits", "goods_multioption_2_tier", (new StringBuilder()).append(dealId).append(",").append(deal.getOptions().size()).toString());
        }
    }

    private void refresh()
    {
        listView.setAdapter(new TwoTraitOptionAdapter(this, deal, traitCount.intValue()));
        ((TwoTraitOptionAdapter)listView.getAdapter()).setOptionClickListener(this);
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        if (!isOnPause)
        {
            LoaderCallbacksUtil.handleSyncError(runnable, exception, this, loginService, countryUtil, currentCountryManager.getCurrentCountry(), dealSyncManager, intentFactory, new Function2() {

                final GoodsMultiOption this$0;

                public volatile void execute(Object obj, Object obj1)
                    throws Exception
                {
                    execute((Runnable)obj, (Exception)obj1);
                }

                public void execute(Runnable runnable1, Exception exception1)
                {
                    Ln.w(exception1);
                    runnable1 = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f080165));
                    runnable1.setCancelable(false);
                    GrouponDialogFragment.show(getFragmentManager(), runnable1, "http_error_dialog");
                }

            
            {
                this$0 = GoodsMultiOption.this;
                super();
            }
            });
        }
    }

    protected boolean hasCartIcon()
    {
        return true;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f08035c));
    }

    public void onActivityReenter(int i, Intent intent)
    {
        super.onActivityReenter(i, intent);
        transitionController.setReentering(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030118);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            transitionController.setExitSharedElementCallback();
        }
        getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(dealId, bundle) {

            final GoodsMultiOption this$0;
            final Bundle val$finalSavedInstanceState;

            public void onDealLoaded(Deal deal1)
            {
                deal = deal1;
                refresh();
                logStartEvent(finalSavedInstanceState);
                listView.setVisibility(0);
                progress.setVisibility(8);
                Ln.d("GoodsMultiOption Deal Loaded", new Object[0]);
            }

            
            {
                this$0 = GoodsMultiOption.this;
                finalSavedInstanceState = bundle;
                super(final_context, s);
            }
        });
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "http_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public void onOptionClick(Option option, View view, int i)
    {
        String s = option.remoteId;
        logger.logMultiOption("", dealId, s, deal.getOptions().size(), i, "");
        logger.logClick(String.format("{\"traitCount\":%d}", new Object[] {
            traitCount
        }), "select_multioption", "goods_multioption", (new StringBuilder()).append(dealId).append(",").append(s).toString());
        if (!option.isSoldOut() && !buyUtil.isOptionExpired(option))
        {
            Object obj = view.findViewById(0x7f10032d);
            View view1 = view.findViewById(0x7f100330);
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                obj = ActivityTransitionUtils.getDealToDetailsActivityOptions(this, new Pair[] {
                    Pair.create(obj, "deal_image_transition"), Pair.create(view1, "option_title_transition")
                });
            } else
            {
                obj = null;
            }
            startActivity(getDealCardClickedIntent(option, ((OneTraitMultiOptionListItem)view).getImageViewSize()), ((Bundle) (obj)));
        }
    }

    protected void onPause()
    {
        isOnPause = true;
        super.onPause();
        dealSyncManager.stopAutomaticSyncs();
    }

    protected void onResume()
    {
        isOnPause = false;
        super.onResume();
        dealSyncManager.startAutomaticSyncs(this, null);
    }


/*
    static Deal access$002(GoodsMultiOption goodsmultioption, Deal deal1)
    {
        goodsmultioption.deal = deal1;
        return deal1;
    }

*/



}
