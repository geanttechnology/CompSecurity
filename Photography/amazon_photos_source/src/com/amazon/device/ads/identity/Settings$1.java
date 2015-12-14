// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads.identity:
//            Settings

class val.context
    implements Runnable
{

    final Settings this$0;
    final Context val$context;

    public void run()
    {
        fetchSharedPreferences(val$context);
    }

    ()
    {
        this$0 = final_settings;
        val$context = Context.this;
        super();
    }
}
