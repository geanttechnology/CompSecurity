// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseCloud

static final class 
    implements Continuation
{

    public Object then(Task task)
        throws Exception
    {
        return ParseCloud.access$000(task.getResult());
    }

    ()
    {
    }
}
