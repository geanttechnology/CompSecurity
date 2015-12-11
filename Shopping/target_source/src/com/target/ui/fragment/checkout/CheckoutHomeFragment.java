// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.analytics.a.at;
import com.target.ui.analytics.b.i;
import com.target.ui.fragment.account.AccountTabbedFragment;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.checkout.d.a;
import com.target.ui.fragment.checkout.d.b;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.payment.PaymentCardDetailsFragment;
import com.target.ui.fragment.payment.PaymentCardListFragment;
import com.target.ui.fragment.scan.ScanGiftCardFragment;
import com.target.ui.fragment.shipping.ShippingAddressDetailsFragment;
import com.target.ui.fragment.shipping.ShippingAddressListFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.PayPalDisplayDetails;
import com.target.ui.model.checkout.PaymentCardDisplayDetails;
import com.target.ui.model.checkout.PaymentDetailsModel;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import com.target.ui.model.checkout.TGTEmailRecipientDetailsModel;
import com.target.ui.model.checkout.TGTPickUpPersonDetailsModel;
import com.target.ui.model.checkout.TGTShippingAddressDetailsModel;
import com.target.ui.model.checkout.TGTSmsRecipientDetailsModel;
import com.target.ui.service.provider.f;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.util.q;
import com.target.ui.view.account.c;
import com.target.ui.view.checkout.CardSummaryView;
import com.target.ui.view.checkout.CheckoutProductsView;
import com.target.ui.view.checkout.ContactView;
import com.target.ui.view.checkout.CouponWalletItemContainerView;
import com.target.ui.view.checkout.CouponWalletSavedOffersView;
import com.target.ui.view.checkout.DeliveryView;
import com.target.ui.view.checkout.GiftCardContainerView;
import com.target.ui.view.checkout.PaymentView;
import com.target.ui.view.checkout.PromoCodeContainerView;
import com.target.ui.view.checkout.SummaryView;
import com.target.ui.view.checkout.e;
import com.target.ui.view.checkout.g;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.d;
import com.target.ui.view.common.h;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.checkout:
//            SelectPaymentDialogFragment, PayPalWebFragment, ThankYouDialogFragment, SecurityCodeDialogFragment, 
//            CouponWalletItemListFragment, EmailRecipientDetailsFragment, PickUpDetailsFragment, SmsRecipientDetailsFragment, 
//            GiftCardSelectorDialogFragment, a

public class CheckoutHomeFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.account.BaseAccountDialog.e, com.target.ui.fragment.account.BaseAccountDialog.f, CouponWalletItemListFragment.b, PayPalWebFragment.a, SecurityCodeDialogFragment.a, SelectPaymentDialogFragment.a, ThankYouDialogFragment.a, com.target.ui.fragment.checkout.d.a, b, com.target.ui.fragment.scan.ScanGiftCardFragment.a, com.target.ui.fragment.shipping.a.e.a, com.target.ui.view.account.a, com.target.ui.view.account.b, c, com.target.ui.view.checkout.CouponWalletSavedOffersView.a, com.target.ui.view.checkout.DeliveryView.a, com.target.ui.view.checkout.GiftCardContainerView.a, com.target.ui.view.checkout.c, e, g, com.target.ui.view.common.c, d
{
    static class Views extends com.target.ui.view.a
    {

        CardSummaryView cardSummaryView;
        TextView cartNumber;
        LinearLayout checkoutContainer;
        CheckoutProductsView checkoutProductListView;
        ContactView contactView;
        CouponWalletItemContainerView couponWalletItemContainerView;
        CouponWalletSavedOffersView couponWalletSavedOffersView;
        View couponWalletSpacer;
        DeliveryView deliveryView;
        TargetErrorView errorView;
        GiftCardContainerView giftCardContainerView;
        View giftCardSpacer;
        View paymentSpacer;
        PaymentView paymentView;
        PromoCodeContainerView promoCodeContainer;
        Button purchaseButton;
        View rootView;
        ScrollView scrollView;
        SummaryView summaryView;

        Views(View view)
        {
            super(view);
        }
    }

    public class a
    {

        boolean contactValid;
        boolean deliveryValid;
        boolean paymentValid;
        final CheckoutHomeFragment this$0;

        public a()
        {
            this$0 = CheckoutHomeFragment.this;
            super();
            contactValid = false;
            deliveryValid = false;
            paymentValid = false;
        }
    }


