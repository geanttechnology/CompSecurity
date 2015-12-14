// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.model.Model;

public class ProductType extends Model
{

    public long typeId;
    public String typeName;

    public ProductType()
    {
    }

    public static ProductType b()
    {
        ProductType producttype = new ProductType();
        producttype.typeId = -1L;
        producttype.typeName = Globals.n().getString(m.bc_products_type);
        return producttype;
    }

    public String toString()
    {
        return typeName;
    }
}
