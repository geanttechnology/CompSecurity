// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;

import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import com.shazam.server.response.config.AmpConfig;
import java.io.Serializable;

public class e
    implements Serializable
{
    public static final class a
    {

        public AmpConfig a;
        public OrbitConfig b;

        public final e a()
        {
            return new e(this, (byte)0);
        }

        public a()
        {
        }
    }


    private AmpConfig a;
    private OrbitConfig b;

    private e()
    {
    }

    private e(a a1)
    {
        a = a1.a;
        b = a1.b;
    }

    e(a a1, byte byte0)
    {
        this(a1);
    }

    public static AmpConfig a(e e1)
    {
        return e1.a;
    }

    public static OrbitConfig b(e e1)
    {
        return e1.b;
    }

    public final AmpConfig a()
    {
        if (a != null)
        {
            return a;
        } else
        {
            return com.shazam.server.response.config.AmpConfig.Builder.ampConfig().build();
        }
    }

    public final OrbitConfig b()
    {
        if (b != null)
        {
            return b;
        } else
        {
            return com.shazam.server.legacy.orbitconfig.OrbitConfig.Builder.anOrbitConfig().build();
        }
    }
}
