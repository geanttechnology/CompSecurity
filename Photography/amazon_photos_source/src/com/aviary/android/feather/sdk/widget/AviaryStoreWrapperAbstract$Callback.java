// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.aviary.android.feather.cds.billing.util.Purchase;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryStoreWrapperAbstract

public static interface 
{

    public abstract void onDownloadStatusChanged(long l, String s, int i);

    public abstract void onPackInstalled(long l, String s, int i);

    public abstract void onPurchaseSuccess(long l, String s, Purchase purchase);

    public abstract void onServiceFinished();

    public abstract void onSubscriptionPurchased(String s, int i);
}
