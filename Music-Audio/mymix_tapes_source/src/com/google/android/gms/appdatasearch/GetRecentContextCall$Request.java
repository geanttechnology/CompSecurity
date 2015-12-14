// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            GetRecentContextCall, zzf

public static class <init>
    implements SafeParcelable
{
    public static final class zza
    {

        private Account zzPq;
        private boolean zzPr;
        private boolean zzPs;
        private boolean zzPt;
        private String zzPu;

        public zza zzL(boolean flag)
        {
            zzPs = flag;
            return this;
        }

        public zza zzbw(String s)
        {
            zzPu = s;
            return this;
        }

        public GetRecentContextCall.Request zzlb()
        {
            return new GetRecentContextCall.Request(zzPq, zzPr, zzPs, zzPt, zzPu);
        }

        public zza()
        {
        }
    }


    public static final zzf CREATOR = new zzf();
    final int mVersionCode;
    public final Account zzPl;
    public final boolean zzPm;
    public final boolean zzPn;
    public final boolean zzPo;
    public final String zzPp;

    public int describeContents()
    {
        zzf zzf1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf zzf1 = CREATOR;
        zzf.zza(this, parcel, i);
    }


    public zza()
    {
        this(null, false, false, false, null);
    }

    <init>(int i, Account account, boolean flag, boolean flag1, boolean flag2, String s)
    {
        mVersionCode = i;
        zzPl = account;
        zzPm = flag;
        zzPn = flag1;
        zzPo = flag2;
        zzPp = s;
    }

    public zzPp(Account account, boolean flag, boolean flag1, boolean flag2, String s)
    {
        this(1, account, flag, flag1, flag2, s);
    }
}
