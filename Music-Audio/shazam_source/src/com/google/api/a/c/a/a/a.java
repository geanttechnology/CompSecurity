// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.a.a;

import com.google.api.a.a.a.b;
import com.google.api.a.a.a.d;
import com.google.api.a.a.a.f;
import com.google.api.a.a.a.j;
import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.v;
import com.google.api.a.e.c;
import com.google.api.a.g.w;
import java.util.Collection;

// Referenced classes of package com.google.api.a.c.a.a:
//            b, c

public final class com.google.api.a.c.a.a.a extends com.google.api.a.a.a.a
{
    public static final class a extends com.google.api.a.a.a.a
    {

        String o;
        String p;

        private a b(Collection collection)
        {
            boolean flag;
            if (!collection.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.b(flag);
            return (a)super.a(collection);
        }

        public final volatile com.google.api.a.a.a.a a(com.google.api.a.a.a.b b1)
        {
            return (a)super.a(b1);
        }

        public final volatile com.google.api.a.a.a.a a(com.google.api.a.a.a.i.a a1)
        {
            return (a)super.a(a1);
        }

        public final volatile com.google.api.a.a.a.a a(j j1)
        {
            return (a)super.a(j1);
        }

        public final volatile com.google.api.a.a.a.a a(h h1)
        {
            return (a)super.a(h1);
        }

        public final volatile com.google.api.a.a.a.a a(l l)
        {
            return (a)super.a(l);
        }

        public final volatile com.google.api.a.a.a.a a(v v)
        {
            return (a)super.a(v);
        }

        public final volatile com.google.api.a.a.a.a a(c c1)
        {
            return (a)super.a(c1);
        }

        public final volatile com.google.api.a.a.a.a a(com.google.api.a.g.b.d d)
        {
            return (a)super.a(d);
        }

        public final volatile com.google.api.a.a.a.a a(String s)
        {
            return (a)super.a(s);
        }

        public final com.google.api.a.a.a.a a(Collection collection)
        {
            return b(collection);
        }

        public final com.google.api.a.a.a.a a()
        {
            return b();
        }

        public final volatile com.google.api.a.a.a.a b(String s)
        {
            return (a)super.b(s);
        }

        public final com.google.api.a.c.a.a.a b()
        {
            return new com.google.api.a.c.a.a.a(this);
        }

        public a(v v, c c1, String s, String s1, Collection collection)
        {
            super(f.a(), v, c1, new h("https://accounts.google.com/o/oauth2/token"), new com.google.api.a.a.a.h(s, s1), s, "https://accounts.google.com/o/oauth2/auth");
            b(collection);
        }
    }


    private final String i;
    private final String j;

    protected com.google.api.a.c.a.a.a(a a1)
    {
        super(a1);
        j = a1.p;
        i = a1.o;
    }

    public final b a()
    {
        com.google.api.a.c.a.a.b b1 = new com.google.api.a.c.a.a.b(super.f, super.e, "", super.h);
        b1.accessType = j;
        b1.approvalPrompt = i;
        return b1;
    }

    public final d a(String s)
    {
        return (new com.google.api.a.c.a.a.c(super.a, super.b, super.c, "", "", s, "")).c(super.d).c(super.g).c(super.h);
    }
}
