// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.UUID;

public class ProductInfoActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    private Product f;

    public ProductInfoActivity()
    {
    }

    static Product a(ProductInfoActivity productinfoactivity, Product product)
    {
        productinfoactivity.f = product;
        return product;
    }

    private void a(long l)
    {
        r.a(l, AccountManager.c()).a(new com.perfectcorp.utility.m(l) {

            final long a;
            final ProductInfoActivity b;

            protected void a()
            {
                if (e.a)
                {
                    Globals.b((new StringBuilder()).append("queryProdInfo(").append(a).append(") canceld!").toString());
                }
            }

            protected void a(int i)
            {
                if (e.a)
                {
                    Globals.b((new StringBuilder()).append("queryProdInfo(").append(a).append(") fail! error: ").append(Integer.toHexString(i)).toString());
                }
            }

            protected void a(d d1)
            {
                if (d1 == null || d1.a.intValue() <= 0)
                {
                    a(0x80000003);
                    return;
                } else
                {
                    ProductInfoActivity.a(b, (Product)d1.b.get(0));
                    ProductInfoActivity.a(b);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                b = ProductInfoActivity.this;
                a = l;
                super();
            }
        });
    }

    static void a(ProductInfoActivity productinfoactivity)
    {
        productinfoactivity.o();
    }

    static Product b(ProductInfoActivity productinfoactivity)
    {
        return productinfoactivity.f;
    }

    private void o()
    {
        if (f != null)
        {
            Object obj = (UICImageView)findViewById(com.cyberlink.beautycircle.j.productInfoImage);
            if (obj != null)
            {
                ((UICImageView) (obj)).setImageURI(Uri.parse(f.imgOriginal));
            }
            obj = (TextView)findViewById(com.cyberlink.beautycircle.j.productInfoTitle);
            if (obj != null)
            {
                ((TextView) (obj)).setText(f.displayTitle);
            }
            obj = (TextView)findViewById(com.cyberlink.beautycircle.j.productInfoDesc);
            if (obj != null)
            {
                ((TextView) (obj)).setText(f.description);
            }
            obj = findViewById(com.cyberlink.beautycircle.j.productInfoBuyBtn);
            if (obj != null && f.productStoreLink != null)
            {
                ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ProductInfoActivity a;

                    public void onClick(View view)
                    {
                        if (ProductInfoActivity.b(a).productStoreLink != null)
                        {
                            c.a(a, Uri.parse(ProductInfoActivity.b(a).productStoreLink));
                        }
                    }

            
            {
                a = ProductInfoActivity.this;
                super();
            }
                });
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_product_info);
        long l = getIntent().getLongExtra("ProductId", -1L);
        b(m.bc_products_title);
        a(l);
    }

}
