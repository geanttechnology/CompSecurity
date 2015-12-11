// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import cn.jpush.android.a;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            x, ai, ac

public final class ae
{

    private static SharedPreferences a;
    private static final String z[];

    public static int a(Context context, String s, int i)
    {
        c(context);
        return a.getInt(s, i);
    }

    public static long a(Context context, String s, long l)
    {
        c(context);
        return a.getLong(s, l);
    }

    public static String a(Context context, String s, String s1)
    {
        c(context);
        return a.getString(s, s1);
    }

    private static void a()
    {
        x.d();
        String s = a.getString(z[29], z[25]);
        int i;
        if (!s.equals(z[25]))
        {
            long l;
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.b = true;
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.b = false;
            }
            (new StringBuilder(z[28])).append(s).toString();
            x.c();
        }
        s = a.getString(z[14], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.C = true;
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.C = false;
            }
        }
        s = a.getString(z[13], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.d(true);
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.d(false);
            }
            (new StringBuilder(z[24])).append(s).toString();
            x.c();
        }
        s = a.getString(z[3], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.q = true;
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.q = false;
            }
            (new StringBuilder(z[30])).append(s).toString();
            x.c();
        }
        i = a.getInt(z[12], -1);
        if (i != -1)
        {
            if (i == 1)
            {
                PushService.r = true;
            } else
            if (i == 0)
            {
                PushService.r = false;
            }
            (new StringBuilder(z[33])).append(PushService.r).toString();
            x.c();
        }
        s = a.getString(z[22], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.B = true;
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.B = false;
            }
        }
        s = a.getString(z[10], "");
        if (!cn.jpush.android.util.ai.a(s))
        {
            cn.jpush.android.util.ac.a(s);
        }
        s = a.getString(z[18], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.c(true);
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.c(false);
            }
        }
        s = a.getString(z[20], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.b(true);
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.b(false);
            }
        }
        i = a.getInt(z[2], -1);
        if (i != -1)
        {
            PushService.d(i);
        }
        i = a.getInt(z[11], -1);
        if (i != -1)
        {
            PushService.i = i;
            ServiceInterface.d(a.d);
        }
        i = a.getInt(z[31], -1);
        if (i != -1)
        {
            PushService.p = i;
            PushService.a(i);
        }
        s = a.getString(z[8], z[25]);
        if (!s.equals(z[25]))
        {
            PushService.o = s;
            PushService.a(s);
        }
        s = a.getString(z[6], z[25]);
        if (!s.equals(z[25]))
        {
            PushService.d(s);
        }
        s = a.getString(z[16], z[25]);
        if (!s.equals(z[25]))
        {
            PushService.c(s);
        }
        i = a.getInt(z[1], -1);
        if (i != -1)
        {
            PushService.d = i;
        }
        s = a.getString(z[7], z[25]);
        if (!s.equals(z[25]))
        {
            PushService.b(s);
        }
        i = a.getInt(z[17], -1);
        if (i != -1)
        {
            PushService.b(i);
        }
        s = a.getString(z[19], z[25]);
        if (!s.equals(z[25]))
        {
            PushService.A = s;
        }
        s = a.getString(z[26], z[25]);
        if (!s.equals(z[25]))
        {
            if (s.toLowerCase().equals(z[23]))
            {
                PushService.a(true);
            } else
            if (s.toLowerCase().equals(z[9]))
            {
                PushService.a(false);
            }
        }
        i = a.getInt(z[21], -1);
        if (i != -1)
        {
            PushService.c(i);
        }
        i = a.getInt(z[4], -1);
        if (i != -1)
        {
            PushService.D = i;
        }
        i = a.getInt(z[15], -1);
        if (i != -1)
        {
            ServiceInterface.c(i);
        }
        i = a.getInt(z[34], -1);
        if (i != -1)
        {
            ServiceInterface.d(i);
        }
        s = a.getString(z[32], z[25]);
        if (!s.equals(z[25]))
        {
            ServiceInterface.a(s);
        }
        s = a.getString(z[5], z[25]);
        if (!s.equals(z[25]))
        {
            ServiceInterface.b(s);
        }
        l = a.getLong(z[27], -1L);
        if (-1L != l)
        {
            PushService.e = l;
        }
    }

    public static void a(Context context)
    {
        try
        {
            c(context);
            a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.getMessage();
        }
        x.f();
    }

    public static void a(Context context, JSONObject jsonobject)
    {
        Object obj;
        boolean flag1;
        flag1 = true;
        context = c(context).edit();
        obj = jsonobject.optString(z[29], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[29], ((String) (obj)));
        }
        obj = jsonobject.optString(z[26], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[26], ((String) (obj)));
        }
        int i = jsonobject.optInt(z[11], -1);
        if (i != -1)
        {
            context.putInt(z[11], i);
        }
        i = jsonobject.optInt(z[12], -1);
        if (i != -1)
        {
            context.putInt(z[12], i);
        }
        i = jsonobject.optInt(z[2], -1);
        if (i != -1)
        {
            context.putInt(z[2], i);
        }
        obj = jsonobject.optString(z[20], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[20], ((String) (obj)));
        }
        obj = jsonobject.optString(z[8], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[8], ((String) (obj)));
        }
        obj = jsonobject.optString(z[6], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[6], ((String) (obj)));
        }
        obj = jsonobject.optString(z[7], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[7], ((String) (obj)));
        }
        i = jsonobject.optInt(z[31], -1);
        if (i != -1)
        {
            context.putInt(z[31], i);
        }
        obj = jsonobject.optString(z[16], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[16], ((String) (obj)));
        }
        obj = jsonobject.optString(z[3], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[3], ((String) (obj)));
        }
        obj = jsonobject.optString(z[13], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[13], ((String) (obj)));
        }
        obj = jsonobject.optString(z[18], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[18], ((String) (obj)));
        }
        obj = jsonobject.optString(z[19], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[19], ((String) (obj)));
        }
        obj = jsonobject.optString(z[22], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[22], ((String) (obj)));
        }
        obj = jsonobject.optString(z[14], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[14], ((String) (obj)));
        }
        i = jsonobject.optInt(z[17], -1);
        if (i != -1)
        {
            context.putInt(z[17], i);
        }
        i = jsonobject.optInt(z[15], -1);
        if (i != -1)
        {
            context.putInt(z[15], i);
        }
        i = jsonobject.optInt(z[34], -1);
        if (i != -1)
        {
            context.putInt(z[34], i);
        }
        obj = jsonobject.optString(z[32], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[32], ((String) (obj)));
        }
        obj = jsonobject.optString(z[5], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[5], ((String) (obj)));
        }
        i = jsonobject.optInt(z[1], -1);
        if (i != -1)
        {
            context.putInt(z[1], i);
        }
        obj = jsonobject.optString(z[46], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[46], ((String) (obj)));
        }
        obj = jsonobject.optString(z[38], z[25]);
        if (!((String) (obj)).equals(z[25]))
        {
            context.putString(z[38], ((String) (obj)));
        }
        obj = jsonobject.optString(z[39], z[25]);
        if (((String) (obj)).equals(z[25])) goto _L2; else goto _L1
