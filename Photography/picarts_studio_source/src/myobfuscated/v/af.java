// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.load.b;
import java.util.Collections;
import java.util.List;
import myobfuscated.f.m;

public final class af
{

    public final b a;
    public final List b;
    public final myobfuscated.q.b c;

    public af(b b1, List list, myobfuscated.q.b b2)
    {
        a = (b)m.a(b1, "Argument must not be null");
        b = (List)m.a(list, "Argument must not be null");
        c = (myobfuscated.q.b)m.a(b2, "Argument must not be null");
    }

    public af(b b1, myobfuscated.q.b b2)
    {
        this(b1, Collections.emptyList(), b2);
    }
}
