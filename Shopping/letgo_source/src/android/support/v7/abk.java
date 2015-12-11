// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

public class abk extends aat
{

    private static final String a;

    public abk()
    {
        super(a, new String[0]);
    }

    public lv.a a(Map map)
    {
        map = Locale.getDefault();
        if (map == null)
        {
            return ado.f();
        }
        map = map.getLanguage();
        if (map == null)
        {
            return ado.f();
        } else
        {
            return ado.e(map.toLowerCase());
        }
    }

    public boolean a()
    {
        return false;
    }

    public volatile String b()
    {
        return super.b();
    }

    public volatile Set c()
    {
        return super.c();
    }

    static 
    {
        a = ls.t.toString();
    }
}
