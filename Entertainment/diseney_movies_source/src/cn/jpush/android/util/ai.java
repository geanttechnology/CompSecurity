// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ai
{

    private static String a;
    private static final String z[];

    public static boolean a(String s)
    {
        while (s == null || s.length() == 0 || s.trim().length() == 0) 
        {
            return true;
        }
        return false;
    }

    public static boolean a(String s, String s1)
    {
        while (s == null || s1 == null) 
        {
            return false;
        }
        return s.equals(s1);
    }

    public static String b(String s)
    {
        int i = 0;
        if (s == null || "".equals(s))
        {
            return null;
        }
        StringBuffer stringbuffer;
        byte byte0;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance(z[1]);
            messagedigest.update(s.getBytes());
            s = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s == null)
        {
            return "";
        }
        stringbuffer = new StringBuffer(s.length * 2);
_L1:
        if (i >= s.length)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        byte0 = s[i];
        stringbuffer.append(z[0].charAt(byte0 >> 4 & 0xf)).append(z[0].charAt(byte0 & 0xf));
        i++;
          goto _L1
        s = stringbuffer.toString();
        return s;
    }

    static 
    {
        Object obj1;
        String as2[];
        int k;
        int l;
        as2 = new String[2];
        obj1 = "\r<)\0375\b;,\0248|OXhD{";
        k = -1;
        l = 0;
_L10:
        Object obj;
        String as[];
        int i;
        int j;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        j = obj1.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        i = 0;
        as = ((String []) (obj));
        i1 = l;
        obj = obj1;
        j1 = k;
_L9:
        l = i;
        k = i;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 244
    //                   1 251
    //                   2 258
    //                   3 265;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 1;
_L11:
label0:
        {
            obj1[k] = (char)(i ^ k1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        k = j;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        j = k;
        i = l;
        if (k > l) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "pI.";
            l = 1;
            k = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            z = as2;
            a = z[0];
            return;
        }
          goto _L10
_L6:
        i = 61;
          goto _L11
_L3:
        i = 13;
          goto _L11
_L4:
        i = 27;
          goto _L11
_L5:
        i = 44;
          goto _L11
        boolean flag = false;
        k1 = k;
        l1 = l;
        as1 = ((String []) (obj));
        k = j;
        l = ((flag) ? 1 : 0);
          goto _L12
    }
}
