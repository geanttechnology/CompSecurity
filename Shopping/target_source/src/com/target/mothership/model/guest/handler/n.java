// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.text.Html;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.TGTOrderLevelPromotion;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.model.common.TGTPickUpPersonDetails;
import com.target.mothership.model.common.TGTPickUpStoreAddress;
import com.target.mothership.model.common.TGTStorePickUpDetails;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.b;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.AppliedPaymentCard;
import com.target.mothership.model.guest.interfaces.EmailDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.MobileDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.model.guest.interfaces.ShipHomeShipmentDetails;
import com.target.mothership.model.guest.interfaces.StorePickUpShipmentDetails;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.g;
import com.target.mothership.services.apigee.c.b.t;
import com.target.mothership.services.apigee.j.b.c;
import com.target.mothership.services.apigee.j.b.d;
import com.target.mothership.services.apigee.j.b.e;
import com.target.mothership.util.l;
import com.target.mothership.util.o;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTGuestAddress, TGTPersonName, TGTPhoneNumber, TGTOrderDetails, 
//            TGTOrderDetailsProduct, TGTOrderItemStatus, TGTAppliedPaymentCard, TGTShipHomeShipmentDetails, 
//            TGTAppliedPayPalDetails, TGTStorePickUpShipmentDetails, TGTEmailDeliveryShipmentDetails, TGTAppliedGiftCard, 
//            TGTMobileDeliveryShipmentDetails

