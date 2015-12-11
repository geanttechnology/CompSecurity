// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import java.util.Arrays;
import shared_presage.com.google.android.exoplayer.util.Assertions;

final class h
{

    public byte a[];
    public int b;
    private final int c;
    private boolean d;
    private boolean e;

    public h(int i)
    {
        c = i;
        a = new byte[131];
        a[2] = 1;
    }

    public final void a()
    {
        d = false;
        e = false;
    }

    public final void a(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (!d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        if (i == c)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        d = flag;
        if (d)
        {
            b = 3;
            e = false;
        }
    }

    public final void a(byte abyte0[], int i, int j)
    {
        if (!d)
        {
            return;
        }
        j -= i;
        if (a.length < b + j)
        {
            a = Arrays.copyOf(a, (b + j) * 2);
        }
        System.arraycopy(abyte0, i, a, b, j);
        b = j + b;
    }

    public final boolean b()
    {
        return e;
    }

    public final boolean b(int i)
    {
        if (!d)
        {
            return false;
        } else
        {
            b = b - i;
            d = false;
            e = true;
            return true;
        }
    }
}
