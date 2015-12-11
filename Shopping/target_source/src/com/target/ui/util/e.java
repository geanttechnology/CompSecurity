// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.widget.ImageView;
import com.target.mothership.common.a.f;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.a;
import com.target.mothership.common.tender.b;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.DigitalDownloadDeliveryProfile;
import com.target.mothership.model.cart.interfaces.GiftCardDeliveryProfile;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.Shipment;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PaymentCardTender;
import com.target.mothership.model.common.PersonName;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.tender.PaymentCardExpiration;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.model.checkout.PaymentDetailsModel;
import com.target.ui.model.checkout.ShippingAddressDetailsModel;
import com.target.ui.model.checkout.TGTBillingCardDetailsModel;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.model.checkout.TGTDeliveryDetailsModel;
import com.target.ui.model.checkout.TGTDeliveryTypedProducts;
import com.target.ui.model.checkout.TGTEmailRecipientDetailsModel;
import com.target.ui.model.checkout.TGTPayPalDisplayDetails;
import com.target.ui.model.checkout.TGTPaymentCardDisplayDetails;
import com.target.ui.model.checkout.TGTPaymentCardInformationModel;
import com.target.ui.model.checkout.TGTPaymentDetailsModel;
import com.target.ui.model.checkout.TGTPickUpPersonDetailsModel;
import com.target.ui.model.checkout.TGTShippingAddressDetailsModel;
import com.target.ui.model.checkout.TGTSmsRecipientDetailsModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.util:
//            q

public final class e
{

    private static final int ADDRESS_LINE_1_INDEX = 0;
    private static final int ADDRESS_LINE_2_INDEX = 1;
    private static final String DEFAULT_COUNTRY = "US";
    private static final String ERROR_CODE_UNKNOWN = "ERR_CART_UNKNOWN";
    private static final int MAX_GC_APPLIED_COUNT = 4;
    private static final String TAG = com/target/ui/util/e.getSimpleName();

    public e()
    {
    }

    public static com.target.mothership.common.params.b a(BillingCardDetailsModel billingcarddetailsmodel)
    {
        return a(billingcarddetailsmodel, true);
    }

