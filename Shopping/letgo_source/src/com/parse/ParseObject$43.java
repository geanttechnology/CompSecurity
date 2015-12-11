// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.objects
    implements ct
{

    final List val$objects;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        return ParseObject.access$1800(val$objects, cu1);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    (List list)
    {
        val$objects = list;
        super();
    }
}
