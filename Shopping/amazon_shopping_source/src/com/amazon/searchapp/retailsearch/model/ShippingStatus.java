// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface ShippingStatus
{

    public abstract String getBadgeAssetId();

    public abstract String getFreeRentalLabel();

    public abstract boolean getHasBadge();

    public abstract boolean getHasFreeRental();

    public abstract String getMessage();
}
