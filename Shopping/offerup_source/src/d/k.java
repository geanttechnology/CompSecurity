// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package d:
//            ae, e

public final class k
    implements Serializable
{

    public static final k a = a(new byte[0]);
    private static char c[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    final byte b[];
    private transient int d;
    private transient String e;

    k(byte abyte0[])
    {
        b = abyte0;
    }

    public static k a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("s == null");
        } else
        {
            k k1 = new k(s.getBytes(ae.a));
            k1.e = s;
            return k1;
        }
    }

    public static transient k a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("data == null");
        } else
        {
            return new k((byte[])abyte0.clone());
        }
    }

    public static k b(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("base64 == null");
        }
        s = d.e.a(s);
        if (s != null)
        {
            return new k(s);
        } else
        {
            return null;
        }
    }

    private k c(String s)
    {
        try
        {
            s = a(MessageDigest.getInstance(s).digest(b));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public final byte a(int i)
    {
        return b[i];
    }

    public final String a()
    {
        String s = e;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = new String(b, ae.a);
            e = s1;
            return s1;
        }
    }

    public final String b()
    {
        return d.e.a(b);
    }

    public final String c()
    {
        int i = 0;
        char ac[] = new char[b.length << 1];
        byte abyte0[] = b;
        int l = abyte0.length;
        int j = 0;
        for (; i < l; i++)
        {
            byte byte0 = abyte0[i];
            int i1 = j + 1;
            ac[j] = c[byte0 >> 4 & 0xf];
            j = i1 + 1;
            ac[i1] = c[byte0 & 0xf];
        }

        return new String(ac);
    }

    public final k d()
    {
        int i = 0;
        do
        {
label0:
            {
                Object obj = this;
                if (i < b.length)
                {
                    byte byte0 = b[i];
                    if (byte0 < 65 || byte0 > 90)
                    {
                        break label0;
                    }
                    obj = (byte[])b.clone();
                    obj[i] = (byte)(byte0 + 32);
                    for (i++; i < obj.length; i++)
                    {
                        byte byte1 = obj[i];
                        if (byte1 >= 65 && byte1 <= 90)
                        {
                            obj[i] = (byte)(byte1 + 32);
                        }
                    }

                    obj = new k(((byte []) (obj)));
                }
                return ((k) (obj));
            }
            i++;
        } while (true);
    }

    public final int e()
    {
        return b.length;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof k) && ((k)obj).b.length == b.length)
        {
            obj = (k)obj;
            byte abyte0[] = b;
            int i = b.length;
            boolean flag;
            if (((k) (obj)).b.length - i >= 0 && abyte0.length - i >= 0 && ae.a(((k) (obj)).b, 0, abyte0, 0, i))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final byte[] f()
    {
        return (byte[])b.clone();
    }

    public final int hashCode()
    {
        int i = d;
        if (i != 0)
        {
            return i;
        } else
        {
            int j = Arrays.hashCode(b);
            d = j;
            return j;
        }
    }

    public final String toString()
    {
        if (b.length == 0)
        {
            return "ByteString[size=0]";
        }
        if (b.length <= 16)
        {
            return String.format("ByteString[size=%s data=%s]", new Object[] {
                Integer.valueOf(b.length), c()
            });
        } else
        {
            return String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(b.length), c("MD5").c()
            });
        }
    }

}
