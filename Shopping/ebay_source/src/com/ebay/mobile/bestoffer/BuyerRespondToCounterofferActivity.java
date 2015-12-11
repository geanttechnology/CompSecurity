// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
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
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ItemViewBidTracking;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.mobile.viewitem.ViewItemShippingPaymentsReturnsActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.List;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            BestOfferViewHelper, BestOfferShipping, OfferFormValidation, BuyerMakeOfferActivity, 
//            BestOfferInput, BestOfferTracking

public class BuyerRespondToCounterofferActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener
{
    public static final class BuyerRespondStage extends Enum
    {

        private static final BuyerRespondStage $VALUES[];
        public static final BuyerRespondStage COMPLETE_ACCEPT;
        public static final BuyerRespondStage COMPLETE_COUNTER_AUTO_ACCEPTED;
        public static final BuyerRespondStage COMPLETE_COUNTER_AUTO_DECLINED;
        public static final BuyerRespondStage COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE;
        public static final BuyerRespondStage COMPLETE_COUNTER_ERROR;
        public static final BuyerRespondStage COMPLETE_COUNTER_SENT;
        public static final BuyerRespondStage COMPLETE_DECLINE;
        public static final BuyerRespondStage COMPLETE_RESPOND_ERROR;
        public static final BuyerRespondStage INPUT_COUNTER;
        public static final BuyerRespondStage INPUT_DECLINE;
        public static final BuyerRespondStage INPUT_DECLINE_NETWORK_ERROR;
        public static final BuyerRespondStage REVIEW_COUNTER;
        public static final BuyerRespondStage REVIEW_COUNTER_RETRYABLE_ERROR;
        public static final BuyerRespondStage REVIEW_FOR_ACCEPT;
        public static final BuyerRespondStage REVIEW_FOR_ACCEPT_NETWORK_ERROR;
        public static final BuyerRespondStage VIEW_OFFER;

        public static BuyerRespondStage valueOf(String s)
        {
            return (BuyerRespondStage)Enum.valueOf(com/ebay/mobile/bestoffer/BuyerRespondToCounterofferActivity$BuyerRespondStage, s);
        }

        public static BuyerRespondStage[] values()
        {
            return (BuyerRespondStage[])$VALUES.clone();
        }

        static 
        {
            VIEW_OFFER = new BuyerRespondStage("VIEW_OFFER", 0);
            REVIEW_FOR_ACCEPT = new BuyerRespondStage("REVIEW_FOR_ACCEPT", 1);
            REVIEW_FOR_ACCEPT_NETWORK_ERROR = new BuyerRespondStage("REVIEW_FOR_ACCEPT_NETWORK_ERROR", 2);
            COMPLETE_ACCEPT = new BuyerRespondStage("COMPLETE_ACCEPT", 3);
            INPUT_DECLINE = new BuyerRespondStage("INPUT_DECLINE", 4);
            INPUT_DECLINE_NETWORK_ERROR = new BuyerRespondStage("INPUT_DECLINE_NETWORK_ERROR", 5);
            COMPLETE_DECLINE = new BuyerRespondStage("COMPLETE_DECLINE", 6);
            COMPLETE_RESPOND_ERROR = new BuyerRespondStage("COMPLETE_RESPOND_ERROR", 7);
            INPUT_COUNTER = new BuyerRespondStage("INPUT_COUNTER", 8);
            REVIEW_COUNTER = new BuyerRespondStage("REVIEW_COUNTER", 9);
            REVIEW_COUNTER_RETRYABLE_ERROR = new BuyerRespondStage("REVIEW_COUNTER_RETRYABLE_ERROR", 10);
            COMPLETE_COUNTER_SENT = new BuyerRespondStage("COMPLETE_COUNTER_SENT", 11);
            COMPLETE_COUNTER_AUTO_ACCEPTED = new BuyerRespondStage("COMPLETE_COUNTER_AUTO_ACCEPTED", 12);
            COMPLETE_COUNTER_AUTO_DECLINED = new BuyerRespondStage("COMPLETE_COUNTER_AUTO_DECLINED", 13);
            COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE = new BuyerRespondStage("COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE", 14);
            COMPLETE_COUNTER_ERROR = new BuyerRespondStage("COMPLETE_COUNTER_ERROR", 15);
            $VALUES = (new BuyerRespondStage[] {
                VIEW_OFFER, REVIEW_FOR_ACCEPT, REVIEW_FOR_ACCEPT_NETWORK_ERROR, COMPLETE_ACCEPT, INPUT_DECLINE, INPUT_DECLINE_NETWORK_ERROR, COMPLETE_DECLINE, COMPLETE_RESPOND_ERROR, INPUT_COUNTER, REVIEW_COUNTER, 
                REVIEW_COUNTER_RETRYABLE_ERROR, COMPLETE_COUNTER_SENT, COMPLETE_COUNTER_AUTO_ACCEPTED, COMPLETE_COUNTER_AUTO_DECLINED, COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE, COMPLETE_COUNTER_ERROR
            });
        }