    private static final String ARG_APPLIED_TENDERS = "appliedTenders";
    private static final String ARG_CHECKOUT_CONTEXT = "checkoutContext";
    private static final String ARG_ORDER_REVIEW = "orderReview";
    private static final String ARG_PAYPAL_INITIATED = "the user has initiated the PayPal flow, but has not yet passed paypal validation";
    private static final String ARG_PAYPAL_PENDING_VALIDATION = "the user has entered valid paypal credentials into the paypal web form";
    private static final String ARG_PENDING_GIFT_CARD_SCAN = "the user has recently scanned a gift card barcode";
    public static final int DEFAULT = 0;
    private static final int DEFAULT_SCROLL_X = 0;
    public static final int EXPRESS = 1;
    public static final String GIFT_CARD_APPLY_ENTRY = "entry";
    public static final String GIFT_CARD_APPLY_PICKER = "dialog";
    private static final String SAVED_STATE_APPLIED_TENDERS = "appliedTenders";
    private static final String SAVED_STATE_CHECKOUT_CONTEXT = "checkoutContext";
    private static final String SAVED_STATE_DELIVERY_DETAILS = "deliveryDetails";
    private static final String SAVED_STATE_GIFT_CARD_TENDERS = "giftCardTenders";
    private static final String SAVED_STATE_ORDER_REVIEW = "orderReview";
    private static final String SAVED_STATE_PAYMENT_DETAILS = "paymentDetails";
    private static final String SAVED_STATE_WALLET_ITEMS = "walletItems";
    public static final String TAG = com/target/ui/fragment/checkout/CheckoutHomeFragment.getSimpleName();
    private AppliedTenders mAppliedTenders;
    private boolean mApplySelectedCouponCode;
    private int mCheckoutContext;
    private com.target.ui.fragment.checkout.b.a mCheckoutPresenter;
    private DeliveryDetailsModel mDeliveryDetails;
    private a mFormState;
    private boolean mGiftCardScanRequested;
    private GiftCardSelectorDialogFragment mGiftCardSelectorDialogFragment;
    private List mGiftCardTenderList;
    private OrderReview mOrderReview;
    private PaymentDetailsModel mPaymentDetails;
    private WalletItem mSelectedCouponWalletItem;
    private boolean mShowMyGiftCards;
    private h mSnackBar;
    private Views mViews;
    private List mWalletItemList;

    public CheckoutHomeFragment()
    {
        mApplySelectedCouponCode = false;
    }

    static Views a(CheckoutHomeFragment checkouthomefragment)
    {
        return checkouthomefragment.mViews;
    }

