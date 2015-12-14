// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.Arrays;

public abstract class b
{

    public static Object[] a(Object aobj[], Object aobj1[])
    {
        Object aobj2[] = Arrays.copyOf(aobj, aobj.length + aobj1.length);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), aobj.length, aobj1.length);
        return aobj2;
    }
}
