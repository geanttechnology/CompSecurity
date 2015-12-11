// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import cn.jpush.android.api.b;
import cn.jpush.android.api.m;
import cn.jpush.android.data.d;
import cn.jpush.android.data.r;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ac;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.service:
//            PushService, DownloadService, PushReceiver, AlarmReceiver, 
//            p, PushProtocol, o

public class ServiceInterface
{

    public static long a;
    public static String b;
    public static ConcurrentHashMap d;
    private static String e;
    private static int f;
    private static String g;
    private static int h;
    private static boolean i;
    private static final String z[];
    WeakHashMap c;

    public ServiceInterface()
    {
        c = new WeakHashMap();
    }

    static b a(int k)
    {
        return (b)d.get(Integer.valueOf(k));
    }

    public static void a(Context context)
    {
        while (j(context) || ae.a(context, z[10], z[13]).equals(z[8])) 
        {
            return;
        }
        Intent intent = new Intent(context, cn/jpush/android/service/PushService);
        intent.setAction(z[30]);
        intent.putExtra(z[7], context.getPackageName());
        context.startService(intent);
    }

    public static void a(Context context, int k)
    {
        k = ae.a(context, z[6], -1);
        if (1 == k)
        {
            x.b(z[9], z[11]);
            return;
        }
        boolean flag;
        if (1 < k && k > 0)
        {
            flag = i;
        }
        ae.b(context, z[6], 1);
        cn.jpush.android.service.PushService.b(false);
        ae.b(context, z[10], z[8]);
        Intent intent = new Intent(context, cn/jpush/android/service/PushService);
        intent.setAction(z[5]);
        intent.putExtra(z[7], context.getPackageName());
        context.startService(intent);
        a(context, false);
    }

    public static void a(Context context, d d1)
    {
        x.b();
        Intent intent = new Intent(context, cn/jpush/android/service/DownloadService);
        intent.putExtra(z[44], d1);
        context.startService(intent);
    }

    public static void a(Context context, String s)
    {
        if (ae.a(context, z[10], z[13]).equals(z[8]))
        {
            return;
        } else
        {
            ae.b(context, z[15], s);
            return;
        }
    }

    public static void a(Context context, String s, String s1, b b1)
    {
        while (j(context) || ae.a(context, z[10], z[13]).equals(z[8])) 
        {
            return;
        }
        boolean flag = false;
        short word0 = flag;
        if (b1 != null)
        {
            word0 = flag;
            if (b1.c != null)
            {
                word0 = cn.jpush.android.util.a.c(context);
                d.put(Integer.valueOf(word0), b1);
            }
        }
        b1 = new Intent(context, cn/jpush/android/service/PushService);
        b1.setAction(z[46]);
        b1.putExtra(z[48], s);
        b1.putExtra(z[47], s1);
        b1.putExtra(z[45], word0);
        context.startService(b1);
    }

    public static void a(Context context, JSONObject jsonobject)
    {
        if (context == null)
        {
            throw new IllegalArgumentException(z[23]);
        }
        if (jsonobject != null && jsonobject.length() > 0)
        {
            ac.a(context, jsonobject);
            (new StringBuilder(z[22])).append(jsonobject.toString()).toString();
            x.c();
        }
    }

    private static void a(Context context, boolean flag)
    {
        PackageManager packagemanager = context.getPackageManager();
        ComponentName componentname = new ComponentName(context.getApplicationContext(), cn/jpush/android/service/PushReceiver);
        context = new ComponentName(context.getApplicationContext(), cn/jpush/android/service/AlarmReceiver);
        if (!flag)
        {
            packagemanager.setComponentEnabledSetting(context, 2, 1);
            return;
        } else
        {
            packagemanager.setComponentEnabledSetting(componentname, 1, 1);
            packagemanager.setComponentEnabledSetting(context, 1, 1);
            return;
        }
    }

