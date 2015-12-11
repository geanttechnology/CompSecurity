// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject, ParseException

class this._cls0
    implements ct
{

    final ParseObject this$0;

    public cu then(cu cu1)
        throws Exception
    {
        cu cu2 = cu1;
        if (cu1.f() instanceof ParseException)
        {
            cu2 = cu1;
            if (((ParseException)cu1.f()).getCode() == 120)
            {
                cu2 = null;
            }
        }
        return cu2;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = ParseObject.this;
        super();
    }
}
