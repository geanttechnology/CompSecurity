// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzi, zza, zzp

public class GetServiceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    final int version;
    final int zzafq;
    int zzafr;
    String zzafs;
    IBinder zzaft;
    Scope zzafu[];
    Bundle zzafv;
    Account zzafw;

    public GetServiceRequest(int i)
    {
        version = 2;
        zzafr = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        zzafq = i;
    }

    GetServiceRequest(int i, int j, int k, String s, IBinder ibinder, Scope ascope[], Bundle bundle, 
            Account account)
    {
        version = i;
        zzafq = j;
        zzafr = k;
        zzafs = s;
        if (i < 2)
        {
            zzafw = zzaG(ibinder);
        } else
        {
            zzaft = ibinder;
            zzafw = account;
        }
        zzafu = ascope;
        zzafv = bundle;
    }

    private Account zzaG(IBinder ibinder)
    {
        Account account = null;
        if (ibinder != null)
        {
            account = zza.zzb(zzp.zza.zzaH(ibinder));
        }
        return account;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public GetServiceRequest zzc(Account account)
    {
        zzafw = account;
        return this;
    }

    public GetServiceRequest zzc(zzp zzp1)
    {
        if (zzp1 != null)
        {
            zzaft = zzp1.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzcl(String s)
    {
        zzafs = s;
        return this;
    }

    public GetServiceRequest zzd(Collection collection)
    {
        zzafu = (Scope[])collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzg(Bundle bundle)
    {
        zzafv = bundle;
        return this;
    }

}
