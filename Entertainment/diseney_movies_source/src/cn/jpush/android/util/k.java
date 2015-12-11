// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package cn.jpush.android.util:
//            a, x, l, m

public final class k
{

    public static final String a;
    private static final String z[];

    public static String a(Context context, String s)
    {
        context = (new StringBuilder()).append(context.getFilesDir()).append("/").append(s).toString();
        s = new File(context);
        if (!s.exists())
        {
            s.mkdir();
        }
        return (new StringBuilder()).append(context).append("/").toString();
    }

    private static String a(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s1 = "";
        } else
        {
            s1 = s;
            if (s.lastIndexOf(File.separator) != 0)
            {
                return (new StringBuilder()).append(s).append(File.separator).toString();
            }
        }
        return s1;
    }

    public static void a(Context context)
    {
        if (cn.jpush.android.util.a.a())
        {
            String s = e(context);
            String s1 = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File((new StringBuilder()).append(s1).append(s).toString());
            if (!file.isDirectory())
            {
                file.mkdirs();
            }
            file = new File((new StringBuilder()).append(s1).append(s).append(z[6]).toString());
            if (!file.isDirectory())
            {
                file.mkdirs();
            }
            file = new File((new StringBuilder()).append(s1).append(s).append(z[1]).toString());
            if (!file.isDirectory())
            {
                file.mkdirs();
            }
            context = new File((new StringBuilder()).append(s1).append(s).append(File.separator).append(context.getPackageName()).toString());
            if (!context.isDirectory())
            {
                context.mkdirs();
            }
            return;
        } else
        {
            x.f();
            return;
        }
    }

    private static boolean a(File file)
    {
        int i;
        if (!file.exists())
        {
            return false;
        }
        String as[];
        File file1;
        int j;
        try
        {
            if (file.isFile())
            {
                return file.delete();
            }
            as = file.list();
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            x.f();
            return false;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        file1 = new File(file, as[i]);
        if (file1.isDirectory())
        {
            a(file1);
            break MISSING_BLOCK_LABEL_88;
        }
        file1.delete();
        break MISSING_BLOCK_LABEL_88;
        boolean flag = file.delete();
        return flag;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String b(Context context)
    {
        if (cn.jpush.android.util.a.a())
        {
            String s = a(Environment.getExternalStorageDirectory().getAbsolutePath());
            s = (new StringBuilder()).append(s).append(e(context)).append(z[6]).toString();
            if (!(new File(s)).isDirectory())
            {
                a(context);
            }
            return (new StringBuilder()).append(s).append(File.separator).toString();
        } else
        {
            return "";
        }
    }

    public static String b(Context context, String s)
    {
        if (cn.jpush.android.util.a.a())
        {
            String s1 = Environment.getExternalStorageDirectory().getAbsolutePath();
            context = (new StringBuilder()).append(s1).append(z[0]).append(context.getPackageName()).append(File.separator).append(s).append(File.separator).toString();
            s = new File(context);
            if (!s.exists())
            {
                s.mkdirs();
            }
            return context;
        }
        File file = new File((new StringBuilder()).append(context.getFilesDir()).append(a).toString());
        if (file.exists() && file.isDirectory())
        {
            File afile[] = file.listFiles();
            if (afile.length > 10)
            {
                Arrays.sort(afile, new l());
                a(afile[afile.length - 1]);
            }
        }
        context = (new StringBuilder()).append(context.getFilesDir()).append(a).append(s).toString();
        s = new File(context);
        if (!s.exists())
        {
            s.mkdirs();
        }
        return (new StringBuilder()).append(context).append("/").toString();
    }

    public static String c(Context context)
    {
        if (cn.jpush.android.util.a.a())
        {
            String s = a(Environment.getExternalStorageDirectory().getAbsolutePath());
            s = (new StringBuilder()).append(s).append(e(context)).append(z[1]).toString();
            if (!(new File(s)).isDirectory())
            {
                a(context);
            }
            return (new StringBuilder()).append(s).append("/").toString();
        } else
        {
            return "";
        }
    }

    public static void d(Context context)
    {
        context = context.getFilesDir().listFiles();
        int j = context.length;
        int i = 0;
        while (i < j) 
        {
            File file = context[i];
            String s = file.getName();
            boolean flag;
            if (TextUtils.isEmpty(s))
            {
                flag = false;
            } else
            {
                flag = Pattern.compile(z[5]).matcher(s).matches();
            }
            if (flag)
            {
                m.a(file.getAbsolutePath());
            }
            i++;
        }
    }

    private static String e(Context context)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String s = sharedpreferences.getString(z[3], "");
        if (TextUtils.isEmpty(s))
        {
            String s1 = Environment.getExternalStorageDirectory().getAbsolutePath();
            context = z[0];
            Object obj1 = new File((new StringBuilder()).append(s1).append(context).toString());
            if (((File) (obj1)).exists())
            {
                Object obj = new ArrayList();
                obj1 = ((File) (obj1)).listFiles();
                int i1 = obj1.length;
                for (int i = 0; i < i1; i++)
                {
                    File file = obj1[i];
                    if (file.isDirectory())
                    {
                        ((ArrayList) (obj)).add(file.getName());
                        (new StringBuilder(z[2])).append(file.getName()).toString();
                        x.b();
                    }
                }

                int j = ((ArrayList) (obj)).size();
                if (j > 0)
                {
                    obj = (String)((ArrayList) (obj)).get(j / 2);
                    context = (new StringBuilder()).append(context).append(((String) (obj))).toString();
                } else
                {
                    context = (new StringBuilder()).append(context).append(UUID.randomUUID().toString().substring(0, 5)).toString();
                }
            } else
            {
                ((File) (obj1)).mkdirs();
                context = (new StringBuilder()).append(context).append(UUID.randomUUID().toString().substring(0, 5)).toString();
            }
            (new StringBuilder(z[4])).append(context).toString();
            x.d();
            sharedpreferences.edit().putString(z[3], context).commit();
        }
        return s;
    }

    static 
    {
        Object obj;
        Object aobj[];
        Object obj1;
        int i;
        int j;
        aobj = new String[7];
        j = 0;
        obj1 = "ID8( \tl2c6\007q7c";
        i = -1;
        obj = ((Object) (aobj));
_L18:
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
        byte1 = i;
        obj1 = ac1;
        i2 = j;
        as = ((String []) (obj));
        k1 = i1;
        if (i1 > 1) goto _L2; else goto _L1
_L1:
        String as1[];
        byte byte0;
        as1 = ((String []) (obj));
        obj = ac1;
        byte0 = i;
_L10:
        k1 = j1;
_L8:
        obj1 = obj;
        l1 = obj1[j1];
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 492
    //                   1 499
    //                   2 505
    //                   3 512;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        i = 82;
_L29:
label0:
        {
            obj1[j1] = (char)(i ^ l1);
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
        i2 = j;
        obj1 = obj;
        byte1 = byte0;
_L2:
        byte0 = byte1;
        obj = obj1;
        j = i2;
        as1 = as;
        i1 = k1;
        j1 = l1;
        if (k1 > l1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        byte1;
        JVM INSTR tableswitch 0 5: default 244
    //                   0 263
    //                   1 282
    //                   2 301
    //                   3 320
    //                   4 339
    //                   5 359;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L11:
        as[i2] = ((String) (obj));
        j = 1;
        obj1 = "I7";
        i = 0;
        obj = ((Object) (aobj));
          goto _L18
_L12:
        as[i2] = ((String) (obj));
        j = 2;
        obj1 = "\002d\"-r\002l$vr";
        i = 1;
        obj = ((Object) (aobj));
          goto _L18
_L13:
        as[i2] = ((String) (obj));
        j = 3;
        obj1 = "\002l$";
        i = 2;
        obj = ((Object) (aobj));
          goto _L18
_L14:
        as[i2] = ((String) (obj));
        j = 4;
        obj1 = "2m3l&\007w1)&Fa?>hF";
        i = 3;
        obj = ((Object) (aobj));
          goto _L18
_L15:
        as[i2] = ((String) (obj));
        j = 5;
        obj1 = "8^fak;~e1v";
        i = 4;
        obj = ((Object) (aobj));
          goto _L18
_L16:
        as[i2] = ((String) (obj));
        j = 6;
        obj1 = "I4";
        i = 5;
        obj = ((Object) (aobj));
          goto _L18
_L17:
        char ac[];
        as[i2] = ((String) (obj));
        z = ((String []) (aobj));
        obj1 = (new StringBuilder()).append(File.separator);
        ac = "\024l5$".toCharArray();
        j = ac.length;
        j1 = 0;
        i = 0;
        aobj = ac;
        i1 = j;
        if (j > 1) goto _L20; else goto _L19
_L19:
        j1 = i;
        i1 = i;
_L28:
        aobj = ac;
        k1 = aobj[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 460
    //                   0 519
    //                   1 526
    //                   2 532
    //                   3 539;
           goto _L21 _L22 _L23 _L24 _L25
_L21:
        i = 82;
_L30:
        aobj[i1] = (char)(i ^ k1);
        j1++;
        if (j != 0) goto _L27; else goto _L26
_L26:
        i1 = j;
          goto _L28
_L4:
        i = 102;
          goto _L29
_L5:
        i = 5;
          goto _L29
_L6:
        i = 86;
          goto _L29
_L7:
        i = 76;
          goto _L29
_L22:
        i = 102;
          goto _L30
_L23:
        i = 5;
          goto _L30
_L24:
        i = 86;
          goto _L30
_L25:
        i = 76;
          goto _L30
_L27:
        i1 = j;
        aobj = ac;
_L20:
        ac = ((char []) (aobj));
        j = i1;
        i = j1;
        if (i1 > j1) goto _L19; else goto _L31
_L31:
        a = ((StringBuilder) (obj1)).append((new String(((char []) (aobj)))).intern()).append(File.separator).toString();
          goto _L8
    }
}
