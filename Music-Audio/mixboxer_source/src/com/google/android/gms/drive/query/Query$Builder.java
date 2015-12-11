// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.query:
//            Query, Filter

public static class tor
{

    private String rP;
    private final List rQ = new ArrayList();

    public tor addFilter(Filter filter)
    {
        rQ.add(filter);
        return this;
    }

    public Query build()
    {
        return new Query(new LogicalFilter(Operator.si, rQ), rP);
    }

    public rP setPageToken(String s)
    {
        rP = s;
        return this;
    }

    public tor()
    {
    }
}
