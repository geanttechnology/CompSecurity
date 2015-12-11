// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.service;

import android.os.RemoteCallbackList;
import com.penthera.virtuososdk.database.impl.provider.ProvidersInstance;
import java.util.HashMap;

// Referenced classes of package com.penthera.virtuososdk.service:
//            VirtuosoService

class val.auth
    implements Runnable
{

    final VirtuosoService this$0;
    private final String val$auth;

    public void run()
    {
        VirtuosoService.access$13(VirtuosoService.this, VirtuosoService.access$12(VirtuosoService.this).addProvider(val$auth));
        if (!VirtuosoService.access$1(VirtuosoService.this).containsKey(val$auth))
        {
            VirtuosoService.access$1(VirtuosoService.this).put(val$auth, new RemoteCallbackList());
        }
        if (!VirtuosoService.access$3(VirtuosoService.this).containsKey(val$auth))
        {
            VirtuosoService.access$3(VirtuosoService.this).put(val$auth, new RemoteCallbackList());
        }
        if (!VirtuosoService.access$2(VirtuosoService.this).containsKey(val$auth))
        {
            VirtuosoService.access$2(VirtuosoService.this).put(val$auth, new RemoteCallbackList());
        }
    }

    vidersInstance()
    {
        this$0 = final_virtuososervice;
        val$auth = String.this;
        super();
    }
}
