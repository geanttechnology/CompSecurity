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
    final int kg;
    private List rQ;
    final Operator rR;
    final List sb;

    LogicalFilter(int i, Operator operator, List list)
    {
        kg = i;
        rR = operator;
        sb = list;
    }

    public transient LogicalFilter(Operator operator, Filter filter, Filter afilter[])
    {
        kg = 1;
        rR = operator;
        sb = new ArrayList(afilter.length + 1);
        sb.add(new FilterHolder(filter));
        rQ = new ArrayList(afilter.length + 1);
        rQ.add(filter);
        int j = afilter.length;
        for (int i = 0; i < j; i++)
        {
            operator = afilter[i];
            sb.add(new FilterHolder(operator));
            rQ.add(operator);
        }

    }

    public LogicalFilter(Operator operator, List list)
    {
        kg = 1;
        rR = operator;
        rQ = list;
        sb = new ArrayList(list.size());
        for (operator = list.iterator(); operator.hasNext(); sb.add(new FilterHolder(list)))
        {
            list = (Filter)operator.next();
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
