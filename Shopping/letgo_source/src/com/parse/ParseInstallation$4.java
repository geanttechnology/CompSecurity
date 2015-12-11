// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseInstallation, ParseObject

static final class 
    implements ct
{

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (List)cu1.e();
        if (cu1 != null)
        {
            if (cu1.size() == 1)
            {
                return cu.a(cu1.get(0));
            } else
            {
                return ParseObject.unpinAllInBackground("_currentInstallation").i();
            }
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
    }
}