    public static CheckoutHomeFragment a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders, int i1)
    {
        CheckoutHomeFragment checkouthomefragment = new CheckoutHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("orderReview", expressorderreview);
        bundle.putParcelable("appliedTenders", appliedtenders);
        bundle.putInt("checkoutContext", i1);
        checkouthomefragment.setArguments(bundle);
        return checkouthomefragment;
    }

    static EmailRecipientDetailsModel a(CheckoutHomeFragment checkouthomefragment, ContactView contactview, DeliveryTypedProducts deliverytypedproducts)
    {
        return checkouthomefragment.a(contactview, deliverytypedproducts);
    }

    private EmailRecipientDetailsModel a(ContactView contactview, DeliveryTypedProducts deliverytypedproducts)
    {
        if (deliverytypedproducts.c().isEmpty())
        {
            return null;
        }
        if (mDeliveryDetails.d() != null && !mDeliveryDetails.d().a())
        {
            return mDeliveryDetails.d();
        }
        deliverytypedproducts = new com.target.ui.fragment.checkout.d.a.a();
        contactview.a(deliverytypedproducts);
        contactview = new TGTEmailRecipientDetailsModel();
        contactview.a(true);
        if (!((com.target.ui.fragment.checkout.d.a.a) (deliverytypedproducts)).isValid)
        {
            com.target.ui.util.q.d(TAG, "Contact details not valid");
            contactview.b(com.target.ui.util.e.a(ad(), mOrderReview));
            return contactview;
        } else
        {
            contactview.b(((com.target.ui.fragment.checkout.d.a.a) (deliverytypedproducts)).email);
            return contactview;
        }
    }

    static PickUpPersonDetailsModel a(CheckoutHomeFragment checkouthomefragment, ContactView contactview, DeliveryView deliveryview)
    {
        return checkouthomefragment.a(contactview, deliveryview);
    }

    private PickUpPersonDetailsModel a(ContactView contactview, DeliveryView deliveryview)
    {
        Object obj = ad();
        if (obj != null);
        if (mDeliveryDetails.c() == null)
        {
            return null;
        }
        if (!((Guest) (obj)).isAnonymous())
        {
            return mDeliveryDetails.c();
        }
        obj = new com.target.ui.fragment.checkout.d.a.a();
        contactview.a(((com.target.ui.view.checkout.ContactView.a) (obj)));
        contactview = deliveryview.getPickUpNameDetails();
        if (!((com.target.ui.view.checkout.DeliveryView.c) (contactview)).isValid || !((com.target.ui.fragment.checkout.d.a.a) (obj)).isValid)
        {
            com.target.ui.util.q.a(TAG, "No valid pickup person details");
            return null;
        } else
        {
            deliveryview = new TGTPickUpPersonDetailsModel();
            deliveryview.a(true);
            deliveryview.b(false);
            deliveryview.a(((com.target.ui.view.checkout.DeliveryView.c) (contactview)).firstName);
            deliveryview.b(((com.target.ui.view.checkout.DeliveryView.c) (contactview)).lastName);
            deliveryview.c(((com.target.ui.fragment.checkout.d.a.a) (obj)).email);
            return deliveryview;
        }
    }

    private void a(com.target.ui.fragment.checkout.d.a.a a1)
    {
        for (EmailRecipientDetailsModel emailrecipientdetailsmodel = mDeliveryDetails.d(); emailrecipientdetailsmodel == null || !emailrecipientdetailsmodel.a();)
        {
            return;
        }

        TGTEmailRecipientDetailsModel tgtemailrecipientdetailsmodel = new TGTEmailRecipientDetailsModel();
        tgtemailrecipientdetailsmodel.a(true);
        tgtemailrecipientdetailsmodel.b(a1.email);
        mDeliveryDetails.a(tgtemailrecipientdetailsmodel);
        mViews.deliveryView.a(tgtemailrecipientdetailsmodel);
    }

    private void a(String s1, String s2)
    {
        for (Guest guest = ad(); guest == null || !guest.isAnonymous() || mDeliveryDetails.c() == null;)
        {
            return;
        }

        TGTPickUpPersonDetailsModel tgtpickuppersondetailsmodel = (TGTPickUpPersonDetailsModel)mDeliveryDetails.c();
        tgtpickuppersondetailsmodel.a(s1);
        tgtpickuppersondetailsmodel.b(s2);
        mDeliveryDetails.a(tgtpickuppersondetailsmodel);
        mViews.deliveryView.a(tgtpickuppersondetailsmodel);
    }

    private boolean a(a a1)
    {
        return a1.contactValid && a1.deliveryValid && a1.paymentValid;
    }

    static boolean a(CheckoutHomeFragment checkouthomefragment, a a1)
    {
        return checkouthomefragment.a(a1);
    }

    private void ab()
    {
        mViews.errorView.setClickListener(this);
        mViews.giftCardContainerView.setGiftCardActionListener(this);
        mViews.giftCardContainerView.setMyGiftCardActionListener(this);
        mViews.promoCodeContainer.setPromoCodeActionListener(this);
        mViews.paymentView.setPaymentActionListener(this);
    }

    private void ac()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final CheckoutHomeFragment this$0;

            public void onClick(View view)
            {
                view = com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this).contactView;
                DeliveryView deliveryview = com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this).deliveryView;
                DeliveryTypedProducts deliverytypedproducts = com.target.ui.fragment.checkout.CheckoutHomeFragment.b(CheckoutHomeFragment.this).a();
                com.target.ui.fragment.checkout.CheckoutHomeFragment.f(CheckoutHomeFragment.this).a(com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this, com.target.ui.fragment.checkout.CheckoutHomeFragment.c(CheckoutHomeFragment.this)), com.target.ui.fragment.checkout.CheckoutHomeFragment.d(CheckoutHomeFragment.this), com.target.ui.fragment.checkout.CheckoutHomeFragment.e(CheckoutHomeFragment.this), deliverytypedproducts, com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this, view, deliveryview), com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this, view, deliverytypedproducts), com.target.ui.fragment.checkout.CheckoutHomeFragment.b(CheckoutHomeFragment.this, view, deliverytypedproducts));
            }

            
            {
                this$0 = CheckoutHomeFragment.this;
                super();
            }
        };
        mViews.purchaseButton.setOnClickListener(onclicklistener);
    }

    private Guest ad()
    {
        com.target.ui.service.a a1 = com.target.ui.service.a.a();
        if (a1.c().b())
        {
            return (Guest)a1.c().c();
        } else
        {
            return null;
        }
    }

    private boolean ae()
    {
        return getArguments().containsKey("the user has recently scanned a gift card barcode");
    }

    private String af()
    {
        return getArguments().getString("the user has recently scanned a gift card barcode", null);
    }

    private void ag()
    {
        getArguments().remove("the user has recently scanned a gift card barcode");
    }

    private boolean ah()
    {
        return getArguments().containsKey("the user has entered valid paypal credentials into the paypal web form");
    }

    private InitiatedPayPal ai()
    {
        return (InitiatedPayPal)getArguments().getParcelable("the user has entered valid paypal credentials into the paypal web form");
    }

    private void aj()
    {
        getArguments().remove("the user has entered valid paypal credentials into the paypal web form");
    }

    private boolean ak()
    {
        return getArguments().getBoolean("the user has initiated the PayPal flow, but has not yet passed paypal validation");
    }

    private void al()
    {
        String s1;
        if (mViews != null)
        {
            if ((s1 = af()) != null)
            {
                mViews.giftCardContainerView.a(s1);
                ag();
                return;
            }
        }
    }

    private void am()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            InitiatedPayPal initiatedpaypal = ai();
            mCheckoutPresenter.a(initiatedpaypal);
            aj();
            return;
        }
    }

    private void an()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mCheckoutPresenter.l();
            p(false);
            return;
        }
    }

    private String ao()
    {
        String s1 = null;
        com.target.ui.fragment.checkout.d.a.a a1 = new com.target.ui.fragment.checkout.d.a.a();
        mViews.contactView.a(a1);
        if (a1.isValid)
        {
            s1 = a1.email;
        }
        return s1;
    }

    static DeliveryDetailsModel b(CheckoutHomeFragment checkouthomefragment)
    {
        return checkouthomefragment.mDeliveryDetails;
    }

    static SmsRecipientDetailsModel b(CheckoutHomeFragment checkouthomefragment, ContactView contactview, DeliveryTypedProducts deliverytypedproducts)
    {
        return checkouthomefragment.b(contactview, deliverytypedproducts);
    }

    private SmsRecipientDetailsModel b(ContactView contactview, DeliveryTypedProducts deliverytypedproducts)
    {
        if (deliverytypedproducts.d().isEmpty())
        {
            return null;
        }
        if (mDeliveryDetails.e() != null && !mDeliveryDetails.e().a())
        {
            return mDeliveryDetails.e();
        }
        deliverytypedproducts = new com.target.ui.fragment.checkout.d.a.a();
        contactview.a(deliverytypedproducts);
        contactview = new TGTSmsRecipientDetailsModel();
        contactview.a(true);
        if (!((com.target.ui.fragment.checkout.d.a.a) (deliverytypedproducts)).isValid)
        {
            com.target.ui.util.q.d(TAG, "Contact details not valid");
            return contactview;
        } else
        {
            contactview.b(((com.target.ui.fragment.checkout.d.a.a) (deliverytypedproducts)).phone);
            return contactview;
        }
    }

    private void b(com.target.ui.fragment.checkout.d.a.a a1)
    {
        for (SmsRecipientDetailsModel smsrecipientdetailsmodel = mDeliveryDetails.e(); smsrecipientdetailsmodel == null || !smsrecipientdetailsmodel.a();)
        {
            return;
        }

        TGTSmsRecipientDetailsModel tgtsmsrecipientdetailsmodel = new TGTSmsRecipientDetailsModel();
        tgtsmsrecipientdetailsmodel.a(true);
        tgtsmsrecipientdetailsmodel.b(a1.phone);
        mDeliveryDetails.a(tgtsmsrecipientdetailsmodel);
        mViews.deliveryView.a(tgtsmsrecipientdetailsmodel);
    }

    private boolean b(a a1)
    {
        return a1.contactValid || a1.deliveryValid || a1.paymentValid;
    }

    static a c(CheckoutHomeFragment checkouthomefragment)
    {
        return checkouthomefragment.mFormState;
    }

    private void c(a a1)
    {
        if (b(a1))
        {
            mViews.purchaseButton.setBackgroundResource(0x7f020050);
            return;
        } else
        {
            mViews.purchaseButton.setBackgroundResource(0x7f0201d0);
            return;
        }
    }

    static String d(CheckoutHomeFragment checkouthomefragment)
    {
        return checkouthomefragment.ao();
    }

    static OrderReview e(CheckoutHomeFragment checkouthomefragment)
    {
        return checkouthomefragment.mOrderReview;
    }

    static com.target.ui.fragment.checkout.b.a f(CheckoutHomeFragment checkouthomefragment)
    {
        return checkouthomefragment.mCheckoutPresenter;
    }

    private void p(boolean flag)
    {
        getArguments().putBoolean("the user has initiated the PayPal flow, but has not yet passed paypal validation", flag);
    }

    public void A()
    {
        mSnackBar.a();
    }

    public void A_()
    {
        mCheckoutPresenter.a(mOrderReview, mAppliedTenders);
    }

    public void B()
    {
        mViews.couponWalletSavedOffersView.setCouponWalletItemViewListener(this);
        com.target.ui.util.al.b(new View[] {
            mViews.couponWalletSavedOffersView, mViews.couponWalletSpacer
        });
    }

    public void C()
    {
        mViews.couponWalletSavedOffersView.setCouponWalletItemViewListener(null);
        com.target.ui.util.al.a(new View[] {
            mViews.couponWalletSavedOffersView, mViews.couponWalletSpacer, mViews.couponWalletItemContainerView
        });
    }

    public void D()
    {
        mViews.couponWalletSavedOffersView.a();
    }

    public void E()
    {
        if (Z())
        {
            return;
        }
        if (mPaymentDetails.a() && mPaymentDetails.b().b())
        {
            PaymentCardDisplayDetails paymentcarddisplaydetails = (PaymentCardDisplayDetails)mPaymentDetails.b().c();
            com.target.ui.fragment.checkout.SelectPaymentDialogFragment.a(getString(0x7f09027e, new Object[] {
                paymentcarddisplaydetails.b()
            }), paymentcarddisplaydetails.c(), paymentcarddisplaydetails.a(), this).show(getFragmentManager(), SelectPaymentDialogFragment.TAG);
            return;
        } else
        {
            com.target.ui.fragment.checkout.SelectPaymentDialogFragment.a(this).show(getFragmentManager(), SelectPaymentDialogFragment.TAG);
            return;
        }
    }

    public void F()
    {
        if (Z())
        {
            return;
        } else
        {
            ShopHomeFragment shophomefragment = ShopHomeFragment.a();
            m().a(shophomefragment);
            return;
        }
    }

    public void G()
    {
        (new Handler()).post(new Runnable() {

            final CheckoutHomeFragment this$0;

            public void run()
            {
                if (com.target.ui.fragment.checkout.CheckoutHomeFragment.a(CheckoutHomeFragment.this) == null || Z())
                {
                    return;
                } else
                {
                    m().b();
                    return;
                }
            }

            
            {
                this$0 = CheckoutHomeFragment.this;
                super();
            }
        });
    }

    public void H()
    {
        if (Z())
        {
            return;
        } else
        {
            PaymentCardListFragment paymentcardlistfragment = PaymentCardListFragment.a(mOrderReview, this);
            m().d(paymentcardlistfragment);
            return;
        }
    }

    public com.target.ui.fragment.checkout.d.a.a I()
    {
        com.target.ui.fragment.checkout.d.a.a a1 = new com.target.ui.fragment.checkout.d.a.a();
        mViews.contactView.a(a1);
        return a1;
    }

    public OrderReview J()
    {
        return mOrderReview;
    }

    public DeliveryDetailsModel K()
    {
        return mDeliveryDetails;
    }

    public PaymentDetailsModel L()
    {
        return mPaymentDetails;
    }

    public List M()
    {
        return mGiftCardTenderList;
    }

    public boolean N()
    {
        return mShowMyGiftCards;
    }

    public boolean O()
    {
        return mApplySelectedCouponCode;
    }

    public void P()
    {
        mCheckoutPresenter.j();
    }

    public void Q()
    {
        p(true);
        mCheckoutPresenter.k();
    }

    public void a()
    {
        mCheckoutPresenter.c(mWalletItemList);
    }

    public void a(int i1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.purchaseButton.setText(i1);
            return;
        }
    }

    public void a(int i1, int j1)
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a(getString(i1), getString(j1)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void a(int i1, int j1, com.target.ui.fragment.checkout.a a1)
    {
        mSnackBar.a(getString(i1), getString(j1), a1);
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(MenuItem menuitem, boolean flag)
    {
        menuitem.setVisible(flag);
    }

    public void a(View view, boolean flag)
    {
        view.getId();
        JVM INSTR lookupswitch 2: default 32
    //                   2131755330: 41
    //                   2131755335: 52;
           goto _L1 _L2 _L3
_L1:
        c(mFormState);
        return;
_L2:
        mFormState.contactValid = flag;
        continue; /* Loop/switch isn't completed */
_L3:
        mFormState.deliveryValid = flag;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void a(com.target.mothership.common.tender.a a1, String s1)
    {
        mCheckoutPresenter.a(ao(), a1, s1);
    }

    public void a(com.target.mothership.model.cart.b.d d1, String s1)
    {
        mCheckoutPresenter.a(d1, s1);
    }

    public void a(AppliedTenders appliedtenders)
    {
        mAppliedTenders = appliedtenders;
    }

    public void a(InitiatedPayPal initiatedpaypal)
    {
        if (Z())
        {
            return;
        } else
        {
            initiatedpaypal = com.target.ui.fragment.checkout.PayPalWebFragment.a(initiatedpaypal, this);
            m().d(initiatedpaypal);
            return;
        }
    }

    public void a(OrderCompletionDetails ordercompletiondetails)
    {
        com.target.ui.analytics.b.i.a(ordercompletiondetails, mOrderReview, mCheckoutContext).a();
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.checkout.ThankYouDialogFragment.a(ordercompletiondetails.r(), this).show(getFragmentManager(), ThankYouDialogFragment.TAG);
            return;
        }
    }

    public void a(OrderReview orderreview)
    {
        mOrderReview = orderreview;
    }

    public void a(OrderReview orderreview, DeliveryDetailsModel deliverydetailsmodel)
    {
        mViews.summaryView.a(orderreview, deliverydetailsmodel);
    }

    public void a(PromoCode promocode)
    {
        mCheckoutPresenter.a(promocode);
    }

    public void a(com.target.mothership.model.cart.interfaces.a.c c1)
    {
        mViews.giftCardContainerView.a(c1);
    }

    public void a(com.target.mothership.model.cart.interfaces.a.e e1)
    {
        mViews.promoCodeContainer.a(e1);
    }

    public void a(com.target.mothership.model.cart.interfaces.a.g g1)
    {
        mViews.promoCodeContainer.a(g1);
    }

    public void a(AppliedGiftCardTender appliedgiftcardtender)
    {
        mCheckoutPresenter.a(appliedgiftcardtender);
    }

    public void a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a(appliedpaymentcardtender, this).show(getFragmentManager(), SecurityCodeDialogFragment.TAG);
            return;
        }
    }

    public void a(AppliedPaymentCardTender appliedpaymentcardtender, List list, BigDecimal bigdecimal)
    {
        mViews.cardSummaryView.a(appliedpaymentcardtender, list, bigdecimal);
    }

    public void a(GuestAddress guestaddress, OrderReview orderreview)
    {
        mOrderReview = orderreview;
        guestaddress = com.target.ui.util.e.a(guestaddress);
        mDeliveryDetails.a(guestaddress);
    }

    public void a(WalletItem walletitem)
    {
        if (walletitem.a().b())
        {
            mApplySelectedCouponCode = true;
            mSelectedCouponWalletItem = walletitem;
        }
    }

    public void a(Guest guest)
    {
        mCheckoutPresenter.a(guest);
    }

    public void a(Guest guest, com.target.mothership.services.o o1, com.target.ui.fragment.checkout.d.c c1)
    {
        if (Z())
        {
            return;
        } else
        {
            guest = AuthenticateDialog.a(guest, this, c1);
            guest.a(o1);
            guest.show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(com.target.ui.fragment.checkout.d.c c1)
    {
        mCheckoutPresenter.a(c1);
    }

    public void a(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1, OrderReview orderreview)
    {
        mOrderReview = orderreview;
        orderreview = new TGTShippingAddressDetailsModel();
        orderreview.a(true);
        orderreview.c(false);
        orderreview.a(a1.addressLine);
        orderreview.b(a1.apartment);
        mDeliveryDetails.a(orderreview);
    }

    public void a(DeliveryDetailsModel deliverydetailsmodel)
    {
        mViews.checkoutProductListView.a(deliverydetailsmodel);
    }

    public void a(DeliveryDetailsModel deliverydetailsmodel, boolean flag)
    {
        mViews.deliveryView.a(mDeliveryDetails, this, this);
    }

    public void a(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        mDeliveryDetails.a(emailrecipientdetailsmodel);
    }

    public void a(PayPalDisplayDetails paypaldisplaydetails)
    {
        mViews.cardSummaryView.a(paypaldisplaydetails);
    }

    public void a(PaymentDetailsModel paymentdetailsmodel)
    {
        mFormState.paymentValid = paymentdetailsmodel.a();
        c(mFormState);
        mViews.paymentView.setPaymentActionListener(this);
        mViews.paymentView.a(paymentdetailsmodel);
    }

    public void a(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        mDeliveryDetails.a(pickuppersondetailsmodel);
    }

    public void a(SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        mDeliveryDetails.a(smsrecipientdetailsmodel);
    }

    public void a(String s1)
    {
        mCheckoutPresenter.b(s1);
    }

    public void a(ArrayList arraylist)
    {
        if (Z())
        {
            return;
        } else
        {
            arraylist = com.target.ui.fragment.checkout.CouponWalletItemListFragment.a(arraylist, this);
            m().d(arraylist);
            return;
        }
    }

    public void a(List list)
    {
        mCheckoutPresenter.a(list);
    }

    public void a(List list, boolean flag, boolean flag1)
    {
        mViews.giftCardContainerView.a(list, flag, flag1);
    }

    public void a(boolean flag)
    {
        com.target.ui.util.al.a(mViews.checkoutContainer, flag);
    }

    public void a(boolean flag, String s1, String s2)
    {
        if (flag)
        {
            a(s1, s2);
        }
    }

    public boolean a(com.target.ui.e.e e1)
    {
        com.target.ui.util.ai.a(this, 0x7f090219);
        return true;
    }

    public void b()
    {
        mCheckoutPresenter.d(mWalletItemList);
    }

    public void b(int i1)
    {
        j(getString(i1));
    }

    public void b(int i1, int j1)
    {
        mViews.couponWalletSavedOffersView.a(getString(i1, new Object[] {
            Integer.valueOf(j1)
        }));
    }

    public void b(View view, boolean flag)
    {
label0:
        {
            if (view == mViews.contactView && flag)
            {
                view = new com.target.ui.fragment.checkout.d.a.a();
                mViews.contactView.a(view);
                if (((com.target.ui.fragment.checkout.d.a.a) (view)).isValid)
                {
                    break label0;
                }
                com.target.ui.util.q.a(TAG, "contact information still not valid");
            }
            return;
        }
        a(view);
        b(((com.target.ui.fragment.checkout.d.a.a) (view)));
    }

    public void b(InitiatedPayPal initiatedpaypal)
    {
        p(false);
        getArguments().putParcelable("the user has entered valid paypal credentials into the paypal web form", initiatedpaypal);
    }

    public void b(OrderReview orderreview)
    {
        mViews.contactView.setInputValidationListener(this);
        mViews.contactView.setInputChangeListener(this);
        mViews.contactView.a(orderreview);
    }

    public void b(PromoCode promocode)
    {
        mViews.promoCodeContainer.b(promocode);
    }

    public void b(com.target.mothership.model.cart.interfaces.a.c c1)
    {
        if (Z())
        {
            return;
        } else
        {
            c1 = (com.target.mothership.model.cart.interfaces.a.c.a)c1.e();
            c1 = com.target.ui.util.e.a(getActivity(), c1);
            ErrorDialogFragment.a(getString(0x7f09021b), c1).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void b(WalletItem walletitem)
    {
        mSelectedCouponWalletItem = walletitem;
    }

    public void b(DeliveryDetailsModel deliverydetailsmodel)
    {
        mDeliveryDetails = deliverydetailsmodel;
    }

    public void b(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        if (Z())
        {
            return;
        } else
        {
            emailrecipientdetailsmodel = com.target.ui.fragment.checkout.EmailRecipientDetailsFragment.a(mOrderReview, emailrecipientdetailsmodel, this);
            m().d(emailrecipientdetailsmodel);
            return;
        }
    }

    public void b(PaymentDetailsModel paymentdetailsmodel)
    {
        mPaymentDetails = paymentdetailsmodel;
    }

    public void b(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        if (Z())
        {
            return;
        } else
        {
            pickuppersondetailsmodel = com.target.ui.fragment.checkout.PickUpDetailsFragment.a(pickuppersondetailsmodel, this);
            m().d(pickuppersondetailsmodel);
            return;
        }
    }

    public void b(SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        if (Z())
        {
            return;
        } else
        {
            smsrecipientdetailsmodel = com.target.ui.fragment.checkout.SmsRecipientDetailsFragment.a(smsrecipientdetailsmodel, this);
            m().d(smsrecipientdetailsmodel);
            return;
        }
    }

    public void b(Object obj)
    {
        a((com.target.ui.fragment.checkout.d.c)obj);
    }

    public void b(String s1)
    {
        mCheckoutPresenter.a(s1);
    }

    public void b(List list)
    {
        mCheckoutPresenter.b(list);
    }

    public void c()
    {
        mCheckoutPresenter.e();
    }

    public void c(int i1)
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a("", getString(i1)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void c(OrderReview orderreview)
    {
        mViews.promoCodeContainer.a(orderreview);
    }

    public void c(String s1)
    {
        if (!com.target.ui.util.validation.b.n(s1))
        {
            com.target.ui.util.ai.a(this, 0x7f090281);
            return;
        }
        Bundle bundle1 = getArguments();
        Bundle bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        bundle.putString("the user has recently scanned a gift card barcode", s1);
    }

    public void c(List list)
    {
        while (Z() || mGiftCardSelectorDialogFragment == null || !mGiftCardSelectorDialogFragment.isVisible()) 
        {
            return;
        }
        mGiftCardSelectorDialogFragment.a(list);
    }

    public void c(boolean flag)
    {
        com.target.ui.util.al.a(mViews.errorView, flag);
    }

    public void d(int i1)
    {
        while (Z() || mGiftCardSelectorDialogFragment == null || !mGiftCardSelectorDialogFragment.isVisible()) 
        {
            return;
        }
        mGiftCardSelectorDialogFragment.a(getString(i1));
    }

    public void d(OrderReview orderreview)
    {
        mOrderReview = orderreview;
    }

    public void d(String s1)
    {
        mCheckoutPresenter.d(s1);
    }

    public void d(List list)
    {
        com.target.ui.util.al.b(mViews.couponWalletItemContainerView);
        mViews.couponWalletItemContainerView.a(list);
    }

    public void d(boolean flag)
    {
        o(flag);
    }

    public void e()
    {
        mGiftCardSelectorDialogFragment = com.target.ui.fragment.checkout.GiftCardSelectorDialogFragment.a(mGiftCardTenderList, this);
        mGiftCardSelectorDialogFragment.show(getFragmentManager(), GiftCardSelectorDialogFragment.TAG);
    }

    public void e(int i1)
    {
        mSnackBar.c(getString(i1));
    }

    public void e(String s1)
    {
        mCheckoutPresenter.e(s1);
    }

    public void e(List list)
    {
        if (Z())
        {
            return;
        } else
        {
            list = ShippingAddressDetailsFragment.a(false, mOrderReview, (ArrayList)list, null, false, null, this);
            m().d(list);
            return;
        }
    }

    public void e(boolean flag)
    {
        if (flag)
        {
            com.target.ui.util.al.b(new View[] {
                mViews.giftCardContainerView, mViews.giftCardSpacer
            });
            return;
        } else
        {
            com.target.ui.util.al.a(new View[] {
                mViews.giftCardContainerView, mViews.giftCardSpacer
            });
            return;
        }
    }

    public void f(int i1)
    {
        mViews.couponWalletSavedOffersView.a(getString(i1));
    }

    public void f(String s1)
    {
        if (com.target.mothership.util.o.e(s1))
        {
            com.target.ui.util.q.a(TAG, "orderId is blank");
            return;
        } else
        {
            mViews.cartNumber.setText((new StringBuilder()).append(getString(0x7f0901c7)).append(s1).toString());
            return;
        }
    }

    public void f(List list)
    {
        if (Z())
        {
            return;
        } else
        {
            list = ShippingAddressListFragment.a(mOrderReview, list, this);
            m().d(list);
            return;
        }
    }

    public void f(boolean flag)
    {
        mViews.giftCardContainerView.a(flag);
    }

    public void g()
    {
        if (mGiftCardScanRequested)
        {
            return;
        } else
        {
            ScanGiftCardFragment scangiftcardfragment = ScanGiftCardFragment.a(this);
            m().d(scangiftcardfragment);
            mGiftCardScanRequested = true;
            return;
        }
    }

    public void g(int i1)
    {
        mViews.couponWalletSavedOffersView.b(getString(i1));
    }

    public void g(String s1)
    {
        mViews.promoCodeContainer.a(s1);
    }

    public void g(List list)
    {
        mGiftCardTenderList = list;
    }

    public void g(boolean flag)
    {
        mViews.promoCodeContainer.a(flag);
    }

    public void h()
    {
        mCheckoutPresenter.i();
    }

    public void h(String s1)
    {
        mViews.couponWalletSavedOffersView.a(s1);
    }

    public void h(List list)
    {
        mWalletItemList = list;
    }

    public void h(boolean flag)
    {
        if (flag)
        {
            mViews.couponWalletSavedOffersView.b();
            return;
        } else
        {
            mViews.couponWalletSavedOffersView.c();
            return;
        }
    }

    public void i()
    {
    }

    public void i(String s1)
    {
        if (Z())
        {
            return;
        } else
        {
            s1 = AccountTabbedFragment.a(s1);
            m().e(s1);
            return;
        }
    }

    public void i(boolean flag)
    {
        if (flag)
        {
            mViews.couponWalletSavedOffersView.d();
            return;
        } else
        {
            mViews.couponWalletSavedOffersView.e();
            return;
        }
    }

    public void j()
    {
        mCheckoutPresenter.a(mDeliveryDetails);
    }

    public void j(boolean flag)
    {
        if (Z())
        {
            return;
        }
        Object obj = com.target.ui.util.e.a((AppliedPaymentCardTender)mOrderReview.k().d());
        if (obj == null)
        {
            obj = PaymentCardDetailsFragment.a(mOrderReview, flag, this);
        } else
        {
            obj = PaymentCardDetailsFragment.a(mOrderReview, ((com.target.ui.model.checkout.PaymentCardInformationModel) (obj)), flag, this);
        }
        m().d(((android.support.v4.app.Fragment) (obj)));
    }

    public void k()
    {
        mCheckoutPresenter.b(mDeliveryDetails);
    }

    public void k(boolean flag)
    {
        mShowMyGiftCards = flag;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public void l(boolean flag)
    {
        mApplySelectedCouponCode = flag;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return this;
    }

    public void n_()
    {
        mCheckoutPresenter.f();
    }

    public void o()
    {
        mCheckoutPresenter.c(mDeliveryDetails);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        mOrderReview = (OrderReview)bundle.getParcelable("orderReview");
        mAppliedTenders = (AppliedTenders)bundle.getParcelable("appliedTenders");
        mCheckoutContext = bundle.getInt("checkoutContext");
        mDeliveryDetails = (DeliveryDetailsModel)bundle.getParcelable("deliveryDetails");
        mPaymentDetails = (PaymentDetailsModel)bundle.getParcelable("paymentDetails");
        mGiftCardTenderList = bundle.getParcelableArrayList("giftCardTenders");
        mWalletItemList = bundle.getParcelableArrayList("walletItems");
_L4:
        mCheckoutPresenter = new com.target.ui.fragment.checkout.b.a(new com.target.ui.helper.c.c(mOrderReview), mCheckoutContext, new f(), new com.target.ui.service.provider.d(), new com.target.ui.j.a.a.a(), new com.target.ui.fragment.checkout.a.b(this, new f(), new com.target.ui.helper.c.c(mOrderReview), this), this);
        mFormState = new a();
        return;
_L2:
        if (getArguments() != null)
        {
            mOrderReview = (OrderReview)getArguments().getParcelable("orderReview");
            mAppliedTenders = (AppliedTenders)getArguments().getParcelable("appliedTenders");
            mCheckoutContext = getArguments().getInt("checkoutContext");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            mCheckoutPresenter.a(menu, menuinflater);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004c, viewgroup, false);
        mViews = new Views(layoutinflater);
        ab();
        ac();
        mSnackBar = new h(getActivity());
        mCheckoutPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mCheckoutPresenter.v_();
        mCheckoutPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mCheckoutPresenter.z_();
        mViews = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return mCheckoutPresenter.a(menuitem) || super.onOptionsItemSelected(menuitem);
    }

    public void onPause()
    {
        super.onPause();
        mCheckoutPresenter.d();
        if (mGiftCardSelectorDialogFragment != null)
        {
            mGiftCardSelectorDialogFragment.dismiss();
        }
    }

    public void onResume()
    {
        super.onResume();
        mGiftCardScanRequested = false;
        if (ae())
        {
            al();
        }
        if (ah())
        {
            am();
        }
        if (ak())
        {
            an();
        }
        at.a(mOrderReview, a(V())).e();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("orderReview", mOrderReview);
        bundle.putParcelable("appliedTenders", mAppliedTenders);
        bundle.putInt("checkoutContext", mCheckoutContext);
        bundle.putParcelable("deliveryDetails", mDeliveryDetails);
        bundle.putParcelable("paymentDetails", mPaymentDetails);
        if (mGiftCardTenderList != null)
        {
            bundle.putParcelableArrayList("giftCardTenders", new ArrayList(mGiftCardTenderList));
        }
        if (mWalletItemList != null)
        {
            bundle.putParcelableArrayList("walletItems", new ArrayList(mWalletItemList));
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mCheckoutPresenter.a(mWalletItemList, mApplySelectedCouponCode, mSelectedCouponWalletItem, mOrderReview, mAppliedTenders);
    }

    public void p()
    {
        mCheckoutPresenter.h();
    }

    public void q()
    {
        Object obj = "";
        if (mViews != null)
        {
            obj = new com.target.ui.fragment.checkout.d.a.a();
            mViews.contactView.a(((com.target.ui.view.checkout.ContactView.a) (obj)));
            obj = ((com.target.ui.fragment.checkout.d.a.a) (obj)).email;
        }
        mCheckoutPresenter.c(((String) (obj)));
    }

    public void r()
    {
        getActivity().d();
    }

    public void s()
    {
        com.target.ui.util.al.b(new View[] {
            mViews.paymentSpacer, mViews.paymentView
        });
    }

    public void t()
    {
        mFormState.paymentValid = true;
        c(mFormState);
        com.target.ui.util.al.a(new View[] {
            mViews.paymentSpacer, mViews.paymentView
        });
    }

    public void u()
    {
        com.target.ui.util.e.a.a(this);
    }

    public void v()
    {
        mViews.promoCodeContainer.a();
        mViews.giftCardContainerView.a();
    }

    public void w()
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        com.target.ui.util.al.a(mViews.errorView, new View[] {
            mViews.checkoutContainer
        });
    }

    public void x()
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a("", getString(0x7f090278)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void y()
    {
        mShowMyGiftCards = false;
        mViews.giftCardContainerView.b(false);
    }

    public void z()
    {
        if (!a(mFormState))
        {
            mViews.contactView.a();
            mViews.deliveryView.a();
            mViews.paymentView.a();
            if (!mFormState.contactValid)
            {
                mViews.scrollView.smoothScrollTo(0, mViews.contactView.getTop());
                return;
            }
            if (!mFormState.paymentValid)
            {
                mViews.scrollView.smoothScrollTo(0, mViews.paymentView.getTop());
                return;
            }
            if (!mFormState.deliveryValid)
            {
                mViews.scrollView.smoothScrollTo(0, mViews.deliveryView.getTop());
                return;
            }
        }
    }

}
