// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import myobfuscated.ai.a;

// Referenced classes of package myobfuscated.v:
//            ae, af, h, g

public final class e
    implements ae
{

    private final g a;

    public e(g g)
    {
        a = g;
    }

    public final af buildLoadData(Object obj, int i, int j, com.bumptech.glide.load.e e1)
    {
        obj = (byte[])obj;
        return new af(myobfuscated.ai.a.a(), new h(((byte []) (obj)), a));
    }

    public final volatile boolean handles(Object obj)
    {
        return true;
    }
}
