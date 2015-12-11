// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.common.a.f;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderCompletionPaymentDetails;
import com.target.mothership.model.cart.interfaces.OrderCompletionShipmentDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.Shipment;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, i, s

class bc extends com.target.ui.analytics.a.f
{

    private static final String COMMA = ",";
    private static final String DELIMITER = "|";
    private final GuestAddress mBillingAddress;
    private final List mCartProducts;
    private final int mCheckoutContext;
    private final Long mLoadTimeMS;
    private final OrderCompletionDetails mOrderCompletionDetails;

    private bc(OrderCompletionDetails ordercompletiondetails, OrderReview orderreview, int j, long l)
    {
        mOrderCompletionDetails = ordercompletiondetails;
        mCheckoutContext = j;
        mCartProducts = a(orderreview);
        mBillingAddress = a(ordercompletiondetails);
        mLoadTimeMS = Long.valueOf(l);
    }

    private static GuestAddress a(OrderCompletionDetails ordercompletiondetails)
    {
        if (ordercompletiondetails == null)
        {
            return null;
        }
        if (ordercompletiondetails.k() == null || ordercompletiondetails.k().isEmpty())
        {
            return null;
        }
        ordercompletiondetails = ordercompletiondetails.k().iterator();
        do
        {
            if (!ordercompletiondetails.hasNext())
            {
                break;
            }
            OrderCompletionPaymentDetails ordercompletionpaymentdetails = (OrderCompletionPaymentDetails)ordercompletiondetails.next();
            static class _cls1
            {

                static final int $SwitchMap$com$target$mothership$common$cart$FulfillmentType[];
                static final int $SwitchMap$com$target$mothership$common$tender$CardType[];

                static 
                {
                    $SwitchMap$com$target$mothership$common$cart$FulfillmentType = new int[com.target.mothership.common.a.f.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.ShipToHome.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.StorePickup.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.Special.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.Electronic.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.NONE_SELECTED.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    $SwitchMap$com$target$mothership$common$tender$CardType = new int[com.target.mothership.common.tender.a.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_GIFT_CARD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[ordercompletionpaymentdetails.a().ordinal()])
            {
            default:
                return ordercompletionpaymentdetails.b();

            case 1: // '\001'
                break;
            }
        } while (true);
        return null;
    }

    static bc a(OrderCompletionDetails ordercompletiondetails, OrderReview orderreview, int j, long l)
    {
        return new bc(ordercompletiondetails, orderreview, j, l);
    }

    private static String a(OrderCompletionDetails ordercompletiondetails, int j)
    {
        if (ordercompletiondetails == null)
        {
            return "";
        }
        ordercompletiondetails = new StringBuilder("purchase");
        if (j == 1)
        {
            ordercompletiondetails.append(",");
            ordercompletiondetails.append("expressPurchase");
        }
        return ordercompletiondetails.toString();
    }

    private static List a(OrderReview orderreview)
    {
        ArrayList arraylist = new ArrayList();
        if (orderreview == null || orderreview.n() == null)
        {
            return arraylist;
        }
        orderreview = orderreview.n().iterator();
        do
        {
            if (!orderreview.hasNext())
            {
                break;
            }
            List list = ((Shipment)orderreview.next()).a();
            if (list != null && !list.isEmpty())
            {
                arraylist.addAll(list);
            }
        } while (true);
        return arraylist;
    }

    private static int b(OrderCompletionDetails ordercompletiondetails)
    {
        while (ordercompletiondetails == null || ordercompletiondetails.k().isEmpty()) 
        {
            return 0;
        }
        ordercompletiondetails = ordercompletiondetails.k().iterator();
        int j = 0;
        do
        {
            if (!ordercompletiondetails.hasNext())
            {
                break;
            }
            if (((OrderCompletionPaymentDetails)ordercompletiondetails.next()).a() == a.TARGET_GIFT_CARD)
            {
                j++;
            }
        } while (true);
        return j;
    }

    private static String c(OrderCompletionDetails ordercompletiondetails)
    {
        boolean flag;
        boolean flag1;
        if (ordercompletiondetails == null)
        {
            return "";
        }
        if (ordercompletiondetails.l() == null || ordercompletiondetails.l().isEmpty())
        {
            return "";
        }
        ordercompletiondetails = ordercompletiondetails.l().iterator();
        flag1 = false;
        flag = false;
_L8:
        if (!ordercompletiondetails.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = ((OrderCompletionShipmentDetails)ordercompletiondetails.next()).a();
        if (obj == null || ((List) (obj)).isEmpty()) goto _L4; else goto _L3
_L3:
        obj = (CartProduct)((List) (obj)).get(0);
        if (obj == null) goto _L4; else goto _L5
_L5:
        obj = ((CartProduct) (obj)).d();
        _cls1..SwitchMap.com.target.mothership.common.cart.FulfillmentType[((f) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 140
    //                   1 159
    //                   2 170;
           goto _L4 _L6 _L7
_L4:
        boolean flag2 = flag1;
        flag1 = flag;
        flag = flag2;
_L9:
        boolean flag3 = flag1;
        flag1 = flag;
        flag = flag3;
          goto _L8
_L6:
        boolean flag4 = true;
        flag1 = flag;
        flag = flag4;
          goto _L9
_L7:
        flag = flag1;
        flag1 = true;
          goto _L9
_L2:
        if (flag && flag1)
        {
            return "Mix";
        }
        if (flag)
        {
            return "Pickup Only";
        }
        if (flag1)
        {
            return "Ship Only";
        } else
        {
            return "";
        }
    }

    private static String d(OrderCompletionDetails ordercompletiondetails)
    {
        ordercompletiondetails = e(ordercompletiondetails);
        if (ordercompletiondetails.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < ordercompletiondetails.size(); j++)
        {
            stringbuilder.append(((a)ordercompletiondetails.get(j)).a());
            if (j < ordercompletiondetails.size() - 1)
            {
                stringbuilder.append("|");
            }
        }

        return stringbuilder.toString();
    }

    private static List e(OrderCompletionDetails ordercompletiondetails)
    {
        ArrayList arraylist = new ArrayList();
        if (ordercompletiondetails == null)
        {
            return arraylist;
        }
        if (ordercompletiondetails.k() == null || ordercompletiondetails.k().isEmpty())
        {
            return arraylist;
        }
        Object obj = ordercompletiondetails.k();
        ordercompletiondetails = new HashSet();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            OrderCompletionPaymentDetails ordercompletionpaymentdetails = (OrderCompletionPaymentDetails)((Iterator) (obj)).next();
            if (ordercompletionpaymentdetails.a() != null)
            {
                ordercompletiondetails.add(ordercompletionpaymentdetails.a());
            }
        } while (true);
        for (ordercompletiondetails = ordercompletiondetails.iterator(); ordercompletiondetails.hasNext(); arraylist.add(ordercompletiondetails.next())) { }
        return arraylist;
    }

    private static String f(OrderCompletionDetails ordercompletiondetails)
    {
        if (ordercompletiondetails == null)
        {
            return "";
        }
        ordercompletiondetails = ordercompletiondetails.s();
        if (ordercompletiondetails == null || ordercompletiondetails.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < ordercompletiondetails.size(); j++)
        {
            PromoCode promocode = (PromoCode)ordercompletiondetails.get(j);
            if (!o.g(promocode.b()))
            {
                continue;
            }
            stringbuilder.append(promocode.b());
            if (j < ordercompletiondetails.size() - 1)
            {
                stringbuilder.append("|");
            }
        }

        return stringbuilder.toString();
    }

    private static String g(OrderCompletionDetails ordercompletiondetails)
    {
        if (ordercompletiondetails == null)
        {
            return "";
        } else
        {
            return "Cart Order";
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "events", a(mOrderCompletionDetails, mCheckoutContext));
        if (mCartProducts != null && !mCartProducts.isEmpty())
        {
            com.target.ui.analytics.a.i.a(map, "products", com.target.ui.analytics.a.i.a(mCartProducts));
        }
        if (mOrderCompletionDetails != null)
        {
            com.target.ui.analytics.a.i.a(map, "orderID", mOrderCompletionDetails.a());
            com.target.ui.analytics.a.i.a(map, "cartSubtotal", mOrderCompletionDetails.i().toPlainString());
            com.target.ui.analytics.a.i.a(map, "orderTax", mOrderCompletionDetails.t().toPlainString());
            com.target.ui.analytics.a.i.a(map, "orderShipping", mOrderCompletionDetails.w().toPlainString());
            com.target.ui.analytics.a.i.a(map, "orderTotal", mOrderCompletionDetails.c().toPlainString());
            com.target.ui.analytics.a.i.a(map, "orderPromoCodes", f(mOrderCompletionDetails));
            com.target.ui.analytics.a.i.a(map, "numberOfGiftCardsUsed", String.valueOf(b(mOrderCompletionDetails)));
            com.target.ui.analytics.a.i.a(map, "paymentMethod", d(mOrderCompletionDetails));
            com.target.ui.analytics.a.i.a(map, "flexFullfilmentTypeOrder", c(mOrderCompletionDetails));
            com.target.ui.analytics.a.i.a(map, "orderType", g(mOrderCompletionDetails));
        }
        if (mBillingAddress != null)
        {
            com.target.ui.analytics.a.i.a(map, "billingState", mBillingAddress.getStateOrProvince());
            com.target.ui.analytics.a.i.a(map, "billingPostalCode", mBillingAddress.getPostalCode());
        }
        return map;
    }

    protected s c()
    {
        return s.OrderConfirmation;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected Long i()
    {
        return mLoadTimeMS;
    }
}
