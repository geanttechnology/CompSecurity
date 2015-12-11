// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.gdata;

import java.io.IOException;

// Referenced classes of package com.parse.gdata:
//            UnicodeEscaper

class decodedChars
    implements Appendable
{

    char decodedChars[];
    int pendingHighSurrogate;
    final UnicodeEscaper this$0;
    final Appendable val$out;

    private void outputChars(char ac[], int i)
        throws IOException
    {
        for (int j = 0; j < i; j++)
        {
            val$out.append(ac[j]);
        }

    }

    public Appendable append(char c)
        throws IOException
    {
        if (pendingHighSurrogate != -1)
        {
            if (!Character.isLowSurrogate(c))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Expected low surrogate character but got '").append(c).append("' with value ").append(c).toString());
            }
            char ac[] = escape(Character.toCodePoint((char)pendingHighSurrogate, c));
            if (ac != null)
            {
                outputChars(ac, ac.length);
            } else
            {
                val$out.append((char)pendingHighSurrogate);
                val$out.append(c);
            }
            pendingHighSurrogate = -1;
            return this;
        }
        if (Character.isHighSurrogate(c))
        {
            pendingHighSurrogate = c;
            return this;
        }
        if (Character.isLowSurrogate(c))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected low surrogate character '").append(c).append("' with value ").append(c).toString());
        }
        char ac1[] = escape(c);
        if (ac1 != null)
        {
            outputChars(ac1, ac1.length);
            return this;
        } else
        {
            val$out.append(c);
            return this;
        }
    }

    public Appendable append(CharSequence charsequence)
        throws IOException
    {
        return append(charsequence, 0, charsequence.length());
    }

    public Appendable append(CharSequence charsequence, int i, int j)
        throws IOException
    {
label0:
        {
label1:
            {
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    char ac1[];
                    int k;
                    int l;
                    if (pendingHighSurrogate != -1)
                    {
                        k = i + 1;
                        char c = charsequence.charAt(i);
                        if (!Character.isLowSurrogate(c))
                        {
                            throw new IllegalArgumentException((new StringBuilder()).append("Expected low surrogate character but got ").append(c).toString());
                        }
                        char ac[] = escape(Character.toCodePoint((char)pendingHighSurrogate, c));
                        if (ac != null)
                        {
                            outputChars(ac, ac.length);
                            i++;
                        } else
                        {
                            val$out.append((char)pendingHighSurrogate);
                        }
                        pendingHighSurrogate = -1;
                    } else
                    {
                        k = i;
                    }
                }
                k = nextEscapeIndex(charsequence, k, j);
                if (k > i)
                {
                    val$out.append(charsequence, i, k);
                }
                if (k != j)
                {
                    break label0;
                }
            }
            return this;
        }
        i = UnicodeEscaper.codePointAt(charsequence, k, j);
        if (i < 0)
        {
            pendingHighSurrogate = -i;
            return this;
        }
        ac1 = escape(i);
        if (ac1 != null)
        {
            outputChars(ac1, ac1.length);
        } else
        {
            l = Character.toChars(i, decodedChars, 0);
            outputChars(decodedChars, l);
        }
        if (Character.isSupplementaryCodePoint(i))
        {
            i = 2;
        } else
        {
            i = 1;
        }
        i = k + i;
        k = i;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_105;
        }
    }

    n()
    {
        this$0 = final_unicodeescaper;
        val$out = Appendable.this;
        super();
        pendingHighSurrogate = -1;
        decodedChars = new char[2];
    }
}
