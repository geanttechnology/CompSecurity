// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.a.g;
import com.shazam.model.configuration.StreamingTrackMappingsUrlConfiguration;
import java.util.ArrayList;
import java.util.Set;

public final class x
{

    final g a;
    final StreamingTrackMappingsUrlConfiguration b;
    final ArrayList c = new ArrayList();
    final ArrayList d = new ArrayList();

    public x(g g, StreamingTrackMappingsUrlConfiguration streamingtrackmappingsurlconfiguration)
    {
        a = g;
        b = streamingtrackmappingsurlconfiguration;
    }

    final void a(String s, Set set)
    {
        if (!set.contains(s))
        {
            c.add(s);
        }
    }
}
