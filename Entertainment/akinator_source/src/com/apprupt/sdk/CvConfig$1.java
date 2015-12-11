// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig

class val.context
    implements Runnable
{

    final CvConfig this$0;
    final Context val$context;

    public void run()
    {
        CvConfig.access$000(CvConfig.this).i(new Object[] {
            "Config initialized"
        });
        CvConfig.access$102(CvConfig.this, val$context.getApplicationContext());
        doCheck(null);
    }

    ()
    {
        this$0 = final_cvconfig;
        val$context = Context.this;
        super();
    }
}
