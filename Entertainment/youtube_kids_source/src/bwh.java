// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class bwh extends bmr
{

    bwh()
    {
    }

    public final Object a()
    {
        HashSet hashset = new HashSet();
        hashset.addAll(bwd.a());
        hashset.addAll(bwd.b());
        return Collections.unmodifiableSet(hashset);
    }
}
