// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import java.util.LinkedHashMap;

final class b extends LinkedHashMap
{

    b()
    {
        super(7);
    }

    protected final boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        return size() > 500;
    }
}
