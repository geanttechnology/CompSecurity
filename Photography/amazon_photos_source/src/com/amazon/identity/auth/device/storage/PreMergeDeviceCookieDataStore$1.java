// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            PreMergeDeviceCookieDataStore

class val.copyOfCookies
    implements Runnable
{

    final PreMergeDeviceCookieDataStore this$0;
    final List val$copyOfCookies;
    final String val$directedId;
    final String val$domain;

    public void run()
    {
        setCookies(val$directedId, val$domain, val$copyOfCookies);
    }

    ()
    {
        this$0 = final_premergedevicecookiedatastore;
        val$directedId = s;
        val$domain = s1;
        val$copyOfCookies = List.this;
        super();
    }
}
