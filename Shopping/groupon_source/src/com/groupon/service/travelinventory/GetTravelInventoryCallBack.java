// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.travelinventory;

import com.groupon.models.travelinventory.TravelInventoryResponse;

public interface GetTravelInventoryCallBack
{

    public abstract void onSuccess(TravelInventoryResponse travelinventoryresponse)
        throws Exception;
}