_L1:
        String s = z[40];
        if (!Pattern.compile((new StringBuilder(z[37])).append(s).append(z[44]).append(s).append(z[45]).append(s).append(z[48]).toString()).matcher(((CharSequence) (obj))).matches()) goto _L4; else goto _L3
_L3:
        String as[];
        Object obj1;
        String as1[];
        int j;
        int l;
        as = ((String) (obj)).split("_");
        obj1 = as[1];
        (new StringBuilder(z[36])).append(((String) (obj1))).toString();
        x.b();
        as1 = ((String) (obj1)).split("-");
        obj1 = new ArrayList();
        l = as1.length;
        j = 0;
_L12:
        if (j >= l) goto _L6; else goto _L5
_L5:
        String as2[];
        String s1 = as1[j];
        (new StringBuilder(z[41])).append(s1).toString();
        x.b();
        as2 = s1.split(z[47]);
        Integer integer;
        Integer integer1;
        integer = Integer.valueOf(Integer.parseInt(as2[0]));
        integer1 = Integer.valueOf(Integer.parseInt(as2[1]));
        if (integer1.intValue() <= integer.intValue()) goto _L8; else goto _L7
_L7:
        int k = integer.intValue();
_L13:
        boolean flag = flag1;
        if (k > integer1.intValue()) goto _L10; else goto _L9
_L9:
        if (!((ArrayList) (obj1)).contains(Integer.valueOf(k)))
        {
            ((ArrayList) (obj1)).add(String.valueOf(k));
        }
          goto _L11
_L8:
        (new StringBuilder(z[43])).append(((String) (obj))).toString();
        x.f();
        flag = false;
