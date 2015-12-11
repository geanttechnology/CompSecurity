// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cn.jpush.android.api.k;
import cn.jpush.android.util.ab;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{

    public static int a;
    public static String b;
    public static String c;
    public static Context d;
    public static String e;
    public static String f;
    public static int g;
    public static String h;
    public static boolean i;
    private static AtomicBoolean j;
    private static final String z[];

    public static boolean a(Context context)
    {
        if (j.get())
        {
            return true;
        }
        x.c();
        ab.a(context.getApplicationContext());
        Object obj = b(context);
        if (obj == null)
        {
            x.e(z[0], z[11]);
            return false;
        }
        try
        {
            Object obj1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            g = ((PackageInfo) (obj1)).versionCode;
            obj1 = ((PackageInfo) (obj1)).versionName;
            h = ((String) (obj1));
            if (((String) (obj1)).length() > 30)
            {
                h = h.substring(0, 30);
            }
        }
        catch (Exception exception)
        {
            x.b(z[0], z[7]);
        }
        d = context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14 && (context instanceof Application))
        {
            boolean flag = cn.jpush.android.util.a.i(context);
            k.a = flag;
            if (flag)
            {
                k.a((Application)context.getApplicationContext());
            }
        }
        b = context.getPackageName();
        a = ((ApplicationInfo) (obj)).icon;
        if (a == 0)
        {
            x.e(z[0], z[5]);
        }
        c = context.getPackageManager().getApplicationLabel(((ApplicationInfo) (obj))).toString();
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null) goto _L2; else goto _L1
_L1:
        try
        {
            context = ((ApplicationInfo) (context)).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.a(z[0], z[1], context);
            context = null;
        }
        if (context == null) goto _L4; else goto _L3
_L2:
        x.b(z[0], z[8]);
        context = null;
        break MISSING_BLOCK_LABEL_212;
_L3:
        obj = context.getString(z[17]);
        f = ((String) (obj));
        if (ai.a(((String) (obj))))
        {
            x.e(z[0], z[6]);
            return false;
        }
        if (f.length() != 24)
        {
            x.e(z[0], (new StringBuilder(z[18])).append(f).append(z[15]).toString());
            return false;
        }
        x.b(z[0], (new StringBuilder(z[4])).append(f).toString());
        context = context.getString(z[14]);
        e = context;
        if (ai.a(context))
        {
            x.b(z[0], z[13]);
        } else
        {
            x.b(z[0], (new StringBuilder(z[12])).append(e).toString());
        }
_L6:
        if (android.os.Build.VERSION.SDK_INT == 8)
        {
            System.setProperty(z[10], z[16]);
            System.setProperty(z[9], z[2]);
        }
        j.set(true);
        return true;
