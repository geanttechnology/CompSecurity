// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzh, zza, IAccountAccessor

public class GetServiceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int a;
    final int b;
    int c;
    String d;
    IBinder e;
    Scope f[];
    Bundle g;
    Account h;

    public GetServiceRequest(int i)
    {
        a = 2;
        c = GooglePlayServicesUtil.a;
        b = i;
    }

    GetServiceRequest(int i, int j, int k, String s, IBinder ibinder, Scope ascope[], Bundle bundle, 
            Account account)
    {
        a = i;
        b = j;
        c = k;
        d = s;
        if (i < 2)
        {
            h = a(ibinder);
        } else
        {
            e = ibinder;
            h = account;
        }
        f = ascope;
        g = bundle;
    }

    private Account a(IBinder ibinder)
    {
        Account account = null;
        if (ibinder != null)
        {
            account = zza.a(IAccountAccessor.zza.a(ibinder));
        }
        return account;
    }

    public GetServiceRequest a(Account account)
    {
        h = account;
        return this;
    }

    public GetServiceRequest a(Bundle bundle)
    {
        g = bundle;
        return this;
    }

    public GetServiceRequest a(IAccountAccessor iaccountaccessor)
    {
        if (iaccountaccessor != null)
        {
            e = iaccountaccessor.asBinder();
        }
        return this;
    }

    public GetServiceRequest a(String s)
    {
        d = s;
        return this;
    }

    public GetServiceRequest a(Collection collection)
    {
        f = (Scope[])collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.a(this, parcel, i);
    }

}
