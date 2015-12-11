// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseObject

class val.sessionToken
    implements ct
{

    final ParseObject this$0;
    final String val$sessionToken;

    public cu then(cu cu1)
        throws Exception
    {
        if (ParseObject.access$1000(ParseObject.this).objectId() == null)
        {
            return cu1.i();
        } else
        {
            return deleteAsync(val$sessionToken);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    te()
    {
        this$0 = final_parseobject;
        val$sessionToken = String.this;
        super();
    }
}
