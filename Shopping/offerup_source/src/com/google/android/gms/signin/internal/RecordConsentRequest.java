// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.signin.internal:
//            zzg

public class RecordConsentRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    final int mVersionCode;
    private final Account zzQd;
    private final String zzTl;
    private final Scope zzaVk[];

    RecordConsentRequest(int i, Account account, Scope ascope[], String s)
    {
        mVersionCode = i;
        zzQd = account;
        zzaVk = ascope;
        zzTl = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public Account getAccount()
    {
        return zzQd;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

    public Scope[] zzCj()
    {
        return zzaVk;
    }

    public String zzmb()
    {
        return zzTl;
    }

}
