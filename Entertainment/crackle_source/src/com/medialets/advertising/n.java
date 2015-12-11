// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import java.util.HashMap;

// Referenced classes of package com.medialets.advertising:
//            JSBridge

final class n
    implements Runnable
{

    private JSBridge a;

    n(JSBridge jsbridge)
    {
        a = jsbridge;
        super();
    }

    public final void run()
    {
        a.expandAd(new HashMap());
    }
}
