// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ax;

import com.shazam.android.j.l.a;
import com.shazam.model.availability.AppInstallationVerifier;
import com.shazam.model.availability.GooglePlayAvailability;

public final class b
    implements GooglePlayAvailability
{

    private final a a;
    private final AppInstallationVerifier b;
    private Boolean c;

    public b(a a1, AppInstallationVerifier appinstallationverifier)
    {
        b = appinstallationverifier;
        a = a1;
    }

    public final boolean a()
    {
        if (c != null)
        {
            return c.booleanValue();
        }
        boolean flag;
        if (b.a("com.android.vending") && a.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = Boolean.valueOf(flag);
        return c.booleanValue();
    }
}
