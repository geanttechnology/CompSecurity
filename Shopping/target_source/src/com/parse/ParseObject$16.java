// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject, Parse, ParseEventuallyQueue

class val.success
    implements i
{

    final ParseObject this$0;
    final boolean val$success;

    public j then(j j)
        throws Exception
    {
        if (val$success)
        {
            Parse.getEventuallyQueue().notifyTestHelper(5);
        }
        return j;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    Queue()
    {
        this$0 = final_parseobject;
        val$success = Z.this;
        super();
    }
}
