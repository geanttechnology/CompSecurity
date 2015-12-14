// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;


// Referenced classes of package com.facebook.imagepipeline.memory:
//            BasePool

public static class  extends RuntimeException
{

    public (int i, int j, int k, int l)
    {
        super((new StringBuilder()).append("Pool hard cap violation? Hard cap = ").append(i).append(" Used size = ").append(j).append(" Free size = ").append(k).append(" Request size = ").append(l).toString());
    }
}
