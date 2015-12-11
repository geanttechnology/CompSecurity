// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            al, gx

public class ak extends al
{

    private static final String a = com/flurry/sdk/al.getSimpleName();
    private final gx b;

    public ak(gx gx, String s, long l, boolean flag)
    {
        super(s, l, flag);
        if (gx == null)
        {
            throw new IllegalArgumentException("Serializer cannot be null");
        } else
        {
            b = gx;
            return;
        }
    }

}
