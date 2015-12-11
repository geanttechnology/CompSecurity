// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            ErrorMessage, EcasShoppingCart

public class EcasShoppingCartResponse extends BaseApiResponse
{

    public ErrorMessage errorMessage;
    public List extensions;
    public EcasShoppingCart shoppingCart;

    public EcasShoppingCartResponse()
    {
    }
}
