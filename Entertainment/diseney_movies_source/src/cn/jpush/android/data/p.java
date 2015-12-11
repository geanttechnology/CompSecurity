// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            a, s, d, l, 
//            y, x, q

public final class p
{

    private static final String z[];

    public static cn.jpush.android.data.a a(Context context, String s1, String s2, String s3, String s4)
    {
        (new StringBuilder(z[14])).append(s1).toString();
        x.c();
        if (context == null)
        {
            throw new IllegalArgumentException(z[3]);
        }
        if (TextUtils.isEmpty(s1))
        {
            x.f();
            ServiceInterface.a(z[8], 996, context);
            return null;
        }
        JSONObject jsonobject = a(context, z[22], s1);
        if (jsonobject == null)
        {
            x.c();
            return null;
        }
        s1 = jsonobject.optString(z[11], "");
        int i;
        boolean flag;
        if (!ai.a(s1))
        {
            s4 = s1;
        }
        s1 = s4;
        if (ai.a(s4))
        {
            s1 = jsonobject.optString(z[6], "");
        }
        (new StringBuilder(z[18])).append(s1).toString();
        x.c();
        if (jsonobject.optInt(z[27], 0) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i = jsonobject.optInt(z[21], 0);
        } else
        {
            i = 0;
        }
        s4 = new cn.jpush.android.data.a();
        s4.c = s1;
        s4.a = jsonobject;
        s4.b = jsonobject.optInt(z[7], 3);
        s4.e = flag;
        s4.f = i;
        s4.g = jsonobject.optInt(z[23], 0);
        s4.i = jsonobject.optString(z[17], "");
        s4.j = jsonobject.optString(z[20], "");
        s4.k = jsonobject.optString(z[15], "");
        s4.l = jsonobject.optString(z[26], "");
        s4.m = s2;
        s4.n = s3;
        s4.d = jsonobject.optString(z[24], "");
        if (!ai.a(((cn.jpush.android.data.a) (s4)).i))
        {
            context = a(context, s1, jsonobject, z[19]);
            if (context != null)
            {
                s4.a(context.optString(z[16], ""));
                s4.T = context.optString(z[25], "");
                s4.a(true);
            }
        }
        return s4;
    }

    private static JSONObject a(Context context, String s1, String s2)
    {
        try
        {
            s2 = new JSONObject(s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s2)
        {
            x.j();
            ServiceInterface.a(s1, 996, context);
            return null;
        }
        return s2;
    }

    public static JSONObject a(Context context, String s1, JSONObject jsonobject, String s2)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        x.e();
        ServiceInterface.a(s1, 996, context);
_L4:
        return null;
_L2:
        if (TextUtils.isEmpty(s2))
        {
            x.e();
            return null;
        }
        if (jsonobject.isNull(s2)) goto _L4; else goto _L3
_L3:
        jsonobject = jsonobject.getJSONObject(s2);
        return jsonobject;
        jsonobject;
        x.j();
        ServiceInterface.a(s1, 996, context);
        return null;
    }

