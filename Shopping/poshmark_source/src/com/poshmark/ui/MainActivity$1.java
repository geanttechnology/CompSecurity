// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.appevents.AppEventsLogger;

// Referenced classes of package com.poshmark.ui:
//            MainActivity

class val.context
    implements Runnable
{

    final MainActivity this$0;
    final Context val$context;

    public void run()
    {
        AppEventsLogger.activateApp(val$context, getResources().getString(0x7f06010b));
    }

    sLogger()
    {
        this$0 = final_mainactivity;
        val$context = Context.this;
        super();
    }
}
