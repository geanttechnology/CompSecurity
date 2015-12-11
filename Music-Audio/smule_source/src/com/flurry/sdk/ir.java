// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.IOException;

// Referenced classes of package com.flurry.sdk:
//            jo, ih, ig, jz, 
//            jx

public abstract class ir
{

    public ir()
    {
    }

    public final ig a(Object obj)
    {
        try
        {
            jo jo1 = new jo();
            a(((jz) (jo1)), obj);
            obj = jo1.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ih(((Throwable) (obj)));
        }
        return ((ig) (obj));
    }

    public abstract void a(jz jz, Object obj);

    public abstract Object b(jx jx);
}
