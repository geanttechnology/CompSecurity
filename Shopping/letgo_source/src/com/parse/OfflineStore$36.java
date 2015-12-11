// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseObject

class val.name
    implements ct
{

    final OfflineStore this$0;
    final String val$name;

    public ParsePin then(cu cu1)
        throws Exception
    {
        Object obj;
        if (cu1.e() != null && ((List)cu1.e()).size() > 0)
        {
            cu1 = (ParsePin)((List)cu1.e()).get(0);
        } else
        {
            cu1 = null;
        }
        obj = cu1;
        if (cu1 == null)
        {
            obj = (ParsePin)ParseObject.create(com/parse/ParsePin);
            ((ParsePin) (obj)).setName(val$name);
        }
        return ((ParsePin) (obj));
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$name = String.this;
        super();
    }
}
