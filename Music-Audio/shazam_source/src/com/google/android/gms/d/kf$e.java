// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            kf

public static final class <init>
{

    public final List a;
    public final List b;
    public final List c;
    public final List d;
    public final List e;
    public final List f;
    private final List g;
    private final List h;
    private final List i;
    private final List j;

    public final String toString()
    {
        return (new StringBuilder("Positive predicates: ")).append(a).append("  Negative predicates: ").append(b).append("  Add tags: ").append(c).append("  Remove tags: ").append(d).append("  Add macros: ").append(e).append("  Remove macros: ").append(f).toString();
    }

    private (List list, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9)
    {
        a = Collections.unmodifiableList(list);
        b = Collections.unmodifiableList(list1);
        c = Collections.unmodifiableList(list2);
        d = Collections.unmodifiableList(list3);
        e = Collections.unmodifiableList(list4);
        f = Collections.unmodifiableList(list5);
        g = Collections.unmodifiableList(list6);
        h = Collections.unmodifiableList(list7);
        i = Collections.unmodifiableList(list8);
        j = Collections.unmodifiableList(list9);
    }

    ableList(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9, byte byte0)
    {
        this(list, list1, list2, list3, list4, list5, list6, list7, list8, list9);
    }
}
