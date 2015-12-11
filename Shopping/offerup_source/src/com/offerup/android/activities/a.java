// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import com.b.a.a.g;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.utils.as;
import com.offerup.android.utils.ba;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            LoginActivity, OfferUpWebViewActivity, PaymentMethodCaptureActivity, UserDetailActivity, 
//            ChatActivity, ItemDetailActivity, NewPostActivity, PaymentInitialConfirmationActivity, 
//            RatingActivity, SearchActivity, ChangeLocationActivity, MyOffersActivity, 
//            BuyActivity, SendMessageActivity, AlertsActivity, SelectBuyerActivity, 
//            MyAccountActivity, NavigationDrawerWebViewActivity, ExploreActivity, PayItemGridActivity

public class a
{

    Activity a;

    public a(Activity activity)
    {
        a = activity;
    }

    private void a(Intent intent)
    {
        Intent intent1 = new Intent(a, com/offerup/android/activities/LoginActivity);
        if (intent != null)
        {
            intent1.putExtra("login_complete_intent", intent);
        }
        a.startActivityForResult(intent1, 2);
    }

    private void a(String s, Uri uri, String s1)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
        intent.putExtra("uri", uri);
        intent.putExtra("title", s);
        intent.putExtra("hideMenuOptions", true);
        if (StringUtils.isNotEmpty(s1))
        {
            intent.putExtra("webviewScreenName", s1);
        }
        a.startActivity(intent);
    }

    public final void a()
    {
        a(((Intent) (null)));
    }

    public final void a(double d1)
    {
        try
        {
            Intent intent = new Intent(a, com/offerup/android/activities/PaymentMethodCaptureActivity);
            intent.putExtra("price", d1);
            a.startActivityForResult(intent, 113);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    public final void a(long l1)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/UserDetailActivity);
        intent.putExtra("userId", l1);
        intent.addFlags(0x20000);
        a.startActivity(intent);
    }

    public final void a(long l1, long l2, boolean flag)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/ChatActivity);
        intent.putExtra("discussionId", l1);
        intent.putExtra("itemId", l2);
        intent.putExtra("activity_started_externally", flag);
        a.startActivity(intent);
    }

    public final void a(long l1, boolean flag, String s)
    {
        if (l1 > 0L)
        {
            s = new Intent(a, com/offerup/android/activities/ItemDetailActivity);
            s.putExtra("activity_started_externally", flag);
            s.putExtra("itemId", l1);
            s.putExtra("originScreenViewKey", null);
            s.addFlags(0x20000);
            a.startActivity(s);
            return;
        } else
        {
            com.b.a.a.g.a(this, new Exception("itemId is 0"));
            return;
        }
    }

    public final void a(Item item)
    {
        if (item != null)
        {
            Intent intent = new Intent(a, com/offerup/android/activities/NewPostActivity);
            intent.putExtra("item", item);
            a.startActivity(intent);
        }
    }

    public final void a(Item item, BuyRequest buyrequest)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/PaymentInitialConfirmationActivity);
        intent.putExtra("item", item);
        intent.putExtra("currentBuyRequest", buyrequest);
        a.startActivity(intent);
    }

    public final void a(Item item, Person person)
    {
        if (item != null)
        {
            Intent intent = new Intent(a, com/offerup/android/activities/RatingActivity);
            intent.putExtra("item", item);
            intent.putExtra("buyerId", person);
            a.startActivityForResult(intent, 11);
            return;
        } else
        {
            com.b.a.a.g.a(this, new Exception("item is null"));
            return;
        }
    }

    public final void a(Item item, String s)
    {
        if (item != null)
        {
            Intent intent = new Intent(a, com/offerup/android/activities/ItemDetailActivity);
            intent.putExtra("item", item);
            intent.putExtra("originScreenViewKey", s);
            intent.addFlags(0x20000);
            a.startActivity(intent);
            return;
        } else
        {
            com.b.a.a.g.a(this, new Exception("item is null"));
            return;
        }
    }

    public final void a(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", a.getString(0x7f090138));
        android.support.v4.g.a a1 = new android.support.v4.g.a();
        a1.put("utm_campaign", "si");
        a1.put("utm_medium", "id");
        a1.put("utm_source", "ad");
        intent.putExtra("android.intent.extra.TEXT", as.a(s, a1).toString());
        a.startActivity(Intent.createChooser(intent, a.getString(0x7f090137)));
    }

    public final void a(String s, long l1)
    {
        try
        {
            Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
            intent.putExtra("uri", as.a((new StringBuilder("https://offerupnow.com/")).append("report/discussion/").append(l1).toString(), s));
            intent.putExtra("hideMenuOptions", true);
            a.startActivityForResult(intent, 545);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.b.a.a.g.a(this, s);
        }
    }

    public final void a(String s, Integer integer, Integer integer1, Double double1, Double double2)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/SearchActivity);
        intent.addFlags(0x4000000);
        intent.putExtra("activity_started_externally", true);
        if (s != null)
        {
            intent.putExtra("query", s);
        }
        if (integer1 != null)
        {
            intent.putExtra("cid", integer1.intValue());
        }
        if (double1 != null && double2 != null)
        {
            s = new Location("");
            s.setLatitude(double1.doubleValue());
            s.setLongitude(double2.doubleValue());
            intent.putExtra("loc", s);
        }
        if (integer != null)
        {
            intent.putExtra("lid", integer.intValue());
        }
        a.startActivity(intent);
    }

    public final void a(String s, String s1)
    {
        s1 = Uri.parse(s1);
        Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
        intent.putExtra("uri", s1);
        intent.putExtra("title", s);
        intent.putExtra("hideMenuOptions", true);
        a.startActivity(intent);
    }

    public final void a(String s, boolean flag, String s1)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
        intent.putExtra("uri", as.b(s));
        intent.putExtra("activity_started_externally", flag);
        intent.putExtra("hideMenuOptions", true);
        if (StringUtils.isNotEmpty(s1))
        {
            intent.putExtra("webviewScreenName", s1);
        }
        a.startActivity(intent);
    }

    public final void a(boolean flag)
    {
        com.offerup.android.tracker.a.a("ou_account_tap_settings", null);
        Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
        intent.putExtra("uri", as.b("accounts/settings/"));
        intent.putExtra("allowBrowserBack", false);
        intent.putExtra("title", "Settings");
        intent.putExtra("activity_started_externally", flag);
        a.startActivityForResult(intent, 5);
    }

    public final void b()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/ChangeLocationActivity);
        a.startActivityForResult(intent, 615);
    }

    public final void b(long l1)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/MyOffersActivity);
        intent.addFlags(0x4000000);
        intent.putExtra("userId", l1);
        if (ba.a())
        {
            a.startActivity(intent);
            return;
        } else
        {
            a(intent);
            return;
        }
    }

    public final void b(Item item)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/BuyActivity);
        intent.putExtra("item", item);
        if (ba.a())
        {
            a.startActivityForResult(intent, 3);
            return;
        } else
        {
            a(intent);
            return;
        }
    }

    public final void b(String s, long l1)
    {
        try
        {
            Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
            intent.putExtra("uri", as.a((new StringBuilder("https://offerupnow.com/")).append("report/user/").append(l1).toString(), s));
            intent.putExtra("hideMenuOptions", true);
            a.startActivityForResult(intent, 545);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.b.a.a.g.a(this, s);
        }
    }

    public final void b(boolean flag)
    {
        Uri uri = as.b("terms/");
        String s1 = a.getString(0x7f090222);
        String s;
        if (flag)
        {
            s = "payments_terms_conditions";
        } else
        {
            s = null;
        }
        a(s1, uri, s);
    }

    public final void c()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/NewPostActivity);
        if (ba.a())
        {
            a.startActivity(intent);
            return;
        } else
        {
            a(intent);
            return;
        }
    }

    public final void c(long l1)
    {
        try
        {
            Uri uri = as.b((new StringBuilder("payments/receipt/")).append(String.valueOf(l1)).toString());
            Intent intent = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
            intent.putExtra("uri", uri);
            intent.putExtra("hideMenuOptions", true);
            intent.putExtra("allowBrowserBack", false);
            a.startActivityForResult(intent, 545);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    public final void c(Item item)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/SendMessageActivity);
        intent.putExtra("item", item);
        if (ba.a())
        {
            a.startActivity(intent);
            return;
        } else
        {
            a(intent);
            return;
        }
    }

    public final void d()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/AlertsActivity);
        intent.addFlags(0x4000000);
        if (ba.a())
        {
            a.startActivity(intent);
            return;
        } else
        {
            intent.putExtra("login_failed_dialog_message_intent_key", "You must be logged in to view Alerts.");
            a(intent);
            return;
        }
    }

    public final void d(Item item)
    {
        Intent intent = new Intent(a, com/offerup/android/activities/SelectBuyerActivity);
        intent.putExtra("item", item);
        a.startActivity(intent);
    }

    public final void e()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/MyAccountActivity);
        intent.addFlags(0x20000);
        if (ba.a())
        {
            a.startActivity(intent);
            return;
        } else
        {
            a(intent);
            return;
        }
    }

    public final void f()
    {
        com.offerup.android.tracker.a.a("ou_account_tap_support", null);
        Uri uri = as.b("support/");
        Intent intent = new Intent(a, com/offerup/android/activities/NavigationDrawerWebViewActivity);
        intent.putExtra("whiteBackground", true);
        intent.putExtra("uri", uri);
        intent.putExtra("use_title", true);
        intent.putExtra("title", a.getString(0x7f090223));
        intent.putExtra("hideMenuOptions", true);
        a.startActivity(intent);
    }

    public final void g()
    {
        Uri uri = as.b("privacy/");
        a(a.getString(0x7f090221), uri, ((String) (null)));
    }

    public final void h()
    {
        a("No Refunds", as.b("terms/", "no-refunds"), "payments_no_refunds");
    }

    public final void i()
    {
        a("Learn More", as.b("payments/learnmore-buyer/"), "payments_learnmore_buyer");
    }

    public final void j()
    {
        a("Learn More", as.b("payments/learnmore-seller/"), "payments_learnmore_seller");
    }

    public final void k()
    {
        a("Buying Tips", (new StringBuilder("https://offerupnow.com/")).append("app/help/buyer/tips/").toString());
    }

    public final void l()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/ExploreActivity);
        intent.addFlags(0x4000000);
        a.startActivity(intent);
    }

    public final void m()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/SearchActivity);
        intent.addFlags(0x4000000);
        a.startActivity(intent);
    }

    public final void n()
    {
        Intent intent = new Intent(a, com/offerup/android/activities/PayItemGridActivity);
        a.startActivity(intent);
    }
}
