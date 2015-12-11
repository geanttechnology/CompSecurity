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

    public abstract boolean getPreOrder();

    public abstract ShippingStatus getPrime();

    public abstract List getSss();
}
