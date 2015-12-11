// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.e;

import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.j.c;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;

// Referenced classes of package com.shazam.android.persistence.e:
//            f

public final class j extends b.a
{

    private final com.shazam.j.b a;
    private final b b;

    public j(com.shazam.j.b b1, b b2)
    {
        a = b1;
        b = b2;
    }

    private OrbitConfig b()
    {
        Object obj;
        obj = b.h("pk_oc");
        if (com.shazam.b.e.a.a(((String) (obj))))
        {
            throw new f("No serialized config found in preferences.");
        }
        try
        {
            obj = (OrbitConfig)a.a(((String) (obj)), com/shazam/server/legacy/orbitconfig/OrbitConfig);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new f("Could not parse the serialized config to an OrbitConfig object.", ((Exception) (obj)));
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        throw new f("Parsed OrbitConfig was null");
        return ((OrbitConfig) (obj));
    }

    public final Object a()
    {
        return b();
    }
}
