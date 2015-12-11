// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            AbstractQueryController, ParseObject, ParseException

class this._cls0
    implements ct
{

    final AbstractQueryController this$0;

    public ParseObject then(cu cu1)
        throws Exception
    {
        if (cu1.d())
        {
            throw cu1.f();
        }
        if (cu1.e() != null && ((List)cu1.e()).size() > 0)
        {
            return (ParseObject)((List)cu1.e()).get(0);
        } else
        {
            throw new ParseException(101, "no results found for query");
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = AbstractQueryController.this;
        super();
    }
}
