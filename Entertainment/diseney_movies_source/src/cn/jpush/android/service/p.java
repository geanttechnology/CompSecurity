// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.text.TextUtils;
import cn.jpush.android.util.x;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
{

    private static final HashMap a;
    private static final HashMap b;
    private static long c;
    private static final String z[];

    public static String a(int i)
    {
        if (!a.containsKey(Integer.valueOf(i)))
        {
            (new StringBuilder(z[0])).append(i).toString();
            x.c();
            return null;
        } else
        {
            return (String)a.get(Integer.valueOf(i));
        }
    }

    public static JSONObject a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put(z[6], z[7]);
            jsonobject.put(z[3], s);
            jsonobject.put(z[5], z[4]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return jsonobject;
    }

    public static String b(int i)
    {
        if (!b.containsKey(Integer.valueOf(i)))
        {
            (new StringBuilder(z[1])).append(i).toString();
            x.c();
            return "";
        } else
        {
            return (String)b.get(Integer.valueOf(i));
        }
    }

    public static JSONObject b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put(z[6], z[2]);
            jsonobject.put(z[3], s);
            jsonobject.put(z[5], z[4]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
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
        as = new String[8];
        i = 0;
        obj1 = "7}?\"i\025}t)t\020|&le\rw1l+B";
        byte0 = -1;
        obj = as;
_L19:
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
_L10:
        l = k;
_L8:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 544
    //                   1 551
    //                   2 558
    //                   3 565;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        byte0 = 6;
_L30:
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
          goto _L8
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
        if (l > i1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        byte2;
        JVM INSTR tableswitch 0 6: default 248
    //                   0 267
    //                   1 286
    //                   2 305
    //                   3 324
    //                   4 343
    //                   5 363
    //                   6 384;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L11:
        as1[j1] = ((String) (obj));
        i = 1;
        obj1 = "7}?\"i\025}t>c\022|&8&\001|0)&O3";
        byte0 = 0;
        obj = as;
          goto _L19
_L12:
        as1[j1] = ((String) (obj));
        i = 2;
        obj1 = "\020~\"";
        byte0 = 1;
        obj = as;
          goto _L19
_L13:
        as1[j1] = ((String) (obj));
        i = 3;
        obj1 = "\003c$%b";
        byte0 = 2;
        obj = as;
          goto _L19
_L14:
        as1[j1] = ((String) (obj));
        i = 4;
        obj1 = "\003c$\023g\006w\013>k\024";
        byte0 = 3;
        obj = as;
          goto _L19
_L15:
        as1[j1] = ((String) (obj));
        i = 5;
        obj1 = "\026j$)";
        byte0 = 4;
        obj = as;
          goto _L19
_L16:
        as1[j1] = ((String) (obj));
        i = 6;
        obj1 = "\003p %i\f";
        byte0 = 5;
        obj = as;
          goto _L19
_L17:
        as1[j1] = ((String) (obj));
        i = 7;
        obj1 = "\003w0";
        byte0 = 6;
        obj = as;
          goto _L19
_L18:
        HashMap hashmap;
        as1[j1] = ((String) (obj));
        z = as;
        hashmap = new HashMap();
        a = hashmap;
        obj = Integer.valueOf(0);
        obj1 = "-X";
        byte0 = -1;
_L76:
        Integer integer;
        HashMap hashmap1;
        char ac1[];
        ac1 = ((String) (obj1)).toCharArray();
        i = ac1.length;
        l = 0;
        j = 0;
        byte1 = byte0;
        obj1 = ac1;
        integer = ((Integer) (obj));
        hashmap1 = hashmap;
        k = i;
        if (i > 1) goto _L21; else goto _L20
_L20:
        Integer integer1;
        integer1 = ((Integer) (obj));
        obj = ac1;
        i1 = byte0;
_L33:
        k = j;
_L29:
        obj1 = obj;
        l = obj1[j];
        k % 5;
        JVM INSTR tableswitch 0 3: default 512
    //                   0 572
    //                   1 579
    //                   2 586
    //                   3 593;
           goto _L22 _L23 _L24 _L25 _L26
_L22:
        byte0 = 6;
_L31:
        obj1[j] = (char)(byte0 ^ l);
        k++;
        if (i != 0) goto _L28; else goto _L27
_L27:
        j = i;
          goto _L29
_L4:
        byte0 = 98;
          goto _L30
_L5:
        byte0 = 19;
          goto _L30
_L6:
        byte0 = 84;
          goto _L30
_L7:
        byte0 = 76;
          goto _L30
_L23:
        byte0 = 98;
          goto _L31
_L24:
        byte0 = 19;
          goto _L31
_L25:
        byte0 = 84;
          goto _L31
_L26:
        byte0 = 76;
          goto _L31
_L28:
        l = k;
        k = i;
        hashmap1 = hashmap;
        integer = integer1;
        obj1 = obj;
        byte1 = i1;
_L21:
        i1 = byte1;
        obj = obj1;
        integer1 = integer;
        hashmap = hashmap1;
        i = k;
        j = l;
        if (k > l) goto _L33; else goto _L32
_L32:
        obj = (new String(((char []) (obj1)))).intern();
        byte1;
        JVM INSTR tableswitch 0 39: default 836
    //                   0 864
    //                   1 892
    //                   2 920
    //                   3 948
    //                   4 976
    //                   5 1004
    //                   6 1033
    //                   7 1061
    //                   8 1090
    //                   9 1119
    //                   10 1148
    //                   11 1185
    //                   12 1214
    //                   13 1243
    //                   14 1272
    //                   15 1301
    //                   16 1330
    //                   17 1359
    //                   18 1388
    //                   19 1417
    //                   20 1446
    //                   21 1475
    //                   22 1504
    //                   23 1533
    //                   24 1562
    //                   25 1591
    //                   26 1620
    //                   27 1649
    //                   28 1678
    //                   29 1707
    //                   30 1736
    //                   31 1765
    //                   32 1794
    //                   33 1823
    //                   34 1852
    //                   35 1881
    //                   36 1910
    //                   37 1939
    //                   38 1968
    //                   39 1997;
           goto _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74
_L34:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-1001);
        obj1 = "'k7)c\006369`\004v&lu\013i1b&2\1771-u\00737#h\026r78&\021f$<i\020gz";
        byte0 = 0;
        continue; /* Loop/switch isn't completed */
_L35:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-1000);
        obj1 = "!|:\"c\001g=#hBu5%j\007wzlV\016v5?cBp<)e\t3-#s\02037#h\fv78o\r}t-h\0063&)r\020jt g\026v&m";
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L36:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-998);
        obj1 = "1v:(o\ftt*g\013\1771(&\rat8o\017v;9rL3\004 c\003`1lT\007g&5&\016r )tC";
        byte0 = 2;
        continue; /* Loop/switch isn't completed */
