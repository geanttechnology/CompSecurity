// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.fragment.PageProductsFragment;
import com.cyberlink.beautycircle.controller.fragment.s;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import java.util.UUID;

public class ProductsActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();

    public ProductsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        setContentView(k.bc_activity_products);
        obj = getIntent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        PageProductsFragment pageproductsfragment;
        boolean flag1;
        boolean flag = ((Intent) (obj)).getBooleanExtra("IsPickProduct", false);
        flag1 = ((Intent) (obj)).getBooleanExtra("IsListProduct", false);
        bundle = Long.valueOf(((Intent) (obj)).getLongExtra("brandId", PageProductsFragment.s.longValue()));
        Long long1 = Long.valueOf(((Intent) (obj)).getLongExtra("typeId", PageProductsFragment.s.longValue()));
        Long long2 = Long.valueOf(((Intent) (obj)).getLongExtra("priceRangeId", PageProductsFragment.s.longValue()));
        obj = ((Intent) (obj)).getStringExtra("locale");
        if (flag)
        {
            b(m.bc_select_products_title);
        } else
        {
            b(m.bc_products_title);
        }
        pageproductsfragment = (PageProductsFragment)getSupportFragmentManager().findFragmentById(j.fragment_main_panel);
        if (!flag) goto _L4; else goto _L3
_L3:
        pageproductsfragment.t = 2;
_L5:
        if (obj != null && (bundle != PageProductsFragment.s || long1 != PageProductsFragment.s || long2 != PageProductsFragment.s))
        {
            k();
            pageproductsfragment.a(bundle, long1, long2, ((String) (obj)), new s() {

                final ProductsActivity a;

                public void a()
                {
                    a.l();
                }

                public void b()
                {
                    a.l();
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_register_error_invalid_locale), null, null, a.getResources().getString(m.bc_dialog_button_ok), null);
                }

            
            {
                a = ProductsActivity.this;
                super();
            }
            });
        }
        pageproductsfragment.b(0);
        return;
_L4:
        if (flag1)
        {
            pageproductsfragment.t = 1;
        }
        if (true) goto _L5; else goto _L2
_L2:
        b(m.bc_products_title);
        return;
    }

}
