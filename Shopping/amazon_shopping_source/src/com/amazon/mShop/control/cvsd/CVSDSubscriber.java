// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cvsd;

import com.amazon.mShop.control.GenericSubscriber;
import java.util.List;

public interface CVSDSubscriber
    extends GenericSubscriber
{

    public abstract void onDeliveryLocationsReceived(List list);

    public abstract void onOnlyMessageReceived(String s);

    public abstract void onRefinementsReceived();
}
