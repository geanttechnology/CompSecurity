// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.api.m;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            d

public final class y extends d
{

    private static final String ab[];
    public String W;
    public String X;
    public String Y;
    public String Z;
    public int a;
    public String aa;

    public y()
    {
        o = 2;
    }

    public final void a(Context context)
    {
        x.b();
        ServiceInterface.a(c, 995, context);
        if (a == 0)
        {
            if (cn.jpush.android.util.a.b(context))
            {
                ServiceInterface.a(context, this);
            }
            return;
        }
        if (a == 1)
        {
            m.a(context, this);
            return;
        } else
        {
            (new StringBuilder(ab[0])).append(a).toString();
            x.c();
            return;
        }
    }

    public final boolean a(Context context, JSONObject jsonobject)
    {
        x.b();
        a = jsonobject.optInt(ab[2], 0);
        W = jsonobject.optString(ab[1], "");
        X = jsonobject.optString(ab[4], "");
        Z = jsonobject.optString(ab[5], "");
        Y = jsonobject.optString(ab[3], "");
        return true;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[6];
        i = 0;
        obj1 = "H]\037Fhj]T^nyV\033\bsdC\021\b*=";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 345
    //                   1 352
    //                   2 359
    //                   3 366;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_366;
_L3:
        byte0 = 7;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "kl\001Zk";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "kl\000Qwx";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "kl\035Far";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "kl\021]uq";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "kl\031L2";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            ab = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 29;
          goto _L13
_L5:
        byte0 = 51;
          goto _L13
_L6:
        byte0 = 116;
          goto _L13
        byte0 = 40;
          goto _L13
    }
}
