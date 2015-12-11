// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.auth:
//            zzb

public class AccountChangeEventsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    final int mVersion;
    Account zzQd;
    String zzRs;
    int zzRu;

    public AccountChangeEventsRequest()
    {
        mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int j, String s, Account account)
    {
        mVersion = i;
        zzRu = j;
        zzRs = s;
        if (account == null && !TextUtils.isEmpty(s))
        {
            zzQd = new Account(s, "com.google");
            return;
        } else
        {
            zzQd = account;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Account getAccount()
    {
        return zzQd;
    }

    public String getAccountName()
    {
        return zzRs;
    }

    public int getEventIndex()
    {
        return zzRu;
    }

    public AccountChangeEventsRequest setAccount(Account account)
    {
        zzQd = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String s)
    {
        zzRs = s;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i)
    {
        zzRu = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
