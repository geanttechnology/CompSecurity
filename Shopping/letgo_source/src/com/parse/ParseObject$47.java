// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseQuery, ParseUser

static final class val.user
    implements ct
{

    final ParseQuery val$query;
    final ParseUser val$user;

    public cu then(cu cu)
        throws Exception
    {
        return val$query.findAsync(val$query.getBuilder().build(), val$user, null);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    e.Builder(ParseQuery parsequery, ParseUser parseuser)
    {
        val$query = parsequery;
        val$user = parseuser;
        super();
    }
}