    public static void a(Context context, cn.jpush.android.data.a a1)
    {
        String s1;
        JSONObject jsonobject1;
        int i;
        int j;
        x.b();
        if (context == null)
        {
            throw new IllegalArgumentException(z[3]);
        }
        i = a1.b;
        JSONObject jsonobject = a1.a;
        s1 = a1.c;
        if (i == 2)
        {
            a1 = jsonobject.optString(z[10], "").trim();
            if (a(((String) (a1))))
            {
                b(context, a1, s1);
                return;
            } else
            {
                (new StringBuilder(z[5])).append(a1).toString();
                x.c();
                ServiceInterface.a(s1, 996, context);
                return;
            }
        }
        if (i == 1 || i == 3 || i == 4)
        {
            jsonobject1 = a(context, s1, jsonobject, z[10]);
            if (jsonobject1 == null)
            {
                x.c();
                return;
            }
        } else
        {
            (new StringBuilder(z[28])).append(i).toString();
            x.c();
            ServiceInterface.a(s1, 996, context);
            return;
        }
        j = jsonobject1.optInt(z[12], -1);
        j;
        JVM INSTR tableswitch 0 3: default 224
    //                   0 258
    //                   1 357
    //                   2 368
    //                   3 379;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_379;
_L1:
        (new StringBuilder(z[13])).append(j).toString();
        x.e();
        ServiceInterface.a(s1, 996, context);
        return;
_L2:
        Object obj = new s();
_L6:
        obj.c = s1;
        obj.b = i;
        obj.o = j;
        obj.h = a1.h;
        obj.e = a1.e;
        obj.f = a1.f;
        obj.m = a1.m;
        obj.d = a1.d;
        obj.g = a1.g;
        boolean flag = ((d) (obj)).b(context, jsonobject1);
        x.b();
        if (flag)
        {
            ((d) (obj)).a(context);
            x.b();
            return;
        } else
        {
            x.e();
            return;
        }
_L3:
        obj = new l();
          goto _L6
_L4:
        obj = new y();
          goto _L6
        obj = new cn.jpush.android.data.x();
          goto _L6
    }

