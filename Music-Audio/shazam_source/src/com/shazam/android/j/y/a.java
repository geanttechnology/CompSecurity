// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.y;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.model.configuration.EmailRegistrationConfiguration;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import com.shazam.server.legacy.orbitconfig.OrbitDialog;
import com.shazam.server.legacy.orbitconfig.Type;
import java.util.Iterator;
import java.util.List;

public final class a
    implements EmailRegistrationConfiguration
{

    private final h a;

    public a(h h1)
    {
        a = h1;
    }

    public final boolean a()
    {
        for (Iterator iterator = a.a().b().getOrbitDialogs().iterator(); iterator.hasNext();)
        {
            if (((OrbitDialog)iterator.next()).getType() == Type.email)
            {
                return true;
            }
        }

        return false;
    }
}
