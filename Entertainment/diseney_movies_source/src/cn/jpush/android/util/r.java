// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import cn.jpush.android.data.f;
import cn.jpush.android.service.PushService;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            x, ac

public final class r
{

    private static final String z[];
    protected int a;
    protected boolean b;
    private int c;
    private int d;
    private long e;
    private long f;
    private long g;
    private long h;
    private Context i;
    private ArrayList j;

    protected r()
    {
        c = 2;
        d = 0;
        e = 0L;
        f = 0L;
        g = 0L;
        h = 0L;
        a = 0;
        b = false;
        j = new ArrayList();
    }

    private void a(String s)
    {
        int k = s.length();
        do
        {
            if (k <= 0)
            {
                break;
            }
            k--;
            switch (s.charAt(k))
            {
            case 100: // 'd'
                a = a | 2;
                break;

            case 118: // 'v'
                a = a | 1;
                break;

            case 105: // 'i'
                a = a | 4;
                break;

            case 119: // 'w'
                a = a | 8;
                break;

            case 101: // 'e'
                a = a | 0x10;
                break;
            }
        } while (true);
    }

    private void b()
    {
        JSONObject jsonobject = d();
        if (jsonobject != null)
        {
            x.b(z[0], jsonobject.toString());
            ac.b(i, jsonobject);
        }
    }

    private void c()
    {
        b = false;
        d = 0;
        h = 0L;
        e = 0L;
        f = 0L;
        a = 0;
        g = 0L;
        c = 2;
        i = null;
        j.clear();
    }

