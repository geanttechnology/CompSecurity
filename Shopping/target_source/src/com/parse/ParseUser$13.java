// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements i
{

    final ParseUser this$0;
    final String val$authType;

    public j then(j j1)
        throws Exception
    {
        boolean flag;
        if (!j1.d() && ((Boolean)j1.e()).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return unlinkFromInBackground(val$authType);
        } else
        {
            return j1.j();
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = final_parseuser;
        val$authType = String.this;
        super();
    }
}
