// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseQueryController, ParseUser, ParseObject, ParseException

abstract class AbstractQueryController
    implements ParseQueryController
{

    AbstractQueryController()
    {
    }

    public j getFirstAsync(ParseQuery.State state, ParseUser parseuser, j j1)
    {
        return findAsync(state, parseuser, j1).a(new i() {

            final AbstractQueryController this$0;

            public ParseObject then(j j2)
                throws Exception
            {
                if (j2.d())
                {
                    throw j2.f();
                }
                if (j2.e() != null && ((List)j2.e()).size() > 0)
                {
                    return (ParseObject)((List)j2.e()).get(0);
                } else
                {
                    throw new ParseException(101, "no results found for query");
                }
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = AbstractQueryController.this;
                super();
            }
        });
    }
}
