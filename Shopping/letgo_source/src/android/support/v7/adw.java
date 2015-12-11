// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado, abo

class adw extends aat
{

    private static final String a;
    private final Context b;

    public adw(Context context)
    {
        super(a, new String[0]);
        b = context;
    }

    public lv.a a(Map map)
    {
        try
        {
            map = ado.e(Integer.valueOf(b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionCode));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            abo.a((new StringBuilder()).append("Package name ").append(b.getPackageName()).append(" not found. ").append(map.getMessage()).toString());
            return ado.f();
        }
        return map;
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.e.toString();
    }
}
