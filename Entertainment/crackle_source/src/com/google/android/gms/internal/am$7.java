// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, am, cw, h, 
//            d, ct

static final class 
    implements an
{

    public void a(cw cw1, Map map)
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
            cw1 = cw1.aD();
        }
        // Misplaced declaration of an exception variable
        catch (cw cw1)
        {
            ct.v("Could not parse touch parameters from gmsg.");
            return;
        }
        if (cw1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        cw1.g().a(i, j, k);
    }

    ()
    {
    }
}
