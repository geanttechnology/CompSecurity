// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package c:
//            u, b

public final class f
    implements Serializable
{

    static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    public static final f b = a(new byte[0]);
    public final byte c[];
    transient int d;
    transient String e;

    f(byte abyte0[])
    {
        c = abyte0;
    }

    public static f a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("s == null");
        } else
        {
            f f1 = new f(s.getBytes(u.a));
            f1.e = s;
            return f1;
        }
    }

    public static transient f a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("data == null");
        } else
        {
            return new f((byte[])abyte0.clone());
        }
    }

    public static f b(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("base64 == null");
        }
        s = c.b.a(s);
        if (s != null)
        {
            return new f(s);
        } else
        {
            return null;
        }
    }

    private f c(String s)
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

    public final String a()
    {
        String s = e;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = new String(c, u.a);
            e = s1;
            return s1;
        }
    }

    public final String b()
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

    public final f c()
    {
        int i = 0;
        do
        {
label0:
            {
                Object obj = this;
                if (i < c.length)
                {
                    byte byte0 = c[i];
                    if (byte0 < 65 || byte0 > 90)
                    {
                        break label0;
                    }
                    obj = (byte[])c.clone();
                    obj[i] = (byte)(byte0 + 32);
                    for (i++; i < obj.length; i++)
                    {
                        byte byte1 = obj[i];
                        if (byte1 >= 65 && byte1 <= 90)
                        {
                            obj[i] = (byte)(byte1 + 32);
                        }
                    }

                    obj = new f(((byte []) (obj)));
                }
                return ((f) (obj));
            }
            i++;
        } while (true);
    }

    public final byte[] d()
    {
        return (byte[])c.clone();
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof f) && ((f)obj).c.length == c.length)
        {
            obj = (f)obj;
            byte abyte0[] = c;
            int i = c.length;
            boolean flag;
            if (((f) (obj)).c.length - i >= 0 && abyte0.length - i >= 0 && u.a(((f) (obj)).c, abyte0, i))
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

    public final int hashCode()
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

    public final String toString()
    {
        if (c.length == 0)
        {
            return "ByteString[size=0]";
        }
        if (c.length <= 16)
        {
            return String.format("ByteString[size=%s data=%s]", new Object[] {
                Integer.valueOf(c.length), b()
            });
        } else
        {
            return String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(c.length), c("MD5").b()
            });
        }
    }

}
