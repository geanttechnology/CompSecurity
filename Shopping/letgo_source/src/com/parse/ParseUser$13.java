// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser

static final class 
    implements ct
{

    final ParseUser val$user;

    public ParseUser then(cu cu1)
        throws Exception
    {
        Object obj = ParseUser.access$900();
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (!cu1.d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ParseUser.access$1002(flag);
        ParseUser.currentUser = val$user;
        obj;
        JVM INSTR monitorexit ;
        return val$user;
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

    (ParseUser parseuser)
    {
        val$user = parseuser;
        super();
    }
}
