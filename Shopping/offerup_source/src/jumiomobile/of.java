// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Intent;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.NetverifyMrzData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVMRZFormat;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.net.ssl.SSLException;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            ai, oa, cb, hu, 
//            hq, ho, bi, ab, 
//            ag, oo, cs, ba

class of extends ai
{

    final oa e;
    private ArrayList f;
    private int g;

    public of(oa oa1, ArrayList arraylist, int i)
    {
        e = oa1;
        super();
        f = arraylist;
        g = i;
    }

    private void a(JSONObject jsonobject, String s, Boolean boolean1)
    {
        if (boolean1 != null)
        {
            jsonobject.put(s, boolean1);
        }
    }

    private void a(JSONObject jsonobject, String s, String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            return;
        } else
        {
            jsonobject.put(s, s1);
            return;
        }
    }

    protected transient Boolean a(Void avoid[])
    {
        String s;
        Country country;
        NetverifyDocumentData netverifydocumentdata;
        boolean flag;
        flag = true;
        s = null;
        country = oa.a(e).e();
        netverifydocumentdata = oa.a(e).I;
        cb.a(getClass());
        oa.a(e).c = hu.n;
        JSONObject jsonobject;
        Object obj;
        obj = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        jsonobject = new JSONObject();
        if (f.contains(hq.a))
        {
            a(jsonobject, "mrzFormat", "MRP");
        }
        if (!f.contains(hq.b))
        {
            break MISSING_BLOCK_LABEL_131;
        }
        int i;
        long l;
        if (netverifydocumentdata.getMrzData().getFormat() == NVMRZFormat.MRV_A)
        {
            avoid = "MRV_A";
        } else
        {
            avoid = "MRV_B";
        }
        a(jsonobject, "mrzFormat", ((String) (avoid)));
        if (f.contains(hq.c))
        {
            a(jsonobject, "mrzFormat", "TD1");
        }
        if (f.contains(hq.d))
        {
            a(jsonobject, "mrzFormat", "TD2");
        }
        if (f.contains(hq.e))
        {
            a(jsonobject, "mrzFormat", "CNIS");
        }
        if (f.contains(hq.h))
        {
            a(jsonobject, "thirdPartyOcr", "CSSN");
        }
        if (f.contains(hq.f))
        {
            a(jsonobject, "barcodeFormat", "PDF417");
        }
        if (!oa.a(e).F) goto _L2; else goto _L1
_L1:
        if (f.contains(hq.a) || f.contains(hq.c) || f.contains(hq.d) || f.contains(hq.e))
        {
            avoid = netverifydocumentdata.getMrzData();
            a(jsonobject, "mrzLine1", avoid.getMrzLine1());
            a(jsonobject, "mrzLine2", avoid.getMrzLine2());
            a(jsonobject, "mrzLine3", avoid.getMrzLine3());
        }
        a(jsonobject, "firstName", netverifydocumentdata.getFirstName());
        a(jsonobject, "middleName", netverifydocumentdata.getMiddleName());
        a(jsonobject, "lastName", netverifydocumentdata.getLastName());
        a(jsonobject, "personalNumber", netverifydocumentdata.getPersonalNumber());
        a(jsonobject, "number", netverifydocumentdata.getIdNumber());
        if (netverifydocumentdata.getIssuingDate() != null) goto _L4; else goto _L3
_L3:
        avoid = null;
_L17:
        a(jsonobject, "issuingDate", ((String) (avoid)));
        if (netverifydocumentdata.getDob() != null) goto _L6; else goto _L5
_L5:
        avoid = null;
_L11:
        a(jsonobject, "dob", ((String) (avoid)));
        if (netverifydocumentdata.getExpiryDate() != null) goto _L8; else goto _L7
_L7:
        avoid = null;
_L12:
        a(jsonobject, "expiry", ((String) (avoid)));
        a(jsonobject, "issuingCountry", netverifydocumentdata.getIssuingCountry());
        a(jsonobject, "country", netverifydocumentdata.getOriginatingCountry());
        a(jsonobject, "optionalData1", netverifydocumentdata.getOptionalData1());
        a(jsonobject, "optionalData2", netverifydocumentdata.getOptionalData2());
        if (netverifydocumentdata.getLivenessDetected() != null) goto _L10; else goto _L9
_L9:
        avoid = s;
_L13:
        a(jsonobject, "livenessDetected", ((Boolean) (avoid)));
        obj = new JSONObject();
        if (country.d() != ho.b)
        {
            break MISSING_BLOCK_LABEL_1004;
        }
        a(((JSONObject) (obj)), "city", netverifydocumentdata.getCity());
        a(((JSONObject) (obj)), "state", netverifydocumentdata.getState());
        a(((JSONObject) (obj)), "streetName", bi.a(netverifydocumentdata.getStreet(), 100));
        s = netverifydocumentdata.getPostalCode();
        avoid = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_623;
        }
        avoid = s;
        if (s.length() == 15)
        {
            avoid = s.substring(0, 14);
        }
        a(((JSONObject) (obj)), "zip", ((String) (avoid)));
        if (((JSONObject) (obj)).length() != 0)
        {
            jsonobject.put("usAddress", obj);
        }
