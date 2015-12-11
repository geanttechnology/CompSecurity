// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzx

public class SessionStartRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.fitness.request.zzx();
    private final int mVersionCode;
    private final Session zzapP;
    private final zzoj zzasb;

    SessionStartRequest(int i, Session session, IBinder ibinder)
    {
        mVersionCode = i;
        zzapP = session;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public SessionStartRequest(Session session, zzoj zzoj1)
    {
        zzx.zzb(session.isOngoing(), "Cannot start a session which has already ended");
        mVersionCode = 3;
        zzapP = session;
        zzasb = zzoj1;
    }

    private boolean zzb(SessionStartRequest sessionstartrequest)
    {
        return zzw.equal(zzapP, sessionstartrequest.zzapP);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof SessionStartRequest) && zzb((SessionStartRequest)obj);
    }

    public Session getSession()
    {
        return zzapP;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapP
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("session", zzapP).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzx.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

}
