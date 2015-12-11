// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.sessionToken
    implements ct
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public cu then(cu cu)
        throws Exception
    {
        return ParseObject.access$1200(val$uniqueObjects, val$sessionToken, cu);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    (List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}
