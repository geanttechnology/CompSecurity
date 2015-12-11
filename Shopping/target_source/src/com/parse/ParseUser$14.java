// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements i
{

    final ParseUser this$0;
    final String val$authType;
    final Map val$oldAnonymousData;

    public j then(j j1)
        throws Exception
    {
label0:
        {
            synchronized (mutex)
            {
                if (!j1.d() && !j1.c())
                {
                    break label0;
                }
                ParseUser.access$300(ParseUser.this, val$oldAnonymousData);
            }
            return j1;
        }
        j1 = synchronizeAuthDataAsync(val$authType);
        obj;
        JVM INSTR monitorexit ;
        return j1;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_parseuser;
        val$oldAnonymousData = map;
        val$authType = String.this;
        super();
    }
}
