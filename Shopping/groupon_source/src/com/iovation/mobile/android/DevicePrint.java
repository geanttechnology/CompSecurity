// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android;

import android.content.Context;
import com.iovation.mobile.android.details.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DevicePrint
{

    private static String a(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder("0500");
        HashMap hashmap = new HashMap();
        a(((Map) (hashmap)), context);
        stringbuilder.append(a(a(((Map) (hashmap)))));
        return stringbuilder.toString();
        context;
        throw context;
    }

    private static String a(String s)
    {
        String s1 = "";
        if (s != null)
        {
            try
            {
                s1 = a(s.getBytes("utf-8"));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return "";
            }
        }
        return s1;
    }

    private static String a(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (map == null)
        {
            stringbuilder.append("0");
        } else
        {
            Formatter formatter = new Formatter(stringbuilder);
            formatter.format("%04x", new Object[] {
                Integer.valueOf(map.size())
            });
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                a(formatter, (String)entry.getKey());
                a(formatter, (String)entry.getValue());
            }
        }
        return stringbuilder.toString();
    }

    private static String a(byte abyte0[])
    {
        int i = 0;
        byte abyte1[];
        ByteArrayOutputStream bytearrayoutputstream;
        abyte1 = new byte[16];
        (new Random()).nextBytes(abyte1);
        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write("0500".getBytes());
        bytearrayoutputstream.write(abyte0);
        if (bytearrayoutputstream.size() % 16 != 0) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.write(new byte[] {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0
        }, 0, i);
        abyte0 = Cipher.getInstance("AES/CBC/NoPadding");
        IvParameterSpec ivparameterspec = new IvParameterSpec(abyte1);
        abyte0.init(1, new SecretKeySpec(new byte[] {
            16, -59, 20, -5, -54, -85, 110, 61, -51, -99, 
            70, -78, 11, -44, 3, 5, -120, 58, -14, 74, 
            13, -122, 35, 120, 14, -60, 67, 73, -58, -90, 
            42, 112
        }, "AES"), ivparameterspec);
        abyte0 = abyte0.doFinal(bytearrayoutputstream.toByteArray());
        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(abyte1);
        bytearrayoutputstream.write(abyte0);
        return new String(b(bytearrayoutputstream.toByteArray()));
_L2:
        i = bytearrayoutputstream.size();
        i = 16 - i % 16;
          goto _L1
        abyte0;
        return "";
    }

    private static void a(Formatter formatter, String s)
    {
        try
        {
            formatter.format("%04x", new Object[] {
                Integer.valueOf(s.getBytes("UTF-8").length)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Formatter formatter)
        {
            return;
        }
        formatter.format("%s", new Object[] {
            s
        });
    }

    private static void a(Map map, Context context)
    {
        a(map, h.a(context));
    }

    private static void a(Map map, String s, String s1)
    {
        if (s != null && s1 != null && s1.length() > 0)
        {
            map.put(s, s1);
        }
    }

    private static void a(Map map, Map map1)
    {
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); a(map, (String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

    }

    private static byte[] b(byte abyte0[])
    {
        byte abyte1[];
        int l;
        int l1;
label0:
        {
            l = 0;
            abyte1 = new byte[64];
            byte[] _tmp = abyte1;
            abyte1[0] = 65;
            abyte1[1] = 66;
            abyte1[2] = 67;
            abyte1[3] = 68;
            abyte1[4] = 69;
            abyte1[5] = 70;
            abyte1[6] = 71;
            abyte1[7] = 72;
            abyte1[8] = 73;
            abyte1[9] = 74;
            abyte1[10] = 75;
            abyte1[11] = 76;
            abyte1[12] = 77;
            abyte1[13] = 78;
            abyte1[14] = 79;
            abyte1[15] = 80;
            abyte1[16] = 81;
            abyte1[17] = 82;
            abyte1[18] = 83;
            abyte1[19] = 84;
            abyte1[20] = 85;
            abyte1[21] = 86;
            abyte1[22] = 87;
            abyte1[23] = 88;
            abyte1[24] = 89;
            abyte1[25] = 90;
            abyte1[26] = 97;
            abyte1[27] = 98;
            abyte1[28] = 99;
            abyte1[29] = 100;
            abyte1[30] = 101;
            abyte1[31] = 102;
            abyte1[32] = 103;
            abyte1[33] = 104;
            abyte1[34] = 105;
            abyte1[35] = 106;
            abyte1[36] = 107;
            abyte1[37] = 108;
            abyte1[38] = 109;
            abyte1[39] = 110;
            abyte1[40] = 111;
            abyte1[41] = 112;
            abyte1[42] = 113;
            abyte1[43] = 114;
            abyte1[44] = 115;
            abyte1[45] = 116;
            abyte1[46] = 117;
            abyte1[47] = 118;
            abyte1[48] = 119;
            abyte1[49] = 120;
            abyte1[50] = 121;
            abyte1[51] = 122;
            abyte1[52] = 48;
            abyte1[53] = 49;
            abyte1[54] = 50;
            abyte1[55] = 51;
            abyte1[56] = 52;
            abyte1[57] = 53;
            abyte1[58] = 54;
            abyte1[59] = 55;
            abyte1[60] = 56;
            abyte1[61] = 57;
            abyte1[62] = 43;
            abyte1[63] = 47;
            if (abyte0 != null)
            {
                l1 = abyte0.length;
                if (l1 != 0)
                {
                    break label0;
                }
            }
            throw new Exception("Invalid length");
        }
        int i2 = l1 / 3;
        byte abyte2[];
        int i;
        int j;
        int i1;
        if (l1 % 3 != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        abyte2 = new byte[(i + i2) * 4];
        i1 = 0;
        j = 0;
        i = l;
        l = i1;
        for (; j < i2; j++)
        {
            int l2 = l + 1;
            i1 = abyte0[l];
            int k2 = l2 + 1;
            l2 = abyte0[l2];
            l = k2 + 1;
            i1 = (l2 & 0xff) << 8 | (i1 & 0xff) << 16 | abyte0[k2] & 0xff;
            k2 = i + 1;
            abyte2[i] = abyte1[i1 >> 18 & 0x3f];
            i = k2 + 1;
            abyte2[k2] = abyte1[i1 >> 12 & 0x3f];
            k2 = i + 1;
            abyte2[i] = abyte1[i1 >> 6 & 0x3f];
            i = k2 + 1;
            abyte2[k2] = abyte1[i1 & 0x3f];
        }

        i1 = i2 * 3;
        if (i1 < l1)
        {
            int j2 = l + 1;
            l = (abyte0[l] & 0xff) << 16;
            int k = i + 1;
            abyte2[i] = abyte1[l >> 18 & 0x3f];
            if (i1 + 1 < l1)
            {
                l = (abyte0[j2] & 0xff) << 8 | l;
                int j1 = k + 1;
                abyte2[k] = abyte1[l >> 12 & 0x3f];
                i = j1 + 1;
                abyte2[j1] = abyte1[l >> 6 & 0x3f];
            } else
            {
                int k1 = k + 1;
                abyte2[k] = abyte1[l >> 12 & 0x3f];
                i = k1 + 1;
                abyte2[k1] = 61;
            }
            abyte2[i] = 61;
        }
        return abyte2;
    }

    public static String getBlackbox(Context context)
    {
        return a(context);
    }

    public static String ioBegin(Context context)
    {
        return getBlackbox(context);
    }
}
