// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            af, et, ew

final class ad
    implements af
{

    ad()
    {
    }

    public final void a(ew ew, Map map)
    {
        et.b((new StringBuilder("Received log message: ")).append((String)map.get("string")).toString());
    }
}
