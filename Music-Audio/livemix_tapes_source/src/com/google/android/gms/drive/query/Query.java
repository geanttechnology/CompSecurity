// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.query:
//            zza, SortOrder, Filter

public class Query
    implements SafeParcelable
{
    public static class Builder
    {

        private Set zzahr;
        private String zzalm;
        private SortOrder zzaln;
        private List zzalo;
        private boolean zzalp;
        private final List zzalq;

        public Builder addFilter(Filter filter)
        {
            if (!(filter instanceof MatchAllFilter))
            {
                zzalq.add(filter);
            }
            return this;
        }

        public Query build()
        {
            return new Query(new LogicalFilter(Operator.zzalR, zzalq), zzalm, zzaln, zzalo, zzalp, zzahr);
        }

        public Builder setPageToken(String s)
        {
            zzalm = s;
            return this;
        }

        public Builder setSortOrder(SortOrder sortorder)
        {
            zzaln = sortorder;
            return this;
        }

        public Builder()
        {
            zzalq = new ArrayList();
        }

        public Builder(Query query)
        {
            zzalq = new ArrayList();
            zzalq.add(query.getFilter());
            zzalm = query.getPageToken();
            zzaln = query.getSortOrder();
            zzalo = query.zzrd();
            zzalp = query.zzre();
            zzahr = query.zzrf();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final List zzahq;
    private final Set zzahr;
    final LogicalFilter zzall;
    final String zzalm;
    final SortOrder zzaln;
    final List zzalo;
    final boolean zzalp;

    Query(int i, LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, List list1)
    {
        Object obj;
        if (list1 == null)
        {
            obj = null;
        } else
        {
            obj = new HashSet(list1);
        }
        this(i, logicalfilter, s, sortorder, list, flag, list1, ((Set) (obj)));
    }

    private Query(int i, LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, List list1, 
            Set set)
    {
        mVersionCode = i;
        zzall = logicalfilter;
        zzalm = s;
        zzaln = sortorder;
        zzalo = list;
        zzalp = flag;
        zzahq = list1;
        zzahr = set;
    }

    private Query(LogicalFilter logicalfilter, String s, SortOrder sortorder, List list, boolean flag, Set set)
    {
        Object obj;
        if (set == null)
        {
            obj = null;
        } else
        {
            obj = new ArrayList(set);
        }
        this(1, logicalfilter, s, sortorder, list, flag, ((List) (obj)), set);
    }


    public int describeContents()
    {
        return 0;
    }

    public Filter getFilter()
    {
        return zzall;
    }

    public String getPageToken()
    {
        return zzalm;
    }

    public SortOrder getSortOrder()
    {
        return zzaln;
    }

    public String toString()
    {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[] {
            zzall, zzaln, zzalm, zzahq
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public List zzrd()
    {
        return zzalo;
    }

    public boolean zzre()
    {
        return zzalp;
    }

    public Set zzrf()
    {
        return zzahr;
    }

}
