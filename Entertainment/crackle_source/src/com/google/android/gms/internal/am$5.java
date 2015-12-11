// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, am, ct, cr, 
//            cw, cu

static final class 
    implements an
{

    public void a(cw cw1, Map map)
    {
        map = (String)map.get("u");
        if (map == null)
        {
            ct.v("URL missing from httpTrack GMSG.");
            return;
        } else
        {
            (new cr(cw1.getContext(), cw1.aE().iJ, map)).start();
            return;
        }
    }

    ()
    {
    }
}
