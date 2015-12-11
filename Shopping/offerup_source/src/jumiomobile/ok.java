// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Intent;
import com.jumio.netverify.barcode.JumioBarcodeScannerInterface;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.net.ssl.SSLException;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            ai, hq, cb, oa, 
//            hu, ag, oo, cs, 
//            az, ho, ba, ob

public final class ok extends ai
{

    final oa e;

    private ok(oa oa1)
    {
        e = oa1;
        super();
    }

    ok(oa oa1, ob ob)
    {
        this(oa1);
    }

    private DocumentType a(Country country, JSONObject jsonobject)
    {
        JSONArray jsonarray;
        boolean flag;
        flag = jsonobject.optBoolean("paperVariant", false);
        jsonarray = jsonobject.optJSONArray("paperVariantParts");
        if (!flag) goto _L2; else goto _L1
_L1:
        if (jsonarray == null) goto _L4; else goto _L3
_L3:
        int i = jsonarray.length();
_L10:
        jsonobject = new DocumentType(jsonobject.getString("idType"), jsonobject.optInt("parts"), jsonobject.optString("mrzFormat", ""), jsonobject.optString("mrzSide", ""), jsonobject.optString("barcodeFormat", ""), jsonobject.optString("barcodeSide", ""), jsonobject.optString("thirdPartyOcr", ""), flag, i);
        if (!"FRA".equals(country.b()) || jsonobject.getDocumentScanMode() != hq.d) goto _L6; else goto _L5
_L5:
        jsonobject.setDocumentScanMode(hq.e);
_L8:
        return jsonobject;
_L4:
        if (jsonobject.optString("paperVariantParts", null) != null)
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L2
_L6:
        if (!"DEU".equals(country.b()) || jsonobject.getId() != NVDocumentType.IDENTITY_CARD) goto _L8; else goto _L7
_L7:
        jsonobject.setPaperVariant(true);
        jsonobject.setFallbackScan(false);
        jsonobject.setDocumentScanMode(hq.h);
        jsonobject.setDocumentScanSide(NVScanSide.BACK);
        jsonobject.setPaperScanMode(hq.d);
        jsonobject.setPaperScanSide(NVScanSide.FRONT);
        jsonobject.setPaperParts(2);
        return jsonobject;
_L2:
        i = 0;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected final transient Boolean a(Void avoid[])
    {
        int i;
        int j;
        boolean flag;
        flag = true;
        cb.a(getClass());
        oa.a(e).c = hu.b;
        e.d = UUID.randomUUID();
        if (oa.a(e).e)
        {
            return Boolean.valueOf(true);
        }
        j = -1;
        i = j;
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            -30, 20, -21, 71, 22, -98, -119, 123, -92, 6, 
            -18, 120, -38, -120, -58, 28, -99, -81, -115, -74, 
            6, 48, -112, 68, 120, 30, 26, 0, -107, 121, 
            65, 120, 81, -95, 7, 51, -81, -57, 31, -78, 
            125, -36, -89, 59, 41, -72, -94, 68, 90, -21, 
            -109, 105, -98, -124, -3, 81, -44, 114, 71, 37, 
            94, -62, 72, 58, 92, -37, 79, -40, 62, 125, 
            -80, 89, 69, -69, 2
        }, 0x19f81e78e8e687ebL)).toString());
        i = j;
        a = e.a("GET", avoid);
        i = j;
        long l = System.currentTimeMillis();
        i = j;
        b(10000);
        i = j;
        j = a.getResponseCode();
        i = j;
        long l1 = System.currentTimeMillis();
        i = j;
        avoid = oa.a(e, a);
        JSONObject jsonobject;
        a(j);
        if (oo.a())
        {
            cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d", new Object[] {
                getClass().getName(), "", Long.valueOf(l1 - l), Integer.valueOf(j)
            }));
        }
        jsonobject = new JSONObject(avoid);
        if (avoid == null) goto _L2; else goto _L1
_L1:
        if (avoid.isEmpty()) goto _L2; else goto _L3
_L3:
        Object obj;
        JSONArray jsonarray;
        avoid = new Country(jsonobject.optString("countryForIp", ""));
        obj = new ArrayList();
        jsonarray = jsonobject.getJSONArray("supportedCountries");
        i = 0;
_L14:
        if (i >= jsonarray.length()) goto _L5; else goto _L4
_L4:
        JSONObject jsonobject1;
        Country country;
        jsonobject1 = jsonarray.getJSONObject(i);
        country = new Country(jsonobject1.getString("country"));
        if (country.c().equalsIgnoreCase(az.a(jsonobject1.getString("country")))) goto _L7; else goto _L6
_L6:
        JSONArray jsonarray1 = jsonobject1.optJSONArray("idTypes");
        if (jsonarray1 == null) goto _L9; else goto _L8
_L8:
        j = 0;
_L11:
        if (j >= jsonarray1.length())
        {
            break; /* Loop/switch isn't completed */
        }
        country.a(a(country, jsonarray1.getJSONObject(j)));
        j++;
        if (true) goto _L11; else goto _L10
        avoid;
        try
        {
            a(i);
            throw avoid;
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
                oa.a(e, getClass(), true);
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
_L9:
        country.a(a(country, jsonobject1.getJSONObject("idTypes")));
_L10:
        if (country.e().size() != 0)
        {
            country.a(ho.valueOf(jsonobject1.optString("addressFormat", "EU")));
            ((ArrayList) (obj)).add(country);
        }
        break; /* Loop/switch isn't completed */
_L5:
        Collections.sort(((List) (obj)));
        oa.a(e).C = jsonobject.optString("enabledFields");
        oa.a(e).a(((List) (obj)));
        oa.a(e).k = avoid;
        avoid = jsonobject.getString("barcodeScannerKey").split(";");
        obj = oa.a(e);
        if (avoid.length >= 2)
        {
            avoid = avoid[0];
        } else
        {
            avoid = "";
        }
        obj.D = avoid;
        oa.a(e).G = jsonobject.optBoolean("verificationAllowed", true);
        oa.a(e).H = jsonobject.optBoolean("brandingEnabled", true);
        oa.a(e).e = true;
        ba.a(oa.a(e).a).a(new Intent("com.jumio.netverify.sdk.ACTION_CONTROLLER_LOADED"));
        if (true) goto _L12; else goto _L7
_L12:
        break MISSING_BLOCK_LABEL_897;
_L2:
        throw new Exception(jsonobject.getString("errorMsg"));
_L7:
        i++;
        if (true) goto _L14; else goto _L13
_L13:
    }

    protected final void a(Boolean boolean1)
    {
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.c, hu.d);
        if (oa.a(e).P != null)
        {
            oa.a(e).P.onLoadingComplete();
        }
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected final void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
