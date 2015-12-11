// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser

static final class val.onlyIfNeeded
    implements i
{

    final List val$objects;
    final boolean val$onlyIfNeeded;

    public j then(final j user)
        throws Exception
    {
        user = (ParseUser)user.e();
        return ParseObject.enqueueForAll(val$objects, new i() {

            final ParseObject._cls45 this$0;
            final ParseUser val$user;

            public j then(j j1)
                throws Exception
            {
                return ParseObject.access$1800(objects, user, onlyIfNeeded, j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseObject._cls45.this;
                user = parseuser;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.user(List list, boolean flag)
    {
        val$objects = list;
        val$onlyIfNeeded = flag;
        super();
    }
}
