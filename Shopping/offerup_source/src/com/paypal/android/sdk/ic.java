// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            hb, ia, hr, hq, 
//            jb

final class ic extends hb
{

    private jb a;
    private ia b;

    transient ic(ia ia1, String s, Object aobj[], jb jb)
    {
        b = ia1;
        a = jb;
        super(s, aobj);
    }

    public final void c()
    {
        try
        {
            b.a.i.a(a);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
