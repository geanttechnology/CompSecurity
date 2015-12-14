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
    private final Status zzQA;
    private final List zzaqN;

    ListSubscriptionsResult(int i, List list, Status status)
    {
        mVersionCode = i;
        zzaqN = list;
        zzQA = status;
    }

    public ListSubscriptionsResult(List list, Status status)
    {
        mVersionCode = 3;
        zzaqN = Collections.unmodifiableList(list);
        zzQA = (Status)zzx.zzb(status, "status");
    }

    public static ListSubscriptionsResult zzT(Status status)
    {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listsubscriptionsresult)
    {
        return zzQA.equals(listsubscriptionsresult.zzQA) && zzw.equal(zzaqN, listsubscriptionsresult.zzaqN);
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
        return zzQA;
    }

    public List getSubscriptions()
    {
        return zzaqN;
    }

    public List getSubscriptions(DataType datatype)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzaqN.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Subscription subscription = (Subscription)iterator.next();
            if (datatype.equals(subscription.zzrQ()))
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
            zzQA, zzaqN
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("subscriptions", zzaqN).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}
