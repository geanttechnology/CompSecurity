// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.CharArrayWriter;

public class cej
{

    private static final String b = cej.getCanonicalName();
    cel a;
    private int c;
    private int d;
    private final CharArrayWriter e = new CharArrayWriter();
    private final CharArrayWriter f = new CharArrayWriter();

    public cej()
    {
        c = 1;
    }

    private int a(char ac[], int i, int j)
    {
        for (int k = 0; k < j; k++)
        {
            if (ac[i + k] == '\n')
            {
                e.write(ac, i, k);
                ac = e.toString();
                try
                {
                    d = Integer.parseInt(ac, 10);
                }
                catch (NumberFormatException numberformatexception)
                {
                    String s = b;
                    ac = String.valueOf(ac);
                    if (ac.length() != 0)
                    {
                        ac = "Error parsing chunk length: ".concat(ac);
                    } else
                    {
                        ac = new String("Error parsing chunk length: ");
                    }
                    Log.e(s, ac, numberformatexception);
                    c = 1;
                    e.reset();
                    return k + 1;
                }
                c = 2;
                e.reset();
                return k + 1;
            }
        }

        e.write(ac, i, j);
        return j;
    }

    public static void a(int i)
    {
        if (i == 404)
        {
            throw new cfd((new StringBuilder(37)).append("Unexpected response code: ").append(i).toString());
        }
        if (i != 200)
        {
            throw new cfe(i);
        } else
        {
            return;
        }
    }

    public final int a(char ac[])
    {
        int i;
        int l;
        int i1;
        i1 = ac.length;
        i = i1;
        l = 0;
_L2:
        int j;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        switch (cek.a[c - 1])
        {
        default:
            j = i;
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_75;
        }
_L3:
        l += j;
        i -= j;
        if (true) goto _L2; else goto _L1
_L1:
        j = a(ac, l, i);
          goto _L3
        int k;
        if (i >= d)
        {
            k = d;
            c = 1;
        } else
        {
            k = i;
        }
        f.write(ac, l, k);
        d = d - k;
        j = k;
        if (d == 0)
        {
            if (a != null)
            {
                a.a(f.toString());
            }
            f.reset();
            j = k;
        }
          goto _L3
        return i1 - i;
    }

    protected void finalize()
    {
        if (2 == c)
        {
            Log.w(b, "Lost partial chunk");
        }
    }

}
