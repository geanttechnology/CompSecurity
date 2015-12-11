// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseObject

class val.sessionToken
    implements i
{

    final ParseObject this$0;
    final String val$sessionToken;

    public j then(j j1)
        throws Exception
    {
        if (ParseObject.access$900(ParseObject.this).objectId() == null)
        {
            return j1.i();
        } else
        {
            return deleteAsync(val$sessionToken);
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    te()
    {
        this$0 = final_parseobject;
        val$sessionToken = String.this;
        super();
    }
}
