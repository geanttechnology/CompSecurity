// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.model.auth;

import com.amazon.mShop.control.GenericSubscriber;

public interface UserSubscriber
    extends GenericSubscriber
{
    public static interface Callback
    {

        public abstract void userCancelledSignIn();

        public abstract void userSuccessfullySignedIn();
    }


    public abstract void onRequiresUserLogin(Callback callback);
}
