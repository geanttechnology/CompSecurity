// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.c;

import com.google.a.a.b;
import com.google.a.a.g;
import com.google.a.b.e;
import com.google.a.b.h;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.model.product.interfaces.ProductDetails;

public class a
{

    private static final String ATT_PHONE_PLAN_DPCI_MATCH_PREFIX = "255-02";
    private static final b getDpci = new b() {

        public com.google.a.a.e a(ProductDetails productdetails)
        {
            return productdetails.e();
        }

        public volatile Object a(Object obj)
        {
            return a((ProductDetails)obj);
        }

    };
    private static final g isPhoneWithPlanOptions = new g() {

        public boolean a(com.google.a.a.e e1)
        {
            return e1.b() && ((Dpci)e1.c()).b().startsWith("255-02");
        }

        public volatile boolean a(Object obj)
        {
            return a((com.google.a.a.e)obj);
        }

    };

    public static com.target.ui.common.a a(ProductDetails productdetails)
    {
        com.target.ui.common.a a1 = new com.target.ui.common.a();
        if (e.a(h.a(productdetails)).b(productdetails.E()).a(getDpci).c(isPhoneWithPlanOptions).b())
        {
            a1.a(true);
            a1.a("http://img1.targetimg1.com/wcsstore/marketing/com/mobile/en/html/spot/phone-charts/atnt.html");
        }
        return a1;
    }

}
