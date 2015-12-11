// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b.b;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e
{

    public static transient Set a(Object aobj[])
    {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(aobj)));
    }
}
