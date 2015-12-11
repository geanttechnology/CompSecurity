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

public static class zzalC
{

    private Set zzajB;
    private boolean zzalC;
    private String zzanL;
    private SortOrder zzanM;
    private List zzanN;
    private boolean zzanO;
    private final List zzanP;

    public zzalC addFilter(Filter filter)
    {
        if (!(filter instanceof MatchAllFilter))
        {
            zzanP.add(filter);
        }
        return this;
    }

    public Query build()
    {
        return new Query(new LogicalFilter(Operator.zzaor, zzanP), zzanL, zzanM, zzanN, zzanO, zzajB, zzalC, null);
    }

    public alFilter setPageToken(String s)
    {
        zzanL = s;
        return this;
    }

    public zzanL setSortOrder(SortOrder sortorder)
    {
        zzanM = sortorder;
        return this;
    }

    public tor()
    {
        zzanP = new ArrayList();
    }

    public zzanP(Query query)
    {
        zzanP = new ArrayList();
        zzanP.add(query.getFilter());
        zzanL = query.getPageToken();
        zzanM = query.getSortOrder();
        zzanN = query.zzrO();
        zzanO = query.zzrP();
        zzajB = query.zzrQ();
        zzalC = query.zzrR();
    }
}
