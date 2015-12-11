// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseQueryAdapter, ParseQuery

class val.className
    implements eryFactory
{

    final String val$className;

    public ParseQuery create()
    {
        ParseQuery parsequery = ParseQuery.getQuery(val$className);
        parsequery.orderByDescending("createdAt");
        return parsequery;
    }

    eryFactory()
    {
        val$className = s;
        super();
    }
}
