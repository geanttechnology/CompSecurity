// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, aj

final class cq extends o
{

    private static final String b;
    private final Context c;

    public cq(Context context)
    {
        super(b, new String[0]);
        c = context;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        try
        {
            map = c.getPackageManager();
            map = cj.a(map.getApplicationLabel(map.getApplicationInfo(c.getPackageName(), 0)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aj.a("App name is not found.", map);
            return cj.f();
        }
        return map;
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.d.toString();
    }
}
