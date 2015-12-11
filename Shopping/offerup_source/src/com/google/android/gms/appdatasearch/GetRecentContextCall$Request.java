// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzf

public class <init>
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    final int mVersionCode;
    public final Account zzQq;
    public final boolean zzQr;
    public final boolean zzQs;
    public final boolean zzQt;
    public final String zzQu;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }


    public ()
    {
        this(null, false, false, false, null);
    }

    <init>(int i, Account account, boolean flag, boolean flag1, boolean flag2, String s)
    {
        mVersionCode = i;
        zzQq = account;
        zzQr = flag;
        zzQs = flag1;
        zzQt = flag2;
        zzQu = s;
    }

    public zzQu(Account account, boolean flag, boolean flag1, boolean flag2, String s)
    {
        this(1, account, flag, flag1, flag2, s);
    }
}
