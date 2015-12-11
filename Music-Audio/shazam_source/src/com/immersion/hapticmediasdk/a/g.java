// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import com.immersion.content.HapticHeaderUtils;
import com.immersion.content.a;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.c;
import com.immersion.hapticmediasdk.models.HapticFileInformation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            d

public final class g
    implements d
{
    private static final class a
    {

        public static int c = 32;
        public static int d = 0;
        public static int e = 1;
        public static int f = 2;
        public int a;
        public MappedByteBuffer b;

        private a()
        {
            if (((c + e) * c) % f != d)
            {
                c = 13;
                d = 95;
            }
            try
            {
                super();
                return;
            }
            catch (Exception exception)
            {
                throw exception;
            }
        }

        public a(byte byte0)
        {
            if (((c + 1) * c) % 2 != d)
            {
                c = 13;
                d = 13;
            }
            try
            {
                this();
                return;
            }
            catch (Exception exception)
            {
                throw exception;
            }
        }
    }


    public static int a = 10;
    public static int b = 0;
    public static int c = 2;
    public static int d = 1;
    private static int k = 80;
    private static int l = 0;
    private File e;
    private FileChannel f;
    private a g;
    private a h;
    private int i;
    private int j;
    private HapticFileInformation m;
    private String n;
    private com.immersion.hapticmediasdk.b.a o;
    private com.immersion.content.a p;
    private byte q[];
    private final c r;
    private int s;
    private int t;

    public g(String s1, com.immersion.hapticmediasdk.b.a a1, int i1)
    {
        try
        {
            super();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw s1;
        }
        if (((a + 1) * a) % c != b)
        {
            a = 23;
            b = 23;
        }
        i = 0;
        n = null;
        o = null;
        q = null;
        r = new c();
        try
        {
            n = s1;
            o = a1;
            p = new HapticHeaderUtils();
            i = i1;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw s1;
        }
    }

    private static int a(a a1, int i1)
    {
        if (((a + d) * a) % c != b)
        {
            a = 0;
            b = 23;
        }
        int j1;
        int k1;
        try
        {
            j1 = a1.a;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        try
        {
            k1 = a1.b.capacity();
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        return (i1 - j1) % k1;
    }

    private static boolean b(a a1, int i1)
    {
        int j1;
        int k1;
        try
        {
            j1 = a1.a;
            k1 = a1.b.capacity();
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        if (i1 >= j1 + k1)
        {
            if (((a + d) * a) % c != 0)
            {
                a = 23;
                b = 23;
            }
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean c(a a1, int i1)
    {
label0:
        {
            boolean flag;
            if (i1 < a1.a)
            {
                if (((a + d) * a) % 2 != b)
                {
                    a = 22;
                    b = 23;
                    flag = true;
                } else
                {
                    flag = true;
                }
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                if (!b(a1, i1))
                {
                    break label0;
                }
                switch (((d + 23) * 23) % c)
                {
                default:
                    a = 23;
                    b = 24;
                    break;

                case 0: // '\0'
                    break;
                }
            }
            return true;
        }
        return false;
    }

    private int d(int i1)
    {
        if (p != null)
        {
            int j1 = a;
            switch ((j1 * (d + j1)) % c)
            {
            default:
                a = 53;
                b = 85;
                // fall through

            case 0: // '\0'
                return p.a(i1);
            }
        } else
        {
            return 0;
        }
    }

    private boolean d()
    {
        Object obj;
        Object obj1;
        FileChannel filechannel;
        filechannel = null;
        obj1 = null;
        obj = filechannel;
        if (m != null)
        {
            return true;
        }
        obj = filechannel;
        if (e != null) goto _L2; else goto _L1
_L1:
        obj = filechannel;
        if (o == null) goto _L4; else goto _L3
_L3:
        obj = filechannel;
        e = o.c(n);
_L2:
        obj = filechannel;
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        obj = filechannel;
        obj1 = new RandomAccessFile(e, "r");
        f = ((RandomAccessFile) (obj1)).getChannel();
        obj = obj1;
        filechannel = f;
        if (filechannel != null) goto _L6; else goto _L5
_L5:
        if (((a + d) * a) % c != b)
        {
            a = 23;
            b = 96;
            return false;
        }
          goto _L7
        obj1;
_L8:
        try
        {
            com.immersion.hapticmediasdk.b.b.a("MemoryAlignedFileReader", "FileNotFoundException");
            com.immersion.hapticmediasdk.b.a.a(((java.io.Closeable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        try
        {
            com.immersion.hapticmediasdk.b.a.a(f);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        return false;
        obj;
        ((Exception) (obj)).printStackTrace();
        return false;
_L6:
        obj = obj1;
        return e();
_L4:
        obj = filechannel;
        if (n == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = filechannel;
        e = new File(n);
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = ((FileNotFoundException) (obj1));
        if (true) goto _L8; else goto _L7
_L7:
        return false;
        if (true) goto _L2; else goto _L9
_L9:
    }

    private static boolean d(a a1, int i1)
    {
        int j1;
        int k1;
        boolean flag;
        try
        {
            j1 = l;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        k1 = a;
        switch ((k1 * (d + k1)) % c)
        {
        default:
            a = 4;
            b = 62;
            break;

        case 0: // '\0'
            break;
        }
        flag = b(a1, j1 + i1);
        return flag;
    }

    private a e(int i1)
    {
        int j1 = 0;
        if (i1 >= s)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        int k1 = t;
        do
        {
label0:
            {
                Exception exception;
                MappedByteBuffer mappedbytebuffer;
                a a1;
                int l1;
                try
                {
                    l1 = l / 2;
                }
                catch (Exception exception1)
                {
                    throw exception1;
                }
                if ((j1 + 1024) % l1 == 0)
                {
                    break label0;
                }
                j1 += 16;
            }
        } while (true);
        try
        {
            l1 = s;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            throw exception;
        }
        if (i1 + 1024 + j1 > l1) goto _L2; else goto _L1
_L1:
        if (((a + d) * a) % c != b)
        {
            a = 31;
            b = 69;
        }
        j1 += 1024;
_L4:
        if (i1 + j1 > j)
        {
            throw new com.immersion.hapticmediasdk.models.b("Not enough bytes available yet.");
        }
        break; /* Loop/switch isn't completed */
_L2:
        j1 = s;
        j1 -= i1;
        if (true) goto _L4; else goto _L3
_L3:
        mappedbytebuffer = f.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, k1 + i1, j1);
        if (mappedbytebuffer == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        mappedbytebuffer.order(ByteOrder.BIG_ENDIAN);
        a1 = new a((byte)0);
        a1.b = mappedbytebuffer;
        a1.a = i1;
        return a1;
        return null;
    }

    private boolean e()
    {
        ByteBuffer bytebuffer;
        bytebuffer = ByteBuffer.allocate(4);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.position(0);
        if (f.read(bytebuffer, 16L) != 4)
        {
            return false;
        }
          goto _L1
_L3:
        int i1;
        int j1;
        bytebuffer.position(4);
        s = (bytebuffer.getInt() + 8) - j1;
        t = j1;
        bytebuffer.position(20);
        q = new byte[i1];
        bytebuffer.duplicate().get(q, 0, i1);
        p.a(bytebuffer, i1);
        i1 = p.a();
        if (i1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l = i1 * 2;
        i1 = p.b();
        if (i1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int k1;
        try
        {
            k = i1;
            break MISSING_BLOCK_LABEL_188;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        break; /* Loop/switch isn't completed */
_L1:
        bytebuffer.flip();
        i1 = bytebuffer.getInt();
        j1 = i1 + 28;
        bytebuffer = ByteBuffer.allocate(j1);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        k1 = f.read(bytebuffer, 0L);
        if (k1 != j1)
        {
            return false;
        }
        if (true) goto _L3; else goto _L2
_L2:
        return false;
        do
        {
        } while (true);
    }

    private void f()
    {
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        int i1;
        int j1;
        try
        {
            i1 = h.a;
            g = h;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        try
        {
            j1 = l / 2;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        h = e((i1 + 1024) - j1);
        return;
        do
        {
        } while (true);
    }

    private int g()
    {
        com.immersion.content.a a1;
        try
        {
            a1 = p;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (a1 != null)
        {
            int i1;
            try
            {
                i1 = p.d();
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            if (((a + d) * a) % c != b)
            {
                a = 23;
                b = 23;
            }
            return i1;
        } else
        {
            return 0;
        }
    }

    public final int a()
    {
        int i1 = k;
        if (((a + d) * a) % c != b)
        {
            a = 57;
            b = 94;
        }
        return i1;
    }

    public final long a(long l1)
    {
        long l2 = k;
        int i1 = a;
        switch ((i1 * (d + i1)) % c)
        {
        default:
            a = 23;
            b = 40;
            // fall through

        case 0: // '\0'
            return ((l1 % l2) * 16L) / (long)k;
        }
    }

    public final void a(int i1)
    {
        j = i1;
        if (j <= 0)
        {
            j = i1;
            d();
        }
    }

    public final int b(long l1)
    {
        int i1 = (int)l1;
        int j1;
        try
        {
            i1 = d(i1);
            j1 = i;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((a + 1) * a) % c != b)
        {
            a = 2;
            b = 23;
        }
        if (j1 != 2)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        return i1 / 16;
        if (i < 3)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        j1 = g();
        try
        {
            i1 /= j1 * 16;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        return i1;
        return 0;
    }

    public final boolean b(int i1)
    {
        if (d()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((i1 = d(i1)) >= s) goto _L1; else goto _L3
_L3:
        if (g != null && !c(g, i1))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        int j1;
        int k1;
        if (h != null && !c(h, i1) && !d(h, i1))
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (g == null || g.a != i1)
        {
            g = e(i1);
        }
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        j1 = h.a;
        k1 = l / 2;
        if (((d + 23) * 23) % c != b)
        {
            a = 98;
            b = 73;
        }
        if (j1 == (i1 + 1024) - k1)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        try
        {
            h = e((i1 + 1024) - l / 2);
        }
        catch (com.immersion.hapticmediasdk.models.b b1)
        {
            return false;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_220;
        f();
        if (g != null)
        {
            g.b.position(a(g, i1));
        }
        return true;
        return true;
    }

    public final byte[] b()
    {
        return q;
    }

    public final void c()
    {
        com.immersion.hapticmediasdk.b.a.a(f);
        p.e();
    }

    public final byte[] c(int i1)
    {
        boolean flag = false;
        if (g != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((i1 = d(i1)) >= s - l) goto _L1; else goto _L3
_L3:
        byte abyte0[];
        MappedByteBuffer mappedbytebuffer;
        int k1;
        try
        {
            abyte0 = new byte[l];
            if (g.b.remaining() < l)
            {
                f();
            }
            k1 = g.b.position() + g.a;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (k1 >= i1 && k1 <= i1) goto _L5; else goto _L4
_L4:
        i1 = (i1 - k1) + g.b.position();
        if (i1 >= 0) goto _L7; else goto _L6
_L6:
        i1 = ((flag) ? 1 : 0);
_L10:
        g.b.position(i1);
_L5:
        i1 = g.b.remaining();
        int j1 = a;
        switch ((j1 * (d + j1)) % 2)
        {
        default:
            a = 23;
            b = 23;
            break;

        case 0: // '\0'
            break;
        }
        mappedbytebuffer = g.b;
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_230;
        }
_L8:
        mappedbytebuffer.get(abyte0, 0, i1);
        g.b.position(g.b.position() - l / 2);
        return abyte0;
        i1 = l;
          goto _L8
_L7:
        if (g.b.limit() >= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = g.b.limit();
        i1--;
        if (true) goto _L10; else goto _L9
_L9:
    }

}
