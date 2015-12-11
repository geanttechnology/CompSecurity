// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android;

import android.os.Environment;
import java.io.File;

public interface b
{

    public static final String a;
    public static final String b;

    
    {
        Object obj;
        int k;
        obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator);
        k = -1;
_L11:
        char ac[];
        Object obj1;
        int i;
        int j;
        int i1;
        ac = "[vb\t)\035".toCharArray();
        j = ac.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        i = 0;
        obj1 = obj;
        obj = ac;
        i1 = k;
_L10:
        int l;
        l = i;
        k = i;
_L7:
        int j1;
        ac = ((char []) (obj));
        j1 = ac[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 104
    //                   0 136
    //                   1 143
    //                   2 150
    //                   3 157;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_157;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 90;
_L8:
        ac[k] = (char)(i ^ j1);
        l++;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        k = j;
        if (true) goto _L7; else goto _L6
_L6:
        i = 117;
          goto _L8
_L3:
        i = 28;
          goto _L8
_L4:
        i = 18;
          goto _L8
        i = 124;
          goto _L8
        Object obj2;
        k = j;
        obj2 = obj1;
        ac = ((char []) (obj));
        j1 = i1;
_L12:
        i1 = j1;
        obj = ac;
        obj1 = obj2;
        j = k;
        i = l;
        if (k > l) goto _L10; else goto _L9
_L9:
        obj = (new String(ac)).intern();
        switch (j1)
        {
        default:
            a = ((StringBuilder) (obj2)).append(((String) (obj))).append(File.separator).toString();
            obj = (new StringBuilder()).append(a);
            k = 0;
            break;

        case 0: // '\0'
            b = ((StringBuilder) (obj2)).append(((String) (obj))).toString();
            return;
        }
          goto _L11
        l = 0;
        j1 = k;
        obj2 = obj;
        k = j;
          goto _L12
    }
}
