// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;

public interface UserPreferences
{

    public abstract Authentication getAuthentication();

    public abstract EbayCountry getCurrentCountry();

    public abstract String getCurrentUser();
}
