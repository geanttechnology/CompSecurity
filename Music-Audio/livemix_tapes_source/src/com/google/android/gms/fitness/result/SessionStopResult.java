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
    private final Status zzQA;
    private final List zzapH;

    SessionStopResult(int i, Status status, List list)
    {
        mVersionCode = i;
        zzQA = status;
        zzapH = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List list)
    {
        mVersionCode = 3;
        zzQA = status;
        zzapH = Collections.unmodifiableList(list);
    }

    public static SessionStopResult zzV(Status status)
    {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionstopresult)
    {
        return zzQA.equals(sessionstopresult.zzQA) && zzw.equal(zzapH, sessionstopresult.zzapH);
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
        return zzapH;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzQA, zzapH
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("sessions", zzapH).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}
