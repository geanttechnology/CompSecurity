// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.query:
//            a, Filter

public class Query
    implements SafeParcelable
{
    public static class Builder
    {

        private String rP;
        private final List rQ = new ArrayList();

        public Builder addFilter(Filter filter)
        {
            rQ.add(filter);
            return this;
        }

        public Query build()
        {
            return new Query(new LogicalFilter(Operator.si, rQ), rP);
        }

        public Builder setPageToken(String s)
        {
            rP = s;
            return this;
        }

        public Builder()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    final int kg;
    LogicalFilter rO;
    String rP;

    Query(int i, LogicalFilter logicalfilter, String s)
    {
        kg = i;
        rO = logicalfilter;
        rP = s;
    }

    Query(LogicalFilter logicalfilter, String s)
    {
        this(1, logicalfilter, s);
    }

    public int describeContents()
    {
        return 0;
    }

    public Filter getFilter()
    {
        return rO;
    }

    public String getPageToken()
    {
        return rP;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        a.a(this, parcel, i);
    }

}
