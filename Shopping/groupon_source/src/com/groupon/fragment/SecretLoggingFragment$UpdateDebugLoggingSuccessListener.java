// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.util.Function0;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.fragment:
//            SecretLoggingFragment

private class debugLoggingEnabled
    implements Function0
{

    boolean debugLoggingEnabled;
    final SecretLoggingFragment this$0;

    public void execute()
    {
        byte byte0;
        if (debugLoggingEnabled)
        {
            byte0 = 2;
        } else
        {
            byte0 = 4;
        }
        Ln.setLoggingLevel(byte0);
    }

    public (boolean flag)
    {
        this$0 = SecretLoggingFragment.this;
        super();
        debugLoggingEnabled = flag;
    }
}
