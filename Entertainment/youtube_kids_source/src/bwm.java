// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class bwm extends bmr
{

    bwm()
    {
    }

    public final Object a()
    {
        HashSet hashset = new HashSet();
        hashset.add(Integer.valueOf(149));
        return Collections.unmodifiableSet(hashset);
    }
}
