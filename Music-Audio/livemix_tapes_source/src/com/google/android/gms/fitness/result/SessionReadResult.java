// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzj

public class SessionReadResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    private final int mVersionCode;
    private final Status zzQA;
    private final List zzapH;
    private final List zzaqO;

    SessionReadResult(int i, List list, List list1, Status status)
    {
        mVersionCode = i;
        zzapH = list;
        zzaqO = Collections.unmodifiableList(list1);
        zzQA = status;
    }

    public SessionReadResult(List list, List list1, Status status)
    {
        mVersionCode = 3;
        zzapH = list;
        zzaqO = Collections.unmodifiableList(list1);
        zzQA = status;
    }

    public static SessionReadResult zzU(Status status)
    {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionreadresult)
    {
        return zzQA.equals(sessionreadresult.zzQA) && zzw.equal(zzapH, sessionreadresult.zzapH) && zzw.equal(zzaqO, sessionreadresult.zzaqO);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionReadResult) && zzb((SessionReadResult)obj);
    }

    public List getDataSet(Session session)
    {
        zzx.zzb(zzapH.contains(session), "Attempting to read data for session %s which was not returned", new Object[] {
            session
        });
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzaqO.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SessionDataSet sessiondataset = (SessionDataSet)iterator.next();
            if (zzw.equal(session, sessiondataset.getSession()))
            {
                arraylist.add(sessiondataset.zzrO());
            }
        } while (true);
        return arraylist;
    }

    public List getDataSet(Session session, DataType datatype)
    {
        zzx.zzb(zzapH.contains(session), "Attempting to read data for session %s which was not returned", new Object[] {
            session
        });
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzaqO.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SessionDataSet sessiondataset = (SessionDataSet)iterator.next();
            if (zzw.equal(session, sessiondataset.getSession()) && datatype.equals(sessiondataset.zzrO().getDataType()))
            {
                arraylist.add(sessiondataset.zzrO());
            }
        } while (true);
        return arraylist;
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
            zzQA, zzapH, zzaqO
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("sessions", zzapH).zzg("sessionDataSets", zzaqO).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

    public List zzsG()
    {
        return zzaqO;
    }

}
