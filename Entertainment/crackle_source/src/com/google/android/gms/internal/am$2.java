// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, am, i, ct, 
//            cw, h, cr, cu

static final class 
    implements an
{

    public void a(cw cw1, Map map)
    {
        String s;
        s = (String)map.get("u");
        if (s == null)
        {
            ct.v("URL missing from click GMSG.");
            return;
        }
        map = Uri.parse(s);
        Object obj = cw1.aD();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!((h) (obj)).a(map))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((h) (obj)).a(map, cw1.getContext());
        map = ((Map) (obj));
_L2:
        map = map.toString();
        (new cr(cw1.getContext(), cw1.aE().iJ, map)).start();
        return;
        i j;
        j;
        ct.v((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
    }
}
