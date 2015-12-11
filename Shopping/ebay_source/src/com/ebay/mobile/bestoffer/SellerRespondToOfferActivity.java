// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Activity;
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
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.bestoffer:
//            BestOfferViewHelper, OfferFormValidation, BuyerMakeOfferActivity, BestOfferInput, 
//            BestOfferTracking

public class SellerRespondToOfferActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener
{
    public static final class SellerRespondStage extends Enum
    {

        private static final SellerRespondStage $VALUES[];
        public static final SellerRespondStage COMPLETE_ACCEPT;
        public static final SellerRespondStage COMPLETE_COUNTER;
        public static final SellerRespondStage COMPLETE_COUNTER_ERROR;
        public static final SellerRespondStage COMPLETE_DECLINE;
        public static final SellerRespondStage COMPLETE_RESPOND_ERROR;
        public static final SellerRespondStage INPUT_COUNTER;
        public static final SellerRespondStage INPUT_DECLINE;
        public static final SellerRespondStage INPUT_DECLINE_NETWORK_ERROR;
        public static final SellerRespondStage REVIEW_COUNTER;
        public static final SellerRespondStage REVIEW_COUNTER_RETRYABLE_ERROR;
        public static final SellerRespondStage REVIEW_FOR_ACCEPT;
        public static final SellerRespondStage REVIEW_FOR_ACCEPT_NETWORK_ERROR;
        public static final SellerRespondStage VIEW_OFFER;

        public static SellerRespondStage valueOf(String s)
        {
            return (SellerRespondStage)Enum.valueOf(com/ebay/mobile/bestoffer/SellerRespondToOfferActivity$SellerRespondStage, s);
        }

        public static SellerRespondStage[] values()
        {
            return (SellerRespondStage[])$VALUES.clone();
        }

        static 
        {
            VIEW_OFFER = new SellerRespondStage("VIEW_OFFER", 0);
            REVIEW_FOR_ACCEPT = new SellerRespondStage("REVIEW_FOR_ACCEPT", 1);
            REVIEW_FOR_ACCEPT_NETWORK_ERROR = new SellerRespondStage("REVIEW_FOR_ACCEPT_NETWORK_ERROR", 2);
            COMPLETE_ACCEPT = new SellerRespondStage("COMPLETE_ACCEPT", 3);
            INPUT_DECLINE = new SellerRespondStage("INPUT_DECLINE", 4);
            INPUT_DECLINE_NETWORK_ERROR = new SellerRespondStage("INPUT_DECLINE_NETWORK_ERROR", 5);
            COMPLETE_DECLINE = new SellerRespondStage("COMPLETE_DECLINE", 6);
            INPUT_COUNTER = new SellerRespondStage("INPUT_COUNTER", 7);
            REVIEW_COUNTER = new SellerRespondStage("REVIEW_COUNTER", 8);
            REVIEW_COUNTER_RETRYABLE_ERROR = new SellerRespondStage("REVIEW_COUNTER_RETRYABLE_ERROR", 9);
            COMPLETE_COUNTER = new SellerRespondStage("COMPLETE_COUNTER", 10);
            COMPLETE_RESPOND_ERROR = new SellerRespondStage("COMPLETE_RESPOND_ERROR", 11);
            COMPLETE_COUNTER_ERROR = new SellerRespondStage("COMPLETE_COUNTER_ERROR", 12);
            $VALUES = (new SellerRespondStage[] {
                VIEW_OFFER, REVIEW_FOR_ACCEPT, REVIEW_FOR_ACCEPT_NETWORK_ERROR, COMPLETE_ACCEPT, INPUT_DECLINE, INPUT_DECLINE_NETWORK_ERROR, COMPLETE_DECLINE, INPUT_COUNTER, REVIEW_COUNTER, REVIEW_COUNTER_RETRYABLE_ERROR, 
                COMPLETE_COUNTER, COMPLETE_RESPOND_ERROR, COMPLETE_COUNTER_ERROR
            });
        }