    public static void a(Context context, boolean flag, String s)
    {
        if (ae.a(context, z[10], z[13]).equals(z[8]))
        {
            return;
        } else
        {
            Intent intent = new Intent(context, cn/jpush/android/service/PushService);
            intent.setAction(z[26]);
            intent.putExtra(z[25], flag);
            intent.putExtra(z[24], s);
            context.startService(intent);
            return;
        }
    }

    public static void a(String s)
    {
        e = s;
    }

    public static void a(String s, int k, Context context)
    {
        a(s, k, null, context);
    }

    public static void a(String s, int k, String s1, Context context)
    {
        if (context == null)
        {
            x.c();
            return;
        }
        Object obj = new StringBuffer();
        ((StringBuffer) (obj)).append((new StringBuilder(z[37])).append(s).append(z[42]).append(k).append("-").append(cn.jpush.android.service.p.b(k)).toString());
        if (!ai.a(s1))
        {
            ((StringBuffer) (obj)).append((new StringBuilder(z[43])).append(s1).toString());
        }
        ((StringBuffer) (obj)).toString();
        x.c();
        obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put(z[39], s);
            ((JSONObject) (obj)).put(z[36], k);
            if (!ai.a(s1))
            {
                ((JSONObject) (obj)).put(z[38], s1);
            }
            ((JSONObject) (obj)).put(z[40], cn.jpush.android.service.PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
            ((JSONObject) (obj)).put(z[35], z[41]);
            ac.a(context, ((JSONObject) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static boolean a()
    {
        return PushProtocol.GetSdkVersion() >= 160;
    }

    public static boolean a(Context context, int k, int l, int i1, int j1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(z[32], k);
            jsonobject.put(z[34], l);
            jsonobject.put(z[31], i1);
            jsonobject.put(z[33], j1);
            a(context, jsonobject.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static String b()
    {
        return z[19];
    }

    static void b(int k)
    {
        d.remove(Integer.valueOf(k));
    }

    public static void b(Context context)
    {
        if (ae.a(context, z[10], z[13]).equals(z[8]))
        {
            return;
        } else
        {
            Intent intent = new Intent(context, cn/jpush/android/service/PushService);
            intent.setAction(z[49]);
            intent.putExtra(z[7], context.getPackageName());
            context.startService(intent);
            return;
        }
    }

    public static void b(Context context, int k)
    {
        k = ae.a(context, z[6], -1);
        if (k == 0)
        {
            x.b(z[9], z[17]);
            return;
        }
        boolean flag;
        if (1 < k && k > 0)
        {
            flag = i;
        }
        a(context, true);
        cn.jpush.android.service.PushService.b(true);
        ae.b(context, z[10], z[13]);
        ae.b(context, z[6], 0);
        Intent intent = new Intent(context, cn/jpush/android/service/PushService);
        intent.setAction(z[16]);
        intent.putExtra(z[7], context.getPackageName());
        context.startService(intent);
    }

    public static void b(String s)
    {
        g = s;
    }

    static String c()
    {
        return g;
    }

    public static void c(int k)
    {
        f = k;
    }

    public static void c(Context context)
    {
        if (ae.a(context, z[10], z[13]).equals(z[8]))
        {
            return;
        } else
        {
            Intent intent = new Intent(context, cn/jpush/android/service/PushService);
            Bundle bundle = new Bundle();
            bundle.putString(z[14], z[14]);
            intent.putExtras(bundle);
            context.startService(intent);
            return;
        }
    }

    public static void c(Context context, int k)
    {
        if (ae.a(context, z[10], z[13]).equals(z[8]))
        {
            return;
        } else
        {
            Intent intent = new Intent(context, cn/jpush/android/service/PushService);
            Bundle bundle = new Bundle();
            bundle.putString(z[14], z[14]);
            bundle.putInt(z[12], k);
            intent.putExtras(bundle);
            context.startService(intent);
            return;
        }
    }

    static int d()
    {
        return h;
    }

    public static void d(int k)
    {
        h = k;
    }

    public static void d(Context context)
    {
        if (ae.a(context, z[10], z[13]).equals(z[8]))
        {
            return;
        }
        x.b();
        if (cn.jpush.android.service.PushService.a())
        {
            Intent intent = new Intent(context, cn/jpush/android/service/PushService);
            intent.setAction(z[21]);
            context.startService(intent);
            return;
        } else
        {
            x.d();
            return;
        }
    }

    public static void d(Context context, int k)
    {
        ae.b(context, z[20], k);
    }

    static String e()
    {
        return e;
    }

    public static void e(Context context)
    {
        if (context == null)
        {
            x.c();
        } else
        {
            JSONArray jsonarray = cn.jpush.android.util.a.n(context);
            if (jsonarray != null && jsonarray.length() != 0)
            {
                Object obj = new JSONArray();
                int l = jsonarray.length();
                int k = 0;
                while (k < l) 
                {
                    try
                    {
                        ((JSONArray) (obj)).put(jsonarray.getJSONObject(k));
                    }
                    catch (JSONException jsonexception) { }
                    if (((JSONArray) (obj)).toString().length() <= 15360 && k != l - 1)
                    {
                        continue;
                    }
                    obj = cn.jpush.android.util.a.a(z[29], jsonarray);
                    if (obj != null && ((JSONObject) (obj)).length() > 0)
                    {
                        ac.a(context, ((JSONObject) (obj)));
                    }
                    obj = new JSONArray();
                    k++;
                }
                obj = cn.jpush.android.util.a.a(z[29], jsonarray);
                if (obj != null && ((JSONObject) (obj)).length() > 0)
                {
                    ac.a(context, ((JSONObject) (obj)));
                    (new StringBuilder(z[27])).append(((JSONObject) (obj)).toString().getBytes().length).toString();
                    x.d();
                    (new StringBuilder(z[28])).append(obj).toString();
                    x.d();
                    return;
                }
            }
        }
    }

    static int f()
    {
        return f;
    }

    public static void f(Context context)
    {
        Cursor cursor1 = null;
        Cursor cursor = r.a(context);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor1 = cursor;
        if (cursor.getCount() <= 0) goto _L2; else goto _L3
_L3:
        cursor1 = cursor;
        (new StringBuilder(z[3])).append(cursor.getCount()).toString();
        cursor1 = cursor;
        x.d();
        cursor1 = cursor;
        cursor.moveToFirst();
_L6:
        cursor1 = cursor;
        if (cursor.isAfterLast()) goto _L2; else goto _L4
_L4:
        cursor1 = cursor;
        int k = cursor.getInt(cursor.getColumnIndex(z[0]));
        cursor1 = cursor;
        String s = cursor.getString(cursor.getColumnIndex(z[4]));
        cursor1 = cursor;
        (new Thread(new o(cursor.getString(cursor.getColumnIndex(z[2])), s.getBytes()))).start();
        cursor1 = cursor;
        (new StringBuilder(z[1])).append(s).toString();
        cursor1 = cursor;
        x.d();
        cursor1 = cursor;
        r.a(context, k);
        cursor1 = cursor;
        cursor.moveToNext();
        if (true) goto _L6; else goto _L5
_L5:
        context;
        if (cursor1 != null)
        {
            cursor1.close();
        }
_L8:
        return;
_L2:
        if (cursor == null) goto _L8; else goto _L7
_L7:
        cursor.close();
        return;
        context;
        cursor = null;
_L10:
        if (cursor != null)
        {
            cursor.close();
        }
        throw context;
        context;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void g(Context context)
    {
        m.a(context);
    }

    public static boolean h(Context context)
    {
        boolean flag = false;
        if (ae.a(context, z[6], 0) > 0)
        {
            flag = true;
        }
        return flag;
    }

    public static int i(Context context)
    {
        return ae.a(context, z[6], -1);
    }

    public static boolean j(Context context)
    {
        boolean flag = h(context);
        if (flag)
        {
            x.d(z[9], z[18]);
        }
        return flag;
    }

    static 
    {
        Object obj;
        Object aobj[];
        Object obj1;
        int k;
        int l;
        aobj = new String[50];
        l = 0;
        obj1 = "X$\022\000-N";
        k = -1;
        obj = ((Object) (aobj));
_L61:
        String as[];
        char ac1[];
        int i1;
        int j1;
        int k1;
        int l1;
        byte byte1;
        int i2;
        ac1 = ((String) (obj1)).toCharArray();
        i1 = ac1.length;
        l1 = 0;
        j1 = 0;
        byte1 = k;
        obj1 = ac1;
        i2 = l;
        as = ((String []) (obj));
        k1 = i1;
        if (i1 > 1) goto _L2; else goto _L1
_L1:
        String as1[];
        byte byte0;
        as1 = ((String []) (obj));
        obj = ac1;
        byte0 = k;
_L10:
        k1 = j1;
_L8:
        obj1 = obj;
        l1 = obj1[j1];
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 1576
    //                   1 1583
    //                   2 1590
    //                   3 1597;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        k = 68;
_L72:
label0:
        {
            obj1[j1] = (char)(k ^ l1);
            k1++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
          goto _L8
        l1 = k1;
        k1 = i1;
        as = as1;
        i2 = l;
        obj1 = obj;
        byte1 = byte0;
_L2:
        byte0 = byte1;
        obj = obj1;
        l = i2;
        as1 = as;
        i1 = k1;
        j1 = l1;
        if (k1 > l1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        byte1;
        JVM INSTR tableswitch 0 48: default 416
    //                   0 435
    //                   1 454
    //                   2 473
    //                   3 492
    //                   4 511
    //                   5 531
    //                   6 552
    //                   7 573
    //                   8 594
    //                   9 615
    //                   10 636
    //                   11 657
    //                   12 678
    //                   13 699
    //                   14 720
    //                   15 741
    //                   16 762
    //                   17 783
    //                   18 804
    //                   19 825
    //                   20 846
    //                   21 867
    //                   22 888
    //                   23 909
    //                   24 930
    //                   25 951
    //                   26 972
    //                   27 993
    //                   28 1014
    //                   29 1035
    //                   30 1056
    //                   31 1077
    //                   32 1098
    //                   33 1119
    //                   34 1140
    //                   35 1161
    //                   36 1182
    //                   37 1203
    //                   38 1224
    //                   39 1245
    //                   40 1266
    //                   41 1287
    //                   42 1308
    //                   43 1329
    //                   44 1350
    //                   45 1371
    //                   46 1392
    //                   47 1413
    //                   48 1434;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60
_L11:
        as[i2] = ((String) (obj));
        l = 1;
        obj1 = "y$\f;dG$\021,#Oa\004-+Ga&\035~\n";
        k = 0;
        obj = ((Object) (aobj));
          goto _L61
_L12:
        as[i2] = ((String) (obj));
        l = 2;
        obj1 = "X$\022\0004X$\0046<";
        k = 1;
        obj = ((Object) (aobj));
          goto _L61
_L13:
        as[i2] = ((String) (obj));
        l = 3;
        obj1 = "m$\026\177)O2\0218!\n'\0200)\n\005 sd^)\007\177'E4\f+dC2X\177";
        k = 2;
        obj = ((Object) (aobj));
          goto _L61
_L14:
        as[i2] = ((String) (obj));
        l = 4;
        obj1 = "X$\022\000 K5\003";
        k = 3;
        obj = ((Object) (aobj));
          goto _L61
_L15:
        as[i2] = ((String) (obj));
        l = 5;
        obj1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\027~\0162\017\021y\t";
        k = 4;
        obj = ((Object) (aobj));
          goto _L61
_L16:
        as[i2] = ((String) (obj));
        l = 6;
        obj1 = "Y$\020)-I$=,0E1\007;";
        k = 5;
        obj = ((Object) (aobj));
          goto _L61
_L17:
        as[i2] = ((String) (obj));
        l = 7;
        obj1 = "K1\022";
        k = 6;
        obj = ((Object) (aobj));
          goto _L61
_L18:
        as[i2] = ((String) (obj));
        l = 8;
        obj1 = "L \016,!";
        k = 7;
        obj = ((Object) (aobj));
          goto _L61
_L19:
        as[i2] = ((String) (obj));
        l = 9;
        obj1 = "y$\020)-I$+10O3\004>'O";
        k = 8;
        obj = ((Object) (aobj));
          goto _L61
_L20:
        as[i2] = ((String) (obj));
        l = 10;
        obj1 = "C20:7^ \020+\026^\"";
        k = 9;
        obj = ((Object) (aobj));
          goto _L61
_L21:
        as[i2] = ((String) (obj));
        l = 11;
        obj1 = "Y$\020)-I$B>(X$\003;=\n2\02604";
        k = 10;
        obj = ((Object) (aobj));
          goto _L61
_L22:
        as[i2] = ((String) (obj));
        l = 12;
        obj1 = "X5\001\000 O-\003&";
        k = 11;
        obj = ((Object) (aobj));
          goto _L61
_L23:
        as[i2] = ((String) (obj));
        l = 13;
        obj1 = "^3\027:";
        k = 12;
        obj = ((Object) (aobj));
          goto _L61
_L24:
        as[i2] = ((String) (obj));
        l = 14;
        obj1 = "X5\001";
        k = 13;
        obj = ((Object) (aobj));
          goto _L61
_L25:
        as[i2] = ((String) (obj));
        l = 15;
        obj1 = "Y(\016:*I$2*7B\025\0132!";
        k = 14;
        obj = ((Object) (aobj));
          goto _L61
_L26:
        as[i2] = ((String) (obj));
        l = 16;
        obj1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\026o\0226\020\026o\0217\f\f";
        k = 15;
        obj = ((Object) (aobj));
          goto _L61
_L27:
        as[i2] = ((String) (obj));
        l = 17;
        obj1 = "Y$\020)-I$B67\n3\0271*C/\005\177%F3\007> S";
        k = 16;
        obj = ((Object) (aobj));
          goto _L61
_L28:
        as[i2] = ((String) (obj));
        l = 18;
        obj1 = "~)\007\1777O3\0246'Oa\013,dY5\r/4O%N\177-^a\0256(Fa\00562Oa\027/dK-\016\1770B$B>'^(\r17\n4\f+-Fa\03301\n\"\0033(\n3\007,1G$2*7Ba\017:0B.\006\1770Ea\020:7_,\007\1770B$B,!X7\013<!\004";
        k = 17;
        obj = ((Object) (aobj));
          goto _L61
_L29:
        as[i2] = ((String) (obj));
        l = 19;
        obj1 = "\033oUqu";
        k = 18;
        obj = ((Object) (aobj));
          goto _L61
_L30:
        as[i2] = ((String) (obj));
        l = 20;
        obj1 = "D.\0266\"K\"\0266+D\036\f*)";
        k = 19;
        obj = ((Object) (aobj));
          goto _L61
_L31:
        as[i2] = ((String) (obj));
        l = 21;
        obj1 = "X$\021+%X5=-0I";
        k = 20;
        obj = ((Object) (aobj));
          goto _L61
_L32:
        as[i2] = ((String) (obj));
        l = 22;
        obj1 = "K\"\0266+D{\020:4E3\026\0204O3\003+-E/BrdI.\f+!D5X";
        k = 21;
        obj = ((Object) (aobj));
          goto _L61
_L33:
        as[i2] = ((String) (obj));
        l = 23;
        obj1 = "d\024.\023dI.\f+!R5";
        k = 22;
        obj = ((Object) (aobj));
          goto _L61
_L34:
        as[i2] = ((String) (obj));
        l = 24;
        obj1 = "Z4\02170C,\007";
        k = 23;
        obj = ((Object) (aobj));
          goto _L61
_L35:
        as[i2] = ((String) (obj));
        l = 25;
        obj1 = "I-\r,!Z4\0217";
        k = 24;
        obj = ((Object) (aobj));
          goto _L61
_L36:
        as[i2] = ((String) (obj));
        l = 26;
        obj1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\024\177\022*\000\020c\f'";
        k = 25;
        obj = ((Object) (aobj));
          goto _L61
_L37:
        as[i2] = ((String) (obj));
        l = 27;
        obj1 = "k\02123-Y5B3!D&\0267~\n";
        k = 26;
        obj = ((Object) (aobj));
          goto _L61
_L38:
        as[i2] = ((String) (obj));
        l = 28;
        obj1 = "k1\0223-Y5Bed";
        k = 27;
        obj = ((Object) (aobj));
          goto _L61
_L39:
        as[i2] = ((String) (obj));
        l = 29;
        obj1 = "K1\022\000(C2\026";
        k = 28;
        obj = ((Object) (aobj));
          goto _L61
_L40:
        as[i2] = ((String) (obj));
        l = 30;
        obj1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\rd\b6";
        k = 29;
        obj = ((Object) (aobj));
          goto _L61
_L41:
        as[i2] = ((String) (obj));
        l = 31;
        obj1 = "O/\006\027+_3";
        k = 30;
        obj = ((Object) (aobj));
          goto _L61
_L42:
        as[i2] = ((String) (obj));
        l = 32;
        obj1 = "Y5\003-0b.\027-";
        k = 31;
        obj = ((Object) (aobj));
          goto _L61
_L43:
        as[i2] = ((String) (obj));
        l = 33;
        obj1 = "O/\006+\tC/\021";
        k = 32;
        obj = ((Object) (aobj));
          goto _L61
_L44:
        as[i2] = ((String) (obj));
        l = 34;
        obj1 = "Y5\003-0g(\f,";
        k = 33;
        obj = ((Object) (aobj));
          goto _L61
_L45:
        as[i2] = ((String) (obj));
        l = 35;
        obj1 = "^8\022:";
        k = 34;
        obj = ((Object) (aobj));
          goto _L61
_L46:
        as[i2] = ((String) (obj));
        l = 36;
        obj1 = "X$\021*(^";
        k = 35;
        obj = ((Object) (aobj));
          goto _L61
_L47:
        as[i2] = ((String) (obj));
        l = 37;
        obj1 = "K\"\0266+D{\020:4E3\026\036'^(\r1\026O2\02730\nlB2!Y2\0038!c%X\177";
        k = 36;
        obj = ((Object) (aobj));
          goto _L61
_L48:
        as[i2] = ((String) (obj));
        l = 38;
        obj1 = "N \026>";
        k = 37;
        obj = ((Object) (aobj));
          goto _L61
_L49:
        as[i2] = ((String) (obj));
        l = 39;
        obj1 = "G2\005\000-N";
        k = 38;
        obj = ((Object) (aobj));
          goto _L61
_L50:
        as[i2] = ((String) (obj));
        l = 40;
        obj1 = "C5\0132!";
        k = 39;
        obj = ((Object) (aobj));
          goto _L61
_L51:
        as[i2] = ((String) (obj));
        l = 41;
        obj1 = "G2\005\0007^ \026*7";
        k = 40;
        obj = ((Object) (aobj));
          goto _L61
_L52:
        as[i2] = ((String) (obj));
        l = 42;
        obj1 = "\006a\0010 O{B";
        k = 41;
        obj = ((Object) (aobj));
          goto _L61
_L53:
        as[i2] = ((String) (obj));
        l = 43;
        obj1 = "\n3\007/+X5B<+D5\00710\020a";
        k = 42;
        obj = ((Object) (aobj));
          goto _L61
_L54:
        as[i2] = ((String) (obj));
        l = 44;
        obj1 = "H.\006&";
        k = 43;
        obj = ((Object) (aobj));
          goto _L61
_L55:
        as[i2] = ((String) (obj));
        l = 45;
        obj1 = "Y$\023\000-N";
        k = 44;
        obj = ((Object) (aobj));
          goto _L61
_L56:
        as[i2] = ((String) (obj));
        l = 46;
        obj1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\005f\b#\f\033~\000%\f";
        k = 45;
        obj = ((Object) (aobj));
          goto _L61
_L57:
        as[i2] = ((String) (obj));
        l = 47;
        obj1 = "^ \005,";
        k = 46;
        obj = ((Object) (aobj));
          goto _L61
_L58:
        as[i2] = ((String) (obj));
        l = 48;
        obj1 = "K-\013>7";
        k = 47;
        obj = ((Object) (aobj));
          goto _L61
_L59:
        as[i2] = ((String) (obj));
        l = 49;
        obj1 = "Y5\r/\033^)\020:%N";
        k = 48;
        obj = ((Object) (aobj));
          goto _L61
_L60:
        as[i2] = ((String) (obj));
        z = ((String []) (aobj));
        a = 0L;
        k = -1;
        obj = "\033pUqu\031tLnr\032oWm";
_L80:
        obj = ((String) (obj)).toCharArray();
        l = obj.length;
        j1 = 0;
        byte0 = 0;
        aobj = ((Object []) (obj));
        i1 = l;
        l1 = k;
        if (l > 1) goto _L63; else goto _L62
_L62:
        k1 = k;
        k = byte0;
_L75:
        j1 = k;
        i1 = k;
_L71:
        aobj = ((Object []) (obj));
        l1 = aobj[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 1544
    //                   0 1604
    //                   1 1611
    //                   2 1618
    //                   3 1625;
           goto _L64 _L65 _L66 _L67 _L68
_L64:
        k = 68;
_L73:
        aobj[i1] = (char)(k ^ l1);
        j1++;
        if (l != 0) goto _L70; else goto _L69
_L69:
        i1 = l;
          goto _L71
_L4:
        k = 42;
          goto _L72
_L5:
        k = 65;
          goto _L72
_L6:
        k = 98;
          goto _L72
_L7:
        k = 95;
          goto _L72
_L65:
        k = 42;
          goto _L73
_L66:
        k = 65;
          goto _L73
_L67:
        k = 98;
          goto _L73
_L68:
        k = 95;
          goto _L73
_L70:
        l1 = k1;
        i1 = l;
        aobj = ((Object []) (obj));
_L63:
        obj = ((Object) (aobj));
        l = i1;
        k = j1;
        k1 = l1;
        if (i1 > j1) goto _L75; else goto _L74
_L74:
        obj = (new String(((char []) (aobj)))).intern();
        l1;
        JVM INSTR tableswitch 0 1: default 1700
    //                   0 1719
    //                   1 1738;
           goto _L76 _L77 _L78
_L76:
        e = ((String) (obj));
        f = 9001;
        k = 0;
        obj = "\033pUqu\031tLnr\032oWm";
        continue; /* Loop/switch isn't completed */
_L77:
        g = ((String) (obj));
        h = 9002;
        k = 1;
        obj = "B5\026/~\005n\021+%^2L54_2\nq'D";
        if (true) goto _L80; else goto _L79
_L79:
_L78:
        b = ((String) (obj));
        d = new ConcurrentHashMap();
        i = false;
          goto _L8
    }
}
