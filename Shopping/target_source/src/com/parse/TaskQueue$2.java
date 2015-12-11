// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            TaskQueue

static final class >
    implements i
{

    final j val$toAwait;

    public j then(final j task)
        throws Exception
    {
        return val$toAwait.b(new i() {

            final TaskQueue._cls2 this$0;
            final j val$task;

            public j then(j j1)
                throws Exception
            {
                return task;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = TaskQueue._cls2.this;
                task = j1;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    >(j j1)
    {
        val$toAwait = j1;
        super();
    }
}
