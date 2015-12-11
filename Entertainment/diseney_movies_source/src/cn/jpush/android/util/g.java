// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

// Referenced classes of package cn.jpush.android.util:
//            x

public final class g
{

    private static final String z[];

    public static boolean a(String s, File file)
    {
        (new StringBuilder(z[4])).append(s).toString();
        x.c();
        if (s == null || "".equals(s))
        {
            (new StringBuilder(z[1])).append(s).append(z[2]).toString();
            x.c();
            return true;
        }
        if (!file.exists() || file.length() == 0L)
        {
            return false;
        }
        file = b(file);
        (new StringBuilder(z[3])).append(file).toString();
        x.c();
        if (file != null && !"".equals(file) && file.equals(s))
        {
            x.c();
            return true;
        } else
        {
            x.c();
            return false;
        }
    }

    private static byte[] a(File file)
    {
        Object obj = null;
        FileInputStream fileinputstream = new FileInputStream(file);
        file = fileinputstream;
        byte abyte0[] = new byte[1024];
        file = fileinputstream;
        MessageDigest messagedigest = MessageDigest.getInstance(z[0]);
_L2:
        file = fileinputstream;
        int i = fileinputstream.read(abyte0);
        if (i <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        file = fileinputstream;
        messagedigest.update(abyte0, 0, i);
        if (i != -1) goto _L2; else goto _L1
_L1:
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                x.h();
                return null;
            }
        }
        file = messagedigest.digest();
_L4:
        return file;
        file;
        fileinputstream = null;
_L7:
        file = fileinputstream;
        x.h();
        file = obj;
        if (fileinputstream == null) goto _L4; else goto _L3
_L3:
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            x.h();
            return null;
        }
        return null;
        Exception exception;
        exception;
        file = null;
_L6:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                x.h();
                return null;
            }
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        file;
          goto _L7
    }

    private static String b(File file)
    {
        byte abyte0[] = a(file);
        file = "";
        File file1 = file;
        if (abyte0 != null)
        {
            file1 = file;
            if (abyte0.length > 0)
            {
                int i = 0;
                do
                {
                    file1 = file;
                    if (i >= abyte0.length)
                    {
                        break;
                    }
                    file = (new StringBuilder()).append(file).append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1)).toString();
                    i++;
                } while (true);
            }
        }
        return file1;
    }

    static 
    {
        Object obj;
        String as2[];
        int i;
        int j;
        as2 = new String[5];
        obj = "T9;";
        i = -1;
        j = 0;
_L10:
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        as = as2;
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        l = 0;
        i1 = j;
        j1 = i;
_L9:
        j = l;
_L7:
        char ac[];
        int k1;
        ac = ((char []) (obj));
        k1 = ac[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 291
    //                   1 298
    //                   2 305
    //                   3 312;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 80;
_L11:
label0:
        {
            ac[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        ac = ((char []) (obj));
        k1 = j1;
_L12:
        j1 = k1;
        obj = ac;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(ac)).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj = "m\025kt=}H.2\"v\020.'5k\013k&pp\0164t";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            obj = "9\031at>v\t.:5|\031.78|\036et\035]H.7?}\030\"t\"|\t{&>9\t|!5";
            j = 2;
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            obj = "t\031;t9w]z<59\036b=5m]h=<|G.";
            j = 3;
            i = 2;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            j = 4;
            obj = "t\031;t6k\022ct#|\017x1\"9\016g05#]";
            i = 3;
            break;

        case 3: // '\003'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 25;
          goto _L11
_L3:
        i = 125;
          goto _L11
_L4:
        i = 14;
          goto _L11
_L5:
        i = 84;
          goto _L11
        boolean flag = false;
        k1 = i;
        ac = ((char []) (obj));
        l1 = j;
        as1 = as;
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
