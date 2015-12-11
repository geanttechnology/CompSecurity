// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata;

import com.google.android.gms.internal.ha;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class b
{

    public final String a;
    private final Set b;

    public b(String s)
    {
        a = (String)ha.a(s, "fieldName");
        b = Collections.singleton(s);
    }

    public b(String s, Collection collection)
    {
        a = (String)ha.a(s, "fieldName");
        b = Collections.unmodifiableSet(new HashSet(collection));
    }

    public String toString()
    {
        return a;
    }
}
