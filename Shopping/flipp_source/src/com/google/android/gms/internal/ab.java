// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, ew, et, cd, 
//            cm

final class ab
    implements af
{

    ab()
    {
    }

    public final void a(ew ew1, Map map)
    {
        ew1 = ew1.b();
        if (ew1 == null)
        {
            et.d("A GMSG tried to use a custom close button on something that wasn't an overlay.");
        } else
        {
            boolean flag = "1".equals(map.get("custom_close"));
            if (((cd) (ew1)).d != null)
            {
                ((cd) (ew1)).d.a(flag);
                return;
            }
        }
    }
}