        private SellerRespondStage(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String EXTRA_INPUT = "input";
    public static final String EXTRA_OFFER = "offer";
    private static final String EXTRA_OFFERS_REMAINING = "offers_remaining";
    public static final String EXTRA_STAGE = "stage";
    private static final int SIGN_IN_RESULT_ACCEPT = 2;
    private static final int SIGN_IN_RESULT_COUNTER = 3;
    private static final int SIGN_IN_RESULT_DECLINE = 1;
    private Button acceptConfirmButton;
    private TextView acceptSuccess;
    private PriceView counterBid;
    private TextView counterBidValue;
    private Button counterEditButton;
    private LinearLayout counterInputParent;
    private TextView counterLegal;
    private EditText counterQuantity;
    private TextView counterQuantityValue;
    private Button counterReviewButton;
    private Button counterSubmitButton;
    private LinearLayout counterSubmitButtonsRow;
    private TextView counterSuccess;
    private EditText counterTerms;
    private TextView counterTermsValue;
    private SellerRespondStage currentStage;
    private Button declineConfirmButton;
    private LinearLayout declineMessageRow;
    private TextView declineSuccess;
    private TextView error;
    private BestOfferInput input;
    private BestOffer offer;
    private int offersRemaining;
    private LinearLayout offersRemainingRow;
    private ProgressBar progressBar;
    private int quantityAvailable;
    private LinearLayout respondButtons;
    private Button reviewOffersButton;
    private TextView sellerAcceptLegal;
    private EditText sellerMessage;
    private TextView sellerMessageValue;
    private LinearLayout sellerMessageValueRow;
    private LinearLayout viewCounterParent;
    private ViewItemDataManager viewItemDataManager;
    private LinearLayout viewOfferParent;

    public SellerRespondToOfferActivity()
    {
        currentStage = SellerRespondStage.VIEW_OFFER;
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, BestOffer bestoffer, int i)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/bestoffer/SellerRespondToOfferActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        intent.putExtra("offer", bestoffer);
        activity.startActivityForResult(intent, i);
    }

