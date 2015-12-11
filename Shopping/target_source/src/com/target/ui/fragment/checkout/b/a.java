// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.b;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.a.g;
import com.target.mothership.model.cart.interfaces.a.h;
import com.target.mothership.model.cart.interfaces.a.i;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.cart.interfaces.a.r;
import com.target.mothership.model.cart.interfaces.a.s;
import com.target.mothership.model.cart.interfaces.a.t;
import com.target.mothership.model.cart.interfaces.a.v;
import com.target.mothership.model.cart.interfaces.a.x;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.fragment.checkout.GiftCardSelectorDialogFragment;
import com.target.ui.fragment.checkout.c.f;
import com.target.ui.fragment.checkout.d.b;
import com.target.ui.helper.c.c;
import com.target.ui.helper.c.d;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.PayPalDisplayDetails;
import com.target.ui.model.checkout.PaymentDetailsModel;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import com.target.ui.model.checkout.TGTEmailRecipientDetailsModel;
import com.target.ui.model.checkout.TGTSmsRecipientDetailsModel;
import com.target.ui.service.provider.m;
import com.target.ui.util.e;
import com.target.ui.util.q;
import com.target.ui.view.checkout.PromoCodeInputView;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.c.c.a, com.target.ui.helper.c.d.a
{

    private static final String TAG = com/target/ui/fragment/checkout/b/a.getSimpleName();
    private int mCheckoutContext;
    private com.target.ui.fragment.checkout.a.a mCheckoutCouponWalletFeature;
    private c mCheckoutDataHelper;
    private com.target.ui.fragment.checkout.d.a mCheckoutModelHolder;
    private com.target.ui.service.provider.b mConnectivityProvider;
    private m mGuestProvider;
    private com.target.ui.fragment.checkout.a.c mPayPalFeature;
    private d mPendingActionsHelper;
    private b mPresentation;

    public a(c c1, int i1, m m1, com.target.ui.service.provider.b b1, com.target.ui.fragment.checkout.a.c c2, com.target.ui.fragment.checkout.a.a a1, com.target.ui.fragment.checkout.d.a a2)
    {
        mCheckoutDataHelper = c1;
        mCheckoutContext = i1;
        mGuestProvider = m1;
        mConnectivityProvider = b1;
        mCheckoutModelHolder = a2;
        mPayPalFeature = c2;
        mCheckoutCouponWalletFeature = a1;
        mCheckoutModelHolder.k(p());
    }

    static b a(a a1)
    {
        return a1.mPresentation;
    }

    private EmailRecipientDetailsModel a(OrderReview orderreview, DeliveryDetailsModel deliverydetailsmodel, com.target.ui.fragment.checkout.d.a.a a1)
    {
        if (deliverydetailsmodel.a().c().isEmpty())
        {
            return null;
        }
        if (deliverydetailsmodel.d() != null && !deliverydetailsmodel.d().a())
        {
            return deliverydetailsmodel.d();
        }
        deliverydetailsmodel = new TGTEmailRecipientDetailsModel();
        deliverydetailsmodel.a(true);
        if (!a1.isValid)
        {
            com.target.ui.util.q.d(TAG, "Contact details not valid");
            deliverydetailsmodel.b(com.target.ui.util.e.a(mGuestProvider.a(), orderreview));
            return deliverydetailsmodel;
        } else
        {
            deliverydetailsmodel.b(a1.email);
            return deliverydetailsmodel;
        }
    }

    private SmsRecipientDetailsModel a(DeliveryDetailsModel deliverydetailsmodel, com.target.ui.fragment.checkout.d.a.a a1)
    {
        if (deliverydetailsmodel.a().d().isEmpty())
        {
            return null;
        }
        if (deliverydetailsmodel.e() != null && !deliverydetailsmodel.e().a())
        {
            return deliverydetailsmodel.e();
        }
        deliverydetailsmodel = new TGTSmsRecipientDetailsModel();
        deliverydetailsmodel.a(true);
        if (!a1.isValid)
        {
            com.target.ui.util.q.d(TAG, "Contact details not valid");
            return deliverydetailsmodel;
        } else
        {
            deliverydetailsmodel.b(a1.phone);
            return deliverydetailsmodel;
        }
    }

    private void a(OrderReview orderreview)
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.d(TAG, "Guest session is null while updating order views");
            return;
        }
        mPresentation.b(orderreview);
        mPresentation.c(orderreview);
        DeliveryDetailsModel deliverydetailsmodel = com.target.ui.util.e.a(guest, orderreview, mCheckoutModelHolder.K());
        if (deliverydetailsmodel == null || deliverydetailsmodel.a() == null)
        {
            g();
            return;
        }
        com.target.ui.fragment.checkout.d.a.a a1 = mPresentation.I();
        deliverydetailsmodel.a(a(orderreview, deliverydetailsmodel, a1));
        deliverydetailsmodel.a(a(deliverydetailsmodel, a1));
        mCheckoutModelHolder.b(deliverydetailsmodel);
        if (mCheckoutContext == 1)
        {
            mPresentation.a(deliverydetailsmodel);
        }
        mPresentation.a(deliverydetailsmodel, guest.isAnonymous());
        mPresentation.a(orderreview, mCheckoutModelHolder.K());
    }

    private void a(AppliedPaymentCardTender appliedpaymentcardtender, List list, AppliedPayPalDetails appliedpaypaldetails, BigDecimal bigdecimal, boolean flag)
    {
        boolean flag2 = true;
        if (mPresentation != null)
        {
            if (mGuestProvider.a() == null)
            {
                com.target.ui.util.q.d(TAG, "Guest session is null while updating payment views");
                return;
            }
            DeliveryDetailsModel deliverydetailsmodel = mCheckoutModelHolder.K();
            if (deliverydetailsmodel != null && deliverydetailsmodel.a() != null)
            {
                mPresentation.a(list, flag, mCheckoutModelHolder.N());
                appliedpaypaldetails = com.target.ui.util.e.a(appliedpaymentcardtender, appliedpaypaldetails);
                mCheckoutModelHolder.b(appliedpaypaldetails);
                b b1;
                boolean flag1;
                if (appliedpaypaldetails.a() && appliedpaypaldetails.c().b())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                b1 = mPresentation;
                if (flag1)
                {
                    flag2 = false;
                }
                b1.e(flag2);
                if (flag1)
                {
                    mPresentation.a((PayPalDisplayDetails)appliedpaypaldetails.c().c());
                } else
                {
                    mPresentation.a(appliedpaymentcardtender, list, bigdecimal);
                }
                if (flag)
                {
                    n();
                    return;
                } else
                {
                    a(((PaymentDetailsModel) (appliedpaypaldetails)));
                    return;
                }
            }
        }
    }

    private void a(Guest guest, com.target.mothership.services.o o1, com.target.ui.fragment.checkout.d.c c1)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.v();
        if (guest.isAnonymous())
        {
            mCheckoutDataHelper.a(guest, o1, this);
            return;
        } else
        {
            mPresentation.a(guest, o1, c1);
            return;
        }
    }

    private void a(Guest guest, String s1)
    {
        mPresentation.d(true);
        mCheckoutDataHelper.b(guest, s1, this);
    }

    private void a(com.target.mothership.services.o o1)
    {
        a(((com.target.ui.fragment.checkout.a) (new com.target.ui.fragment.checkout.a(o1) {

            final a this$0;

            public void c()
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).g(true);
                    return;
                }
            }

            
            {
                this$0 = a.this;
                super(o1);
            }
        })));
    }

    private void a(com.target.ui.fragment.checkout.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.u();
            mPresentation.v();
            mPresentation.a(0x7f0904cc, 0x7f090203, a1);
            return;
        }
    }

    private void a(PaymentDetailsModel paymentdetailsmodel)
    {
        mPresentation.s();
        mPresentation.a(paymentdetailsmodel);
    }

    private void a(String s1, OrderReview orderreview, DeliveryTypedProducts deliverytypedproducts, PickUpPersonDetailsModel pickuppersondetailsmodel, EmailRecipientDetailsModel emailrecipientdetailsmodel, SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        mPendingActionsHelper = new d(mGuestProvider.a(), s1, orderreview, deliverytypedproducts.b(), deliverytypedproducts.c(), deliverytypedproducts.d(), pickuppersondetailsmodel, emailrecipientdetailsmodel, smsrecipientdetailsmodel, this);
        mPendingActionsHelper.a();
    }

    private void b(int i1)
    {
        mPendingActionsHelper.b();
        mPresentation.d(false);
        mPresentation.c(i1);
    }

    private void b(OrderReview orderreview, AppliedTenders appliedtenders)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (!mConnectivityProvider.a())
        {
            mPresentation.w();
            return;
        }
        if (orderreview != null)
        {
            a(orderreview);
            mPresentation.f(orderreview.a());
            boolean flag;
            if (orderreview.p().b())
            {
                appliedtenders = (BigDecimal)orderreview.p().c();
            } else
            if (appliedtenders != null)
            {
                appliedtenders = appliedtenders.a();
            } else
            {
                mPresentation.d(true);
                mPresentation.a(true);
                mPresentation.c(false);
                r();
                return;
            }
            flag = com.target.ui.util.e.a(orderreview.l(), appliedtenders);
            a((AppliedPaymentCardTender)orderreview.k().d(), orderreview.l(), (AppliedPayPalDetails)orderreview.m().d(), appliedtenders, flag);
            mPresentation.a(true);
            mPresentation.c(false);
            return;
        } else
        {
            g();
            return;
        }
    }

    private void b(h h1, com.target.mothership.services.o o1)
    {
        h1 = h1.f();
        if (!h1.isEmpty()) goto _L2; else goto _L1
_L1:
        mPresentation.x();
_L4:
        return;
_L2:
        h1 = h1.iterator();
        do
        {
            if (!h1.hasNext())
            {
                continue;
            }
            com.target.mothership.model.cart.interfaces.a.h.a a1 = (com.target.mothership.model.cart.interfaces.a.h.a)h1.next();
            static class _cls3
            {

                static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[];
                static final int $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[];

                static 
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason = new int[com.target.mothership.model.cart.interfaces.a.h.a.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_TOKEN_EXPIRED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_ACCOUNT_IN_USE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_REAUTH_REQUIRED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_TC_PIN_REQUIRED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_DECLINE_TC_PIN_INVALID.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_CVV_REQUIRED.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_DECLINE_CVV_INVALID.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_DECLINE_MAX_RETRIES.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_INVALID_PAYMENT.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_DECLINE_TARGET_DEBIT_CARD.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_VALIDATE_PAYMENT_INSTRUCTION.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_NO_ADDRESS.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_TOO_MANY_REQUESTS.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_CART_EMPTY.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.h.a.ERR_CART_UNKNOWN.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType = new int[com.target.ui.fragment.checkout.d.c.values().length];
                    try
                    {
                        $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[com.target.ui.fragment.checkout.d.c.GIFT_CARD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[com.target.ui.fragment.checkout.d.c.PROMO_CODE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[com.target.ui.fragment.checkout.d.c.DEFAULT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3..SwitchMap.com.target.mothership.model.cart.interfaces.error.CheckoutFailure.CheckoutFailureReason[a1.ordinal()])
            {
            default:
                mPresentation.x();
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                com.target.ui.util.q.a(TAG, "Reauthentication is required before proceeding with checkout");
                a(mGuestProvider.a(), o1, com.target.ui.fragment.checkout.d.c.DEFAULT);
                break;

            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
                o();
                break;

            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
                com.target.ui.util.q.a(TAG, "tried to checkout but payment instruction is invalid");
                // fall through

            case 11: // '\013'
                com.target.ui.util.q.a(TAG, "tried to checkout but there is no payment instruction associated with this order.");
                mPresentation.a(0x7f0901fe, 0x7f0901fd);
                break;

            case 12: // '\f'
                com.target.ui.util.q.a(TAG, "tried to checkout but there was no address associated with this order.");
                mPresentation.a(0x7f0901f0, 0x7f0901ef);
                break;

            case 13: // '\r'
                com.target.ui.util.q.a(TAG, "tried to checkout but throttling is enabled, unable to place the order.");
                mPresentation.c(0x7f09027b);
                break;

            case 14: // '\016'
                com.target.ui.util.q.a(TAG, "tried to checkout but services reported an empty cart.");
                mPresentation.x();
                mPresentation.G();
                break;
            }
        } while (true);
          goto _L3
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b(com.target.mothership.services.o o1)
    {
        a(new com.target.ui.fragment.checkout.a(o1) {

            final a this$0;

            public void c()
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(true);
                    return;
                }
            }

            
            {
                this$0 = a.this;
                super(o1);
            }
        });
    }

    private void m()
    {
        mCheckoutCouponWalletFeature = new com.target.ui.fragment.checkout.a.b(mPresentation, mGuestProvider, mCheckoutDataHelper, mCheckoutModelHolder);
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "The current session was unexpectedly null in onCreateView()");
            mPresentation.G();
        } else
        if (q())
        {
            mCheckoutDataHelper.c(guest, this);
            return;
        }
    }

    private void n()
    {
        mPresentation.t();
    }

    private void o()
    {
        OrderReview orderreview = mCheckoutModelHolder.J();
        mPresentation.a((AppliedPaymentCardTender)orderreview.k().c());
    }

    private boolean p()
    {
        Guest guest = mGuestProvider.a();
        return guest != null && !guest.isAnonymous();
    }

    private boolean q()
    {
        return mCheckoutModelHolder.N() && mCheckoutModelHolder.M() == null;
    }

    private void r()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to fetch applied tenders, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        } else
        {
            mCheckoutDataHelper.b(guest, this);
            return;
        }
    }

    private void s()
    {
        mCheckoutDataHelper.b();
        if (mPendingActionsHelper != null)
        {
            mPendingActionsHelper.b();
        }
    }

    public void a(int i1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mPendingActionsHelper != null)
        {
            mPendingActionsHelper.b();
        }
        mPresentation.d(false);
        mPresentation.v();
        mPresentation.c(0x7f09027b);
    }

    public void a(int i1, Guest guest, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mPendingActionsHelper != null)
        {
            mPendingActionsHelper.b();
        }
        mPresentation.d(false);
        i1;
        JVM INSTR lookupswitch 3: default 68
    //                   40: 100
    //                   41: 100
    //                   50: 82;
           goto _L1 _L2 _L2 _L3
