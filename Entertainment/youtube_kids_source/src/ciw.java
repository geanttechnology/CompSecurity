// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

class ciw extends ciu
{

    private static final String i = ciw.getSimpleName();
    private static final int j = 14;
    private static boolean o;
    private byte k[];
    private int l;
    private int m;
    private cix n;

    public ciw(URL url, ciz ciz, int i1, cin cin1, cio cio1)
    {
        super(url, ciz, i1, cin1, cio1);
        k = new byte[0x40000];
        l = 0;
        m = 1;
        n = new cix(-1L, -1L);
    }

    private static String a(int i1, cix cix1, int j1)
    {
        long l1 = 0L;
        if (cix1 != null)
        {
            if (!o && (long)i1 != (cix1.a - cix1.b) + 1L)
            {
                throw new AssertionError();
            }
            l1 = cix1.a;
        }
        cix1 = new Vector();
        for (int k1 = 0; k1 < i1; k1 += j1)
        {
            long l2 = k1;
            long l3 = Math.min((k1 + j1) - 1, i1 - 1);
            cix1.add((new StringBuilder(41)).append(l2 + l1).append("-").append(l3 + l1).toString());
        }

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("bytes=");
        for (i1 = cix1.size() - 1; i1 >= 0; i1--)
        {
            if (i1 < cix1.size() - 1)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append((String)cix1.elementAt(i1));
        }

        return stringbuilder.toString();
    }

