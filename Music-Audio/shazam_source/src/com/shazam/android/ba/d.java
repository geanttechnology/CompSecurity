// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ba;

import com.shazam.android.aq.h;
import com.shazam.android.j.e;
import com.shazam.android.persistence.e.b;
import com.shazam.android.persistence.e.f;
import com.shazam.b.e.a;
import com.shazam.model.configuration.InstallationIdRepository;
import com.shazam.server.legacy.orbitconfig.ConfigElements;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import java.util.Map;

// Referenced classes of package com.shazam.android.ba:
//            f

public final class d
    implements com.shazam.android.ba.f
{

    private final InstallationIdRepository a;
    private final h b;
    private final b c;
    private final b d;

    public d(InstallationIdRepository installationidrepository, h h1, b b1, b b2)
    {
        a = installationidrepository;
        b = h1;
        c = b1;
        d = b2;
    }

    private static String a(OrbitConfig orbitconfig)
    {
        return (String)orbitconfig.getConfigElements().getValues().get("inid");
    }

    public final void a()
    {
        Object obj = b.a().b();
        if (!a.a())
        {
            String s = ((OrbitConfig) (obj)).getStringConfigEntry("inid");
            obj = s;
            if (com.shazam.b.e.a.a(s))
            {
                try
                {
                    obj = a((OrbitConfig)c.a());
                }
                catch (f f1)
                {
                    try
                    {
                        f1 = a((OrbitConfig)d.a());
                    }
                    catch (f f2)
                    {
                        return;
                    }
                }
            }
            a.a(((String) (obj)));
        }
    }
}
