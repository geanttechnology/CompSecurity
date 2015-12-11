// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, TaskQueue

class val.sessionToken
    implements ct
{

    final then this$1;
    final String val$sessionToken;

    public cu then(cu cu)
        throws Exception
    {
        return ParseObject.access$1100(_fld0, val$sessionToken, cu);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$sessionToken = String.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$32

/* anonymous class */
    class ParseObject._cls32
        implements ct
    {

        final ParseObject this$0;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (String)cu1.e();
            return taskQueue.enqueue(cu1. new ParseObject._cls32._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = ParseObject.this;
                super();
            }
    }

}
