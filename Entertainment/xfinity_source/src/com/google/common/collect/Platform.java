// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.lang.reflect.Array;

class Platform
{

    static Object[] clone(Object aobj[])
    {
        return (Object[])((Object []) (aobj)).clone();
    }

    static Object[] newArray(Object aobj[], int i)
    {
        return (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i);
    }
}
