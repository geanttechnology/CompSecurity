// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.af;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.NcmConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpNcm;
import com.shazam.server.response.config.AmpNcmPresence;
import java.util.List;

public final class a
    implements NcmConfiguration
{

    private final com.shazam.b.a.a a;
    private final c b;

    public a(c c1, com.shazam.b.a.a a1)
    {
        b = c1;
        a = a1;
    }

    public final List a()
    {
        List list = b.a().getNcm().getPresence().getRanges();
        return (List)a.a(list);
    }
}
