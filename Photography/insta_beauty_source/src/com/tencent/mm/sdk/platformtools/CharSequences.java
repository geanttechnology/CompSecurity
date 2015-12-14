// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


public class CharSequences
{

    public CharSequences()
    {
    }

    static void a(int i, int j, int k)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j > k)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i > j)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static int compareToIgnoreCase(CharSequence charsequence, CharSequence charsequence1)
    {
        int k = 0;
        int l = charsequence.length();
        int i1 = charsequence1.length();
        int i;
        int j;
        if (l < i1)
        {
            i = l;
        } else
        {
            i = i1;
        }
        j = 0;
        do
        {
            if (j < i)
            {
                int j1 = Character.toLowerCase(charsequence.charAt(j)) - Character.toLowerCase(charsequence1.charAt(k));
                if (j1 != 0)
                {
                    return j1;
                }
            } else
            {
                return l - i1;
            }
            k++;
            j++;
        } while (true);
    }

    public static boolean equals(CharSequence charsequence, CharSequence charsequence1)
    {
        if (charsequence.length() == charsequence1.length()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = charsequence.length();
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (charsequence.charAt(i) != charsequence1.charAt(i))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static CharSequence forAsciiBytes(byte abyte0[])
    {
        return new _cls1(abyte0);
    }

    public static CharSequence forAsciiBytes(byte abyte0[], int i, int j)
    {
        a(i, j, abyte0.length);
        return new _cls2(abyte0, i, j);
    }

    private class _cls1
        implements CharSequence
    {

        final byte U[];

        public final char charAt(int i)
        {
            return (char)U[i];
        }

        public final int length()
        {
            return U.length;
        }

        public final CharSequence subSequence(int i, int j)
        {
            return CharSequences.forAsciiBytes(U, i, j);
        }

        public final String toString()
        {
            return new String(U);
        }

        _cls1(byte abyte0[])
        {
            U = abyte0;
            super();
        }
    }


    private class _cls2
        implements CharSequence
    {

        final byte U[];
        final int V;
        final int W;

        public final char charAt(int i)
        {
            return (char)U[V + i];
        }

        public final int length()
        {
            return W - V;
        }

        public final CharSequence subSequence(int i, int j)
        {
            i -= V;
            j -= V;
            CharSequences.a(i, j, length());
            return CharSequences.forAsciiBytes(U, i, j);
        }

        public final String toString()
        {
            return new String(U, V, length());
        }

        _cls2(byte abyte0[], int i, int j)
        {
            U = abyte0;
            V = i;
            W = j;
            super();
        }
    }

}
