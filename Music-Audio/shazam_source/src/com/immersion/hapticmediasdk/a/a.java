// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import com.immersion.content.HapticHeaderUtils;
import com.immersion.hapticmediasdk.b.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            g, h, d

public final class a
{

    public static int a = 72;
    public static int b = 2;
    public static int c = 1;
    public static int d;

    private static int a(FileChannel filechannel)
    {
        ByteBuffer bytebuffer;
        int i;
        try
        {
            bytebuffer = ByteBuffer.allocate(4);
            bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        // Misplaced declaration of an exception variable
        catch (FileChannel filechannel)
        {
            filechannel.printStackTrace();
            return 0;
        }
        if (d != 0)
        {
            a = 47;
            d = 93;
        }
        bytebuffer.position(0);
        if (filechannel.read(bytebuffer, 16L) != 4)
        {
            return 0;
        }
          goto _L1
_L3:
        bytebuffer.position(4);
        bytebuffer.getInt();
        bytebuffer.position(20);
        filechannel = new HapticHeaderUtils();
        filechannel.a(bytebuffer, i);
        i = filechannel.c();
        return i;
_L1:
        bytebuffer.flip();
        i = bytebuffer.getInt();
        int j = i + 28;
        int k;
        bytebuffer = ByteBuffer.allocate(j);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        k = filechannel.read(bytebuffer, 0L);
        if (k != j)
        {
            return 0;
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static d a(String s, com.immersion.hapticmediasdk.b.a a1)
    {
        b(s, a1);
        JVM INSTR tableswitch -1 3: default 123
    //                   -1 49
    //                   0 40
    //                   1 111
    //                   2 89
    //                   3 100;
           goto _L1 _L2 _L1 _L3 _L4 _L5
_L1:
        com.immersion.hapticmediasdk.b.b.a("FileReaderFactory", "Unsupported HAPT file version");
        return null;
_L2:
        try
        {
            com.immersion.hapticmediasdk.b.b.a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            if (((a + c) * a) % b != 0)
            {
                a = 47;
                c = 47;
                return null;
            } else
            {
                return null;
            }
        }
        return null;
_L4:
        return new g(s, a1, 2);
_L5:
        return new g(s, a1, 3);
_L3:
        s = new h(s, a1);
        return s;
    }

    private static int b(String s, com.immersion.hapticmediasdk.b.a a1)
    {
        int i;
        int j;
        boolean flag;
        {
            flag = false;
            j = 0;
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            i = j;
            try
            {
                s = a1.c(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                try
                {
                    s.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw s;
                }
                return i;
            }
        }
        i = j;
        if (s.length() == 0L)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
        i = ((flag) ? 1 : 0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        i = j;
        s = new File(s);
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_17;
_L1:
        i = j;
        s = (new RandomAccessFile(s, "r")).getChannel();
        i = ((flag) ? 1 : 0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        i = j;
        j = a(s);
        i = j;
        s.close();
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a = 47;
        }
        i = j;
        return i;
    }
}
