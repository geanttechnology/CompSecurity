// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngine;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineInternalSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSettings;

// Referenced classes of package jumiomobile:
//            fe, ab, dz, fd, 
//            fg, ff

class fi extends Thread
{

    final fe a;

    private fi(fe fe1)
    {
        a = fe1;
        super();
    }

    fi(fe fe1, ff ff)
    {
        this(fe1);
    }

    public void run()
    {
        Object obj = Environment.getOCREngineSettingsPath(fe.a(a));
        if (obj == null)
        {
            try
            {
                throw new Exception("OCR loading failed!");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ab.a(((Throwable) (obj)));
            }
            if (fe.f(a) != null)
            {
                fe.f(a).b(dz.g);
            }
            return;
        }
        obj = OcrEngineInternalSettings.createFromFilesystem(((String) (obj)));
        fe.a(a, new fg(a, null));
        fe.a(a, new OcrEngine(((OcrEngineInternalSettings) (obj))));
        synchronized (fe.b(a))
        {
            fe.a(a, new OcrEngineSettings());
            fe.c(a).setIntensityThreshold(70);
            fe.c(a).setFocusThreshold(20);
        }
        fe.a(a, fe.e(a).createSession(fe.d(a)));
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
