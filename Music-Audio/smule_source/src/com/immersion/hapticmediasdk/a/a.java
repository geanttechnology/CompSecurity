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

public class a
{

    public static int a = 72;
    public static int b = 2;
    public static int c = 1;
    public static int d;

    public static int a()
    {
        return 1;
    }

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
        if (((b() + a()) * b()) % d() != d)
        {
            a = b();
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
        i = filechannel.f();
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
_L4:
        0;
        JVM INSTR tableswitch 0 1: default 180
    //                   0 65
    //                   1 155;
           goto _L2 _L3 _L4
_L2:
        0;
        JVM INSTR tableswitch 0 1: default 204
    //                   0 65
    //                   1 155;
           goto _L2 _L3 _L4
    }

    public static d a(String s, com.immersion.hapticmediasdk.b.a a1)
    {
        b(s, a1);
        JVM INSTR tableswitch -1 3: default 133
    //                   -1 50
    //                   0 40
    //                   1 121
    //                   2 99
    //                   3 110;
           goto _L1 _L2 _L1 _L3 _L4 _L5
_L1:
        com.immersion.hapticmediasdk.b.b.d("FileReaderFactory", "Unsupported HAPT file version");
        break; /* Loop/switch isn't completed */
_L2:
        try
        {
            com.immersion.hapticmediasdk.b.b.b("FileReaderFactory", "Can't retrieve Major version! Not enough bytes available yet.");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            if (((a + c) * a) % b != c())
            {
                a = b();
                c = b();
                return null;
            }
            break MISSING_BLOCK_LABEL_187;
        }
        return null;
_L4:
        return new g(s, a1, 2);
_L5:
        return new g(s, a1, 3);
_L3:
        s = new h(s, a1);
        return s;
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
        return null;
    }

    public static int b()
    {
        return 47;
    }

    private static int b(String s, com.immersion.hapticmediasdk.b.a a1)
    {
        Object obj;
        int i;
        int j;
        boolean flag;
        {
            obj = null;
            flag = false;
            j = 0;
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_35;
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
            break MISSING_BLOCK_LABEL_131;
        }
        i = j;
        s = new File(s);
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_21;
_L1:
        a1 = obj;
        if (false)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        i = j;
        a1 = (new RandomAccessFile(s, "r")).getChannel();
        i = ((flag) ? 1 : 0);
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        i = j;
        j = a(a1);
        i = j;
        a1.close();
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a = b();
        }
        i = j;
        return i;
    }

    public static int c()
    {
        return 0;
    }

    public static int d()
    {
        return 2;
    }
}
