// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.fullTask
    implements i
{

    final List val$childTasks;
    final j val$fullTask;

    public j then(j j)
        throws Exception
    {
        val$childTasks.add(j);
        return val$fullTask;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    (List list, j j)
    {
        val$childTasks = list;
        val$fullTask = j;
        super();
    }
}
