// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.SystemClock;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            gi, gw, gd, ge

final class b
    implements android.content.gInterface.OnDismissListener
{

    final Activity a;
    final ge b;
    final gi c;

    public final void onDismiss(DialogInterface dialoginterface)
    {
        gi.a(a, c.c.g);
        c.a.a(c.c.k, SystemClock.elapsedRealtime() - c.d);
        if (!c.f)
        {
            b.b(c.b, c.c.h);
        }
        if (c.g && c.c.k != null && c.c.k.containsKey("action_id"))
        {
            dialoginterface = c.c.k.get("action_id").toString();
            if (dialoginterface != null && dialoginterface.length() > 0)
            {
                c.a.h(dialoginterface);
            }
        }
    }

    erface(gi gi1, Activity activity, ge ge1)
    {
        c = gi1;
        a = activity;
        b = ge1;
        super();
    }
}
