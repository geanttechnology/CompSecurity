// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.api.m;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.h;
import cn.jpush.android.util.x;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            d, o, p, m, 
//            n

public class l extends d
{

    private static final String bb[];
    public String W;
    public boolean X;
    public boolean Y;
    public int Z;
    public String a;
    public boolean aa;
    public int ab;
    public String ac;
    public o ad;
    public String ae;
    public boolean af;
    public boolean ag;
    public String ah;
    public boolean ai;

    public l()
    {
        ag = true;
        o = 1;
        ad = new o(this);
    }

    static void a(l l1, l l2, Context context)
    {
        if (cn.jpush.android.data.p.a(l2.Y, l2.Z, context))
        {
            if (cn.jpush.android.util.a.b(context))
            {
                ServiceInterface.a(context, l2);
                return;
            }
            l2.Y = false;
        }
        m.a(context, l2);
    }

    public void a(Context context)
    {
        x.b();
        boolean flag = cn.jpush.android.util.a.f(context, a);
        char c1 = '\u03E3';
        if (!X && flag)
        {
            x.c();
            ServiceInterface.a(this.c, 997, context);
            return;
        }
        char c = c1;
        if (X)
        {
            c = c1;
            if (flag)
            {
                x.c();
                c = '\u03E6';
            }
        }
        if (ab == 1)
        {
            (new cn.jpush.android.data.m(this, this, context, c)).start();
            return;
        }
        if (ab == 0)
        {
            (new n(this, context, c, this)).start();
            return;
        } else
        {
            (new StringBuilder(bb[27])).append(ab).toString();
            x.e();
            return;
        }
    }

    public boolean a(Context context, JSONObject jsonobject)
    {
        boolean flag1 = false;
        x.b();
        a = jsonobject.optString(bb[7], "");
        boolean flag;
        if (jsonobject.optInt(bb[0], 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        X = flag;
        if (jsonobject.optInt(bb[14], 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Y = flag;
        Z = jsonobject.optInt(bb[11], 0);
        if (jsonobject.optInt(bb[4], 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aa = flag;
        ab = jsonobject.optInt(bb[21], 1);
        ac = jsonobject.optString(bb[17], "").trim();
        ae = jsonobject.optString(bb[12], "");
        W = jsonobject.optString(bb[23], "");
        if (jsonobject.optInt(bb[22], 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        af = flag;
        if (jsonobject.optInt(bb[18], 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ag = flag;
        if (o == 1)
        {
            context = cn.jpush.android.data.p.a(context, c, jsonobject, bb[9]);
            if (context == null)
            {
                return false;
            }
            jsonobject = ad;
            x.b();
            jsonobject.a = context.optString(bb[13], "");
            jsonobject.b = context.optString(bb[19], "").trim();
            jsonobject.c = context.optString(bb[16], "");
            jsonobject.d = context.optString(bb[2], "");
            l l1;
            if (context.optInt(bb[8], 0) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            jsonobject.e = flag;
            jsonobject.f = context.optString(bb[26], "");
            jsonobject.g = context.optString(bb[6], "");
            jsonobject.h = context.optString(bb[3], "").trim();
            jsonobject.j = context.optString(bb[25], "").trim();
            l1 = ((o) (jsonobject)).o;
            if (context.optInt(bb[10], 0) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l1.O = flag;
            flag = flag1;
            if (context.optInt(bb[1], 0) == 0)
            {
                flag = true;
            }
            jsonobject.i = flag;
            if (((o) (jsonobject)).i)
            {
                jsonobject.k = h.a(context.optJSONArray(bb[20]));
            }
            if (cn.jpush.android.util.ai.a(((o) (jsonobject)).m))
            {
                jsonobject.m = context.optString(bb[15], "").trim();
            }
            if (cn.jpush.android.util.ai.a(((o) (jsonobject)).l))
            {
                jsonobject.l = context.optString(bb[24], "").trim();
            }
            if (cn.jpush.android.util.ai.a(((o) (jsonobject)).l))
            {
                jsonobject.l = context.optString(bb[5], "").trim();
            }
        }
        return true;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[28];
        i = 0;
        obj1 = "2]g:\001";
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
    //                   0 894
    //                   1 901
    //                   2 908
    //                   3 915;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_915;
_L3:
        byte0 = 116;
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
            obj1 = "2r~\000\007";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "2rx\034\0046";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = "2re\b\0254HS\020\006?";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = "2Xx\n+!";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "\fZi\007$2Ji5\025'E";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = "2re\013\022<";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            i = 7;
            obj1 = "2]g:\032";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[k1] = ((String) (obj));
            i = 8;
            obj1 = "2r\177\006\033!H";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[k1] = ((String) (obj));
            i = 9;
            obj1 = "2]g:\0210Bb";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[k1] = ((String) (obj));
            i = 10;
            obj1 = "2rn\027\033 Zi\027";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[k1] = ((String) (obj));
            i = 11;
            obj1 = "2Xx\n+=";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[k1] = ((String) (obj));
            i = 12;
            obj1 = "2]g:\0317\030";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[k1] = ((String) (obj));
            i = 13;
            obj1 = "2rx\f\000?H";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[k1] = ((String) (obj));
            i = 14;
            obj1 = "2Xx\n+>";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[k1] = ((String) (obj));
            i = 15;
            obj1 = "\fDa\004\0236}m\021\034";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[k1] = ((String) (obj));
            i = 16;
            obj1 = "2rz\000\006";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[k1] = ((String) (obj));
            i = 17;
            obj1 = "2]g:\001!A";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[k1] = ((String) (obj));
            i = 18;
            obj1 = "2]g:\025&Yc:\035=^x\004\030?";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[k1] = ((String) (obj));
            i = 19;
            obj1 = "2re\006\033=ry\027\030";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[k1] = ((String) (obj));
            i = 20;
            obj1 = "2ri\027\021 ";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[k1] = ((String) (obj));
            i = 21;
            obj1 = "2]g:\007;B{";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[k1] = ((String) (obj));
            i = 22;
            obj1 = "2]g:\007;B{:\022:Ce\026\0346IS\013\033'D";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[k1] = ((String) (obj));
            i = 23;
            obj1 = "2Xx\n+!N";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[k1] = ((String) (obj));
            i = 24;
            obj1 = "\fDo\n\032\003Lx\r";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[k1] = ((String) (obj));
            i = 25;
            obj1 = "2ri\020\006?";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[k1] = ((String) (obj));
            i = 26;
            obj1 = "2r\177\f\0166";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[k1] = ((String) (obj));
            i = 27;
            obj1 = "\006Ci\035\0046Nx\000\020i\ry\013\037=B{\013T#F,\026\034<Z,\b\0337H,HT";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[k1] = ((String) (obj));
            bb = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 83;
          goto _L13
_L5:
        byte0 = 45;
          goto _L13
_L6:
        byte0 = 12;
          goto _L13
        byte0 = 101;
          goto _L13
    }
}
