// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

public final class af extends o
{

    private static final String b;

    public af()
    {
        super(b, new String[0]);
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        map = Locale.getDefault();
        if (map == null)
        {
            return cj.f();
        }
        map = map.getLanguage();
        if (map == null)
        {
            return cj.f();
        } else
        {
            return cj.a(map.toLowerCase());
        }
    }

    public final boolean a()
    {
        return false;
    }

    public final volatile String b()
    {
        return super.b();
    }

    public final volatile Set c()
    {
        return super.c();
    }

    static 
    {
        b = e.t.toString();
    }
}
