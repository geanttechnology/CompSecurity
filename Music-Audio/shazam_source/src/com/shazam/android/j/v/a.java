// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.v;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.PlayWithConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpPlayWith;
import com.shazam.server.response.config.Option;
import java.util.Iterator;
import java.util.List;

public final class a
    implements PlayWithConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final Option a(String s)
    {
        if (s == null)
        {
            return null;
        }
        for (Iterator iterator = a().iterator(); iterator.hasNext();)
        {
            Option option = (Option)iterator.next();
            if (s.equals(option.getId()))
            {
                return option;
            }
        }

        return null;
    }

    public final List a()
    {
        return a.a().getAmpPlayWith().getOptions();
    }

    public final boolean b(String s)
    {
        return a(s) != null;
    }
}