_L1:
        com.target.ui.fragment.checkout.d.c c1 = com.target.ui.fragment.checkout.d.c.DEFAULT;
_L5:
        a(guest, o1, c1);
        return;
_L3:
        mPresentation.g(false);
        c1 = com.target.ui.fragment.checkout.d.c.PROMO_CODE;
        continue; /* Loop/switch isn't completed */
_L2:
        mPresentation.f(false);
        c1 = com.target.ui.fragment.checkout.d.c.GIFT_CARD;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(menu, menuinflater, 0x7f120004);
        mPresentation.b(0x7f0901b9);
        menuinflater = mGuestProvider.a();
        if (menuinflater == null)
        {
            com.target.ui.util.q.a(TAG, "The current session was unexpectedly null on onCreateOptionsMenu()");
            return;
        } else
        {
            mPresentation.a(menu.findItem(0x7f100601), menuinflater.isAnonymous());
            return;
        }
    }

    public void a(com.target.mothership.model.cart.b.d d1, String s1)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to apply GiftCard, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        }
        mPresentation.f(true);
        if (com.target.mothership.util.o.a(GiftCardSelectorDialogFragment.TAG, s1))
        {
            s1 = "dialog";
        } else
        {
            s1 = "entry";
        }
        mCheckoutDataHelper.a(guest, d1, s1, this);
    }

    public void a(AppliedTenders appliedtenders)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mCheckoutModelHolder.a(appliedtenders);
            BigDecimal bigdecimal = appliedtenders.a();
            OrderReview orderreview = mCheckoutModelHolder.J();
            a((AppliedPaymentCardTender)orderreview.k().d(), orderreview.l(), ((AppliedPayPalDetails) (null)), bigdecimal, com.target.ui.util.e.a(appliedtenders.b(), bigdecimal));
            mPresentation.d(false);
            return;
        }
    }

    public void a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders)
    {
        mCheckoutModelHolder.d(expressorderreview);
        mCheckoutModelHolder.k(p());
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            m();
            b(expressorderreview, appliedtenders);
            return;
        }
    }

    public void a(InitiatedPayPal initiatedpaypal)
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "tried to update paypal as a payment option, but the current session is null");
            mPresentation.G();
            return;
        } else
        {
            mPresentation.d(true);
            mCheckoutDataHelper.a(guest, initiatedpaypal, mCheckoutModelHolder.J(), this);
            return;
        }
    }

    public void a(OrderCompletionDetails ordercompletiondetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mCheckoutDataHelper.a();
            mPresentation.a(ordercompletiondetails);
            return;
        }
    }

    public void a(OrderReview orderreview, AppliedTenders appliedtenders)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(orderreview, appliedtenders);
            mPresentation.v();
            return;
        }
    }

    public void a(OrderReview orderreview, boolean flag)
    {
        if (mPresentation != null)
        {
            if (orderreview == null)
            {
                g();
            }
            if (mCheckoutDataHelper == null)
            {
                com.target.ui.util.q.d(TAG, "CheckoutDataHelper object is null");
                return;
            }
            mPresentation.d(false);
            mCheckoutModelHolder.d(orderreview);
            a(orderreview);
            BigDecimal bigdecimal = (BigDecimal)orderreview.p().d();
            a((AppliedPaymentCardTender)orderreview.k().d(), orderreview.l(), (AppliedPayPalDetails)orderreview.m().d(), bigdecimal, com.target.ui.util.e.a(orderreview.l(), bigdecimal));
            if (flag)
            {
                mCheckoutCouponWalletFeature.b();
                return;
            }
        }
    }

    public void a(PromoCode promocode)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to remove a promo code, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        } else
        {
            mCheckoutDataHelper.a(guest, promocode, this);
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(0x7f090278);
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.c c1, com.target.mothership.services.o o1, String s1)
    {
        byte byte0;
        if (mPresentation == null)
        {
            return;
        }
        if (com.target.mothership.model.cart.interfaces.a.e.a.ERR_TIMEOUT.equals(c1.e()))
        {
            b(o1);
        }
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 60
    //                   -1332085432: 106
    //                   96667762: 122;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_122;
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            mPresentation.f(false);
            mPresentation.b(c1);
            return;

        case 1: // '\001'
            mPresentation.a(c1);
            break;
        }
        break MISSING_BLOCK_LABEL_148;