_L37:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-997);
        obj1 = "0v7)o\024z:+&\004r= c\0063;>&\026z9)i\027gzlV\016v5?cBA18t\03338-r\007au";
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L38:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-996);
        obj1 = "!|:\"c\001g=#hBz'le\016|')bL3\004 c\003`1lT\007g&5&\016r )tC";
        byte0 = 4;
        continue; /* Loop/switch isn't completed */
_L39:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-994);
        obj1 = "0v'<i\f`1lr\013~1#s\026=t\034j\007r')&0v >\177B\17758c\0202";
        byte0 = 5;
        continue; /* Loop/switch isn't completed */
_L40:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(-993);
        obj1 = "+}\"-j\013wt?i\001x18(BC8)g\021vt\036c\026a-lj\003g1>'";
        byte0 = 6;
        continue; /* Loop/switch isn't completed */
_L41:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(11);
        obj1 = "$r= c\0063 #&\020v3%u\026v&m";
        byte0 = 7;
        continue; /* Loop/switch isn't completed */
_L42:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(1005);
        obj1 = ";|!>&\003c$\007c\03335\"bBr:(t\rz0lv\003p?-a\0073:-k\00735>cB};8&\017r /n\007wzlV\016v5?cBw;9d\016vt/n\007p?lr\nv9lg\001p;>b\013}3lr\r3\025<v\016z7-r\013|:l\177\rft/t\007r )bB|:lV\ra -jL";
        byte0 = 8;
        continue; /* Loop/switch isn't completed */
