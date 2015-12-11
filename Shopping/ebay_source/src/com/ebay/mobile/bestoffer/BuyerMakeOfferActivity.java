// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.PlaceOfferResult;
import com.ebay.common.net.api.trading.PlaceOfferResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ItemViewBidTracking;
import com.ebay.mobile.viewitem.PpaUpgradeConfirmDialog;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            BestOfferInput, OfferFormValidation, BestOfferTracking, BestOfferViewHelper, 
//            BestOfferShipping

public class BuyerMakeOfferActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener
{
    public static final class BuyerOfferStage extends Enum
    {

        private static final BuyerOfferStage $VALUES[];
        public static final BuyerOfferStage COMPLETE_AUTO_ACCEPTED;
        public static final BuyerOfferStage COMPLETE_AUTO_DECLINED;
        public static final BuyerOfferStage COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE;
        public static final BuyerOfferStage COMPLETE_ERROR;
        public static final BuyerOfferStage COMPLETE_ERROR_RETRY_AVAILABLE;
        public static final BuyerOfferStage COMPLETE_SENT;
        public static final BuyerOfferStage INPUT;
        public static final BuyerOfferStage REVIEW;

        public static BuyerOfferStage valueOf(String s)
        {
            return (BuyerOfferStage)Enum.valueOf(com/ebay/mobile/bestoffer/BuyerMakeOfferActivity$BuyerOfferStage, s);
        }

        public static BuyerOfferStage[] values()
        {
            return (BuyerOfferStage[])$VALUES.clone();
        }

        static 
        {
            INPUT = new BuyerOfferStage("INPUT", 0);
            REVIEW = new BuyerOfferStage("REVIEW", 1);
            COMPLETE_SENT = new BuyerOfferStage("COMPLETE_SENT", 2);
            COMPLETE_AUTO_ACCEPTED = new BuyerOfferStage("COMPLETE_AUTO_ACCEPTED", 3);
            COMPLETE_AUTO_DECLINED = new BuyerOfferStage("COMPLETE_AUTO_DECLINED", 4);
            COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE = new BuyerOfferStage("COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE", 5);
            COMPLETE_ERROR = new BuyerOfferStage("COMPLETE_ERROR", 6);
            COMPLETE_ERROR_RETRY_AVAILABLE = new BuyerOfferStage("COMPLETE_ERROR_RETRY_AVAILABLE", 7);
            $VALUES = (new BuyerOfferStage[] {
                INPUT, REVIEW, COMPLETE_SENT, COMPLETE_AUTO_ACCEPTED, COMPLETE_AUTO_DECLINED, COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE, COMPLETE_ERROR, COMPLETE_ERROR_RETRY_AVAILABLE
            });
        }

