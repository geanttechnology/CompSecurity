// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.f;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.ChartsConfiguration;
import com.shazam.o.b;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.Charts;
import java.util.List;

public final class a
    implements ChartsConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final boolean a()
    {
        return com.shazam.o.b.b(b());
    }

    public final List b()
    {
        Charts charts = a.a().getCharts();
        if (com.shazam.o.b.b(charts.getChartList()))
        {
            return charts.getChartList();
        } else
        {
            return null;
        }
    }
}
