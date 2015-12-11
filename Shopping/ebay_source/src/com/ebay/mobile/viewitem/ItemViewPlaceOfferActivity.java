// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.util.Debug;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.fragments.ViewItemFragmentBiddingUtil;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ItemViewActivity, ViewItemViewData, ViewItemDataManager, 
//            ItemViewCommonProgressAndError, ItemViewBidTracking, ViewItemConfirmActivity, PpaUpgradeConfirmDialog

public class ItemViewPlaceOfferActivity extends ItemViewBaseActivity
    implements TextWatcher, android.view.View.OnClickListener, android.view.View.OnKeyListener, android.widget.TextView.OnEditorActionListener, ViewItemDataManager.Observer, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{

    static final int ACTIVITY_RESULT_CONFIRM = 1;
    private static final String PARAM_BID_AMOUNT = "bidAmount";
    private static final String PARAM_USE_LONG_THRESHOLD = "useLongThreshold";
    private TextView bidAtLeast;
    private PriceView bidEditView;
    private TextView bidEntryLabelTextView;
    private String bidSource;
    private TextView numBidsView;
    private String referrer;
    private final EbayTimer timer = new EbayTimer(1000L);
    private boolean useLongThreshold;

    public ItemViewPlaceOfferActivity()
    {
    }

    private void enableButtons()
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        ((TextView)findViewById(0x7f1004d6)).setEnabled(isValidBid());
    }

    private boolean isPlaceInitialBid()
    {
        return !viewItemDataManager.isInMyEbayBidList(item.id, viewData.nameValueList);
    }

    private boolean isValidBid()
    {
        return Item.isValidBid(item, bidEditView.getPrice());
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final ItemViewPlaceOfferActivity this$0;

            public void OnTimer()
            {
                updateTimeLeft();
                render();
            }

            
            {
                this$0 = ItemViewPlaceOfferActivity.this;
                super();
            }
        });
    }

    public static void startActivity(BaseActivity baseactivity, Fragment fragment, ViewItemViewData viewitemviewdata, String s, String s1, String s2, int i, boolean flag)
    {
        Object obj;
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                s1
            });
        }
        double d;
        double d1;
        if (fragment != null)
        {
            obj = fragment.getActivity();
        } else
        {
            obj = baseactivity;
        }
        obj = new Intent(((android.content.Context) (obj)), com/ebay/mobile/viewitem/ItemViewPlaceOfferActivity);
        ((Intent) (obj)).putExtra("view_item_view_data", viewitemviewdata);
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        d = -1D;
        d1 = Double.parseDouble(s1);
        d = d1;
_L4:
        ((Intent) (obj)).putExtra("bidAmount", d);
