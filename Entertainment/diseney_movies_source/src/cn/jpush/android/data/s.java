// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.util.h;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            d, t

public final class s extends d
{

    private static final String bb[];
    public int W;
    public boolean X;
    public ArrayList Y;
    public String Z;
    public String a;
    public String aa;
    public String ab;

    public s()
    {
        Y = new ArrayList();
        Z = "";
        aa = "";
        o = 0;
    }

    public final void a(Context context)
    {
        x.b();
        (new t(this, context, this)).start();
    }

    public final boolean a(Context context, JSONObject jsonobject)
    {
        x.b();
        a = jsonobject.optString(bb[1], "").trim();
        W = jsonobject.optInt(bb[3], 0);
        boolean flag;
        if (jsonobject.optInt(bb[4], 0) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        X = flag;
        if (X)
        {
            Y = h.a(jsonobject.optJSONArray(bb[2]));
        }
        Z = jsonobject.optString(bb[5], "");
        aa = jsonobject.optString(bb[0], "");
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
        obj1 = "J\026D6\"S";
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
        byte0 = 87;
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
            obj1 = "[&n*;";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "[&~*2M";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "[&h08I";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "[&i=$";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "X\013t5\bP\fv";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            bb = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 62;
          goto _L13
_L5:
        byte0 = 121;
          goto _L13
_L6:
        byte0 = 27;
          goto _L13
        byte0 = 88;
          goto _L13
    }
}
