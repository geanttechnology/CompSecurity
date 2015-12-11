// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import java.io.Writer;

// Referenced classes of package com.google.b.b:
//            j

private static final class e extends Writer
{
    static final class a
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

        a()
        {
        }
    }


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

    private e(Appendable appendable)
    {
        b = new a();
        a = appendable;
    }

    e(Appendable appendable, byte byte0)
    {
        this(appendable);
    }
}
