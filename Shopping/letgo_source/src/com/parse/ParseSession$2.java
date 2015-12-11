// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSession, ParseRESTSessionCommand

static final class nCommand
    implements ct
{

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        if (cu1 == null)
        {
            return cu.a(null);
        } else
        {
            return ParseRESTSessionCommand.getCurrentSessionCommand(cu1).executeAsync().i();
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    nCommand()
    {
    }
}
