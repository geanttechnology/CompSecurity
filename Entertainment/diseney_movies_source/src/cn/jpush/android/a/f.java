// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package cn.jpush.android.a:
//            d, b, i

final class f extends Handler
{

    private static final String z[];
    final d a;
    private float b;
    private JSONArray c;

    public final void handleMessage(Message message)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        if (d.c(a) == this) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (message.what)
        {
        default:
            return;

        case 10: // '\n'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            c = null;
            b = 1.401298E-45F;
            // fall through

        case 2: // '\002'
            if (d.d(a) == 2)
            {
                message = d.b(a).c();
                d.b(a).g();
                if (message != null && 1.065353E+09F > b)
                {
                    c = message;
                    b = 1.065353E+09F;
                }
                sendEmptyMessageDelayed(2, 600L);
                return;
            }
            break;

        case 5: // '\005'
            if (d.d(a) == 2)
            {
                removeMessages(2);
                removeMessages(10);
                d.a(a, 3);
                if (d.b(a).f())
                {
                    d.b(a).d();
                }
                d.b(a).a();
                message = new JSONArray[2];
                message[0] = c;
                if (d.e(a).a())
                {
                    message[1] = d.e(a).c();
                }
                if (c != null)
                {
                    (new StringBuilder(z[0])).append(c.toString()).toString();
                    x.d();
                    a.a(c);
                }
                if (message[1] != null)
                {
                    (new StringBuilder(z[1])).append(message[1].toString()).toString();
                    x.d();
                    a.b(message[1]);
                }
                d.a(a, z[5]);
                return;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (d.d(a) != 1 || d.f(a)) goto _L1; else goto _L3
_L3:
        if (!d.b(a).f())
        {
            if (d.g(a) != d.b(a).a())
            {
                flag = false;
            }
            if (!flag)
            {
                sendEmptyMessageDelayed(10, d.b);
                return;
            }
            break MISSING_BLOCK_LABEL_744;
        }
        if (d.h(a) == null || d.h(a).length == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        int ai[] = d.b(a).d();
        if (ai == null || ai.length == 0)
        {
            break MISSING_BLOCK_LABEL_744;
        }
        if (d.h(a)[0] != ai[0])
        {
            break; /* Loop/switch isn't completed */
        }
        message = new ArrayList(d.h(a).length / 2);
        ArrayList arraylist = new ArrayList(ai.length / 2);
        int i1 = d.h(a).length;
        for (int j = 0; j < i1; j += 2)
        {
            message.add(Integer.valueOf(d.h(a)[j]));
        }

        for (int k = 0; k < ai.length; k += 2)
        {
            arraylist.add(Integer.valueOf(ai[k]));
        }

        Iterator iterator = message.iterator();
        int l = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (arraylist.contains(iterator.next()))
            {
                l++;
            }
        } while (true);
        i1 = message.size() - l;
        int j1 = arraylist.size() - l;
        if (i1 + j1 > l)
        {
            flag1 = true;
        }
        if (flag1)
        {
            message = (new StringBuilder(i1)).append(z[3]);
            message.append(j1).append(z[2]);
            message.append(l);
            d.a(a, message.toString());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        d.a(a, z[4]);
        a.e();
        return;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int j;
        as = new String[6];
        j = 0;
        obj1 = "\\QIT\030pCK]>Ugjvv?\024";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int k;
        int l;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac = ((String) (obj1)).toCharArray();
        k = ac.length;
        j1 = 0;
        l = 0;
        byte2 = byte0;
        obj1 = ac;
        k1 = j;
        as1 = ((String []) (obj));
        i1 = k;
        if (k > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        i1 = l;
_L9:
        obj1 = obj;
        j1 = obj1[l];
        i1 % 5;
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
        byte0 = 76;
_L13:
label0:
        {
            obj1[l] = (char)(byte0 ^ j1);
            i1++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L9; else goto _L8
        j1 = i1;
        i1 = k;
        as1 = as2;
        k1 = j;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        j = k1;
        as2 = as1;
        k = i1;
        l = j1;
        if (i1 > j1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[k1] = ((String) (obj));
            j = 1;
            obj1 = "H}cq\030pCK]>Ugjvv?";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            j = 2;
            obj1 = "?\n\005";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            j = 3;
            obj1 = "?\037\005";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            j = 4;
            obj1 = "Oflu\rMm\005{\tSx\005{\004^zb}\b";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            j = 5;
            obj1 = "O[VLluGJV";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 31;
          goto _L13
_L5:
        byte0 = 52;
          goto _L13
_L6:
        byte0 = 37;
          goto _L13
        byte0 = 56;
          goto _L13
    }
}
