// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseObject

class val.object
    implements i
{

    final then this$1;
    final ParseObject val$object;

    public Boolean then(j j1)
        throws ParseException
    {
        return Boolean.valueOf(tches(val$object, (List)j1.e()));
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$1 = final_;
        val$object = ParseObject.this;
        super();
    }
}
