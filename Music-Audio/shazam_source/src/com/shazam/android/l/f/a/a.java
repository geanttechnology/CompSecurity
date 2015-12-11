// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.f.a;

import android.content.Context;
import com.shazam.android.activities.streaming.b;
import com.shazam.android.activities.streaming.c;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.configuration.StreamingConfiguration;

public final class a
    implements com.shazam.b.a.a
{

    private final Context a;
    private final StreamingConfiguration b;
    private final b c;
    private final b d;

    public a(Context context, StreamingConfiguration streamingconfiguration, b b1, b b2)
    {
        a = context;
        b = streamingconfiguration;
        c = b1;
        d = b2;
    }

    public final volatile Object a(Object obj)
    {
        if (b.a() && c != d)
        {
            return com.shazam.android.activities.streaming.c.a(c, a, ScreenOrigin.DETAILS);
        } else
        {
            return null;
        }
    }
}
