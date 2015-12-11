// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, ew, jg, fl, 
//            et

final class ae
    implements af
{

    ae()
    {
    }

    public final void a(ew ew1, Map map)
    {
        String s = (String)map.get("tx");
        String s1 = (String)map.get("ty");
        map = (String)map.get("td");
        int i;
        int j;
        int k;
        try
        {
            i = Integer.parseInt(s);
            j = Integer.parseInt(s1);
            k = Integer.parseInt(map);
            ew1 = ew1.c;
        }
        // Misplaced declaration of an exception variable
        catch (ew ew1)
        {
            et.d("Could not parse touch parameters from gmsg.");
            return;
        }
        if (ew1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        ew1.a().a(i, j, k);
    }
}
