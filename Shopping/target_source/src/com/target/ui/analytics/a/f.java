// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            a, s, i

public abstract class f extends com.target.ui.analytics.a.a
{

    public f()
    {
    }

    private String a(s s1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$Screen[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$Screen = new int[s.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Cart.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Checkout.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.OrderConfirmation.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AddToCartDialog.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Reviews.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.StoreInventory.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ProductDetails.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ProductListing.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Browse.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SearchResults.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SearchTypeAhead.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.BrowseResultsMore.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SearchResultsMore.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.List.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountGiftCards.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.DealsMap.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Categories.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountEdit.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Featured.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.FeaturedMiscDialog.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.FindInAnotherTargetStore.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ListPromotions.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MappedStore.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponEntry.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponSignUp.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponHome.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponList.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.OrderHistory.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.OrderDetails.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.FindAStore.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.GetLocalDeals.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SaveForLater.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.StoreMap.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountView.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountLogin.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.WeeklyAd.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.WeeklyAdProductCollection.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.WeeklyAdStore.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Unknown.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.Screen[s1.ordinal()])
        {
        default:
            return "event:view";

        case 1: // '\001'
            return "event:viewCart";

        case 2: // '\002'
            return "event:viewCheckout";

        case 3: // '\003'
            return "event:viewOrderConfirmation";

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return "event:viewProductDetails";

        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return "event:viewProductListing";

        case 12: // '\f'
        case 13: // '\r'
            return "event:moreProductsLoadedEvent";

        case 14: // '\016'
            return "event:viewShoppingList";
        }
    }

    private String a(Long long1)
    {
        if (long1 == null)
        {
            return "";
        } else
        {
            return String.valueOf(long1.longValue());
        }
    }

    private Map j()
    {
        a a1 = new a();
        com.target.ui.analytics.a.i.a(a1, "screenLoadTime", a(i()));
        return a1;
    }

    protected String a()
    {
        return a(c());
    }

    protected Map b()
    {
        return j();
    }

    protected abstract Long i();
}
