// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Context;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.aio.downloader.dialog.AnzhuangDialog;

// Referenced classes of package com.aio.downloader.service:
//            GetBroadcast

class val.context
    implements Runnable
{

    final GetBroadcast this$0;
    private final Context val$context;

    public void run()
    {
        GetBroadcast.access$0(GetBroadcast.this).show();
        Window window = GetBroadcast.access$0(GetBroadcast.this).getWindow();
        android.view.ayoutParams ayoutparams = window.getAttributes();
        window.setGravity(80);
        ayoutparams.width = ((WindowManager)val$context.getSystemService("window")).getDefaultDisplay().getWidth();
        window.setAttributes(ayoutparams);
    }

    ()
    {
        this$0 = final_getbroadcast;
        val$context = Context.this;
        super();
    }
}
