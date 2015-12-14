// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;


// Referenced classes of package com.tencent.mm.algorithm:
//            LRUMap

public class UpTime
{

    final LRUMap g;
    public Object obj;
    public Long t;

    public void UpTime()
    {
        t = Long.valueOf(System.currentTimeMillis());
    }

    public (LRUMap lrumap, Object obj1)
    {
        g = lrumap;
        super();
        obj = obj1;
        UpTime();
    }
}
