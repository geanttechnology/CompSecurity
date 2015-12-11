// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


// Referenced classes of package com.g.c:
//            z, c, x

static final class ringBuilder extends z
{

    public final boolean a(x x)
    {
        return true;
    }

    public final ringBuilder b(x x)
    {
        throw new IllegalStateException((new StringBuilder("Unrecognized type of request: ")).append(x).toString());
    }

    ringBuilder()
    {
    }
}
