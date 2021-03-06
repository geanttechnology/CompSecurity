// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            f

public class SessionReadResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new f();
    private final int BR;
    private final Status CM;
    private final List UZ;
    private final List Ul;

    SessionReadResult(int i, List list, List list1, Status status)
    {
        BR = i;
        Ul = list;
        UZ = Collections.unmodifiableList(list1);
        CM = status;
    }

    public SessionReadResult(List list, List list1, Status status)
    {
        BR = 3;
        Ul = list;
        UZ = Collections.unmodifiableList(list1);
        CM = status;
    }

    public static SessionReadResult H(Status status)
    {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean b(SessionReadResult sessionreadresult)
    {
        return CM.equals(sessionreadresult.CM) && n.equal(Ul, sessionreadresult.Ul) && n.equal(UZ, sessionreadresult.UZ);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SessionReadResult) && b((SessionReadResult)obj);
    }

    public List getDataSet(Session session)
    {
        o.b(Ul.contains(session), "Attempting to read data for session %s which was not returned", new Object[] {
            session
        });
        ArrayList arraylist = new ArrayList();
        Iterator iterator = UZ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            q q1 = (q)iterator.next();
            if (n.equal(session, q1.getSession()))
            {
                arraylist.add(q1.iW());
            }
        } while (true);
        return arraylist;
    }

    public List getDataSet(Session session, DataType datatype)
    {
        o.b(Ul.contains(session), "Attempting to read data for session %s which was not returned", new Object[] {
            session
        });
        ArrayList arraylist = new ArrayList();
        Iterator iterator = UZ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            q q1 = (q)iterator.next();
            if (n.equal(session, q1.getSession()) && datatype.equals(q1.iW().getDataType()))
            {
                arraylist.add(q1.iW());
            }
        } while (true);
        return arraylist;
    }

    public List getSessions()
    {
        return Ul;
    }

    public Status getStatus()
    {
        return CM;
    }

    int getVersionCode()
    {
        return BR;
    }

    public int hashCode()
    {
        return n.hashCode(new Object[] {
            CM, Ul, UZ
        });
    }

    public List jL()
    {
        return UZ;
    }

    public String toString()
    {
        return n.h(this).a("status", CM).a("sessions", Ul).a("sessionDataSets", UZ).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        f.a(this, parcel, i);
    }

}
