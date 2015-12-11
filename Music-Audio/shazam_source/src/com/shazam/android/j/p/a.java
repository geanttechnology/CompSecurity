// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.p;

import com.shazam.android.persistence.n.b;
import com.shazam.model.configuration.ProModeConfiguration;
import com.shazam.model.configuration.location.LocationConfiguration;

public final class a
    implements LocationConfiguration
{

    private final b a;
    private final ProModeConfiguration b;

    public a(b b1, ProModeConfiguration promodeconfiguration)
    {
        a = b1;
        b = promodeconfiguration;
    }

    public final boolean a()
    {
        return a.a("pk_l_e", true) && !b.a();
    }
}
