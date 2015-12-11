// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import com.google.a.a.e;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.a.a.b;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.g;
import com.target.mothership.util.o;
import com.target.ui.analytics.f;
import com.target.ui.service.k;
import com.target.ui.util.d.c;
import com.target.ui.util.p;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.target.ui.analytics.a:
//            b, s, g, i

public abstract class com.target.ui.analytics.a.a extends com.target.ui.analytics.a.b
{
    class a
    {

        final List levels;
        final String platform = "android";
        final s screen;
        final String siteSection;
        final com.target.ui.analytics.a.a this$0;

        public String a()
        {
            StringBuilder stringbuilder = new StringBuilder();
            getClass();
            stringbuilder.append("android");
            if (siteSection != null)
            {
                stringbuilder.append(": ");
                stringbuilder.append(siteSection);
            }
            if (levels != null && !levels.isEmpty())
            {
                String s1;
                for (Iterator iterator = levels.iterator(); iterator.hasNext(); stringbuilder.append(s1))
                {
                    s1 = (String)iterator.next();
                    stringbuilder.append(": ");
                }

            }
            return stringbuilder.toString();
        }

        public a(s s1, String s2, List list)
        {
            this$0 = com.target.ui.analytics.a.a.this;
            super();
            screen = s1;
            siteSection = s2;
            levels = list;
        }
    }


    private static final int INDEX_LEVEL_2 = 0;
    private static final int INDEX_LEVEL_3 = 1;
    public static final String SCREEN_NAME_TAG = "screenName";
    private static final String SPACER = ": ";
    private static final String TAG = com/target/ui/analytics/a/a.getSimpleName();
    private static final DateFormat TIMESTAMP_DATE_FORMAT;

    public com.target.ui.analytics.a.a()
    {
    }

    private static String a(Context context)
    {
        if (!p.a(context))
        {
            return "DISABLED";
        }
        context = com.target.ui.service.k.a().c();
        if (!context.b())
        {
            return "OUT_OF_VENUE";
        }
        if (((RelevantStoreSummary)context.c()).a())
        {
            return "IN_VENUE_CONFIRMED";
        } else
        {
            return "OUT_OF_VENUE";
        }
    }

