// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.model.auth.UserSubscriber;
import java.util.List;

public interface AmazonPointsSummarySubscriber
    extends UserSubscriber
{

    public abstract void onReceiveAmazonPointsSummary(List list);
}