    public static com.target.mothership.common.params.b a(BillingCardDetailsModel billingcarddetailsmodel, boolean flag)
    {
        CardDataModel carddatamodel = billingcarddetailsmodel.a();
        billingcarddetailsmodel = billingcarddetailsmodel.b();
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$tender$CardType[];
            static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason = new int[com.target.mothership.model.cart.interfaces.a.c.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason[com.target.mothership.model.cart.interfaces.a.c.a.ERR_GIFT_CARD_DETAILS_INVALID.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason[com.target.mothership.model.cart.interfaces.a.c.a.ERR_GIFT_CARD_ALREADY_USED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                $SwitchMap$com$target$mothership$common$tender$CardType = new int[com.target.mothership.common.tender.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.AMEX.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.VISA.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_DEBIT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_MASTERCARD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_RED_CARD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_CARD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_VISA.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_BUSINESS.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.DISCOVER.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.MASTER_CARD.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_GIFT_CARD.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.PAYPAL.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[carddatamodel.a().ordinal()])
        {
        default:
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Cannot construct PaymentCardParams - the give card type (").append(carddatamodel.a().toString()).append(") is not recognized").toString());
            return null;

        case 2: // '\002'
            return com.target.mothership.common.params.b.a(carddatamodel.b(), billingcarddetailsmodel.f(), com.target.mothership.common.tender.b.a(carddatamodel.d()), Integer.parseInt(carddatamodel.e()), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 10: // '\n'
            return com.target.mothership.common.params.b.b(carddatamodel.b(), billingcarddetailsmodel.f(), com.target.mothership.common.tender.b.a(carddatamodel.d()), Integer.parseInt(carddatamodel.e()), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 1: // '\001'
            return com.target.mothership.common.params.b.c(carddatamodel.b(), billingcarddetailsmodel.f(), com.target.mothership.common.tender.b.a(carddatamodel.d()), Integer.parseInt(carddatamodel.e()), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 9: // '\t'
            return com.target.mothership.common.params.b.d(carddatamodel.b(), billingcarddetailsmodel.f(), com.target.mothership.common.tender.b.a(carddatamodel.d()), Integer.parseInt(carddatamodel.e()), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 3: // '\003'
            return com.target.mothership.common.params.b.d(carddatamodel.b(), billingcarddetailsmodel.f(), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 7: // '\007'
            return com.target.mothership.common.params.b.e(carddatamodel.b(), billingcarddetailsmodel.f(), com.target.mothership.common.tender.b.a(carddatamodel.d()), Integer.parseInt(carddatamodel.e()), true, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 4: // '\004'
            return com.target.mothership.common.params.b.f(carddatamodel.b(), billingcarddetailsmodel.f(), com.target.mothership.common.tender.b.a(carddatamodel.d()), Integer.parseInt(carddatamodel.e()), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 8: // '\b'
            return com.target.mothership.common.params.b.a(carddatamodel.b(), billingcarddetailsmodel.f(), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 6: // '\006'
            return com.target.mothership.common.params.b.c(carddatamodel.b(), billingcarddetailsmodel.f(), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());

        case 5: // '\005'
            return com.target.mothership.common.params.b.b(carddatamodel.b(), billingcarddetailsmodel.f(), flag, billingcarddetailsmodel, true, billingcarddetailsmodel.f());
        }
    }

    public static BillingCardDetailsModel a(PaymentCardTender paymentcardtender)
    {
        if (paymentcardtender == null)
        {
            return null;
        }
        TGTBillingCardDetailsModel tgtbillingcarddetailsmodel = new TGTBillingCardDetailsModel();
        Object obj = new TGTCardDataModel();
        ((TGTCardDataModel) (obj)).a(paymentcardtender.d());
        ((TGTCardDataModel) (obj)).a(null);
        ((TGTCardDataModel) (obj)).e(null);
        ((TGTCardDataModel) (obj)).b(paymentcardtender.e());
        if (paymentcardtender.f().b())
        {
            PaymentCardExpiration paymentcardexpiration = (PaymentCardExpiration)paymentcardtender.f().c();
            ((TGTCardDataModel) (obj)).c(String.valueOf(paymentcardexpiration.b()));
            ((TGTCardDataModel) (obj)).d(String.valueOf(paymentcardexpiration.a()));
        }
        tgtbillingcarddetailsmodel.a(((CardDataModel) (obj)));
        GuestAddress guestaddress = paymentcardtender.c();
        Object obj1 = (PersonName)guestaddress.c().d();
        paymentcardtender = "";
        obj = "";
        String s = "";
        if (obj1 != null)
        {
            paymentcardtender = ((PersonName) (obj1)).a();
            obj = ((PersonName) (obj1)).b();
            s = ((PersonName) (obj1)).c();
        }
        com.target.mothership.model.common.a a1 = guestaddress.b();
        List list = guestaddress.getAddressLines();
        String s1 = guestaddress.getCity();
        String s2 = guestaddress.getStateOrProvince();
        String s3 = guestaddress.getPostalCode();
        String s4;
        com.target.mothership.model.common.c c1;
        boolean flag;
        if (guestaddress.getCountry() != null)
        {
            obj1 = guestaddress.getCountry();
        } else
        {
            obj1 = "US";
        }
        s4 = com.target.ui.util.d.b.g(guestaddress.d().a());
        c1 = guestaddress.d().b();
        if (guestaddress.e() == null)
        {
            flag = false;
        } else
        {
            flag = guestaddress.e().booleanValue();
        }
        tgtbillingcarddetailsmodel.a(new AddressParams(a1, list, s1, s2, s3, ((String) (obj1)), paymentcardtender, ((String) (obj)), s, s4, c1, flag));
        return tgtbillingcarddetailsmodel;
    }

    public static DeliveryDetailsModel a(Guest guest, OrderReview orderreview, DeliveryDetailsModel deliverydetailsmodel)
    {
        if (deliverydetailsmodel != null)
        {
            guest = a(orderreview);
            if (guest == null)
            {
                return null;
            }
            TGTShippingAddressDetailsModel tgtshippingaddressdetailsmodel = new TGTShippingAddressDetailsModel();
            if (guest.a().isEmpty())
            {
                deliverydetailsmodel.a(tgtshippingaddressdetailsmodel);
            } else
            {
                deliverydetailsmodel.a(a(orderreview, tgtshippingaddressdetailsmodel));
            }
            deliverydetailsmodel.a(guest);
            return deliverydetailsmodel;
        }
        if (orderreview == null || orderreview.n().isEmpty())
        {
            return null;
        }
        DeliveryTypedProducts deliverytypedproducts = a(orderreview);
        if (deliverytypedproducts == null)
        {
            return null;
        }
        Object obj = new TGTShippingAddressDetailsModel();
        Object obj1 = new TGTPickUpPersonDetailsModel();
        TGTEmailRecipientDetailsModel tgtemailrecipientdetailsmodel = new TGTEmailRecipientDetailsModel();
        TGTSmsRecipientDetailsModel tgtsmsrecipientdetailsmodel = new TGTSmsRecipientDetailsModel();
        deliverydetailsmodel = ((DeliveryDetailsModel) (obj));
        if (!deliverytypedproducts.a().isEmpty())
        {
            deliverydetailsmodel = a(orderreview, ((TGTShippingAddressDetailsModel) (obj)));
        }
        obj = obj1;
        if (!deliverytypedproducts.b().isEmpty())
        {
            obj = a(guest, ((TGTPickUpPersonDetailsModel) (obj1)));
        }
        obj1 = tgtemailrecipientdetailsmodel;
        if (!deliverytypedproducts.c().isEmpty())
        {
            obj1 = a(guest, orderreview, tgtemailrecipientdetailsmodel);
        }
        if (!deliverytypedproducts.d().isEmpty())
        {
            tgtsmsrecipientdetailsmodel.a(true);
        }
        guest = new TGTDeliveryDetailsModel();
        guest.a(deliverytypedproducts);
        guest.a(deliverydetailsmodel);
        guest.a(((com.target.ui.model.checkout.PickUpPersonDetailsModel) (obj)));
        guest.a(((com.target.ui.model.checkout.EmailRecipientDetailsModel) (obj1)));
        guest.a(tgtsmsrecipientdetailsmodel);
        return guest;
    }

    public static DeliveryTypedProducts a(OrderReview orderreview)
    {
        if (orderreview == null || orderreview.n().isEmpty())
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        for (orderreview = orderreview.n().iterator(); orderreview.hasNext();)
        {
            Object obj = (Shipment)orderreview.next();
            if (((Shipment) (obj)).a() != null)
            {
                obj = ((Shipment) (obj)).a().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    CartProduct cartproduct = (CartProduct)((Iterator) (obj)).next();
                    com.target.mothership.common.a.b b1 = cartproduct.c();
                    f f1 = b1.a();
                    if (f1 == f.ShipToHome || f1 == f.Special)
                    {
                        arraylist.add(cartproduct);
                    } else
                    if (f1 == f.StorePickup || f1 == f.ShipToStore)
                    {
                        arraylist1.add(cartproduct);
                    } else
                    if (f1 == f.Electronic)
                    {
                        if (b1 == com.target.mothership.common.a.b.Email)
                        {
                            arraylist2.add(cartproduct);
                        } else
                        if (b1 == com.target.mothership.common.a.b.Mobile)
                        {
                            arraylist3.add(cartproduct);
                        }
                    }
                }
            }
        }

        orderreview = new TGTDeliveryTypedProducts();
        orderreview.a(arraylist);
        orderreview.b(arraylist1);
        orderreview.c(arraylist2);
        orderreview.d(arraylist3);
        return orderreview;
    }

    public static PaymentCardInformationModel a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        if (appliedpaymentcardtender == null)
        {
            return null;
        } else
        {
            TGTPaymentCardInformationModel tgtpaymentcardinformationmodel = new TGTPaymentCardInformationModel();
            tgtpaymentcardinformationmodel.a(a(((PaymentCardTender) (appliedpaymentcardtender))));
            tgtpaymentcardinformationmodel.a(true);
            tgtpaymentcardinformationmodel.b(appliedpaymentcardtender.g());
            tgtpaymentcardinformationmodel.a(appliedpaymentcardtender);
            return tgtpaymentcardinformationmodel;
        }
    }

    public static PaymentDetailsModel a(AppliedPaymentCardTender appliedpaymentcardtender, AppliedPayPalDetails appliedpaypaldetails)
    {
        TGTPaymentDetailsModel tgtpaymentdetailsmodel = new TGTPaymentDetailsModel();
        if (appliedpaymentcardtender == null && appliedpaypaldetails == null)
        {
            tgtpaymentdetailsmodel.a(false);
            return tgtpaymentdetailsmodel;
        }
        if (appliedpaymentcardtender != null)
        {
            appliedpaypaldetails = new TGTPaymentCardDisplayDetails();
            appliedpaypaldetails.a(appliedpaymentcardtender.d());
            appliedpaypaldetails.a(appliedpaymentcardtender.e());
            appliedpaymentcardtender = appliedpaymentcardtender.c();
            if (appliedpaymentcardtender != null && appliedpaymentcardtender.getAddressLines() != null && !appliedpaymentcardtender.getAddressLines().isEmpty())
            {
                appliedpaymentcardtender = appliedpaymentcardtender.getAddressLines();
                appliedpaypaldetails.b((String)appliedpaymentcardtender.get(0));
                if (appliedpaymentcardtender.size() > 1 && o.g((String)appliedpaymentcardtender.get(1)))
                {
                    appliedpaypaldetails.c((String)appliedpaymentcardtender.get(1));
                }
            }
            tgtpaymentdetailsmodel.a(appliedpaypaldetails);
            tgtpaymentdetailsmodel.a(true);
            return tgtpaymentdetailsmodel;
        } else
        {
            appliedpaymentcardtender = new TGTPayPalDisplayDetails();
            appliedpaymentcardtender.a(appliedpaypaldetails.a());
            tgtpaymentdetailsmodel.a(appliedpaymentcardtender);
            tgtpaymentdetailsmodel.a(true);
            return tgtpaymentdetailsmodel;
        }
    }

    private static TGTEmailRecipientDetailsModel a(Guest guest, OrderReview orderreview, TGTEmailRecipientDetailsModel tgtemailrecipientdetailsmodel)
    {
        tgtemailrecipientdetailsmodel.a(true);
        guest = a(guest, orderreview);
        if (o.g(guest))
        {
            tgtemailrecipientdetailsmodel.b(guest);
        }
        return tgtemailrecipientdetailsmodel;
    }

    private static TGTPickUpPersonDetailsModel a(Guest guest, TGTPickUpPersonDetailsModel tgtpickuppersondetailsmodel)
    {
        tgtpickuppersondetailsmodel.a(true);
        if (!guest.isAnonymous() && guest.getAccountDetails().b())
        {
            guest = (AccountDetails)guest.getAccountDetails().c();
            tgtpickuppersondetailsmodel.a(guest.getFirstName());
            tgtpickuppersondetailsmodel.b(guest.getLastName());
            tgtpickuppersondetailsmodel.c(guest.getEmailAddress());
            tgtpickuppersondetailsmodel.b(true);
            return tgtpickuppersondetailsmodel;
        } else
        {
            tgtpickuppersondetailsmodel.b(false);
            return tgtpickuppersondetailsmodel;
        }
    }

    private static TGTShippingAddressDetailsModel a(OrderReview orderreview, TGTShippingAddressDetailsModel tgtshippingaddressdetailsmodel)
    {
        for (Iterator iterator = orderreview.n().iterator(); iterator.hasNext();)
        {
            Shipment shipment = (Shipment)iterator.next();
            orderreview = shipment.b();
            if (orderreview != null)
            {
                orderreview = orderreview.a();
            } else
            {
                orderreview = null;
            }
            if ((orderreview == f.ShipToHome || orderreview == f.Special) && shipment.c().b())
            {
                return b((GuestAddress)shipment.c().c());
            }
        }

        tgtshippingaddressdetailsmodel.a(false);
        tgtshippingaddressdetailsmodel.c(true);
        return tgtshippingaddressdetailsmodel;
    }

    public static TGTShippingAddressDetailsModel a(GuestAddress guestaddress)
    {
        return b(guestaddress);
    }

    public static String a(Context context, com.target.mothership.model.cart.interfaces.a.c.a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        switch (_cls1..SwitchMap.com.target.mothership.model.cart.interfaces.error.ApplyGiftCardFailure.ApplyGiftCardFailureReason[a1.ordinal()])
        {
        default:
            return context.getString(0x7f09020b);

        case 1: // '\001'
            return context.getString(0x7f09020b);

        case 2: // '\002'
            return context.getString(0x7f09020a);
        }
    }

    public static String a(Guest guest, OrderReview orderreview)
    {
        if (o.g(orderreview.o()))
        {
            return orderreview.o();
        }
        if (guest != null && !guest.isAnonymous() && guest.getAccountDetails().b())
        {
            return ((AccountDetails)guest.getAccountDetails().c()).getEmailAddress();
        } else
        {
            return null;
        }
    }

    public static List a(DeliveryDetailsModel deliverydetailsmodel)
    {
        if (deliverydetailsmodel == null || deliverydetailsmodel.a() == null)
        {
            return Collections.emptyList();
        } else
        {
            deliverydetailsmodel = deliverydetailsmodel.a();
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(deliverydetailsmodel.a());
            arraylist.addAll(deliverydetailsmodel.b());
            arraylist.addAll(deliverydetailsmodel.c());
            arraylist.addAll(deliverydetailsmodel.d());
            return arraylist;
        }
    }

    public static List a(List list)
    {
        if (list.isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(b((PaymentCardTender)list.next()))) { }
        return arraylist;
    }

    public static void a(a a1, ImageView imageview)
    {
        if (imageview == null)
        {
            return;
        }
        if (a1 == null)
        {
            imageview.setImageResource(0x7f0201d2);
            return;
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[a1.ordinal()])
        {
        default:
            imageview.setImageResource(0x7f0201d2);
            return;

        case 1: // '\001'
            imageview.setImageResource(0x7f0201d1);
            return;

        case 2: // '\002'
            imageview.setImageResource(0x7f0201d8);
            return;

        case 3: // '\003'
            imageview.setImageResource(0x7f0201d7);
            return;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            imageview.setImageResource(0x7f0201d6);
            return;

        case 9: // '\t'
            imageview.setImageResource(0x7f0201d3);
            return;

        case 10: // '\n'
            imageview.setImageResource(0x7f0201d4);
            return;

        case 11: // '\013'
            imageview.setImageResource(0x7f02012b);
            return;

        case 12: // '\f'
            imageview.setImageResource(0x7f0201d5);
            break;
        }
    }

    public static boolean a(int i)
    {
        return i >= 4;
    }

    public static boolean a(a a1)
    {
        if (a1 == null)
        {
            return false;
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[a1.ordinal()])
        {
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 8: // '\b'
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 7: // '\007'
        case 9: // '\t'
        case 10: // '\n'
            return true;
        }
    }

    public static boolean a(j j)
    {
        return "ERR_CART_UNKNOWN".equals(j.toString());
    }

    public static boolean a(Guest guest, DeliveryDetailsModel deliverydetailsmodel)
    {
        while (guest == null || deliverydetailsmodel == null || !guest.isAnonymous() || !deliverydetailsmodel.b().c()) 
        {
            return false;
        }
        return true;
    }

    public static boolean a(List list, BigDecimal bigdecimal)
    {
        while (list.isEmpty() || bigdecimal == null || bigdecimal.compareTo(BigDecimal.ZERO) != 0) 
        {
            return false;
        }
        return true;
    }

    public static PaymentCardInformationModel b(PaymentCardTender paymentcardtender)
    {
        TGTPaymentCardInformationModel tgtpaymentcardinformationmodel = new TGTPaymentCardInformationModel();
        tgtpaymentcardinformationmodel.a(a(paymentcardtender));
        tgtpaymentcardinformationmodel.a(false);
        tgtpaymentcardinformationmodel.a(paymentcardtender);
        tgtpaymentcardinformationmodel.b(paymentcardtender.g());
        return tgtpaymentcardinformationmodel;
    }

    private static TGTShippingAddressDetailsModel b(GuestAddress guestaddress)
    {
        TGTShippingAddressDetailsModel tgtshippingaddressdetailsmodel = new TGTShippingAddressDetailsModel();
        if (guestaddress == null || o.e(guestaddress.a()))
        {
            tgtshippingaddressdetailsmodel.a(false);
            tgtshippingaddressdetailsmodel.c(true);
            return tgtshippingaddressdetailsmodel;
        }
        tgtshippingaddressdetailsmodel.a(true);
        List list = guestaddress.getAddressLines();
        if (list == null || list.isEmpty())
        {
            tgtshippingaddressdetailsmodel.b(true);
            tgtshippingaddressdetailsmodel.c(false);
            if (guestaddress.c().b())
            {
                guestaddress = ((PersonName)guestaddress.c().c()).a();
            } else
            {
                guestaddress = "";
            }
            tgtshippingaddressdetailsmodel.c(guestaddress);
            return tgtshippingaddressdetailsmodel;
        }
        tgtshippingaddressdetailsmodel.c(false);
        tgtshippingaddressdetailsmodel.a((String)list.get(0));
        if (list.size() > 1 && o.g((String)list.get(1)))
        {
            tgtshippingaddressdetailsmodel.b((String)list.get(1));
        }
        return tgtshippingaddressdetailsmodel;
    }

    private static String b(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        if (appliedpaymentcardtender == null)
        {
            appliedpaymentcardtender = null;
        } else
        {
            appliedpaymentcardtender = appliedpaymentcardtender.c();
            if (appliedpaymentcardtender == null && appliedpaymentcardtender.c() == null)
            {
                return null;
            }
            if (!appliedpaymentcardtender.c().b())
            {
                return null;
            }
            String s = ((PersonName)appliedpaymentcardtender.c().c()).a();
            appliedpaymentcardtender = s;
            if (!o.g(s))
            {
                return null;
            }
        }
        return appliedpaymentcardtender;
    }

    public static String b(Guest guest, OrderReview orderreview)
    {
        if (guest.isAnonymous() || !guest.getAccountDetails().b()) goto _L2; else goto _L1
_L1:
        guest = (AccountDetails)guest.getAccountDetails().c();
        if (!o.g(guest.getFirstName())) goto _L2; else goto _L3
_L3:
        guest = guest.getFirstName();
_L5:
        return guest;
_L2:
        String s;
        if (!orderreview.k().b())
        {
            break; /* Loop/switch isn't completed */
        }
        s = b((AppliedPaymentCardTender)orderreview.k().d());
        guest = s;
        if (o.g(s)) goto _L5; else goto _L4
_L4:
        if (orderreview.n().isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        orderreview = c(orderreview.n());
        guest = orderreview;
        if (o.g(orderreview)) goto _L5; else goto _L6
_L6:
        return "Target Guest";
    }

    public static boolean b(a a1)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[a1.ordinal()])
        {
        case 3: // '\003'
        case 5: // '\005'
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean b(List list)
    {
        if (list == null || list.isEmpty())
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            if (((CartProduct)list.next()).c().a() == f.Special)
            {
                return true;
            }
        }

        return false;
    }

    private static String c(List list)
    {
        list = list.iterator();
label0:
        do
        {
            Object obj;
            do
            {
                f f1;
                do
                {
                    if (!list.hasNext())
                    {
                        break label0;
                    }
                    obj = (Shipment)list.next();
                    f1 = ((Shipment) (obj)).b().a();
                    if (f1 != f.StorePickup)
                    {
                        if (f1 != f.ShipToHome && f1 != f.Special)
                        {
                            continue;
                        }
                        if (((Shipment) (obj)).c().b())
                        {
                            obj = (GuestAddress)((Shipment) (obj)).c().c();
                            if (((GuestAddress) (obj)).c().b())
                            {
                                obj = (PersonName)((GuestAddress) (obj)).c().c();
                                if (o.g(((PersonName) (obj)).a()))
                                {
                                    return ((PersonName) (obj)).a();
                                }
                            }
                        }
                    }
                    continue label0;
                } while (f1 != f.Electronic);
                if (!((Shipment) (obj)).d().b())
                {
                    continue;
                }
                obj = (GiftCardDeliveryProfile)((Shipment) (obj)).d().c();
                if (o.g(((GiftCardDeliveryProfile) (obj)).a()))
                {
                    return ((GiftCardDeliveryProfile) (obj)).a();
                }
                continue label0;
            } while (!((Shipment) (obj)).e().b());
            obj = (DigitalDownloadDeliveryProfile)((Shipment) (obj)).e().c();
            if (o.g(((DigitalDownloadDeliveryProfile) (obj)).a()))
            {
                return ((DigitalDownloadDeliveryProfile) (obj)).a();
            }
        } while (true);
        return null;
    }

}
