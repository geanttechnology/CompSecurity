// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngine;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineInternalSettings;
import java.util.concurrent.ExecutorService;

// Referenced classes of package jumiomobile:
//            ix, ht, ii, iy

class jb
    implements Runnable
{

    final ix a;

    private jb(ix ix1)
    {
        a = ix1;
        super();
    }

    jb(ix ix1, iy iy)
    {
        this(ix1);
    }

    public void run()
    {
        Object obj = Environment.getMRZEngineSettingsPath(a.a);
        if (obj == null)
        {
            try
            {
                throw new Exception("Loading mrz settings failed!");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                a.d.a(ht.l);
            }
            ix.g(a).shutdownNow();
            return;
        }
        obj = MrzEngineInternalSettings.createFromFilesystem(((String) (obj)));
        ix.a(a, new MrzEngine(((MrzEngineInternalSettings) (obj))));
        return;
    }
}
