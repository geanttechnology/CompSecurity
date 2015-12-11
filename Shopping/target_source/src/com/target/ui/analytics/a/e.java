// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            a, y, i

public abstract class e extends com.target.ui.analytics.a.a
{

    public e()
    {
    }

    private String a(y y1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$TapAction[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$TapAction = new int[y.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AddToCart.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AddToCartFromSaveForLater.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AddToList.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AddToSaveForLaterFromCart.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.Checkout.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.ExpressCheckout.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FindInAnotherStore.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.PickUpInStore.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.PickUpInStoreExpress.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.SearchProduct.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.RemoveFromCart.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.RemoveFromCartFromSaveForLater.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.ShipToMe.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AccountCreate.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AccountLogin.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.AccountLogout.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.DealsCartwheel.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.DealsMapProduct.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.DealsMobileCoupons.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.EditList.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FeaturedCartwheelOffer.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FeaturedClearance.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FeaturedProduct.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FeaturedInternalPromo.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FeaturedMiscDialog.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FindAisle.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.FormInteraction.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.InStoreCard.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.ListInteraction.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.ListPromo.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.MapInteraction.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.SearchRefine.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.SearchRefineFilter.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.SearchRefineSort.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.LeftNavMain.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.LeftNavList.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.LeftNavAccount.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.LeftNavShop.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.TypeAheadRow.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.ViewOnMap.ordinal()] = 40;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.PushMessage.ordinal()] = 41;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapAction[y.Unknown.ordinal()] = 42;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapAction[y1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
            return "event:productEvent";

        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
            return "event:contentEvent";
        }
    }

    private String b(y y1)
    {
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapAction[y1.ordinal()])
        {
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        default:
            return "";

        case 1: // '\001'
            return "add to cart";

        case 2: // '\002'
            return "add to cart from save for later";

        case 3: // '\003'
            return "add to list";

        case 5: // '\005'
            return "checkout";

        case 17: // '\021'
            return "cartwheel icon";

        case 19: // '\023'
            return "mobile coupons icon";

        case 6: // '\006'
            return "express checkout";

        case 20: // '\024'
            return "edit list";

        case 21: // '\025'
        case 22: // '\026'
            return "clearance item";

        case 7: // '\007'
            return "fiat";

        case 27: // '\033'
            return "form";

        case 29: // '\035'
            return "list item edit";

        case 8: // '\b'
        case 9: // '\t'
            return "pick up";

        case 11: // '\013'
            return "remove from cart";

        case 4: // '\004'
        case 12: // '\f'
            return "remove from cart for save for later";

        case 10: // '\n'
            return "search prod tap";

        case 32: // ' '
            return "refine";

        case 33: // '!'
            return "filter";

        case 34: // '"'
            return "sort";

        case 13: // '\r'
            return "ship it";

        case 35: // '#'
            return "navmain";

        case 36: // '$'
            return "navslist";

        case 37: // '%'
            return "navaccount";

        case 38: // '&'
            return "navshop";

        case 39: // '\''
            return "type ahead";

        case 18: // '\022'
        case 26: // '\032'
        case 31: // '\037'
        case 40: // '('
            return "view on map";

        case 24: // '\030'
            return "";

        case 23: // '\027'
            return "";

        case 25: // '\031'
            return "";

        case 30: // '\036'
            return "";

        case 28: // '\034'
            return "";
        }
    }

    private static String c(y y1)
    {
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapAction[y1.ordinal()])
        {
        case 2: // '\002'
        case 4: // '\004'
        case 12: // '\f'
        default:
            return "";

        case 14: // '\016'
            return "createAccount";

        case 15: // '\017'
            return "accountSignIn";

        case 16: // '\020'
            return "accountSignOut";

        case 3: // '\003'
            return "addProductToList";

        case 5: // '\005'
            return "checkout";

        case 11: // '\013'
            return "removeFromCart";

        case 1: // '\001'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 10: // '\n'
        case 13: // '\r'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
            return "tapAction";

        case 9: // '\t'
            return "expressStart";

        case 31: // '\037'
            return "mapInteractions";
        }
    }

    private static String d(y y1)
    {
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapAction[y1.ordinal()])
        {
        case 4: // '\004'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        default:
            return "";

        case 3: // '\003'
            return "alst";

        case 17: // '\021'
            return "cartwheel";

        case 19: // '\023'
            return "mc";

        case 18: // '\022'
            return "pimg";

        case 20: // '\024'
            return "ntop";

        case 21: // '\025'
            return "cwhe";

        case 22: // '\026'
            return "clrn";

        case 24: // '\030'
        case 30: // '\036'
            return "promo";

        case 25: // '\031'
            return "mffm";

        case 2: // '\002'
        case 10: // '\n'
        case 12: // '\f'
        case 23: // '\027'
            return "prod";

        case 7: // '\007'
            return "fiat";

        case 26: // '\032'
        case 31: // '\037'
        case 40: // '('
            return "map";

        case 27: // '\033'
            return "form";

        case 29: // '\035'
            return "list";

        case 8: // '\b'
        case 9: // '\t'
        case 13: // '\r'
            return "ship";

        case 6: // '\006'
            return "scrt";

        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
            return "refn";

        case 39: // '\''
            return "type";

        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            return "nicon";

        case 1: // '\001'
        case 5: // '\005'
        case 11: // '\013'
            return "cart";

        case 28: // '\034'
            return "local";
        }
    }

    protected String a()
    {
        return a(i());
    }

    protected Map b()
    {
        a a1 = new a();
        com.target.ui.analytics.a.i.a(a1, "tapActionName", b(i()));
        com.target.ui.analytics.a.i.a(a1, "linkType", d(i()));
        com.target.ui.analytics.a.i.a(a1, "events", c(i()));
        return a1;
    }

    protected abstract y i();
}
