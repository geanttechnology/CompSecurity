// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            abg

class adt extends aat
{

    private static final String a;
    private static final String b;
    private static final String c;
    private final Context d;

    public adt(Context context)
    {
        super(a, new String[] {
            c
        });
        d = context;
    }

    public lv.a a(Map map)
    {
        Object obj = (lv.a)map.get(c);
        if (obj == null)
        {
            return ado.f();
        }
        obj = ado.a(((lv.a) (obj)));
        map = (lv.a)map.get(b);
        if (map != null)
        {
            map = ado.a(map);
        } else
        {
            map = null;
        }
        map = abg.a(d, ((String) (obj)), map);
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
        a = ls.E.toString();
        b = lt.R.toString();
        c = lt.U.toString();
    }
}
