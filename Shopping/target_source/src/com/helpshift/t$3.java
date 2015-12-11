// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            m, t

static final class init>
    implements m
{

    final HashMap a;

    public HashMap a()
    {
        if (a.get("hs-custom-metadata") instanceof HashMap)
        {
            return (HashMap)a.get("hs-custom-metadata");
        } else
        {
            return null;
        }
    }

    (HashMap hashmap)
    {
        a = hashmap;
        super();
    }
}
