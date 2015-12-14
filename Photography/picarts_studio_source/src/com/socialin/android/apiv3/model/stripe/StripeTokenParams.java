// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.stripe;

import com.socialin.android.apiv3.request.RequestParams;

public class StripeTokenParams extends RequestParams
{

    public String provider;
    public String tokenValue;

    public StripeTokenParams()
    {
    }
}
