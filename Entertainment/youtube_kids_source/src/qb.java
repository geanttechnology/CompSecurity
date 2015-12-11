// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;

public final class qb
{

    public static final Map a;
    public static final Map b;

    static 
    {
        HashMap hashmap = new HashMap();
        a = hashmap;
        hashmap.put("VSS_CMT", Integer.valueOf(1));
        a.put("VSS_CPN", Integer.valueOf(2));
        a.put("VSS_STATE", Integer.valueOf(3));
        a.put("VSS_CONN", Integer.valueOf(4));
        a.put("VSS_RT", Integer.valueOf(5));
        a.put("VSS_VIS", Integer.valueOf(6));
        hashmap = new HashMap();
        b = hashmap;
        hashmap.put("VSS_CMT", "-1");
        b.put("VSS_CPN", "");
        b.put("VSS_STATE", "");
        b.put("VSS_CONN", "0");
        b.put("VSS_RT", "0");
        b.put("VSS_VIS", "0");
    }
}