    private void createUi(int i)
    {
        viewOfferParent = (LinearLayout)findViewById(0x7f100445);
        findViewById(0x7f100487).setOnClickListener(this);
        Object obj = (TextView)findViewById(0x7f100487);
        String s;
        boolean flag;
        if (offer.buyerFeedbackScore != null)
        {
            ((TextView) (obj)).setText((new StringBuilder()).append(offer.buyerId).append(" (").append(offer.buyerFeedbackScore).append(")").toString());
        } else
        {
            ((TextView) (obj)).setText(offer.buyerId);
        }
        offersRemainingRow = (LinearLayout)findViewById(0x7f10044f);
        ((TextView)findViewById(0x7f100450)).setText((new StringBuilder()).append("").append(i).toString());
        ((TextView)findViewById(0x7f10044a)).setText(BestOfferViewHelper.getBidValueStr(getResources(), offer.currentOffer, offer.quantity));
        ((TextView)findViewById(0x7f10044b)).setText((new StringBuilder()).append("").append(offer.quantity).toString());
        obj = (ViewGroup)findViewById(0x7f100312);
        s = item.salesTaxPercent;
        if (s != null)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ViewGroup) (obj)).setVisibility(i);
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
            obj = (TextView)findViewById(0x7f10044e);
            if (TextUtils.isEmpty(offer.buyerMessage))
            {
                ((TextView) (obj)).setText("--");
            } else
            {
                ((TextView) (obj)).setText(offer.buyerMessage);
            }
        } else
        {
            findViewById(0x7f10044d).setVisibility(8);
        }
        if (offer.buyerAddress != null)
        {
            ((TextView)findViewById(0x7f100489)).setText(getShipToString(offer));
            findViewById(0x7f100488).setVisibility(0);
        }
        findViewById(0x7f100459).setOnClickListener(this);
        findViewById(0x7f10045a).setOnClickListener(this);
        findViewById(0x7f10045b).setOnClickListener(this);
        respondButtons = (LinearLayout)findViewById(0x7f100458);
        declineMessageRow = (LinearLayout)findViewById(0x7f10048d);
        declineConfirmButton = (Button)findViewById(0x7f100456);
        declineConfirmButton.setOnClickListener(this);
        progressBar = (ProgressBar)findViewById(0x7f100438);
        error = (TextView)findViewById(0x7f100425);
        declineSuccess = (TextView)findViewById(0x7f100442);
        sellerMessage = (EditText)findViewById(0x7f10048e);
        sellerMessageValue = (TextView)findViewById(0x7f10048c);
        sellerMessageValueRow = (LinearLayout)findViewById(0x7f10048b);
        sellerAcceptLegal = (TextView)findViewById(0x7f10048a);
        acceptConfirmButton = (Button)findViewById(0x7f100457);
        acceptConfirmButton.setOnClickListener(this);
        acceptSuccess = (TextView)findViewById(0x7f100443);
        counterInputParent = (LinearLayout)findViewById(0x7f10045c);
        counterBid = (PriceView)findViewById(0x7f100418);
        counterBid.setCurrency(offer.currentOffer.getCurrencyCode());
        counterQuantity = (EditText)findViewById(0x7f10045f);
        quantityAvailable = item.getQuantityAvailable(viewData.nameValueList);
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
            findViewById(0x7f10046e).setVisibility(8);
        }
        if (quantityAvailable < 2 && !flag)
        {
            counterBid.setImeOptions(6);
        }
        counterTerms = (EditText)findViewById(0x7f100463);
        counterSubmitButtonsRow = (LinearLayout)findViewById(0x7f100471);
        viewCounterParent = (LinearLayout)findViewById(0x7f100466);
        counterLegal = (TextView)findViewById(0x7f100470);
        counterEditButton = (Button)findViewById(0x7f100473);
        counterEditButton.setOnClickListener(this);
        counterSubmitButton = (Button)findViewById(0x7f100472);
        counterSubmitButton.setOnClickListener(this);
        obj = String.format(getString(0x7f07045b), new Object[] {
            EbayCurrencyUtil.formatDisplay(offer.currentOffer, 0)
        });
        ((TextView)findViewById(0x7f10045d)).setText(((CharSequence) (obj)));
        counterBidValue = (TextView)findViewById(0x7f100467);
        counterQuantityValue = (TextView)findViewById(0x7f100469);
        if (quantityAvailable < 2)
        {
            findViewById(0x7f100468).setVisibility(8);
        }
        counterTermsValue = (TextView)findViewById(0x7f10046f);
        counterSuccess = (TextView)findViewById(0x7f100444);
        reviewOffersButton = (Button)findViewById(0x7f100490);
        reviewOffersButton.setOnClickListener(this);
        if (MyApp.getPrefs().getCurrentSite().isEuSite())
        {
            setEuConsumerRightsText();
        }
    }

    public static String getShipToString(BestOffer bestoffer)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (bestoffer != null)
        {
            if (!TextUtils.isEmpty(bestoffer.buyerAddress.addressFields.postalCode))
            {
                stringbuilder.append(bestoffer.buyerAddress.addressFields.postalCode);
            }
            if (!TextUtils.isEmpty(bestoffer.buyerAddress.addressFields.stateOrProvince))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(bestoffer.buyerAddress.addressFields.stateOrProvince);
            }
            if (!TextUtils.isEmpty(bestoffer.buyerAddress.addressFields.countryName))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(bestoffer.buyerAddress.addressFields.countryName);
            }
        }
        return stringbuilder.toString();
    }

    private void handleBackOrTop()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[];

            static 
            {
                $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage = new int[SellerRespondStage.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.INPUT_DECLINE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.INPUT_DECLINE_NETWORK_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.REVIEW_FOR_ACCEPT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.REVIEW_FOR_ACCEPT_NETWORK_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.INPUT_COUNTER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.REVIEW_COUNTER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.REVIEW_COUNTER_RETRYABLE_ERROR.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.VIEW_OFFER.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.COMPLETE_DECLINE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.COMPLETE_ACCEPT.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.COMPLETE_COUNTER.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.COMPLETE_RESPOND_ERROR.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$bestoffer$SellerRespondToOfferActivity$SellerRespondStage[SellerRespondStage.COMPLETE_COUNTER_ERROR.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.bestoffer.SellerRespondToOfferActivity.SellerRespondStage[currentStage.ordinal()])
        {
        default:
            super.onBackPressed();
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            setStage(SellerRespondStage.VIEW_OFFER);
            return;

        case 6: // '\006'
        case 7: // '\007'
            setStage(SellerRespondStage.INPUT_COUNTER);
            break;
        }
    }

    private void setEuConsumerRightsText()
    {
        acceptConfirmButton.setText(0x7f070061);
        counterSubmitButton.setText(0x7f07006b);
        if (item.isGspItem)
        {
            sellerAcceptLegal.setText(0x7f07005d);
            counterLegal.setText(0x7f07005e);
            return;
        } else
        {
            sellerAcceptLegal.setText(0x7f07006f);
            counterLegal.setText(0x7f070070);
            return;
        }
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

    private void setStage(SellerRespondStage sellerrespondstage)
    {
        if (BuyerMakeOfferActivity.log.isLoggable)
        {
            FwLog.println(BuyerMakeOfferActivity.log, (new StringBuilder()).append("stage transition from:").append(currentStage).append(" to:").append(sellerrespondstage).toString());
        }
        showStage(sellerrespondstage, input);
        currentStage = sellerrespondstage;
    }

    private void submitAccept()
    {
        if (!networkAvailable())
        {
            return;
        }
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj == null)
        {
            obj = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
            ((Intent) (obj)).putExtra("client_int", 2);
            startActivityForResult(((Intent) (obj)), 65);
            return;
        } else
        {
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            viewItemDataManager.respondToBestOffer(EbayApiUtil.getTradingApi(this, ((com.ebay.nautilus.domain.app.Authentication) (obj))), "Accept", item.id, Long.valueOf(offer.id).longValue(), null, null, null, -1);
            return;
        }
    }

    private void submitCounter()
    {
        if (!networkAvailable())
        {
            return;
        }
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj == null)
        {
            obj = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
            ((Intent) (obj)).putExtra("client_int", 3);
            startActivityForResult(((Intent) (obj)), 65);
            return;
        } else
        {
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            viewItemDataManager.respondToBestOffer(EbayApiUtil.getTradingApi(this, ((com.ebay.nautilus.domain.app.Authentication) (obj))), "Counter", item.id, Long.valueOf(offer.id).longValue(), input.terms, input.bidAmount, item.currentPrice.code, input.quantity);
            return;
        }
    }

    private void submitDecline()
    {
        if (!networkAvailable())
        {
            return;
        }
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj == null)
        {
            obj = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this);
            ((Intent) (obj)).putExtra("client_int", 1);
            startActivityForResult(((Intent) (obj)), 65);
            return;
        } else
        {
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            viewItemDataManager.respondToBestOffer(EbayApiUtil.getTradingApi(this, ((com.ebay.nautilus.domain.app.Authentication) (obj))), "Decline", item.id, Long.valueOf(offer.id).longValue(), getSellerDeclineMessage(), null, null, -1);
            return;
        }
    }

    public void copyInputForReview(BestOfferInput bestofferinput)
    {
        CurrencyAmount currencyamount = new CurrencyAmount((new StringBuilder()).append("").append(bestofferinput.bidAmount).toString(), item.currentPrice.code);
        counterBidValue.setText(BestOfferViewHelper.getBidValueStr(getResources(), currencyamount, bestofferinput.quantity));
        counterQuantityValue.setText((new StringBuilder()).append("").append(bestofferinput.quantity).toString());
        if (TextUtils.isEmpty(bestofferinput.terms))
        {
            counterTermsValue.setText("--");
            return;
        } else
        {
            counterTermsValue.setText(bestofferinput.terms);
            return;
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
        return "BestOfferSellerRespond";
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
            setStage(SellerRespondStage.INPUT_DECLINE);
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
                setStage(SellerRespondStage.REVIEW_FOR_ACCEPT);
                return;
            }
            if (0x7f100457 == view.getId())
            {
                submitAccept();
                return;
            }
            if (0x7f10045a == view.getId())
            {
                setStage(SellerRespondStage.INPUT_COUNTER);
                return;
            }
            if (0x7f100465 == view.getId())
            {
                input.bidAmount = getCounterBid();
                input.quantity = getCounterQuantity();
                input.terms = getCounterTerms();
                hideKeyboard();
                setStage(SellerRespondStage.REVIEW_COUNTER);
                return;
            }
            if (0x7f100473 == view.getId())
            {
                setStage(SellerRespondStage.INPUT_COUNTER);
                return;
            }
            if (0x7f100472 == view.getId())
            {
                submitCounter();
                return;
            }
            if (0x7f100490 == view.getId())
            {
                onBackPressed();
                return;
            }
            if (0x7f100487 == view.getId())
            {
                UserDetailActivity.StartActivityForBuyer(this, null, offer.buyerId, null, null);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03018d);
        Intent intent = null;
        Object obj = null;
        if (bundle == null)
        {
            intent = getIntent();
            viewData = (ViewItemViewData)intent.getParcelableExtra("view_item_view_data");
            String s = intent.getStringExtra("stage");
            bundle = obj;
            if (!TextUtils.isEmpty(s))
            {
                bundle = SellerRespondStage.valueOf(s);
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
            BestOfferTracking.trackPage(this, getTrackingEventName());
        } else
        {
            viewData = (ViewItemViewData)bundle.getParcelable("view_item_view_data");
            String s1 = bundle.getString("stage");
            Object obj1 = intent;
            if (!TextUtils.isEmpty(s1))
            {
                obj1 = SellerRespondStage.valueOf(s1);
            }
            if (obj1 != null)
            {
                currentStage = ((SellerRespondStage) (obj1));
            }
            offer = (BestOffer)bundle.getParcelable("offer");
            input = (BestOfferInput)bundle.getSerializable("input");
            offersRemaining = bundle.getInt("offers_remaining");
        }
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (!isFinishing())
        {
            super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
            if (!content.getStatus().hasError())
            {
                if (actionhandled == com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.INITIAL_LOAD)
                {
                    headerStart(0x7f03012c);
                    offersRemaining = item.remainingBestOffersForBuyer(offer.buyerId);
                    createUi(offersRemaining);
                    setStage(currentStage);
                    return;
                }
            } else
            {
                EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
                return;
            }
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

    public void onRespondBestOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (!isFinishing())
        {
            if (viewItemDataManager == null)
            {
                viewItemDataManager = viewitemdatamanager;
            }
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
            Long long1;
            String s;
            if (offer != null)
            {
                viewitemdatamanager = offer.id;
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
            if (content.getData() != null)
            {
                s = ((com.ebay.mobile.viewitem.ViewItemDataManager.RespondBestOfferInfo)content.getData()).action;
            } else
            {
                s = null;
            }
            if (!content.getStatus().hasError())
            {
                headerStart(0x7f03012c);
                if ("Accept".equals(s))
                {
                    setStage(SellerRespondStage.COMPLETE_ACCEPT);
                    BestOfferTracking.trackState(this, "OSRA", long1, null, viewitemdatamanager);
                    offer.status = "Accepted";
                    viewitemdatamanager = new Intent();
                    viewitemdatamanager.putExtra("offer", offer);
                    setResult(-1, viewitemdatamanager);
                    return;
                }
                if ("Decline".equals(s))
                {
                    input.declineMessage = getSellerDeclineMessage();
                    setStage(SellerRespondStage.COMPLETE_DECLINE);
                    BestOfferTracking.trackState(this, "OSRD", long1, null, viewitemdatamanager);
                    offer.status = "Declined";
                    viewitemdatamanager = new Intent();
                    viewitemdatamanager.putExtra("offer", offer);
                    setResult(-1, viewitemdatamanager);
                    return;
                }
                if ("Counter".equals(s))
                {
                    setStage(SellerRespondStage.COMPLETE_COUNTER);
                    BestOfferTracking.trackState(this, "OSRC", long1, null, viewitemdatamanager);
                    offer.status = "Countered";
                    viewitemdatamanager = new Intent();
                    viewitemdatamanager.putExtra("offer", offer);
                    setResult(-1, viewitemdatamanager);
                    return;
                }
            } else
            {
                if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
                {
                    EbayErrorHandler.handleResultStatus(this, 0, content.getStatus());
                }
                content = content.getStatus();
                if ("Accept".equals(s))
                {
                    content = content.getFirstMessage();
                    if (content != null)
                    {
                        setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), content));
                        setStage(SellerRespondStage.COMPLETE_RESPOND_ERROR);
                        BestOfferTracking.trackState(this, "OSRE", long1, null, viewitemdatamanager);
                        return;
                    } else
                    {
                        setErrorMessage(getString(0x7f070150));
                        setStage(SellerRespondStage.REVIEW_FOR_ACCEPT_NETWORK_ERROR);
                        return;
                    }
                }
                if ("Decline".equals(s))
                {
                    content = content.getFirstMessage();
                    if (content != null)
                    {
                        setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), content));
                        setStage(SellerRespondStage.COMPLETE_RESPOND_ERROR);
                        BestOfferTracking.trackState(this, "OSRE", long1, null, viewitemdatamanager);
                        return;
                    } else
                    {
                        setErrorMessage(getString(0x7f070150));
                        setStage(SellerRespondStage.INPUT_DECLINE_NETWORK_ERROR);
                        return;
                    }
                }
                if ("Counter".equals(s))
                {
                    com.ebay.nautilus.kernel.content.ResultStatus.Message message = content.getFirstMessage();
                    if (message != null)
                    {
                        content = null;
                        if (message instanceof EbayResponseError)
                        {
                            content = (EbayResponseError)message;
                        }
                        if (content != null && ((EbayResponseError) (content)).code.equals("21916"))
                        {
                            setErrorMessage(getString(0x7f070714));
                        } else
                        {
                            setErrorMessage(ResultStatus.getSafeLongMessage(getEbayContext(), message));
                        }
                        if (content != null && (((EbayResponseError) (content)).code.equals("21917") || ((EbayResponseError) (content)).code.equals("21916") || ((EbayResponseError) (content)).code.equals("21991")))
                        {
                            setStage(SellerRespondStage.REVIEW_COUNTER_RETRYABLE_ERROR);
                            return;
                        } else
                        {
                            setStage(SellerRespondStage.COMPLETE_COUNTER_ERROR);
                            BestOfferTracking.trackState(this, "OSRE", long1, null, viewitemdatamanager);
                            return;
                        }
                    } else
                    {
                        setErrorMessage(getString(0x7f070150));
                        setStage(SellerRespondStage.REVIEW_COUNTER_RETRYABLE_ERROR);
                        return;
                    }
                } else
                {
                    showMessage(0, content);
                    return;
                }
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("stage", currentStage.name());
        bundle.putParcelable("offer", offer);
        bundle.putSerializable("input", input);
        bundle.putInt("offers_remaining", offersRemaining);
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
            flag = flag2;
        } else
        {
            flag = false;
        }
        ((Button) (obj)).setEnabled(flag);
    }

    public void showStage(SellerRespondStage sellerrespondstage, BestOfferInput bestofferinput)
    {
        switch (_cls1..SwitchMap.com.ebay.mobile.bestoffer.SellerRespondToOfferActivity.SellerRespondStage[sellerrespondstage.ordinal()])
        {
        default:
            return;

        case 8: // '\b'
            setTitle(getString(0x7f070b66));
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            error.setVisibility(8);
            sellerAcceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            counterInputParent.setVisibility(8);
            viewOfferParent.setVisibility(0);
            respondButtons.setVisibility(0);
            return;

        case 1: // '\001'
            setTitle(getString(0x7f070b60));
            respondButtons.setVisibility(8);
            error.setVisibility(8);
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

        case 9: // '\t'
            setSellerMessageValue(bestofferinput.declineMessage);
            setTitle(getString(0x7f070b5d));
            respondButtons.setVisibility(8);
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            error.setVisibility(8);
            declineSuccess.setVisibility(0);
            sellerMessageValueRow.setVisibility(0);
            reviewOffersButton.setVisibility(0);
            return;

        case 3: // '\003'
            setTitle(getString(0x7f070b5c));
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            respondButtons.setVisibility(8);
            error.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            sellerAcceptLegal.setVisibility(0);
            acceptConfirmButton.setVisibility(0);
            return;

        case 4: // '\004'
            setTitle(getString(0x7f070b5c));
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            respondButtons.setVisibility(8);
            sellerAcceptLegal.setVisibility(0);
            acceptConfirmButton.setVisibility(0);
            error.setVisibility(0);
            return;

        case 10: // '\n'
            setTitle(getString(0x7f070b5d));
            respondButtons.setVisibility(8);
            error.setVisibility(8);
            sellerAcceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            offersRemainingRow.setVisibility(8);
            acceptSuccess.setVisibility(0);
            reviewOffersButton.setVisibility(0);
            return;

        case 5: // '\005'
            setTitle(getString(0x7f070b62));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            viewCounterParent.setVisibility(8);
            error.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            counterInputParent.setVisibility(0);
            return;

        case 6: // '\006'
            copyInputForReview(bestofferinput);
            setTitle(getString(0x7f070b68));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterInputParent.setVisibility(8);
            error.setVisibility(8);
            viewCounterParent.setVisibility(0);
            counterSubmitButtonsRow.setVisibility(0);
            return;

        case 7: // '\007'
            copyInputForReview(bestofferinput);
            setTitle(getString(0x7f070b68));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterInputParent.setVisibility(8);
            viewCounterParent.setVisibility(0);
            counterSubmitButtonsRow.setVisibility(0);
            error.setVisibility(0);
            return;

        case 11: // '\013'
            setTitle(getString(0x7f070b5f));
            viewOfferParent.setVisibility(8);
            respondButtons.setVisibility(8);
            counterSubmitButtonsRow.setVisibility(8);
            error.setVisibility(8);
            counterLegal.setVisibility(8);
            counterSuccess.setVisibility(0);
            viewCounterParent.setVisibility(0);
            reviewOffersButton.setVisibility(0);
            return;

        case 12: // '\f'
            respondButtons.setVisibility(8);
            declineMessageRow.setVisibility(8);
            declineConfirmButton.setVisibility(8);
            sellerAcceptLegal.setVisibility(8);
            acceptConfirmButton.setVisibility(8);
            viewCounterParent.setVisibility(8);
            error.setVisibility(0);
            viewOfferParent.setVisibility(0);
            reviewOffersButton.setVisibility(0);
            return;

        case 13: // '\r'
            respondButtons.setVisibility(8);
            break;
        }
        declineMessageRow.setVisibility(8);
        declineConfirmButton.setVisibility(8);
        sellerAcceptLegal.setVisibility(8);
        acceptConfirmButton.setVisibility(8);
        viewOfferParent.setVisibility(8);
        counterLegal.setVisibility(8);
        counterSubmitButtonsRow.setVisibility(8);
        error.setVisibility(0);
        viewCounterParent.setVisibility(0);
        reviewOffersButton.setVisibility(0);
    }
}
