// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            AbstractQueryController, ParseObject, ParseException

class this._cls0
    implements i
{

    final AbstractQueryController this$0;

    public ParseObject then(j j1)
        throws Exception
    {
        if (j1.d())
        {
            throw j1.f();
        }
        if (j1.e() != null && ((List)j1.e()).size() > 0)
        {
            return (ParseObject)((List)j1.e()).get(0);
        } else
        {
            throw new ParseException(101, "no results found for query");
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = AbstractQueryController.this;
        super();
    }
}
