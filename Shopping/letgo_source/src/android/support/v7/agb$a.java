// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.Writer;

// Referenced classes of package android.support.v7:
//            agb

private static final class <init> extends Writer
{
    static class a
        implements CharSequence
    {

        char a[];

        public char charAt(int i)
        {
            return a[i];
        }

        public int length()
        {
            return a.length;
        }

        public CharSequence subSequence(int i, int j)
        {
            return new String(a, i, j - i);
        }

        a()
        {
        }
    }


    private final Appendable a;
    private final a b;

    public void close()
    {
    }

    public void flush()
    {
    }

    public void write(int i)
        throws IOException
    {
        a.append((char)i);
    }

    public void write(char ac[], int i, int j)
        throws IOException
    {
        b.a = ac;
        a.append(b, i, i + j);
    }

    private a(Appendable appendable)
    {
        b = new a();
        a = appendable;
    }

    a(Appendable appendable, a a1)
    {
        this(appendable);
    }
}
