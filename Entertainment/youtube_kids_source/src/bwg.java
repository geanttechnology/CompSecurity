// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class bwg extends bmr
{

    bwg()
    {
    }

    public final Object a()
    {
        HashSet hashset = new HashSet();
        hashset.add(Integer.valueOf(242));
        hashset.add(Integer.valueOf(243));
        hashset.add(Integer.valueOf(244));
        hashset.add(Integer.valueOf(247));
        hashset.add(Integer.valueOf(302));
        hashset.add(Integer.valueOf(248));
        hashset.add(Integer.valueOf(303));
        hashset.add(Integer.valueOf(271));
        hashset.add(Integer.valueOf(308));
        hashset.add(Integer.valueOf(313));
        hashset.add(Integer.valueOf(315));
        return Collections.unmodifiableSet(hashset);
    }
}
