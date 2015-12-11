// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.List;

public abstract class elf extends Enum
{

    public static final elf a;
    public static final elf b;
    public static final elf c;
    public static final elf d;
    private static elf e;
    private static final elf f[];

    elf(String s, int i)
    {
        super(s, i);
    }

    public static elf valueOf(String s)
    {
        return (elf)Enum.valueOf(elf, s);
    }

    public static elf[] values()
    {
        return (elf[])f.clone();
    }

    public abstract int a(Comparator comparator, Object obj, List list, int i);

    static 
    {
        a = new elg("ANY_PRESENT", 0);
        b = new elh("LAST_PRESENT", 1);
        c = new eli("FIRST_PRESENT", 2);
        d = new elj("FIRST_AFTER", 3);
        e = new elk("LAST_BEFORE", 4);
        f = (new elf[] {
            a, b, c, d, e
        });
    }
}