class n
    implements aa
{
    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a CANCELED;
        public static final a EMAIL_GIFTCARD;
        public static final a MOBILE_GIFTCARD;
        public static final a PICK_UP;
        public static final a SHIP_HOME;
        public static final a UNKNOWN;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/guest/handler/n$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            SHIP_HOME = new a("SHIP_HOME", 0);
            PICK_UP = new a("PICK_UP", 1);
            EMAIL_GIFTCARD = new a("EMAIL_GIFTCARD", 2);
            MOBILE_GIFTCARD = new a("MOBILE_GIFTCARD", 3);
            CANCELED = new a("CANCELED", 4);
            UNKNOWN = new a("UNKNOWN", 5);
            $VALUES = (new a[] {
                SHIP_HOME, PICK_UP, EMAIL_GIFTCARD, MOBILE_GIFTCARD, CANCELED, UNKNOWN
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String HYPHEN = "-";
    private static final String TRUE = "true";
    private static final String YES = "Y";
    private static final int ZERO_QUANTITY = 0;

    n()
    {
    }

    private GuestAddress a(c c1)
    {
        TGTGuestAddress tgtguestaddress = new TGTGuestAddress();
        tgtguestaddress.a(com.target.mothership.model.common.a.Billing);
        com.target.mothership.services.apigee.j.b.c.a a1 = c1.a();
        tgtguestaddress.e(a1.d());
        if (a1.e() != null)
        {
            c1 = a1.e();
        } else
        {
            c1 = Collections.emptyList();
        }
        tgtguestaddress.a(c1);
        tgtguestaddress.a(a1.f());
        tgtguestaddress.b(a1.g());
        tgtguestaddress.d(a1.h());
        tgtguestaddress.c(a1.i());
        c1 = new TGTPersonName();
        c1.a(a1.a());
        c1.c(a1.b());
        c1.b(a1.c());
        tgtguestaddress.a(c1);
        c1 = new TGTPhoneNumber();
        c1.a(l.a(new String[] {
            a1.j(), a1.k(), a1.l(), a1.m()
        }));
        c1.a(com.target.mothership.model.common.c.Other);
        tgtguestaddress.a(c1);
        return tgtguestaddress;
    }

    private TGTOrderDetails a(TGTOrderDetails tgtorderdetails, List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        return tgtorderdetails;
_L2:
        tgtorderdetails.a(Collections.emptyList());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                continue;
            }
            e e1 = (e)list.next();
            a a1 = a(e1);
            static class _cls1
            {

                static final int $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[];

                static 
                {
                    $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType = new int[a.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[a.SHIP_HOME.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[a.PICK_UP.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[a.EMAIL_GIFTCARD.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[a.MOBILE_GIFTCARD.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[a.CANCELED.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$model$guest$handler$OrderDetailsTransformer$ShipmentType[a.UNKNOWN.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.target.mothership.model.guest.handler.OrderDetailsTransformer.ShipmentType[a1.ordinal()])
            {
            case 1: // '\001'
                tgtorderdetails.a(b(e1));
                break;

            case 2: // '\002'
                tgtorderdetails.a(c(e1));
                break;

            case 3: // '\003'
                tgtorderdetails.a(d(e1));
                break;

            case 4: // '\004'
                tgtorderdetails.a(e(e1));
                break;

            case 5: // '\005'
                tgtorderdetails.a(a(e1.i()));
                break;
            }
        } while (true);
          goto _L3
        if (true) goto _L1; else goto _L3
_L3:
    }

    private a a(e e1)
    {
        if (e1 == null || e1.i() == null || e1.i().isEmpty())
        {
            return a.UNKNOWN;
        }
        com.target.mothership.services.apigee.j.b.e.a a1 = e1.j();
        if (a1 != null && o.g(a1.d()))
        {
            if (o.g(e1.a()))
            {
                return a.PICK_UP;
            } else
            {
                return a.SHIP_HOME;
            }
        }
        if (o.g(e1.g()))
        {
            return a.EMAIL_GIFTCARD;
        }
        if (o.g(e1.h()))
        {
            return a.MOBILE_GIFTCARD;
        } else
        {
            return a.CANCELED;
        }
    }

    private Date a(String s)
    {
        if (!o.g(s))
        {
            return null;
        } else
        {
            return (new SimpleDateFormat("MM/dd/yyyy", Locale.US)).parse(s, new ParsePosition(0));
        }
    }

    private List a(List list)
    {
        ArrayList arraylist;
        b b1;
        Iterator iterator2;
        if (list == null)
        {
            return Collections.emptyList();
        }
        arraylist = new ArrayList();
        b1 = new b();
        iterator2 = list.iterator();
_L7:
        if (!iterator2.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj4;
        Object obj5;
        TGTOrderDetailsProduct tgtorderdetailsproduct;
        String s;
        String s1;
        Object obj6 = (com.target.mothership.services.apigee.j.b.b)iterator2.next();
        tgtorderdetailsproduct = new TGTOrderDetailsProduct();
        tgtorderdetailsproduct.b(((com.target.mothership.services.apigee.j.b.b) (obj6)).l());
        tgtorderdetailsproduct.l(Html.fromHtml(((com.target.mothership.services.apigee.j.b.b) (obj6)).k()).toString());
        tgtorderdetailsproduct.a(((com.target.mothership.services.apigee.j.b.b) (obj6)).h());
        tgtorderdetailsproduct.a(((com.target.mothership.services.apigee.j.b.b) (obj6)).o());
        tgtorderdetailsproduct.a(((com.target.mothership.services.apigee.j.b.b) (obj6)).g());
        int i;
        if (o.g(((com.target.mothership.services.apigee.j.b.b) (obj6)).p()))
        {
            i = Double.valueOf(((com.target.mothership.services.apigee.j.b.b) (obj6)).p()).intValue();
        } else
        {
            i = 0;
        }
        tgtorderdetailsproduct.b(i);
        tgtorderdetailsproduct.a(((com.target.mothership.services.apigee.j.b.b) (obj6)).R());
        tgtorderdetailsproduct.a(b(((com.target.mothership.services.apigee.j.b.b) (obj6)).Q()));
        list = new ArrayList();
        if (((com.target.mothership.services.apigee.j.b.b) (obj6)).S() != null)
        {
            TGTOrderItemStatus tgtorderitemstatus;
            for (Iterator iterator = ((com.target.mothership.services.apigee.j.b.b) (obj6)).S().iterator(); iterator.hasNext(); list.add(tgtorderitemstatus))
            {
                com.target.mothership.services.apigee.j.b.b.a a1 = (com.target.mothership.services.apigee.j.b.b.a)iterator.next();
                tgtorderitemstatus = new TGTOrderItemStatus();
                tgtorderitemstatus.a(a(a1.a()));
                tgtorderitemstatus.a(a1.b());
            }

        }
        tgtorderdetailsproduct.a(list);
        list = new ArrayList();
        if (((com.target.mothership.services.apigee.j.b.b) (obj6)).s() != null)
        {
            TGTOrderProductImage tgtorderproductimage;
            for (Iterator iterator1 = ((com.target.mothership.services.apigee.j.b.b) (obj6)).s().iterator(); iterator1.hasNext(); list.add(tgtorderproductimage))
            {
                t t1 = (t)iterator1.next();
                tgtorderproductimage = new TGTOrderProductImage();
                tgtorderproductimage.a(t1.a());
                tgtorderproductimage.b(t1.b());
            }

        }
        tgtorderdetailsproduct.b(list);
        list = b1.a(((com.target.mothership.services.apigee.j.b.b) (obj6)).a());
        tgtorderdetailsproduct.a(list);
        tgtorderdetailsproduct.a(list.a());
        list = null;
        obj1 = null;
        obj2 = ((com.target.mothership.services.apigee.j.b.b) (obj6)).i();
        obj = obj1;
        if (o.g(((String) (obj2))))
        {
            if (((String) (obj2)).contains("-"))
            {
                int j = ((String) (obj2)).indexOf("-");
                obj = a(((String) (obj2)).substring(0, j));
                list = a(((String) (obj2)).substring(j + 1, ((String) (obj2)).length()));
            } else
            {
                list = a(((String) (obj2)).substring(0, ((String) (obj2)).length()));
                obj = obj1;
            }
        }
        tgtorderdetailsproduct.a(list);
        tgtorderdetailsproduct.b(((Date) (obj)));
        s = ((com.target.mothership.services.apigee.j.b.b) (obj6)).m();
        s1 = ((com.target.mothership.services.apigee.j.b.b) (obj6)).n();
        obj5 = null;
        obj = null;
        obj4 = null;
        obj1 = null;
        obj2 = null;
        list = null;
        if (((com.target.mothership.services.apigee.j.b.b) (obj6)).P() == null) goto _L4; else goto _L3
_L3:
        obj6 = ((com.target.mothership.services.apigee.j.b.b) (obj6)).P().iterator();
_L6:
        obj2 = list;
        obj4 = obj1;
        obj5 = obj;
        if (!((Iterator) (obj6)).hasNext()) goto _L4; else goto _L5
_L5:
        obj2 = (com.target.mothership.services.apigee.d.b.a)((Iterator) (obj6)).next();
        obj4 = com.target.mothership.common.a.a(((com.target.mothership.services.apigee.d.b.a) (obj2)).a());
        if (obj4 == com.target.mothership.common.a.PRICE_FOR_EACH)
        {
            obj2 = ((com.target.mothership.services.apigee.d.b.a) (obj2)).b();
            obj = obj1;
            obj1 = obj2;
        } else
        if (obj4 == com.target.mothership.common.a.ORIGINAL_PRICE)
        {
            obj2 = ((com.target.mothership.services.apigee.d.b.a) (obj2)).b();
            obj1 = obj;
            obj = obj2;
        } else
        if (obj4 == com.target.mothership.common.a.SALE_PRICE)
        {
            list = ((com.target.mothership.services.apigee.d.b.a) (obj2)).b();
            obj2 = obj;
            obj = obj1;
            obj1 = obj2;
        } else
        {
            Object obj3 = obj;
            obj = obj1;
            obj1 = obj3;
        }
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L6; else goto _L4
_L4:
        tgtorderdetailsproduct.a(l.a(l.a(new String[] {
            s, obj2, obj5, obj4, s1, null
        })));
        tgtorderdetailsproduct.b(l.a(l.a(new String[] {
            s1, obj5, s, obj2, obj4
        })));
        tgtorderdetailsproduct.c(l.a(l.a(new String[] {
            null, obj4, s1, obj5, s, obj2
        })));
        arraylist.add(tgtorderdetailsproduct);
          goto _L7
_L2:
        return arraylist;
    }

    private AppliedPaymentCard b(List list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            list = (c)iterator.next();
            com.target.mothership.services.apigee.j.b.c.b b1 = list.b();
            if (b1 != null && com.target.mothership.common.tender.a.a(b1.b()) != com.target.mothership.common.tender.a.TARGET_GIFT_CARD && com.target.mothership.common.tender.a.a(b1.b()) != com.target.mothership.common.tender.a.PAYPAL)
            {
                TGTAppliedPaymentCard tgtappliedpaymentcard = new TGTAppliedPaymentCard();
                tgtappliedpaymentcard.a(com.target.mothership.common.tender.a.a(b1.b()));
                tgtappliedpaymentcard.a(l.a(b1.c()));
                tgtappliedpaymentcard.a(l.c(b1.a()));
                tgtappliedpaymentcard.a(a(list));
                return tgtappliedpaymentcard;
            }
        }

        return null;
    }

    private ShipHomeShipmentDetails b(e e1)
    {
        TGTShipHomeShipmentDetails tgtshiphomeshipmentdetails = new TGTShipHomeShipmentDetails();
        tgtshiphomeshipmentdetails.a(a(e1.i()));
        TGTGuestAddress tgtguestaddress = new TGTGuestAddress();
        tgtguestaddress.a(com.target.mothership.model.common.a.Shipping);
        com.target.mothership.services.apigee.j.b.e.a a1 = e1.j();
        tgtguestaddress.e(a1.d());
        if (a1.e() != null)
        {
            e1 = a1.e();
        } else
        {
            e1 = Collections.emptyList();
        }
        tgtguestaddress.a(e1);
        tgtguestaddress.a(a1.f());
        tgtguestaddress.b(a1.g());
        tgtguestaddress.c(a1.h());
        e1 = new TGTPersonName();
        e1.a(a1.a());
        e1.c(a1.b());
        e1.b(a1.c());
        tgtguestaddress.a(e1);
        e1 = new TGTPhoneNumber();
        e1.a(a1.i());
        e1.a(com.target.mothership.model.common.c.Other);
        tgtguestaddress.a(e1);
        tgtshiphomeshipmentdetails.a(tgtguestaddress);
        return tgtshiphomeshipmentdetails;
    }

    private boolean b(String s)
    {
        return o.g(s) && "true".equalsIgnoreCase(s);
    }

    private AppliedPayPalDetails c(List list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            list = (c)iterator.next();
            com.target.mothership.services.apigee.j.b.c.b b1 = list.b();
            if (b1 != null && com.target.mothership.common.tender.a.a(b1.b()) == com.target.mothership.common.tender.a.PAYPAL)
            {
                TGTAppliedPayPalDetails tgtappliedpaypaldetails = new TGTAppliedPayPalDetails();
                tgtappliedpaypaldetails.a(l.a(b1.c()));
                tgtappliedpaypaldetails.a(a(list));
                return tgtappliedpaypaldetails;
            }
        }

        return null;
    }

    private StorePickUpShipmentDetails c(e e1)
    {
        TGTStorePickUpShipmentDetails tgtstorepickupshipmentdetails = new TGTStorePickUpShipmentDetails();
        tgtstorepickupshipmentdetails.a(a(e1.i()));
        tgtstorepickupshipmentdetails.b(b(e1.d()));
        Object obj = e1.e();
        Object obj1;
        TGTPhoneNumber tgtphonenumber;
        boolean flag;
        if (o.g(((String) (obj))) && "Y".equalsIgnoreCase(((String) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tgtstorepickupshipmentdetails.a(flag);
        obj = new TGTStorePickUpDetails();
        obj1 = new TGTPickUpPersonDetails();
        ((TGTPickUpPersonDetails) (obj1)).a(e1.a());
        ((TGTPickUpPersonDetails) (obj1)).b(e1.b());
        tgtphonenumber = new TGTPhoneNumber();
        tgtphonenumber.a(e1.c());
        tgtphonenumber.a(com.target.mothership.model.common.c.Other);
        ((TGTPickUpPersonDetails) (obj1)).a(tgtphonenumber);
        ((TGTStorePickUpDetails) (obj)).a(((com.target.mothership.model.common.PickUpPersonDetails) (obj1)));
        obj1 = new TGTPickUpStoreAddress();
        e1 = e1.j();
        ((TGTPickUpStoreAddress) (obj1)).a(e1.e());
        ((TGTPickUpStoreAddress) (obj1)).a(e1.f());
        ((TGTPickUpStoreAddress) (obj1)).b(e1.g());
        ((TGTPickUpStoreAddress) (obj1)).c(e1.h());
        tgtphonenumber = new TGTPhoneNumber();
        tgtphonenumber.a(e1.i());
        tgtphonenumber.a(com.target.mothership.model.common.c.Other);
        ((TGTPickUpStoreAddress) (obj1)).a(tgtphonenumber);
        ((TGTStorePickUpDetails) (obj)).a(((com.target.mothership.model.common.PickUpStoreAddress) (obj1)));
        ((TGTStorePickUpDetails) (obj)).a(e1.a());
        ((TGTStorePickUpDetails) (obj)).a(new StoreIdentifier(e1.d()));
        tgtstorepickupshipmentdetails.a(((com.target.mothership.model.common.StorePickUpDetails) (obj)));
        return tgtstorepickupshipmentdetails;
    }

    private EmailDeliveryShipmentDetails d(e e1)
    {
        TGTEmailDeliveryShipmentDetails tgtemaildeliveryshipmentdetails = new TGTEmailDeliveryShipmentDetails();
        tgtemaildeliveryshipmentdetails.a(a(e1.i()));
        tgtemaildeliveryshipmentdetails.b(e1.g());
        tgtemaildeliveryshipmentdetails.a(e1.f());
        return tgtemaildeliveryshipmentdetails;
    }

    private List d(List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            com.target.mothership.services.apigee.j.b.c.b b1 = ((c)list.next()).b();
            if (b1 != null && com.target.mothership.common.tender.a.a(b1.b()) == com.target.mothership.common.tender.a.TARGET_GIFT_CARD)
            {
                TGTAppliedGiftCard tgtappliedgiftcard = new TGTAppliedGiftCard();
                tgtappliedgiftcard.a(l.a(b1.c()));
                tgtappliedgiftcard.a(l.c(b1.a()));
                arraylist.add(tgtappliedgiftcard);
            }
        } while (true);
        return arraylist;
    }

    private MobileDeliveryShipmentDetails e(e e1)
    {
        TGTMobileDeliveryShipmentDetails tgtmobiledeliveryshipmentdetails = new TGTMobileDeliveryShipmentDetails();
        tgtmobiledeliveryshipmentdetails.a(a(e1.i()));
        tgtmobiledeliveryshipmentdetails.b(e1.h());
        tgtmobiledeliveryshipmentdetails.a(e1.f());
        return tgtmobiledeliveryshipmentdetails;
    }

    public OrderDetails a(d d1)
    {
        TGTOrderDetails tgtorderdetails = a(new TGTOrderDetails(), d1.R());
        tgtorderdetails.a(b(d1.Q()));
        tgtorderdetails.a(c(d1.Q()));
        tgtorderdetails.b(d(d1.Q()));
        tgtorderdetails.a(d1.y());
        tgtorderdetails.b(d1.O());
        tgtorderdetails.a(a(d1.P()));
        tgtorderdetails.a(b(d1.J()));
        tgtorderdetails.c(b(d1.N()));
        tgtorderdetails.b(b(d1.M()));
        tgtorderdetails.d(b(d1.I()));
        tgtorderdetails.e(b(d1.K()));
        tgtorderdetails.f(b(d1.L()));
        ArrayList arraylist;
        int i;
        if (o.g(d1.D()))
        {
            i = Double.valueOf(d1.D()).intValue();
        } else
        {
            i = 0;
        }
        tgtorderdetails.a(i);
        arraylist = new ArrayList();
        if (d1.r() != null)
        {
            TGTOrderLevelPromotion tgtorderlevelpromotion;
            for (Iterator iterator = d1.r().iterator(); iterator.hasNext(); arraylist.add(tgtorderlevelpromotion))
            {
                g g1 = (g)iterator.next();
                tgtorderlevelpromotion = new TGTOrderLevelPromotion();
                tgtorderlevelpromotion.a(g1.a());
                tgtorderlevelpromotion.a(g1.b());
            }

        }
        tgtorderdetails.c(arraylist);
        tgtorderdetails.a(l.a(d1.s()));
        tgtorderdetails.a(l.b(d1.t()));
        tgtorderdetails.f(l.a(d1.u()));
        tgtorderdetails.g(l.a(d1.v()));
        tgtorderdetails.e(l.b(d1.w()));
        tgtorderdetails.h(l.a(d1.x()));
        tgtorderdetails.b(l.a(d1.e()));
        tgtorderdetails.b(l.b(d1.f()));
        tgtorderdetails.c(l.a(d1.g()));
        tgtorderdetails.d(l.a(d1.z()));
        tgtorderdetails.c(l.b(d1.A()));
        tgtorderdetails.e(l.a(d1.B()));
        tgtorderdetails.d(l.b(d1.C()));
        tgtorderdetails.i(l.a(d1.a()));
        tgtorderdetails.f(l.b(d1.b()));
        tgtorderdetails.j(l.a(d1.c()));
        tgtorderdetails.g(l.b(d1.d()));
        tgtorderdetails.b(l.a(d1.e()));
        tgtorderdetails.b(l.b(d1.f()));
        tgtorderdetails.c(l.a(d1.g()));
        tgtorderdetails.k(l.a(d1.h()));
        tgtorderdetails.h(l.b(d1.i()));
        tgtorderdetails.l(l.a(d1.j()));
        tgtorderdetails.i(l.b(d1.k()));
        tgtorderdetails.m(l.a(d1.E()));
        tgtorderdetails.j(l.b(d1.F()));
        tgtorderdetails.n(l.a(d1.G()));
        tgtorderdetails.k(l.b(d1.H()));
        tgtorderdetails.o(l.a(d1.m()));
        tgtorderdetails.l(l.b(d1.n()));
        return tgtorderdetails;
    }

    public volatile Object a(Object obj)
    {
        return a((d)obj);
    }
}
