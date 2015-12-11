// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado, abo

class adv extends aat
{

    private static final String a;
    private final Context b;

    public adv(Context context)
    {
        super(a, new String[0]);
        b = context;
    }

    public lv.a a(Map map)
    {
        try
        {
            map = b.getPackageManager();
            map = ado.e(map.getApplicationLabel(map.getApplicationInfo(b.getPackageName(), 0)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            abo.a("App name is not found.", map);
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
        a = ls.d.toString();
    }
}
