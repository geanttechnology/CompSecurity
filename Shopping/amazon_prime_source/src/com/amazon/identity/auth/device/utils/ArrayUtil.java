// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ArrayUtil
{

    public static transient Set asSet(Object aobj[])
    {
        HashSet hashset = new HashSet();
        hashset.addAll(Arrays.asList(aobj));
        return hashset;
    }
}
