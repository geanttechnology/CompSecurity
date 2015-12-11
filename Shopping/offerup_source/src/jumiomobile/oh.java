// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Intent;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVGender;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            ai, ab, cb, oa, 
//            hu, ag, oo, cs, 
//            ba

class oh extends ai
{

    final oa e;
    private byte f[];
    private Country g;
    private NVDocumentType h;
    private int i;

    public oh(oa oa1, Country country, NVDocumentType nvdocumenttype, byte abyte0[], int j)
    {
        e = oa1;
        super();
        f = null;
        g = null;
        h = null;
        f = abyte0;
        g = country;
        h = nvdocumenttype;
        i = j;
    }

    private String a(String s)
    {
        if (s != null && s.length() != 0 && !JSONObject.NULL.toString().equals(s))
        {
            return s;
        } else
        {
            return null;
        }
    }

    private Date a(String s, SimpleDateFormat simpledateformat, boolean flag)
    {
        Object obj;
        obj = null;
        s = a(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (!Pattern.compile("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$").matcher(s).matches())
        {
            return null;
        }
        s = simpledateformat.parse(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        simpledateformat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        flag = s.after(simpledateformat.parse(simpledateformat.format(new Date())));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        return s;
        simpledateformat;
        s = obj;
_L2:
        ab.a(simpledateformat);
        return s;
        simpledateformat;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag;
        flag = true;
        cb.a(getClass());
        oa.a(e).c = hu.k;
        Object obj;
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            9, 80, -55, -97, 29, 60, 56, 65, -48, 107, 
            2, -101
        }, 0x3d0dbb555fe3c3faL)).toString());
        a = e.a("POST", avoid);
        avoid = new JSONObject();
        avoid.put("country", g.b());
        avoid.put("idType", h.toString());
        a.setRequestProperty("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(d).toString());
        obj = new DataOutputStream(a.getOutputStream());
        int j;
        long l;
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder("--")).append(d).append("\r\n").toString());
        ((DataOutputStream) (obj)).writeBytes("Content-Disposition: form-data; name=\"data\"\r\n");
        ((DataOutputStream) (obj)).writeBytes("Content-Type: application/json; charset=UTF-8\r\n");
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder("Content-Length: ")).append(avoid.toString().length()).append("\r\n").toString());
        ((DataOutputStream) (obj)).writeBytes("\r\n");
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder()).append(avoid.toString()).append("\r\n").toString());
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder("--")).append(d).append("\r\n").toString());
        ((DataOutputStream) (obj)).writeBytes("Content-Disposition: form-data; name=\"fileUpload\"; filename=\"image.jpeg\"\r\n");
        ((DataOutputStream) (obj)).writeBytes("Content-Type: image/jpeg\r\n");
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder("Content-Length: ")).append(f.length).append("\r\n").toString());
        ((DataOutputStream) (obj)).writeBytes("\r\n");
        ((DataOutputStream) (obj)).write(f);
        ((DataOutputStream) (obj)).writeBytes("\r\n");
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder("--")).append(d).append("--\r\n").toString());
        ((DataOutputStream) (obj)).flush();
        l = System.currentTimeMillis();
        b(0x15f90);
        j = a.getResponseCode();
        long l1 = System.currentTimeMillis();
        avoid = oa.d(e, a);
        if (oo.a())
        {
            cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
                getClass().getName(), oa.a(e).j, Long.valueOf(l1 - l), Integer.valueOf(j), avoid
            }));
        }
        Object obj1;
        ((DataOutputStream) (obj)).close();
        a(j);
        avoid = new JSONObject(avoid);
        obj = oa.a(e).I;
        obj1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ((NetverifyDocumentData) (obj)).setSelectedCountry(g.b());
        ((NetverifyDocumentData) (obj)).setSelectedDocumentType(h);
        ((NetverifyDocumentData) (obj)).setIdNumber(a(avoid.optString("idNumber")));
        ((NetverifyDocumentData) (obj)).setPersonalNumber(a(avoid.optString("personalNumber")));
        ((NetverifyDocumentData) (obj)).setIssuingDate(a(avoid.optString("issueDate"), ((SimpleDateFormat) (obj1)), true));
        ((NetverifyDocumentData) (obj)).setExpiryDate(a(avoid.optString("expiryDate"), ((SimpleDateFormat) (obj1)), false));
        ((NetverifyDocumentData) (obj)).setIssuingCountry(a(avoid.optString("country")));
        ((NetverifyDocumentData) (obj)).setLastName(a(avoid.optString("lastName")));
        ((NetverifyDocumentData) (obj)).setFirstName(a(avoid.optString("firstName")));
        ((NetverifyDocumentData) (obj)).setMiddleName(a(avoid.optString("middleName")));
        ((NetverifyDocumentData) (obj)).setName(oa.a(e).E);
        ((NetverifyDocumentData) (obj)).setDob(a(avoid.optString("dateOfBirth"), ((SimpleDateFormat) (obj1)), true));
        obj1 = a(avoid.optString("gender"));
        if (!NVGender.M.name().equals(obj1)) goto _L2; else goto _L1
_L1:
        ((NetverifyDocumentData) (obj)).setGender(NVGender.M);
_L5:
        ((NetverifyDocumentData) (obj)).setStreet(a(avoid.optString("address")));
        ((NetverifyDocumentData) (obj)).setCity(a(avoid.optString("city")));
        ((NetverifyDocumentData) (obj)).setState(a(avoid.optString("state")));
        ((NetverifyDocumentData) (obj)).setPostalCode(a(avoid.optString("zip")));
_L3:
        return Boolean.valueOf(flag);
        avoid;
        obj = null;
        j = 0;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_882;
        }
        ((DataOutputStream) (obj)).close();
        a(j);
        throw avoid;
        avoid;
        oa.a(e, avoid, getClass());
        flag = false;
          goto _L3
_L2:
        if (!NVGender.F.name().equals(obj1)) goto _L5; else goto _L4
_L4:
        ((NetverifyDocumentData) (obj)).setGender(NVGender.F);
          goto _L5
        avoid;
        if (b())
        {
            oa.a(e, getClass(), false);
            flag = false;
        } else
        {
            if (!isCancelled())
            {
                oa.a(e, avoid, getClass());
            }
            flag = false;
        }
          goto _L3
        avoid;
        j = 0;
          goto _L6
        avoid;
          goto _L6
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1 != null && boolean1.booleanValue())
        {
            Intent intent = new Intent("com.jumio.netverify.sdk.ACTION_EXTRACTION_FINISHED");
            intent.putExtra("com.jumio.netverify.sdk.DATA_DOCUMENT_ID", i);
            intent.putExtra("com.jumio.netverify.sdk.DATA_DOCUMENT_DATA", oa.a(e).I);
            ba.a(oa.a(e).a).a(intent);
        }
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.l, hu.m);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
