// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

// Referenced classes of package com.flurry.sdk:
//            ka, jx, jv, ir, 
//            ig, ii, io, ih, 
//            jz

public final class jh
{

    public static ig a(jx jx1)
    {
        boolean flag = true;
        try
        {
            jx1.f();
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            if (flag)
            {
                return ii.a;
            } else
            {
                throw new io(jx1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new io(jx1);
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new ih(jx1);
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new io(jx1);
        }
        flag = false;
        jx1 = (ig)jv.P.b(jx1);
        return jx1;
    }

    public static Writer a(Appendable appendable)
    {
        if (appendable instanceof Writer)
        {
            return (Writer)appendable;
        } else
        {
            return new a(appendable);
        }
    }

    public static void a(ig ig1, jz jz)
    {
        jv.P.a(jz, ig1);
    }

    private class a extends Writer
    {

        private final Appendable a;
        private final a b;

        public void close()
        {
        }

        public void flush()
        {
        }

        public void write(int i)
        {
            a.append((char)i);
        }

        public void write(char ac[], int i, int j)
        {
            b.a = ac;
            a.append(b, i, i + j);
        }

        private a(Appendable appendable)
        {
            class a
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

            b = new a();
            a = appendable;
        }

    }

}
