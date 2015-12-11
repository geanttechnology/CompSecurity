// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.util.Function0;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

private class username
    implements Function0
{

    final LogInFragment this$0;
    private String username;

    public void execute()
    {
        onLoginSuccess(username);
    }

    public (String s)
    {
        this$0 = LogInFragment.this;
        super();
        username = s;
    }
}
