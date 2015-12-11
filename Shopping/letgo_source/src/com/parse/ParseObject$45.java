// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, ParseUser

static final class val.onlyIfNeeded
    implements ct
{

    final List val$objects;
    final boolean val$onlyIfNeeded;

    public cu then(final cu user)
        throws Exception
    {
        user = (ParseUser)user.e();
        return ParseObject.enqueueForAll(val$objects, new ct() {

            final ParseObject._cls45 this$0;
            final ParseUser val$user;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseObject.access$1900(objects, user, onlyIfNeeded, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseObject._cls45.this;
                user = parseuser;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.val.user(List list, boolean flag)
    {
        val$objects = list;
        val$onlyIfNeeded = flag;
        super();
    }
}
