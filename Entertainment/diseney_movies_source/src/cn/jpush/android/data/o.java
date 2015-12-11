// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import cn.jpush.android.util.h;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.data:
//            l

public final class o
    implements Serializable
{

    private static final String z[];
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public ArrayList k;
    public String l;
    public String m;
    public String n;
    final l o;

    public o(l l1)
    {
        o = l1;
        super();
        k = new ArrayList();
    }

    private JSONObject a()
    {
        JSONObject jsonobject;
        boolean flag;
        flag = false;
        jsonobject = new JSONObject();
        String s;
        jsonobject.put(z[8], a);
        jsonobject.put(z[7], b);
        jsonobject.put(z[9], c);
        jsonobject.put(z[12], d);
        s = z[3];
        int i1;
        if (e)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        jsonobject.put(s, i1);
        jsonobject.put(z[13], f);
        jsonobject.put(z[5], g);
        jsonobject.put(z[6], h);
        jsonobject.put(z[10], j);
        s = z[4];
        if (i)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 1;
        }
        try
        {
            jsonobject.put(s, i1);
            jsonobject.put(z[11], cn.jpush.android.util.h.a(k));
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public final String toString()
    {
        JSONObject jsonobject = a();
        try
        {
            jsonobject.put(z[1], l);
            jsonobject.put(z[2], m);
            jsonobject.put(z[0], n);
        }
        catch (JSONException jsonexception) { }
        return jsonobject.toString();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[14];
        i1 = 0;
        obj1 = "\007-\016s@9=\016Aq,2";
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
    //                   0 544
    //                   1 551
    //                   2 558
    //                   3 565;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_565;
_L3:
        byte0 = 16;
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
            obj1 = "\0073\b~~\b;\037y";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "\0073\006pw=\n\nex";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "9\005\030r\177*?";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "9\005\031tc";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "9\005\002\177v7";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "9\005\002|q??4db4";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "9\005\002r\1776\005\036c|";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "9\005\037xd4?";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "9\005\035tb";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "9\005\016db4";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "9\005\016cu+";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "9\005\037h`=";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            i1 = 13;
            obj1 = "9\005\030xj=";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j2] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 88;
          goto _L13
_L5:
        byte0 = 90;
          goto _L13
_L6:
        byte0 = 107;
          goto _L13
        byte0 = 17;
          goto _L13
    }
}
