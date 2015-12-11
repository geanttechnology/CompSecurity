// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

public final class elt extends els
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private byte a[];

    public elt(byte abyte0[])
    {
        a = (byte[])f.b(abyte0);
    }

    public final int a()
    {
        boolean flag;
        if (a.length >= 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", new Object[] {
            Integer.valueOf(a.length)
        });
        return a[0] & 0xff | (a[1] & 0xff) << 8 | (a[2] & 0xff) << 16 | (a[3] & 0xff) << 24;
    }

    public final byte[] b()
    {
        return (byte[])a.clone();
    }

    public final int hashCode()
    {
        if (a.length < 4) goto _L2; else goto _L1
_L1:
        int k = a();
_L4:
        return k;
_L2:
        int i = a[0] & 0xff;
        int j = 1;
        do
        {
            k = i;
            if (j >= a.length)
            {
                continue;
            }
            i |= (a[j] & 0xff) << (j << 3);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
