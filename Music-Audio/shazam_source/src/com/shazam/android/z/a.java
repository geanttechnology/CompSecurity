// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.z;

import com.shazam.i.i.c;
import com.shazam.model.Factory;

// Referenced classes of package com.shazam.android.z:
//            b

public final class a
    implements Factory
{

    public a()
    {
    }

    public final Object create(Object obj)
    {
        obj = (String)obj;
        return new b(c.b(), ((String) (obj)));
    }
}