_L43:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(1006);
        obj1 = ";|!lg\fw&#o\0063$-e\tr3)&\fr9)&\013`t\"i\026314o\021gxlV\016v5?cBa1+o\021g1>&\033|!>&\022r7-m\005vt\"g\017vt%hBC;>r\003\177z";
        byte0 = 9;
        continue; /* Loop/switch isn't completed */
_L44:
        hashmap1.put(integer, obj);
        hashmap = a;
        obj = Integer.valueOf(1007);
        obj1 = "+}\"-j\013wt\005k\007zxlT\007t=?r\007at-a\003z:b";
        byte0 = 10;
        continue; /* Loop/switch isn't completed */
_L45:
        hashmap1.put(integer, obj);
        hashmap = new HashMap();
        b = hashmap;
        obj = Integer.valueOf(995);
        obj1 = "/v'?g\005vt\006U-]t<g\020`=\"aB`!/e\007v0";
        byte0 = 11;
        continue; /* Loop/switch isn't completed */
_L46:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(996);
        obj1 = "/v'?g\005vt\006U-]t<g\020`=\"aBu5%j\007w";
        byte0 = 12;
        continue; /* Loop/switch isn't completed */
_L47:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(997);
        obj1 = "/v'?g\005vt-j\020v5(\177Ba1/c\013e1(*Bt=:cBf$";
        byte0 = 13;
        continue; /* Loop/switch isn't completed */
_L48:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(998);
        obj1 = "/v'?g\005vt-j\020v5(\177Ba1/c\013e1(*B` %j\0163$>i\001v'?";
        byte0 = 14;
        continue; /* Loop/switch isn't completed */
_L49:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1000);
        obj1 = "7`1>&\001\177=/m\007wt-h\0063;<c\fv0lr\nvt\001c\021`5+c";
        byte0 = 15;
        continue; /* Loop/switch isn't completed */
_L50:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1001);
        obj1 = "/v'?g\005vt(i\025}8#g\0063'9e\001v1(";
        byte0 = 16;
        continue; /* Loop/switch isn't completed */
_L51:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1002);
        obj1 = "/v'?g\005vt>c\001v=:c\0063'9e\001v1(";
        byte0 = 17;
        continue; /* Loop/switch isn't completed */
_L52:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1003);
        obj1 = "/v'?g\005vt?o\016v:/cBw;;h\016|5(&\021f7/c\007w";
        byte0 = 18;
        continue; /* Loop/switch isn't completed */
_L53:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1004);
        obj1 = "4z0)iB`= c\fp1lb\rd: g\rwt?s\001p1)b";
        byte0 = 19;
        continue; /* Loop/switch isn't completed */
_L54:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1005);
        obj1 = "7`1>&\001\177=/m\007wt:o\006v;lg\fwt&s\017c1(&\026|t9t\0163\031)u\021r3)&Jq&#q\021v&e";
        byte0 = 20;
        continue; /* Loop/switch isn't completed */
_L55:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1008);
        obj1 = "4z0)iBz'l`\ra7)&\001\177;?c\006365&\027`1>";
        byte0 = 21;
        continue; /* Loop/switch isn't completed */
