// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseQueryController, ParseUser, ParseObject, ParseException

abstract class AbstractQueryController
    implements ParseQueryController
{

    AbstractQueryController()
    {
    }

    public cu getFirstAsync(ParseQuery.State state, ParseUser parseuser, cu cu1)
    {
        return findAsync(state, parseuser, cu1).a(new ct() {

            final AbstractQueryController this$0;

            public ParseObject then(cu cu2)
                throws Exception
            {
                if (cu2.d())
                {
                    throw cu2.f();
                }
                if (cu2.e() != null && ((List)cu2.e()).size() > 0)
                {
                    return (ParseObject)((List)cu2.e()).get(0);
                } else
                {
                    throw new ParseException(101, "no results found for query");
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = AbstractQueryController.this;
                super();
            }
        });
    }
}
