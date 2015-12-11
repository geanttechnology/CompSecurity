// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.g.c;

import android.content.Context;
import com.shazam.android.analytics.session.AgofSession;
import com.shazam.android.analytics.session.AndroidAgofSession;
import com.shazam.b.b;
import com.shazam.i.b.c;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSetting;
import com.shazam.server.response.config.AmpSettings;

public final class a
{

    private static final com.shazam.android.aq.c a = com.shazam.i.b.m.a.a();
    private static final Context b = com.shazam.i.b.c.a();
    private static AgofSession c;

    public static AgofSession a()
    {
        if (c == null)
        {
            Object obj;
            if (a.a().getSettings().getAgof().isEnabled())
            {
                obj = new AndroidAgofSession();
            } else
            {
                obj = (AgofSession)com.shazam.b.b.a(com/shazam/android/analytics/session/AgofSession);
            }
            c = ((AgofSession) (obj));
            ((AgofSession) (obj)).initSession(b);
        }
        return c;
    }

    public static void b()
    {
        if (c != null)
        {
            c.sendLoggedEvents();
            c = null;
        }
    }

}
