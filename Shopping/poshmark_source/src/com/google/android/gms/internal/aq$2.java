// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ar, aq, m, da, 
//            dd, l, cy, db

static final class 
    implements ar
{

    public void a(dd dd1, Map map)
    {
        String s;
        s = (String)map.get("u");
        if (s == null)
        {
            da.w("URL missing from click GMSG.");
            return;
        }
        map = Uri.parse(s);
        Object obj = dd1.bc();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!((l) (obj)).a(map))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((l) (obj)).a(map, dd1.getContext());
        map = ((Map) (obj));
_L2:
        map = map.toString();
        (new cy(dd1.getContext(), dd1.bd().pU, map)).start();
        return;
        m m1;
        m1;
        da.w((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
    }
}
