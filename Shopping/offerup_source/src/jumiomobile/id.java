// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.Context;
import android.widget.ScrollView;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import com.jumio.ocr.impl.smartEngines.swig.ImageCheck;

// Referenced classes of package jumiomobile:
//            hq, ix, je, hz, 
//            ij, jk, ig, in, 
//            iu, b, ab, a, 
//            ii, if, mk, mf, 
//            l, cb, ie, ao, 
//            mr, mt, g, hp

public abstract class id
{

    protected Context a;
    protected l b;
    protected ao c;
    protected ii d;
    protected ModelTemplate e;
    protected long f;
    mr g;
    private boolean h;

    public id(Context context, ModelTemplate modeltemplate, ao ao, ii ii1)
    {
        h = true;
        g = null;
        a = context;
        c = ao;
        d = ii1;
        e = modeltemplate;
        f = System.currentTimeMillis();
    }

    public static id a(Activity activity, ModelTemplate modeltemplate, ao ao, ii ii1, mt mt, g g1, hq hq1, hp hp)
    {
        Object obj = null;
        if (hq1 == hq.a || hq1 == hq.b || hq1 == hq.c || hq1 == hq.d || hq1 == hq.e)
        {
            hp = new ix(activity, modeltemplate, ao, g1, ii1, mt, hq1);
        } else
        {
            if (hq1 == hq.f || hq1 == hq.g)
            {
                return new je(activity, modeltemplate, ao, ii1, modeltemplate.D, hq1);
            }
            if (hq1 == hq.h)
            {
                if (!modeltemplate.F)
                {
                    return new hz(activity, modeltemplate, ao, ii1, mt, g1, hp);
                } else
                {
                    return new ij(activity, modeltemplate, ao, ii1, mt, g1, hp);
                }
            }
            if (hq1 == hq.m)
            {
                return new jk(activity, modeltemplate, ao, g1, ii1, mt, modeltemplate.F);
            }
            if (hq1 == hq.i)
            {
                return new ij(activity, modeltemplate, ao, ii1, mt, g1, hp);
            }
            if (hq1 == hq.j)
            {
                return new ig(activity, modeltemplate, ao, ii1, mt, g1);
            }
            if (hq1 == hq.k)
            {
                return new in(activity, modeltemplate, ao, ii1, mt);
            }
            hp = obj;
            if (hq1 == hq.l)
            {
                return new iu(activity, modeltemplate, ao, ii1, mt, g1);
            }
        }
        return hp;
    }

    public float a(byte abyte0[], int k, int i1, float f1, boolean flag)
    {
        b b1;
        int j1;
        byte byte0;
        long l1;
        boolean flag1;
        if (flag)
        {
            j1 = 3;
        } else
        {
            j1 = 1;
        }
        if (flag)
        {
            byte0 = 3;
        } else
        {
            byte0 = 1;
        }
        if (flag)
        {
            b1 = b.a;
        } else
        {
            b1 = b.e;
        }
        flag = false;
        ab.d("ImageCheck", String.format("-- isFlashNeeded: len = %d, threshold=%d, w = %d, h = %d, stride = %d, ch = %d", new Object[] {
            Integer.valueOf(abyte0.length), Integer.valueOf(70), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(j1 * k), Integer.valueOf(byte0)
        }));
        flag1 = ImageCheck.isFlashNeeded(abyte0, 70, k, i1, j1 * k, byte0);
        flag = flag1;
_L2:
        ab.d("ImageCheck", String.format("-- computeFocusConfidence: len = %d, threshold=%f, w = %d, h = %d, stride = %d, format = %s", new Object[] {
            Integer.valueOf(abyte0.length), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(j1 * k), b1.toString()
        }));
        l1 = j1;
        float f2;
        try
        {
            f2 = jumiomobile.a.a(abyte0, (long)k * l1, k, i1, b1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ab.b("ImageCheck", "computeFocusConfidence failed!", abyte0);
            f2 = -1F;
        }
        if (d != null)
        {
            abyte0 = d;
            Exception exception;
            boolean flag2;
            if (f2 < f1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            abyte0.a(flag, flag2);
        }
        return f2;
        exception;
        ab.b("ImageCheck", "isFlashNeeded failed!", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public float a(byte abyte0[], int k, int i1, boolean flag)
    {
        return a(abyte0, k, i1, 0.12F, flag);
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        nvscanside = null;
        if.a[nvdocumenttype.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 51
    //                   2 57
    //                   3 63
    //                   4 69;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        nvdocumenttype = nvscanside;
_L7:
        return mk.a(a, nvdocumenttype);
_L2:
        nvdocumenttype = "infobar_camera_view_passport";
        continue; /* Loop/switch isn't completed */
_L3:
        nvdocumenttype = "infobar_camera_view_visa_frame";
        continue; /* Loop/switch isn't completed */
_L4:
        nvdocumenttype = "infobar_camera_view_idcard";
        continue; /* Loop/switch isn't completed */
_L5:
        nvdocumenttype = "infobar_camera_view_driverlicense";
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(Activity activity, ScrollView scrollview, boolean flag)
    {
        mf.a(activity, scrollview, flag);
    }

    public void a(l l1)
    {
        if (l1 != null)
        {
            b = l1.a();
        }
    }

    public void a(mr mr)
    {
        g = mr;
    }

    public void a(boolean flag)
    {
        h = flag;
    }

    public void a(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        cb.b(getClass());
        b(abyte0);
        if (true) goto _L1; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }

    public void b()
    {
    }

    protected abstract void b(byte abyte0[]);

    public void b(byte abyte0[], int k, int i1, boolean flag)
    {
        byte byte1 = 3;
        byte byte0;
        if (flag)
        {
            byte0 = 3;
        } else
        {
            byte0 = 1;
        }
        if (!flag)
        {
            byte1 = 1;
        }
        try
        {
            ab.d("ImageCheck", String.format("-- isFlashNeeded: len = %d, threshold=%d, w = %d, h = %d, stride = %d, ch = %d", new Object[] {
                Integer.valueOf(abyte0.length), Integer.valueOf(70), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(byte0 * k), Integer.valueOf(byte1)
            }));
            flag = ImageCheck.isFlashNeeded(abyte0, 70, k, i1, byte0 * k, byte1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ab.b("ImageCheck", "isFlashNeeded failed!", abyte0);
            flag = false;
        }
        if (d != null)
        {
            d.a(flag, false);
        }
    }

    public float c(byte abyte0[], int k, int i1, boolean flag)
    {
        float f1;
        b b1;
        int j1;
        long l1;
        long l2;
        if (flag)
        {
            j1 = 3;
        } else
        {
            j1 = 1;
        }
        if (flag)
        {
            b1 = b.a;
        } else
        {
            b1 = b.e;
        }
        l1 = j1;
        l2 = k;
        try
        {
            f1 = jumiomobile.a.a(abyte0, l2 * l1, k, i1, b1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ab.a(abyte0);
            return -1F;
        }
        return f1;
    }

    public void c()
    {
        if (!f())
        {
            e();
            a(true);
        }
    }

    public void d()
    {
        if (g != null)
        {
            d.a(new ie(this));
        }
        a(false);
        System.gc();
    }

    public abstract void e();

    public boolean f()
    {
        return h;
    }

    public boolean g()
    {
        return false;
    }

    public void h()
    {
    }

    public mr i()
    {
        return g;
    }

    public String j()
    {
        return mk.a(a, "actionbar_title_scan");
    }
}
