// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ao;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.ProductBrand;
import com.cyberlink.beautycircle.model.ProductPrice;
import com.cyberlink.beautycircle.model.ProductType;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public class q extends com.cyberlink.beautycircle.controller.adapter.m
{

    public ProductBrand a;
    public ProductPrice b;
    public ProductType c;
    public String d;
    private Activity e;
    private boolean f;

    public q(Activity activity, ViewGroup viewgroup, int i, n n)
    {
        super(activity, viewgroup, i, 20, n);
        a = ProductBrand.b();
        b = ProductPrice.b();
        c = ProductType.b();
        f = false;
        if (activity == null)
        {
            throw new NullPointerException("The first parameter cannot be null");
        } else
        {
            e = activity;
            return;
        }
    }

    static Activity a(q q1)
    {
        return q1.e;
    }

    protected void a(Product product)
    {
    }

    protected void a(Product product, View view)
    {
        if (product != null && view != null)
        {
            Object obj = view.findViewById(j.product_info_bar);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
            }
            obj = (UICImageView)view.findViewById(j.product_thumb);
            if (obj != null && product.imgThumbnail != null)
            {
                ((UICImageView) (obj)).setImageURI(Uri.parse(product.imgThumbnail));
            }
            obj = (TextView)view.findViewById(j.product_name);
            if (obj != null)
            {
                ((TextView) (obj)).setText(product.displayTitle);
            }
            obj = (TextView)view.findViewById(j.product_description);
            if (obj != null)
            {
                ((TextView) (obj)).setText(product.description);
            }
            obj = (RatingBar)view.findViewById(j.product_rating_star);
            if (obj != null)
            {
                ((RatingBar) (obj)).setRating(product.rating);
            }
            obj = (TextView)view.findViewById(j.product_rating_count);
            if (obj != null)
            {
                ((TextView) (obj)).setTag(Integer.valueOf(product.commentCount));
                ((TextView) (obj)).setText(String.format(Locale.getDefault(), "(%d)", new Object[] {
                    Integer.valueOf(product.commentCount)
                }));
            }
            obj = (TextView)view.findViewById(j.product_price);
            if (obj != null)
            {
                ((TextView) (obj)).setText(product.recommendedPrice);
            }
            obj = (TextView)view.findViewById(j.product_brand);
            if (obj != null)
            {
                ((TextView) (obj)).setText(product.brandName);
            }
            view = (TextView)view.findViewById(j.product_category);
            if (view != null && product.typeName != null)
            {
                StringBuilder stringbuilder = new StringBuilder();
                String s;
                for (product = product.typeName.iterator(); product.hasNext(); stringbuilder.append(s))
                {
                    s = (String)product.next();
                    if (stringbuilder.length() != 0)
                    {
                        stringbuilder.append(" | ");
                    }
                }

                view.setText(stringbuilder);
                return;
            }
        }
    }

    protected void a(Model model)
    {
        b((Product)model);
    }

    protected volatile void a(Model model, View view)
    {
        a((Product)model, view);
    }

    protected d b(int i, int k)
    {
        Object obj = new com.perfectcorp.utility.j() {

            final q a;

            protected d a(d d2)
            {
                return d2;
            }

            protected volatile Object a(Object obj1)
            {
                return a((d)obj1);
            }

            protected void a(int l)
            {
                super.a(l);
                if (q.a(a) != null && (q.a(a) instanceof MainActivity) && l != 0)
                {
                    ((BaseActivity)q.a(a)).a(q.a(a).getString(m.bc_server_connect_fail), 3000);
                }
            }

            
            {
                a = q.this;
                super();
            }
        };
        if (d != null) goto _L2; else goto _L1
_L1:
        d d1 = (d)r.a(i, k, a.id, c.typeId, b.id, (int)b.priceMin, (int)b.priceMax).a(((com.perfectcorp.utility.j) (obj))).d();
        if (b.priceMin <= 0.0D && b.priceMax <= 0.0D && c.typeId <= 0L && a.id <= 0L) goto _L4; else goto _L3
_L3:
        if (b.priceMin != -1D || b.priceMax != -1D) goto _L6; else goto _L5
_L5:
        obj = "All Prices";
_L16:
        if (c.typeId != -1L) goto _L8; else goto _L7
_L7:
        String s = "All Categories";
_L12:
        if (a.id != -1L) goto _L10; else goto _L9
_L9:
        String s1 = "All Brands";
_L13:
        com.perfectcorp.a.b.a(new ao(s, ((String) (obj)), s1, AccountManager.a()));
        return d1;
_L6:
        Exception exception;
        try
        {
            obj = b.toString();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            obj = d1;
        }
          goto _L11
_L8:
        s = c.toString();
          goto _L12
_L10:
        s1 = a.toString();
          goto _L13
_L2:
        obj = (d)r.a(i, k, d).a(((com.perfectcorp.utility.j) (obj))).d();
        return ((d) (obj));
        exception;
        obj = null;
_L14:
        com.perfectcorp.utility.e.e(new Object[] {
            exception
        });
        return ((d) (obj));
_L11:
        if (true) goto _L14; else goto _L4
_L4:
        return d1;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public void b()
    {
        a = ProductBrand.b();
        b = ProductPrice.b();
        c = ProductType.b();
    }

    protected void b(Product product)
    {
        if (product != null)
        {
            if (f)
            {
                if (e != null)
                {
                    Intent intent = new Intent();
                    intent.putExtra("ProductId", product.productId);
                    e.setResult(-1, intent);
                    ((BaseActivity)e).f();
                    return;
                }
            } else
            {
                com.cyberlink.beautycircle.c.a(e, product.productId);
                return;
            }
        }
    }

    protected void b(Model model)
    {
        a((Product)model);
    }

    public void b(boolean flag)
    {
        f = flag;
    }
}
