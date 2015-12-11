// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.b.a.a.j;
import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.g.g;
import com.offerup.android.g.k;
import com.offerup.android.utils.ax;

// Referenced classes of package com.offerup.android.activities:
//            y, a

public class PaymentMethodActivity extends y
    implements ax
{

    private double j;
    private boolean k;

    public PaymentMethodActivity()
    {
    }

    private void c(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("fromChat", k);
        bundle.putBoolean("cardAlreadyOnFile", flag);
        g g1 = new g();
        g1.setArguments(bundle);
        getSupportFragmentManager().a().b(0x7f100114, g1, "Cards").b();
    }

    final String b()
    {
        return "";
    }

    public final void b(PaymentMethod paymentmethod)
    {
        c(false);
    }

    public final int e()
    {
        if (k)
        {
            return 0x7f110001;
        } else
        {
            return super.e();
        }
    }

    public void finish()
    {
        super.finish();
    }

    public final void g()
    {
        f.a(j);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040031);
        if (getIntent().hasExtra("item"))
        {
            getIntent().getParcelableExtra("item");
            j = getIntent().getDoubleExtra("price", -1D);
        }
        k = getIntent().getBooleanExtra("fromChat", false);
        if (k)
        {
            bundle = getSupportActionBar();
            bundle.setHomeButtonEnabled(false);
            bundle.setDisplayShowHomeEnabled(false);
            bundle.setDisplayHomeAsUpEnabled(false);
            bundle.setDisplayUseLogoEnabled(false);
        }
        if (e.q())
        {
            c(true);
            return;
        } else
        {
            bundle = new Bundle();
            bundle.putBoolean("fromChat", k);
            k k1 = new k();
            k1.setArguments(bundle);
            getSupportFragmentManager().a().a(0x7f100114, k1, "Cards").b();
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755393: 
            finish();
            break;
        }
        return true;
    }
}