    private JSONObject d()
    {
        if (j == null)
        {
            return null;
        }
        int l = j.size();
        if (l <= 0)
        {
            return null;
        }
        JSONArray jsonarray = new JSONArray();
        for (int k = 0; k < l; k++)
        {
            jsonarray.put(((f)j.get(k)).b());
        }

        if (jsonarray.length() <= 0)
        {
            return null;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(z[4], jsonarray);
            jsonobject.put(z[5], z[3]);
            jsonobject.put(z[6], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return jsonobject;
    }

    protected final void a()
    {
        if (b)
        {
            if (System.currentTimeMillis() - g >= h)
            {
                b();
                c();
            } else
            if (c == 1 && System.currentTimeMillis() - f >= e)
            {
                synchronized (j)
                {
                    b();
                    j.clear();
                    d = 0;
                    f = System.currentTimeMillis();
                }
                return;
            }
        }
    }

    protected final void a(Context context, String s)
    {
        x.b(z[0], (new StringBuilder(z[17])).append(s).toString());
        x.b(z[0], z[10]);
        String s1;
        try
        {
            if (b)
            {
                b = false;
                b();
                c();
            }
            i = context;
            context = new JSONObject(s);
            s = context.getString(z[13]);
            s1 = context.getString(z[9]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            c();
            x.b(z[0], (new StringBuilder(z[14])).append(context.getMessage()).toString());
            return;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equals(z[11])) goto _L4; else goto _L3
_L3:
        c = 2;
_L2:
        a(s1);
        h = context.getLong(z[12]) * 1000L;
        x.b(z[0], (new StringBuilder(z[18])).append(s).toString());
        x.b(z[0], (new StringBuilder(z[19])).append(s1).toString());
        if (c != 1)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        e = context.getLong(z[16]) * 1000L;
        f = System.currentTimeMillis();
        x.b(z[0], (new StringBuilder(z[15])).append(e / 1000L).append("s").toString());
        if (h < 0x493e0L)
        {
            c = 2;
        }
_L6:
        g = System.currentTimeMillis();
        b = true;
        x.b(z[0], z[8]);
        return;
_L4:
        if (!s.equals(z[16])) goto _L2; else goto _L5
_L5:
        c = 1;
          goto _L2
        x.b(z[0], z[7]);
          goto _L6
    }

    protected final void a(f f1)
    {
        if (!b)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        ArrayList arraylist = j;
        arraylist;
        JVM INSTR monitorenter ;
        d = d + f1.a();
        x.b(z[0], (new StringBuilder(z[1])).append(f1.a()).toString());
        x.b(z[0], (new StringBuilder(z[2])).append((h - (System.currentTimeMillis() - g)) / 1000L).append("s").toString());
        c;
        JVM INSTR tableswitch 1 2: default 302
    //                   1 135
    //                   2 232;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (System.currentTimeMillis() - g < h)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        b();
        c();
          goto _L1
        f1;
        throw f1;
        if (System.currentTimeMillis() - f > e)
        {
            synchronized (j)
            {
                b();
                j.clear();
                d = 0;
                f = System.currentTimeMillis();
            }
        }
        j.add(f1);
          goto _L1
        f1;
        arraylist1;
        JVM INSTR monitorexit ;
        throw f1;
_L3:
        if (System.currentTimeMillis() - g < h)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        b();
        c();
          goto _L1
        if ((long)d >= 10240L)
        {
            b();
            j.clear();
            d = f1.a();
        }
        j.add(f1);
          goto _L1
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int k;
        as = new String[20];
        k = 0;
        obj1 = "oNzFR@pGDEJpaiPIrpS";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac1[];
        int l;
        int i1;
        int j1;
        int k1;
        byte byte2;
        int l1;
        ac1 = ((String) (obj1)).toCharArray();
        l = ac1.length;
        k1 = 0;
        i1 = 0;
        byte2 = byte0;
        obj1 = ac1;
        l1 = k;
        as1 = ((String []) (obj));
        j1 = l;
        if (l > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac1;
        byte1 = byte0;
_L11:
        j1 = i1;
_L9:
        obj1 = obj;
        k1 = obj1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 694
    //                   1 701
    //                   2 707
    //                   3 714;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_714;
_L3:
        byte0 = 53;
_L13:
label0:
        {
            obj1[i1] = (char)(byte0 ^ k1);
            j1++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L9; else goto _L8
        k1 = j1;
        j1 = l;
        as1 = as2;
        l1 = k;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        k = l1;
        as2 = as1;
        l = j1;
        i1 = k1;
        if (j1 > k1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[l1] = ((String) (obj));
            k = 1;
            obj1 = "\u65C0\u5FD5\u5932\u5C2E\uFF2F";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            k = 2;
            obj1 = "\u524C\u4F5B\u65E3\u95D5\uFF2F";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            k = 3;
            obj1 = "Or`R]znzFR@p";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            k = 4;
            obj1 = "Fm{UPKv";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[l1] = ((String) (obj));
            k = 5;
            obj1 = "Q{eD";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[l1] = ((String) (obj));
            k = 6;
            obj1 = "Lv|LP";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[l1] = ((String) (obj));
            k = 7;
            obj1 = "\u9EFD\u8BA6\u5310\u5906\u5C3A\uFF3F3%\023\001\025";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[l1] = ((String) (obj));
            k = 8;
            obj1 = "\u89C6\u6792\u6205\u52BE";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[l1] = ((String) (obj));
            k = 9;
            obj1 = "IgcDYV";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[l1] = ((String) (obj));
            k = 10;
            obj1 = "\u5F25\u59C9\u89F6\u67B1\033\013,";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[l1] = ((String) (obj));
            k = 11;
            obj1 = "UcvJPQ";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[l1] = ((String) (obj));
            k = 12;
            obj1 = "QkxD";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[l1] = ((String) (obj));
            k = 13;
            obj1 = "HmqD";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[l1] = ((String) (obj));
            k = 14;
            obj1 = "\u89C6\u6792\u5924\u8D04\uFF2F";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[l1] = ((String) (obj));
            k = 15;
            obj1 = "\u4E2F\u62A7\u547D\u673E\uFF2F";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[l1] = ((String) (obj));
            k = 16;
            obj1 = "UggHZA";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[l1] = ((String) (obj));
            k = 17;
            obj1 = "\u6513\u5232\u6718\u5280\u4E3E\u53F4\u6305\u4EF1\uFF3B";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[l1] = ((String) (obj));
            k = 18;
            obj1 = "\u4E2F\u62A7\u6A34\u5F2E\uFF2F";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[l1] = ((String) (obj));
            k = 19;
            obj1 = "\u65C0\u5FD5\u7B5C\u7E86\uFF2F";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[l1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 37;
          goto _L13
_L5:
        byte0 = 2;
          goto _L13
_L6:
        byte0 = 21;
          goto _L13
        byte0 = 33;
          goto _L13
    }
}