        private BuyerOfferStage(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String EXTRA_INPUT = "input";
    public static final String EXTRA_IS_BUYER = "is_buyer";
    public static final String EXTRA_ITEM_VIEW_INFO = "info";
    private static final String EXTRA_OFFERS_REMAINING = "offers_remaining";
    public static final String EXTRA_OFFER_ID = "offer_id";
    public static final String EXTRA_OFFER_STATUS = "status";
    private static final String EXTRA_STAGE = "stage";
    public static final String EXTRA_TRANSACTION_ID = "transaction_id";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("bestOffer", 3, "Log best offer");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo testActions = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("bestOfferTest", 3, "Show test actions in best offer");
    private PriceView bid;
    private String bidSource;
    private TextView bidValue;
    private BuyerOfferStage currentStage;
    private TextView error;
    private ViewGroup importChargesRow;
    private TextView importChargesValue;
    private BestOfferInput input;
    private LinearLayout inputParent;
    private long itemId;
    private Button makeAnotherOfferButton;
    private int offersRemaining;
    private LinearLayout offersRemainingRow;
    private TextView offersRemainingView;
    private ProgressBar progressBar;
    private EditText quantity;
    private int quantityAvailable;
    private TextView quantityValue;
    private String referrer;
    private BuyerOfferStage restoredStage;
    private Button reviewButton;
    private LinearLayout reviewParent;
    private Bundle savedInstanceState;
    private ViewGroup shippingRow;
    private TextView shippingValue;
    private Button submitButton;
    private LinearLayout submitParent;
    private TextView success;
    private EditText terms;
    private TextView termsValue;
    private Long transactionId;
    private Button viewItemButton;
    private ViewItemDataManager viewItemDataManager;

    public BuyerMakeOfferActivity()
    {
        currentStage = BuyerOfferStage.INPUT;
    }

    private void createUI(int i)
    {
        ((TextView)findViewById(0x7f10041a)).setText(getResources().getQuantityString(0x7f08003e, i, new Object[] {
            Integer.valueOf(i)
        }));
        headerStart(0x7f03012c);
        inputParent = (LinearLayout)findViewById(0x7f100419);
        reviewParent = (LinearLayout)findViewById(0x7f100426);
        bid = (PriceView)findViewById(0x7f100418);
        bid.setCurrency(item.currentPrice.code);
        if (input.bidAmount != null)
        {
            bid.setPrice(input.bidAmount);
        }
        quantity = (EditText)findViewById(0x7f10041d);
        ((TextView)findViewById(0x7f10041b)).setText(0x7f07071c);
        quantityAvailable = item.quantity - item.quantitySold;
        Object obj = (TextView)findViewById(0x7f10041f);
        ViewGroup viewgroup;
        int j;
        boolean flag;
        if (quantityAvailable > 10)
        {
            ((TextView) (obj)).setText(getString(0x7f07071f, new Object[] {
                getObfuscatedQuantityAvailable(quantityAvailable)
            }));
        } else
        {
            ((TextView) (obj)).setText(getString(0x7f07071e, new Object[] {
                Integer.valueOf(quantityAvailable)
            }));
        }
        if (quantityAvailable < 2)
        {
            findViewById(0x7f10041c).setVisibility(8);
            findViewById(0x7f10041e).setVisibility(8);
            findViewById(0x7f100428).setVisibility(8);
        }
        obj = item.salesTaxPercent;
        viewgroup = (ViewGroup)findViewById(0x7f100312);
        if (obj != null)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        viewgroup.setVisibility(j);
        if (obj != null)
        {
            ((TextView)viewgroup.findViewById(0x7f100313)).setText(getString(0x7f07093d, new Object[] {
                obj
            }));
        }
        shippingRow = (ViewGroup)findViewById(0x7f10042a);
        shippingValue = (TextView)findViewById(0x7f10042b);
        shippingRow.setVisibility(8);
        importChargesRow = (ViewGroup)findViewById(0x7f10042c);
        importChargesValue = (TextView)findViewById(0x7f10042d);
        importChargesRow.setVisibility(8);
        flag = com.ebay.common.view.util.EbayCountryManager.Default.supportsBestOfferTerms(MyApp.getPrefs().getCurrentCountry());
        if (!flag)
        {
            findViewById(0x7f100420).setVisibility(8);
            findViewById(0x7f100422).setVisibility(8);
            findViewById(0x7f10042e).setVisibility(8);
            quantity.setImeOptions(6);
        }
        if (quantityAvailable < 2 && !flag)
        {
            bid.setImeOptions(6);
        }
        terms = (EditText)findViewById(0x7f100421);
        submitParent = (LinearLayout)findViewById(0x7f100433);
        obj = (TextView)submitParent.findViewById(0x7f100434);
        if (item.isGspItem)
        {
            Util.buildTextViewWithHyperLink(((TextView) (obj)), getString(0x7f070091), ItemViewBaseActivity.getGspTermsAndConditionsUrl(item), getString(0x7f070092));
        } else
        {
            ((TextView) (obj)).setText(getText(0x7f0700a9));
        }
        reviewButton = (Button)findViewById(0x7f100423);
        reviewButton.setOnClickListener(this);
        new OfferFormValidation(reviewButton, bid, quantity, quantityAvailable);
        makeAnotherOfferButton = (Button)findViewById(0x7f100436);
        makeAnotherOfferButton.setOnClickListener(this);
        submitButton = (Button)findViewById(0x7f100435);
        submitButton.setOnClickListener(this);
        viewItemButton = (Button)findViewById(0x7f100437);
        viewItemButton.setOnClickListener(this);
        bidValue = (TextView)findViewById(0x7f100427);
        quantityValue = (TextView)findViewById(0x7f100429);
        termsValue = (TextView)findViewById(0x7f10042f);
        offersRemainingRow = (LinearLayout)findViewById(0x7f100430);
        offersRemainingView = (TextView)findViewById(0x7f100431);
        offersRemainingView.setText((new StringBuilder()).append("").append(i).toString());
        ((TextView)findViewById(0x7f100432)).setText(getResources().getQuantityString(0x7f080025, 3, new Object[] {
            Integer.valueOf(3)
        }));
        progressBar = (ProgressBar)findViewById(0x7f100438);
        error = (TextView)findViewById(0x7f100425);
        success = (TextView)findViewById(0x7f100424);
        if (MyApp.getPrefs().getCurrentSite().isEuSite())
        {
            setEuConsumerRightsText();
        }
    }

    private String getObfuscatedQuantityAvailable(int i)
    {
        if (i > 10)
        {
            return getResources().getQuantityString(0x7f08001a, 10, new Object[] {
                Integer.valueOf(10)
            });
        } else
        {
            return (new StringBuilder()).append("").append(i).toString();
        }
    }

    private void handleBackOrTop()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[];
            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.SHIPPING_COSTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage = new int[BuyerOfferStage.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.REVIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.COMPLETE_ERROR_RETRY_AVAILABLE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.INPUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.COMPLETE_SENT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.COMPLETE_AUTO_ACCEPTED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.COMPLETE_AUTO_DECLINED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerMakeOfferActivity$BuyerOfferStage[BuyerOfferStage.COMPLETE_ERROR.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.bestoffer.BuyerMakeOfferActivity.BuyerOfferStage[currentStage.ordinal()])
        {
        default:
            super.onBackPressed();
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            setStage(BuyerOfferStage.INPUT);
            break;
        }
    }

    private void handleBidTracking(PlaceOfferResponse placeofferresponse)
    {
        Object obj;
        Authentication authentication;
        authentication = null;
        obj = authentication;
        if (placeofferresponse.result == null) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(placeofferresponse.result.bidTransactionId)) goto _L4; else goto _L3
_L3:
        obj = placeofferresponse.result.bidTransactionId;
_L2:
        placeofferresponse = null;
        authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            placeofferresponse = new com.ebay.mobile.viewitem.ItemViewBidTracking.Roi(authentication.iafToken, null);
        }
        ItemViewBidTracking.sendBidState(this, item, referrer, bidSource, com.ebay.mobile.viewitem.ItemViewBidTracking.BidStateType.BO, placeofferresponse, ((String) (obj)));
        return;
_L4:
        obj = authentication;
        if (!TextUtils.isEmpty(placeofferresponse.result.transactionId))
        {
            obj = placeofferresponse.result.transactionId;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void handleMakeOffer(com.ebay.mobile.viewitem.ViewItemDataManager.PlaceOfferInfo placeofferinfo)
    {
        PlaceOfferResponse placeofferresponse = placeofferinfo.response;
        offersRemaining = offersRemaining - 1;
        if (offersRemaining < 0)
        {
            offersRemaining = 0;
        }
        updateOffersRemaining(offersRemaining);
        String s = placeofferresponse.result.bestOfferStatus;
        if (s == null)
        {
            if (log.isLoggable)
            {
                FwLog.println(log, "Load success, but no best offer status in response");
            }
            return;
        }
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Best offer status in response: ").append(s).toString());
        }
        Intent intent = new Intent();
        intent.putExtra("status", s);
        placeofferinfo = viewData.kind;
        if (s.equals("Declined"))
        {
            if (offersRemaining > 0)
            {
                setStage(BuyerOfferStage.COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE);
            } else
            {
                setStage(BuyerOfferStage.COMPLETE_AUTO_DECLINED);
            }
            BestOfferTracking.trackState(this, "OBMD", Long.valueOf(item.id), null, placeofferresponse.getBestOfferId());
            placeofferinfo = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
        } else
        if (s.equals("Accepted"))
        {
            placeofferinfo = (MyEbayBuyingDataManager)MyEbayBuyingDataManager.get(getEbayContext(), new com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.KeyParams(MyApp.getPrefs().getCurrentUser()));
            if (placeofferinfo != null)
            {
                placeofferinfo.forceReloadWonList();
            }
            viewItemDataManager.markDirty();
            intent.putExtra("transaction_id", placeofferresponse.result.transactionId);
            setStage(BuyerOfferStage.COMPLETE_AUTO_ACCEPTED);
            placeofferinfo = placeofferresponse.getTransactionIdAsLong();
            BestOfferTracking.trackState(this, "OBMA", Long.valueOf(item.id), placeofferinfo, placeofferresponse.getBestOfferId());
            placeofferinfo = com.ebay.common.ConstantsCommon.ItemKind.Won;
        } else
        if (s.equals("Pending"))
        {
            setStage(BuyerOfferStage.COMPLETE_SENT);
            BestOfferTracking.trackState(this, "OBMS", Long.valueOf(item.id), null, placeofferresponse.getBestOfferId());
            placeofferinfo = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
        } else
        {
            com.ebay.nautilus.kernel.content.ResultStatus.Message message = placeofferresponse.getResultStatus().getFirstMessage();
            if (message != null)
            {
                setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), message));
            } else
            {
                setErrorMessage(getString(0x7f07071d));
            }
            setStage(BuyerOfferStage.COMPLETE_ERROR);
            BestOfferTracking.trackState(this, "OBME", Long.valueOf(item.id), null, placeofferresponse.getBestOfferId());
        }
        handleBidTracking(placeofferresponse);
        if (viewData.kind != placeofferinfo)
        {
            viewData.kind = placeofferinfo;
            intent.putExtra("view_item_view_data", viewData);
        }
        setResult(-1, intent);
    }

    private void initInput(BestOfferInput bestofferinput)
    {
        if (bestofferinput != null)
        {
            if (bestofferinput.bidAmount != null)
            {
                bid.setText(String.format("%1.2f", new Object[] {
                    bestofferinput.bidAmount
                }));
            }
            if (bestofferinput.quantity > 0)
            {
                quantity.setText(Integer.toString(bestofferinput.quantity));
            }
            if (!TextUtils.isEmpty(bestofferinput.terms))
            {
                terms.setText(bestofferinput.terms);
            }
        }
    }

    private void setEuConsumerRightsText()
    {
        TextView textview = (TextView)submitParent.findViewById(0x7f100434);
        if (textview == null)
        {
            return;
        }
        if (item.isGspItem)
        {
            Util.buildTextViewWithHyperLink(textview, getString(0x7f07005c), ItemViewBaseActivity.getGspTermsAndConditionsUrl(item), getString(0x7f070073));
        } else
        {
            textview.setText(0x7f070068);
        }
        submitButton.setText(0x7f070072);
    }

    private void setStage(BuyerOfferStage buyerofferstage)
    {
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("stage transition from:").append(currentStage).append(" to:").append(buyerofferstage).toString());
        }
        showStage(buyerofferstage, input, offersRemaining);
        currentStage = buyerofferstage;
    }

    private void submitGetShippingCosts(int i, Double double1)
    {
        com.ebay.nautilus.domain.data.PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        if (postalcodespecification != null && viewItemDataManager != null)
        {
            double1 = new ItemCurrency(EbaySite.getInstanceFromId(item.site).getCurrency().getCurrencyCode(), String.valueOf(double1));
            viewItemDataManager.getShippingCosts(postalcodespecification, i, double1);
            showProgress(true);
            return;
        } else
        {
            setStage(BuyerOfferStage.REVIEW);
            return;
        }
    }

    private void submitOffer()
    {
        if (networkAvailable())
        {
            Authentication authentication = MyApp.getPrefs().getAuthentication();
            if (authentication == null)
            {
                startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            } else
            if (item != null)
            {
                long l = EbayResponse.currentHostTime();
                if (item.endDate != null)
                {
                    l = item.endDate.getTime() - l;
                } else
                {
                    l = 0L;
                }
                if (l <= 0L)
                {
                    setErrorMessage(getString(0x7f070706));
                    setStage(BuyerOfferStage.COMPLETE_ERROR);
                    BestOfferTracking.trackState(this, "OBME", Long.valueOf(item.id), null, null);
                    return;
                } else
                {
                    showProgress(true);
                    ItemCurrency itemcurrency = (new CurrencyAmount((new StringBuilder()).append("").append(input.bidAmount).toString(), item.currentPrice.code)).toItemCurrency();
                    viewItemDataManager.makeOffer(EbayApiUtil.getTradingApi(this, authentication), itemId, "Offer", itemcurrency, input.quantity, null, null, input.terms, false);
                    return;
                }
            }
        }
    }

    public void copyInputForReview(BestOfferInput bestofferinput)
    {
        CurrencyAmount currencyamount = new CurrencyAmount((new StringBuilder()).append("").append(bestofferinput.bidAmount).toString(), item.currentPrice.code);
        bidValue.setText(BestOfferViewHelper.getBidValueStr(getResources(), currencyamount, bestofferinput.quantity));
        quantityValue.setText((new StringBuilder()).append("").append(bestofferinput.quantity).toString());
        int i;
        boolean flag;
        if (TextUtils.isEmpty(bestofferinput.terms))
        {
            termsValue.setText("--");
        } else
        {
            termsValue.setText(bestofferinput.terms);
        }
        shippingValue.setText(BestOfferShipping.getShippingString(this, item, bestofferinput.quantity));
        flag = item.isGspItem;
        bestofferinput = importChargesRow;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        bestofferinput.setVisibility(i);
        if (flag)
        {
            bestofferinput = BestOfferShipping.getImportChargeText(this, item);
            importChargesValue.setText(bestofferinput);
        }
    }

    public Double getBid()
    {
        return Double.valueOf(bid.getPrice());
    }

    public int getQuantity()
    {
        String s = quantity.getText().toString();
        if (TextUtils.isEmpty(s))
        {
            return 1;
        } else
        {
            return Integer.parseInt(s);
        }
    }

    public String getTerms()
    {
        return terms.getText().toString();
    }

    public String getTrackingEventName()
    {
        return "BestOfferBuyerMake";
    }

    public void hideKeyboard()
    {
        Util.hideSoftInput(this, bid);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 65 65: default 20
    //                   65 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            submitOffer();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        handleBackOrTop();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756067: 
            input.bidAmount = getBid();
            input.quantity = getQuantity();
            input.terms = getTerms();
            hideKeyboard();
            submitGetShippingCosts(input.quantity, input.bidAmount);
            return;

        case 2131756085: 
            submitOffer();
            return;

        case 2131756087: 
            onBackPressed();
            return;

        case 2131756086: 
            onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030188);
        restoredStage = null;
        savedInstanceState = bundle;
        if (bundle == null)
        {
            bundle = getIntent();
            viewData = (ViewItemViewData)bundle.getParcelableExtra("view_item_view_data");
            referrer = bundle.getStringExtra("com.ebay.mobile.tracking.Referrer");
            bidSource = bundle.getStringExtra("com.ebay.mobile.tracking.BidSource");
            input = (BestOfferInput)bundle.getSerializableExtra("input");
            if (input == null)
            {
                input = new BestOfferInput();
            }
            BestOfferTracking.trackPage(this, getTrackingEventName());
        } else
        {
            viewData = (ViewItemViewData)bundle.getParcelable("view_item_view_data");
            restoredStage = BuyerOfferStage.valueOf(bundle.getString("stage"));
            input = (BestOfferInput)bundle.getSerializable("input");
            referrer = bundle.getString("com.ebay.mobile.tracking.Referrer");
            bidSource = bundle.getString("com.ebay.mobile.tracking.BidSource");
        }
        itemId = getIntent().getLongExtra("item_view_id", 0L);
        transactionId = Long.valueOf(getIntent().getLongExtra("item_view_tx_id", -1L));
        if (transactionId.longValue() == -1L)
        {
            transactionId = null;
        }
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

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (content.getStatus().hasError())
        {
            break; /* Loop/switch isn't completed */
        }
        switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (savedInstanceState == null)
            {
                offersRemaining = item.remainingBestOffersForBuyer(MyApp.getPrefs().getCurrentUser());
            } else
            {
                offersRemaining = savedInstanceState.getInt("offers_remaining");
            }
            createUI(offersRemaining);
            if (restoredStage != null)
            {
                setStage(restoredStage);
                return;
            }
            break;

        case 2: // '\002'
            showProgress(false);
            setStage(BuyerOfferStage.REVIEW);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
        return;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    public void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (isFinishing())
        {
            return;
        }
        showProgress(false);
        if (viewItemDataManager == null)
        {
            viewItemDataManager = viewitemdatamanager;
        }
        com.ebay.mobile.viewitem.ViewItemDataManager.PlaceOfferInfo placeofferinfo = (com.ebay.mobile.viewitem.ViewItemDataManager.PlaceOfferInfo)content.getData();
        if (!content.getStatus().hasError())
        {
            handleMakeOffer(placeofferinfo);
            return;
        }
        if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
        {
            EbayErrorHandler.handleResultStatus(this, 0, content.getStatus());
            return;
        }
        Object obj = null;
        viewitemdatamanager = obj;
        if (placeofferinfo.response != null)
        {
            viewitemdatamanager = obj;
            if (placeofferinfo.response.getResultStatus() != null)
            {
                viewitemdatamanager = placeofferinfo.response.getResultStatus().getMessages();
            }
        }
        if (viewitemdatamanager != null)
        {
            com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)viewitemdatamanager.get(0);
            if ((message instanceof EbayResponseError) && ((EbayResponseError)message).code.equals("21917143"))
            {
                setStage(BuyerOfferStage.COMPLETE_ERROR_RETRY_AVAILABLE);
            } else
            {
                setStage(BuyerOfferStage.COMPLETE_ERROR);
            }
        }
        if (viewitemdatamanager != null)
        {
            viewitemdatamanager = placeofferinfo.resultStatus.getMessage();
        } else
        {
            viewitemdatamanager = null;
        }
        if (!TextUtils.isEmpty(viewitemdatamanager))
        {
            setErrorMessage(viewitemdatamanager);
            return;
        } else
        {
            showMessage(0, content.getStatus());
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("stage", currentStage.name());
        bundle.putInt("offers_remaining", offersRemaining);
        bundle.putSerializable("input", input);
        bundle.putString("com.ebay.mobile.tracking.Referrer", referrer);
        bundle.putString("com.ebay.mobile.tracking.BidSource", bidSource);
        bundle.putParcelable("view_item_view_data", viewData);
    }

    public void setAutoDeclineMessage(int i, BestOfferInput bestofferinput)
    {
        error.setText(BestOfferViewHelper.getAutoDeclineMessage(getResources(), i, bestofferinput.bidAmount, item));
    }

    public void setErrorMessage(String s)
    {
        error.setText(s);
    }

    public void setOfferSentMessage()
    {
        String s = String.format(getResources().getString(0x7f070725), new Object[] {
            item.sellerUserId
        });
        success.setText(s);
        success.setTypeface(Typeface.DEFAULT);
    }

    public void showError()
    {
        error.setVisibility(0);
    }

    public void showProgress(boolean flag)
    {
        int i = 0;
        Object obj = submitButton;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((Button) (obj)).setEnabled(flag1);
        obj = progressBar;
        if (!flag)
        {
            i = 8;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        setProgressBarIndeterminateVisibility(flag);
    }

    public void showStage(BuyerOfferStage buyerofferstage, BestOfferInput bestofferinput, int i)
    {
        switch (_cls1..SwitchMap.com.ebay.mobile.bestoffer.BuyerMakeOfferActivity.BuyerOfferStage[buyerofferstage.ordinal()])
        {
        default:
            return;

        case 4: // '\004'
            initInput(bestofferinput);
            setTitle(getString(0x7f0705ff));
            inputParent.setVisibility(0);
            reviewParent.setVisibility(8);
            error.setVisibility(8);
            makeAnotherOfferButton.setVisibility(8);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;

        case 1: // '\001'
            copyInputForReview(bestofferinput);
            setTitle(getString(0x7f070b69));
            inputParent.setVisibility(8);
            reviewParent.setVisibility(0);
            submitParent.setVisibility(0);
            error.setVisibility(8);
            shippingRow.setVisibility(0);
            return;

        case 5: // '\005'
            setOfferSentMessage();
            setTitle(getString(0x7f070b64));
            inputParent.setVisibility(8);
            submitParent.setVisibility(8);
            error.setVisibility(8);
            reviewParent.setVisibility(0);
            success.setVisibility(0);
            viewItemButton.setVisibility(0);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;

        case 6: // '\006'
            MyEbayLandingActivity.setBuyingInvalid(getEbayContext());
            success.setText(BestOfferViewHelper.getAutoAcceptMessage(getResources(), item.currentPrice, bestofferinput.bidAmount));
            setTitle(getString(0x7f070b63));
            inputParent.setVisibility(8);
            submitParent.setVisibility(8);
            error.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            reviewParent.setVisibility(0);
            success.setVisibility(0);
            viewItemButton.setVisibility(0);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;

        case 7: // '\007'
            setAutoDeclineMessage(i, bestofferinput);
            setTitle(getString(0x7f070b5d));
            inputParent.setVisibility(8);
            submitParent.setVisibility(8);
            reviewParent.setVisibility(0);
            error.setVisibility(0);
            viewItemButton.setVisibility(0);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;

        case 2: // '\002'
            setAutoDeclineMessage(i, bestofferinput);
            setTitle(getString(0x7f070b69));
            inputParent.setVisibility(8);
            reviewParent.setVisibility(0);
            submitParent.setVisibility(8);
            makeAnotherOfferButton.setVisibility(0);
            error.setVisibility(0);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;

        case 8: // '\b'
            inputParent.setVisibility(8);
            reviewParent.setVisibility(8);
            error.setVisibility(0);
            viewItemButton.setVisibility(0);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;

        case 3: // '\003'
            inputParent.setVisibility(8);
            reviewParent.setVisibility(0);
            submitParent.setVisibility(0);
            error.setVisibility(0);
            shippingRow.setVisibility(8);
            importChargesRow.setVisibility(8);
            return;
        }
    }

    public void updateOffersRemaining(int i)
    {
        offersRemainingView.setText((new StringBuilder()).append("").append(i).toString());
    }

}
