// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.auth.api.consent:
//            zzb

public class GetConsentIntentRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final Account zzQd;
    private final String zzSb;
    private final int zzSc;
    private final String zzSd;
    final ScopeDetail zzSe[];
    private final boolean zzSf;
    private final int zzSg;

    GetConsentIntentRequest(int i, String s, int j, String s1, Account account, ScopeDetail ascopedetail[], boolean flag, 
            int k)
    {
        mVersionCode = i;
        zzSb = s;
        zzSc = j;
        zzSd = s1;
        zzQd = (Account)zzx.zzw(account);
        zzSe = ascopedetail;
        zzSf = flag;
        zzSg = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public Account getAccount()
    {
        return zzQd;
    }

    public String getCallingPackage()
    {
        return zzSb;
    }

    public int getCallingUid()
    {
        return zzSc;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public String zzlF()
    {
        return zzSd;
    }

    public boolean zzlG()
    {
        return zzSf;
    }

    public int zzlH()
    {
        return zzSg;
    }

}
