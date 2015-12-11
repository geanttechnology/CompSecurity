// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import com.immersion.hapticmediasdk.b.a;
import com.immersion.hapticmediasdk.b.c;
import com.immersion.hapticmediasdk.models.HapticFileInformation;
import com.immersion.hapticmediasdk.models.b;
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

public final class h
    implements d
{
    private static final class a
    {

        public static int c = 99;
        public static int d = 0;
        public static int e = 1;
        public static int f = 2;
        public int a;
        public MappedByteBuffer b;

        private a()
        {
            if (((c + e) * c) % 2 != d)
            {
                c = 68;
                d = 77;
            }
            super();
        }

        public a(byte byte0)
        {
            if (((c + e) * c) % f != d)
            {
                c = 68;
                d = 62;
            }
            this();
        }
    }


    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 93;
    private static int j = 40;
    private static int k = 0;
    private File e;
    private FileChannel f;
    private a g;
    private a h;
    private int i;
    private HapticFileInformation l;
    private String m;
    private final c n = new c();
    private com.immersion.hapticmediasdk.b.a o;

    public h(String s, com.immersion.hapticmediasdk.b.a a1)
    {
        try
        {
            super();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        if (((b + 73) * 73) % c != a)
        {
            a = 73;
        }
        try
        {
            m = s;
            o = a1;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
    }

    private static boolean a(a a1, int i1)
    {
        if (i1 >= a1.a + a1.b.capacity())
        {
            if (((d + b) * d) % c != a)
            {
                d = 73;
                a = 73;
            }
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean b(a a1, int i1)
    {
        boolean flag1 = false;
        if (i1 >= a1.a) goto _L2; else goto _L1
_L1:
        int j1 = d;
        (j1 * (b + j1)) % c;
        JVM INSTR tableswitch 0 0: default 120
    //                   0 115;
           goto _L3 _L4
_L3:
        d = 73;
        a = 73;
        boolean flag = true;
_L9:
        if (flag) goto _L6; else goto _L5
_L5:
        boolean flag2;
        try
        {
            flag2 = a(a1, i1);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        if (((d + b) * d) % c != a)
        {
            d = 52;
            a = 7;
        }
        if (!flag2) goto _L7; else goto _L6
_L6:
        flag1 = true;
_L7:
        return flag1;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static boolean c(a a1, int i1)
    {
        int j1 = d;
        switch ((j1 * (j1 + 1)) % c)
        {
        default:
            d = 57;
            a = 27;
            break;

        case 0: // '\0'
            break;
        }
        boolean flag;
        try
        {
            j1 = k;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        try
        {
            flag = a(a1, j1 + i1);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw a1;
        }
        return flag;
    }

    private a d(int i1)
    {
        if (i1 < l.d())
        {
            int k1 = HapticFileInformation.e();
            MappedByteBuffer mappedbytebuffer;
            int j1;
            if (i1 + 4096 <= l.d())
            {
                j1 = 4096;
            } else
            {
                j1 = l.d() - i1;
            }
            if (i1 + j1 > i)
            {
                throw new b("Not enough bytes available yet.");
            }
            mappedbytebuffer = f.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, k1 + i1, j1);
            if (mappedbytebuffer != null)
            {
                mappedbytebuffer.order(ByteOrder.LITTLE_ENDIAN);
                a a1 = new a((byte)0);
                a1.b = mappedbytebuffer;
                a1.a = i1;
                return a1;
            }
        }
        return null;
    }

    private boolean d()
    {
        boolean flag;
        if (i < 12288)
        {
            flag = false;
        } else
        {
            flag = true;
            if (((b + 73) * 73) % c != a)
            {
                d = 58;
                a = 75;
                return true;
            }
        }
        return flag;
    }

    private boolean e()
    {
        Object obj;
        RandomAccessFile randomaccessfile;
        Object obj1;
        obj1 = null;
        randomaccessfile = null;
        obj = obj1;
        break MISSING_BLOCK_LABEL_6;
_L2:
        obj = obj1;
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        obj = obj1;
        e = o.c(m);
        obj = obj1;
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        obj = obj1;
        randomaccessfile = new RandomAccessFile(e, "r");
        f = randomaccessfile.getChannel();
        obj = randomaccessfile;
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj = randomaccessfile;
        boolean flag;
        try
        {
            return f();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            randomaccessfile = ((RandomAccessFile) (obj));
            obj = filenotfoundexception;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        break MISSING_BLOCK_LABEL_110;
        if (l != null)
        {
            return true;
        }
        obj = obj1;
        flag = d();
        if (!flag) goto _L2; else goto _L1
_L1:
        return false;
_L4:
        com.immersion.hapticmediasdk.b.b.a("MemoryMappedFileReader", ((FileNotFoundException) (obj)).getMessage());
        com.immersion.hapticmediasdk.b.a.a(randomaccessfile);
        com.immersion.hapticmediasdk.b.a.a(f);
        return false;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    private boolean f()
    {
        ByteBuffer bytebuffer;
        bytebuffer = ByteBuffer.allocate(4);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.position(0);
        if (f.read(bytebuffer, 16L) != 4)
        {
            return false;
        }
        int i1;
        bytebuffer.flip();
        i1 = bytebuffer.getInt() + 28;
        bytebuffer = ByteBuffer.allocate(i1);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        if (f.read(bytebuffer, 0L) != i1) goto _L2; else goto _L1
_L1:
        com.immersion.hapticmediasdk.models.HapticFileInformation.a a1;
        bytebuffer.flip();
        a1 = new com.immersion.hapticmediasdk.models.HapticFileInformation.a();
        a1.a(e.getAbsolutePath());
        bytebuffer.position(4);
        a1.a(bytebuffer.getInt() + 8);
        bytebuffer.position(20);
        a1.a = bytebuffer.get();
        if (((com.immersion.hapticmediasdk.models.HapticFileInformation.a.g + com.immersion.hapticmediasdk.models.HapticFileInformation.a.h) * com.immersion.hapticmediasdk.models.HapticFileInformation.a.g) % 2 != com.immersion.hapticmediasdk.models.HapticFileInformation.a.j)
        {
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 18;
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 18;
        }
        i1 = bytebuffer.get();
        ((com.immersion.hapticmediasdk.models.HapticFileInformation.a.h + 61) * 61) % com.immersion.hapticmediasdk.models.HapticFileInformation.a.i;
        JVM INSTR tableswitch 0 0: default 608
    //                   0 214;
           goto _L3 _L4
_L3:
        com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 41;
        com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 61;
_L4:
        int ai[];
        int j1;
        a1.b = i1;
        i1 = bytebuffer.get();
        if (((com.immersion.hapticmediasdk.models.HapticFileInformation.a.h + 61) * 61) % com.immersion.hapticmediasdk.models.HapticFileInformation.a.i != com.immersion.hapticmediasdk.models.HapticFileInformation.a.j)
        {
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 61;
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 98;
        }
        a1.c = i1;
        bytebuffer.position(24);
        bytebuffer.getInt();
        a1.b(bytebuffer.get() | bytebuffer.get() << 8);
        j1 = bytebuffer.get();
        if (((com.immersion.hapticmediasdk.models.HapticFileInformation.a.g + com.immersion.hapticmediasdk.models.HapticFileInformation.a.h) * com.immersion.hapticmediasdk.models.HapticFileInformation.a.g) % com.immersion.hapticmediasdk.models.HapticFileInformation.a.i != 0)
        {
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 61;
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 32;
        }
        a1.d = j1;
        ai = new int[j1];
        i1 = 0;
_L6:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        ai[i1] = bytebuffer.get();
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        if (((com.immersion.hapticmediasdk.models.HapticFileInformation.a.g + 1) * com.immersion.hapticmediasdk.models.HapticFileInformation.a.g) % com.immersion.hapticmediasdk.models.HapticFileInformation.a.i != com.immersion.hapticmediasdk.models.HapticFileInformation.a.j)
        {
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 61;
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 53;
        }
        a1.e = ai;
        i1 = bytebuffer.get();
        if (((com.immersion.hapticmediasdk.models.HapticFileInformation.a.g + 1) * com.immersion.hapticmediasdk.models.HapticFileInformation.a.g) % com.immersion.hapticmediasdk.models.HapticFileInformation.a.i != com.immersion.hapticmediasdk.models.HapticFileInformation.a.j) goto _L8; else goto _L7
_L7:
        a1.f = i1;
        bytebuffer.position(bytebuffer.position() + 4);
        a1.c(bytebuffer.getInt());
        a1.d(bytebuffer.position());
        if (((com.immersion.hapticmediasdk.models.HapticFileInformation.a.g + com.immersion.hapticmediasdk.models.HapticFileInformation.a.h) * com.immersion.hapticmediasdk.models.HapticFileInformation.a.g) % com.immersion.hapticmediasdk.models.HapticFileInformation.a.i != com.immersion.hapticmediasdk.models.HapticFileInformation.a.j)
        {
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 61;
            com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 61;
        }
        l = new HapticFileInformation(a1, (byte)0);
        i1 = (j * l.a()) / 1000;
        int k1 = d;
        switch ((k1 * (k1 + 1)) % c)
        {
        default:
            d = 73;
            a = 51;
            break;

        case 0: // '\0'
            break;
        }
        k = (i1 * l.b() * l.c()) / 8;
        return true;
_L8:
        com.immersion.hapticmediasdk.models.HapticFileInformation.a.g = 61;
        com.immersion.hapticmediasdk.models.HapticFileInformation.a.j = 61;
          goto _L7
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
_L2:
        return false;
    }

    private void g()
    {
        a a1;
        int i1;
        try
        {
            if (h == null)
            {
                return;
            }
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        i1 = h.a;
        a1 = h;
        try
        {
            g = a1;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((b + 73) * 73) % 2 != 0)
        {
            d = 80;
            a = 68;
        }
        h = d(i1 + 4096);
        return;
    }

    public final int a()
    {
        int i1;
        try
        {
            i1 = j;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((d + b) * d) % c != a)
        {
            d = 73;
            a = 73;
        }
        return i1;
    }

    public final long a(long l1)
    {
        int i1 = d;
        switch ((i1 * (b + i1)) % c)
        {
        default:
            d = 89;
            a = 47;
            // fall through

        case 0: // '\0'
            return 0L;
        }
    }

    public final void a(int i1)
    {
        i = i1;
        if (((d + 1) * d) % c != 0)
        {
            d = 62;
            a = 4;
        }
        e();
    }

    public final int b(long l1)
    {
        return 0;
    }

    public final boolean b(int i1)
    {
        if (!e())
        {
            return false;
        }
        float f1;
        float f2;
        Object obj;
        Object obj1;
        a a1;
        int k1;
        int l1;
        boolean flag;
        try
        {
            l1 = i1 / (1000 / l.a());
            if (((d + b) * d) % c != a)
            {
                d = 77;
                a = 64;
            }
            i1 = l.b();
            int j1 = l.c();
            f1 = (float)(i1 * j1) / 8F;
            f2 = (i1 * j1) / 8;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        k1 = (int)f2;
        i1 = k1;
        if (f1 > f2)
        {
            i1 = k1 + 1;
        }
        i1 *= l1;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        flag = b(g, i1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        if (h == null || b(h, i1))
        {
            break MISSING_BLOCK_LABEL_168;
        }
        flag = c(h, i1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        k1 = g.a;
        if (k1 == i1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        g = d(i1);
        if (h == null || h.a != i1 + 4096)
        {
            h = d(i1 + 4096);
        }
        break MISSING_BLOCK_LABEL_371;
        g();
        do
        {
        } while (true);
        obj;
        ((b) (obj)).getMessage();
        return false;
        try
        {
            obj1 = g;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        obj1 = g.b;
        a1 = g;
        k1 = a1.a;
        l1 = d;
        switch ((l1 * (l1 + 1)) % c)
        {
        default:
            d = 73;
            a = 73;
            // fall through

        case 0: // '\0'
            ((MappedByteBuffer) (obj1)).position((i1 - k1) % a1.b.capacity());
            break;
        }
        break MISSING_BLOCK_LABEL_376;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        return false;
        return true;
        return true;
    }

    public final byte[] b()
    {
        return new byte[0];
    }

    public final void c()
    {
        int i1 = d;
        switch ((i1 * (i1 + 1)) % c)
        {
        default:
            d = 73;
            a = 35;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            com.immersion.hapticmediasdk.b.a.a(f);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    public final byte[] c(int i1)
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        obj = g;
        if (((d + b) * d) % c != a)
        {
            d = 73;
            a = 47;
        }
        if (((a) (obj)).a + g.b.position() >= l.d()) goto _L1; else goto _L3
_L3:
        int j1;
        obj = new byte[k];
        if (k < g.b.remaining())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        j1 = g.b.remaining();
        i1 = k - j1;
        g.b.get(((byte []) (obj)), 0, j1);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (h.b.remaining() < i1)
        {
            try
            {
                i1 = h.b.remaining();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return null;
            }
        }
        h.b.get(((byte []) (obj)), j1, i1);
        g();
_L4:
        return ((byte []) (obj));
        g.b.get(((byte []) (obj)), 0, k);
          goto _L4
    }

    static 
    {
        if (((d + b) * d) % c != a)
        {
            d = 55;
            a = 34;
        }
    }
}