    private static String a(byte abyte0[], int i1, int j1)
    {
        int k1 = i1;
_L4:
label0:
        {
            if (k1 >= j1)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            if (abyte0[k1] == 10)
            {
                break label0;
            } else
            {
                k1++;
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        if (k1 == -1)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (; i1 <= k1; i1++)
        {
            stringbuilder.append((char)abyte0[i1]);
        }

        return stringbuilder.toString();
        k1 = -1;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
    }

    private final void a(byte abyte0[], int i1)
    {
        int j1;
        for (j1 = k.length; j1 - l < i1; j1 <<= 1) { }
        if (j1 != k.length)
        {
            byte abyte1[] = k;
            k = new byte[j1];
            System.arraycopy(abyte1, 0, k, 0, l);
        }
        System.arraycopy(abyte0, 0, k, l, i1);
        l = l + i1;
        i1 = 0;
        do
        {
            if (i1 >= l)
            {
                break;
            }
            if (m == 3)
            {
                int k1 = (int)((n.b - n.a) + 1L);
                if (k1 <= 0 || k1 > l - i1)
                {
                    break;
                }
                d.a(k, i1, k1);
                i1 += k1;
                m = 1;
                e.f.b.a(k1);
                continue;
            }
            if (m == 1)
            {
                abyte0 = a(k, i1, l);
                if (abyte0 == null)
                {
                    break;
                }
                int l1 = i1 + abyte0.length();
                if (abyte0.length() < j + 1 || !abyte0.substring(0, j).equalsIgnoreCase("Content-Range:"))
                {
                    abyte0 = null;
                } else
                {
                    abyte0 = abyte0.substring(15).split(" ");
                    if (!abyte0[0].equalsIgnoreCase("bytes"))
                    {
                        abyte0 = null;
                    } else
                    {
                        abyte0 = abyte0[1].split("/");
                        if (abyte0.length != 2)
                        {
                            abyte0 = null;
                        } else
                        {
                            abyte0 = abyte0[0].split("-");
                            if (abyte0.length != 2)
                            {
                                abyte0 = null;
                            } else
                            {
                                i1 = Integer.parseInt(abyte0[0]);
                                int j2 = Integer.parseInt(abyte0[1]);
                                if (i1 > j2)
                                {
                                    abyte0 = null;
                                } else
                                {
                                    abyte0 = new cix(i1, j2);
                                }
                            }
                        }
                    }
                }
                i1 = l1;
                if (abyte0 != null)
                {
                    n = abyte0;
                    m = 2;
                    i1 = l1;
                }
                continue;
            }
            if (m != 2)
            {
                continue;
            }
            abyte0 = a(k, i1, l);
            if (abyte0 == null)
            {
                break;
            }
            int i2 = i1 + abyte0.length();
            i1 = i2;
            if (abyte0.equals("\r\n"))
            {
                m = 3;
                i1 = i2;
            }
        } while (true);
        if (i1 > 0)
        {
            abyte0 = k;
            k = new byte[j1];
            System.arraycopy(abyte0, i1, k, 0, l - i1);
            l = l - i1;
        }
    }

    public void run()
    {
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        String s = i;
        if (a == null) goto _L2; else goto _L1
_L1:
        int i1;
        long l1;
        cip cip1 = e.d;
        i1 = cip1.a.b;
        l1 = cip1.a.c;
        if (i1 <= 0) goto _L4; else goto _L3
_L3:
        long l2 = SystemClock.elapsedRealtime();
_L8:
        if (h) goto _L6; else goto _L5
_L5:
        long l3 = SystemClock.elapsedRealtime();
        if (l3 >= (long)(i1 * 1000) + l2) goto _L6; else goto _L7
_L7:
        Thread.sleep(100L);
          goto _L8
        Exception exception;
        exception;
        exception.printStackTrace();
        throw new IOException("Thread.sleep error.");
        IOException ioexception1;
        ioexception1;
        Object obj = null;
_L14:
        Log.e(i, ioexception1.toString());
        obj2 = obj1;
        obj3 = obj;
        if (g == null)
        {
            g = ioexception1;
            obj3 = obj;
            obj2 = obj1;
        }
_L16:
        Object obj4;
        InputStream inputstream;
        byte abyte0[];
        int j1;
        boolean flag;
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            catch (IOException ioexception)
            {
                Log.e(i, ioexception.toString());
                if (g == null)
                {
                    g = ioexception;
                }
                if (obj3 != null)
                {
                    ((HttpURLConnection) (obj3)).disconnect();
                }
            }
        }
_L19:
        d.c();
        e.f.b.b();
        obj = i;
        return;
_L9:
        Thread.sleep(100L);
_L6:
        flag = h;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = e.f.a.c();
        if ((long)i1 >= l1) goto _L9; else goto _L4
_L4:
        if (h) goto _L11; else goto _L10
_L10:
        e.f.a(true);
        obj = i;
        if (e.d.a.g != 3) goto _L13; else goto _L12
_L12:
        obj = i;
        e.f.b.a();
        i1 = d.a();
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_767;
        }
        obj = a(e.j);
        obj2 = i;
        obj2 = String.valueOf(a);
        String s1 = String.valueOf(b);
        (new StringBuilder(String.valueOf(obj2).length() + 46 + String.valueOf(s1).length())).append("SecondaryTask openConnection: ").append(((String) (obj2))).append("; networkType = ").append(s1);
        obj2 = a(a, ((String) (obj)), b);
        obj1 = obj3;
        obj = obj2;
        i1 = ((HttpURLConnection) (obj2)).getResponseCode();
        if (i1 == 200 || i1 == 206)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        obj1 = obj3;
        obj = obj2;
        obj4 = i;
        obj1 = obj3;
        obj = obj2;
        (new StringBuilder(35)).append("Invalid response code = ").append(i1);
        obj1 = obj3;
        obj = obj2;
        try
        {
            throw new IOException((new StringBuilder(34)).append("Invalid response code, ").append(i1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj4) { }
          goto _L14
        obj;
        ((InterruptedException) (obj)).printStackTrace();
        throw new IOException("Thread.sleep error.");
        obj1 = obj3;
        obj = obj2;
        i1 = ((HttpURLConnection) (obj2)).getContentLength();
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_535;
        }
        obj1 = obj3;
        obj = obj2;
        throw new IOException("Failed to get content-length from the secondary http.");
        obj1 = obj3;
        obj = obj2;
        d.a(i1);
_L20:
        obj1 = obj3;
        obj = obj2;
        j1 = (int)Math.ceil((double)i1 / (double)c);
        obj1 = obj3;
        obj = obj2;
        obj4 = a(i1, e.j, j1);
        obj1 = obj3;
        obj = obj2;
        obj4 = a(a, ((String) (obj4)), b);
        obj1 = obj3;
        obj = obj4;
        inputstream = ((HttpURLConnection) (obj4)).getInputStream();
        obj1 = inputstream;
        obj = obj4;
        abyte0 = new byte[j1];
_L18:
        obj2 = inputstream;
        obj3 = obj4;
        obj1 = inputstream;
        obj = obj4;
        if (h) goto _L16; else goto _L15
_L15:
        obj1 = inputstream;
        obj = obj4;
        i1 = inputstream.read(abyte0);
        obj2 = inputstream;
        obj3 = obj4;
        if (i1 < 0) goto _L16; else goto _L17
_L17:
        obj1 = inputstream;
        obj = obj4;
        a(i1);
        obj1 = inputstream;
        obj = obj4;
        a(abyte0, i1);
          goto _L18
_L13:
        obj = i;
_L11:
        obj3 = null;
          goto _L16
_L2:
        ioexception = i;
          goto _L19
        obj2 = null;
          goto _L20
    }

    static 
    {
        boolean flag;
        if (!ciw.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o = flag;
    }
}
