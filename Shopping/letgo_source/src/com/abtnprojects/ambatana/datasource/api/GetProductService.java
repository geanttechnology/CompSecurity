// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import com.abtnprojects.ambatana.models.product.ApiProduct;
import retrofit.Callback;

public interface GetProductService
{

    public abstract ApiProduct getProduct(String s);

    public abstract void getProduct(String s, Callback callback);
}