        private BuyerRespondStage(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String EXTRA_INPUT = "input";
    public static final String EXTRA_ITEM_VIEW_INFO = "info";
    public static final String EXTRA_OFFER = "offer";
    private static final String EXTRA_OFFERS_REMAINING = "offers_remaining";
    public static final String EXTRA_STAGE = "stage";
    private static final int SIGN_IN_RESULT_ACCEPT = 2;
    private static final int SIGN_IN_RESULT_COUNTER = 3;
    private static final int SIGN_IN_RESULT_DECLINE = 1;
    private Button acceptConfirmButton;
    private TextView acceptLegal;
    private TextView acceptSuccess;
    private String bidSource;
    private PriceView counterBid;
    private TextView counterBidValue;
    private Button counterEditButton;
    private LinearLayout counterImportChargeRow;
    private TextView counterImportChargeValue;
    private LinearLayout counterInputParent;
    private TextView counterLegal;
    private Button counterMakeAnotherButton;
    private EditText counterQuantity;
    private TextView counterQuantityValue;
    private Button counterReviewButton;
    private TextView counterShippingValue;
    private Button counterSubmitButton;
    private LinearLayout counterSubmitButtonsRow;
    private TextView counterSuccess;
    private EditText counterTerms;
    private TextView counterTermsValue;
    private LinearLayout counterTermsValueRow;
    private BuyerRespondStage currentStage;
    private Button declineConfirmButton;
    private LinearLayout declineMessageRow;
    private TextView declineSuccess;
    private TextView error;
    private BestOfferInput input;
    private BestOffer offer;
    private int offersRemaining;
    private LinearLayout offersRemainingRow;
    private TextView offersRemainingView;
    private ProgressBar progressBar;
    private int quantityAvailable;
    private String referrer;
    private LinearLayout respondButtons;
    private Bundle savedInstanceState;
    private EditText sellerMessage;
    private TextView sellerMessageValue;
    private LinearLayout sellerMessageValueRow;
    private View shippingDetails;
    private TextView shippingDetailsSubtext;
    private Long transactionId;
    private LinearLayout viewCounterParent;
    private Button viewItemButton;
    private ViewItemDataManager viewItemDataManager;
    private LinearLayout viewOfferParent;

    public BuyerRespondToCounterofferActivity()
    {
        currentStage = BuyerRespondStage.VIEW_OFFER;
    }

    private void createUi(int i)
    {
        viewOfferParent = (LinearLayout)findViewById(0x7f100445);
        shippingDetails = findViewById(0x7f10049c);
        shippingDetails.setOnClickListener(this);
        shippingDetailsSubtext = (TextView)findViewById(0x7f10049f);
        ((TextView)findViewById(0x7f100449)).setText(getString(0x7f07050c, new Object[] {
            item.sellerUserId, Integer.valueOf(item.sellerFeedbackScore)
        }));
        offersRemainingRow = (LinearLayout)findViewById(0x7f10044f);
        offersRemainingView = (TextView)findViewById(0x7f100450);
        offersRemainingView.setText((new StringBuilder()).append("").append(i).toString());
        ((TextView)findViewById(0x7f10044a)).setText(BestOfferViewHelper.getBidValueStr(getResources(), offer.currentOffer, offer.quantity));
        ((TextView)findViewById(0x7f100446)).setText(BestOfferShipping.getShippingString(this, item, offer.quantity));
        Object obj = findViewById(0x7f100447);
        boolean flag = item.isGspItem;
        String s;
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((View) (obj)).setVisibility(j);
        if (flag)
        {
            obj = BestOfferShipping.getImportChargeText(this, item);
            ((TextView)findViewById(0x7f100448)).setText(((CharSequence) (obj)));
        }
        ((TextView)findViewById(0x7f10044b)).setText((new StringBuilder()).append("").append(offer.quantity).toString());
        obj = (ViewGroup)findViewById(0x7f100312);
        s = item.salesTaxPercent;
        if (s != null)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((ViewGroup) (obj)).setVisibility(j);
        if (s != null)
        {
            ((TextView)((ViewGroup) (obj)).findViewById(0x7f100313)).setText(getString(0x7f07093d, new Object[] {
                s
            }));
        }
        ((TextView)findViewById(0x7f10044c)).setText(BestOfferViewHelper.getExpiresStr(getResources(), offer.timeLeft()));
        flag = com.ebay.common.view.util.EbayCountryManager.Default.supportsBestOfferTerms(MyApp.getPrefs().getCurrentCountry());
        if (flag)
        {
            Object obj1 = (TextView)findViewById(0x7f10044e);
            if (TextUtils.isEmpty(offer.sellerMessage))
            {
                ((TextView) (obj1)).setText("--");
            } else
            {
                ((TextView) (obj1)).setText(offer.sellerMessage);
            }
        } else
        {
            findViewById(0x7f10044d).setVisibility(8);
        }
        findViewById(0x7f100459).setOnClickListener(this);
        findViewById(0x7f10045b).setOnClickListener(this);
        obj1 = findViewById(0x7f10045a);
        if (i > 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((View) (obj1)).setVisibility(j);
        if (i > 0)
        {
            findViewById(0x7f10045a).setOnClickListener(this);
        }
        respondButtons = (LinearLayout)findViewById(0x7f100458);
        declineMessageRow = (LinearLayout)findViewById(0x7f100454);
        declineConfirmButton = (Button)findViewById(0x7f100456);
        declineConfirmButton.setOnClickListener(this);
        progressBar = (ProgressBar)findViewById(0x7f100438);
        error = (TextView)findViewById(0x7f100425);
        declineSuccess = (TextView)findViewById(0x7f100442);
        sellerMessage = (EditText)findViewById(0x7f100455);
        sellerMessageValue = (TextView)findViewById(0x7f100453);
        sellerMessageValueRow = (LinearLayout)findViewById(0x7f100452);
        acceptLegal = (TextView)findViewById(0x7f100451);
        if (item.isGspItem)
        {
            Util.buildTextViewWithHyperLink(acceptLegal, getString(0x7f07008b), ItemViewBaseActivity.getGspTermsAndConditionsUrl(item), getString(0x7f070092));
        } else
        {
            acceptLegal.setText(0x7f070080);
        }
        acceptConfirmButton = (Button)findViewById(0x7f100457);
        acceptConfirmButton.setOnClickListener(this);
        acceptSuccess = (TextView)findViewById(0x7f100443);
        counterInputParent = (LinearLayout)findViewById(0x7f10045c);
        counterBid = (PriceView)findViewById(0x7f100418);
        counterBid.setCurrency(offer.currentOffer.getCurrencyCode());
        counterQuantity = (EditText)findViewById(0x7f10045f);
        quantityAvailable = item.quantity - item.quantitySold;
        counterReviewButton = (Button)findViewById(0x7f100465);
        counterReviewButton.setOnClickListener(this);
        new OfferFormValidation(counterReviewButton, counterBid, counterQuantity, quantityAvailable);
        ((TextView)findViewById(0x7f10045d)).setText(EbayCurrencyUtil.formatDisplay(offer.currentOffer, 0));
        ((TextView)findViewById(0x7f100461)).setText(String.format(getResources().getString(0x7f07071e), new Object[] {
            Integer.valueOf(quantityAvailable)
        }));
        if (quantityAvailable < 2)
        {
            findViewById(0x7f10045e).setVisibility(8);
            findViewById(0x7f100460).setVisibility(8);
        }
        if (!flag)
        {
            findViewById(0x7f100462).setVisibility(8);
            findViewById(0x7f100464).setVisibility(8);
            counterQuantity.setImeOptions(6);
        }
        if (quantityAvailable < 2 && !flag)
        {
            counterBid.setImeOptions(6);
        }
        counterShippingValue = (TextView)findViewById(0x7f10046b);
        counterImportChargeRow = (LinearLayout)findViewById(0x7f10046c);
        counterImportChargeValue = (TextView)findViewById(0x7f10046d);
        counterTerms = (EditText)findViewById(0x7f100463);
        counterSubmitButtonsRow = (LinearLayout)findViewById(0x7f100471);
        viewCounterParent = (LinearLayout)findViewById(0x7f100466);
        counterLegal = (TextView)findViewById(0x7f100470);
        counterLegal.setText(getText(0x7f070081));
        counterEditButton = (Button)findViewById(0x7f100473);
        counterEditButton.setOnClickListener(this);
        counterMakeAnotherButton = (Button)findViewById(0x7f100474);
        counterMakeAnotherButton.setOnClickListener(this);
        counterSubmitButton = (Button)findViewById(0x7f100472);
        counterSubmitButton.setOnClickListener(this);
        obj1 = String.format(getString(0x7f07045b), new Object[] {
            EbayCurrencyUtil.formatDisplay(offer.currentOffer, 0)
        });
        ((TextView)findViewById(0x7f10045d)).setText(((CharSequence) (obj1)));
        counterBidValue = (TextView)findViewById(0x7f100467);
        counterQuantityValue = (TextView)findViewById(0x7f100469);
        if (quantityAvailable < 2)
        {
            findViewById(0x7f100468).setVisibility(8);
        }
        counterTermsValueRow = (LinearLayout)findViewById(0x7f10046e);
        counterTermsValue = (TextView)findViewById(0x7f10046f);
        counterSuccess = (TextView)findViewById(0x7f100444);
        viewItemButton = (Button)findViewById(0x7f100437);
        viewItemButton.setOnClickListener(this);
        if (MyApp.getPrefs().getCurrentSite().isEuSite())
        {
            setEuConsumerRightsText();
        }
    }

    private void handleBackOrTop()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[];
            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.SHIPPING_COSTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage = new int[BuyerRespondStage.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.INPUT_DECLINE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.INPUT_DECLINE_NETWORK_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.REVIEW_FOR_ACCEPT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.REVIEW_FOR_ACCEPT_NETWORK_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.INPUT_COUNTER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.REVIEW_COUNTER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.REVIEW_COUNTER_RETRYABLE_ERROR.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.VIEW_OFFER.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_DECLINE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_ACCEPT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_COUNTER_SENT.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_RESPOND_ERROR.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_COUNTER_ERROR.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_COUNTER_AUTO_ACCEPTED.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$BuyerRespondToCounterofferActivity$BuyerRespondStage[BuyerRespondStage.COMPLETE_COUNTER_AUTO_DECLINED.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.bestoffer.BuyerRespondToCounterofferActivity.BuyerRespondStage[currentStage.ordinal()])
        {
        default:
            super.onBackPressed();
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            setStage(BuyerRespondStage.VIEW_OFFER);
            return;

        case 6: // '\006'
        case 7: // '\007'
            setStage(BuyerRespondStage.INPUT_COUNTER);
            return;

        case 8: // '\b'
            setStage(BuyerRespondStage.INPUT_COUNTER);
            break;
        }
    }

    private void handleBidTracking(PlaceOfferResponse placeofferresponse, int i)
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

    private void setEuConsumerRightsText()
    {
        if (item.isGspItem)
        {
            Util.buildTextViewWithHyperLink(acceptLegal, getString(0x7f07005a), ItemViewBaseActivity.getGspTermsAndConditionsUrl(item), getString(0x7f070073));
            Util.buildTextViewWithHyperLink(counterLegal, getString(0x7f07005b), ItemViewBaseActivity.getGspTermsAndConditionsUrl(item), getString(0x7f070073));
        } else
        {
            acceptLegal.setText(0x7f070066);
            counterLegal.setText(0x7f070067);
        }
        acceptConfirmButton.setText(0x7f070061);
        counterSubmitButton.setText(0x7f07006b);
    }

    private void setSellerMessageValue(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            sellerMessageValue.setText("--");
            return;
        } else
        {
            sellerMessageValue.setText(s);
            return;
        }
    }

    private void setStage(BuyerRespondStage buyerrespondstage)
    {
        if (BuyerMakeOfferActivity.log.isLoggable)
        {
            FwLog.println(BuyerMakeOfferActivity.log, (new StringBuilder()).append("stage transition from:").append(currentStage).append(" to:").append(buyerrespondstage).toString());
        }
        showStage(buyerrespondstage, input, offersRemaining);
        currentStage = buyerrespondstage;
    }

    private void submitAccept()
    {
        Object obj;
label0:
        {
            if (networkAvailable())
            {
                obj = MyApp.getPrefs().getAuthentication();
                if (obj != null)
                {
                    break label0;
                }
                obj = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
                ((Intent) (obj)).putExtra("client_int", 2);
                startActivityForResult(((Intent) (obj)), 65);
            }
            return;
        }
        showProgress(true);
        viewItemDataManager.placeOffer(EbayApiUtil.getTradingApi(this, ((Authentication) (obj))), item.id, "Accept", offer.currentOffer.toItemCurrency(), offer.quantity, null, offer.id, null, false, null);
    }

    private void submitCounter()
    {
        Object obj;
label0:
        {
            if (networkAvailable())
            {
                obj = MyApp.getPrefs().getAuthentication();
                if (obj != null)
                {
                    break label0;
                }
                obj = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
                ((Intent) (obj)).putExtra("client_int", 3);
                startActivityForResult(((Intent) (obj)), 65);
            }
            return;
        }
        showProgress(true);
        ItemCurrency itemcurrency = (new CurrencyAmount((new StringBuilder()).append("").append(input.bidAmount).toString(), item.currentPrice.code)).toItemCurrency();
        viewItemDataManager.placeOffer(EbayApiUtil.getTradingApi(this, ((Authentication) (obj))), item.id, "Counter", itemcurrency, input.quantity, null, offer.id, input.terms, false, null);
    }

    private void submitDecline()
    {
        Object obj;
label0:
        {
            if (networkAvailable())
            {
                obj = MyApp.getPrefs().getAuthentication();
                if (obj != null)
                {
                    break label0;
                }
                obj = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
                ((Intent) (obj)).putExtra("client_int", 1);
                startActivityForResult(((Intent) (obj)), 65);
            }
            return;
        }
        showProgress(true);
        viewItemDataManager.placeOffer(EbayApiUtil.getTradingApi(this, ((Authentication) (obj))), item.id, "Decline", offer.currentOffer.toItemCurrency(), offer.quantity, null, offer.id, input.declineMessage, false, null);
    }

    private void submitGetShippingCosts(int i, Double double1)
    {
        com.ebay.nautilus.domain.data.PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        if (postalcodespecification != null && viewItemDataManager != null)
        {
            double1 = new ItemCurrency(EbaySite.getInstanceFromId(item.site).getCurrency().getCurrencyCode(), String.valueOf(double1));
            viewItemDataManager.getShippingCosts(postalcodespecification, i, double1);
            showProgress(true);
        }
    }

    public void copyInputForReview(BestOfferInput bestofferinput)
    {
        CurrencyAmount currencyamount = new CurrencyAmount((new StringBuilder()).append("").append(bestofferinput.bidAmount).toString(), item.currentPrice.code);
        counterBidValue.setText(BestOfferViewHelper.getBidValueStr(getResources(), currencyamount, bestofferinput.quantity));
        counterQuantityValue.setText((new StringBuilder()).append("").append(bestofferinput.quantity).toString());
        int i;
        boolean flag;
        if (TextUtils.isEmpty(bestofferinput.terms))
        {
            counterTermsValue.setText("--");
        } else
        {
            counterTermsValue.setText(bestofferinput.terms);
        }
        counterShippingValue.setText(BestOfferShipping.getShippingString(this, item, bestofferinput.quantity));
        if (item.shippingInfo.orderedOptions != null && item.shippingInfo.orderedOptions.size() > 1)
        {
            shippingDetailsSubtext.setText(getString(0x7f070718));
        }
        flag = item.isGspItem;
        bestofferinput = counterImportChargeRow;
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
            counterImportChargeValue.setText(bestofferinput);
        }
    }

