// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Referenced classes of package cn.jpush.android.util:
//            x, k, ai

public final class m
{

    private static final String z[];

    public static ArrayList a(InputStream inputstream)
    {
        ArrayList arraylist = new ArrayList();
        BufferedReader bufferedreader;
        inputstream = new InputStreamReader(inputstream, z[0]);
        bufferedreader = new BufferedReader(inputstream, 2048);
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s = s.trim();
        if (!"".equals(s))
        {
            arraylist.add(s);
        }
          goto _L1
        try
        {
            inputstream.close();
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.getMessage();
            x.f();
            return arraylist;
        }
        return arraylist;
    }

    public static void a(String s)
    {
        s = new File(s);
        if (s.exists())
        {
            if (s.isDirectory())
            {
                File afile[] = s.listFiles();
                int j = afile.length;
                for (int i = 0; i < j; i++)
                {
                    File file = afile[i];
                    a(file.getAbsolutePath());
                    file.delete();
                }

            }
            s.delete();
        }
    }

    public static boolean a(String s, String s1, Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException(z[1]);
        }
        (new StringBuilder(z[2])).append(s).append(z[3]).append(s1).toString();
        x.b();
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        s = new File(s);
        if (!s.exists())
        {
            s.createNewFile();
        }
        context = new FileOutputStream(s);
        context.write(s1.getBytes(z[0]));
        context.flush();
        context.close();
        return true;
_L4:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s1.close();
        throw s;
        s;
        x.h();
_L2:
        return false;
        s;
        s1 = context;
        continue; /* Loop/switch isn't completed */
        s;
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean a(String s, byte abyte0[], Context context)
    {
        k.a(context);
        if (TextUtils.isEmpty(s) || abyte0.length <= 0) goto _L2; else goto _L1
_L1:
        s = new File(s);
        if (!s.exists())
        {
            s.createNewFile();
        }
        context = new FileOutputStream(s);
        context.write(abyte0);
        context.flush();
        context.close();
        return true;
        s;
        abyte0 = null;
_L4:
        if (abyte0 != null)
        {
            abyte0.close();
        }
        throw s;
_L2:
        return false;
        s;
        abyte0 = context;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String b(String s)
    {
        if (!ai.a(s))
        {
            int i = s.lastIndexOf(".");
            int j = s.length();
            if (i > 0 && i + 1 != j)
            {
                return s.substring(i, s.length());
            }
        }
        return "";
    }

    public static String c(String s)
    {
        if (ai.a(s))
        {
            return "";
        } else
        {
            return s.substring(s.lastIndexOf("/") + 1, s.length());
        }
    }

    static 
    {
        Object obj;
        String as2[];
        int i;
        int j;
        as2 = new String[4];
        obj = "6'\b S";
        i = -1;
        j = 0;
_L10:
        String as[];
        int l;
        int i1;
        int j1;
        int k1;
        as = as2;
        obj = ((String) (obj)).toCharArray();
        l = obj.length;
        if (l > 1)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        i1 = 0;
        j1 = j;
        k1 = i;
_L9:
        j = i1;
_L7:
        char ac[];
        int l1;
        ac = ((char []) (obj));
        l1 = ac[i1];
        j % 5;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 270
    //                   1 277
    //                   2 284
    //                   3 291;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 107;
_L11:
label0:
        {
            ac[i1] = (char)(i ^ l1);
            j++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        i = l;
        as1 = as;
        i2 = j1;
        ac = ((char []) (obj));
        l1 = k1;
_L12:
        k1 = l1;
        obj = ac;
        j1 = i2;
        as = as1;
        l = i;
        i1 = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(ac)).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj = "-&\002AK\000\034 y\016\033\007";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            obj = "\002\020:d\004\rI-\177\016\002\007+E\037\016\037\bd\007\006Sc-\r\n\037+]\n\027\033t";
            j = 2;
            i = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            j = 3;
            obj = "OS-b\005\027\026 yQ";
            i = 2;
            break;

        case 2: // '\002'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 99;
          goto _L11
_L3:
        i = 115;
          goto _L11
_L4:
        i = 78;
          goto _L11
_L5:
        i = 13;
          goto _L11
        boolean flag = false;
        l1 = i;
        ac = ((char []) (obj));
        i2 = j;
        as1 = as;
        i = l;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
