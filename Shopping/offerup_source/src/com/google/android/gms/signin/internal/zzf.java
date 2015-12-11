// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;

// Referenced classes of package com.google.android.gms.signin.internal:
//            zze, CheckServerAuthResult, RecordConsentRequest

public interface zzf
    extends IInterface
{

    public abstract void zza(int i, Account account, zze zze);

    public abstract void zza(AuthAccountRequest authaccountrequest, zze zze);

    public abstract void zza(ResolveAccountRequest resolveaccountrequest, zzt zzt);

    public abstract void zza(zzp zzp, int i, boolean flag);

    public abstract void zza(CheckServerAuthResult checkserverauthresult);

    public abstract void zza(RecordConsentRequest recordconsentrequest, zze zze);

    public abstract void zza(zze zze);

    public abstract void zzaq(boolean flag);

    public abstract void zzjq(int i);
}
