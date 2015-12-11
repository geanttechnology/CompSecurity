// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, ParseException

class this._cls0
    implements i
{

    final ParseObject this$0;

    public j then(j j1)
        throws Exception
    {
        j j2 = j1;
        if (j1.f() instanceof ParseException)
        {
            j2 = j1;
            if (((ParseException)j1.f()).getCode() == 120)
            {
                j2 = null;
            }
        }
        return j2;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = ParseObject.this;
        super();
    }
}
