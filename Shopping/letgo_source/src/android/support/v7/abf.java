// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            abg

class abf extends aat
{

    private static final String a;
    private static final String b;
    private final Context c;

    public abf(Context context)
    {
        super(a, new String[0]);
        c = context;
    }

    public lv.a a(Map map)
    {
        if ((lv.a)map.get(b) != null)
        {
            map = ado.a((lv.a)map.get(b));
        } else
        {
            map = null;
        }
        map = abg.a(c, map);
        if (map != null)
        {
            return ado.e(map);
        } else
        {
            return ado.f();
        }
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.J.toString();
        b = lt.R.toString();
    }
}
