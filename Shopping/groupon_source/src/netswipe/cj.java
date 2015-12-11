// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.ocr.impl.smartEngines.swig.OcrEngine;
import com.jumio.ocr.impl.smartEngines.swig.OcrException;
import java.util.Arrays;

// Referenced classes of package netswipe:
//            de, ce, h, cz, 
//            an, cd

class cj extends Thread
{

    final ce a;
    private byte b[];
    private int c;
    private int d;

    public cj(ce ce1, byte abyte0[], int i, int j)
    {
        a = ce1;
        super();
        b = abyte0;
        c = i;
        d = j;
    }

    public void run()
    {
        try
        {
            ce.a(a, new de());
            if (ce.f(a).d && (ce.e(a).e() || ce.e(a).a(an.d)) || ce.e(a).a(an.d) || ce.e(a).a(an.c))
            {
                ce.b(a, b);
            }
            ce.a(a, System.currentTimeMillis());
            ce.i(a).processUncompressedImageData(b, c, d, c * 3);
            if (ce.c(a) != null)
            {
                ce.c(a).a(ce.k(a));
            }
        }
        catch (OcrException ocrexception)
        {
            ocrexception.printStackTrace();
        }
        Arrays.fill(b, (byte)0);
        b = null;
    }
}
