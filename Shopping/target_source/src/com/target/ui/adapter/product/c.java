// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import android.widget.Button;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.util.o;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.i.c.b;
import com.target.ui.service.k;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.f.a;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.product.PlpFulfillmentOverflowView;
import com.target.ui.view.product.PlpFulfillmentView;
import com.target.ui.view.product.PlpGridPriceView;
import com.target.ui.view.product.ProductDialogPriceView;
import com.target.ui.view.product.ProductEyebrowView;
import com.target.ui.view.product.ProductPriceView;
import java.net.URL;
import java.util.List;

public class c
{

    private static ProductFulfillmentOptions a(ProductDetails productdetails)
    {
        boolean flag = false;
        if (k.a().c().b())
        {
            flag = ((RelevantStoreSummary)k.a().c().c()).a();
        }
        return b.b(productdetails, flag);
    }

    private static com.target.ui.common.b a(ProductDetails productdetails, com.target.ui.i.c.a a1, String s)
    {
        boolean flag = false;
        if (k.a().c().b())
        {
            flag = ((RelevantStoreSummary)k.a().c().c()).a();
        }
        return com.target.ui.i.c.c.a(productdetails, flag, a1, s);
    }

    private static void a(View view, boolean flag)
    {
        if (flag)
        {
            aj.f(view);
            return;
        } else
        {
            al.b(view);
            return;
        }
    }

    public static void a(Button button, ProductDetails productdetails, boolean flag)
    {
        if (button == null || productdetails == null)
        {
            return;
        }
        productdetails = a(productdetails);
        boolean flag1;
        if (productdetails.e() && productdetails.l())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            a(((View) (button)), flag);
            return;
        } else
        {
            al.c(button);
            return;
        }
    }

    public static void a(BitmapImageView bitmapimageview, int i, ProductDetails productdetails)
    {
        if (bitmapimageview == null || productdetails == null)
        {
            return;
        }
        if (productdetails.r().b())
        {
            if (((ProductImage)productdetails.r().c()).b().b())
            {
                productdetails = ((URL)((ProductImage)productdetails.r().c()).a(i).c()).toString();
            } else
            {
                productdetails = ((ProductImage)productdetails.r().c()).b(i).toString();
            }
            com.target.ui.adapter.b.c.a(bitmapimageview.getContext(), productdetails, bitmapimageview);
        } else
        {
            bitmapimageview.setImageResource(0x7f0201ae);
        }
        al.b(bitmapimageview);
    }

    public static void a(PlpFulfillmentOverflowView plpfulfillmentoverflowview, AisleBadgeView aislebadgeview, ProductDetails productdetails)
    {
        if (plpfulfillmentoverflowview == null || productdetails == null)
        {
            return;
        }
        productdetails = a(productdetails);
        al.b(plpfulfillmentoverflowview);
        plpfulfillmentoverflowview.a(productdetails);
        if (productdetails.g())
        {
            if (o.g(productdetails.t()))
            {
                aislebadgeview.setAisle(productdetails.t());
            } else
            {
                aislebadgeview.setDepartment(com.target.ui.util.f.a.a(productdetails.x()));
            }
            al.b(aislebadgeview);
            return;
        } else
        {
            al.c(aislebadgeview);
            return;
        }
    }

    public static void a(PlpFulfillmentView plpfulfillmentview, ProductDetails productdetails)
    {
        if (plpfulfillmentview == null || productdetails == null)
        {
            return;
        }
        boolean flag = false;
        if (k.a().c().b())
        {
            flag = ((RelevantStoreSummary)k.a().c().c()).a();
        }
        plpfulfillmentview.a(b.a(productdetails, flag));
    }

    public static void a(PlpGridPriceView plpgridpriceview, ProductDetails productdetails)
    {
        if (plpgridpriceview == null || productdetails == null)
        {
            return;
        }
        com.target.ui.i.c.a a1;
        if (productdetails.I() || !productdetails.A().isEmpty())
        {
            a1 = com.target.ui.i.c.a.REGULAR;
        } else
        {
            a1 = com.target.ui.i.c.a.SHORT;
        }
        productdetails = a(productdetails, a1, ((String) (null)));
        productdetails.d(false);
        productdetails.c(false);
        plpgridpriceview.setPriceData(productdetails);
    }

    public static void a(ProductDialogPriceView productdialogpriceview, ProductDetails productdetails)
    {
        if (productdialogpriceview == null)
        {
            return;
        }
        productdetails = a(productdetails, com.target.ui.i.c.a.REGULAR, ((String) (null)));
        if (!o.g(productdetails.e()))
        {
            al.c(productdialogpriceview);
            return;
        } else
        {
            productdialogpriceview.setPrice(productdetails.e());
            al.b(productdialogpriceview);
            return;
        }
    }

    public static void a(ProductPriceView productpriceview, ProductEyebrowView producteyebrowview, ProductDetails productdetails)
    {
        if (productpriceview == null || producteyebrowview == null || productdetails == null)
        {
            return;
        }
        com.target.ui.i.c.a a1;
        if (productdetails.I() || !productdetails.A().isEmpty())
        {
            a1 = com.target.ui.i.c.a.REGULAR;
        } else
        {
            a1 = com.target.ui.i.c.a.SHORT;
        }
        productdetails = a(productdetails, a1, ((String) (null)));
        productpriceview.setPriceData(productdetails);
        producteyebrowview.setEyebrowData(productdetails);
    }
}
