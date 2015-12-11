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

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public String then(cu cu1)
        throws Exception
    {
        cu1 = (ParseUser)cu1.e();
        if (cu1 != null)
        {
            return cu1.getSessionToken();
        } else
        {
            return null;
        }
    }

    ()
    {
    }
}
