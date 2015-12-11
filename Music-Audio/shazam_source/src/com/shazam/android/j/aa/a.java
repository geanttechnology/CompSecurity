// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.aa;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.ShareConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpShare;
import com.shazam.server.response.config.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
    implements ShareConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final List a()
    {
        Object obj = a.a().getAmpShare().getOptions();
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((Option)((Iterator) (obj)).next()).getPackageName())) { }
        return arraylist;
    }
}