_L4:
        x.b(z[0], z[3]);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static ApplicationInfo b(Context context)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.b(z[0], z[1], context);
            return null;
        }
        return context;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int l;
        as = new String[19];
        l = 0;
        obj1 = ";0\"\000\017\0130";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int i1;
        int j1;
        int k1;
        int l1;
        byte byte2;
        int i2;
        ac = ((String) (obj1)).toCharArray();
        i1 = ac.length;
        l1 = 0;
        j1 = 0;
        byte2 = byte0;
        obj1 = ac;
        i2 = l;
        as1 = ((String []) (obj));
        k1 = i1;
        if (i1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        k1 = j1;
_L9:
        obj1 = obj;
        l1 = obj1[j1];
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 684
    //                   1 691
    //                   2 698
    //                   3 705;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_705;
_L3:
        byte0 = 102;
_L13:
label0:
        {
            obj1[j1] = (char)(byte0 ^ l1);
            k1++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
        if (true) goto _L9; else goto _L8
        l1 = k1;
        k1 = i1;
        as1 = as2;
        i2 = l;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        l = i2;
        as2 = as1;
        i1 = k1;
        j1 = l1;
        if (k1 > l1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[i2] = ((String) (obj));
            l = 1;
            obj1 = "=;5\016\026\r6$\023\002Ru6\027\017\00404V\022\007u7\023\022H6%\004\024\r;$V\007\030%<\037\005\t!9\031\bH<>\020\t";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            l = 2;
            obj1 = "\0164<\005\003";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            l = 3;
            obj1 = "&\032p\033\003\0344p\022\007\0344p\022\003\016<>\023\002H<>V\013\t;9\020\003\033!~";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[i2] = ((String) (obj));
            l = 4;
            obj1 = "\0050$\027\002\t!1LF\t% =\003\021u}V";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[i2] = ((String) (obj));
            l = 5;
            obj1 = "\0050$\027\002\t!1LF+4>V\b\007!p\021\003\034u\021\006\026\004<3\027\022\001:>V\017\013:>ZF\021:%V\021\0019<V\004\ru>\031\022H42\032\003H!?V\025\000:'V\b\007!9\020\017\0134$\037\t\006u4\003\003H!?V\022\0000p\027\026\03099\025\007\034<?\030F\0016?\030F\001&p\030\023\0049~";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[i2] = ((String) (obj));
            l = 6;
            obj1 = "\0050$\027\002\t!1LF\t% =\003\021u}V\b\007!p\022\003\016<>\023\002H<>V\013\t;9\020\003\033!";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[i2] = ((String) (obj));
            l = 7;
            obj1 = "&\032p\000\003\032&9\031\b+:4\023F\007'p\000\003\032&9\031\b&4=\023F\f06\037\b\r1p\037\bH81\030\017\0160#\002H";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[i2] = ((String) (obj));
            l = 8;
            obj1 = "\0050$\027\002\t!1LF+4>V\b\007!p\021\003\034u\021\006\026\004<3\027\022\001:>?\b\016:";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[i2] = ((String) (obj));
            l = 9;
            obj1 = "\0024&\027H\0060$X\026\03206\023\024!\005&@'\f1\"\023\025\0330#";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[i2] = ((String) (obj));
            l = 10;
            obj1 = "\0024&\027H\0060$X\026\03206\023\024!\005&B5\03443\035";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[i2] = ((String) (obj));
            l = 11;
            obj1 = "\"\005%\005\016H61\030\b\007!p\024\003H<>\037\022\0014<\037\034\r1p\025\t\005%5\032\003\0340<\017F\f 5V\022\007u\036#*$u1\006\026!;6\031H";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[i2] = ((String) (obj));
            l = 12;
            obj1 = "\0050$\027\002\t!1LF\013=1\030\b\r9p[F";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[i2] = ((String) (obj));
            l = 13;
            obj1 = "\0050$\027\002\t!1LF\013=1\030\b\r9p[F\006:$V\002\r39\030\003\fu9\030F\0054>\037\000\r&$";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[i2] = ((String) (obj));
            l = 14;
            obj1 = "\"\005\005%.7\026\0307(&\020\034";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[i2] = ((String) (obj));
            l = 15;
            obj1 = "Du\000\032\003\t&5V\001\r!p\017\t\035'p7\026\030>5\017F\016'?\033F\030:\"\002\007\004t";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[i2] = ((String) (obj));
            l = 16;
            obj1 = "\034'%\023";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[i2] = ((String) (obj));
            l = 17;
            obj1 = "\"\005\005%.7\024\000&--\f";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[i2] = ((String) (obj));
            l = 18;
            obj1 = "!;&\027\n\0011p\027\026\030\0365\017FRu";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[i2] = ((String) (obj));
            z = as;
            j = new AtomicBoolean(false);
            i = false;
            return;
        }
          goto _L12
_L8:
        byte0 = 104;
          goto _L13
_L5:
        byte0 = 85;
          goto _L13
_L6:
        byte0 = 80;
          goto _L13
        byte0 = 118;
          goto _L13
    }
}
