// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.ocr.impl.smartEngines.swig.ImageCheck;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSettings;

// Referenced classes of package jumiomobile:
//            fe, l, n, fd, 
//            ab

class fh extends Thread
{

    public boolean a;
    final fe b;

    public fh(fe fe1, byte abyte0[], boolean flag)
    {
        b = fe1;
        super();
        if (fe.g(fe1) == null)
        {
            fe.a(fe1, new byte[(int)(fe.h(fe1).c() * (float)(fe.h(fe1).c.a * fe.h(fe1).c.b))]);
        }
        System.arraycopy(abyte0, 0, fe.g(fe1), 0, abyte0.length);
        a = flag;
    }

    public void run()
    {
        boolean flag = ImageCheck.isRefocusNeeded(fe.g(b), 20, fe.h(b).c.a, fe.h(b).c.b, fe.h(b).c.a, 1);
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        byte abyte0[];
        OcrEngineSettings ocrenginesettings;
        try
        {
            fe.f(b).a(ImageCheck.computeFlashConfidence(fe.g(b), fe.h(b).c.a, fe.h(b).c.b, fe.h(b).c.a, 1));
            b.a(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L3
_L2:
        obj1 = new n(-1, -1);
        abyte0 = fe.a(b, fe.g(b), ((n) (obj1)));
        if (abyte0 == null) goto _L5; else goto _L4
_L4:
        obj = fe.b(b);
        obj;
        JVM INSTR monitorenter ;
        ocrenginesettings = fe.c(b);
        if (ocrenginesettings == null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        flag = ImageCheck.isFlashNeeded(abyte0, fe.c(b).getIntensityThreshold(), ((n) (obj1)).a, ((n) (obj1)).b, ((n) (obj1)).a * 3, 3);
_L6:
        obj;
        JVM INSTR monitorexit ;
        if (fe.f(b) != null)
        {
            fe.f(b).b(flag, false);
        }
        flag = false;
_L5:
        if (flag)
        {
            Exception exception;
            int i;
            try
            {
                i = ImageCheck.computeFocusConfidence(abyte0, ((n) (obj1)).a, ((n) (obj1)).b, ((n) (obj1)).a * 3, 3);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ab.b("ImageCheck", "computeFocusConfidence failed!", ((Throwable) (obj)));
                i = 0;
            }
            fe.f(b).a(i);
            b.a(false);
            return;
        } else
        {
            b.a(abyte0, ((n) (obj1)).a, ((n) (obj1)).b, fe.g(b), a);
            b.a(false);
            return;
        }
        obj;
        flag = false;
_L3:
        ab.b("ImageCheck", "computeFlashConfidence failed!", ((Throwable) (obj)));
          goto _L2
        exception;
        ab.b("ImageCheck", "isFlashNeeded failed!", exception);
        break MISSING_BLOCK_LABEL_384;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        flag = false;
          goto _L6
    }
}
