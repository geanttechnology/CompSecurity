// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import com.jumio.ocr.impl.smartEngines.swig.DetectionEngine;
import com.jumio.ocr.impl.smartEngines.swig.DetectionInternalSettingsFactory;
import com.jumio.ocr.impl.smartEngines.swig.DetectionSettings;

// Referenced classes of package jumiomobile:
//            id, hp, ht, ii, 
//            cs, ao, n, q, 
//            oo, ik, il, mk, 
//            bg, op, im, mt, 
//            g

public class ij extends id
{

    public static int h = 800;
    public static int i = 600;
    protected mt j;
    protected g k;
    private im l;
    private DetectionEngine m;
    private boolean n;
    private int o;

    public ij(Context context, ModelTemplate modeltemplate, ao ao1, ii ii1, mt mt, g g, hp hp1)
    {
        super(context, modeltemplate, ao1, ii1);
        l = null;
        n = false;
        o = 0;
        j = mt;
        k = g;
        Environment.loadJniInterfaceLib();
        modeltemplate = new DetectionSettings();
        modeltemplate.setRoiLeftMargin(hp1.c());
        modeltemplate.setRoiRightMargin(hp1.d());
        modeltemplate.setRoiTopMargin(hp1.a());
        modeltemplate.setRoiBottomMargin(hp1.b());
        modeltemplate.setRoiVerticalDeviation(0.040000000000000001D);
        modeltemplate.setRoiHorizontalDeviation(0.029999999999999999D);
        context = Environment.getCardDetectionSettingsPath(context);
        if (context == null)
        {
            try
            {
                throw new Exception("Loading detection settings failed!");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ii1.a(ht.l);
            }
            return;
        }
        m = new DetectionEngine(modeltemplate, DetectionInternalSettingsFactory.createFromFileSystem(context));
        return;
    }

    private int a(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        int j1 = 0;
        if (flag)
        {
            j1 = 1;
        }
        int i1 = j1;
        if (flag1)
        {
            i1 = j1 + 1;
        }
        j1 = i1;
        if (flag2)
        {
            j1 = i1 + 1;
        }
        i1 = j1;
        if (flag3)
        {
            i1 = j1 + 1;
        }
        return i1;
    }

    static DetectionEngine a(ij ij1)
    {
        return ij1.m;
    }

    static boolean a(ij ij1, boolean flag)
    {
        ij1.n = flag;
        return flag;
    }

    static byte[] a(ij ij1, byte abyte0[], int i1, int j1)
    {
        return ij1.a(abyte0, i1, j1);
    }

    private byte[] a(byte abyte0[], int i1, int j1)
    {
        StringBuilder stringbuilder = null;
        if (cs.a())
        {
            stringbuilder = new StringBuilder();
        }
        byte abyte1[] = q.a(abyte0, c.f(), b, 0.75F, new n(i1, j1), stringbuilder);
        if (oo.a())
        {
            java.io.File file = oo.a(a, (new StringBuilder("LF_")).append(e.j).toString());
            oo.a(abyte0, file, String.format("buffer_%d.yuv", new Object[] {
                Long.valueOf(f)
            }), false);
            oo.a(stringbuilder.toString(), file, String.format("info_%d.txt", new Object[] {
                Long.valueOf(f)
            }), false);
            if (abyte1 != null)
            {
                oo.a(abyte1, file, String.format("buffer_%d.rgb", new Object[] {
                    Long.valueOf(f)
                }), false);
            }
        }
        return abyte1;
    }

    private void b(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        d.a(new ik(this, flag, flag1, flag2, flag3, flag4, flag5));
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        Object obj = null;
        il.a[nvdocumenttype.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 47
    //                   2 66
    //                   3 87;
           goto _L1 _L2 _L3 _L4
_L1:
        nvdocumenttype = obj;
_L6:
        return mk.a(a, nvdocumenttype);
_L2:
        if (nvscanside == NVScanSide.BACK)
        {
            nvdocumenttype = "infobar_camera_view_back_passport";
        } else
        {
            nvdocumenttype = "infobar_camera_view_front_passport";
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (nvscanside == NVScanSide.BACK)
        {
            nvdocumenttype = "infobar_camera_view_back_idcard_templatematcher";
        } else
        {
            nvdocumenttype = "infobar_camera_view_front_idcard_templatematcher";
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (nvscanside == NVScanSide.BACK)
        {
            nvdocumenttype = "infobar_camera_view_back_driverlicense_templatematcher";
        } else
        {
            nvdocumenttype = "infobar_camera_view_front_driverlicense_templatematcher";
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(byte abyte0[], int i1, int j1, byte abyte1[], int k1, int l1, float f)
    {
        d.a(f);
        d.c(false);
        abyte0 = q.a(abyte0, i1, j1);
        abyte1 = q.a(abyte1, k1, l1);
        d.a(abyte0, abyte1, false);
        if (oo.a())
        {
            java.io.File file = oo.a(a, (new StringBuilder("LF_")).append(e.j).toString());
            oo.a(a, abyte0, file, String.format("processed_%d.jpg", new Object[] {
                Long.valueOf(this.f)
            }), android.graphics.Bitmap.CompressFormat.JPEG, 80);
            oo.a(a, abyte1, file, String.format("exact_%d.jpg", new Object[] {
                Long.valueOf(this.f)
            }), android.graphics.Bitmap.CompressFormat.JPEG, 80);
        }
        if (abyte0 != null)
        {
            abyte0.recycle();
        }
        d.a(abyte1, bg.a(a, 15), null);
        System.gc();
    }

    public boolean a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        int i1;
        boolean flag6;
        flag6 = false;
        b(flag, flag1, flag2, flag3, flag4, flag5);
        i1 = a(flag, flag1, flag2, flag3);
        if (i1 < 3 || flag5) goto _L2; else goto _L1
_L1:
        o = o + 1;
        if (oo.a())
        {
            op.a(i1);
        }
_L4:
        flag = flag6;
        if (o >= 5)
        {
            flag = true;
        }
        return flag;
_L2:
        o = 0;
        if (oo.a())
        {
            op.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (!n && m != null)
        {
            n = true;
            l = new im(this, abyte0);
            l.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void d()
    {
        super.d();
        this;
        JVM INSTR monitorenter ;
        if (l != null)
        {
            l.interrupt();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        n = false;
    }

}
