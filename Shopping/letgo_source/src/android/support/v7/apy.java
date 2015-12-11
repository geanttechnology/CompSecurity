// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package android.support.v7:
//            aqm, apu, apv

public class apy
    implements Serializable
{

    static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    public static final apy b = a(new byte[0]);
    final byte c[];
    transient int d;
    transient String e;

    apy(byte abyte0[])
    {
        c = abyte0;
    }

    public static apy a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("s == null");
        } else
        {
            apy apy1 = new apy(s.getBytes(aqm.a));
            apy1.e = s;
            return apy1;
        }
    }

    public static transient apy a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("data == null");
        } else
        {
            return new apy((byte[])abyte0.clone());
        }
    }

    public static apy b(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("base64 == null");
        }
        s = apu.a(s);
        if (s != null)
        {
            return new apy(s);
        } else
        {
            return null;
        }
    }

    private apy c(String s)
    {
        try
        {
            s = a(MessageDigest.getInstance(s).digest(c));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public byte a(int i)
    {
        return c[i];
    }

    public String a()
    {
        String s = e;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = new String(c, aqm.a);
            e = s1;
            return s1;
        }
    }

    void a(apv apv1)
    {
        apv1.b(c, 0, c.length);
    }

    public boolean a(int i, byte abyte0[], int j, int k)
    {
        return i <= c.length - k && j <= abyte0.length - k && aqm.a(c, i, abyte0, j, k);
    }

    public String b()
    {
        return apu.a(c);
    }

    public apy c()
    {
        return c("MD5");
    }

    public String d()
    {
        int i = 0;
        char ac[] = new char[c.length * 2];
        byte abyte0[] = c;
        int k = abyte0.length;
        int j = 0;
        for (; i < k; i++)
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac[j] = a[byte0 >> 4 & 0xf];
            j = l + 1;
            ac[l] = a[byte0 & 0xf];
        }

        return new String(ac);
    }

    public apy e()
    {
        Object obj;
label0:
        {
            int i = 0;
            byte byte0;
            do
            {
                obj = this;
                if (i >= c.length)
                {
                    break label0;
                }
                byte0 = c[i];
                if (byte0 >= 65 && byte0 <= 90)
                {
                    break;
                }
                i++;
            } while (true);
            obj = (byte[])c.clone();
            obj[i] = (byte)(byte0 + 32);
            i++;
            while (i < obj.length) 
            {
                byte byte1 = obj[i];
                if (byte1 >= 65 && byte1 <= 90)
                {
                    obj[i] = (byte)(byte1 + 32);
                }
                i++;
            }
            obj = new apy(((byte []) (obj)));
        }
        return ((apy) (obj));
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        boolean flag;
        if ((obj instanceof apy) && ((apy)obj).f() == c.length && ((apy)obj).a(0, c, 0, c.length))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public int f()
    {
        return c.length;
    }

    public byte[] g()
    {
        return (byte[])c.clone();
    }

    public int hashCode()
    {
        int i = d;
        if (i != 0)
        {
            return i;
        } else
        {
            int j = Arrays.hashCode(c);
            d = j;
            return j;
        }
    }

    public String toString()
    {
        if (c.length == 0)
        {
            return "ByteString[size=0]";
        }
        if (c.length <= 16)
        {
            return String.format("ByteString[size=%s data=%s]", new Object[] {
                Integer.valueOf(c.length), d()
            });
        } else
        {
            return String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(c.length), c().d()
            });
        }
    }

}
