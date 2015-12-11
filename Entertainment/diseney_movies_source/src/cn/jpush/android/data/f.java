// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import cn.jpush.android.util.ai;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{

    private static final String z[];
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;

    public f()
    {
    }

    public f(int i, String s, String s1, String s2, String s3)
    {
        a = i;
        e = s;
        c = s2;
        b = s1;
        d = s3;
    }

    public final int a()
    {
        return toString().getBytes().length;
    }

    public final JSONObject b()
    {
        boolean flag = true;
        JSONObject jsonobject = new JSONObject();
        if (ai.a(d) || ai.a(e) || ai.a(b) || ai.a(c))
        {
            flag = false;
        }
        if (!flag)
        {
            return null;
        }
        try
        {
            jsonobject.put(z[4], a);
            jsonobject.put(z[3], e);
            jsonobject.put(z[2], d);
            jsonobject.put(z[1], b);
            jsonobject.put(z[0], c);
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return jsonobject;
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public final String toString()
    {
        if (c != null && c.contains(z[6]))
        {
            c.replaceAll(z[6], z[5]);
        }
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(a).append(z[7]);
        stringbuffer.append(e).append(z[7]);
        stringbuffer.append(d).append(z[7]);
        stringbuffer.append(b).append(z[7]);
        stringbuffer.append(c).append(z[7]);
        return stringbuffer.toString();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[8];
        i = 0;
        obj1 = "cnL";
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
    //                   0 394
    //                   1 401
    //                   2 408
    //                   3 415;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_415;
_L3:
        byte0 = 80;
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
            obj1 = "z|L";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "ztFZ";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "bx]Z<}iY";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "bx]Z<";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "-w[J#f>";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "Rs";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = ".=";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 14;
          goto _L13
_L5:
        byte0 = 29;
          goto _L13
_L6:
        byte0 = 43;
          goto _L13
        byte0 = 63;
          goto _L13
    }
}
