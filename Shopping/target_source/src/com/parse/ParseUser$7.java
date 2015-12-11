// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

class >
    implements i
{

    final ParseUser this$0;
    final Map val$anonymousData;
    final String val$oldPassword;
    final String val$oldUsername;
    final ParseUser val$user;

    public j then(j j1)
        throws Exception
    {
        if (!j1.c() && !j1.d())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        Object obj = val$user.mutex;
        obj;
        JVM INSTR monitorenter ;
        if (val$oldUsername == null) goto _L2; else goto _L1
_L1:
        val$user.setUsername(val$oldUsername);
_L5:
        if (val$oldPassword == null) goto _L4; else goto _L3
_L3:
        val$user.setPassword(val$oldPassword);
_L6:
        ParseUser.access$300(val$user, val$anonymousData);
        return j1;
_L2:
        val$user.revert("username");
          goto _L5
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
_L4:
        val$user.revert("password");
          goto _L6
        val$user.revert("password");
        revert("password");
        mergeFromObject(val$user);
        return ParseUser.access$200(ParseUser.this);
          goto _L5
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_parseuser;
        val$user = parseuser1;
        val$oldUsername = s;
        val$oldPassword = s1;
        val$anonymousData = Map.this;
        super();
    }
}