    public Double getCounterBid()
    {
        return Double.valueOf(counterBid.getPrice());
    }

    public int getCounterQuantity()
    {
        String s = counterQuantity.getText().toString();
        if (TextUtils.isEmpty(s))
        {
            return 1;
        } else
        {
            return Integer.parseInt(s);
        }
    }

    public String getCounterTerms()
    {
        return counterTerms.getText().toString();
    }

    public String getSellerDeclineMessage()
    {
        return sellerMessage.getText().toString();
    }

    public String getTrackingEventName()
    {
        return "BestOfferBuyerRespond";
    }

    public void hideKeyboard()
    {
        Util.hideSoftInput(this, counterBid);
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
        if (j == -1 && item != null)
        {
            switch (i)
            {
            default:
                return;

            case 1: // '\001'
                submitDecline();
                return;

            case 2: // '\002'
                submitAccept();
                return;

            case 3: // '\003'
                submitCounter();
                break;
            }
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
        if (0x7f10045b == view.getId())
        {
            setStage(BuyerRespondStage.INPUT_DECLINE);
        } else
        {
            if (0x7f100456 == view.getId())
            {
                hideKeyboard();
                submitDecline();
                return;
            }
            if (0x7f100459 == view.getId())
            {
                setStage(BuyerRespondStage.REVIEW_FOR_ACCEPT);
                return;
            }
            if (0x7f100457 == view.getId())
            {
                submitAccept();
                return;
            }
            if (0x7f10045a == view.getId())
            {
                setStage(BuyerRespondStage.INPUT_COUNTER);
                return;
            }
            if (0x7f100465 == view.getId())
            {
                input.bidAmount = getCounterBid();
                input.quantity = getCounterQuantity();
                input.terms = getCounterTerms();
                hideKeyboard();
                submitGetShippingCosts(input.quantity, input.bidAmount);
                setStage(BuyerRespondStage.REVIEW_COUNTER);
                return;
            }
            if (0x7f100473 == view.getId() || 0x7f100474 == view.getId())
            {
                setStage(BuyerRespondStage.INPUT_COUNTER);
                return;
            }
            if (0x7f100472 == view.getId())
            {
                submitCounter();
                return;
            }
            if (0x7f10049c == view.getId())
            {
                ViewItemShippingPaymentsReturnsActivity.StartActivity(this, viewData, 19);
                return;
            }
            if (0x7f100437 == view.getId())
            {
                onBackPressed();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03018a);
        savedInstanceState = bundle;
        Object obj = null;
        if (bundle == null)
        {
            Intent intent = getIntent();
            viewData = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
            String s = intent.getStringExtra("stage");
            bundle = obj;
            if (!TextUtils.isEmpty(s))
            {
                bundle = BuyerRespondStage.valueOf(s);
            }
            if (bundle != null)
            {
                currentStage = bundle;
            }
            offer = (BestOffer)intent.getParcelableExtra("offer");
            input = (BestOfferInput)intent.getSerializableExtra("input");
            if (input == null)
            {
                input = new BestOfferInput();
            }
            referrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
            bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
            BestOfferTracking.trackPage(this, getTrackingEventName());
        } else
        {
            viewData = (ViewItemViewData)bundle.getParcelable("view_item_view_data");
            BuyerRespondStage.valueOf(bundle.getString("stage"));
            offer = (BestOffer)bundle.getParcelable("offer");
            input = (BestOfferInput)bundle.getSerializable("input");
            referrer = bundle.getString("com.ebay.mobile.tracking.Referrer");
            bidSource = bundle.getString("com.ebay.mobile.tracking.BidSource");
        }
        transactionId = Long.valueOf(getIntent().getLongExtra("item_view_tx_id", -1L));
        if (transactionId.longValue() == -1L)
        {
            transactionId = null;
        }
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (!content.getStatus().hasError())
        {
            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                headerStart(0x7f03012c);
                if (savedInstanceState == null)
                {
                    offersRemaining = item.remainingBestOffersForBuyer(offer.buyerId);
                } else
                {
                    offersRemaining = savedInstanceState.getInt("offers_remaining");
                }
                createUi(offersRemaining);
                setStage(currentStage);
                return;

            case 2: // '\002'
                showProgress(false);
                setStage(BuyerRespondStage.REVIEW_COUNTER);
                return;
            }
        } else
        {
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null || content.getData() == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (false) goto _L2; else goto _L1
_L1:
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 28
    //                   16908332 30;
           goto _L2 _L3
_L2:
        return false;
_L3:
        handleBackOrTop();
        return true;
    }

    public void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Long long1;
        PlaceOfferResponse placeofferresponse;
        Object obj;
        String s;
        showProgress(false);
        if (content != null && content.getData() != null)
        {
            placeofferresponse = ((com.ebay.mobile.viewitem.ViewItemDataManager.PlaceOfferInfo)content.getData()).response;
        } else
        {
            placeofferresponse = null;
        }
        if (placeofferresponse != null && placeofferresponse.result != null)
        {
            viewitemdatamanager = placeofferresponse.result.bestOfferId;
        } else
        {
            viewitemdatamanager = null;
        }
        if (item != null)
        {
            long1 = Long.valueOf(item.id);
        } else
        {
            long1 = null;
        }
        if (placeofferresponse != null)
        {
            obj = placeofferresponse.getTransactionIdAsLong();
        } else
        {
            obj = null;
        }
        if (content.getData() != null)
        {
            s = ((com.ebay.mobile.viewitem.ViewItemDataManager.PlaceOfferInfo)content.getData()).action;
        } else
        {
            s = null;
        }
        if (content.getStatus().hasError())
        {
            break; /* Loop/switch isn't completed */
        }
        if ("Decline".equals(s))
        {
            content = new Intent();
            content.putExtra("status", "Declined");
            setResult(-1, content);
            input.declineMessage = getSellerDeclineMessage();
            setStage(BuyerRespondStage.COMPLETE_DECLINE);
            BestOfferTracking.trackState(this, "OBRD", long1, ((Long) (obj)), viewitemdatamanager);
            return;
        }
        if ("Accept".equals(s))
        {
            viewItemDataManager.forceReloadWonList();
            content = new Intent();
            content.putExtra("status", "Accepted");
            content.putExtra("transaction_id", placeofferresponse.result.transactionId);
            setResult(-1, content);
            setStage(BuyerRespondStage.COMPLETE_ACCEPT);
            BestOfferTracking.trackState(this, "OBRA", long1, ((Long) (obj)), viewitemdatamanager);
            handleBidTracking(placeofferresponse, offer.quantity);
            return;
        }
        if ("Counter".equals(s))
        {
label0:
            {
                offersRemaining = offersRemaining - 1;
                if (offersRemaining < 0)
                {
                    offersRemaining = 0;
                }
                updateOffersRemaining(offersRemaining);
                s = placeofferresponse.result.bestOfferStatus;
                if (s != null)
                {
                    break label0;
                }
                if (BuyerMakeOfferActivity.log.isLoggable)
                {
                    FwLog.println(BuyerMakeOfferActivity.log, "Load success, but no best offer status in response");
                    return;
                }
            }
        }
        if (true) goto _L1; else goto _L3
        if (BuyerMakeOfferActivity.log.isLoggable)
        {
            FwLog.println(BuyerMakeOfferActivity.log, (new StringBuilder()).append("Best offer status in response: ").append(s).toString());
        }
        content = new Intent();
        content.putExtra("status", s);
        if (s.equals("Declined"))
        {
            if (offersRemaining > 0)
            {
                setStage(BuyerRespondStage.COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE);
            } else
            {
                setStage(BuyerRespondStage.COMPLETE_COUNTER_AUTO_DECLINED);
            }
            BestOfferTracking.trackState(this, "OBCD", long1, null, viewitemdatamanager);
        } else
        if (s.equals("Accepted"))
        {
            content.putExtra("transaction_id", placeofferresponse.result.transactionId);
            setStage(BuyerRespondStage.COMPLETE_COUNTER_AUTO_ACCEPTED);
            BestOfferTracking.trackState(this, "OBCA", long1, ((Long) (obj)), viewitemdatamanager);
        } else
        if (s.equals("Pending"))
        {
            setStage(BuyerRespondStage.COMPLETE_COUNTER_SENT);
            BestOfferTracking.trackState(this, "OBRC", long1, null, viewitemdatamanager);
        } else
        {
            obj = placeofferresponse.getResultStatus().getFirstMessage();
            if (obj != null)
            {
                setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), ((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj))));
            } else
            {
                setErrorMessage(getString(0x7f07071d));
            }
            setStage(BuyerRespondStage.COMPLETE_COUNTER_ERROR);
            BestOfferTracking.trackState(this, "OBRE", long1, null, viewitemdatamanager);
        }
_L5:
        handleBidTracking(placeofferresponse, input.quantity);
        setResult(-1, content);
        return;
_L3:
        if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
        {
            EbayErrorHandler.handleResultStatus(this, 0, content.getStatus());
        }
        content = content.getStatus();
        if ("Decline".equals(s))
        {
            content = content.getFirstMessage();
            if (content != null)
            {
                setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), content));
                setStage(BuyerRespondStage.COMPLETE_RESPOND_ERROR);
                BestOfferTracking.trackState(this, "OBRE", long1, null, viewitemdatamanager);
                return;
            } else
            {
                setErrorMessage(getString(0x7f070150));
                setStage(BuyerRespondStage.INPUT_DECLINE_NETWORK_ERROR);
                return;
            }
        }
        if ("Accept".equals(s))
        {
            content = content.getFirstMessage();
            if (content != null)
            {
                setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), content));
                setStage(BuyerRespondStage.COMPLETE_RESPOND_ERROR);
                BestOfferTracking.trackState(this, "OBRE", long1, ((Long) (obj)), viewitemdatamanager);
                return;
            } else
            {
                setErrorMessage(getString(0x7f070150));
                setStage(BuyerRespondStage.REVIEW_FOR_ACCEPT_NETWORK_ERROR);
                return;
            }
        }
        if ("Counter".equals(s))
        {
            content = content.getFirstMessage();
            if (content != null)
            {
                setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), content));
                if ((content instanceof EbayResponseError) && ((EbayResponseError)content).code.equals("21917143"))
                {
                    setStage(BuyerRespondStage.REVIEW_COUNTER_RETRYABLE_ERROR);
                    return;
                } else
                {
                    setStage(BuyerRespondStage.COMPLETE_COUNTER_ERROR);
                    BestOfferTracking.trackState(this, "OBRE", long1, null, viewitemdatamanager);
                    return;
                }
            } else
            {
                setErrorMessage(getString(0x7f070150));
                setStage(BuyerRespondStage.REVIEW_COUNTER_RETRYABLE_ERROR);
                return;
            }
        }
        showMessage(0, content);
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("stage", currentStage.name());
        bundle.putParcelable("offer", offer);
        bundle.putSerializable("input", input);
        bundle.putInt("offers_remaining", offersRemaining);
        bundle.putString("com.ebay.mobile.tracking.Referrer", referrer);
        bundle.putString("com.ebay.mobile.tracking.BidSource", bidSource);
        bundle.putParcelable("view_item_view_data", viewData);
    }

    public void setErrorMessage(String s)
    {
        error.setText(s);
    }

    public void showProgress(boolean flag)
    {
        boolean flag2 = true;
        Object obj = progressBar;
        int i;
        boolean flag1;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        setProgressBarIndeterminateVisibility(flag);
        obj = declineConfirmButton;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((Button) (obj)).setEnabled(flag1);
        obj = acceptConfirmButton;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((Button) (obj)).setEnabled(flag1);
        obj = sellerMessage;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((EditText) (obj)).setEnabled(flag1);
        obj = counterSubmitButton;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((Button) (obj)).setEnabled(flag1);
        obj = counterEditButton;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((Button) (obj)).setEnabled(flag1);
        obj = shippingDetails;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        ((View) (obj)).setEnabled(flag);
    }

    public void showStage(BuyerRespondStage buyerrespondstage, BestOfferInput bestofferinput, int i)
    {
        switch (_cls1..SwitchMap.com.ebay.mobile.bestoffer.BuyerRespondToCounterofferActivity.BuyerRespondStage[buyerrespondstage.ordinal()])
        {
        default:
            return;

        case 9: // '\t'
            setTitle(getString(0x7f070b66));
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            error.setVisibility(8);
            acceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            counterInputParent.setVisibility(8);
            viewOfferParent.setVisibility(0);
            respondButtons.setVisibility(0);
            offersRemainingRow.setVisibility(0);
            return;

        case 1: // '\001'
            setTitle(getString(0x7f070b60));
            respondButtons.setVisibility(8);
            error.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            declineMessageRow.setVisibility(0);
            declineConfirmButton.setVisibility(0);
            return;

        case 2: // '\002'
            setTitle(getString(0x7f070b60));
            respondButtons.setVisibility(8);
            declineMessageRow.setVisibility(0);
            declineConfirmButton.setVisibility(0);
            error.setVisibility(0);
            return;

        case 10: // '\n'
            setSellerMessageValue(bestofferinput.declineMessage);
            setTitle(getString(0x7f070b5d));
            respondButtons.setVisibility(8);
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            error.setVisibility(8);
            declineSuccess.setVisibility(0);
            sellerMessageValueRow.setVisibility(0);
            viewItemButton.setVisibility(0);
            return;

        case 3: // '\003'
            setTitle(getString(0x7f070b5c));
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            respondButtons.setVisibility(8);
            error.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            acceptLegal.setVisibility(0);
            acceptConfirmButton.setVisibility(0);
            return;

        case 4: // '\004'
            setTitle(getString(0x7f070b5c));
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            respondButtons.setVisibility(8);
            acceptLegal.setVisibility(0);
            acceptConfirmButton.setVisibility(0);
            error.setVisibility(0);
            return;

        case 11: // '\013'
            setTitle(getString(0x7f070b5d));
            respondButtons.setVisibility(8);
            error.setVisibility(8);
            acceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            acceptSuccess.setVisibility(0);
            viewItemButton.setVisibility(0);
            return;

        case 5: // '\005'
            setTitle(getString(0x7f070b62));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            viewCounterParent.setVisibility(8);
            error.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            counterMakeAnotherButton.setVisibility(8);
            counterInputParent.setVisibility(0);
            return;

        case 6: // '\006'
            copyInputForReview(bestofferinput);
            setTitle(getString(0x7f070b68));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterInputParent.setVisibility(8);
            error.setVisibility(8);
            counterTermsValueRow.setVisibility(0);
            viewCounterParent.setVisibility(0);
            counterSubmitButtonsRow.setVisibility(0);
            return;

        case 8: // '\b'
            error.setText(BestOfferViewHelper.getAutoDeclineMessage(getResources(), i, bestofferinput.bidAmount, item));
            copyInputForReview(bestofferinput);
            setTitle(getString(0x7f070b68));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterInputParent.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            counterTermsValueRow.setVisibility(0);
            viewCounterParent.setVisibility(0);
            counterMakeAnotherButton.setVisibility(0);
            error.setVisibility(0);
            return;

        case 7: // '\007'
            copyInputForReview(bestofferinput);
            setTitle(getString(0x7f070b68));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterInputParent.setVisibility(8);
            counterTermsValueRow.setVisibility(0);
            viewCounterParent.setVisibility(0);
            counterSubmitButtonsRow.setVisibility(0);
            error.setVisibility(0);
            return;

        case 12: // '\f'
            setTitle(getString(0x7f070b5f));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            shippingDetails.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            error.setVisibility(8);
            counterLegal.setVisibility(8);
            counterSuccess.setVisibility(0);
            viewCounterParent.setVisibility(0);
            counterTermsValueRow.setVisibility(0);
            viewItemButton.setVisibility(0);
            return;

        case 13: // '\r'
            respondButtons.setVisibility(8);
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            acceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            error.setVisibility(0);
            viewCounterParent.setVisibility(8);
            viewOfferParent.setVisibility(0);
            viewItemButton.setVisibility(0);
            return;

        case 14: // '\016'
            respondButtons.setVisibility(8);
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            acceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            viewOfferParent.setVisibility(8);
            counterLegal.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            shippingDetails.setVisibility(8);
            counterTermsValueRow.setVisibility(0);
            error.setVisibility(0);
            viewCounterParent.setVisibility(0);
            viewItemButton.setVisibility(0);
            return;

        case 15: // '\017'
            counterSuccess.setText(BestOfferViewHelper.getAutoAcceptMessage(getResources(), item.currentPrice, bestofferinput.bidAmount));
            setTitle(getString(0x7f070b63));
            error.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterInputParent.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            shippingDetails.setVisibility(8);
            error.setVisibility(8);
            counterLegal.setVisibility(8);
            viewCounterParent.setVisibility(0);
            counterTermsValueRow.setVisibility(0);
            counterSuccess.setVisibility(0);
            viewItemButton.setVisibility(0);
            return;

        case 16: // '\020'
            error.setText(BestOfferViewHelper.getAutoDeclineMessage(getResources(), i, bestofferinput.bidAmount, item));
            break;
        }
        setTitle(getString(0x7f070b5d));
        offersRemainingRow.setVisibility(8);
        viewOfferParent.setVisibility(8);
        respondButtons.setVisibility(8);
        counterInputParent.setVisibility(8);
        counterSubmitButtonsRow.setVisibility(8);
        shippingDetails.setVisibility(8);
        counterSuccess.setVisibility(8);
        counterLegal.setVisibility(8);
        error.setVisibility(0);
        viewCounterParent.setVisibility(0);
        counterTermsValueRow.setVisibility(0);
        viewItemButton.setVisibility(0);
    }

    public void updateOffersRemaining(int i)
    {
        offersRemainingView.setText((new StringBuilder()).append("").append(i).toString());
    }
}
