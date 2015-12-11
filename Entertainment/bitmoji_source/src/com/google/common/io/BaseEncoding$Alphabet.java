// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

private static final class validPadding extends CharMatcher
{

    final int bitsPerChar;
    final int bytesPerChunk;
    private final char chars[];
    final int charsPerChunk;
    private final byte decodabet[];
    final int mask;
    private final String name;
    private final boolean validPadding[];

    private boolean hasLowerCase()
    {
        boolean flag1 = false;
        char ac[] = chars;
        int j = ac.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!Ascii.isLowerCase(ac[i]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private boolean hasUpperCase()
    {
        boolean flag1 = false;
        char ac[] = chars;
        int j = ac.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!Ascii.isUpperCase(ac[i]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    int decode(char c)
        throws xception
    {
        if (c > '\177' || decodabet[c] == -1)
        {
            Object obj;
            if (CharMatcher.INVISIBLE.matches(c))
            {
                obj = String.valueOf(Integer.toHexString(c));
                if (((String) (obj)).length() != 0)
                {
                    obj = "0x".concat(((String) (obj)));
                } else
                {
                    obj = new String("0x");
                }
            } else
            {
                obj = Character.valueOf(c);
            }
            obj = String.valueOf(obj);
            throw new xception((new StringBuilder(String.valueOf(obj).length() + 24)).append("Unrecognized character: ").append(((String) (obj))).toString());
        } else
        {
            return decodabet[c];
        }
    }

    char encode(int i)
    {
        return chars[i];
    }

    boolean isValidPaddingStartPosition(int i)
    {
        return validPadding[i % charsPerChunk];
    }

    charsPerChunk lowerCase()
    {
        if (!hasUpperCase())
        {
            return this;
        }
        char ac[];
        boolean flag;
        if (!hasLowerCase())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Cannot call lowerCase() on a mixed-case alphabet");
        ac = new char[chars.length];
        for (int i = 0; i < chars.length; i++)
        {
            ac[i] = Ascii.toLowerCase(chars[i]);
        }

        return new <init>(String.valueOf(name).concat(".lowerCase()"), ac);
    }

    public boolean matches(char c)
    {
        return CharMatcher.ASCII.matches(c) && decodabet[c] != -1;
    }

    public String toString()
    {
        return name;
    }

    name upperCase()
    {
        if (!hasLowerCase())
        {
            return this;
        }
        char ac[];
        boolean flag;
        if (!hasUpperCase())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Cannot call upperCase() on a mixed-case alphabet");
        ac = new char[chars.length];
        for (int i = 0; i < chars.length; i++)
        {
            ac[i] = Ascii.toUpperCase(chars[i]);
        }

        return new <init>(String.valueOf(name).concat(".upperCase()"), ac);
    }


    xception(String s, char ac[])
    {
        name = (String)Preconditions.checkNotNull(s);
        chars = (char[])Preconditions.checkNotNull(ac);
        int i;
        try
        {
            bitsPerChar = IntMath.log2(ac.length, RoundingMode.UNNECESSARY);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            int j = ac.length;
            throw new IllegalArgumentException((new StringBuilder(35)).append("Illegal alphabet length ").append(j).toString(), s);
        }
        i = Math.min(8, Integer.lowestOneBit(bitsPerChar));
        charsPerChunk = 8 / i;
        bytesPerChunk = bitsPerChar / i;
        mask = ac.length - 1;
        s = new byte[128];
        Arrays.fill(s, (byte)-1);
        i = 0;
        while (i < ac.length) 
        {
            char c = ac[i];
            Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", new Object[] {
                Character.valueOf(c)
            });
            boolean flag;
            if (s[c] == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Duplicate character: %s", new Object[] {
                Character.valueOf(c)
            });
            s[c] = (byte)i;
            i++;
        }
        decodabet = s;
        s = new boolean[charsPerChunk];
        for (int k = 0; k < bytesPerChunk; k++)
        {
            s[IntMath.divide(k * 8, bitsPerChar, RoundingMode.CEILING)] = 1;
        }

        validPadding = s;
    }
}
