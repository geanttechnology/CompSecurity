// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p;

import android.content.res.Resources;
import com.shazam.model.Factory;

// Referenced classes of package com.shazam.android.p:
//            i

public final class j
    implements Factory
{

    public j()
    {
    }

    public final Object create(Object obj)
    {
        obj = (Resources)obj;
        return new i(((Resources) (obj)).getBoolean(0x7f0d0005), ((Resources) (obj)).getBoolean(0x7f0d0006), ((Resources) (obj)).getBoolean(0x7f0d0004), ((Resources) (obj)).getBoolean(0x7f0d0003));
    }
}
