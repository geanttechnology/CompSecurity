// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl

class val.inappActivityIntent
    implements Runnable
{

    final InappManagerImpl this$0;
    final Activity val$caller;
    final Intent val$inappActivityIntent;

    public void run()
    {
        val$caller.startActivity(val$inappActivityIntent);
    }

    ()
    {
        this$0 = final_inappmanagerimpl;
        val$caller = activity;
        val$inappActivityIntent = Intent.this;
        super();
    }
}
