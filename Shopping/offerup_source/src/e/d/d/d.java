// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import java.security.PrivilegedAction;

final class d
    implements PrivilegedAction
{

    d()
    {
    }

    public final Object run()
    {
        return ClassLoader.getSystemClassLoader();
    }
}
