// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.maps.model.a.f;
import com.google.android.gms.maps.model.c;

// Referenced classes of package com.google.android.gms.maps:
//            c

public final class nit> extends com.google.android.gms.maps.a.t>
{

    final l.a.f a;
    final com.google.android.gms.maps.c b;

    public final void a(f f)
    {
        a.onInfoWindowClick(new c(f));
    }

    public l.a.f(com.google.android.gms.maps.c c1, l.a.f f)
    {
        b = c1;
        a = f;
        super();
    }
}
