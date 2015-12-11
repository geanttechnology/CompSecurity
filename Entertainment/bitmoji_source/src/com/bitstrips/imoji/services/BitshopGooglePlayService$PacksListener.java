// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;


// Referenced classes of package com.bitstrips.imoji.services:
//            BitshopGooglePlayService

public static interface I
{

    public abstract void onErrorConnectingToGooglePlay();

    public abstract void onErrorPurchasingPack(int i);

    public abstract void onPacksSynced();
}