_L2:
        ab.c("RemoteManager", jsonobject.toString());
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            48, 93, 92, 2, -8, 57
        }, 0x9551fd3500f40694L)).append(oa.a(e).j).append(ag.a(new byte[] {
            -74, 83, 66, 26, -72
        }, 0x95933cac0e2349c2L)).toString());
        a = e.a("POST", avoid);
        a.getOutputStream().write(jsonobject.toString().getBytes("UTF-8"));
        l = System.currentTimeMillis();
        b(10000);
        i = a.getResponseCode();
        long l1 = System.currentTimeMillis();
        avoid = oa.e(e, a);
        if (oo.a())
        {
            cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
                getClass().getName(), oa.a(e).j, Long.valueOf(l1 - l), Integer.valueOf(i), avoid
            }));
        }
        try
        {
            a(i);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            oa.a(e, avoid, getClass());
            flag = false;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
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
        }
        return Boolean.valueOf(flag);
_L4:
        avoid = ((SimpleDateFormat) (obj)).format(netverifydocumentdata.getIssuingDate());
        continue; /* Loop/switch isn't completed */
_L6:
        avoid = ((SimpleDateFormat) (obj)).format(netverifydocumentdata.getDob());
          goto _L11
_L8:
        avoid = ((SimpleDateFormat) (obj)).format(netverifydocumentdata.getExpiryDate());
          goto _L12
_L10:
        avoid = netverifydocumentdata.getLivenessDetected();
          goto _L13
        a(((JSONObject) (obj)), "city", netverifydocumentdata.getCity());
        a(((JSONObject) (obj)), "province", netverifydocumentdata.getState());
        a(((JSONObject) (obj)), "streetName", bi.a(netverifydocumentdata.getStreet(), 100));
        a(((JSONObject) (obj)), "postalCode", netverifydocumentdata.getPostalCode());
        if (((JSONObject) (obj)).length() != 0)
        {
            jsonobject.put("euAddress", obj);
        }
          goto _L2
        avoid;
        i = 0;
_L15:
        a(i);
        throw avoid;
        avoid;
        if (true) goto _L15; else goto _L14
_L14:
        if (true) goto _L17; else goto _L16
_L16:
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1 != null && boolean1.booleanValue())
        {
            Intent intent = new Intent("com.jumio.netverify.sdk.ACTION_SEND_DATA_FINISHED");
            intent.putExtra("com.jumio.netverify.sdk.DATA_DOCUMENT_ID", g);
            ba.a(oa.a(e).a).a(intent);
        }
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.o, hu.p);
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
