// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.a;
import com.google.android.gms.location.places.internal.b;
import com.google.android.gms.location.places.internal.h;

// Referenced classes of package com.google.android.gms.location.places:
//            c, f

public class k
{

    public static final com.google.android.gms.common.api.a.d a;
    public static final com.google.android.gms.common.api.a.d b;
    public static final a c;
    public static final a d;
    public static final c e = new b();
    public static final f f = new h();

    static 
    {
        a = new com.google.android.gms.common.api.a.d();
        b = new com.google.android.gms.common.api.a.d();
        c = new a("Places.GEO_DATA_API", new com.google.android.gms.location.places.internal.c.a(null, null), a);
        d = new a("Places.PLACE_DETECTION_API", new com.google.android.gms.location.places.internal.i.a(null, null), b);
    }
}
