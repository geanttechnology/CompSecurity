// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.barcode.enums.BarcodeFormat;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVGender;
import com.jumio.netverify.sdk.enums.NVScanSide;
import com.jumio.netverify.sdk.environment.RecognizerWrapper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

// Referenced classes of package jumiomobile:
//            id, hq, jf, ht, 
//            ii, l, ao, n, 
//            q, oo, mk, nw, 
//            nz, ny, ab, jg

public class je extends id
{

    private jg h;
    private boolean i;
    private RecognizerWrapper j;
    private long k;
    private Point l[];
    private int m;
    private int n;
    private hq o;

    public je(Context context, ModelTemplate modeltemplate, ao ao1, ii ii1, String s, hq hq1)
    {
        super(context, modeltemplate, ao1, ii1);
        h = null;
        i = false;
        int i1;
        Environment.loadPhotopayNativeAPILib();
        o = hq1;
        j = new RecognizerWrapper();
        context = j;
        if (hq1 != hq.f)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        i1 = BarcodeFormat.PDF417.getType();
_L1:
        context = context.init(s, i1);
        j.a(new jf(this));
        if (context != null)
        {
            try
            {
                if (context.length() != 0)
                {
                    throw new Exception(context);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                d.a(ht.l);
                return;
            }
        }
        break MISSING_BLOCK_LABEL_132;
        i1 = modeltemplate.K.getType();
          goto _L1
        k = System.currentTimeMillis();
        return;
    }

    static int a(je je1, int i1)
    {
        je1.n = i1;
        return i1;
    }

    static Bitmap a(je je1, byte abyte0[], Rect rect, int i1)
    {
        return je1.a(abyte0, rect, i1);
    }

    private Bitmap a(byte abyte0[], Rect rect, int i1)
    {
        int k3 = b.e;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        if (c.f())
        {
            j2 = b.c.b;
            i2 = b.c.a;
            i3 = rect.top;
            j3 = rect.left;
            j1 = rect.width();
            k1 = rect.height();
            k2 = j1;
            l2 = k1;
        } else
        {
            j2 = b.c.a;
            i2 = b.c.b;
            i3 = rect.top;
            j1 = rect.height();
            k1 = rect.width();
            j3 = rect.left;
            k2 = k1;
            l2 = j1;
        }
        if (i1 > 0)
        {
            j1 = (int)((float)k2 * ((float)i1 / 100F));
            k1 = (int)((float)l2 * ((float)i1 / 100F));
            int l3 = Math.max(0, j3 - j1);
            int i4 = Math.max(0, i3 - k1);
            j1 = k2 + j1 * 2;
            i1 = j1;
            if (j1 + l3 > j2)
            {
                i1 = j2 - l3 - 1;
            }
            k1 = l2 + k1 * 2;
            j1 = k1;
            if (k1 + i4 > i2)
            {
                j1 = i2 - i4 - 1;
            }
            java.io.File file;
            StringBuilder stringbuilder;
            int l1;
            if (c.f())
            {
                l1 = i1;
                k1 = j1;
            } else
            {
                l1 = j1;
                k1 = i1;
            }
            rect = q.a(abyte0, c.f(), b, i1, j1, l3, i4, k1, l1);
            j1 = l1;
        } else
        {
            rect = q.a(abyte0, c.f(), b, k2, l2, j3, i3, k1, j1);
        }
        if (oo.a())
        {
            file = oo.a(a, (new StringBuilder("BC_")).append(e.j).toString());
            oo.a(abyte0, file, "buffer.yuv", false);
            stringbuilder = new StringBuilder();
            oo.a(stringbuilder, "yuvWidth = ", j2);
            oo.a(stringbuilder, "yuvHeight = ", i2);
            oo.a(stringbuilder, "holeLeft = ", j3);
            oo.a(stringbuilder, "holeTop = ", i3);
            oo.a(stringbuilder, "holeWidth = ", k2);
            oo.a(stringbuilder, "holeHeight = ", l2);
            oo.a(stringbuilder, "outWidth = ", k1);
            oo.a(stringbuilder, "outHeight = ", j1);
            oo.a(stringbuilder, "imageRotation = ", k3);
            stringbuilder.append("status = YuvUtils.yuvCutRotateScale2rgb(yuv, yuvWidth, yuvHeight, holeLeft, holeTop, holeWidth, holeHeight, out, outWidth, outHeight, imageRotation)");
            stringbuilder.append("\r\n\r\n");
            stringbuilder.append("Result:\r\n");
            oo.a(stringbuilder.toString(), file, "info.txt", false);
            if (abyte0 != null && rect != null)
            {
                oo.a(abyte0, file, "frame.yuv");
                oo.a(a, rect, file, "bitmap_cropped.jpg", android.graphics.Bitmap.CompressFormat.JPEG, 80);
            }
        }
        return rect;
    }

    static RecognizerWrapper a(je je1)
    {
        return je1.j;
    }

    static boolean a(je je1, boolean flag)
    {
        je1.i = flag;
        return flag;
    }

    static Point[] a(je je1, Point apoint[])
    {
        je1.l = apoint;
        return apoint;
    }

    static int b(je je1, int i1)
    {
        je1.m = i1;
        return i1;
    }

    static Point[] b(je je1)
    {
        return je1.l;
    }

    static int c(je je1)
    {
        return je1.m;
    }

    static int d(je je1)
    {
        return je1.n;
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        if (nvdocumenttype == NVDocumentType.DRIVER_LICENSE)
        {
            return mk.a(a, "infobar_camera_view_barcode_driverlicense");
        } else
        {
            return super.a(nvdocumenttype, nvscanside);
        }
    }

    public boolean a(String s, byte abyte0[], Bitmap bitmap, int i1, int j1)
    {
        Object obj1 = e.I;
        if (o != hq.f) goto _L2; else goto _L1
_L1:
        abyte0 = new nw();
        Object obj;
        StringBuilder stringbuilder1;
        nz nz1;
        try
        {
            if (oo.a())
            {
                oo.a(s, oo.a(a, (new StringBuilder("BC_")).append(e.j).toString()), "rawdata.txt", false);
            }
            nz1 = abyte0.a(s);
            ((NetverifyDocumentData) (obj1)).setSelectedCountry(((Country)e.d().get(e.w)).b());
            ((NetverifyDocumentData) (obj1)).setSelectedDocumentType(e.v.getId());
            ((NetverifyDocumentData) (obj1)).setIdNumber(nz1.a());
            ((NetverifyDocumentData) (obj1)).setIssuingDate(nz1.b());
            ((NetverifyDocumentData) (obj1)).setExpiryDate(nz1.c());
            obj = nz1.d();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (oo.a())
            {
                bitmap = oo.a(a, (new StringBuilder("BC_")).append(e.j).toString());
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append("Raw Data:\r\n");
                stringbuilder.append(s);
                stringbuilder.append("\r\n\r\n");
                stringbuilder.append("Result:\r\n");
                s = new StringWriter();
                abyte0.printStackTrace(new PrintWriter(s));
                stringbuilder.append(s.toString());
                oo.a(stringbuilder.toString(), bitmap, String.format("info_%s.txt", new Object[] {
                    Long.valueOf(k)
                }), false);
                ab.a(abyte0);
            }
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        abyte0 = ((byte []) (obj));
        if (((String) (obj)).length() != 0)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        abyte0 = ((NetverifyDocumentData) (obj1)).getSelectedCountry();
        ((NetverifyDocumentData) (obj1)).setIssuingCountry(abyte0);
        ((NetverifyDocumentData) (obj1)).setLastName(nz1.i());
        ((NetverifyDocumentData) (obj1)).setFirstName(nz1.h());
        ((NetverifyDocumentData) (obj1)).setMiddleName(nz1.j());
        ((NetverifyDocumentData) (obj1)).setName(e.E);
        ((NetverifyDocumentData) (obj1)).setDob(nz1.k());
        ((NetverifyDocumentData) (obj1)).setGender(nz1.l());
        ((NetverifyDocumentData) (obj1)).setStreet(nz1.o());
        ((NetverifyDocumentData) (obj1)).setCity(nz1.q());
        ((NetverifyDocumentData) (obj1)).setState(nz1.r());
        ((NetverifyDocumentData) (obj1)).setPostalCode(nz1.s());
        if (!oo.a()) goto _L2; else goto _L3
_L3:
        obj = oo.a(a, (new StringBuilder("BC_")).append(e.j).toString());
        stringbuilder1 = new StringBuilder();
        stringbuilder1.append("Image dimensions:\r\n");
        oo.a(stringbuilder1, "width ", i1);
        oo.a(stringbuilder1, "height ", j1);
        stringbuilder1.append("\r\n\r\n");
        stringbuilder1.append("Raw Data:\r\n");
        stringbuilder1.append(s.replaceAll(String.format("[^\\x20-\\x7E%s]+", new Object[] {
            ""
        }), "<Binary Data>"));
        stringbuilder1.append("\r\n\r\n");
        stringbuilder1.append("Result:\r\n");
        oo.a(stringbuilder1, "getIdNumber() ", nz1.a());
        oo.a(stringbuilder1, "getIssueDate() ", nz1.b());
        oo.a(stringbuilder1, "getExpiryDate() ", nz1.c());
        oo.a(stringbuilder1, "getIssuingCountry() ", nz1.d());
        oo.a(stringbuilder1, "getLastName() ", nz1.i());
        oo.a(stringbuilder1, "getFirstName() ", nz1.h());
        oo.a(stringbuilder1, "getMiddleName() ", nz1.j());
        oo.a(stringbuilder1, "getDateOfBirth() ", nz1.k());
        if (nz1.l() != null)
        {
            oo.a(stringbuilder1, "getGender() ", nz1.l().name());
        }
        oo.a(stringbuilder1, "getAddressStreet1() ", nz1.o());
        oo.a(stringbuilder1, "getAddressCity() ", nz1.q());
        oo.a(stringbuilder1, "getAddressState() ", nz1.r());
        oo.a(stringbuilder1, "getAddressZip() ", nz1.s());
        stringbuilder1.append("\r\n\r\n");
        stringbuilder1.append("Unused:\r\n");
        oo.a(stringbuilder1, "getAddressStreet2() ", nz1.p());
        oo.a(stringbuilder1, "getEndorsementCodes() ", nz1.g());
        if (nz1.m() != null)
        {
            oo.a(stringbuilder1, "getEyeColor() ", nz1.m().name());
        }
        oo.a(stringbuilder1, "getHeight() ", nz1.n());
        oo.a(stringbuilder1, "getRestrictionCodes() ", nz1.f());
        oo.a(stringbuilder1, "getVehicleClass() ", nz1.e());
        stringbuilder1.append("\r\n\r\n");
        stringbuilder1.append("Unparsed:\r\n");
        stringbuilder1.append(nz1.t().toString().replaceAll(String.format("[^\\x20-\\x7E%s]+", new Object[] {
            ""
        }), "<Binary Data>"));
        if (nz1.a() == null)
        {
            break MISSING_BLOCK_LABEL_996;
        }
        abyte0 = nz1.a();
_L4:
        oo.a(stringbuilder1.toString(), ((java.io.File) (obj)), String.format("info_%s.txt", new Object[] {
            abyte0
        }), false);
_L2:
        System.gc();
        d.a(0.0F);
        if (o == hq.f)
        {
            abyte0 = ((NetverifyDocumentData) (obj1)).getStreet();
            obj = ((NetverifyDocumentData) (obj1)).getCity();
            obj1 = (Country)e.d().get(e.w);
            if (!e.F && ((Country) (obj1)).b().equals("USA") && o == hq.f && abyte0 != null && abyte0.length() != 0 && obj != null && ((String) (obj)).length() != 0)
            {
                d.c(true);
            }
        } else
        {
            d.c(true);
        }
        d.a(bitmap, bitmap, true);
        if (o == hq.g)
        {
            d.a(s);
        }
        d.b();
        if (e.F)
        {
            d.c();
        }
        return true;
        abyte0 = Long.toString(k);
          goto _L4
    }

    public void b()
    {
        j.a();
    }

    public void b(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (!i && j != null)
        {
            i = true;
            h = new jg(this, abyte0);
            h.start();
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
        if (h != null)
        {
            h.interrupt();
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
        i = false;
    }
}
