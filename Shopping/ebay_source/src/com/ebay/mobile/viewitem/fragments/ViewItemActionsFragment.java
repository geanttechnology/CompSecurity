// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwActivity;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment, ActionsFactory

public class ViewItemActionsFragment extends ViewItemBaseFragment
    implements DialogFragmentCallback
{
    public static interface PaymentOptionsHandler
    {

        public abstract void handlePaymentOptions();
    }


    static final int ACTIVITY_RESULT_ADD_TRACKING_DETAILS = 110;
    public static final int ACTIVITY_RESULT_AFTER_SALES = 114;
    static final int ACTIVITY_RESULT_BUYER_MAKE_OFFER = 102;
    static final int ACTIVITY_RESULT_BUYER_VIEW_OFFER = 103;
    static final int ACTIVITY_RESULT_COMPOSE_MESSAGE = 101;
    static final int ACTIVITY_RESULT_CONFIRM = 106;
    public static final int ACTIVITY_RESULT_CREATE_SHIPPING_LABEL = 113;
    static final int ACTIVITY_RESULT_PLACE_OFFER = 105;
    static final int ACTIVITY_RESULT_RELIST = 109;
    static final int ACTIVITY_RESULT_REVISE = 108;
    public static final int ACTIVITY_RESULT_SELLER_REVIEW_OFFERS = 112;
    static final int ACTIVITY_RESULT_SELLER_VIEW_OFFER = 104;
    static final int ACTIVITY_RESULT_SELL_SIMILAR = 111;
    static final int ACTIVITY_RESULT_XO = 107;
    static final int MARK_AS_PAID_ID = 0;
    static final int MARK_AS_SHIPPED_ID = 1;
    static final int MARK_AS_UNPAID_ID = 2;
    static final int MARK_AS_UNSHIPPED_ID = 3;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private ActionsFactory actionsFactory;
    private ViewGroup frame;
    public String overrideStatus;
    private PaymentOptionsHandler paymentOptionsHandler;
    public PriceView priceEditor;
    private View stateView;
    public int tertiaryColor;
    private ViewItemDataManager viewItemDataManager;

    public ViewItemActionsFragment()
    {
    }

    public View findButton(ActionsFactory.Action action)
    {
        Object obj = null;
        View view = obj;
        if (action != null)
        {
            View view1 = getView();
            view = obj;
            if (view1 != null)
            {
                view = view1.findViewWithTag((new StringBuilder()).append("actions_button_").append(action.ordinal()).toString());
            }
        }
        return view;
    }

    void handlePaymentOptions()
    {
        paymentOptionsHandler.handlePaymentOptions();
    }

    public boolean hasContent()
    {
        return stateView != null;
    }

    public boolean isShowingButtons()
    {
        return actionsFactory != null && actionsFactory.hasAddedButtonsToView();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        bundle = getActivity();
        int i = ThemeUtil.resolveThemeSecondaryColorResId(bundle.getTheme(), 0x1010212);
        tertiaryColor = bundle.getResources().getColor(i);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), intent
            });
        }
        i;
        JVM INSTR tableswitch 101 114: default 108
    //                   101 109
    //                   102 138
    //                   103 138
    //                   104 138
    //                   105 108
    //                   106 304
    //                   107 108
    //                   108 138
    //                   109 108
    //                   110 189
    //                   111 108
    //                   112 108
    //                   113 354
    //                   114 434;
           goto _L1 _L2 _L3 _L3 _L3 _L1 _L4 _L1 _L3 _L1 _L5 _L1 _L1 _L6 _L7
_L1:
        return;
