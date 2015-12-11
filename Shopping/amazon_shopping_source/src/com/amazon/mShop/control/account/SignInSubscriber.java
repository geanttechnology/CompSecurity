// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.rio.j2me.client.services.mShop.Notification;

public interface SignInSubscriber
    extends GenericSubscriber
{

    public abstract void onSignInCompleted(boolean flag, Notification notification);
}
