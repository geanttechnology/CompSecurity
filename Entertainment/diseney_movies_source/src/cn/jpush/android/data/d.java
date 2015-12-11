// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.k;
import cn.jpush.android.util.m;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            p, l, y, e

public abstract class d
    implements Serializable
{

    private static final String W[];
    public String A;
    public String B;
    public List C;
    public int D;
    public int E;
    public int F;
    public String G;
    public String H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public String Q;
    public ArrayList R;
    public String S;
    public String T;
    public String U;
    public String V;
    private boolean a;
    public int b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public boolean s;
    public String t;
    public boolean u;
    public List v;
    public boolean w;
    public int x;
    public String y;
    public int z;

    public d()
    {
        g = 0;
        s = false;
        u = false;
        v = null;
        D = -1;
        L = false;
        M = false;
        N = false;
        a = false;
        O = false;
        P = -1;
        R = null;
        S = "";
    }

    public static d a(Context context, d d1)
    {
        Iterator iterator;
        if (d1.v == null || d1.v.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        d1.R = new ArrayList();
        iterator = d1.v.iterator();
_L9:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1 = (String)iterator.next();
        if (ai.a(s1)) goto _L4; else goto _L3
_L3:
        byte abyte0[] = cn.jpush.android.util.n.a(s1, 5, 5000L, 4);
        if (abyte0 == null) goto _L6; else goto _L5
_L5:
        s1 = s1.substring(s1.lastIndexOf("/") + 1);
        s1 = (new StringBuilder()).append(cn.jpush.android.util.k.a(context, d1.c)).append(s1).toString();
        if (!cn.jpush.android.util.m.a(s1, abyte0, context)) goto _L8; else goto _L7
_L7:
        d1.R.add(s1);
        (new StringBuilder(W[1])).append(s1).toString();
        cn.jpush.android.util.x.b();
          goto _L9
        IOException ioexception;
        ioexception;
        boolean flag;
        cn.jpush.android.util.x.h();
        flag = false;
_L10:
        if (flag)
        {
            cn.jpush.android.util.x.d();
            return d1;
        } else
        {
            cn.jpush.android.util.x.e();
            ServiceInterface.a(d1.c, 1014, context);
            return null;
        }
_L8:
        cn.jpush.android.util.x.f();
        flag = false;
          goto _L10
_L6:
        (new StringBuilder(W[0])).append(s1).toString();
        cn.jpush.android.util.x.e();
        ServiceInterface.a(d1.c, 1020, cn.jpush.android.util.a.b(context, s1), context);
        flag = false;
          goto _L10
_L4:
        cn.jpush.android.util.x.f();
        flag = false;
          goto _L10
_L2:
        flag = true;
          goto _L10
        cn.jpush.android.util.x.f();
        flag = false;
          goto _L10
    }

    static String a(String s1, String s2, String s3, Context context)
    {
        (new StringBuilder(W[29])).append(s1).toString();
        cn.jpush.android.util.x.b();
        if (cn.jpush.android.data.p.a(s1) && context != null && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            byte abyte0[] = cn.jpush.android.util.n.a(s1, 5, 5000L, 4);
            if (abyte0 != null)
            {
                try
                {
                    s1 = (new StringBuilder()).append(cn.jpush.android.util.k.a(context, s2)).append(s3).toString();
                    cn.jpush.android.util.m.a(s1, abyte0, context);
                    (new StringBuilder(W[1])).append(s1).toString();
                    cn.jpush.android.util.x.b();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    cn.jpush.android.util.x.j();
                    return "";
                }
                return s1;
            }
            ServiceInterface.a(s2, 1020, cn.jpush.android.util.a.b(context, s1), context);
        }
        return "";
    }

    static boolean a(ArrayList arraylist, Context context, String s1, String s2, boolean flag)
    {
        boolean flag1;
        boolean flag2;
        flag2 = true;
        (new StringBuilder(W[2])).append(s1).toString();
        cn.jpush.android.util.x.b();
        flag1 = flag2;
        if (!cn.jpush.android.data.p.a(s1)) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        if (context == null) goto _L2; else goto _L3
_L3:
        flag1 = flag2;
        if (arraylist.size() <= 0) goto _L2; else goto _L4
_L4:
        flag1 = flag2;
        if (TextUtils.isEmpty(s2)) goto _L2; else goto _L5
_L5:
        Iterator iterator;
        iterator = arraylist.iterator();
        flag1 = true;
_L11:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist = (String)iterator.next();
        Object obj;
        byte abyte0[];
        if (arraylist != null && !arraylist.startsWith(W[3]))
        {
            obj = (new StringBuilder()).append(s1).append(arraylist).toString();
        } else
        {
            obj = arraylist;
        }
        abyte0 = cn.jpush.android.util.n.a(((String) (obj)), 5, 5000L, 4);
        if (abyte0 == null) goto _L7; else goto _L6
_L6:
        obj = arraylist;
        try
        {
            if (arraylist.startsWith(W[3]))
            {
                obj = cn.jpush.android.util.m.c(arraylist);
            }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            cn.jpush.android.util.x.h();
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        if (flag) goto _L9; else goto _L8
_L8:
        arraylist = (new StringBuilder()).append(cn.jpush.android.util.k.a(context, s2)).append(((String) (obj))).toString();
_L10:
        cn.jpush.android.util.m.a(arraylist, abyte0, context);
        (new StringBuilder(W[1])).append(arraylist).toString();
        cn.jpush.android.util.x.b();
        continue; /* Loop/switch isn't completed */
_L9:
        arraylist = (new StringBuilder()).append(cn.jpush.android.util.k.b(context, s2)).append(((String) (obj))).toString();
        if (true) goto _L10; else goto _L7
_L7:
        ServiceInterface.a(s2, 1020, cn.jpush.android.util.a.b(context, ((String) (obj))), context);
        flag1 = false;
        if (true) goto _L11; else goto _L2
_L2:
        return flag1;
    }

    public abstract void a(Context context);

    public final void a(String s1)
    {
        V = s1;
    }

    public final void a(boolean flag)
    {
        a = flag;
    }

    public final boolean a()
    {
        return o == 3 || o == 1;
    }

    protected abstract boolean a(Context context, JSONObject jsonobject);

    public final boolean b()
    {
        return o == 2;
    }

    public final boolean b(Context context, JSONObject jsonobject)
    {
        cn.jpush.android.util.x.b();
        p = jsonobject.optInt(W[26], 3);
        JSONObject jsonobject1;
        JSONArray jsonarray;
        int i1;
        int j1;
        boolean flag;
        if (jsonobject.optInt(W[28], 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = flag;
        if (jsonobject.optInt(W[20], 0) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        O = flag;
        z = jsonobject.optInt(W[9], 0);
        x = jsonobject.optInt(W[5], 1);
        y = jsonobject.optString(W[12], "");
        A = jsonobject.optString(W[21], "");
        B = jsonobject.optString(W[16], "");
        r = jsonobject.optString(W[23]);
        S = jsonobject.optString(W[14], "");
        l = jsonobject.optString(W[8], "");
        jsonobject1 = jsonobject.optJSONObject(W[15]);
        if (jsonobject1 != null)
        {
            cn.jpush.android.util.x.d();
            D = jsonobject1.optInt(W[10], -1);
            E = jsonobject1.optInt(W[24], -1);
            F = jsonobject1.optInt(W[27], -1);
            G = jsonobject1.optString(W[25]);
            I = jsonobject1.optInt(W[19]);
            J = jsonobject1.optInt(W[11], 0x80000000);
            K = jsonobject1.optInt(W[6], 0);
        }
        if (!ai.a(S))
        {
            B = B.replaceAll(W[18], (new StringBuilder(W[13])).append(cn.jpush.android.util.a.s(context)).toString());
        }
        jsonobject1 = jsonobject.optJSONObject(W[7]);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_474;
        }
        cn.jpush.android.util.x.d();
        try
        {
            t = jsonobject1.toString();
            jsonarray = jsonobject1.getJSONArray(W[22]);
            j1 = jsonarray.length();
            v = new LinkedList();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            cn.jpush.android.util.x.h();
            ServiceInterface.a(c, 996, context);
            return false;
        }
        i1 = 0;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        v.add(jsonarray.getString(i1));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_419;
_L1:
        if (jsonobject1.optInt(W[4], 1) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w = flag;
        if (!ai.a(A)) goto _L4; else goto _L3
_L3:
        if (h) goto _L6; else goto _L5
_L5:
        cn.jpush.android.util.x.c();
        ServiceInterface.a(c, 996, context);
_L8:
        return false;
_L6:
        cn.jpush.android.util.x.c();
        A = cn.jpush.android.a.c;
_L4:
        jsonobject = cn.jpush.android.data.p.a(context, c, jsonobject, W[17]);
        if (jsonobject == null)
        {
            if (h && e)
            {
                return true;
            }
        } else
        {
            if (h && e)
            {
                a = true;
            }
            return a(context, jsonobject);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final boolean c()
    {
        return o == 3;
    }

    public final String d()
    {
        if (a())
        {
            return ((l)this).ac;
        }
        if (b())
        {
            return ((y)this).W;
        }
        if (a)
        {
            return V;
        } else
        {
            return "";
        }
    }

    public final String e()
    {
        if (a())
        {
            return ((l)this).ah;
        }
        if (b())
        {
            return ((y)this).aa;
        } else
        {
            return "";
        }
    }

    public final boolean f()
    {
        return a;
    }

    public final String g()
    {
        Object obj = null;
        String s1;
        if (a())
        {
            String s2 = ((l)this).ae;
            s1 = obj;
            if (s2 != null)
            {
                s1 = obj;
                if (!"".equals(s2))
                {
                    s1 = s2.trim();
                }
            }
        } else
        if (b())
        {
            String s3 = ((y)this).Z;
            s1 = obj;
            if (s3 != null)
            {
                s1 = obj;
                if (!"".equals(s3))
                {
                    return s3.trim();
                }
            }
        } else
        {
            return "";
        }
        return s1;
    }

    public final e h()
    {
        return new e(this, this);
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[30];
        i1 = 0;
        obj1 = "@I3E\000KG \013\nEO(N\b\uFF28O)J\013As6GV\004";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac = ((String) (obj1)).toCharArray();
        j1 = ac.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 944
    //                   1 951
    //                   2 958
    //                   3 965;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_965;
_L3:
        byte0 = 108;
_L13:
label0:
        {
            obj1[k1] = (char)(byte0 ^ i2);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        i2 = l1;
        l1 = j1;
        as1 = as2;
        j2 = i1;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i1 = j2;
        as2 = as1;
        j1 = l1;
        k1 = i2;
        if (l1 > i2) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j2] = ((String) (obj));
            i1 = 1;
            obj1 = "wS'H\tABd_\003\004J+J\b\004O)J\013A\006i\013";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "EE0B\003J\034(D\r@n0F\000mK%L\tvC7D\031VE!XL\t\0061Y\000tT!M\005\\\034";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "LR0[V\013\t";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "EJ(D\033{E%E\017AJ";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "ME+E";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "EV4t\030]V!";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "W_7t\032MC3";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "Jy!S\030VG7";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "Jy\"G\rC";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "@C7@\030KV\033X\004KQ\033_\025TC";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "IG6L\005Jy(N\nP";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "ME+E3QT(";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            i1 = 13;
            obj1 = "\002S-OQ";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j2] = ((String) (obj));
            i1 = 14;
            obj1 = "IU#t\005IA\033^\036H";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j2] = ((String) (obj));
            i1 = 15;
            obj1 = "@C7@\030KV\033X\004KQ\033H\003JR!E\030";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j2] = ((String) (obj));
            i1 = 16;
            obj1 = "Jy'D\002PC*_";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j2] = ((String) (obj));
            i1 = 17;
            obj1 = "EB\033H\003JR!E\030";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j2] = ((String) (obj));
            i1 = 18;
            obj1 = "\002\0";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j2] = ((String) (obj));
            i1 = 19;
            obj1 = "IG6L\005Jy0D\034";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j2] = ((String) (obj));
            i1 = 20;
            obj1 = "Ey&Y\003WQ!Y";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j2] = ((String) (obj));
            i1 = 21;
            obj1 = "Jy0B\030HC";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j2] = ((String) (obj));
            i1 = 22;
            obj1 = "MK%L\t{S6G3HO7_";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[j2] = ((String) (obj));
            i1 = 23;
            obj1 = "Jy-F\rCC\033^\036H";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[j2] = ((String) (obj));
            i1 = 24;
            obj1 = "RO!\\3SO _\004";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[j2] = ((String) (obj));
            i1 = 25;
            obj1 = "RO!\\3MK#t\031VJ";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[j2] = ((String) (obj));
            i1 = 26;
            obj1 = "VO*L3I";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[j2] = ((String) (obj));
            i1 = 27;
            obj1 = "RO!\\3LC-L\004P";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[j2] = ((String) (obj));
            i1 = 28;
            obj1 = "BS(G3WE6N\tJ";
            byte0 = 27;
            obj = as;
            break;

        case 27: // '\033'
            as1[j2] = ((String) (obj));
            i1 = 29;
            obj1 = "EE0B\003J\034(D\r@o)L>AUd\006LQT(\021";
            byte0 = 28;
            obj = as;
            break;

        case 28: // '\034'
            as1[j2] = ((String) (obj));
            W = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 36;
          goto _L13
_L5:
        byte0 = 38;
          goto _L13
_L6:
        byte0 = 68;
          goto _L13
        byte0 = 43;
          goto _L13
    }
}
