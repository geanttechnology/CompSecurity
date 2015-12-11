// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class bwf extends bmr
{

    bwf()
    {
    }

    public final Object a()
    {
        HashSet hashset = new HashSet();
        hashset.add(Integer.valueOf(0));
        hashset.add(Integer.valueOf(93));
        hashset.add(Integer.valueOf(17));
        hashset.add(Integer.valueOf(18));
        hashset.add(Integer.valueOf(22));
        hashset.add(Integer.valueOf(36));
        hashset.add(Integer.valueOf(59));
        hashset.add(Integer.valueOf(78));
        hashset.add(Integer.valueOf(82));
        hashset.add(Integer.valueOf(83));
        hashset.add(Integer.valueOf(84));
        hashset.add(Integer.valueOf(85));
        return Collections.unmodifiableSet(hashset);
    }
}
