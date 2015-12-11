// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.os.Bundle;
import android.os.Message;
import cn.jpush.android.data.d;
import cn.jpush.android.util.p;

// Referenced classes of package cn.jpush.android.api:
//            p

final class o
    implements p
{

    private static final String z[];
    final cn.jpush.android.api.p a;
    final int b;
    final d c;

    o(cn.jpush.android.api.p p1, int i, d d1)
    {
        a = p1;
        b = i;
        c = d1;
        super();
    }

    public final void a(boolean flag, String s)
    {
        Message message = a.obtainMessage(b);
        Bundle bundle = new Bundle();
        bundle.putBoolean(z[0], flag);
        bundle.putString(z[1], s);
        bundle.putString(z[2], c.c);
        message.setData(bundle);
        message.sendToTarget();
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "U~G?L_";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        l = 0;
        as = ((String []) (obj));
        i1 = j;
        obj = obj1;
        j1 = i;
_L9:
        j = l;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 47;
_L11:
label0:
        {
            obj1[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "Zdx/\177]y|";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "Qhg9N[h].";
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 60;
          goto _L11
_L3:
        i = 13;
          goto _L11
_L4:
        i = 20;
          goto _L11
_L5:
        i = 74;
          goto _L11
        boolean flag = false;
        k1 = i;
        l1 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
