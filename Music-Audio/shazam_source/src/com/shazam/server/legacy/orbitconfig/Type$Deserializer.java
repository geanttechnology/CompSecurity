// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.server.legacy.orbitconfig:
//            Type

public static class 
    implements k
{

    public com.shazam.server.legacy.orbitconfig.Type deserialize(l l1, Type type, j j)
    {
        return Type.fromString(l1.h().b());
    }

    public volatile Object deserialize(l l1, Type type, j j)
    {
        return deserialize(l1, type, j);
    }

    public ()
    {
    }
}
