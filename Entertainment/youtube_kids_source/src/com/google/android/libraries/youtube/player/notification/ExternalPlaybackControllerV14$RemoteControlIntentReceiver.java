// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.player.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import cur;

// Referenced classes of package com.google.android.libraries.youtube.player.notification:
//            ExternalPlaybackControllerV14

public class  extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        if (ExternalPlaybackControllerV14.a == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) goto _L2; else goto _L1
_L1:
        context = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (context.getAction() != 1) goto _L2; else goto _L3
_L3:
        context.getKeyCode();
        JVM INSTR lookupswitch 7: default 116
    //                   79: 135
    //                   85: 135
    //                   86: 162
    //                   87: 144
    //                   88: 153
    //                   126: 117
    //                   127: 126;
           goto _L2 _L4 _L4 _L5 _L6 _L7 _L8 _L9
_L2:
        return;
_L8:
        ExternalPlaybackControllerV14.a.b();
        return;
_L9:
        ExternalPlaybackControllerV14.a.c();
        return;
_L4:
        ExternalPlaybackControllerV14.a.d();
        return;
_L6:
        ExternalPlaybackControllerV14.a.g();
        return;
_L7:
        ExternalPlaybackControllerV14.a.f();
        return;
_L5:
        ExternalPlaybackControllerV14.a.h();
        return;
    }

    public ()
    {
    }
}
