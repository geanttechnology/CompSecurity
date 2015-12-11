// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.google.a.a.b;
import com.google.a.a.g;
import com.google.a.b.e;
import com.google.a.b.h;
import java.util.List;

public class f
    implements b
{

    private static final b sGetCardData = a();
    private static final g sOptionalIsPresent = new g() {

        public boolean a(com.google.a.a.e e1)
        {
            return e1.b();
        }

        public volatile boolean a(Object obj)
        {
            return a((com.google.a.a.e)obj);
        }

    };
    private final g mCanCardBeShownPredicate;
    private final b mToCardData;
    private final b mToCardNames;

    public f(b b1, b b2, g g)
    {
        mToCardNames = b1;
        mToCardData = b2;
        mCanCardBeShownPredicate = g;
    }

    private static b a()
    {
        return new b() {

            public Object a(com.google.a.a.e e1)
            {
                return e1.c();
            }

            public volatile Object a(Object obj)
            {
                return a((com.google.a.a.e)obj);
            }

        };
    }

    public h a(g.a a1)
    {
        a1 = (List)mToCardNames.a(a1);
        if (a1 == null)
        {
            return h.f();
        } else
        {
            return e.a(a1).a(mCanCardBeShownPredicate).a(mToCardData).a(sOptionalIsPresent).a(sGetCardData).a();
        }
    }

    public volatile Object a(Object obj)
    {
        return a((g.a)obj);
    }

}
