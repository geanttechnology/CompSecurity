// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.io.IOException;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

static final class  extends oding
{

    int decodeTo(byte abyte0[], CharSequence charsequence)
        throws on
    {
        Preconditions.checkNotNull(abyte0);
        charsequence = padding().trimTrailingFrom(charsequence);
        if (!alphabet.dPaddingStartPosition(charsequence.length()))
        {
            int i = charsequence.length();
            throw new on((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
        }
        int j = 0;
        int k = 0;
        do
        {
            if (k >= charsequence.length())
            {
                break;
            }
            oding oding = alphabet;
            int j1 = k + 1;
            k = oding.(charsequence.charAt(k));
            oding = alphabet;
            int l = j1 + 1;
            int l1 = k << 18 | oding.(charsequence.charAt(j1)) << 12;
            j1 = j + 1;
            abyte0[j] = (byte)(l1 >>> 16);
            j = j1;
            k = l;
            if (l < charsequence.length())
            {
                oding oding1 = alphabet;
                k = l + 1;
                l1 |= oding1.(charsequence.charAt(l)) << 6;
                j = j1 + 1;
                abyte0[j1] = (byte)(l1 >>> 8 & 0xff);
                if (k < charsequence.length())
                {
                    oding oding2 = alphabet;
                    int i1 = k + 1;
                    k = oding2.(charsequence.charAt(k));
                    int k1 = j + 1;
                    abyte0[j] = (byte)((l1 | k) & 0xff);
                    k = i1;
                    j = k1;
                }
            }
        } while (true);
        return j;
    }

    void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
        throws IOException
    {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
        int k = j;
        int l;
        for (l = i; k >= 3; l++)
        {
            int i1 = l + 1;
            byte byte0 = abyte0[l];
            l = i1 + 1;
            i1 = (byte0 & 0xff) << 16 | (abyte0[i1] & 0xff) << 8 | abyte0[l] & 0xff;
            appendable.append(alphabet.(i1 >>> 18));
            appendable.append(alphabet.(i1 >>> 12 & 0x3f));
            appendable.append(alphabet.(i1 >>> 6 & 0x3f));
            appendable.append(alphabet.(i1 & 0x3f));
            k -= 3;
        }

        if (l < i + j)
        {
            encodeChunkTo(appendable, abyte0, l, (i + j) - l);
        }
    }

    BaseEncoding newInstance(encodeChunkTo encodechunkto, Character character)
    {
        return new <init>(encodechunkto, character);
    }

    private on(on on, Character character)
    {
        super(on, character);
        boolean flag;
        if (._mth000(on).length == 64)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
    }

    t(String s, String s1, Character character)
    {
        this(new (s, s1.toCharArray()), character);
    }
}
