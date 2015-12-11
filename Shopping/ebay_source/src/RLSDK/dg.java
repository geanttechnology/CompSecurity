// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package RLSDK:
//            s, ai, dk, am, 
//            aj, di, au, dl

final class dg
{

    private static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', 
        '+', '-', '.', '/', ':'
    };

    private static char a(int i)
        throws s
    {
        if (i >= a.length)
        {
            throw s.a();
        } else
        {
            return a[i];
        }
    }

    static am a(byte abyte0[], dl dl, di di1, Hashtable hashtable)
        throws s
    {
        aj aj1;
        Vector vector;
        ai ai1;
        StringBuffer stringbuffer;
        boolean flag;
        ai1 = new ai(abyte0);
        stringbuffer = new StringBuffer(50);
        aj1 = null;
        flag = false;
        vector = new Vector(1);
_L5:
        dk dk1;
        if (ai1.a() < 4)
        {
            dk1 = dk.a;
        } else
        {
            try
            {
                dk1 = dk.a(ai1.a(4));
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw s.a();
            }
        }
        if (dk1.equals(dk.a)) goto _L2; else goto _L1
_L1:
        if (!dk1.equals(dk.h) && !dk1.equals(dk.i)) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if (dk1.equals(dk.a))
        {
            hashtable = stringbuffer.toString();
            dl = vector;
            if (vector.isEmpty())
            {
                dl = null;
            }
            int i;
            int j;
            if (di1 == null)
            {
                di1 = null;
            } else
            {
                di1 = di1.toString();
            }
            return new am(abyte0, hashtable, dl, di1);
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (dk1.equals(dk.d))
        {
            ai1.a(16);
        } else
        if (dk1.equals(dk.f))
        {
            i = ai1.a(8);
            if ((i & 0x80) == 0)
            {
                i &= 0x7f;
            } else
            if ((i & 0xc0) == 128)
            {
                i = (i & 0x3f) << 8 | ai1.a(8);
            } else
            if ((i & 0xe0) == 192)
            {
                i = (i & 0x1f) << 16 | ai1.a(16);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Bad ECI bits starting with byte ")).append(i).toString());
            }
            aj1 = aj.a(i);
            if (aj1 == null)
            {
                throw s.a();
            }
        } else
        if (dk1.equals(dk.j))
        {
            i = ai1.a(4);
            j = ai1.a(dk1.a(dl));
            if (i == 1)
            {
                a(ai1, stringbuffer, j);
            }
        } else
        {
            i = ai1.a(dk1.a(dl));
            if (dk1.equals(dk.b))
            {
                c(ai1, stringbuffer, i);
            } else
            if (dk1.equals(dk.c))
            {
                a(ai1, stringbuffer, i, flag);
            } else
            if (dk1.equals(dk.e))
            {
                a(ai1, stringbuffer, i, aj1, vector, hashtable);
            } else
            if (dk1.equals(dk.g))
            {
                b(ai1, stringbuffer, i);
            } else
            {
                throw s.a();
            }
        }
          goto _L2
    }

    private static void a(ai ai1, StringBuffer stringbuffer, int i)
        throws s
    {
        if (i * 13 > ai1.a())
        {
            throw s.a();
        }
        byte abyte0[] = new byte[i * 2];
        boolean flag = false;
        int j = i;
        i = ((flag) ? 1 : 0);
        while (j > 0) 
        {
            int k = ai1.a(13);
            k = k % 96 | k / 96 << 8;
            if (k < 959)
            {
                k += 41377;
            } else
            {
                k += 42657;
            }
            abyte0[i] = (byte)(k >> 8 & 0xff);
            abyte0[i + 1] = (byte)(k & 0xff);
            j--;
            i += 2;
        }
        try
        {
            stringbuffer.append(new String(abyte0, "GB2312"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ai ai1)
        {
            throw s.a();
        }
    }

    private static void a(ai ai1, StringBuffer stringbuffer, int i, aj aj1, Vector vector, Hashtable hashtable)
        throws s
    {
        if (i << 3 > ai1.a())
        {
            throw s.a();
        }
        byte abyte0[] = new byte[i];
        for (int j = 0; j < i; j++)
        {
            abyte0[j] = (byte)ai1.a(8);
        }

        if (aj1 == null)
        {
            ai1 = au.a(abyte0, hashtable);
        } else
        {
            ai1 = aj1.a();
        }
        try
        {
            stringbuffer.append(new String(abyte0, ai1));
        }
        // Misplaced declaration of an exception variable
        catch (ai ai1)
        {
            throw s.a();
        }
        vector.addElement(abyte0);
    }

    private static void a(ai ai1, StringBuffer stringbuffer, int i, boolean flag)
        throws s
    {
        int j = stringbuffer.length();
        for (; i > 1; i -= 2)
        {
            int k = ai1.a(11);
            stringbuffer.append(a(k / 45));
            stringbuffer.append(a(k % 45));
        }

        if (i == 1)
        {
            stringbuffer.append(a(ai1.a(6)));
        }
        if (flag)
        {
            i = j;
            while (i < stringbuffer.length()) 
            {
                if (stringbuffer.charAt(i) == '%')
                {
                    if (i < stringbuffer.length() - 1 && stringbuffer.charAt(i + 1) == '%')
                    {
                        stringbuffer.deleteCharAt(i + 1);
                    } else
                    {
                        stringbuffer.setCharAt(i, '\035');
                    }
                }
                i++;
            }
        }
    }

    private static void b(ai ai1, StringBuffer stringbuffer, int i)
        throws s
    {
        if (i * 13 > ai1.a())
        {
            throw s.a();
        }
        byte abyte0[] = new byte[i * 2];
        boolean flag = false;
        int j = i;
        i = ((flag) ? 1 : 0);
        while (j > 0) 
        {
            int k = ai1.a(13);
            k = k % 192 | k / 192 << 8;
            if (k < 7936)
            {
                k += 33088;
            } else
            {
                k += 49472;
            }
            abyte0[i] = (byte)(k >> 8);
            abyte0[i + 1] = (byte)k;
            j--;
            i += 2;
        }
        try
        {
            stringbuffer.append(new String(abyte0, "SJIS"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ai ai1)
        {
            throw s.a();
        }
    }

    private static void c(ai ai1, StringBuffer stringbuffer, int i)
        throws s
    {
        for (; i >= 3; i -= 3)
        {
            int j = ai1.a(10);
            if (j >= 1000)
            {
                throw s.a();
            }
            stringbuffer.append(a(j / 100));
            stringbuffer.append(a((j / 10) % 10));
            stringbuffer.append(a(j % 10));
        }

        if (i == 2)
        {
            i = ai1.a(7);
            if (i >= 100)
            {
                throw s.a();
            }
            stringbuffer.append(a(i / 10));
            stringbuffer.append(a(i % 10));
        } else
        if (i == 1)
        {
            i = ai1.a(4);
            if (i >= 10)
            {
                throw s.a();
            } else
            {
                stringbuffer.append(a(i));
                return;
            }
        }
    }

}
