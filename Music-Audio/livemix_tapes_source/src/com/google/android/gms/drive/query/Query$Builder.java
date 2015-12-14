// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.query:
//            Query, SortOrder, Filter

public static class zzahr
{

    private Set zzahr;
    private String zzalm;
    private SortOrder zzaln;
    private List zzalo;
    private boolean zzalp;
    private final List zzalq;

    public zzahr addFilter(Filter filter)
    {
        if (!(filter instanceof MatchAllFilter))
        {
            zzalq.add(filter);
        }
        return this;
    }

    public Query build()
    {
        return new Query(new LogicalFilter(Operator.zzalR, zzalq), zzalm, zzaln, zzalo, zzalp, zzahr, null);
    }

    public alFilter setPageToken(String s)
    {
        zzalm = s;
        return this;
    }

    public zzalm setSortOrder(SortOrder sortorder)
    {
        zzaln = sortorder;
        return this;
    }

    public tor()
    {
        zzalq = new ArrayList();
    }

    public zzalq(Query query)
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
