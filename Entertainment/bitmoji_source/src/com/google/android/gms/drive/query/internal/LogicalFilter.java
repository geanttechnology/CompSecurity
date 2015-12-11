// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            f, FilterHolder, Operator

public class LogicalFilter
    implements SafeParcelable, Filter
{

    public static final android.os.Parcelable.Creator CREATOR = new f();
    private List EN;
    final Operator EO;
    final List EY;
    final int wj;

    LogicalFilter(int i, Operator operator, List list)
    {
        wj = i;
        EO = operator;
        EY = list;
    }

    public transient LogicalFilter(Operator operator, Filter filter, Filter afilter[])
    {
        wj = 1;
        EO = operator;
        EY = new ArrayList(afilter.length + 1);
        EY.add(new FilterHolder(filter));
        EN = new ArrayList(afilter.length + 1);
        EN.add(filter);
        int j = afilter.length;
        for (int i = 0; i < j; i++)
        {
            operator = afilter[i];
            EY.add(new FilterHolder(operator));
            EN.add(operator);
        }

    }

    public LogicalFilter(Operator operator, Iterable iterable)
    {
        wj = 1;
        EO = operator;
        EN = new ArrayList();
        EY = new ArrayList();
        for (operator = iterable.iterator(); operator.hasNext(); EY.add(new FilterHolder(iterable)))
        {
            iterable = (Filter)operator.next();
            EN.add(iterable);
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        f.a(this, parcel, i);
    }

}
