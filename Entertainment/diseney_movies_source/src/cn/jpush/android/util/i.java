// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class i
{

    public static String a;
    private static final String z;

    public static String a()
    {
        return (new SimpleDateFormat(z)).format(new Date());
    }

    static 
    {
        Object obj;
        int l;
        obj = "\030%\007 +,\021S=b>\0246ck\ff\r*";
        l = -1;
_L10:
        int j;
        int k;
        int j1;
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        j = 0;
        j1 = l;
_L9:
        int i1;
        i1 = j;
        l = j;
_L7:
        char ac[];
        int k1;
        ac = ((char []) (obj));
        k1 = ac[l];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 173
    //                   1 179
    //                   2 185
    //                   3 191;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        j = 6;
_L11:
label0:
        {
            ac[l] = (char)(j ^ k1);
            i1++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        l = k;
        ac = ((char []) (obj));
        k1 = j1;
_L12:
        j1 = k1;
        obj = ac;
        k = l;
        j = i1;
        if (l > i1) goto _L9; else goto _L8
_L8:
        obj = (new String(ac)).intern();
        switch (k1)
        {
        default:
            z = ((String) (obj));
            obj = "\030%\007 K,8\032\006N)1\023";
            l = 0;
            break;

        case 0: // '\0'
            a = ((String) (obj));
            return;
        }
          goto _L10
_L6:
        j = 97;
          goto _L11
_L3:
        j = 92;
          goto _L11
_L4:
        j = 126;
          goto _L11
_L5:
        j = 89;
          goto _L11
        i1 = 0;
        k1 = l;
        ac = ((char []) (obj));
        l = k;
          goto _L12
    }
}
