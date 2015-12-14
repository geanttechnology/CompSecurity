// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import android.content.Intent;
import java.util.Map;

public interface AppLovinEventService
{

    public abstract void trackCheckout(String s, Map map);

    public abstract void trackEvent(String s);

    public abstract void trackEvent(String s, Map map);

    public abstract void trackInAppPurchase(Intent intent, Map map);
}
