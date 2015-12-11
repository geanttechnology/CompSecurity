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
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzh

public class ListSubscriptionsResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private final Status zzSC;
    private final List zzatk;

    ListSubscriptionsResult(int i, List list, Status status)
    {
        mVersionCode = i;
        zzatk = list;
        zzSC = status;
    }

    public ListSubscriptionsResult(List list, Status status)
    {
        mVersionCode = 3;
        zzatk = Collections.unmodifiableList(list);
        zzSC = (Status)zzx.zzb(status, "status");
    }

    public static ListSubscriptionsResult zzS(Status status)
    {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listsubscriptionsresult)
    {
        return zzSC.equals(listsubscriptionsresult.zzSC) && zzw.equal(zzatk, listsubscriptionsresult.zzatk);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult)obj);
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public List getSubscriptions()
    {
        return zzatk;
    }

    public List getSubscriptions(DataType datatype)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzatk.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Subscription subscription = (Subscription)iterator.next();
            if (datatype.equals(subscription.zzsC()))
            {
                arraylist.add(subscription);
            }
        } while (true);
        return Collections.unmodifiableList(arraylist);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzSC, zzatk
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("subscriptions", zzatk).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}
