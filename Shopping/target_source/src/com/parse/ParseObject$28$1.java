// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, TaskQueue

class val.sessionToken
    implements i
{

    final then this$1;
    final String val$sessionToken;

    public j then(j j1)
        throws Exception
    {
        if (isDataAvailable())
        {
            return j.a(_fld0);
        } else
        {
            return fetchAsync(val$sessionToken, j1);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$sessionToken = String.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$28

/* anonymous class */
    class ParseObject._cls28
        implements i
    {

        final ParseObject this$0;

        public j then(j j1)
            throws Exception
        {
            j1 = (String)j1.e();
            return taskQueue.enqueue(j1. new ParseObject._cls28._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = ParseObject.this;
                super();
            }
    }

}
