// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ab;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.b.e.a;
import com.shazam.model.configuration.EmailRegistrationStyleConfiguration;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpOnboarding;
import com.shazam.server.response.config.AmpStyles;

public final class b
    implements EmailRegistrationStyleConfiguration
{

    private final h a;

    public b(h h1)
    {
        a = h1;
    }

    public final boolean a()
    {
        String s = a.a().a().getAmpStyles().getAmpOnboarding().getEmailRegistration();
        return com.shazam.b.e.a.c(s) && "legacy".equals(s);
    }
}
