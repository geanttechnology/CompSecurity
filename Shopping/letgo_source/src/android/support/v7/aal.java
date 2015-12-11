// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Build;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class aal extends aat
{

    private static final String a;

    public aal()
    {
        super(a, new String[0]);
    }

    public lv.a a(Map map)
    {
        String s1 = Build.MANUFACTURER;
        String s = Build.MODEL;
        map = s;
        if (!s.startsWith(s1))
        {
            map = s;
            if (!s1.equals("unknown"))
            {
                map = (new StringBuilder()).append(s1).append(" ").append(s).toString();
            }
        }
        return ado.e(map);
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.l.toString();
    }
}
