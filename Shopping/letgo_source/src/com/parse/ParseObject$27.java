// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder, ParseObjectController

class val.sessionToken
    implements ct
{

    final ParseObject this$0;
    final String val$sessionToken;

    public cu then(cu cu)
        throws Exception
    {
        te te;
        java.util.Map map;
        synchronized (mutex)
        {
            te = getState();
            map = ParseObject.access$800(ParseObject.this);
        }
        cu = new KnownParseObjectDecoder(map);
        return ParseObject.access$900().fetchAsync(te, val$sessionToken, cu);
        exception;
        cu;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    roller()
    {
        this$0 = final_parseobject;
        val$sessionToken = String.this;
        super();
    }
}
