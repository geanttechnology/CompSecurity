// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.fullTask
    implements ct
{

    final List val$childTasks;
    final cu val$fullTask;

    public cu then(cu cu)
        throws Exception
    {
        val$childTasks.add(cu);
        return val$fullTask;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    (List list, cu cu)
    {
        val$childTasks = list;
        val$fullTask = cu;
        super();
    }
}
