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
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzx

public class SessionStartRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.fitness.request.zzx();
    private final int mVersionCode;
    private final String zzOZ;
    private final Session zzanp;
    private final zznh zzapE;

    SessionStartRequest(int i, Session session, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzanp = session;
        if (ibinder == null)
        {
            session = null;
        } else
        {
            session = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = session;
        zzOZ = s;
    }

    public SessionStartRequest(Session session, zznh zznh1, String s)
    {
        zzx.zzb(session.isOngoing(), "Cannot start a session which has already ended");
        mVersionCode = 2;
        zzanp = session;
        zzapE = zznh1;
        zzOZ = s;
    }

    private boolean zzb(SessionStartRequest sessionstartrequest)
    {
        return zzw.equal(zzanp, sessionstartrequest.zzanp);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof SessionStartRequest) && zzb((SessionStartRequest)obj);
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    public Session getSession()
    {
        return zzanp;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanp
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("session", zzanp).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzx.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

}
