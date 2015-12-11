// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.HashMap;

// Referenced classes of package com.adobe.mobile:
//            ReferrerHandler, Lifecycle

final class val.contextData
    implements Runnable
{

    final HashMap val$contextData;

    public void run()
    {
        Lifecycle.updateContextData(val$contextData);
    }

    ()
    {
        val$contextData = hashmap;
        super();
    }
}
