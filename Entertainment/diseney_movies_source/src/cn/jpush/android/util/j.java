// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import cn.jpush.android.api.c;
import cn.jpush.android.service.PushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            x, ai, ac, a

public class j
{

    private static final String a;
    private static Map b;
    private static final String z[];

    public j()
    {
    }

    public static void a(Context context)
    {
        Object obj = a;
        cn.jpush.android.util.x.c();
        obj = b(context);
        if (obj != null && !((Map) (obj)).isEmpty())
        {
            if (b == null)
            {
                HashMap hashmap = new HashMap();
                Object obj2 = context.getSharedPreferences(z[0], 0);
                String s1 = ((SharedPreferences) (obj2)).getString(z[1], null);
                String s2 = ((SharedPreferences) (obj2)).getString(z[2], null);
                String s3 = ((SharedPreferences) (obj2)).getString(z[7], null);
                String s4 = ((SharedPreferences) (obj2)).getString(z[15], null);
                String s5 = ((SharedPreferences) (obj2)).getString(z[4], null);
                String s6 = ((SharedPreferences) (obj2)).getString(z[3], null);
                String s7 = ((SharedPreferences) (obj2)).getString(z[10], null);
                String s8 = ((SharedPreferences) (obj2)).getString(z[11], null);
                String s9 = ((SharedPreferences) (obj2)).getString(z[13], null);
                obj2 = ((SharedPreferences) (obj2)).getString(z[6], null);
                if (!ai.a(s1))
                {
                    hashmap.put(z[1], s1);
                }
                if (!ai.a(s2))
                {
                    hashmap.put(z[2], s2);
                }
                if (!ai.a(s3))
                {
                    hashmap.put(z[7], s3);
                }
                if (!ai.a(s4))
                {
                    hashmap.put(z[15], s4);
                }
                if (!ai.a(s5))
                {
                    hashmap.put(z[4], s5);
                }
                if (!ai.a(s6))
                {
                    hashmap.put(z[3], s6);
                }
                if (!ai.a(s7))
                {
                    hashmap.put(z[12], s7);
                }
                if (!ai.a(s7))
                {
                    hashmap.put(z[10], s7);
                }
                if (!ai.a(s8))
                {
                    hashmap.put(z[11], s8);
                }
                if (!ai.a(s9))
                {
                    hashmap.put(z[13], s9);
                }
                if (!ai.a(((String) (obj2))))
                {
                    hashmap.put(z[6], obj2);
                }
                b = hashmap;
            }
            Object obj1 = b;
            boolean flag;
            if (obj1 == null || ((Map) (obj1)).isEmpty())
            {
                flag = true;
            } else
            if (!obj.equals(obj1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                b = ((Map) (obj));
                a(context, ((Map) (obj)));
                try
                {
                    obj1 = new JSONObject(((Map) (obj)));
                    ((JSONObject) (obj1)).put(z[16], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
                    ((JSONObject) (obj1)).put(z[17], z[18]);
                    ac.a(context, ((JSONObject) (obj1)));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    String s = a;
                    context.getMessage();
                    x.f();
                    return;
                }
            }
            obj1 = c.a().c(context);
            if (obj1 != null)
            {
                obj = new JSONObject(((Map) (obj)));
                if (obj != null && ((JSONObject) (obj)).length() > 0)
                {
                    try
                    {
                        ((JSONObject) (obj1)).put(z[18], obj);
                    }
                    catch (JSONException jsonexception) { }
                }
                ac.a(context, ((JSONObject) (obj1)));
                c.b(context);
                return;
            }
        }
    }

    private static void a(Context context, Map map)
    {
        Object obj;
        if (map != null)
        {
            if ((obj = map.keySet()) != null && ((Set) (obj)).size() > 0)
            {
                context = context.getSharedPreferences(z[0], 0).edit();
                String s;
                for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); context.putString(s, (String)map.get(s)))
                {
                    s = (String)((Iterator) (obj)).next();
                }

                context.commit();
                return;
            }
        }
    }

