// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.List;

final class elj extends elf
{

    elj(String s, int i)
    {
        super(s, 3);
    }

    public final int a(Comparator comparator, Object obj, List list, int i)
    {
        return b.a(comparator, obj, list, i) + 1;
    }
}
