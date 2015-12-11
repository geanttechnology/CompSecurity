// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder, ParseObjectController

class val.sessionToken
    implements i
{

    final ParseObject this$0;
    final String val$sessionToken;

    public j then(j j)
        throws Exception
    {
        te te;
        java.util.Map map;
        synchronized (mutex)
        {
            te = getState();
            map = ParseObject.access$700(ParseObject.this);
        }
        j = new KnownParseObjectDecoder(map);
        return ParseObject.access$800().fetchAsync(te, val$sessionToken, j);
        exception;
        j;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    roller()
    {
        this$0 = final_parseobject;
        val$sessionToken = String.this;
        super();
    }
}
