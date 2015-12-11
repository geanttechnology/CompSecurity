// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw, ad

public class ay
{
    public class a
    {

        public ay a;
        public int b;
        public aw c;
        public long d;
        public long e;
        public int f;
        public b g;
        public List h;
        final ay i;

        public a(ay ay2)
        {
            i = ay.this;
            super();
            g = null;
            a = ay2;
            b = 0;
            c = null;
            d = 0L;
            e = 0L;
            g = null;
            h = null;
        }
    }

    public static class b
    {

        public float a;
        public float b;
        public float c;
        public float d;

        public b(float f, float f1, float f2, float f3)
        {
            a = f;
            b = f1;
            c = f2;
            d = f3;
        }
    }


    private static int c = 0;
    List a;
    long b;

    public ay()
    {
        a = new ArrayList();
    }

    public int a(aw aw1, int i, b b1, List list)
    {
        if (aw1 != null && aw1.a() != aw.b.a)
        {
            a a1 = new a(this);
            a1.c = aw1;
            int j = c;
            c = j + 1;
            a1.b = j;
            a1.d = ad.D();
            j = i;
            if (i < 0)
            {
                j = 0;
            }
            a1.f = j;
            a1.g = b1;
            a1.h = list;
            a.add(a1);
            return a1.b;
        } else
        {
            return -1;
        }
    }

    public void a()
    {
        b = ad.D();
    }

    public boolean a(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            if (a1.b == i)
            {
                a1.e = ad.D() - a1.d;
                return true;
            }
        }

        return false;
    }

    public a b(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            if (a1.b == i)
            {
                return a1;
            }
        }

        return null;
    }

}
