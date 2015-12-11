// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;

public interface zzrm
    extends IInterface
{

    public abstract void zza(int i, FullWallet fullwallet, Bundle bundle);

    public abstract void zza(int i, MaskedWallet maskedwallet, Bundle bundle);

    public abstract void zza(int i, boolean flag, Bundle bundle);

    public abstract void zza(Status status, Bundle bundle);

    public abstract void zza(Status status, GetBuyFlowInitializationTokenResponse getbuyflowinitializationtokenresponse, Bundle bundle);

    public abstract void zza(Status status, GetInstrumentsResponse getinstrumentsresponse, Bundle bundle);

    public abstract void zzb(int i, boolean flag, Bundle bundle);

    public abstract void zzj(int i, Bundle bundle);
}