_L2:
        if (j == -1)
        {
            viewItemDataManager.setPaymentReminderStatusToSent(viewData.nameValueList);
            progressListener.showProgress();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            if (i == 104)
            {
                SellingListActivity.setSellingInvalid(getFwActivity().getEbayContext());
                intent.putExtra("meb_flags", 1);
            }
            progressListener.showProgress();
            activityRefreshListener.reloadItemFromNetwork(intent);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (j == -1 && intent != null)
        {
            com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
            if (authentication != null)
            {
                i = intent.getIntExtra("state", -1);
                ShipmentTracking shipmenttracking = new ShipmentTracking();
                if (i != 0)
                {
                    shipmenttracking.addDetail(intent.getStringExtra("number"), intent.getStringExtra("carrier"));
                }
                progressListener.showProgress();
                intent = EbayApiUtil.getTradingApi(getActivity(), authentication);
                viewItemDataManager.addShipmentTracking(intent, Long.valueOf(item.id), item.transactionId.longValue(), shipmenttracking, null, null);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j == 504)
        {
            intent = (PriceView)getActivity().findViewById(0x7f1008a0);
            if (intent != null)
            {
                intent.setText(null);
            }
            progressListener.showProgress();
            activityRefreshListener.reloadItemFromNetwork(null);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j == -1)
        {
            SourceIdentification sourceidentification = new SourceIdentification("ShippingLabelSuccess");
            Intent intent1 = getActivity().getIntent();
            intent = intent1;
            if (intent1 == null)
            {
                intent = new Intent();
            }
            intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
            getActivity().setIntent(intent);
            progressListener.showProgress();
            activityRefreshListener.reloadItemFromNetwork(null);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (j == -1)
        {
            overrideStatus = intent.getStringExtra("ebay-after-sales-status");
            actionsFactory.setAfterSalesStatusOverride(overrideStatus);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            paymentOptionsHandler = (PaymentOptionsHandler)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement PaymentOptionsHandler").toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f03027f, viewgroup, false);
        frame = (ViewGroup)view.findViewById(0x7f10086b);
        setupFragment(view);
        return view;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        boolean flag;
        boolean flag2;
        dialogfragment = null;
        flag2 = true;
        flag = true;
        if (j == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = MyApp.getPrefs().getAuthentication();
        i;
        JVM INSTR tableswitch 0 3: default 52
    //                   0 53
    //                   1 135
    //                   2 53
    //                   3 135;
           goto _L3 _L4 _L5 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        if (obj == null || viewItemDataManager == null) goto _L1; else goto _L6
_L6:
        dialogfragment = EbayApiUtil.getTradingApi(getActivity(), ((com.ebay.nautilus.domain.app.Authentication) (obj)));
        obj = viewItemDataManager;
        long l = item.id;
        Long long1 = item.transactionId;
        if (i != 0)
        {
            flag = false;
        }
        ((ViewItemDataManager) (obj)).markItemPaid(dialogfragment, l, long1, null, Boolean.valueOf(flag));
        progressListener.showProgress();
        return;
        if (obj == null || viewItemDataManager == null) goto _L1; else goto _L7
_L7:
        obj = EbayApiUtil.getTradingApi(getActivity(), ((com.ebay.nautilus.domain.app.Authentication) (obj)));
        ViewItemDataManager viewitemdatamanager = viewItemDataManager;
        long l1 = item.id;
        Long long2 = item.transactionId;
        if (i == 3)
        {
            dialogfragment = new ShipmentTracking();
        }
        boolean flag1;
        if (i == 1)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        viewitemdatamanager.markItemShipped(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), l1, long2, dialogfragment, Boolean.valueOf(flag1));
        progressListener.showProgress();
        return;
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        if (debugLogger.isLoggable)
        {
            FwLog.logMethod(debugLogger, new Object[] {
                item, viewitemviewdata, expandstate
            });
        }
        super.render(item, viewitemviewdata, expandstate);
        viewItemDataManager = (ViewItemDataManager)DataManager.get(getFwActivity().getEbayContext(), viewitemviewdata.keyParams);
        if (actionsFactory == null)
        {
            actionsFactory = new ActionsFactory(this, item, viewitemviewdata, viewItemDataManager);
        } else
        {
            actionsFactory.setItemData(item, viewitemviewdata);
        }
        priceEditor = (PriceView)frame.findViewById(0x7f1008a0);
        frame.removeAllViews();
        stateView = actionsFactory.getView(frame);
        if (stateView == null) goto _L2; else goto _L1
_L1:
        frame.addView(stateView);
_L4:
        priceEditor = null;
        return;
_L2:
        if (verboseLogger.isLoggable)
        {
            verboseLogger.log("ActionsFactory.getView returned null!");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VipActionsFrag", 3, "Log VIP Actions Fragment events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended VIP Actions Fragment events");
    }
}
