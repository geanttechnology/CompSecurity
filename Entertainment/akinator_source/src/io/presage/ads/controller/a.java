// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads.controller;

import android.os.Message;

// Referenced classes of package io.presage.ads.controller:
//            DefaultAdController

final class a
    implements android.os.Handler.Callback
{

    final DefaultAdController a;

    a(DefaultAdController defaultadcontroller)
    {
        a = defaultadcontroller;
        super();
    }

    public final boolean handleMessage(Message message)
    {
        DefaultAdController.access$000(a, "blocked_ui", "Default behaviour closed the ad");
        a.hideAd();
        return true;
    }
}
