// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzk

public class SessionStopResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final int mVersionCode;
    private final Status zzSC;
    private final List zzase;

    SessionStopResult(int i, Status status, List list)
    {
        mVersionCode = i;
        zzSC = status;
        zzase = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List list)
    {
        mVersionCode = 3;
        zzSC = status;
        zzase = Collections.unmodifiableList(list);
    }

    public static SessionStopResult zzU(Status status)
    {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionstopresult)
    {
        return zzSC.equals(sessionstopresult.zzSC) && zzw.equal(zzase, sessionstopresult.zzase);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionStopResult) && zzb((SessionStopResult)obj);
    }

    public List getSessions()
    {
        return zzase;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzSC, zzase
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("sessions", zzase).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}
