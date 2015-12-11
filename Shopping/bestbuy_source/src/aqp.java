// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;
import java.util.Set;

abstract class aqp
{

    private final Set a;

    public abstract wk a(Map map);

    public abstract boolean a();

    boolean a(Set set)
    {
        return set.containsAll(a);
    }

    public Set b()
    {
        return a;
    }
}
