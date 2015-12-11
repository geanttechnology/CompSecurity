// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, aj

final class cr extends o
{

    private static final String b;
    private final Context c;

    public cr(Context context)
    {
        super(b, new String[0]);
        c = context;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        try
        {
            map = cj.a(Integer.valueOf(c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionCode));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aj.a((new StringBuilder("Package name ")).append(c.getPackageName()).append(" not found. ").append(map.getMessage()).toString());
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
        b = e.e.toString();
    }
}
