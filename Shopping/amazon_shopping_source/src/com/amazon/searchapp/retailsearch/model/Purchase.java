// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Image, Link, ShippingStatus

public interface Purchase
{

    public abstract String getBuyingPrice();

    public abstract String getDate();

    public abstract Image getImage();

    public abstract Link getLink();

    public abstract ShippingStatus getPrime();

    public abstract String getTitle();
}
