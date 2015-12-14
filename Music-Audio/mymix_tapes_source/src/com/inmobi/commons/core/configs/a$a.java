// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import java.util.HashMap;

// Referenced classes of package com.inmobi.commons.core.configs:
//            a

public static final class a
{

    private HashMap a;

    static HashMap a(a a1)
    {
        return a1.a;
    }

    public HashMap a()
    {
        return a;
    }

    public ()
    {
        a = new HashMap();
        a.put("O1", Boolean.valueOf(true));
        a.put("SID", Boolean.valueOf(true));
        a.put("LID", Boolean.valueOf(true));
        a.put("UM5", Boolean.valueOf(true));
        a.put("GPID", Boolean.valueOf(true));
        a.put("IMID", Boolean.valueOf(true));
        a.put("AIDL", Boolean.valueOf(true));
    }
}
