// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ax;

import com.shazam.model.availability.AppAvailability;
import com.shazam.model.availability.AppInstallationVerifier;

public abstract class c
    implements AppAvailability
{

    private final AppInstallationVerifier a;

    public c(AppInstallationVerifier appinstallationverifier)
    {
        a = appinstallationverifier;
    }

    public final boolean b()
    {
        return a.a(a());
    }
}
