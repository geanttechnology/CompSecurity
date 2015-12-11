// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.objects
    implements i
{

    final List val$objects;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        return ParseObject.access$1200(val$objects, j1);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    (List list)
    {
        val$objects = list;
        super();
    }
}
