// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.database.Cursor;
import cn.jpush.android.data.u;
import cn.jpush.android.data.w;
import cn.jpush.android.service.PushService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            ai, x, ac, ah

public final class ag
{

    private static final String z[];

    private static JSONObject a(w w1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(z[9], w1.b());
            jsonobject.put(z[2], w1.c());
            jsonobject.put(z[1], w1.d());
            jsonobject.put(z[3], w1.e());
            jsonobject.put(z[5], w1.g());
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put(z[7], w1.h());
            jsonobject1.put(z[8], w1.i());
            jsonobject1.put(z[6], w1.j());
            jsonobject.put(z[4], jsonobject1);
        }
        // Misplaced declaration of an exception variable
        catch (w w1)
        {
            w1.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public static void a(Context context)
    {
        w w1 = null;
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject = new JSONObject();
        Object obj1;
        u u1;
        JSONArray jsonarray;
        jsonobject.put(z[10], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
        jsonobject.put(z[17], z[15]);
        jsonobject.put(z[14], (new SimpleDateFormat(z[16])).format(new Date(b(context) * 1000L)));
        u1 = new u(context);
        u1.a();
        jsonobject.put(z[11], u1.a(true));
        jsonobject.put(z[13], u1.a(false));
        jsonarray = new JSONArray();
        obj1 = u1.d();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Cursor cursor;
        cursor = ((Cursor) (obj1));
        obj = obj1;
        w w2 = u.a(((Cursor) (obj1)));
        if (w2 == null) goto _L6; else goto _L5
_L5:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!ai.a(w2.a())) goto _L7; else goto _L6
_L6:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        x.c();
_L13:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (((Cursor) (obj1)).moveToNext()) goto _L3; else goto _L4
_L4:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        jsonobject.put(z[18], jsonarray);
        jsonarray = new JSONArray();
        obj1 = u1.e();
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        w1 = u.a(((Cursor) (obj1)));
        if (w1 == null) goto _L11; else goto _L10
_L10:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!ai.a(w1.a())) goto _L12; else goto _L11
_L11:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        x.c();
_L15:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (((Cursor) (obj1)).moveToNext()) goto _L8; else goto _L9
_L9:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        jsonobject.put(z[12], jsonarray);
        cursor = ((Cursor) (obj1));
        obj = obj1;
        u1.b();
        cursor = ((Cursor) (obj1));
        obj = obj1;
        ac.a(context, jsonobject);
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L14:
        a(context, System.currentTimeMillis() / 1000L);
        context = new u(context);
        if (context != null)
        {
            context.a();
            context.c();
            context.b();
            return;
        }
          goto _L1
_L7:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        jsonarray.put(b(w2));
          goto _L13
        obj1;
_L18:
        obj = cursor;
        x.f();
        obj = cursor;
        ((JSONException) (obj1)).printStackTrace();
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L14
_L12:
        cursor = ((Cursor) (obj1));
        obj = obj1;
        jsonarray.put(a(w1));
          goto _L15
        context;
_L17:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        context;
        obj = w1;
        if (true) goto _L17; else goto _L16
_L16:
        obj1;
        cursor = null;
          goto _L18
    }

    public static void a(Context context, long l)
    {
        if (context == null)
        {
            return;
        } else
        {
            ah.b(context, z[0], l);
            return;
        }
    }

    public static long b(Context context)
    {
        if (context == null)
        {
            return -1L;
        } else
        {
            return ah.a(context, z[0], 0L);
        }
    }

    private static JSONObject b(w w1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(z[9], w1.b());
            jsonobject.put(z[2], w1.c());
            jsonobject.put(z[1], w1.d());
            jsonobject.put(z[3], w1.e());
            jsonobject.put(z[5], w1.g());
        }
        // Misplaced declaration of an exception variable
        catch (w w1)
        {
            w1.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[19];
        i = 0;
        obj1 = "eeKHbsx\r\farj\021Karb\006Q<ag\n@sjG\004QfTn\025M`r_\fOw";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac1[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac1 = ((String) (obj1)).toCharArray();
        j = ac1.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac1;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac1;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 669
    //                   1 676
    //                   2 683
    //                   3 690;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_690;
_L3:
        byte0 = 18;
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
            obj1 = "jd\006C~Yo\013Q";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "ed\013LMo{";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "ud\020Pqc";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "u~\006Awux:Fwrj\fNa";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "rb\bGa";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "ed\020LfY8:";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "ed\020LfY;:\023";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "ed\020LfY::\021";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "hn\021";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "o\177\fOw";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "jd\002K|Y\177\nVsj";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "u~\006Awco:V}v";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "jd\002K|Ym\004K~co";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            i = 14;
            obj1 = "bj\021G";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j1] = ((String) (obj));
            i = 15;
            obj1 = "uo\016}{ho\000Z";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j1] = ((String) (obj));
            i = 16;
            obj1 = "\177r\034[?KFHFv";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j1] = ((String) (obj));
            i = 17;
            obj1 = "rr\025G";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j1] = ((String) (obj));
            i = 18;
            obj1 = "`j\fNwbT\021Mb";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 6;
          goto _L13
_L5:
        byte0 = 11;
          goto _L13
_L6:
        byte0 = 101;
          goto _L13
        byte0 = 34;
          goto _L13
    }
}
