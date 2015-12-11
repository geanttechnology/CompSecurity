// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import java.util.concurrent.Callable;

// Referenced classes of package com.facebook:
//            i, b, s, AccessToken, 
//            Profile

static final class <init>
    implements Callable
{

    final a a;

    public Void a()
        throws Exception
    {
        b.a().c();
        s.a().c();
        if (AccessToken.a() != null && Profile.a() == null)
        {
            Profile.b();
        }
        if (a != null)
        {
            a.a();
        }
        return null;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    on(on on)
    {
        a = on;
        super();
    }
}
