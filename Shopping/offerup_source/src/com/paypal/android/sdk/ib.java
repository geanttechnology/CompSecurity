// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            hb, ia, hr, iu, 
//            ha, hn, id

final class ib extends hb
{

    private id a;
    private ia b;

    transient ib(ia ia1, String s, Object aobj[], id id1)
    {
        b = ia1;
        a = id1;
        super(s, aobj);
    }

    public final void c()
    {
        try
        {
            hr.f(b.a).a(a);
            return;
        }
        catch (IOException ioexception)
        {
            ha.a.log(Level.INFO, (new StringBuilder("StreamHandler failure for ")).append(hr.a(b.a)).toString(), ioexception);
        }
        try
        {
            a.a(hn.b);
            return;
        }
        catch (IOException ioexception1)
        {
            return;
        }
    }
}
