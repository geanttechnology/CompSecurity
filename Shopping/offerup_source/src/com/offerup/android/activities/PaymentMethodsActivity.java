// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.b.a.a.g;
import com.b.a.a.j;
import com.google.android.gms.wallet.MaskedWallet;
import com.offerup.android.a.af;
import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.network.PaymentService;
import com.offerup.android.network.b;
import com.offerup.android.network.o;
import com.offerup.android.utils.as;
import com.offerup.android.utils.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            y, fs, fr, fp, 
//            fq, fm, fn, fo

public class PaymentMethodsActivity extends y
{

    af j;
    PaymentMethod k;
    boolean l;
    boolean m;
    double n;
    List o;
    private ListView p;
    private boolean q;
    private View r;
    private View s;

    public PaymentMethodsActivity()
    {
    }

    static void a(PaymentMethodsActivity paymentmethodsactivity)
    {
        paymentmethodsactivity.a(0x7f0901b1);
        long l1 = paymentmethodsactivity.k.getId();
        paymentmethodsactivity = new fs(paymentmethodsactivity, paymentmethodsactivity.getString(0x7f090198));
        com.offerup.android.network.o.k(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).deletePaymentMethod(l1, paymentmethodsactivity);
    }

    static void b(PaymentMethodsActivity paymentmethodsactivity)
    {
        paymentmethodsactivity.n();
    }

    static void c(PaymentMethodsActivity paymentmethodsactivity)
    {
        paymentmethodsactivity.m();
    }

    private void m()
    {
        s.setVisibility(8);
        if (o != null && o.size() > 0)
        {
            j = new af(this, o);
        } else
        {
            j = new af(this, new ArrayList());
        }
        p.setAdapter(j);
    }

    private void n()
    {
        a(0x7f0901b1);
        com.offerup.android.network.b.a(new fr(this, (byte)0));
    }

    final String b()
    {
        return "payments_paymentmethod_manage";
    }

    public final void b(PaymentMethod paymentmethod)
    {
        if (q)
        {
            k = paymentmethod;
            finish();
            return;
        } else
        {
            n();
            return;
        }
    }

    public final void b(String s1)
    {
label0:
        {
            c = s1;
            k = null;
            if (StringUtils.isNotEmpty(s1))
            {
                if (!m)
                {
                    break label0;
                }
                com.b.a.a.g.a(this, (new StringBuilder("Masked wallet is ")).append(d).toString());
            }
            g();
            m();
            return;
        }
        if (l)
        {
            a(0x7f0901b1);
            if (!e.p())
            {
                e.d(true);
            }
            s1 = new fs(this, getString(0x7f090196));
            com.offerup.android.network.o.k(com.offerup.android.network.o.a(Executors.newCachedThreadPool())).addPaymentMethod("androidpaycard", s1);
            return;
        }
        if (d != null)
        {
            k = new PaymentMethod(s1);
            a(k);
        }
        finish();
    }

    public final void b(boolean flag)
    {
label0:
        {
            if (flag)
            {
                if (!l)
                {
                    break label0;
                }
                c("0.50");
            }
            return;
        }
        if (d != null && k != null && k.isAndroidPay() && StringUtils.isNotEmpty(c))
        {
            f();
            return;
        } else
        {
            c(String.valueOf(n));
            return;
        }
    }

    public final void c(boolean flag)
    {
        s.setVisibility(8);
    }

    public void finish()
    {
        if (k != null && !l)
        {
            Intent intent = new Intent();
            if (k != null)
            {
                intent.putExtra("paymentMethod", k);
                if (k.isAndroidPay() && d != null)
                {
                    intent.putExtra("googleMaskedWallet", d);
                }
            }
            setResult(-1, intent);
        }
        super.finish();
    }

    public final void g()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= o.size()) goto _L2; else goto _L3
_L3:
        if (!((PaymentMethod)o.get(i)).isAndroidPay()) goto _L5; else goto _L4
_L4:
        a((PaymentMethod)o.get(i));
_L2:
        m = false;
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onContextItemSelected(menuitem);

        case 2131755756: 
            menuitem = com.offerup.android.utils.n.c(this);
            menuitem.setTitle("Delete Payment");
            menuitem.setMessage("Are you sure you want to delete this payment method?");
            menuitem.setNegativeButton("Cancel", new fp(this));
            menuitem.setPositiveButton("Yes", new fq(this));
            com.offerup.android.utils.n.a(menuitem);
            return true;

        case 2131755754: 
            a(0x7f0901b1);
            long l1 = k.getId();
            menuitem = new fs(this, getString(0x7f09019a));
            com.offerup.android.network.o.k(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).defaultPaymentMethod(l1, menuitem);
            return true;

        case 2131755755: 
            break;
        }
        if (StringUtils.isNotEmpty(c) && b != null)
        {
            m = true;
            f();
            return true;
        } else
        {
            Toast.makeText(this, "Edit Failed", 1);
            return true;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04001c);
        bundle = getSupportActionBar();
        bundle.setHomeButtonEnabled(true);
        bundle.setDisplayShowHomeEnabled(true);
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setDisplayUseLogoEnabled(false);
        bundle.setDisplayShowTitleEnabled(true);
        bundle.setTitle("Payments");
        p = (ListView)findViewById(0x7f1000a9);
        r = getLayoutInflater().inflate(0x7f0400ba, p, false);
        bundle = getIntent();
        if (bundle.hasExtra("comingFrom"))
        {
            if ("fromProfile".equals(bundle.getStringExtra("comingFrom")))
            {
                l = true;
            } else
            if ("fromPay".equals(bundle.getStringExtra("comingFrom")))
            {
                q = true;
                if (bundle.hasExtra("paymentMethod") && bundle.hasExtra("googleMaskedWallet"))
                {
                    k = (PaymentMethod)bundle.getParcelableExtra("paymentMethod");
                    d = (MaskedWallet)bundle.getParcelableExtra("googleMaskedWallet");
                    c = k.getGoogleWalletTransactionId();
                }
            }
        }
        if (l)
        {
            registerForContextMenu(p);
        } else
        {
            n = getIntent().getDoubleExtra("price", 0.0D);
        }
        p.addFooterView(r, null, false);
        n();
        r.findViewById(0x7f1002a7).setOnClickListener(new fm(this));
        s = r.findViewById(0x7f1002a9);
        s.setVisibility(8);
        s.setOnClickListener(new fn(this));
        p.setOnItemClickListener(new fo(this));
        getSupportActionBar().setElevation(0.0F);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        getMenuInflater().inflate(0x7f11000d, contextmenu);
        if (k.isDefaultPaymentMethod().booleanValue())
        {
            contextmenu.findItem(0x7f1002ea).setVisible(false);
        }
        if (k.isAndroidPay())
        {
            contextmenu.findItem(0x7f1002eb).setVisible(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onResume()
    {
        super.onResume();
        as.a(getApplicationContext(), p);
    }
}
