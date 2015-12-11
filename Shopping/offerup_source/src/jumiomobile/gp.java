// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.util.SparseArray;
import com.jumio.commons.camera.ImageData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;
import com.jumio.netverify.sdk.enums.NVScanSide;

// Referenced classes of package jumiomobile:
//            gm

class gp
    implements Runnable
{

    final gm a;

    gp(gm gm1)
    {
        a = gm1;
        super();
    }

    public void run()
    {
        Object obj;
        boolean flag;
        if (a.m.F)
        {
            flag = a.m.g();
        } else
        {
            flag = true;
        }
        obj = (ImageData)a.m.u.get(a.n.getScanSide().getPartNumber());
        if (obj != null && ((ImageData) (obj)).g())
        {
            obj = ((ImageData) (obj)).h();
        } else
        {
            obj = null;
        }
        a.o.onNetverifyScanForPartFinished(a.n, ((String) (obj)), flag);
    }
}
