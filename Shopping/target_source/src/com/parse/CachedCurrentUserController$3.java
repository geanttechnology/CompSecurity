// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentUserController, ParseUser

class this._cls0
    implements i
{

    final CachedCurrentUserController this$0;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public String then(j j1)
        throws Exception
    {
        j1 = (ParseUser)j1.e();
        if (j1 != null)
        {
            return j1.getSessionToken();
        } else
        {
            return null;
        }
    }

    ()
    {
        this$0 = CachedCurrentUserController.this;
        super();
    }
}
