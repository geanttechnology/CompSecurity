// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.location.Location;
import com.google.android.gms.location.g;

// Referenced classes of package com.google.android.gms.location.internal:
//            i, h

public final class c
    implements com.google.android.gms.location.c
{

    public c()
    {
    }

    public final Location a(com.google.android.gms.common.api.c c1)
    {
        c1 = g.a(c1);
        try
        {
            c1 = ((i) (c1)).g.a();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.c c1)
        {
            return null;
        }
        return c1;
    }
}