    public static void a(Context context, String s1)
    {
        (new StringBuilder(z[9])).append(s1).toString();
        x.b();
        if (context == null)
        {
            throw new IllegalArgumentException(z[3]);
        }
        if (!TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        x.f();
_L4:
        return;
_L2:
        JSONObject jsonobject = a(context, z[8], s1);
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        s1 = jsonobject.optString(z[11], "");
        String s2 = s1;
        if (ai.a(s1))
        {
            s2 = jsonobject.optString(z[6], "");
        }
        int i = jsonobject.optInt(z[7], -1);
        if (i == 2)
        {
            s1 = jsonobject.optString(z[10], "").trim();
            if (a(s1))
            {
                b(context, s1, s2);
                return;
            } else
            {
                (new StringBuilder(z[5])).append(s1).toString();
                x.c();
                ServiceInterface.a(s2, 996, context);
                return;
            }
        }
        int j;
        boolean flag;
        if (i == 1)
        {
            jsonobject = a(context, s2, jsonobject, z[10]);
        } else
        {
            jsonobject = null;
        }
        if (jsonobject == null) goto _L4; else goto _L5
_L5:
        j = jsonobject.optInt(z[12], -1);
        j;
        JVM INSTR tableswitch 0 3: default 252
    //                   0 286
    //                   1 336
    //                   2 347
    //                   3 358;
           goto _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_358;
_L6:
        (new StringBuilder(z[13])).append(j).toString();
        x.e();
        ServiceInterface.a(s2, 996, context);
        return;
_L7:
        s1 = new s();
_L11:
        flag = s1.b(context, jsonobject);
        x.b();
        s1.c = s2;
        s1.b = i;
        s1.o = j;
        if (flag)
        {
            s1.a(context);
            x.b();
            return;
        } else
        {
            x.e();
            return;
        }
_L8:
        s1 = new l();
          goto _L11
_L9:
        s1 = new y();
          goto _L11
        s1 = new cn.jpush.android.data.x();
          goto _L11
    }

    public static boolean a(String s1)
    {
        boolean flag;
        if (TextUtils.isEmpty(s1))
        {
            flag = false;
        } else
        {
            s1 = s1.trim();
            boolean flag1 = s1.matches(z[2]);
            flag = flag1;
            if (!flag1)
            {
                (new StringBuilder(z[1])).append(s1).toString();
                x.e();
                return flag1;
            }
        }
        return flag;
    }

    public static boolean a(boolean flag, int i, Context context)
    {
        boolean flag1 = z[0].equalsIgnoreCase(cn.jpush.android.util.a.e(context));
        return flag && i == 0 || flag && i == 1 && flag1;
    }

    private static void b(Context context, String s1, String s2)
    {
        (new StringBuilder(z[4])).append(s1).toString();
        x.b();
        if (context == null)
        {
            throw new IllegalArgumentException(z[3]);
        } else
        {
            (new q(s1, context, s2)).start();
            return;
        }
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[29];
        i = 0;
        obj1 = "{\026<A";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        j1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        k1 = i;
        as1 = ((String []) (obj));
        i1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        i1 = k;
_L9:
        obj1 = obj;
        j1 = obj1[k];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 919
    //                   1 926
    //                   2 933
    //                   3 940;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_940;
_L3:
        byte0 = 53;
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
            obj1 = "e1\fiYE;Z}G@\177W(";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "r\004\022|A\\#\022|A\\,'#\017\003pT\"";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = "b\n6D\025O0\024|PT+";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = "M<\016aZBe\026gTH\022\to\177_0\024NGC2/zY\frZ";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "j>\023dPH\177\016g\025K:\016(__0\024(S^0\027(@^3ZjPO>\017{PC9Za[Z>\026aQ\f*\bd\025\001\177";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = "M;%aQ";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            i = 7;
            obj1 = "_7\025\177jX&\nm";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[k1] = ((String) (obj));
            i = 8;
            obj1 = "b\020ZEfk\026>";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[k1] = ((String) (obj));
            i = 9;
            obj1 = "M<\016aZBe\niG_:5z\\K6\024iYa,\035EP_,\033oP\frZgGE8\023fT@\025\tg[\026U";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[k1] = ((String) (obj));
            i = 10;
            obj1 = "A\000\031g[X:\024|";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[k1] = ((String) (obj));
            i = 11;
            obj1 = "A,\035W\\H";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[k1] = ((String) (obj));
            i = 12;
            obj1 = "M;%|";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[k1] = ((String) (obj));
            i = 13;
            obj1 = "y1\021fZ[\177\027{R\f+\003xP\frZ";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[k1] = ((String) (obj));
            i = 14;
            obj1 = "M<\016aZBe\nzP|>\b{Pc-\023o\\B>\026EFK\022\037{FM8\037(\030\f0\baRE1\033d\177_0\0242?";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[k1] = ((String) (obj));
            i = 15;
            obj1 = "X6\016dP";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[k1] = ((String) (obj));
            i = 16;
            obj1 = "Y-\026";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[k1] = ((String) (obj));
            i = 17;
            obj1 = "A:\t{TK:";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[k1] = ((String) (obj));
            i = 18;
            obj1 = "\\-\037XT^,\037GGE8\023fT@\022\toxI,\tiRI\177\027{Re;Z5\025";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[k1] = ((String) (obj));
            i = 19;
            obj1 = "^6\031`jA:\036aT";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[k1] = ((String) (obj));
            i = 20;
            obj1 = "O0\024|PB+%|L\\:";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[k1] = ((String) (obj));
            i = 21;
            obj1 = "B\000\030}\\@;\037zjE;";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[k1] = ((String) (obj));
            i = 22;
            obj1 = "b\020%Efk\026>";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[k1] = ((String) (obj));
            i = 23;
            obj1 = "B0\016aSE<\033aZB\000\016qEI";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[k1] = ((String) (obj));
            i = 24;
            obj1 = "C)\037zGE;\037WX_8%aQ";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[k1] = ((String) (obj));
            i = 25;
            obj1 = "X&\nm";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[k1] = ((String) (obj));
            i = 26;
            obj1 = "I'\016zT_";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[k1] = ((String) (obj));
            i = 27;
            obj1 = "B\000\025fYU";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[k1] = ((String) (obj));
            i = 28;
            obj1 = "y1\021fZ[1ZEfk\177\nzZX0\031gY\f)\037zFE0\024&\025k6\fm\025Y/Z%\025";
            byte0 = 27;
            obj = as;
            break;

        case 27: // '\033'
            as1[k1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 44;
          goto _L13
_L5:
        byte0 = 95;
          goto _L13
_L6:
        byte0 = 122;
          goto _L13
        byte0 = 8;
          goto _L13
    }
}
