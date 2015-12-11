// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.e.a;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.widget.Button;
import com.b.a.a.g;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.g.d.c;
import com.offerup.android.g.d.d;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            k, gp, go, gq, 
//            a, gn

public class RatingActivity extends k
    implements c
{

    private d a;
    private com.offerup.android.g.d.a b;
    private Button c;
    private Item d;
    private Person j;
    private boolean k;
    private boolean l;

    public RatingActivity()
    {
    }

    static Item a(RatingActivity ratingactivity, Item item)
    {
        ratingactivity.d = item;
        return item;
    }

    static d a(RatingActivity ratingactivity)
    {
        return ratingactivity.a;
    }

    private void a(long l1)
    {
        try
        {
            g = ProgressDialog.show(this, "", "Loading...");
            android.support.v4.e.a.a(l1, new gp(this, (byte)0));
            return;
        }
        catch (Exception exception)
        {
            g.a(this, exception);
        }
    }

    static void a(RatingActivity ratingactivity, String s)
    {
        ratingactivity.a(s);
    }

    private void a(String s)
    {
        android.app.AlertDialog.Builder builder = n.c(this);
        builder.setTitle(getString(0x7f09017d));
        builder.setMessage(getString(0x7f09017b));
        builder.setPositiveButton("OK", new go(this));
        n.a(builder);
        g.c(getClass().getSimpleName(), s);
    }

    static boolean a(RatingActivity ratingactivity, boolean flag)
    {
        ratingactivity.l = false;
        return false;
    }

    static boolean b(RatingActivity ratingactivity)
    {
        return ratingactivity.k;
    }

    static Item c(RatingActivity ratingactivity)
    {
        return ratingactivity.d;
    }

    static Person d(RatingActivity ratingactivity)
    {
        return ratingactivity.j;
    }

    static boolean e(RatingActivity ratingactivity)
    {
        return ratingactivity.l;
    }

    private void f()
    {
        k = ba.a(d);
        a = new d();
        an an1 = getSupportFragmentManager().a();
        an1.a(0x7f100129, a);
        if (!k)
        {
            b = new com.offerup.android.g.d.a();
            an1.a(0x7f100129, b);
            a.a(d, null);
            b.a(d);
        } else
        {
            a.a(d, j);
        }
        an1.b();
    }

    static void f(RatingActivity ratingactivity)
    {
        ratingactivity.f();
    }

    public final void a()
    {
        g = ProgressDialog.show(this, "", "Loading...");
        android.support.v4.e.a.a(d.getId(), 0L, 0, new gq(this, true, 0));
    }

    public final String b()
    {
        if (k)
        {
            return "rate_buyer";
        } else
        {
            return "rate_seller";
        }
    }

    public void onBackPressed()
    {
        setResult(0);
        if (l)
        {
            l = false;
            com.offerup.android.tracker.a.a("ou_rate_buyer_back", null);
            f.d();
            finish();
            return;
        }
        if (k)
        {
            com.offerup.android.tracker.a.a("ou_rate_seller_back", null);
        } else
        {
            com.offerup.android.tracker.a.a("ou_rate_buyer_back", null);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040038);
        bundle = getSupportActionBar();
        bundle.setTitle(getResources().getString(0x7f0901dd));
        bundle.setDisplayUseLogoEnabled(false);
        bundle.setDisplayShowTitleEnabled(true);
        bundle = getIntent().getExtras();
        if (bundle.containsKey("activity_started_externally"))
        {
            l = bundle.getBoolean("activity_started_externally");
            long l1 = bundle.getLong("itemId", 0L);
            if (l1 > 0L)
            {
                a(l1);
            } else
            {
                a("Unable to rate this item.");
            }
        } else
        {
            l = false;
            if (bundle.containsKey("itemId"))
            {
                a(bundle.getLong("itemId"));
            } else
            {
                if (bundle.containsKey("item"))
                {
                    d = (Item)bundle.getParcelable("item");
                }
                if (bundle.containsKey("buyerId"))
                {
                    j = (Person)bundle.getParcelable("buyerId");
                }
                f();
            }
        }
        c = (Button)findViewById(0x7f100128);
        c.setOnClickListener(new gn(this));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }
}
