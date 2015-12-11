// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.clientlib.impl.livenessAndTM.FrameProcessorLivenessDetector;
import com.jumio.clientlib.impl.livenessAndTM.ImageOrientation;
import com.jumio.clientlib.impl.livenessAndTM.LibImage;
import com.jumio.clientlib.impl.livenessAndTM.PixelFormatType;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            in, l, n, iq, 
//            ab, ht, ii

public class ir extends Thread
{

    final in a;
    private FrameProcessorLivenessDetector b;
    private Queue c;
    private int d;

    public ir(in in1)
    {
        a = in1;
        super();
        d = -1;
        c = new ConcurrentLinkedQueue();
    }

    private void b()
    {
        if (b != null)
        {
            b.reset();
            b.delete();
            b = null;
        }
    }

    public void a()
    {
        c.clear();
        d = -1;
    }

    public void a(byte abyte0[])
    {
        int i;
        int j;
        n n1 = in.a(a).c;
        i = n1.a;
        j = n1.b;
        if (in.a(a).e == 0 || in.a(a).e == 180)
        {
            c.add(new iq(a, abyte0, i, j, in.a(a).e, PixelFormatType.PIXEL_FORMAT_YUV420_NV21, i));
            return;
        }
        try
        {
            c.add(new iq(a, abyte0, j, i, in.a(a).e, PixelFormatType.PIXEL_FORMAT_YUV420_NV21, j));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            in.b(a);
        }
        ab.a(abyte0);
        System.gc();
        return;
    }

    public void run()
    {
        Object obj;
        iq iq1;
        byte abyte0[];
        LibImage libimage;
        PixelFormatType pixelformattype;
        int i;
        int j;
        int k;
        long l1;
        try
        {
            b = new FrameProcessorLivenessDetector(in.c(a), in.d(a));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.d.a(ht.l);
            ab.a(((Throwable) (obj)));
        }
        iq1 = (iq)c.poll();
_L9:
        if (b == null || isInterrupted())
        {
            break MISSING_BLOCK_LABEL_300;
        }
        if (iq1 == null) goto _L2; else goto _L1
_L1:
        System.currentTimeMillis();
        iq.a(iq1);
        JVM INSTR lookupswitch 3: default 100
    //                   0: 271
    //                   180: 278
    //                   270: 285;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_285;
_L3:
        obj = ImageOrientation.IMAGE_ORIENTATION_PORTRAIT;
_L7:
        abyte0 = iq.b(iq1);
        pixelformattype = iq.c(iq1);
        i = iq.d(iq1);
        j = iq.e(iq1);
        l1 = iq.f(iq1);
        k = d + 1;
        d = k;
        libimage = new LibImage(abyte0, pixelformattype, i, j, l1, 1, 1, k, 0);
        try
        {
            if (in.e(a) == null && in.f(a) != null && d > 10)
            {
                in.f(a).put(Integer.valueOf(d), iq1);
            }
            b.pushFrame(libimage, ((ImageOrientation) (obj)));
        }
        catch (Exception exception)
        {
            ab.a(exception);
        }
        System.currentTimeMillis();
_L2:
        iq1 = (iq)c.poll();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = ImageOrientation.IMAGE_ORIENTATION_LANDSCAPE;
          goto _L7
_L5:
        obj = ImageOrientation.IMAGE_ORIENTATION_REVERSE_LANDSCAPE;
          goto _L7
        obj = ImageOrientation.IMAGE_ORIENTATION_REVERSE_PORTRAIT;
          goto _L7
        b();
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
