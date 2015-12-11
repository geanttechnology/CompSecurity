// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, jp, et, ew, 
//            jg, eq, cu, ee, 
//            eg

final class z
    implements af
{

    z()
    {
    }

    public final void a(ew ew1, Map map)
    {
        String s;
        s = (String)map.get("u");
        if (s == null)
        {
            et.d("URL missing from click GMSG.");
            return;
        }
        map = Uri.parse(s);
        Object obj = ew1.c;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!((jg) (obj)).a(map))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((jg) (obj)).a(map, ew1.getContext());
        map = ((Map) (obj));
_L2:
        map = map.toString();
        eg.a(((ee) (new eq(ew1.getContext(), ew1.d.b, map))).e);
        return;
        jp jp1;
        jp1;
        et.d((new StringBuilder("Unable to append parameter to URL: ")).append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }
}