_L2:
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.BidSource", s2);
        ((Intent) (obj)).putExtra("useLongThreshold", flag);
        if (fragment != null)
        {
            fragment.startActivityForResult(((Intent) (obj)), i);
            return;
        } else
        {
            baseactivity.startActivityForResult(((Intent) (obj)), i);
            return;
        }
        viewitemviewdata;
        ItemViewActivity.logTag.logAsError((new StringBuilder()).append("ItemViewPlaceOfferActivity.startActivity: failed to parse bidAmount=").append(s1).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void startConfirmActivityStage1()
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        if (item.isGspItem)
        {
            com.ebay.nautilus.domain.data.PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
            if (viewItemDataManager != null)
            {
                Object obj = ViewItemFragmentBiddingUtil.getBidForConfirm(item, bidEditView);
                ViewItemDataManager viewitemdatamanager = viewItemDataManager;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((CurrencyAmount) (obj)).toItemCurrency();
                }
                viewitemdatamanager.getShippingCosts(postalcodespecification, 1, ((ItemCurrency) (obj)));
            }
            return;
        } else
        {
            startConfirmActivityStage2();
            return;
        }
    }

    private void startConfirmActivityStage2()
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        CurrencyAmount currencyamount = ViewItemFragmentBiddingUtil.getBidForConfirm(item, bidEditView);
        boolean flag = ItemViewBidTracking.isIncrementalBid(item, viewItemDataManager, currencyamount);
        ViewItemConfirmActivity.StartActivity(this, null, false, viewData, 1, currencyamount, false, referrer, bidSource, flag, useLongThreshold, 1);
    }

    private void updateTimeLeft()
    {
        ItemViewActivity.UpdateTimeLeft(this, (TextView)findViewById(0x7f1002f4), viewData, item, false, useLongThreshold);
        if (item.isAuctionEnded)
        {
            ItemViewCommonProgressAndError.setPrimaryErrorMessage(this, getString(0x7f07017b));
            setTakeActionButtonEnabled(this, false);
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.CUSTOM_ERROR);
        }
    }

    public void afterTextChanged(Editable editable)
    {
        enableButtons();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        i;
        JVM INSTR tableswitch 1 1: default 40
    //                   1 41;
           goto _L1 _L2
_L1:
        return;
_L2:
        setResult(j);
        if (-1 == j)
        {
            getWindow().setSoftInputMode(3);
            setResult(-1, intent);
            finish();
            return;
        }
        if (503 == j)
        {
            finish();
            return;
        }
        if (502 == j)
        {
            setResult(0, intent);
            showDialog(0x7f0707aa);
            return;
        }
        if (505 == j && intent != null)
        {
            String s = intent.getStringExtra("bidTooLowErrorMessage");
            if (!TextUtils.isEmpty(s))
            {
                TextView textview = (TextView)findViewById(0x7f1004df);
                if (textview != null)
                {
                    textview.setText(s);
                    textview.setTextColor(getResources().getColor(0x7f0d0064));
                    textview.setVisibility(0);
                }
            }
            intent = (ItemCurrency)intent.getParcelableExtra("current_price");
            if (item != null && intent != null)
            {
                item.currentPrice = intent;
                headerInnards((ViewGroup)findViewById(0x7f1002ec), true);
            }
            render();
            return;
        }
        if (504 == j)
        {
            setResult(j, intent);
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                content
            });
        }
        if (isFinishing())
        {
            return;
        }
        if (!content.getStatus().hasError())
        {
            item = ((ViewItemDataManager.ViewItemLiteInfo)content.getData()).item;
            if (item == null && ItemViewActivity.logTag.isLoggable)
            {
                FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                    "onBidUpdated set item to null"
                });
            }
            viewitemdatamanager = ((ViewItemDataManager.ViewItemLiteInfo)content.getData()).bidEvent;
            if (((ViewItemDataManager.BidEvent) (viewitemdatamanager)).changed && ((ViewItemDataManager.BidEvent) (viewitemdatamanager)).vibrate)
            {
                Util.vibratePhone(this);
            }
            if (!viewData.finalized && item.finalized)
            {
                viewItemDataManager.markDirty();
                finish();
            }
            headerStart(0x7f03012d, true);
            render();
            return;
        } else
        {
            EbayErrorHandler.handleResultStatus(this, 0, content.getStatus());
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755328: 
        case 2131755356: 
            finish();
            return;

        case 2131756246: 
            startConfirmActivityStage1();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301a3);
        setTitle(getString(0x7f07079b));
        bundle = getIntent();
        viewData = (ViewItemViewData)bundle.getParcelableExtra("view_item_view_data");
        referrer = bundle.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = bundle.getStringExtra("com.ebay.mobile.tracking.BidSource");
        useLongThreshold = bundle.getBooleanExtra("useLongThreshold", false);
        double d = bundle.getDoubleExtra("bidAmount", -1D);
        bidAtLeast = (TextView)findViewById(0x7f1004e1);
        numBidsView = (TextView)findViewById(0x7f1002f3);
        bidEditView = (PriceView)findViewById(0x7f1004e2);
        if (d != -1D)
        {
            bidEditView.setPrice(Double.valueOf(d));
        }
        bidEditView.selectAll();
        bidEditView.setOnKeyListener(this);
        bidEditView.setOnEditorActionListener(this);
        bidEditView.addTextChangedListener(this);
        bidEditView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final ItemViewPlaceOfferActivity this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    getWindow().setSoftInputMode(5);
                }
            }

            
            {
                this$0 = ItemViewPlaceOfferActivity.this;
                super();
            }
        });
        ItemViewCommonProgressAndError.setOkNotRetry(this).setOnClickListener(this);
        bidEntryLabelTextView = (TextView)findViewById(0x7f1004e0);
        bundle = (TextView)findViewById(0x7f1004d6);
        bundle.setOnClickListener(this);
        bundle.setEnabled(false);
        initDataManagers();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 2131167146: 
            return PpaUpgradeConfirmDialog.create(this, false);
        }
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                content, actionhandled, Boolean.valueOf(flag)
            });
        }
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (content.getStatus().hasError())
        {
            break; /* Loop/switch isn't completed */
        }
        static class _cls3
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.SHIPPING_COSTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            headerStart(0x7f03012d, true);
            updateTimeLeft();
            setupTimer();
            render();
            if (item != null && item.currentPrice != null)
            {
                bidEditView.setCurrency(item.currentPrice.code);
                return;
            }
            break;

        case 2: // '\002'
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
            startConfirmActivityStage2();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        setTakeActionButtonEnabled(this, false);
        showMessage(0, content.getStatus());
        return;
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (textview.getId() == 0x7f1004e2)
        {
            enableButtons();
        }
        if (i == 6 && isValidBid())
        {
            startConfirmActivityStage1();
        }
        return false;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
        if (ItemViewActivity.logTag.isLoggable)
        {
            ItemViewActivity.logTag.log((new StringBuilder()).append("onInitializeDataManagers, viewItemDataManager=").append(viewItemDataManager.toString()).toString());
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        enableButtons();
        if (keyevent.getAction() != 0 || i != 66 || !isValidBid()) goto _L2; else goto _L1
_L1:
        startConfirmActivityStage1();
_L4:
        return false;
_L2:
        if (Util.IsTabOrReturnOrKnob(i, keyevent) && view.getId() == 0x7f1004e2)
        {
            Util.hideSoftInput(this, bidEditView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    protected void onPause()
    {
        super.onPause();
        timer.stop();
        Util.hideSoftInput(this, bidEditView);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        if (Debug.logBidTracking.isLoggable)
        {
            FwLog.println(Debug.logBidTracking, (new StringBuilder()).append(com/ebay/mobile/viewitem/ItemViewPlaceOfferActivity.getSimpleName()).append(" referrer:").append(referrer).append(" bidSource:").append(bidSource).toString());
        }
        if (!timer.isTimerRunning())
        {
            timer.start();
        }
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void render()
    {
        com.ebay.mobile.Item.BidBounds bidbounds;
        TextView textview;
        int i;
        if (isPlaceInitialBid())
        {
            bidEntryLabelTextView.setText(getString(0x7f0703ce));
        } else
        {
            bidEntryLabelTextView.setText(getString(0x7f070651));
        }
        if (numBidsView != null)
        {
            numBidsView.setText(String.format(getResources().getQuantityString(0x7f08001b, item.bidCount), new Object[] {
                Integer.valueOf(item.bidCount)
            }));
        }
        bidbounds = item.minimumToBid;
        textview = bidAtLeast;
        if (bidbounds.allowLowerBound)
        {
            i = 0x7f070b9e;
        } else
        {
            i = 0x7f070640;
        }
        textview.setText(getString(i, new Object[] {
            EbayCurrencyUtil.formatDisplay(bidbounds.lowerBound, 0)
        }));
        enableButtons();
    }

}
