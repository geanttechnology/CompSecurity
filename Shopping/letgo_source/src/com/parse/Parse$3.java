// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            Parse, ParseUser

static final class n
    implements ct
{

    public cu then(cu cu1)
        throws Exception
    {
        return ParseUser.getCurrentUserAsync().j();
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    n()
    {
    }
}
