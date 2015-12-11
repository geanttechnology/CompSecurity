// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import c.e;
import com.immersion.content.HapticHeaderUtils;
import com.immersion.content.a;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.c;
import com.immersion.hapticmediasdk.models.HapticFileInformation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            d

public class g
    implements d
{

    public static int a = 10;
    public static int b = 0;
    public static int c = 2;
    public static int d = 1;
    private static int k = 80;
    private static int l = 0;
    private File e;
    private FileChannel f;
    private e g;
    private e h;
    private int i;
    private int j;
    private HapticFileInformation m;
    private String n;
    private com.immersion.hapticmediasdk.b.a o;
    private a p;
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
        if (((a + d()) * a) % c != b)
        {
            a = e();
            b = e();
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

    private int a(e e1, int i1)
    {
        if (((a + d) * a) % c != b)
        {
            a = 0;
            b = e();
        }
        int j1;
        int k1;
        try
        {
            j1 = e1.a;
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            throw e1;
        }
        try
        {
            k1 = e1.b.capacity();
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            throw e1;
        }
        return (i1 - j1) % k1;
    }

    private static boolean b(e e1, int i1)
    {
        if (i1 < e1.a)
        {
            if (((a + d) * a) % f() != b)
            {
                a = 22;
                b = e();
            }
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean c(e e1, int i1)
    {
        int j1;
        int k1;
        try
        {
            j1 = e1.a;
            k1 = e1.b.capacity();
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            throw e1;
        }
        if (i1 >= j1 + k1)
        {
            if (((a + d) * a) % c != g())
            {
                a = e();
                b = e();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public static int d()
    {
        return 1;
    }

    private int d(int i1)
    {
        int j1 = 0;
        if (p != null)
        {
label0:
            do
            {
                switch (0)
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
                    break label0;

                case 1: // '\001'
                    break;
                }
            } while (true);
            j1 = a;
            switch ((j1 * (d + j1)) % c)
            {
            default:
                a = 53;
                b = 85;
                // fall through

            case 0: // '\0'
                j1 = p.a(i1);
                break;
            }
        }
        return j1;
    }

    private static boolean d(e e1, int i1)
    {
label0:
        {
            if (!b(e1, i1))
            {
label1:
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
                                continue label1;

                            case 1: // '\001'
                                break label1;
                            }
                        }
                        break;

                    case 0: // '\0'
                        break;

                    case 1: // '\001'
                        break label1;
                    }
                } while (true);
                if (!c(e1, i1))
                {
                    break label0;
                }
                i1 = e();
                switch ((i1 * (d + i1)) % c)
                {
                default:
                    a = e();
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

    public static int e()
    {
        return 23;
    }

    private e e(int i1)
    {
        int k1;
        r.a();
        if (i1 >= s)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        k1 = t;
        MappedByteBuffer mappedbytebuffer;
        e e1;
        int j1;
        int l1;
        try
        {
            j1 = l();
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            l1 = s;
        }
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
            throw new com.immersion.hapticmediasdk.models.c("Not enough bytes available yet.");
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
            break MISSING_BLOCK_LABEL_179;
        }
        mappedbytebuffer.order(ByteOrder.BIG_ENDIAN);
        e1 = new e(null);
        e1.b = mappedbytebuffer;
        e1.a = i1;
        return e1;
        return null;
    }

    private static boolean e(e e1, int i1)
    {
        int j1;
        int k1;
        boolean flag;
        try
        {
            j1 = l;
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            throw e1;
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
        flag = c(e1, j1 + i1);
        return flag;
    }

    public static int f()
    {
        return 2;
    }

    public static int g()
    {
        return 0;
    }

    private boolean h()
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
            a = e();
            b = 96;
            return false;
        }
          goto _L7
        obj1;
_L8:
        try
        {
            com.immersion.hapticmediasdk.b.b.d("MemoryAlignedFileReader", "FileNotFoundException");
            o.a(((java.io.Closeable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        try
        {
            o.a(f);
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
        return i();
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

    private boolean i()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    private void j()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    private int k()
    {
        a a1;
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
                i1 = p.g();
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            if (((a + d) * a) % c != b)
            {
                a = e();
                b = e();
            }
            return i1;
        } else
        {
            return 0;
        }
    }

    private int l()
    {
        int i1;
        for (i1 = 0; (i1 + 1024) % (l / 2) != 0; i1 += 16) { }
        return i1;
    }

    public int a()
    {
        int i1 = k;
        if (((a + d) * a) % c != b)
        {
            a = 57;
            b = 94;
        }
        return i1;
    }

    public long a(long l1)
    {
        long l2 = k;
        int i1 = a;
        switch ((i1 * (d + i1)) % c)
        {
        default:
            a = e();
            b = 40;
            // fall through

        case 0: // '\0'
            return ((l1 % l2) * 16L) / (long)k;
        }
    }

    public void a(int i1)
    {
        j = i1;
        if (j <= 0)
        {
            j = i1;
            h();
        }
    }

    public int b(long l1)
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
        if (((a + d()) * a) % c != b)
        {
            a = 2;
            b = e();
        }
        if (j1 != 2)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        return i1 / 16;
        if (i < 3)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        j1 = k();
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

    public boolean b(int i1)
    {
        if (h()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((i1 = d(i1)) >= s) goto _L1; else goto _L3
_L3:
        if (g != null && !d(g, i1))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        int j1;
        int k1;
        if (h != null && !d(h, i1) && !e(h, i1))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (g == null || g.a != i1)
        {
            g = e(i1);
        }
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        j1 = h.a;
        k1 = l / 2;
        if (((e() + d) * e()) % c != b)
        {
            a = 98;
            b = 73;
        }
        if (j1 == (i1 + 1024) - k1)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        try
        {
            h = e((i1 + 1024) - l / 2);
        }
        catch (com.immersion.hapticmediasdk.models.c c1)
        {
            return false;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_223;
        j();
        if (g != null)
        {
            g.b.position(a(g, i1));
        }
        return true;
        return true;
    }

    public byte[] b()
    {
        return q;
    }

    public void c()
    {
        o.a(f);
        p.h();
    }

    public byte[] c(int i1)
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((i1 = d(i1)) >= s - l) goto _L1; else goto _L3
_L3:
        byte abyte0[];
        MappedByteBuffer mappedbytebuffer;
        int j1;
        try
        {
            abyte0 = new byte[l];
            if (g.b.remaining() < l)
            {
                j();
            }
            j1 = g.b.position() + g.a;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (j1 >= i1 && j1 <= i1) goto _L5; else goto _L4
_L4:
        j1 = (i1 - j1) + g.b.position();
        if (j1 >= 0) goto _L7; else goto _L6
_L6:
        i1 = 0;
_L12:
        g.b.position(i1);
_L5:
        i1 = g.b.remaining();
        j1 = a;
        switch ((j1 * (d + j1)) % f())
        {
        default:
            a = e();
            b = e();
            break;

        case 0: // '\0'
            break;
        }
        mappedbytebuffer = g.b;
        if (i1 >= l) goto _L9; else goto _L8
_L8:
        mappedbytebuffer.get(abyte0, 0, i1);
        mappedbytebuffer = g.b;
        i1 = g.b.position();
          goto _L10
_L17:
        mappedbytebuffer.position(i1 - l / 2);
        return abyte0;
_L9:
        i1 = l;
          goto _L8
_L7:
        i1 = j1;
        if (g.b.limit() >= j1) goto _L12; else goto _L11
_L11:
        i1 = g.b.limit();
        i1--;
          goto _L12
_L10:
        0;
        JVM INSTR tableswitch 0 1: default 312
    //                   0 225
    //                   1 289;
           goto _L13 _L14 _L10
_L14:
        continue; /* Loop/switch isn't completed */
_L13:
        1;
        JVM INSTR tableswitch 0 1: default 336
    //                   0 289
    //                   1 225;
           goto _L13 _L10 _L15
_L15:
        if (true) goto _L17; else goto _L16
_L16:
          goto _L8
    }


    // Unreferenced inner class com/immersion/hapticmediasdk/a/g$a
    public class a
    {
    }

}
