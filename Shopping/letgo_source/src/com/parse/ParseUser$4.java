// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

class >
    implements ct
{

    final ParseUser this$0;
    final Map val$anonymousData;
    final String val$oldPassword;
    final String val$oldUsername;
    final ParseUser val$user;

    public cu then(cu cu1)
        throws Exception
    {
        if (cu1.c() || cu1.d())
        {
            synchronized (val$user.mutex)
            {
                if (val$oldUsername != null)
                {
                    val$user.setUsername(val$oldUsername);
                }
                if (val$oldPassword != null)
                {
                    val$user.setPassword(val$oldPassword);
                }
                ParseUser.access$400(val$user, val$anonymousData);
            }
            return cu1;
        } else
        {
            revert("password");
            mergeFromObject(val$user);
            return ParseUser.access$200(ParseUser.this).j();
        }
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
        val$user = parseuser1;
        val$oldUsername = s;
        val$oldPassword = s1;
        val$anonymousData = Map.this;
        super();
    }
}
