// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class cov
{

    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "next", "previous"
    })));

    public static bnr a()
    {
        return a("/feed");
    }

    public static bnr a(String s)
    {
        b.a(s);
        bnr bnr1 = new bnr();
        bnr1.a(s, new cpa()).a(String.valueOf(s).concat("/openSearch:totalResults"), new coz()).a(String.valueOf(s).concat("/openSearch:startIndex"), new coy()).a(String.valueOf(s).concat("/openSearch:itemsPerPage"), new cox()).a(String.valueOf(s).concat("/link"), new cow());
        return bnr1;
    }

    public static bnr b(String s)
    {
        b.a(s);
        bnr bnr1 = new bnr();
        bnr1.a(s, new cpb());
        return bnr1;
    }

    static Set b()
    {
        return a;
    }

}
