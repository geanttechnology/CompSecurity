// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.mrz.impl.smartEngines.swig.MrzDate;
import com.jumio.mrz.impl.smartEngines.swig.MrzDateField;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngine;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineSessionHelpers;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineSessionSettings;
import com.jumio.mrz.impl.smartEngines.swig.MrzField;
import com.jumio.mrz.impl.smartEngines.swig.MrzRectVector;
import com.jumio.mrz.impl.smartEngines.swig.MrzResult;
import com.jumio.mrz.impl.smartEngines.swig.StringVector;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVGender;
import com.jumio.netverify.sdk.enums.NVMRZFormat;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package jumiomobile:
//            id, jb, hq, jd, 
//            q, ii, mk, iy, 
//            cs, ab, oo, mr, 
//            jc, iz, mt, g, 
//            ao

public class ix extends id
{

    private MrzEngine h;
    private jd i;
    private MrzEngineSessionHelpers j;
    private MrzEngineSessionSettings k;
    private jc l;
    private mt m;
    private ExecutorService n;
    private hq o;
    private boolean p;
    private int q;
    private int r;
    private g s;

    public ix(Context context, ModelTemplate modeltemplate, ao ao, g g1, ii ii1, mt mt, hq hq1)
    {
        boolean flag1 = true;
        super(context, modeltemplate, ao, ii1);
        p = false;
        q = 0;
        r = 0;
        s = g1;
        m = mt;
        o = hq1;
        Environment.loadMRZJniInterfaceLib();
        n = Executors.newSingleThreadExecutor();
        n.submit(new jb(this, null));
        k = new MrzEngineSessionSettings();
        k.set_should_postprocess(true);
        context = k;
        boolean flag;
        if (hq1 == hq.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.set_mrp_support_enabled(flag);
        context = k;
        if (hq1 == hq.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.set_td1_support_enabled(flag);
        context = k;
        if (hq1 == hq.d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.set_td2_support_enabled(flag);
        context = k;
        if (hq1 == hq.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.set_cnis_support_enabled(flag);
        context = k;
        if (hq1 == hq.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.set_mrva_support_enabled(flag);
        context = k;
        if (hq1 == hq.b)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        context.set_mrvb_support_enabled(flag);
        k.set_m3z_support_enabled(false);
        i = new jd();
        j = new MrzEngineSessionHelpers();
    }

    static int a(ix ix1, int i1)
    {
        ix1.q = i1;
        return i1;
    }

    private Bitmap a(byte abyte0[], int i1, int j1)
    {
        if (!e.F)
        {
            abyte0 = null;
        } else
        {
            Bitmap bitmap = jumiomobile.q.a(abyte0, i1, j1);
            abyte0 = bitmap;
            if (bitmap != null)
            {
                d.a(bitmap, bitmap, false);
                return bitmap;
            }
        }
        return abyte0;
    }

    static MrzEngine a(ix ix1, MrzEngine mrzengine)
    {
        ix1.h = mrzengine;
        return mrzengine;
    }

    private String a(MrzField mrzfield)
    {
        return mrzfield.getAsString();
    }

    private Date a(MrzDate mrzdate, boolean flag)
    {
        Object obj;
        Object obj1 = null;
        Calendar calendar = Calendar.getInstance();
        obj = obj1;
        if (mrzdate.getYear() == -1)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = obj1;
        if (mrzdate.getMonth() <= 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = obj1;
        if (mrzdate.getMonth() > 12)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = obj1;
        if (mrzdate.getDay() <= 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = obj1;
        if (mrzdate.getDay() > 31)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        calendar.set(mrzdate.getYear(), mrzdate.getMonth() - 1, mrzdate.getDay(), 0, 0, 0);
        mrzdate = calendar.getTime();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        obj = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        flag = mrzdate.after(((SimpleDateFormat) (obj)).parse(((SimpleDateFormat) (obj)).format(new Date())));
        if (flag)
        {
            mrzdate = null;
        }
        obj = mrzdate;
        return ((Date) (obj));
        ParseException parseexception;
        parseexception;
        return mrzdate;
    }

    static jd a(ix ix1)
    {
        return ix1.i;
    }

    private void a(MrzResult mrzresult, NetverifyDocumentData netverifydocumentdata)
    {
label0:
        {
            mrzresult = a(mrzresult.getOptData2());
            if (mrzresult != null && mrzresult.length() != 0)
            {
                if (o != hq.e)
                {
                    break label0;
                }
                netverifydocumentdata.setPersonalNumber(mrzresult.replaceAll("\\s+", ""));
            }
            return;
        }
        netverifydocumentdata.setOptionalData2(mrzresult);
    }

    static boolean a(ix ix1, boolean flag)
    {
        ix1.p = flag;
        return flag;
    }

    static int b(ix ix1, int i1)
    {
        ix1.r = i1;
        return i1;
    }

    static MrzEngineSessionHelpers b(ix ix1)
    {
        return ix1.j;
    }

    static int c(ix ix1)
    {
        return ix1.q;
    }

    static int d(ix ix1)
    {
        return ix1.r;
    }

    static g e(ix ix1)
    {
        return ix1.s;
    }

    static MrzEngine f(ix ix1)
    {
        return ix1.h;
    }

    static ExecutorService g(ix ix1)
    {
        return ix1.n;
    }

    static MrzEngineSessionSettings h(ix ix1)
    {
        return ix1.k;
    }

    static mt i(ix ix1)
    {
        return ix1.m;
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        String s1 = null;
        if (!k.get_mrp_support_enabled() || nvdocumenttype != NVDocumentType.PASSPORT) goto _L2; else goto _L1
_L1:
        nvscanside = a;
        nvdocumenttype = "infobar_camera_view_passport_frame";
_L6:
        s1 = mk.a(nvscanside, nvdocumenttype);
_L4:
        return s1;
_L2:
        if (o == hq.b)
        {
            nvscanside = a;
            nvdocumenttype = "infobar_camera_view_visa_frame";
            continue; /* Loop/switch isn't completed */
        }
        if (nvdocumenttype == NVDocumentType.DRIVER_LICENSE)
        {
            Context context = a;
            if (nvscanside == NVScanSide.BACK)
            {
                nvdocumenttype = "infobar_camera_view_back_driverlicense_templatematcher";
            } else
            {
                nvdocumenttype = "infobar_camera_view_front_driverlicense_templatematcher";
            }
            return mk.a(context, nvdocumenttype);
        }
        if (nvdocumenttype != NVDocumentType.IDENTITY_CARD) goto _L4; else goto _L3
_L3:
        Context context1 = a;
        if (nvscanside == NVScanSide.BACK)
        {
            nvdocumenttype = "infobar_camera_view_back_idcard_templatematcher";
            nvscanside = context1;
        } else
        {
            nvdocumenttype = "infobar_camera_view_front_idcard_templatematcher";
            nvscanside = context1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(MrzResult mrzresult, byte abyte0[], int i1, int j1, float f1)
    {
        Bitmap bitmap;
        StringVector stringvector;
        NetverifyDocumentData netverifydocumentdata;
        d.a(f1);
        d.c(true);
        bitmap = a(abyte0, i1, j1);
        stringvector = mrzresult.getMrzLines();
        netverifydocumentdata = e.I;
        netverifydocumentdata.setSelectedCountry(((Country)e.d().get(e.w)).b());
        netverifydocumentdata.setSelectedDocumentType(e.v.getId());
        netverifydocumentdata.setIdNumber(a(mrzresult.getDocNum()));
        iy.a[o.ordinal()];
        JVM INSTR tableswitch 1 5: default 148
    //                   1 533
    //                   2 543
    //                   3 591
    //                   4 627
    //                   5 627;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        Object obj;
        netverifydocumentdata.setExpiryDate(a(mrzresult.getExpidate().getAsMrzDate(), false));
        obj = a(mrzresult.getCountry());
        abyte0 = ((byte []) (obj));
        if (obj != null)
        {
            abyte0 = ((String) (obj)).trim();
        }
        obj = abyte0;
        if ("D".equals(abyte0))
        {
            obj = "DEU";
        }
        netverifydocumentdata.setIssuingCountry(((String) (obj)));
        netverifydocumentdata.setLastName(a(mrzresult.getSecondName()));
        abyte0 = a(mrzresult.getFirstName());
        if (o == hq.e && abyte0 != null)
        {
            abyte0 = abyte0.split("\\s{2}", 2);
            if (abyte0.length > 0)
            {
                netverifydocumentdata.setFirstName(abyte0[0]);
            }
            if (abyte0.length >= 2)
            {
                netverifydocumentdata.setMiddleName(abyte0[1].replaceAll("  ", " "));
            }
        } else
        {
            netverifydocumentdata.setFirstName(abyte0);
        }
        netverifydocumentdata.setName(e.E);
        netverifydocumentdata.setDob(a(mrzresult.getBirthdate().getAsMrzDate(), true));
        if (NVGender.M.name().equals(a(mrzresult.getSex())))
        {
            netverifydocumentdata.setGender(NVGender.M);
        } else
        if (NVGender.F.name().equals(a(mrzresult.getSex())))
        {
            netverifydocumentdata.setGender(NVGender.F);
        }
        obj = a(mrzresult.getNationality());
        abyte0 = ((byte []) (obj));
        if (obj != null)
        {
            abyte0 = ((String) (obj)).trim();
        }
        obj = abyte0;
        if ("D".equals(abyte0))
        {
            obj = "DEU";
        }
        netverifydocumentdata.setOriginatingCountry(((String) (obj)));
        obj = null;
        if (cs.a())
        {
            ab.a("MRZ", (new StringBuilder("detected scan mode: ")).append(o.toString()).toString());
        }
        iy.a[o.ordinal()];
        JVM INSTR tableswitch 1 5: default 484
    //                   1 677
    //                   2 484
    //                   3 749
    //                   4 756
    //                   5 763;
           goto _L6 _L7 _L6 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_763;
_L6:
        abyte0 = NVMRZFormat.MRP;
_L11:
        netverifydocumentdata.setMrzData(mrzresult, abyte0, stringvector);
        System.gc();
        d.b();
        if (e.F)
        {
            d.a(bitmap, 0.0F, null);
        }
        return;
_L2:
        a(mrzresult, netverifydocumentdata);
          goto _L1
_L3:
        obj = a(mrzresult.getOptData2());
        abyte0 = ((byte []) (obj));
        if (obj != null)
        {
            abyte0 = ((byte []) (obj));
            if (((String) (obj)).length() != 0)
            {
                abyte0 = ((String) (obj)).replaceAll("\\s+", "");
            }
        }
        netverifydocumentdata.setPersonalNumber(abyte0);
          goto _L1
_L4:
        abyte0 = a(mrzresult.getOptData1());
        if (abyte0 != null && abyte0.length() != 0)
        {
            netverifydocumentdata.setOptionalData1(abyte0);
        }
        a(mrzresult, netverifydocumentdata);
          goto _L1
_L5:
        a(mrzresult, netverifydocumentdata);
          goto _L1
_L7:
        if (stringvector.size() == 2L && stringvector.get(0).length() == 36)
        {
            abyte0 = NVMRZFormat.MRV_B;
        } else
        {
            abyte0 = ((byte []) (obj));
            if (stringvector.size() == 2L)
            {
                abyte0 = ((byte []) (obj));
                if (stringvector.get(0).length() == 44)
                {
                    abyte0 = NVMRZFormat.MRV_A;
                }
            }
        }
          goto _L11
_L8:
        abyte0 = NVMRZFormat.TD1;
          goto _L11
_L9:
        abyte0 = NVMRZFormat.TD2;
          goto _L11
        abyte0 = NVMRZFormat.CNIS;
          goto _L11
    }

    public void a(MrzRectVector amrzrectvector[])
    {
        if (oo.a() && g != null)
        {
            g.setMrzDigits(amrzrectvector);
            g.postInvalidate();
        }
    }

    public void b(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (!p && h != null)
        {
            p = true;
            l = new jc(this, abyte0);
            n.submit(l);
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
        Exception exception;
        if (l != null)
        {
            try
            {
                l.interrupt();
                l.join();
            }
            catch (Exception exception1) { }
        }
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        h.TerminateSession();
        return;
        exception;
        ab.d(exception.getMessage());
        n.shutdownNow();
        return;
    }

    public void e()
    {
        n.submit(new iz(this, null));
    }
}
