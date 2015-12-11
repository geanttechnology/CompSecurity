// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.io.UnsupportedEncodingException;

// Referenced classes of package cn.jpush.android.util:
//            e

public class c
{

    static final boolean a;
    private static final String z;

    private c()
    {
    }

    public static String a(byte abyte0[], int i)
    {
        byte byte0 = 1;
        e e1;
        int j;
        int k;
        k = abyte0.length;
        e1 = new e(10, null);
        j = (k / 3) * 4;
        if (!e1.d) goto _L2; else goto _L1
_L1:
        i = j;
        if (k % 3 > 0)
        {
            i = j + 4;
        }
_L9:
        if (!e1.e || k <= 0) goto _L4; else goto _L3
_L3:
        j = (k - 1) / 57;
        if (e1.f)
        {
            byte0 = 2;
        }
        i = byte0 * (j + 1) + i;
          goto _L5
_L4:
        try
        {
            e1.a = new byte[i];
            e1.a(abyte0, 0, k, true);
            if (!a && e1.b != i)
            {
                throw new AssertionError();
            }
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
          goto _L6
_L2:
        i = j;
        switch (k % 3)
        {
        case 0: // '\0'
            if (false)
            {
            }
            break;

        default:
            i = j;
            break;

        case 1: // '\001'
            i = j + 2;
            break;

        case 2: // '\002'
            i = j + 3;
            break;
        }
        break; /* Loop/switch isn't completed */
_L6:
        abyte0 = new String(e1.a, z);
        return abyte0;
_L5:
        if (true) goto _L4; else goto _L7
_L7:
        if (true) goto _L9; else goto _L8
_L8:
    }

    static 
    {
        char ac[];
        int i;
        int j;
        boolean flag;
        flag = false;
        ac = "h\021eka~\013\001".toCharArray();
        j = ac.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        i = 0;
_L8:
        int k;
        int l;
        l = i;
        k = i;
_L7:
        char ac1[];
        char c1;
        ac1 = ac;
        c1 = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 68
    //                   0 147
    //                   1 153
    //                   2 159
    //                   3 165;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 50;
_L9:
label0:
        {
            ac1[k] = (char)(i ^ c1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L7; else goto _L6
        k = j;
        ac1 = ac;
_L10:
        ac = ac1;
        j = k;
        i = l;
        if (k <= l)
        {
            z = (new String(ac1)).intern();
            if (!cn/jpush/android/util/c.desiredAssertionStatus())
            {
                flag = true;
            }
            a = flag;
            return;
        }
          goto _L8
_L6:
        i = 61;
          goto _L9
_L3:
        i = 66;
          goto _L9
_L4:
        i = 72;
          goto _L9
_L5:
        i = 42;
          goto _L9
        l = 0;
        ac1 = ac;
        k = j;
          goto _L10
    }
}
