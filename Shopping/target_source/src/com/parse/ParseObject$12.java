// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class et
    implements i
{

    final ParseObject this$0;
    final ParseOperationSet val$operations;

    public j then(final j saveTask)
        throws Exception
    {
        te te = (te)saveTask.e();
        return handleSaveResultAsync(te, val$operations).b(new i() {

            final ParseObject._cls12 this$1;
            final j val$saveTask;

            public j then(j j1)
                throws Exception
            {
                if (j1.d() || j1.c())
                {
                    return j1;
                } else
                {
                    return saveTask.j();
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = ParseObject._cls12.this;
                saveTask = j1;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operations = ParseOperationSet.this;
        super();
    }
}
