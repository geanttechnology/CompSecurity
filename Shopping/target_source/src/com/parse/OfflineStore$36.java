// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseObject

class val.name
    implements i
{

    final OfflineStore this$0;
    final String val$name;

    public ParsePin then(j j1)
        throws Exception
    {
        Object obj;
        if (j1.e() != null && ((List)j1.e()).size() > 0)
        {
            j1 = (ParsePin)((List)j1.e()).get(0);
        } else
        {
            j1 = null;
        }
        obj = j1;
        if (j1 == null)
        {
            obj = (ParsePin)ParseObject.create(com/parse/ParsePin);
            ((ParsePin) (obj)).setName(val$name);
        }
        return ((ParsePin) (obj));
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$name = String.this;
        super();
    }
}
