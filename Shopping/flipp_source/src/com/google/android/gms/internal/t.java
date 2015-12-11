// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, et, u, ew

public final class t
    implements af
{

    private final u a;

    public t(u u1)
    {
        a = u1;
    }

    public final void a(ew ew, Map map)
    {
        ew = (String)map.get("name");
        if (ew == null)
        {
            et.d("App event with no name parameter.");
            return;
        } else
        {
            a.a(ew, (String)map.get("info"));
            return;
        }
    }
}
