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

    public cu then(cu cu1)
        throws Exception
    {
label0:
        {
            cu cu2;
            synchronized (mutex)
            {
                if (!ParseUser.access$1700(ParseUser.this).containsKey(val$authType))
                {
                    break label0;
                }
                ParseUser.access$1800(ParseUser.this, val$authType, null);
                cu2 = saveInBackground();
            }
            return cu2;
        }
        cu cu3 = cu.a(null);
        cu1;
        JVM INSTR monitorexit ;
        return cu3;
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parseuser;
        val$authType = String.this;
        super();
    }
}
