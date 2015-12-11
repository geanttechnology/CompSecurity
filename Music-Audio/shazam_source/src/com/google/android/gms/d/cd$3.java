// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.p;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, cd, ay, ax, 
//            he

static final class ernal.p
    implements ce
{

    public final void a(he he1, Map map)
    {
        au au = ay.ai;
        if (!((Boolean)p.n().a(au)).booleanValue())
        {
            return;
        }
        boolean flag;
        if (!Boolean.parseBoolean((String)map.get("disabled")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        he1.d(flag);
    }

    ernal.p()
    {
    }
}
