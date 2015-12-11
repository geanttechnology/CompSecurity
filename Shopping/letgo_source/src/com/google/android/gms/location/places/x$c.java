// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.location.places:
//            x, e

public static abstract class er extends er
{

    protected e a(Status status)
    {
        return new e(DataHolder.b(status.g()), null);
    }

    protected g b(Status status)
    {
        return a(status);
    }
}
