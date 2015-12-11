// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.Context;
import cn.jpush.android.a.d;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ac;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.service:
//            PushService

final class l extends d
{

    private static final String A[];
    final PushService e;

    l(PushService pushservice, Context context, String s, boolean flag, boolean flag1)
    {
        e = pushservice;
        super(context, s, flag, flag1);
    }

    private static boolean a(JSONArray jsonarray, JSONArray jsonarray1, String s)
    {
label0:
        {
            if (ai.a(s))
            {
                if (!ai.a(PushService.m()))
                {
                    return false;
                }
            } else
            if (!s.equals(PushService.m()))
            {
                return false;
            }
            if (ai.a(PushService.n()))
            {
                if (jsonarray1 != null && jsonarray1.length() != 0)
                {
                    return false;
                }
            } else
            {
                if (jsonarray1 == null)
                {
                    return false;
                }
                if (jsonarray1.length() == 0)
                {
                    return false;
                }
                if (!PushService.n().equals(jsonarray1.toString()))
                {
                    return false;
                }
                x.d();
            }
            if (ai.a(PushService.o()))
            {
                if (jsonarray != null && jsonarray.length() != 0)
                {
                    return false;
                }
                break label0;
            }
            if (jsonarray == null)
            {
                return false;
            }
            if (jsonarray.length() == 0)
            {
                return false;
            }
            boolean flag;
            try
            {
                jsonarray = ((JSONObject)jsonarray.get(0)).optString(A[1]);
                if (ai.a(jsonarray))
                {
                    break label0;
                }
                flag = jsonarray.equals(PushService.o());
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                return false;
            }
            if (!flag)
            {
                return false;
            }
        }
        return true;
    }

    public final void d()
    {
        boolean flag = PushService.p();
        if (!flag)
        {
            g();
            return;
        }
        if (!a.equals(A[8])) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = b();
        obj = cn.jpush.android.util.a.a(A[9], ((JSONArray) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        if (((JSONObject) (obj)).length() > 0)
        {
            ac.a(e.getApplicationContext(), ((JSONObject) (obj)));
            (new StringBuilder(A[3])).append(obj).toString();
            x.d();
        }
_L4:
        g();
        return;
_L2:
        if (!a.equals(A[11]))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj = c();
        obj = cn.jpush.android.util.a.a(A[4], ((JSONArray) (obj)));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        JSONException jsonexception;
        JSONArray jsonarray;
        try
        {
            if (((JSONObject) (obj)).length() > 0)
            {
                ac.a(e.getApplicationContext(), ((JSONObject) (obj)));
                (new StringBuilder(A[7])).append(((JSONObject) (obj)).toString().getBytes().length).toString();
                x.d();
                (new StringBuilder(A[3])).append(obj).toString();
                x.d();
            }
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception) { }
        finally
        {
            g();
            throw exception1;
        }
        x.j();
        g();
        return;
        if (!a.equals(A[0]))
        {
            break MISSING_BLOCK_LABEL_354;
        }
        exception = a();
        if (exception == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = "".equals(exception);
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        exception = new JSONObject(exception);
        jsonarray = new JSONArray();
        jsonarray.put(exception);
        exception = cn.jpush.android.util.a.a(A[12], jsonarray);
        if (exception == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (exception.length() > 0)
        {
            ac.a(e.getApplicationContext(), exception);
            (new StringBuilder(A[3])).append(exception).toString();
            x.d();
        }
        continue; /* Loop/switch isn't completed */
        jsonexception;
        jsonexception.getMessage();
        x.f();
        continue; /* Loop/switch isn't completed */
        JSONArray jsonarray1;
        JSONArray jsonarray2;
        String s;
        if (!a.equals(A[13]))
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonarray1 = c();
        jsonarray2 = b();
        exception1 = new JSONArray();
        s = a();
        if (a(jsonarray1, jsonarray2, s))
        {
            x.d();
            continue; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        flag = "".equals(s);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        JSONObject jsonobject;
        try
        {
            exception1.put(new JSONObject(s));
        }
        catch (Exception exception2)
        {
            exception2 = null;
        }
        jsonobject = new JSONObject();
        jsonobject.put(A[6], A[5]);
        jsonobject.put(A[10], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
        jsonobject.put(A[15], cn.jpush.android.util.a.d(e.getApplicationContext()));
        if (jsonarray1 == null)
        {
            break MISSING_BLOCK_LABEL_564;
        }
        if (jsonarray1.length() > 0)
        {
            jsonobject.put(A[2], jsonarray1);
            PushService.f(((JSONObject)jsonarray1.get(0)).optString(A[1]));
        }
        if (jsonarray2 == null)
        {
            break MISSING_BLOCK_LABEL_596;
        }
        if (jsonarray2.length() > 0)
        {
            jsonobject.put(A[14], jsonarray2);
            PushService.g(jsonarray2.toString());
        }
        if (exception1 == null)
        {
            break MISSING_BLOCK_LABEL_625;
        }
        if (exception1.length() > 0)
        {
            jsonobject.put(A[0], exception1);
            PushService.h(s);
        }
        ac.a(e.getApplicationContext(), jsonobject);
        continue; /* Loop/switch isn't completed */
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[16];
        i = 0;
        obj1 = ",/D";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac1[];
        int j;
        int k;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac1 = ((String) (obj1)).toCharArray();
        j = ac1.length;
        j1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac1;
        k1 = i;
        as1 = ((String []) (obj));
        i1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac1;
        byte1 = byte0;
_L11:
        i1 = k;
_L9:
        obj1 = obj;
        j1 = obj1[k];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 594
    //                   1 601
    //                   2 608
    //                   3 615;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_615;
_L3:
        byte0 = 113;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ j1);
            i1++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        j1 = i1;
        i1 = j;
        as1 = as2;
        k1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = k1;
        as2 = as1;
        j = i1;
        k = j1;
        if (i1 > j1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[k1] = ((String) (obj));
            i = 1;
            obj1 = "8,^\\";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "<6QQ";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = "\0070TY\005\"0Y\002Q";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = "'0Tg\006\"9^";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "'0Tg\030%9X";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = "?&G]";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            i = 7;
            obj1 = "\0346QQQ':Y_\005#e\027";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[k1] = ((String) (obj));
            i = 8;
            obj1 = "(:[T.?0@]\0038";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[k1] = ((String) (obj));
            i = 9;
            obj1 = "'0Tg\022.3[";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[k1] = ((String) (obj));
            i = 10;
            obj1 = "\"+^U\024";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[k1] = ((String) (obj));
            i = 11;
            obj1 = "<6QQ.?0@]\0038";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[k1] = ((String) (obj));
            i = 12;
            obj1 = "'0Tg\026;,";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[k1] = ((String) (obj));
            i = 13;
            obj1 = "*3[";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[k1] = ((String) (obj));
            i = 14;
            obj1 = "(:[T";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[k1] = ((String) (obj));
            i = 15;
            obj1 = "%:CO\03694hL\b;:";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[k1] = ((String) (obj));
            A = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 75;
          goto _L13
_L5:
        byte0 = 95;
          goto _L13
_L6:
        byte0 = 55;
          goto _L13
        byte0 = 56;
          goto _L13
    }
}
