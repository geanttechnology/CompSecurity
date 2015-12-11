// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class val.saveTask
    implements ct
{

    final then this$1;
    final cu val$saveTask;

    public cu then(cu cu1)
        throws Exception
    {
        if (cu1.d() || cu1.c())
        {
            return cu1;
        } else
        {
            return val$saveTask.j();
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$1 = final_;
        val$saveTask = cu.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$13

/* anonymous class */
    class ParseObject._cls13
        implements ct
    {

        final ParseObject this$0;
        final ParseOperationSet val$operations;

        public cu then(cu cu1)
            throws Exception
        {
            ParseObject.State state = (ParseObject.State)cu1.e();
            return handleSaveResultAsync(state, operations).b(cu1. new ParseObject._cls13._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parseobject;
                operations = ParseOperationSet.this;
                super();
            }
    }

}
