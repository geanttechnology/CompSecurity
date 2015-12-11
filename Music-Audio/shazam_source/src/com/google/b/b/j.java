// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import com.google.b.b.a.m;
import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.d.d;
import com.google.b.l;
import com.google.b.n;
import com.google.b.u;
import com.google.b.x;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class j
{
    private static final class a extends Writer
    {

        private final Appendable a;
        private final a b;

        public final void close()
        {
        }

        public final void flush()
        {
        }

        public final void write(int i)
        {
            a.append((char)i);
        }

        public final void write(char ac[], int i, int k)
        {
            b.a = ac;
            a.append(b, i, i + k);
        }

        private a(Appendable appendable)
        {
            b = new a();
            a = appendable;
        }

        a(Appendable appendable, byte byte0)
        {
            this(appendable);
        }
    }

    static final class a.a
        implements CharSequence
    {

        char a[];

        public final char charAt(int i)
        {
            return a[i];
        }

        public final int length()
        {
            return a.length;
        }

        public final CharSequence subSequence(int i, int k)
        {
            return new String(a, i, k - i);
        }

        a.a()
        {
        }
    }


    public static l a(com.google.b.d.a a1)
    {
        boolean flag = true;
        try
        {
            a1.f();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.b.d.a a1)
        {
            if (flag)
            {
                return n.a;
            } else
            {
                throw new u(a1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (com.google.b.d.a a1)
        {
            throw new u(a1);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.b.d.a a1)
        {
            throw new com.google.b.m(a1);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.b.d.a a1)
        {
            throw new u(a1);
        }
        flag = false;
        a1 = (l)m.P.a(a1);
        return a1;
    }

    public static Writer a(Appendable appendable)
    {
        if (appendable instanceof Writer)
        {
            return (Writer)appendable;
        } else
        {
            return new a(appendable, (byte)0);
        }
    }

    public static void a(l l1, c c)
    {
        m.P.a(c, l1);
    }
}
