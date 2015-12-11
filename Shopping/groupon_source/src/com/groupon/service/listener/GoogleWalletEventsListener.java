// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.listener;

import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public interface GoogleWalletEventsListener
{

    public abstract void onFullWalletResponse(FullWallet fullwallet);

    public abstract void onMaskedWalletResponse(MaskedWallet maskedwallet, int i);
}