_L2:
        if (s1.equals("dialog"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s1.equals("entry"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    public void a(com.target.mothership.model.cart.interfaces.a.e e1, String s1, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mCheckoutDataHelper == null)
        {
            com.target.ui.util.q.d(TAG, "CheckoutDataHelper object is null");
            return;
        }
        if (com.target.mothership.model.cart.interfaces.a.e.a.ERR_TIMEOUT.equals(e1.e()))
        {
            a(o1);
            return;
        }
        boolean flag = com.target.ui.i.b.a.a(s1);
        o1 = mGuestProvider.a();
        if (flag)
        {
            mCheckoutDataHelper.d(o1, s1, this);
            return;
        } else
        {
            mPresentation.a(e1);
            return;
        }
    }

    public void a(g g1, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (com.target.mothership.model.cart.interfaces.a.e.a.ERR_TIMEOUT.equals(g1.e()))
        {
            a(o1);
            return;
        } else
        {
            mPresentation.a(g1);
            return;
        }
    }

    public void a(h h1, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            b(h1, o1);
            return;
        }
    }

    public void a(i i1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.x();
            return;
        }
    }

    public void a(i i1, AppliedGiftCardTender appliedgiftcardtender)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.x();
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.x();
            return;
        }
    }

    public void a(p p1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            com.target.ui.util.q.a(TAG, "Error fetching Order Review");
            mPresentation.d(false);
            mPresentation.x();
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.q q1, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.c(0x7f090400);
            return;
        }
    }

    public void a(r r1, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.c(0x7f090400);
            return;
        }
    }

    public void a(s s1, String s2)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.g(s2);
            mPresentation.x();
            return;
        }
    }

    public void a(t t)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.x();
            return;
        }
    }

    public void a(v v, PromoCode promocode)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.b(promocode);
            mPresentation.x();
            return;
        }
    }

    public void a(x x)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(0x7f090278);
            return;
        }
    }

    public void a(AppliedGiftCardTender appliedgiftcardtender)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to remove GiftCard, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        } else
        {
            mPresentation.f(true);
            mCheckoutDataHelper.a(guest, appliedgiftcardtender, this);
            return;
        }
    }

    public void a(Guest guest)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.r();
            mPresentation.d(true);
            mCheckoutDataHelper.d(guest, this);
            return;
        }
    }

    public void a(com.target.mothership.model.guest.interfaces.a.g g1)
    {
        mCheckoutModelHolder.g(null);
        mCheckoutModelHolder.k(false);
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.y();
            mPresentation.d(0x7f090083);
            return;
        }
    }

    public void a(com.target.mothership.services.x x)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.v();
            mPresentation.x();
            return;
        }
    }

    public void a(b b1)
    {
        mPresentation = b1;
        mPresentation.a(com.target.ui.j.a.a().a());
        m();
    }

    public void a(com.target.ui.fragment.checkout.d.c c1)
    {
        if (c1 == null)
        {
            com.target.ui.util.q.d(TAG, "CheckoutProgressType is null when retry is called after reauth");
            return;
        }
        switch (_cls3..SwitchMap.com.target.ui.fragment.checkout.view.CheckoutProgressType[c1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mPresentation.f(true);
            return;

        case 2: // '\002'
            mPresentation.g(true);
            return;

        case 3: // '\003'
            mPresentation.d(true);
            break;
        }
    }

    public void a(DeliveryDetailsModel deliverydetailsmodel)
    {
        deliverydetailsmodel = deliverydetailsmodel.c();
        mPresentation.b(deliverydetailsmodel);
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(String s1)
    {
        mPresentation.F();
    }

    public void a(String s1, com.target.mothership.common.tender.a a1, String s2)
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "tried to checkout with security code but guest object is null");
            mPresentation.G();
            return;
        }
        mPresentation.d(true);
        if (guest.isAnonymous())
        {
            mCheckoutDataHelper.a(guest, s1, a1, s2, this);
            return;
        } else
        {
            mCheckoutDataHelper.a(guest, a1, s2, this);
            return;
        }
    }

    public void a(List list)
    {
        mPresentation.e(list);
    }

    public void a(List list, boolean flag, WalletItem walletitem, OrderReview orderreview, AppliedTenders appliedtenders)
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "The current session was unexpectedly null on onViewCreated()");
            mPresentation.G();
            return;
        }
        if (flag)
        {
            walletitem = walletitem.a();
            if (walletitem.b())
            {
                a(guest, (String)walletitem.c());
            }
        }
        mCheckoutCouponWalletFeature.a(list);
        b(orderreview, appliedtenders);
    }

    public void a(boolean flag, String s1, OrderReview orderreview, DeliveryTypedProducts deliverytypedproducts, PickUpPersonDetailsModel pickuppersondetailsmodel, EmailRecipientDetailsModel emailrecipientdetailsmodel, SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        if (flag)
        {
            mPresentation.d(true);
            a(s1, orderreview, deliverytypedproducts, pickuppersondetailsmodel, emailrecipientdetailsmodel, smsrecipientdetailsmodel);
            return;
        } else
        {
            mPresentation.z();
            return;
        }
    }

    public boolean a(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131756545: 
            menuitem = mGuestProvider.a();
            break;
        }
        if (menuitem == null)
        {
            com.target.ui.util.q.a(TAG, "Guest unexpectedly null in onOptionsItemSelected");
            return false;
        } else
        {
            mPresentation.a(menuitem, null, com.target.ui.fragment.checkout.d.c.DEFAULT);
            return true;
        }
    }

    public void b(InitiatedPayPal initiatedpaypal)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(initiatedpaypal);
            return;
        }
    }

    public void b(com.target.mothership.model.cart.interfaces.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(0x7f090278);
            return;
        }
    }

    public void b(com.target.mothership.model.cart.interfaces.a.e e1, String s1, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mCheckoutModelHolder.b(null);
            mCheckoutModelHolder.l(false);
            mPresentation.d(false);
            mPresentation.a(0x7f090299, PromoCodeInputView.b((com.target.mothership.model.cart.interfaces.a.e.a)e1.e()));
            return;
        }
    }

    public void b(Guest guest)
    {
    }

    public void b(DeliveryDetailsModel deliverydetailsmodel)
    {
        deliverydetailsmodel = deliverydetailsmodel.d();
        mPresentation.b(deliverydetailsmodel);
    }

    public void b(String s1)
    {
        mPresentation.F();
    }

    public void b(List list)
    {
        mPresentation.f(list);
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.v();
            mPresentation.w();
            return;
        }
    }

    public void c(DeliveryDetailsModel deliverydetailsmodel)
    {
        deliverydetailsmodel = deliverydetailsmodel.e();
        mPresentation.b(deliverydetailsmodel);
    }

    public void c(String s1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.i(s1);
            return;
        }
    }

    public void c(List list)
    {
        mCheckoutCouponWalletFeature.b(list);
    }

    public void d()
    {
        mPresentation.A();
    }

    public void d(String s1)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to apply promo code, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        } else
        {
            mPresentation.g(true);
            mCheckoutDataHelper.c(guest, s1, this);
            return;
        }
    }

    public void d(List list)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            mPresentation.G();
        } else
        if (list != null && !list.isEmpty())
        {
            list = ((WalletItem)list.get(0)).a();
            if (list.b())
            {
                a(guest, (String)list.c());
                return;
            }
        }
    }

    public void e()
    {
    }

    public void e(String s1)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to remove team member discount, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        } else
        {
            mCheckoutDataHelper.e(guest, s1, this);
            return;
        }
    }

    public void e(List list)
    {
        mCheckoutModelHolder.g(list);
        com.target.ui.fragment.checkout.d.a a1 = mCheckoutModelHolder;
        boolean flag;
        if (!list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.k(flag);
        if (mPresentation == null)
        {
            return;
        }
        if (list.isEmpty())
        {
            mPresentation.y();
        }
        mPresentation.c(list);
    }

    public void f()
    {
    }

    public void f(String s1)
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to perform pending actions, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        }
        if (guest.isAnonymous())
        {
            mCheckoutDataHelper.a(guest, s1, this);
            return;
        } else
        {
            mCheckoutDataHelper.a(guest, this);
            return;
        }
    }

    public void g()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.x();
            mPresentation.G();
            return;
        }
    }

    public void h()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.F();
            return;
        }
    }

    public void i()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to edit payment, but the current session was unexpectedly null");
            mPresentation.G();
            return;
        } else
        {
            mPayPalFeature.a(guest, mCheckoutModelHolder.L(), mCheckoutModelHolder.K(), mPresentation);
            return;
        }
    }

    public void j()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to edit or add a card through the select payment dialog, but the current session is unexpectedly null");
            mPresentation.G();
            return;
        }
        if (guest.isAnonymous())
        {
            mPresentation.j(com.target.ui.util.e.a(guest, mCheckoutModelHolder.K()));
            return;
        } else
        {
            mPresentation.H();
            return;
        }
    }

    public void k()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "tried to initiate paypal as a payment option but the current session is null");
            mPresentation.G();
            return;
        } else
        {
            mPresentation.d(true);
            mCheckoutDataHelper.a(guest, mCheckoutModelHolder.J(), this);
            return;
        }
    }

    public void l()
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "tried fetch a fresh order review after paypal was canceled, but the current session is null");
            mPresentation.G();
            return;
        } else
        {
            mPresentation.d(true);
            mCheckoutDataHelper.e(guest, this);
            return;
        }
    }

    public void v_()
    {
        mCheckoutDataHelper = null;
        mPendingActionsHelper = null;
        mGuestProvider = null;
        mConnectivityProvider = null;
        mCheckoutModelHolder = null;
    }

    public void z_()
    {
        mCheckoutCouponWalletFeature.a();
        s();
        mPresentation = null;
    }

}
