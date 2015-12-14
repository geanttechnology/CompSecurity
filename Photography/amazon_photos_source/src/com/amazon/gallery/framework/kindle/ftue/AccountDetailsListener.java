// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import com.amazon.gallery.framework.network.http.rest.account.AccountDetails;

public interface AccountDetailsListener
{

    public abstract void onAccountDetailsReceived(AccountDetails accountdetails);
}
