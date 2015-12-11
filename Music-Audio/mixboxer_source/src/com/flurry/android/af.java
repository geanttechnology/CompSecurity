// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            fp, c, FlurryAgent

final class af extends fp
{

    private c bV;

    af(c c1)
    {
        bV = c1;
        super();
    }

    public final void c()
    {
        FlurryAgent.b(bV.l, bV.j);
    }
}
