// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.MessageDigest;
import java.util.Locale;

// Referenced classes of package u.aly:
//            bu, bi, u, bh, 
//            ci

public class c
{

    private final byte a[] = new byte[8];
    private String b;
    private String c;
    private byte d[];
    private byte e[];
    private byte f[];
    private int g;
    private int h;
    private int i;
    private byte j[];
    private byte k[];

    private c(byte abyte0[], String s, byte abyte1[])
        throws Exception
    {
        b = "1.0";
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        h = 0;
        i = 0;
        j = null;
        k = null;
        if (abyte0 == null || abyte0.length == 0)
        {
            throw new Exception("entity is null or empty");
        } else
        {
            c = s;
            i = abyte0.length;
            j = bu.a(abyte0);
            h = (int)(System.currentTimeMillis() / 1000L);
            k = abyte1;
            return;
        }
    }

    public static c a(Context context, String s, byte abyte0[])
    {
        try
        {
            String s1 = bi.p(context);
            String s2 = bi.f(context);
            context = u.a(context);
            String s3 = context.getString("signature", null);
            int l = context.getInt("serial", 1);
            s = new c(abyte0, s, (new StringBuilder(String.valueOf(s2))).append(s1).toString().getBytes());
            s.a(s3);
            s.a(l);
            s.b();
            context.edit().putInt("serial", l + 1).putString("signature", s.a()).commit();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return s;
    }

    public static byte[] a(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.reset();
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

    private byte[] a(byte abyte0[], int l)
    {
        byte abyte1[];
        byte abyte2[];
        byte abyte3[];
        int i1;
        boolean flag;
        int j1;
        flag = false;
        abyte1 = a(k);
        abyte2 = a(j);
        j1 = abyte1.length;
        abyte3 = new byte[j1 * 2];
        i1 = 0;
_L5:
        if (i1 < j1) goto _L2; else goto _L1
_L1:
        i1 = 0;
_L6:
        if (i1 < 2) goto _L4; else goto _L3
_L3:
        byte byte0;
        byte byte1;
        byte byte2;
        byte byte3;
        byte0 = (byte)(l & 0xff);
        byte1 = (byte)(l >> 8 & 0xff);
        byte2 = (byte)(l >> 16 & 0xff);
        byte3 = (byte)(l >>> 24);
        l = ((flag) ? 1 : 0);
_L7:
        if (l >= abyte3.length)
        {
            return abyte3;
        }
        break MISSING_BLOCK_LABEL_175;
_L2:
        abyte3[i1 * 2] = abyte2[i1];
        abyte3[i1 * 2 + 1] = abyte1[i1];
        i1++;
          goto _L5
_L4:
        abyte3[i1] = abyte0[i1];
        abyte3[abyte3.length - i1 - 1] = abyte0[abyte0.length - i1 - 1];
        i1++;
          goto _L6
        abyte3[l] = (byte)(abyte3[l] ^ (new byte[] {
            byte0, byte1, byte2, byte3
        })[l % 4]);
        l++;
          goto _L7
    }

    public static String b(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int l = 0;
        do
        {
            if (l >= abyte0.length)
            {
                return stringbuffer.toString().toLowerCase(Locale.US);
            }
            stringbuffer.append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[l])
            }));
            l++;
        } while (true);
    }

    public static byte[] b(String s)
    {
        byte abyte0[] = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        int i1;
        return abyte0;
_L2:
        if ((i1 = s.length()) % 2 != 0)
        {
            continue;
        }
        byte abyte1[] = new byte[i1 / 2];
        int l = 0;
        do
        {
            abyte0 = abyte1;
            if (l >= i1)
            {
                continue;
            }
            abyte1[l / 2] = (byte)Integer.valueOf(s.substring(l, l + 2), 16).intValue();
            l += 2;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private byte[] d()
    {
        return a(a, (int)(System.currentTimeMillis() / 1000L));
    }

    private byte[] e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(b(d));
        stringbuilder.append(g);
        stringbuilder.append(h);
        stringbuilder.append(i);
        stringbuilder.append(b(e));
        return a(stringbuilder.toString().getBytes());
    }

    public String a()
    {
        return b(d);
    }

    public void a(int l)
    {
        g = l;
    }

    public void a(String s)
    {
        d = b(s);
    }

    public void b()
    {
        if (d == null)
        {
            d = d();
        }
        e = a(d, h);
        f = e();
    }

    public byte[] c()
    {
        bh bh1 = new bh();
        bh1.a(b);
        bh1.b(c);
        bh1.c(b(d));
        bh1.a(g);
        bh1.c(h);
        bh1.d(i);
        bh1.a(j);
        bh1.d(b(e));
        bh1.e(b(f));
        byte abyte0[];
        try
        {
            abyte0 = (new ci()).a(bh1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(String.format("version : %s\n", new Object[] {
            b
        }));
        stringbuilder.append(String.format("address : %s\n", new Object[] {
            c
        }));
        stringbuilder.append(String.format("signature : %s\n", new Object[] {
            b(d)
        }));
        stringbuilder.append(String.format("serial : %s\n", new Object[] {
            Integer.valueOf(g)
        }));
        stringbuilder.append(String.format("timestamp : %d\n", new Object[] {
            Integer.valueOf(h)
        }));
        stringbuilder.append(String.format("length : %d\n", new Object[] {
            Integer.valueOf(i)
        }));
        stringbuilder.append(String.format("guid : %s\n", new Object[] {
            b(e)
        }));
        stringbuilder.append(String.format("checksum : %s ", new Object[] {
            b(f)
        }));
        return stringbuilder.toString();
    }
}
