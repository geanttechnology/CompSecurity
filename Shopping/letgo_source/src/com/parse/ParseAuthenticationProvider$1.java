// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider

class this._cls0
    implements ct
{

    final ParseAuthenticationProvider this$0;

    public cu then(cu cu1)
        throws Exception
    {
        return logInAsync((Map)cu1.e());
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = ParseAuthenticationProvider.this;
        super();
    }
}
