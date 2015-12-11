// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseSession, ParseObject

static final class te
    implements i
{

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public String then(j j1)
        throws Exception
    {
        return ((ParseSession)ParseObject.from((te)j1.e())).getSessionToken();
    }

    te()
    {
    }
}
