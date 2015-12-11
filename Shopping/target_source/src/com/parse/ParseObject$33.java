// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.sessionToken
    implements i
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public j then(j j)
        throws Exception
    {
        return ParseObject.access$1100(val$uniqueObjects, val$sessionToken, j);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    (List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}
