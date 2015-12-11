// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser

class >
    implements ct
{

    final ParseUser this$0;

    public cu then(cu cu1)
        throws Exception
    {
        if (isCurrentUser())
        {
            ParseUser.access$100(ParseUser.this);
            return ParseUser.access$200(ParseUser.this).j();
        } else
        {
            return cu.a(null);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = ParseUser.this;
        super();
    }
}
