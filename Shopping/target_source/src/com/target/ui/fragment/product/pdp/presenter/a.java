// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter;

import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.common.product.j;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.util.o;
import com.target.ui.helper.product.f;
import java.net.URL;
import java.util.List;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.product.f.a
{

    public static final String TAG = com/target/ui/fragment/product/pdp/presenter/a.getSimpleName();
    private final String PARAM_APP_TYPE = "&appType=android";
    private final String PARAM_TCIN = "&tcin=";
    private f mHtmlContentDataHelper;
    private com.target.ui.fragment.product.pdp.a.a mPresentation;
    private ProductDetails mSavedProductDetails;

    public a(ProductDetails productdetails, f f1)
    {
        mSavedProductDetails = productdetails;
        mHtmlContentDataHelper = f1;
    }

    private String a(Tcin tcin)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("http://m.target.com/mContent?type=NUTRITION_FACTS_FLAG");
        stringbuilder.append("&tcin=");
        stringbuilder.append(tcin.b());
        stringbuilder.append("&appType=android");
        return stringbuilder.toString();
    }

    private void b(ProductDetails productdetails)
    {
        if (!productdetails.k())
        {
            mPresentation.b();
            return;
        } else
        {
            mPresentation.a();
            return;
        }
    }

    private void c(ProductDetails productdetails)
    {
        if (productdetails.m().isEmpty())
        {
            mPresentation.c();
            return;
        } else
        {
            mPresentation.a(productdetails.m());
            return;
        }
    }

    private void d(ProductDetails productdetails)
    {
        productdetails = productdetails.b();
        if (!o.g(productdetails))
        {
            mPresentation.d();
            return;
        } else
        {
            mPresentation.a(Html.fromHtml(productdetails));
            return;
        }
    }

    private void e(ProductDetails productdetails)
    {
        if (productdetails.w().isEmpty())
        {
            mPresentation.e();
            return;
        } else
        {
            mPresentation.b(productdetails.w());
            return;
        }
    }

    private void f(ProductDetails productdetails)
    {
        mPresentation.a(productdetails.k_(), (Dpci)productdetails.e().d(), (Upc)productdetails.a().d());
    }

    private void g(ProductDetails productdetails)
    {
        if (productdetails.o().equals(j.APPLE) && productdetails.p().b())
        {
            h(productdetails);
        }
    }

    private void h(ProductDetails productdetails)
    {
        mHtmlContentDataHelper.a((URL)productdetails.p().c(), this);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900ca);
    }

    public void a(ProductDetails productdetails)
    {
        b(productdetails);
        c(productdetails);
        d(productdetails);
        e(productdetails);
        f(productdetails);
    }

    public void a(com.target.ui.fragment.product.pdp.a.a a1)
    {
        mPresentation = a1;
        a(mSavedProductDetails);
        g(mSavedProductDetails);
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.product.pdp.a.a)obj);
    }

    public void a(String s)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(s);
            return;
        }
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f();
            return;
        }
    }

    public void d()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f();
            return;
        }
    }

    public void e()
    {
        String s = a(mSavedProductDetails.k_());
        mPresentation.a(0x7f0900cb, s);
    }

    public void v_()
    {
        mHtmlContentDataHelper = null;
    }

    public void z_()
    {
        mPresentation = null;
    }

}
