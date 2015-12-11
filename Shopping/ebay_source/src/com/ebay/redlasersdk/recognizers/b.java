// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.redlasersdk.recognizers;

import RLSDK.aa;
import RLSDK.ab;
import RLSDK.as;
import RLSDK.j;
import RLSDK.n;
import RLSDK.p;
import RLSDK.r;
import RLSDK.u;
import RLSDK.v;
import RLSDK.y;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.ebay.redlasersdk.BarcodeTypes;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package com.ebay.redlasersdk.recognizers:
//            a, BarcodeResultInternal

public final class b extends a
    implements ab
{

    private static Hashtable a;
    private final u b = new u();

    public b(BarcodeTypes barcodetypes)
    {
        super(barcodetypes);
        a();
    }

    protected final BarcodeResultInternal[] ProcessFrame(RLSDK.a a1)
    {
        Object obj;
        Matrix matrix;
        matrix = new Matrix();
        obj = new Rect(0, 0, a1.b, a1.c);
        obj = new p(new as(new j(a1.a, a1.b, a1.c, ((Rect) (obj)).left, ((Rect) (obj)).top, ((Rect) (obj)).width(), ((Rect) (obj)).height())));
        obj = b.a(((p) (obj)));
        b.a();
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_735;
        }
        Object aobj[] = new BarcodeResultInternal[1];
        aobj[0] = new BarcodeResultInternal();
        BarcodeResultInternal barcoderesultinternal;
        float af[];
        Object obj1;
        int i;
        int k;
        if (((y) (obj)).c().equals(n.n))
        {
            aobj[0].barcodeString = (new StringBuilder("0")).append(((y) (obj)).a()).toString();
        } else
        {
            aobj[0].barcodeString = ((y) (obj)).a();
        }
        barcoderesultinternal = aobj[0];
        obj1 = ((y) (obj)).c();
        if (obj1.equals(n.k))
        {
            i = 16;
        } else
        if (obj1.equals(n.f))
        {
            i = 128;
        } else
        if (obj1.equals(n.e))
        {
            i = 32;
        } else
        if (obj1.equals(n.c))
        {
            i = 64;
        } else
        if (obj1.equals(n.h))
        {
            i = 1;
        } else
        if (obj1.equals(n.g))
        {
            i = 4;
        } else
        if (obj1.equals(n.n))
        {
            i = 1;
        } else
        if (obj1.equals(n.o))
        {
            i = 2;
        } else
        if (obj1.equals(n.p))
        {
            i = 4096;
        } else
        if (obj1.equals(n.i))
        {
            i = 256;
        } else
        if (obj1.equals(n.l))
        {
            i = 1024;
        } else
        if (obj1.equals(n.d))
        {
            i = 512;
        } else
        if (obj1.equals(n.b))
        {
            i = 2048;
        } else
        {
            i = 0;
        }
        barcoderesultinternal.barcodeType = i;
        aobj[0].setRecognizedBy(2);
        obj = ((y) (obj)).b();
        af = new float[2];
        for (i = 0; i < obj.length; i++)
        {
            af[0] = obj[i].a();
            af[1] = obj[i].b();
            matrix.mapPoints(af);
            obj1 = new PointF(af[0], af[1]);
            (new StringBuilder("ZXing found point: x=")).append(obj[i].a()).append(" y=").append(obj[i].b()).append(" active rect: l=").append(a1.d.left).append(" t=").append(a1.d.top).append(" r=").append(a1.d.right).append(" b=").append(a1.d.bottom).toString();
            aobj[0].barcodeLocation.add(obj1);
        }

        break MISSING_BLOCK_LABEL_703;
        obj;
        b.a();
        obj = null;
        continue; /* Loop/switch isn't completed */
        obj;
        Log.e("ZXingScanner", "unhandled exception during decode");
        aobj = ((Exception) (obj)).getStackTrace();
        k = aobj.length;
        i = 0;
_L2:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.e("ZXingScanner", ((StackTraceElement) (aobj[i])).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        ((Exception) (obj)).printStackTrace();
        b.a();
        obj = null;
        continue; /* Loop/switch isn't completed */
        a1;
        b.a();
        throw a1;
        (new StringBuilder("VALID: ")).append(aobj[0].barcodeString).toString();
        return ((BarcodeResultInternal []) (aobj));
        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final volatile BarcodeResultInternal[] ProcessFrameSync(RLSDK.a a1)
    {
        return super.ProcessFrameSync(a1);
    }

    public final void a()
    {
        a = new Hashtable();
        Vector vector = new Vector();
        if (enabledScanTypes != null)
        {
            if (enabledScanTypes.getDataMatrix())
            {
                vector.add(n.f);
            }
            if (enabledScanTypes.getQRCode())
            {
                vector.add(n.k);
            }
        }
        a.put(r.c, vector);
        a.put(r.d, Boolean.FALSE);
        a.put(r.h, this);
        b.a(a);
    }

    public final void a(aa aa1)
    {
        (new StringBuilder("foundPossibleResultPoint ")).append(aa1).toString();
        Message.obtain(parentHandler, 0x764840, null).sendToTarget();
    }

    protected final int getInUseFlagValue()
    {
        return 2;
    }

    public final int getRecognizableTypes()
    {
        return 144;
    }

    public final volatile Handler getThreadHandler()
    {
        return super.getThreadHandler();
    }

    public final volatile void run()
    {
        super.run();
    }

    public final volatile void setHandler(Handler handler)
    {
        super.setHandler(handler);
    }
}
