// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            ShippingStatus

public interface Shipping
{

    public abstract ShippingStatus getAddOn();

    public abstract List getAdditionalStatus();

    public abstract ShippingStatus getCod();

    public abstract ShippingStatus getFba();

    public abstract List getMessage();

    public abstract boolean getPreOrder();

    public abstract List getPriceLabel();

    public abstract ShippingStatus getPrime();

    public abstract List getSss();

    public abstract void setAddOn(ShippingStatus shippingstatus);

    public abstract void setAdditionalStatus(List list);

    public abstract void setCod(ShippingStatus shippingstatus);

    public abstract void setFba(ShippingStatus shippingstatus);

    public abstract void setMessage(List list);

    public abstract void setPreOrder(boolean flag);

    public abstract void setPriceLabel(List list);

    public abstract void setPrime(ShippingStatus shippingstatus);

    public abstract void setSss(List list);
}
