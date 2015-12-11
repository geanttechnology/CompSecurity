// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.product.handler.TGTProduct;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;

public class am
{

    public static Product a(WeeklyAdListingBase weeklyadlistingbase)
    {
        if (!weeklyadlistingbase.d().b())
        {
            return null;
        } else
        {
            TGTProduct tgtproduct = new TGTProduct();
            tgtproduct.a((Tcin)weeklyadlistingbase.d().c());
            tgtproduct.l(weeklyadlistingbase.a());
            return tgtproduct;
        }
    }
}