_L10:
        j++;
        flag1 = flag;
          goto _L12
        Exception exception;
        exception;
        (new StringBuilder(z[43])).append(((String) (obj))).toString();
        flag = false;
        x.j();
          goto _L10
_L6:
        if (flag1)
        {
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append((new StringBuilder()).append(as[0]).append("_").toString());
            for (Iterator iterator = ((ArrayList) (obj1)).iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append("-"))
            {
                ((StringBuilder) (obj)).append((String)iterator.next());
            }

            ((StringBuilder) (obj)).deleteCharAt(((StringBuilder) (obj)).length() - 1);
            obj = ((StringBuilder) (obj)).toString();
            context.putString(z[39], ((String) (obj)));
            (new StringBuilder(z[42])).append(((String) (obj))).toString();
            x.c();
        }
_L2:
        long l1 = jsonobject.optLong(z[27], -1L);
        if (l1 != -1L)
        {
            context.putLong(z[27], l1);
        }
        context.commit();
        a();
        return;
_L4:
        (new StringBuilder(z[43])).append(((String) (obj))).toString();
        x.f();
        if (true) goto _L2; else goto _L11
_L11:
        k++;
          goto _L13
    }

    public static short b(Context context)
    {
        context = c(context).edit();
        short word0 = (short)((a.getInt(z[0], 100) + 1) % 32767);
        context.putInt(z[0], word0);
        context.commit();
        return word0;
    }

    public static void b(Context context, String s, int i)
    {
        context = c(context).edit();
        context.putInt(s, i);
        context.commit();
    }

    public static void b(Context context, String s, long l)
    {
        context = c(context).edit();
        context.putLong(s, l);
        context.commit();
    }

    public static void b(Context context, String s, String s1)
    {
        context = c(context).edit();
        context.putString(s, s1);
        context.commit();
    }

    private static SharedPreferences c(Context context)
    {
        if (a == null)
        {
            a = context.getSharedPreferences(z[35], 0);
        }
        return a;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[49];
        i = 0;
        obj1 = "\022c;\031%\005";
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
    //                   0 1423
    //                   1 1430
    //                   2 1437
    //                   3 1444;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_1444;
_L3:
        byte0 = 76;
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
            obj1 = "\ri-\003\"\000d&#(-c<# ";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "\000e>/:\004O$2)\023p+*\005\017M#* ,i.#";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "\fU>'>\025I$\023?\004t\0324)\022c$2";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "\fE?4>\004h>\025%\022V%5";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "\f\\#6\031\005v\003\026";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "\fU/4:\004t\006/?\025O\032";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "\fN%58";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "\fO\032";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "\007g&5)";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "\tr>6\023\023c:)>\025Y9/?>s8*";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "\fO$2)\023p+*";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "\022h)";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "\bu\006)/\000r#)\"$h+$ \004b";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            i = 14;
            obj1 = "\bu\r#8&i%! \004G.\">\004u9";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j1] = ((String) (obj));
            i = 15;
            obj1 = "\fK/5?\000a/\026#\023r";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j1] = ((String) (obj));
            i = 16;
            obj1 = "\fU/4:\004t\006/?\025N%58";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j1] = ((String) (obj));
            i = 17;
            obj1 = "\fU/4:\004t\006/?\025V%48";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j1] = ((String) (obj));
            i = 18;
            obj1 = "\bu\031# \007M#* \004b\007)(\004";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j1] = ((String) (obj));
            i = 19;
            obj1 = "\ri)\0225\021c";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j1] = ((String) (obj));
            i = 20;
            obj1 = "\bu\030#?\025g82\036\025e";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j1] = ((String) (obj));
            i = 21;
            obj1 = "\f@#4?\025J%!+\004b\003(";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j1] = ((String) (obj));
            i = 22;
            obj1 = "\000i=";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[j1] = ((String) (obj));
            i = 23;
            obj1 = "\025t?#";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[j1] = ((String) (obj));
            i = 24;
            obj1 = "\022c>f%\022J%%-\025o%(\t\017g(*)\005&>)vA";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[j1] = ((String) (obj));
            i = 25;
            obj1 = "\004t8)>\022";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[j1] = ((String) (obj));
            i = 26;
            obj1 = "\fT/6#\023r\032'/\ng-#\005\017`%\t\"-i-!)\005O$";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[j1] = ((String) (obj));
            i = 27;
            obj1 = "\023t&2";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[j1] = ((String) (obj));
            i = 28;
            obj1 = "\022c>f\b#Aj2#[&";
            byte0 = 27;
            obj = as;
            break;

        case 27: // '\033'
            as1[j1] = ((String) (obj));
            i = 29;
            obj1 = "%D\r";
            byte0 = 28;
            obj = as;
            break;

        case 28: // '\034'
            as1[j1] = ((String) (obj));
            i = 30;
            obj1 = "\022c>f!2r+48.h\0375)\023V8#?\004h>f8\016<j";
            byte0 = 29;
            obj = as;
            break;

        case 29: // '\035'
            as1[j1] = ((String) (obj));
            i = 31;
            obj1 = "\fV%48";
            byte0 = 30;
            obj = as;
            break;

        case 30: // '\036'
            as1[j1] = ((String) (obj));
            i = 32;
            obj1 = "\fK/5?\000a/\017\034";
            byte0 = 31;
            obj = as;
            break;

        case 31: // '\037'
            as1[j1] = ((String) (obj));
            i = 33;
            obj1 = "\022c>f!2r+48.h\004#8\026i8-\017\016h$#/\025c.f8\016<j";
            byte0 = 32;
            obj = as;
            break;

        case 32: // ' '
            as1[j1] = ((String) (obj));
            i = 34;
            obj1 = "\f\\#6\031\005v\032)>\025";
            byte0 = 33;
            obj = as;
            break;

        case 33: // '!'
            as1[j1] = ((String) (obj));
            i = 35;
            obj1 = "\002hd,<\024u\"h?\004t<#>\002i$ %\006";
            byte0 = 34;
            obj = as;
            break;

        case 34: // '"'
            as1[j1] = ((String) (obj));
            i = 36;
            obj1 = "\025o'#}[&";
            byte0 = 35;
            obj = as;
            break;

        case 35: // '#'
            as1[j1] = ((String) (obj));
            i = 37;
            obj1 = "I]{k{<}{j{\034/\025nd";
            byte0 = 36;
            obj = as;
            break;

        case 36: // '$'
            as1[j1] = ((String) (obj));
            i = 38;
            obj1 = "\002j%5)\021s9.";
            byte0 = 37;
            obj = as;
            break;

        case 37: // '%'
            as1[j1] = ((String) (obj));
            i = 39;
            obj1 = "\021s9.\030\bk/\n#\002g&";
            byte0 = 38;
            obj = as;
            break;

        case 38: // '&'
            as1[j1] = ((String) (obj));
            i = 40;
            obj1 = "I]zku<z{\035|L?\027:~:6gu\021HZ\024n\027Q+s\0330P]zku<zx\035|L5\027o";
            byte0 = 39;
            obj = as;
            break;

        case 39: // '\''
            as1[j1] = ((String) (obj));
            i = 41;
            obj1 = "\ti?4vA";
            byte0 = 40;
            obj = as;
            break;

        case 40: // '('
            as1[j1] = ((String) (obj));
            i = 42;
            obj1 = "\022g<#l1S\031\016\0235O\007\003l\026o>.l\025n/f:\000j?#vA";
            byte0 = 41;
            obj = as;
            break;

        case 41: // ')'
            as1[j1] = ((String) (obj));
            i = 43;
            obj1 = "(h<' \bbj #\023k+2`Av?5$5o'#v";
            byte0 = 42;
            obj = as;
            break;

        case 42: // '*'
            as1[j1] = ((String) (obj));
            i = 44;
            obj1 = "Hzb";
            byte0 = 43;
            obj = as;
            break;

        case 43: // '+'
            as1[j1] = ((String) (obj));
            i = 45;
            obj1 = "L/an";
            byte0 = 44;
            obj = as;
            break;

        case 44: // ','
            as1[j1] = ((String) (obj));
            i = 46;
            obj1 = "\bu\013(?\026c8";
            byte0 = 45;
            obj = as;
            break;

        case 45: // '-'
            as1[j1] = ((String) (obj));
            i = 47;
            obj1 = "=X";
            byte0 = 46;
            obj = as;
            break;

        case 46: // '.'
            as1[j1] = ((String) (obj));
            i = 48;
            obj1 = "H/";
            byte0 = 47;
            obj = as;
            break;

        case 47: // '/'
            as1[j1] = ((String) (obj));
            z = as;
            a = null;
            return;
        }
          goto _L12
_L8:
        byte0 = 97;
          goto _L13
_L5:
        byte0 = 6;
          goto _L13
_L6:
        byte0 = 74;
          goto _L13
        byte0 = 70;
          goto _L13
    }
}
