// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class bwk extends bmr
{

    bwk()
    {
    }

    public final Object a()
    {
        HashSet hashset = new HashSet();
        hashset.addAll(bwd.c());
        hashset.addAll(bwd.e());
        return Collections.unmodifiableSet(hashset);
    }
}