    private static Map b(Context context)
    {
        String s;
        String s2;
        String s3;
        String s7;
        String s8;
        Object obj;
        String s9;
        String s10;
        Object obj1;
        String s11;
        String s12;
        String s13;
        String s14;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        HashMap hashmap;
        PackageManager packagemanager;
        String s15;
        packagemanager = context.getPackageManager();
        s15 = context.getPackageName();
        hashmap = new HashMap();
        s14 = null;
        s = null;
        obj6 = null;
        obj4 = null;
        obj2 = null;
        obj5 = null;
        s7 = null;
        s9 = null;
        obj1 = null;
        obj3 = null;
        s13 = null;
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = ((String) (obj2));
        s3 = obj6;
        s12 = s;
        String s5 = cn.jpush.android.util.a.c();
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = ((String) (obj2));
        s3 = obj6;
        s12 = s;
        s14 = s5;
        String s6 = cn.jpush.android.util.a.a(context);
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = ((String) (obj2));
        s3 = obj6;
        s12 = s6;
        s14 = s5;
        ApplicationInfo applicationinfo = packagemanager.getApplicationInfo(s15, 128);
        String s1;
        s1 = obj5;
        s = obj4;
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        s1 = obj5;
        s = obj4;
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = ((String) (obj2));
        s3 = obj6;
        s12 = s6;
        s14 = s5;
        if (applicationinfo.metaData == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = ((String) (obj2));
        s3 = obj6;
        s12 = s6;
        s14 = s5;
        s = applicationinfo.metaData.getString(z[9]);
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = ((String) (obj2));
        s3 = s;
        s12 = s6;
        s14 = s5;
        s1 = applicationinfo.metaData.getString(z[5]);
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        obj2 = packagemanager.getPackageInfo(s15, 0);
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        s7 = (new StringBuilder()).append(((PackageInfo) (obj2)).versionCode).toString();
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        s9 = ((PackageInfo) (obj2)).versionName;
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        s9 = s9.replaceAll(z[14], "_");
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        obj1 = (new StringBuilder()).append(android.os.Build.VERSION.RELEASE).toString();
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        s13 = z[8];
        s8 = s13;
        obj = obj1;
        s2 = s9;
        s10 = s7;
        s11 = s1;
        s3 = s;
        s12 = s6;
        s14 = s5;
        obj2 = Build.MODEL;
        s2 = context.getResources().getConfiguration().locale.toString();
        long l = (long)TimeZone.getDefault().getRawOffset() / 0x36ee80L;
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        context = (new StringBuilder("+")).append(l).toString();
        obj = obj1;
        s8 = s13;
_L4:
        if (!ai.a(s5))
        {
            hashmap.put(z[1], s5);
        }
        if (!ai.a(s6))
        {
            hashmap.put(z[2], s6);
        }
        if (!ai.a(s))
        {
            hashmap.put(z[7], s);
        }
        if (!ai.a(s1))
        {
            hashmap.put(z[15], s1);
        }
        if (!ai.a(s7))
        {
            hashmap.put(z[4], s7);
        }
        if (!ai.a(s9))
        {
            hashmap.put(z[3], s9);
        }
        if (!ai.a(((String) (obj))))
        {
            hashmap.put(z[12], obj);
        }
        if (!ai.a(s2))
        {
            hashmap.put(z[10], s2);
        }
        if (!ai.a(context))
        {
            hashmap.put(z[11], context);
        }
        if (!ai.a(s8))
        {
            hashmap.put(z[13], s8);
        }
        if (!ai.a(((String) (obj2))))
        {
            hashmap.put(z[6], obj2);
        }
        return hashmap;
_L2:
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_949;
        }
        context = (new StringBuilder("-")).append(l).toString();
        s8 = s13;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        context = (new StringBuilder()).append(l).toString();
        s8 = s13;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        context = null;
        s13 = null;
        s5 = s14;
        s6 = s12;
        s = s3;
        s1 = s11;
        s7 = s10;
        s9 = s2;
        s2 = s13;
_L5:
        String s4 = a;
        ((Exception) (obj1)).getMessage();
        x.f();
        obj2 = context;
        context = obj3;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        s2 = null;
        context = ((Context) (obj2));
        s8 = s13;
        obj = obj1;
        obj1 = exception;
          goto _L5
        exception;
        context = ((Context) (obj2));
        s8 = s13;
        obj = obj1;
        obj1 = exception;
          goto _L5
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
        obj1 = "+KEA:\036_UD;\"^o[<'T";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac1[];
        int k;
        int l;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac1 = ((String) (obj1)).toCharArray();
        k = ac1.length;
        j1 = 0;
        l = 0;
        byte2 = byte0;
        obj1 = ac1;
        k1 = i;
        as1 = ((String []) (obj));
        i1 = k;
        if (k > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac1;
        byte1 = byte0;
_L11:
        i1 = l;
_L9:
        obj1 = obj;
        j1 = obj1[l];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 681
    //                   1 688
    //                   2 695
    //                   3 702;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_702;
_L3:
        byte0 = 82;
_L13:
label0:
        {
            obj1[l] = (char)(byte0 ^ j1);
            i1++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L9; else goto _L8
        j1 = i1;
        i1 = k;
        as1 = as2;
        k1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = k1;
        as2 = as1;
        k = i1;
        l = j1;
        if (i1 > j1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[k1] = ((String) (obj));
            i = 1;
            obj1 = "\"KEm;/]_";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "3^C]>4OY]<";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = " K@m$$IC[=/UQ_7";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = " K@m$$IC[=/X_V7";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "\013kea\032\036z`b\031\004b";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = ",TTW>";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            i = 7;
            obj1 = "\"SQ\\<$W";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[k1] = ((String) (obj));
            i = 8;
            obj1 = "p\025\007\034c";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[k1] = ((String) (obj));
            i = 9;
            obj1 = "\013kea\032\036xxs\034\017~|";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[k1] = ((String) (obj));
            i = 10;
            obj1 = "-Z^U' \\U";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[k1] = ((String) (obj));
            i = 11;
            obj1 = "5R]W(.UU";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[k1] = ((String) (obj));
            i = 12;
            obj1 = ".HoD73HY]<";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[k1] = ((String) (obj));
            i = 13;
            obj1 = "2_[m$$IC[=/";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[k1] = ((String) (obj));
            i = 14;
            obj1 = "\032eQ\037(\000\026j\002\177xd\036o";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[k1] = ((String) (obj));
            i = 15;
            obj1 = " K@m9$B";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[k1] = ((String) (obj));
            i = 16;
            obj1 = "(OY_7";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[k1] = ((String) (obj));
            i = 17;
            obj1 = "5B@W";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[k1] = ((String) (obj));
            i = 18;
            obj1 = "%^F[1$dY\\4.";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[k1] = ((String) (obj));
            z = as;
            a = cn/jpush/android/util/j.getSimpleName();
            b = null;
            return;
        }
          goto _L12
_L8:
        byte0 = 65;
          goto _L13
_L5:
        byte0 = 59;
          goto _L13
_L6:
        byte0 = 48;
          goto _L13
        byte0 = 50;
          goto _L13
    }
}
