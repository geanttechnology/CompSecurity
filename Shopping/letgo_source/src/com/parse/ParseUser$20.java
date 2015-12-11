// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements ct
{

    final ParseUser this$0;
    final String val$authType;
    final Map val$oldAnonymousData;

    public cu then(cu cu1)
        throws Exception
    {
label0:
        {
            synchronized (mutex)
            {
                if (!cu1.d() && !cu1.c())
                {
                    break label0;
                }
                ParseUser.access$400(ParseUser.this, val$oldAnonymousData);
            }
            return cu1;
        }
        ParseUser.access$2300(ParseUser.this, val$authType);
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        cu1;
        obj;
        JVM INSTR monitorexit ;
        throw cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parseuser;
        val$oldAnonymousData = map;
        val$authType = String.this;
        super();
    }
}
