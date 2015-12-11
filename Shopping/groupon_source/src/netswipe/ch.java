// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.ocr.impl.smartEngines.swig.DetectionEngine;
import com.jumio.ocr.impl.smartEngines.swig.DetectionResult;
import java.util.Arrays;

// Referenced classes of package netswipe:
//            ce, cz, h, cd, 
//            am, an

class ch extends Thread
{

    final ce a;
    private byte b[];
    private am c;

    public ch(ce ce1, byte abyte0[], am am1)
    {
        a = ce1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
        c = am1;
    }

    public void run()
    {
        if (ce.d(a))
        {
            return;
        }
        ce.a = 800;
        ce.b = 600;
        byte abyte0[];
        if (ce.e(a).e())
        {
            if (ce.f(a).c.width < 800)
            {
                int i = (ce.f(a).a.width - ce.f(a).b.width) / 2;
                int k = ce.f(a).c.width / ce.f(a).a.width;
                ce.a = ce.f(a).c.width - i * k * 2;
                ce.b = (int)((float)ce.a * 0.75F);
            }
        } else
        if (ce.f(a).c.height < 600)
        {
            int j = (ce.f(a).a.height - ce.f(a).b.height) / 2;
            int l = ce.f(a).c.height / ce.f(a).a.height;
            ce.b = ce.f(a).c.height - j * l * 2;
            ce.a = (int)((float)ce.b / 0.75F);
        }
        abyte0 = ce.a(a, b, null, ce.a, ce.b);
        if (abyte0 != null)
        {
            DetectionResult detectionresult = ce.g(a).processRawImage(abyte0, ce.a, ce.b, ce.a * 3, (int)System.currentTimeMillis());
            if (detectionresult != null && ce.c(a) != null)
            {
                cd cd1 = ce.c(a);
                boolean flag1 = detectionresult.getFlashTurnOn();
                boolean flag;
                if (detectionresult.getNeedRefocus() || !detectionresult.isCardImageOfGoodQuality())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                cd1.a(false, false, false, false, flag1, flag);
            }
        }
        if (!ce.h(a) && ce.i(a) != null && c == am.b && abyte0 != null)
        {
            a.a(abyte0, ce.a, ce.b);
            ce.a(a, ce.a(a, b, ce.j(a), 320, 240));
            if (ce.f(a).d && (ce.e(a).e() || ce.e(a).a(an.d)) || ce.e(a).a(an.d) || ce.e(a).a(an.c))
            {
                ce.b(a, ce.j(a));
            }
        }
        b = null;
        ce.a(a, false);
    }
}
