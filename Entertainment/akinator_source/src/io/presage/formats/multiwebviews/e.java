// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

final class e extends BroadcastReceiver
{

    final a a;

    e(a a1)
    {
        a = a1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) && io.presage.formats.multiwebviews.a.b(a) != null)
        {
            io.presage.formats.multiwebviews.a.b(a).a();
        }
    }
}
