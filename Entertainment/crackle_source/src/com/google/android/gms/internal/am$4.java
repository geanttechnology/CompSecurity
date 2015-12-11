// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, am, cw, ct, 
//            bk

static final class 
    implements an
{

    public void a(cw cw1, Map map)
    {
        cw1 = cw1.aB();
        if (cw1 == null)
        {
            ct.v("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            return;
        } else
        {
            cw1.g("1".equals(map.get("custom_close")));
            return;
        }
    }

    ()
    {
    }
}
