// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;

public final class bdm
    implements bjp
{

    private bdi a;

    public bdm(bdi bdi1)
    {
        a = bdi1;
        super();
    }

    public final Object b_()
    {
        bdi bdi1 = a;
        HashMap hashmap = new HashMap();
        hashmap.put(bdi1.b(), bdi1.a());
        return hashmap;
    }
}
