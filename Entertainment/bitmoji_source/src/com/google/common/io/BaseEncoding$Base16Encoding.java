// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

static final class  extends oding
{

    final char encoding[];

    int decodeTo(byte abyte0[], CharSequence charsequence)
        throws on
    {
        Preconditions.checkNotNull(abyte0);
        if (charsequence.length() % 2 == 1)
        {
            int i = charsequence.length();
            throw new on((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
        }
        int j = 0;
        for (int k = 0; k < charsequence.length();)
        {
            abyte0[j] = (byte)(alphabet.(charsequence.charAt(k)) << 4 | alphabet.(charsequence.charAt(k + 1)));
            k += 2;
            j++;
        }

        return j;
    }

    void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
        throws IOException
    {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
        for (int k = 0; k < j; k++)
        {
            int l = abyte0[i + k] & 0xff;
            appendable.append(encoding[l]);
            appendable.append(encoding[l | 0x100]);
        }

    }

    BaseEncoding newInstance(encoding encoding1, Character character)
    {
        return new <init>(encoding1);
    }

    private on(on on)
    {
        super(on, null);
        encoding = new char[512];
        boolean flag;
        if (._mth000(on).length == 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        for (int i = 0; i < 256; i++)
        {
            encoding[i] = on.(i >>> 4);
            encoding[i | 0x100] = on.(i & 0xf);
        }

    }

    (String s, String s1)
    {
        this(new (s, s1.toCharArray()));
    }
}
