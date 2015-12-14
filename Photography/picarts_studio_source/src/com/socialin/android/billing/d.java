// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.billing;

import android.app.Activity;
import android.content.Intent;
import myobfuscated.bp.a;
import myobfuscated.bp.b;
import myobfuscated.bp.c;

public interface d
{

    public abstract void getPurchasedItems(b b);

    public abstract void getShopItemPrice(Activity activity, Object obj, a a);

    public abstract boolean handleActivityResult(int i, int j, Intent intent);

    public abstract boolean isBillingSupported();

    public abstract void requestPurchase(Activity activity, String s, String s1, String s2, double d1, myobfuscated.bp.d d2);

    public abstract void requestShopItems(boolean flag, c c);

    public abstract void requestShopItemsForTypeAndTag(boolean flag, String s, String s1, c c, int i);
}
