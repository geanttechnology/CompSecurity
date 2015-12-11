// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Arrays;
import java.util.Stack;

// Referenced classes of package com.tapjoy.internal:
//            eb, do

static final class <init>
{

    final Stack a;

    private static int a(int i)
    {
        int j = Arrays.binarySearch(eb.b(), i);
        i = j;
        if (j < 0)
        {
            i = -(j + 1) - 1;
        }
        return i;
    }

    final void a(do do1)
    {
        do
        {
            if (do1.j())
            {
                int i = a(do1.a());
                int k = eb.b()[i + 1];
                if (a.isEmpty() || ((do)a.peek()).a() >= k)
                {
                    a.push(do1);
                    return;
                }
                i = eb.b()[i];
                Object obj;
                for (obj = (do)a.pop(); !a.isEmpty() && ((do)a.peek()).a() < i; obj = new eb((do)a.pop(), ((do) (obj)), (byte)0)) { }
                do1 = new eb(((do) (obj)), do1, (byte)0);
                do
                {
                    if (a.isEmpty())
                    {
                        break;
                    }
                    int j = a(do1.a());
                    j = eb.b()[j + 1];
                    if (((do)a.peek()).a() >= j)
                    {
                        break;
                    }
                    do1 = new eb((do)a.pop(), do1, (byte)0);
                } while (true);
                a.push(do1);
                return;
            }
            if (do1 instanceof eb)
            {
                do1 = (eb)do1;
                a(eb.a(do1));
                do1 = eb.b(do1);
            } else
            {
                do1 = String.valueOf(String.valueOf(do1.getClass()));
                throw new IllegalArgumentException((new StringBuilder(do1.length() + 49)).append("Has a new type of ByteString been created? Found ").append(do1).toString());
            }
        } while (true);
    }

    private Exception()
    {
        a = new Stack();
    }

    a(byte byte0)
    {
        this();
    }
}
