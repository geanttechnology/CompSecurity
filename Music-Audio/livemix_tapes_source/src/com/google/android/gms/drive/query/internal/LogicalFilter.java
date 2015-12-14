// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            AbstractFilter, zzk, FilterHolder, zzf, 
//            Operator

public class LogicalFilter extends AbstractFilter
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    final int mVersionCode;
    final List zzalK;
    private List zzalq;
    final Operator zzalv;

    LogicalFilter(int i, Operator operator, List list)
    {
        mVersionCode = i;
        zzalv = operator;
        zzalK = list;
    }

    public transient LogicalFilter(Operator operator, Filter filter, Filter afilter[])
    {
        mVersionCode = 1;
        zzalv = operator;
        zzalK = new ArrayList(afilter.length + 1);
        zzalK.add(new FilterHolder(filter));
        zzalq = new ArrayList(afilter.length + 1);
        zzalq.add(filter);
        int j = afilter.length;
        for (int i = 0; i < j; i++)
        {
            operator = afilter[i];
            zzalK.add(new FilterHolder(operator));
            zzalq.add(operator);
        }

    }

    public LogicalFilter(Operator operator, Iterable iterable)
    {
        mVersionCode = 1;
        zzalv = operator;
        zzalq = new ArrayList();
        zzalK = new ArrayList();
        for (operator = iterable.iterator(); operator.hasNext(); zzalK.add(new FilterHolder(iterable)))
        {
            iterable = (Filter)operator.next();
            zzalq.add(iterable);
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    public Object zza(zzf zzf1)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = zzalK.iterator(); iterator.hasNext(); arraylist.add(((FilterHolder)iterator.next()).getFilter().zza(zzf1))) { }
        return zzf1.zzb(zzalv, arraylist);
    }

}