    private String a(s s1)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$Screen[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$Screen = new int[s.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Cart.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror53) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SaveForLater.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror52) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Checkout.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror51) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.OrderConfirmation.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror50) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AddToCartDialog.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror49) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ProductDetails.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror48) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Reviews.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror47) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Browse.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror46) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.BrowseResultsMore.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror45) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ProductListing.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror44) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SearchTypeAhead.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror43) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SearchResults.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror42) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.SearchResultsMore.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountGiftCards.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountEdit.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.DealsMap.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Categories.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Deals.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Featured.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.FeaturedMiscDialog.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[com.target.ui.analytics.a.s.List.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ListPromotions.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponEntry.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponSignUp.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponHome.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MobileCouponList.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.OrderHistory.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.StoreMap.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountView.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.AccountLogin.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.WeeklyAd.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.WeeklyAdProductCollection.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.FindAStore.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.WeeklyAdStore.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.StoreInventory.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.MappedStore.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.GetLocalDeals.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.FindInAnotherTargetStore.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Profile.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.PaymentCardsAccount.ordinal()] = 40;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.PaymentCardsCheckout.ordinal()] = 41;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ShippingAddressesAccount.ordinal()] = 42;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.ShippingAddressesCheckout.ordinal()] = 43;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistryHome.ordinal()] = 44;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistryAdvancedSearch.ordinal()] = 45;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistrySearch.ordinal()] = 46;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistryListWedding.ordinal()] = 47;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistryListBaby.ordinal()] = 48;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistryListCollege.ordinal()] = 49;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.RegistryListTargetList.ordinal()] = 50;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.Unknown.ordinal()] = 51;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.LeftNav.ordinal()] = 52;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.OrderDetails.ordinal()] = 53;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$Screen[s.InStoreCards.ordinal()] = 54;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.ui.analytics.brighttag.Screen[s1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "shopping cart";

        case 2: // '\002'
            return "shopping cart: save for later";

        case 3: // '\003'
            return "checkout";

        case 4: // '\004'
            return "order confirmation";

        case 5: // '\005'
            return "add to cart";

        case 6: // '\006'
            return "product details";

        case 7: // '\007'
            return "reviews";

        case 8: // '\b'
        case 9: // '\t'
            return j();

        case 10: // '\n'
            return "product listing";

        case 11: // '\013'
            return "search type ahead";

        case 12: // '\f'
        case 13: // '\r'
            return "search results";

        case 14: // '\016'
            return "gift card management";

        case 15: // '\017'
            return "my target level 2";

        case 16: // '\020'
            return "deals map";

        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
            return "shop";

        case 20: // '\024'
            return "misc focus frame";

        case 21: // '\025'
        case 22: // '\026'
            return "lists";

        case 23: // '\027'
            return "mobile coupon entry";

        case 24: // '\030'
            return "mobile coupon sign up";

        case 25: // '\031'
            return "mobile coupon home";

        case 26: // '\032'
            return "mobile coupon list";

        case 27: // '\033'
            return "order history: all";

        case 28: // '\034'
            return "store map";

        case 29: // '\035'
        case 30: // '\036'
            return "my target level 1";

        case 31: // '\037'
        case 32: // ' '
            return "weekly ad";

        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            return "store finder results";

        case 39: // '\''
            return "update my account";

        case 40: // '('
        case 41: // ')'
            return "payment cards";

        case 42: // '*'
        case 43: // '+'
            return "shipping addresses";

        case 44: // ','
            return "registry home";

        case 45: // '-'
            return "registry advanced search";

        case 46: // '.'
            return "registry search";

        case 47: // '/'
            return "registry wedding list";

        case 48: // '0'
            return "registry baby list";

        case 49: // '1'
            return "registry college list";

        case 50: // '2'
            return "registry target list";
        }
    }

    private Map a(Map map)
    {
        Object obj2 = com.target.ui.analytics.a.g.a().b();
        Object obj1 = com.target.ui.service.a.a().c();
        Object obj = com.target.ui.service.k.a().c();
        if (((e) (obj)).b())
        {
            RelevantStoreSummary relevantstoresummary = (RelevantStoreSummary)((e) (obj)).c();
            boolean flag1;
            if (relevantstoresummary.a())
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            map.put("visitorCurrentlyInStore", obj);
            map.put("mostRelevantStoreID", relevantstoresummary.getStoreId().a());
        }
        if (((e) (obj1)).b())
        {
            obj1 = (Guest)((e) (obj1)).c();
            if (((Guest) (obj1)).isAnonymous())
            {
                obj = "anonymous";
            } else
            {
                obj = ((Guest) (obj1)).getGuestId();
            }
            if (((Guest) (obj1)).isAnonymous())
            {
                obj1 = "guest";
            } else
            {
                obj1 = "logged in";
            }
        } else
        {
            obj = "not available";
            obj1 = "guest";
        }
        map.put("guestId", obj);
        map.put("loginState", obj1);
        map.put("appLaunchNumber", String.valueOf(com.target.ui.analytics.a.g.a().c().a()));
        map.put("appLaunchSinceUpgrade", String.valueOf(com.target.ui.analytics.a.g.a().c().b()));
        obj = new Date();
        map.put("dayOfWeek", com.target.ui.util.d.c.a(((Date) (obj))));
        map.put("hourOfDay", com.target.ui.util.d.c.b(((Date) (obj))));
        map.put("timestamp", TIMESTAMP_DATE_FORMAT.format(((Date) (obj))));
        map.put("deviceIdentifier", Build.DEVICE);
        map.put("applicationVersionNumber", b(((Context) (obj2))));
        map.put("osVersion", android.os.Build.VERSION.RELEASE);
        map.put("deviceName", Build.MODEL);
        obj = com.target.mothership.services.g.a().b();
        if (obj != null)
        {
            map.put("userLatitude", String.valueOf(((Location) (obj)).getLatitude()));
            map.put("userLongitude", String.valueOf(((Location) (obj)).getLongitude()));
        }
        map.put("proximityToStore", a(((Context) (obj2))));
        map.put("PointInsideLibName", "pimapslib");
        map.put("userLocAccuracy", "65");
        map.put("PointInsideLibVersion", "4.2.4");
        if (com.target.ui.util.g.a.a(((Context) (obj2))))
        {
            com.target.ui.analytics.a.i.a(map, "ABTestingIDs", com.target.ui.j.c.a().c());
        }
        com.target.ui.analytics.a.i.a(map, "androidAdvertiserID", (String)com.target.ui.analytics.a.g.a().d().a().d());
        com.target.ui.analytics.a.i.a(map, "screenType", a(c()));
        com.target.ui.analytics.a.i.a(map, "screenTypeAbbr", e(c()));
        com.target.ui.analytics.a.i.a(map, "platform", "android");
        com.target.ui.analytics.a.i.a(map, "siteSection", c(c()));
        com.target.ui.analytics.a.i.a(map, "level2", b(c()));
        com.target.ui.analytics.a.i.a(map, "previousScreen", i());
        obj2 = d(c());
        com.target.ui.analytics.a.g.a().a(((a) (obj2)));
        obj1 = null;
        obj = obj1;
        if (((a) (obj2)).levels != null)
        {
            obj = obj1;
            if (((a) (obj2)).levels.size() >= 2)
            {
                obj = (String)((a) (obj2)).levels.get(1);
            }
        }
        com.target.ui.analytics.a.i.a(map, "level3", ((String) (obj)));
        com.target.ui.analytics.a.i.a(map, "screenName", ((a) (obj2)).a());
        com.target.ui.analytics.a.i.a(map, "contentLanguage", "en-US");
        map.put("notificationsEnabled", String.valueOf(com.target.ui.l.a.a().b()));
        obj = com.target.ui.util.c.a();
        if (((com.target.ui.util.c.a) (obj)).b() == 1)
        {
            flag1 = ((com.target.ui.util.c.a) (obj)).a();
            boolean flag;
            if (com.target.ui.l.a.a().c() && flag1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            map.put("VLCEngaged", obj);
            if (flag1)
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            map.put("bluetoothEnabled", obj);
        }
        return map;
    }

    private static String b(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    private String b(s s1)
    {
        String s2 = k();
        if (o.f(s2))
        {
            return s2;
        }
        switch (_cls2..SwitchMap.com.target.ui.analytics.brighttag.Screen[s1.ordinal()])
        {
        case 2: // '\002'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 20: // '\024'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 51: // '3'
        case 52: // '4'
        default:
            return "";

        case 17: // '\021'
            return "categories";

        case 1: // '\001'
            return "shopping cart";

        case 3: // '\003'
            return "checkout";

        case 18: // '\022'
            return "deals";

        case 16: // '\020'
            return "deals map";

        case 15: // '\017'
            return "my account";

        case 5: // '\005'
            return "add to cart";

        case 19: // '\023'
            return "featured";

        case 38: // '&'
            return "fiats";

        case 35: // '#'
            return "store inventory";

        case 36: // '$'
            return "map and aisle locations";

        case 23: // '\027'
            return "on demand coupon entry";

        case 24: // '\030'
            return "sign up";

        case 25: // '\031'
            return "home";

        case 26: // '\032'
            return "list";

        case 21: // '\025'
            return "list";

        case 22: // '\026'
            return "list promotions";

        case 4: // '\004'
            return "order confirmation";

        case 27: // '\033'
            return "order history";

        case 53: // '5'
            return "order details";

        case 33: // '!'
            return "find a store";

        case 37: // '%'
            return "get local deals";

        case 28: // '\034'
            return "in-store map";

        case 34: // '"'
            return "weekly ad";

        case 39: // '\''
            return "update my account";

        case 40: // '('
        case 41: // ')'
            return "payment cards";

        case 42: // '*'
        case 43: // '+'
            return "shipping addresses";

        case 14: // '\016'
            return "gift card management";

        case 44: // ','
            return "registry home";

        case 45: // '-'
            return "registry advanced search";

        case 46: // '.'
            return "registry search";

        case 49: // '1'
            return "registry college list";

        case 47: // '/'
            return "registry wedding list";

        case 48: // '0'
            return "registry baby list";

        case 50: // '2'
            return "registry target list";
        }
    }

    private String c(s s1)
    {
        switch (_cls2..SwitchMap.com.target.ui.analytics.brighttag.Screen[s1.ordinal()])
        {
        case 51: // '3'
        default:
            return "";

        case 14: // '\016'
        case 15: // '\017'
        case 27: // '\033'
        case 29: // '\035'
        case 30: // '\036'
        case 39: // '\''
        case 40: // '('
        case 42: // '*'
        case 53: // '5'
            return "my target";

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return "products";

        case 8: // '\b'
        case 9: // '\t'
            return "browse";

        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
            return "shop";

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 41: // ')'
        case 43: // '+'
            return "checkout";

        case 16: // '\020'
        case 28: // '\034'
            return "map";

        case 20: // '\024'
            return "misc focus frame";

        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            return "store finder";

        case 21: // '\025'
        case 22: // '\026'
            return "lists";

        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
            return "mobile coupons";

        case 10: // '\n'
            return "product listing";

        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
            return "search results";

        case 31: // '\037'
        case 32: // ' '
            return "weekly ad";

        case 52: // '4'
            return "nav drawer";

        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
            return "registry";
        }
    }

    private a d(s s1)
    {
        String s2 = c(c());
        String s3 = b(s1);
        List list = d();
        ArrayList arraylist = new ArrayList();
        boolean flag = o.f(s3);
        if (flag)
        {
            arraylist.add(s3);
        }
        int l;
        if (flag)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (list != null && !list.isEmpty())
        {
            for (; l < list.size(); l++)
            {
                arraylist.add(list.get(l));
            }

        }
        return new a(s1, s2, arraylist);
    }

    private String e(s s1)
    {
        switch (_cls2..SwitchMap.com.target.ui.analytics.brighttag.Screen[s1.ordinal()])
        {
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        default:
            return "";

        case 14: // '\016'
            return "acgc";

        case 5: // '\005'
            return "acrt";

        case 17: // '\021'
            return "hp-c";

        case 1: // '\001'
            return "scrt";

        case 2: // '\002'
            return "svfl";

        case 3: // '\003'
            return "ckut";

        case 18: // '\022'
            return "hp-d";

        case 15: // '\017'
            return "uacc";

        case 19: // '\023'
        case 54: // '6'
            return "hp-f";

        case 20: // '\024'
            return "mfrm";

        case 21: // '\025'
            return "slist";

        case 22: // '\026'
            return "plist";

        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
            return "mcsu";

        case 4: // '\004'
            return "ocfm";

        case 27: // '\033'
            return "oh-a";

        case 6: // '\006'
            return "pdp";

        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            return "plp";

        case 12: // '\f'
        case 13: // '\r'
            return "srst";

        case 11: // '\013'
            return "styp";

        case 33: // '!'
        case 37: // '%'
            return "sfnd";

        case 7: // '\007'
            return "revw";

        case 16: // '\020'
            return "dmap";

        case 28: // '\034'
            return "smap";

        case 29: // '\035'
        case 30: // '\036'
            return "acc";

        case 31: // '\037'
        case 32: // ' '
            return "wad";

        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 38: // '&'
            return "sfrs";

        case 44: // ','
            return "regh";

        case 45: // '-'
            return "regas";

        case 46: // '.'
            return "regs";

        case 47: // '/'
            return "regw";

        case 48: // '0'
            return "regb";

        case 49: // '1'
            return "regc";

        case 50: // '2'
            return "regtl";
        }
    }

    private String i()
    {
        a a1 = com.target.ui.analytics.a.g.a().e();
        if (a1 == null)
        {
            return "";
        } else
        {
            return a1.a();
        }
    }

    private String j()
    {
        List list = d();
        if (list == null || list.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int l = 0; l < list.size(); l++)
        {
            stringbuilder.append((String)list.get(l));
            if (l < list.size() - 1)
            {
                stringbuilder.append(": ");
            }
        }

        return stringbuilder.toString();
    }

    private String k()
    {
        List list = d();
        if (list == null || list.isEmpty())
        {
            return "";
        } else
        {
            return (String)list.get(0);
        }
    }

    protected abstract String a();

    protected abstract Map b();

    protected abstract s c();

    protected abstract List d();

    public final void e()
    {
        TraceFieldInterface tracefieldinterface = new TraceFieldInterface() {

            public Trace _nr_trace;
            final com.target.ui.analytics.a.a this$0;

            public void _nr_setTrace(Trace trace)
            {
                try
                {
                    _nr_trace = trace;
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Trace trace)
                {
                    return;
                }
            }

            protected transient Void a(Void avoid1[])
            {
                f();
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                TraceMachine.enterMethod(_nr_trace, "a$1#doInBackground", null);
_L1:
                aobj = a((Void[])aobj);
                TraceMachine.exitMethod();
                TraceMachine.unloadTraceContext(this);
                return ((Object) (aobj));
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "a$1#doInBackground", null);
                  goto _L1
            }

            
            {
                this$0 = com.target.ui.analytics.a.a.this;
                super();
            }
        };
        Void avoid[] = new Void[0];
        if (!(tracefieldinterface instanceof AsyncTask))
        {
            tracefieldinterface.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)tracefieldinterface, avoid);
            return;
        }
    }

    final void f()
    {
        try
        {
            com.target.ui.analytics.a.g.a().a(a(), h());
            return;
        }
        catch (Exception exception)
        {
            com.target.a.a.b.a(TAG, "Critical error while trying to publish analytics event: ", exception);
        }
    }

    String g()
    {
        return a();
    }

    Map h()
    {
        return a(b());
    }

    static 
    {
        TIMESTAMP_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US);
        TimeZone timezone = TimeZone.getTimeZone("UTC");
        TIMESTAMP_DATE_FORMAT.setTimeZone(timezone);
    }
}
