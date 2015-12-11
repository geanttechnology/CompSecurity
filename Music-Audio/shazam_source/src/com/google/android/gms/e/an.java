// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class an extends o
{

    private static final String b;
    private final Context c;

    public an(Context context)
    {
        super(b, new String[0]);
        c = context;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        map = android.provider.Settings.Secure.getString(c.getContentResolver(), "android_id");
        if (map == null)
        {
            return cj.f();
        } else
        {
            return cj.a(map);
        }
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.L.toString();
    }
}
