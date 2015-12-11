// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.signin.internal:
//            AuthAccountResult

public interface zze
    extends IInterface
{

    public abstract void zza(ConnectionResult connectionresult, AuthAccountResult authaccountresult);

    public abstract void zza(Status status, GoogleSignInAccount googlesigninaccount);

    public abstract void zzbd(Status status);

    public abstract void zzbe(Status status);
}
