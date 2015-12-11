// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseQuery, ParseUser

static final class val.user
    implements i
{

    final ParseQuery val$query;
    final ParseUser val$user;

    public j then(j j)
        throws Exception
    {
        return val$query.findAsync(val$query.getBuilder().build(), val$user, null);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    e.Builder(ParseQuery parsequery, ParseUser parseuser)
    {
        val$query = parsequery;
        val$user = parseuser;
        super();
    }
}
