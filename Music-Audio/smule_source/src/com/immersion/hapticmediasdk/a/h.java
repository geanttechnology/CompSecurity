// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import c.b;
import com.immersion.hapticmediasdk.b.a;
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

public class h
    implements d
{

    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 93;
    private static int j = 40;
    private static int k = 0;
    private File e;
    private FileChannel f;
    private b g;
    private b h;
    private int i;
    private HapticFileInformation l;
    private String m;
    private final c n = new c();
    private a o;

    public h(String s, a a1)
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
        if (((d() + b) * d()) % c != a)
        {
            a = d();
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

    private int a(b b1, int i1)
    {
        int j1 = b1.a;
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        int k1 = d;
        switch ((k1 * (e() + k1)) % c)
        {
        default:
            d = d();
            a = d();
            // fall through

        case 0: // '\0'
            return (i1 - j1) % b1.b.capacity();
        }
    }

    private static boolean b(b b1, int i1)
    {
        if (i1 < b1.a)
        {
            i1 = d;
            switch ((i1 * (b + i1)) % c)
            {
            default:
                d = d();
                a = d();
                // fall through

            case 0: // '\0'
                return true;
            }
        }
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        return false;
    }

    private static boolean c(b b1, int i1)
    {
        if (i1 >= b1.a + b1.b.capacity())
        {
            if (((d + b) * d) % c != a)
            {
                d = d();
                a = d();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public static int d()
    {
        return 73;
    }

    private boolean d(int i1)
    {
        if (i >= i1)
        {
            if (((d() + b) * d()) % c != a)
            {
                d = 58;
                a = 75;
            }
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean d(b b1, int i1)
    {
label0:
        {
label1:
            {
                boolean flag;
                try
                {
                    if (b(b1, i1))
                    {
                        break label1;
                    }
                    flag = c(b1, i1);
                }
                // Misplaced declaration of an exception variable
                catch (b b1)
                {
                    throw b1;
                }
                if (((d + b) * d) % c != a)
                {
                    d = 52;
                    a = 7;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public static int e()
    {
        return 1;
    }

    private int e(int i1)
    {
        int k1 = i1 / (1000 / l.e());
        if (((d + b) * d) % c != a)
        {
            d = 77;
            a = 64;
        }
        i1 = l.f();
        int j1 = l.g();
        float f1 = (float)(i1 * j1) / 8F;
        float f2 = (i1 * j1) / 8;
        j1 = (int)f2;
        i1 = j1;
        if (f1 > f2)
        {
            i1 = j1 + 1;
        }
        return i1 * k1;
    }

    private static boolean e(b b1, int i1)
    {
        int j1 = d;
        switch ((j1 * (e() + j1)) % c)
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
        catch (b b1)
        {
            throw b1;
        }
        try
        {
            flag = c(b1, j1 + i1);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            throw b1;
        }
        return flag;
    }

    public static int f()
    {
        return 0;
    }

    private b f(int i1)
    {
        n.a();
        if (i1 < l.h())
        {
            int k1 = l.i();
            MappedByteBuffer mappedbytebuffer;
            int j1;
            if (i1 + 4096 <= l.h())
            {
                j1 = 4096;
            } else
            {
                j1 = l.h() - i1;
            }
            if (i1 + j1 > i)
            {
                throw new com.immersion.hapticmediasdk.models.c("Not enough bytes available yet.");
            }
            mappedbytebuffer = f.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, k1 + i1, j1);
            if (mappedbytebuffer != null)
            {
                mappedbytebuffer.order(ByteOrder.LITTLE_ENDIAN);
                b b1 = new b(null);
                b1.b = mappedbytebuffer;
                b1.a = i1;
                return b1;
            }
        }
        return null;
    }

    public static int g()
    {
        return 2;
    }

    private boolean h()
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
            break MISSING_BLOCK_LABEL_154;
        }
        obj = randomaccessfile;
        boolean flag;
        try
        {
            return i();
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
        break MISSING_BLOCK_LABEL_113;
        if (l != null)
        {
            return true;
        }
        obj = obj1;
        flag = d(12288);
        if (!flag) goto _L2; else goto _L1
_L1:
        return false;
_L4:
        com.immersion.hapticmediasdk.b.b.d("MemoryMappedFileReader", ((FileNotFoundException) (obj)).getMessage());
        o.a(randomaccessfile);
        o.a(f);
        return false;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    private boolean i()
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
        int j1;
        bytebuffer.flip();
        i1 = bytebuffer.getInt() + 28;
        bytebuffer = ByteBuffer.allocate(i1);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        j1 = f.read(bytebuffer, 0L);
          goto _L1
_L8:
        if (j1 != i1)
        {
            break MISSING_BLOCK_LABEL_386;
        }
        com.immersion.hapticmediasdk.models.a a1;
        int ai[];
        bytebuffer.flip();
        a1 = new com.immersion.hapticmediasdk.models.a();
        a1.a(e.getAbsolutePath());
        bytebuffer.position(4);
        a1.a(bytebuffer.getInt() + 8);
        bytebuffer.position(20);
        a1.b(bytebuffer.get());
        a1.c(bytebuffer.get());
        a1.d(bytebuffer.get());
        bytebuffer.position(24);
        a1.e(bytebuffer.getInt());
        a1.f(bytebuffer.get() | bytebuffer.get() << 8);
        j1 = bytebuffer.get();
        a1.g(j1);
        ai = new int[j1];
        i1 = 0;
_L3:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        ai[i1] = bytebuffer.get();
        i1++;
        if (true) goto _L3; else goto _L2
_L2:
        a1.a(ai);
        a1.h(bytebuffer.get());
        bytebuffer.position(bytebuffer.position() + 4);
        a1.i(bytebuffer.getInt());
        a1.j(bytebuffer.position());
        l = a1.e();
        i1 = (j * l.e()) / 1000;
        int k1 = d;
        switch ((k1 * (e() + k1)) % c)
        {
        default:
            d = d();
            a = 51;
            break;

        case 0: // '\0'
            break;
        }
        k = (i1 * l.f() * l.g()) / 8;
        return true;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return false;
_L1:
        0;
        JVM INSTR tableswitch 0 1: default 412
    //                   0 78
    //                   1 388;
           goto _L4 _L5 _L1
_L5:
        continue; /* Loop/switch isn't completed */
_L4:
        1;
        JVM INSTR tableswitch 0 1: default 436
    //                   0 388
    //                   1 78;
           goto _L4 _L1 _L6
_L6:
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void j()
    {
        b b1;
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
        b1 = h;
        try
        {
            g = b1;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((d() + b) * d()) % g() != f())
        {
            d = 80;
            a = 68;
        }
        h = f(i1 + 4096);
        return;
    }

    public int a()
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
            d = d();
            a = d();
        }
        return i1;
    }

    public long a(long l1)
    {
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
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

    public void a(int i1)
    {
        i = i1;
        if (((d + e()) * d) % c != f())
        {
            d = 62;
            a = 4;
        }
        h();
    }

    public int b(long l1)
    {
        return 0;
    }

    public boolean b(int i1)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public byte[] b()
    {
        return new byte[0];
    }

    public void c()
    {
        int i1 = d;
        switch ((i1 * (e() + i1)) % c)
        {
        default:
            d = d();
            a = 35;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            o.a(f);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    public byte[] c(int i1)
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        return null;
_L8:
        if (i1 + g.b.position() >= l.h()) goto _L1; else goto _L3
_L3:
        Object obj = new byte[k];
        if (k < g.b.remaining()) goto _L5; else goto _L4
_L4:
        int j1;
        j1 = g.b.remaining();
        i1 = k - j1;
        g.b.get(((byte []) (obj)), 0, j1);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_123;
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
        j();
_L9:
        return ((byte []) (obj));
_L2:
        obj = g;
        if (((d + b) * d) % c != a)
        {
            d = d();
            a = 47;
        }
        i1 = ((b) (obj)).a;
_L7:
        1;
        JVM INSTR tableswitch 0 1: default 196
    //                   0 171
    //                   1 9;
           goto _L6 _L7 _L8
_L6:
        0;
        JVM INSTR tableswitch 0 1: default 220
    //                   0 9
    //                   1 171;
           goto _L6 _L8 _L7
_L5:
        g.b.get(((byte []) (obj)), 0, k);
          goto _L9
    }

    static 
    {
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        if (((d + b) * d) % c != a)
        {
            d = 55;
            a = 34;
        }
    }

    // Unreferenced inner class com/immersion/hapticmediasdk/a/h$a
    public class a
    {
    }

}
