// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import java.util.concurrent.Callable;

// Referenced classes of package com.facebook:
//            k, b, a, u, 
//            t, AccessToken, Profile

static final class <init>
    implements Callable
{

    final a a;

    public final Object call()
    {
        Object obj = b.a();
        Object obj1 = ((b) (obj)).a.a();
        if (obj1 != null)
        {
            ((b) (obj)).a(((AccessToken) (obj1)), false);
        }
        obj = u.a();
        obj1 = ((u) (obj)).a.a();
        if (obj1 != null)
        {
            ((u) (obj)).a(((Profile) (obj1)), false);
        }
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

    ile(ile ile)
    {
        a = ile;
        super();
    }
}
