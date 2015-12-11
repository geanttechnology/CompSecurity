// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.e;

import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.j.c;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import com.shazam.server.legacy.orbitconfig.json.LegacyJsonConfig;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.android.persistence.e:
//            f

public final class i extends b.a
{

    private final com.shazam.j.b a;
    private final b b;

    public i(com.shazam.j.b b1, b b2)
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
            throw new f("No configuration found in preferences");
        }
        try
        {
            obj = (LegacyJsonConfig)a.a(((String) (obj)), com/shazam/server/legacy/orbitconfig/json/LegacyJsonConfig);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new f("Could not parse the serialized config to a LegacyJsonConfig object", ((Exception) (obj)));
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        throw new f("Parsed LegacyJsonConfig object was null");
        obj = ((LegacyJsonConfig) (obj)).getConfigProperty("inid", null);
        if (com.shazam.b.e.a.a(((String) (obj))))
        {
            throw new f("Parsed INID was null in legacy JSON config");
        }
        com.shazam.server.legacy.orbitconfig.OrbitConfig.Builder builder = com.shazam.server.legacy.orbitconfig.OrbitConfig.Builder.anOrbitConfig();
        com.shazam.server.legacy.orbitconfig.ConfigElements.Builder builder1 = com.shazam.server.legacy.orbitconfig.ConfigElements.Builder.configElements();
        HashMap hashmap = new HashMap(1);
        hashmap.put("inid", obj);
        obj = builder.withConfigElements(builder1.withValues(hashmap).build()).build();
        return ((OrbitConfig) (obj));
    }

    public final Object a()
    {
        return b();
    }
}