_L56:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1007);
        obj1 = "7`1>&\001\177=/m\007wtkI)4";
        byte0 = 22;
        continue; /* Loop/switch isn't completed */
_L57:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1006);
        obj1 = "7`1>&\001\177=/m\007wtkE\003}7)jE";
        byte0 = 23;
        continue; /* Loop/switch isn't completed */
_L58:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1011);
        obj1 = "&|#\"j\rr0l`\003z8)b";
        byte0 = 24;
        continue; /* Loop/switch isn't completed */
_L59:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1012);
        obj1 = "7`1>&\001\177=/m\007wt8iBw;;h\016|5(&\003t5%h";
        byte0 = 25;
        continue; /* Loop/switch isn't completed */
_L60:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1013);
        obj1 = "6{1l`\013\1771lg\016a1-b\033314o\021gt-h\0063'-k\0073'%|\007=t\bi\f4 lb\rd: i\003wt-a\003z:b";
        byte0 = 26;
        continue; /* Loop/switch isn't completed */
_L61:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1100);
        obj1 = "+}\"-j\013wt<g\020r9li\0203!\"c\032c1/r\007wt>c\021f88(";
        byte0 = 27;
        continue; /* Loop/switch isn't completed */
_L62:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1014);
        obj1 = "$r= c\0063 #&\022a1 i\003wt>c\023f=>c\0063&)u\rf&/c";
        byte0 = 28;
        continue; /* Loop/switch isn't completed */
_L63:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1015);
        obj1 = "7`1>&\001\177=/m\007wt%h\021g5 jBr8)t\0263;\"&\021g58s\02136-tBr28c\02030#q\f\177;-b\013}3l`\013}=?n\007wz";
        byte0 = 29;
        continue; /* Loop/switch isn't completed */
_L64:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1016);
        obj1 = "7`1>&\001\177=/m\007wt8n\0073#)d\024z1;!\0213!>j";
        byte0 = 30;
        continue; /* Loop/switch isn't completed */
_L65:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1017);
        obj1 = "7`1>&\001\177=/m\007wt/g\016\177t-e\026z;\"";
        byte0 = 31;
        continue; /* Loop/switch isn't completed */
_L66:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1018);
        obj1 = "6{1lK\007`'-a\0073'$i\0253=\"&\026{1lu\026r 9uBq5>";
        byte0 = 32;
        continue; /* Loop/switch isn't completed */
_L67:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1019);
        obj1 = "!\177=/mBr$<j\013` lg\fwt?n\rdt8n\0073\031)u\021r3)";
        byte0 = 33;
        continue; /* Loop/switch isn't completed */
_L68:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1020);
        obj1 = "&|#\"&\013~5+cBu5%j\007w";
        byte0 = 34;
        continue; /* Loop/switch isn't completed */
_L69:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1021);
        obj1 = "&|#\"&\ng9 &\004r= c\006";
        byte0 = 35;
        continue; /* Loop/switch isn't completed */
_L70:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1022);
        obj1 = "&|#\"&/v'?g\005vt*g\013\1771(";
        byte0 = 36;
        continue; /* Loop/switch isn't completed */
_L71:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1030);
        obj1 = "&z'/g\020wt8n\00739)u\021r3)&\000v7-s\021vt%rBz'lh\rgt%hBg<)&\022f'$&\026z9)";
        byte0 = 37;
        continue; /* Loop/switch isn't completed */
_L72:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1031);
        obj1 = "1g;<&\022f'$&\021v&:o\001v";
        byte0 = 38;
        continue; /* Loop/switch isn't completed */
_L73:
        hashmap1.put(integer, obj);
        hashmap = b;
        obj = Integer.valueOf(1032);
        obj1 = "0v'9k\0073$9u\n3')t\024z7)";
        byte0 = 39;
        if (true) goto _L76; else goto _L75
_L75:
_L74:
        hashmap1.put(integer, obj);
        c = 0L;
          goto _L8
    }
}
