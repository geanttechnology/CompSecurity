// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzc, zzp

public class AuthAccountRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    final IBinder zzaeH;
    final Scope zzaeI[];

    AuthAccountRequest(int i, IBinder ibinder, Scope ascope[])
    {
        mVersionCode = i;
        zzaeH = ibinder;
        zzaeI = ascope;
    }

    public AuthAccountRequest(zzp zzp1, Set set)
    {
        this(1, zzp1.asBinder(), (Scope[])set.toArray(new Scope[set.size()]));
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
