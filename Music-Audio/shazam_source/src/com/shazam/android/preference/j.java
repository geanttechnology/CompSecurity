// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.preference;

import android.app.Activity;
import android.content.DialogInterface;
import com.shazam.android.activities.streaming.b;
import com.shazam.android.an.i;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;

final class j
    implements android.content.DialogInterface.OnClickListener
{

    private final Activity a;
    private final b b;
    private final String c;
    private final i d;
    private final i e;
    private final EventAnalytics f;

    public j(Activity activity, b b1, String s, i k, i l, EventAnalytics eventanalytics)
    {
        a = activity;
        b = b1;
        c = s;
        d = k;
        e = l;
        f = eventanalytics;
    }

    public final void onClick(DialogInterface dialoginterface, int k)
    {
        if (k != -1) goto _L2; else goto _L1
_L1:
        dialoginterface = "connect";
        _cls1.a[b.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 58
    //                   2 71;
           goto _L3 _L4 _L5
_L3:
        f.logEvent(StreamingEventFactory.createStreamingMusicSwitchBeacon(dialoginterface, c));
        return;
_L4:
        e.a();
        continue; /* Loop/switch isn't completed */
_L5:
        d.a();
        continue; /* Loop/switch isn't completed */
_L2:
        dialoginterface = "cancel";
        a.finish();
        if (true) goto _L3; else goto _L6
_L6:
    }

    /* member class not found */
    class _cls1 {}

}
