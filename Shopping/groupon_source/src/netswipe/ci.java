// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.enums.ErrorCase;
import com.jumio.netswipe.sdk.environment.Environment;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngine;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineInternalSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrException;

// Referenced classes of package netswipe:
//            ce, cd, cg, cf

class ci extends Thread
{

    final ce a;

    private ci(ce ce1)
    {
        a = ce1;
        super();
    }

    ci(ce ce1, cf cf)
    {
        this(ce1);
    }

    public void run()
    {
        Object obj = Environment.getOCREngineSettingsPath(ce.a(a));
        if (obj == null)
        {
            try
            {
                throw new OcrException("OCR loading failed!");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((OcrException) (obj)).printStackTrace();
            }
            if (ce.c(a) != null)
            {
                ce.c(a).b(ErrorCase.OCR_LOADING_FAILED);
            }
            return;
        }
        obj = OcrEngineInternalSettings.createFromFilesystem(((String) (obj)));
        ce.a(a, new cg(a, null));
        ce.a(a, new OcrEngine(((OcrEngineInternalSettings) (obj)), ce.b(a)));
        return;
    }
}
