// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package com.paypal.android.sdk:
//            lm, kp

public final class kt
    implements Serializable, Comparable
{

    public static final kt a = a(new byte[0]);
    private static char c[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    final byte b[];
    private transient int d;
    private transient String e;

    kt(byte abyte0[])
    {
        b = abyte0;
    }

    public static kt a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("s == null");
        } else
        {
            kt kt1 = new kt(s.getBytes(lm.a));
            kt1.e = s;
            return kt1;
        }
    }

    public static transient kt a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("data == null");
        } else
        {
            return new kt((byte[])abyte0.clone());
        }
    }

    public static kt b(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("base64 == null");
        }
        s = kp.a(s);
        if (s != null)
        {
            return new kt(s);
        } else
        {
            return null;
        }
    }

    private kt c(String s)
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

    public final String a()
    {
        String s = e;
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = new String(b, lm.a);
            e = s1;
            return s1;
        }
    }

    public final String b()
    {
        int i = 0;
        char ac[] = new char[b.length << 1];
        byte abyte0[] = b;
        int k = abyte0.length;
        int j = 0;
        for (; i < k; i++)
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac[j] = c[byte0 >> 4 & 0xf];
            j = l + 1;
            ac[l] = c[byte0 & 0xf];
        }

        return new String(ac);
    }

    public final kt c()
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

                    obj = new kt(((byte []) (obj)));
                }
                return ((kt) (obj));
            }
            i++;
        } while (true);
    }

    public final int compareTo(Object obj)
    {
        int i;
        int j;
        int k;
        int l;
        obj = (kt)obj;
        j = b.length;
        k = ((kt) (obj)).b.length;
        l = Math.min(j, k);
        i = 0;
_L9:
        if (i >= l) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        i1 = b[i] & 0xff;
        j1 = ((kt) (obj)).b[i] & 0xff;
        if (i1 == j1) goto _L4; else goto _L3
_L3:
        if (i1 >= j1) goto _L6; else goto _L5
_L5:
        return -1;
_L6:
        return 1;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == k)
        {
            return 0;
        }
        if (j < k) goto _L5; else goto _L7
_L7:
        return 1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final byte[] d()
    {
        return (byte[])b.clone();
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof kt) && ((kt)obj).b.length == b.length)
        {
            obj = (kt)obj;
            byte abyte0[] = b;
            int i = b.length;
            boolean flag;
            if (((kt) (obj)).b.length - i >= 0 && abyte0.length - i >= 0 && lm.a(((kt) (obj)).b, 0, abyte0, 0, i))
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
                Integer.valueOf(b.length), b()
            });
        } else
        {
            return String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(b.length), c("MD5").b()
            });
        }
    }

}
