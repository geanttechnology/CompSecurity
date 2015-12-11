// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gdata.util.common.base;


public abstract class UnicodeEscaper
{

    private static final ThreadLocal DEST_TL = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected char[] initialValue()
        {
            return new char[1024];
        }

    };

    public UnicodeEscaper()
    {
    }

    protected static final int codePointAt(CharSequence charsequence, int i, int j)
    {
        if (i < j)
        {
            int k = i + 1;
            char c = charsequence.charAt(i);
            if (c < '\uD800' || c > '\uDFFF')
            {
                return c;
            }
            if (c <= '\uDBFF')
            {
                if (k == j)
                {
                    return -c;
                }
                char c1 = charsequence.charAt(k);
                if (Character.isLowSurrogate(c1))
                {
                    return Character.toCodePoint(c, c1);
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Expected low surrogate but got char '").append(c1).append("' with value ").append(c1).append(" at index ").append(k).toString());
                }
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected low surrogate character '").append(c).append("' with value ").append(c).append(" at index ").append(k - 1).toString());
            }
        } else
        {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    private static final char[] growBuffer(char ac[], int i, int j)
    {
        char ac1[] = new char[j];
        if (i > 0)
        {
            System.arraycopy(ac, 0, ac1, 0, i);
        }
        return ac1;
    }

    public String escape(String s)
    {
        int i = s.length();
        int j = nextEscapeIndex(s, 0, i);
        if (j == i)
        {
            return s;
        } else
        {
            return escapeSlow(s, j);
        }
    }

    protected abstract char[] escape(int i);

    protected final String escapeSlow(String s, int i)
    {
        int k1 = s.length();
        char ac[] = (char[])DEST_TL.get();
        int j = 0;
        int j1 = 0;
        int i1 = i;
        i = j;
        while (i1 < k1) 
        {
            int l1 = codePointAt(s, i1, k1);
            if (l1 < 0)
            {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char ac4[] = escape(l1);
            char ac3[] = ac;
            j = i;
            if (ac4 != null)
            {
                j = i1 - j1;
                int k = i + j + ac4.length;
                char ac1[] = ac;
                if (ac.length < k)
                {
                    ac1 = growBuffer(ac, i, (k1 - i1) + k + 32);
                }
                k = i;
                if (j > 0)
                {
                    s.getChars(j1, i1, ac1, i);
                    k = i + j;
                }
                ac3 = ac1;
                j = k;
                if (ac4.length > 0)
                {
                    System.arraycopy(ac4, 0, ac1, k, ac4.length);
                    j = k + ac4.length;
                    ac3 = ac1;
                }
            }
            if (Character.isSupplementaryCodePoint(l1))
            {
                i = 2;
            } else
            {
                i = 1;
            }
            j1 = i1 + i;
            i1 = nextEscapeIndex(s, j1, k1);
            ac = ac3;
            i = j;
        }
        int l = k1 - j1;
        char ac2[] = ac;
        j = i;
        if (l > 0)
        {
            j = i + l;
            ac2 = ac;
            if (ac.length < j)
            {
                ac2 = growBuffer(ac, i, j);
            }
            s.getChars(j1, k1, ac2, i);
        }
        return new String(ac2, 0, j);
    }

    protected int nextEscapeIndex(CharSequence charsequence, int i, int j)
    {
        do
        {
            int k;
label0:
            {
                if (i < j)
                {
                    k = codePointAt(charsequence, i, j);
                    if (k >= 0 && escape(k) == null)
                    {
                        break label0;
                    }
                }
                return i;
            }
            if (Character.isSupplementaryCodePoint(k))
            {
                k = 2;
            } else
            {
                k = 1;
            }
            i += k;
        } while (true);
    }

}
