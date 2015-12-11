// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase, EcasShoppingCartDataManager, ShopcaseShoppingCartDataManager, UserContextObservingDataManager

public static final class serviceApi extends e
{

    protected final  serviceApi;

    protected ShoppingCartDataManagerBase create(EbayContext ebaycontext)
    {
        switch (ap.com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi[serviceApi.ordinal()])
        {
        default:
            return new EcasShoppingCartDataManager(ebaycontext, this);

        case 1: // '\001'
            return new ShopcaseShoppingCartDataManager(ebaycontext, this);
        }
    }

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (create)obj;
            if (serviceApi != ((serviceApi) (obj)).serviceApi)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return super.hashCode() * 31 + serviceApi.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("ShoppingCart [serviceApi=").append(serviceApi.name()).append("]").toString();
    }

    public ( )
    {
        serviceApi = ;
    }
}
