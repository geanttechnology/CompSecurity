// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.order.OrderContainer;

public interface OrdersServiceMultiItemListener
{

    public abstract void onComplete();

    public abstract boolean onException(Exception exception);

    public abstract void onSuccess(OrderContainer ordercontainer);
}
