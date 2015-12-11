// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ba;

import com.shazam.android.persistence.n.b;

// Referenced classes of package com.shazam.android.ba:
//            f

public final class c
    implements f
{

    b a;

    public c(b b1)
    {
        a = b1;
    }

    public final void a()
    {
        a.b("pk_version_upgraded_from_previous_version", true);
    }
}
