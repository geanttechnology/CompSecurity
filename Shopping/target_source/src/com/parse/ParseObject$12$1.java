// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class val.saveTask
    implements i
{

    final then this$1;
    final j val$saveTask;

    public j then(j j1)
        throws Exception
    {
        if (j1.d() || j1.c())
        {
            return j1;
        } else
        {
            return val$saveTask.j();
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$1 = final_;
        val$saveTask = j.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$12

/* anonymous class */
    class ParseObject._cls12
        implements i
    {

        final ParseObject this$0;
        final ParseOperationSet val$operations;

        public j then(j j1)
            throws Exception
        {
            ParseObject.State state = (ParseObject.State)j1.e();
            return handleSaveResultAsync(state, operations).b(j1. new ParseObject._cls12._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parseobject;
                operations = ParseOperationSet.this;
                super();
            }
    }

}
