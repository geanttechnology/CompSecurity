// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, et, eq, ew, 
//            cu, ee, eg

final class ac
    implements af
{

    ac()
    {
    }

    public final void a(ew ew1, Map map)
    {
        map = (String)map.get("u");
        if (map == null)
        {
            et.d("URL missing from httpTrack GMSG.");
            return;
        } else
        {
            eg.a(((ee) (new eq(ew1.getContext(), ew1.d.b, map))).e);
            return;
        }
    }
}
