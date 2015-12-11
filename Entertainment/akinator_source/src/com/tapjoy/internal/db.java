// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.HashSet;
import java.util.Iterator;

public final class db
{

    public static HashSet a(Iterator iterator)
    {
        HashSet hashset = new HashSet();
        for (; iterator.hasNext(); hashset.add(iterator.next())) { }
        return hashset;
    }
}
