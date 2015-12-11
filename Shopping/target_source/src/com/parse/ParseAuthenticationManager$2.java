// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseAuthenticationManager, AuthenticationCallback

class val.authData
    implements Callable
{

    final ParseAuthenticationManager this$0;
    final Map val$authData;
    final AuthenticationCallback val$callback;

    public Boolean call()
        throws Exception
    {
        return Boolean.valueOf(val$callback.onRestore(val$authData));
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = final_parseauthenticationmanager;
        val$callback = authenticationcallback;
        val$authData = Map.this;
        super();
    }
}
