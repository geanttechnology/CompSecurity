// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSession;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrLogoType;
import com.jumio.ocr.impl.smartEngines.swig.OcrResult;
import java.util.Arrays;

// Referenced classes of package jumiomobile:
//            fe, fg, cs, fx, 
//            fd, ab

class fj extends Thread
{

    final fe a;
    private byte b[];
    private int c;
    private int d;

    public fj(fe fe1, byte abyte0[], int i, int j)
    {
        a = fe1;
        super();
        b = abyte0;
        c = i;
        d = j;
    }

    public void run()
    {
        fe.d(a).a(c);
        fe.d(a).b(d);
        if (cs.a())
        {
            fe.i(a).delete(0, fe.i(a).length());
            fx.g();
            fe.i(a).append("Image information:\r\n");
            fx.a(fe.i(a), "detection width: ", c);
            fx.a(fe.i(a), "detection height: ", d);
            fx.a(fe.i(a), "upload width: ", fe.e());
            fx.a(fe.i(a), "upload height: ", fe.f());
            fe.i(a).append("\r\n");
        }
        fe.a(a, System.currentTimeMillis());
        Object obj1 = fe.b(a);
        obj1;
        JVM INSTR monitorenter ;
        long l;
        boolean flag;
        if (fe.c(a) == null)
        {
            break MISSING_BLOCK_LABEL_964;
        }
        fe.c(a).setNumberRecognitionFlag(true);
        fe.c(a).setNumberContextCorrectionFlag(true);
        fe.c(a).setExpiryRecognitionFlag(fe.j(a));
        fe.c(a).setExpiryContextCorrectionFlag(fe.j(a));
        fe.c(a).setNameRecognitionFlag(fe.k(a));
        fe.c(a).setNameContextCorrectionFlag(fe.k(a));
        fe.c(a).setUkSortCodeAccountNumberRecognitionFlag(fe.l(a));
        fe.c(a).setUkSortCodeAccountNumberContextCorrectionFlag(fe.l(a));
        fe.c(a).setAmexCVVRecognitionFlag(true);
        fe.c(a).setNumberOfQuadranglesToProcess(1);
        fe.c(a).setRawSecondLineRecognitionFlag(false);
        fe.c(a).setCheckUmpFlag(true);
        fe.c(a).setLogoAnalysisFlag(fe.m(a));
        l = System.currentTimeMillis();
        obj = fe.n(a).processUncompressedImageData(b, c, d, c * 3, fe.c(a));
        flag = ((OcrResult) (obj)).getUmpCardFlag();
        if (fe.m(a)) goto _L2; else goto _L1
_L1:
        fe.f(a).d("Logo detection or data transfer not enabled");
        ab.c("OcrTask", "Logo detection or data transfer not enabled");
_L3:
        StringBuilder stringbuilder;
        long l2;
        l2 = System.currentTimeMillis();
        stringbuilder = new StringBuilder("processImageData ");
        if (fe.r(a))
        {
            obj = "with";
        } else
        {
            obj = "without";
        }
        ab.d("OcrTask", stringbuilder.append(((String) (obj))).append(" logo detector took ").append(l2 - l).append(" ms").toString());
_L5:
        obj1;
        JVM INSTR monitorexit ;
        if (fe.f(a) != null)
        {
            synchronized (fe.s(a))
            {
                fe.f(a).a(fe.t(a), b, c, d, fe.u(a), fe.e(), fe.f(), flag, fe.v(a), fe.w(a));
            }
        }
_L4:
        fe.n(a).resetSession();
        Arrays.fill(b, (byte)0);
        b = null;
        synchronized (a)
        {
            fe.c(a, fe.t(a));
        }
        return;
_L2:
        if (((OcrResult) (obj)).getLogoType() == OcrLogoType.OcrLogoTypeUnknown)
        {
            break MISSING_BLOCK_LABEL_921;
        }
        fe.o(a);
        if (!fe.p(a))
        {
            String s = (new StringBuilder()).append(((OcrResult) (obj)).getLogoType().toString()).append(" ").append(fe.q(a)).append("x").toString();
            fe.f(a).d(s);
            ab.a("OcrTask", s);
        }
        if (fe.q(a) == 3 && fe.m(a) && !fe.p(a))
        {
            fe.a(a, 0);
            fe.a(a, true);
            fe.b(a, false);
            fe.f(a).a(((OcrResult) (obj)).getLogoType().swigValue(), b, c, d);
        }
          goto _L3
        obj;
        obj1;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ab.a(((Throwable) (obj)));
        }
        if (cs.a())
        {
            fx.a(fe.i(a), ((Exception) (obj)));
            long l1 = System.currentTimeMillis();
            obj = fx.a(fe.a(a), "");
            fx.a(fx.f().toString(), ((java.io.File) (obj)), String.format("%d_error.txt", new Object[] {
                Long.valueOf(l1)
            }));
            fx.a(b, ((java.io.File) (obj)), String.format("%d_error.rgb", new Object[] {
                Long.valueOf(l1)
            }));
        }
          goto _L4
        fe.f(a).d("no logo detected");
        ab.c("OcrTask", "no logo detected");
          goto _L3
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        flag = false;
          goto _L5
    }
}
