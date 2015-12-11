// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

final class bhn extends bmr
{

    private bgv a;

    bhn(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        Object obj = a;
        obj = new blc(((bgv) (obj)).d(), ((bgv) (obj)).h());
        HashMap hashmap = new HashMap();
        hashmap.put(blc.b, obj);
        return new bkx(hashmap, Executors.newSingleThreadExecutor());
    }
}
