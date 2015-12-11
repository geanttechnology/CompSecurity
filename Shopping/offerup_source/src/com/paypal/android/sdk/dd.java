// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.Html;
import android.text.SpannableString;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            kt, kp, fa, ex

public final class dd
{

    private final Context a;

    public dd(Context context)
    {
        a = context;
    }

    public static int a(String s, int i)
    {
        do
        {
            if (i >= s.length())
            {
                break;
            }
            char c1 = s.charAt(i);
            if (c1 != ' ' && c1 != '\t')
            {
                break;
            }
            i++;
        } while (true);
        return i;
    }

    public static int a(String s, int i, String s1)
    {
        for (; i < s.length() && s1.indexOf(s.charAt(i)) == -1; i++) { }
        return i;
    }

    public static String a(File file)
    {
        file = new RandomAccessFile(file, "r");
        byte abyte0[] = new byte[(int)file.length()];
        file.readFully(abyte0);
        file.close();
        return new String(abyte0, "UTF-8");
    }

    public static String a(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return (new StringBuilder("unable_to_encode:")).append(s).toString();
        }
        return s1;
    }

    public static String a(String s, String s1)
    {
        try
        {
            s = kp.a(kt.a((new StringBuilder()).append(s).append(":").append(s1).toString().getBytes("ISO-8859-1")).b);
            s = (new StringBuilder("Basic ")).append(s).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError();
        }
        return s;
    }

    public static String a(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        map = map.entrySet().iterator();
        boolean flag = true;
        while (map.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!flag)
            {
                stringbuilder.append("&");
            } else
            {
                flag = false;
            }
            stringbuilder.append((new StringBuilder()).append((String)entry.getKey()).append("=").append((String)entry.getValue()).toString());
        }
        return stringbuilder.toString();
    }

    public static void a(Activity activity)
    {
        if (a())
        {
            activity.requestWindowFeature(8);
        }
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static void a(File file, String s)
    {
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        fileoutputstream.write(s.getBytes("UTF-8"));
        a(((Closeable) (fileoutputstream)));
        return;
        file;
        s = null;
_L2:
        a(((Closeable) (s)));
        throw file;
        file;
        s = fileoutputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a()
    {
        return android.os.Build.VERSION.SDK_INT >= 11;
    }

    public static boolean a(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    public static boolean a(String s, String s1, String s2)
    {
        boolean flag = a(((CharSequence) (s1)));
        if (flag)
        {
            Log.e(s, (new StringBuilder()).append(s2).append(" is empty.").toString());
        }
        boolean flag1 = d(s1);
        if (flag1)
        {
            Log.e(s, (new StringBuilder()).append(s2).append(" contains whitespace.").toString());
        }
        return !flag && !flag1;
    }

    public static int b(String s, int i)
    {
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        if (l > 0x7fffffffL)
        {
            return 0x7fffffff;
        }
        if (l < 0L)
        {
            return 0;
        } else
        {
            return (int)l;
        }
    }

    public static SpannableString b(String s)
    {
        String s1 = Locale.getDefault().getCountry().toLowerCase(Locale.US);
        boolean flag;
        if (b(((CharSequence) (s1))) || !s1.equals("jp"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            return null;
        }
        s1 = ex.a(fa.ao);
        if (c(s) && s.equals("ja"))
        {
            s = "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=ja_JP";
        } else
        {
            s = "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=en_US";
        }
        return new SpannableString(Html.fromHtml(String.format(s1, new Object[] {
            s, "https://www.paypal.jp/jp/contents/regulation/info/overseas-remittance/"
        })));
    }

    public static void b(Activity activity)
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            activity.setTheme(0x103006e);
            return;
        } else
        {
            activity.setTheme(0x103000c);
            return;
        }
    }

    public static boolean b(CharSequence charsequence)
    {
        boolean flag1 = false;
        if (charsequence == null) goto _L2; else goto _L1
_L1:
        int j = charsequence.length();
        if (j != 0) goto _L3; else goto _L2
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                flag = flag1;
                if (!Character.isWhitespace(charsequence.charAt(i)))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    public static boolean c(CharSequence charsequence)
    {
        return !b(charsequence);
    }

    public static boolean c(String s)
    {
        return s.equals("POST") || s.equals("PUT") || s.equals("PATCH");
    }

    private static boolean d(CharSequence charsequence)
    {
        if (!a(charsequence))
        {
            int j = charsequence.length();
            int i = 0;
            while (i < j) 
            {
                if (Character.isWhitespace(charsequence.charAt(i)))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean d(String s)
    {
        return c(s) || s.equals("DELETE");
    }

    public final void a(Class class1)
    {
        ActivityInfo aactivityinfo[];
        ActivityInfo activityinfo;
        int i;
        int j;
        try
        {
            aactivityinfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 1).activities;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException((new StringBuilder("Exception loading manifest")).append(class1.getMessage()).toString());
        }
        if (aactivityinfo == null) goto _L2; else goto _L1
_L1:
        j = aactivityinfo.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        activityinfo = aactivityinfo[i];
        if (activityinfo.name.equals(class1.getName()) && activityinfo.getThemeResource() != 0x1030010)
        {
            throw new RuntimeException((new StringBuilder("Theme for ")).append(class1.getName()).append(" should be \"@android:style/Theme.Translucent.NoTitleBar\"").toString());
        }
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
