// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import gs;
import gv;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class Certificate
{

    private static String TAG = com/bestbuy/android/api/lib/models/mybby/Certificate.getSimpleName();
    private String accountId;
    private String amount;
    private String barcode;
    private String certId;
    private Date expiredDate;
    private Date issuedDate;
    private String status;

    public Certificate()
    {
    }

    public static String getFormatedDate(String s)
    {
        String s1 = s;
        String as[];
        int i;
        try
        {
            s = s.trim().split(":")[0];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.e(TAG, (new StringBuilder()).append("Error in getFormatedDate: ").append(s.getLocalizedMessage()).toString());
            return s1;
        }
        s1 = s;
        as = s.split("-");
        s1 = s;
        i = Integer.parseInt(as[0]);
        s1 = s;
        s = (new StringBuilder()).append(as[1]).append("/").append(as[2]).append("/").append(i % 100).toString();
        return s;
    }

    public static Certificate loadData(JSONObject jsonobject)
    {
        Certificate certificate = new Certificate();
        certificate.certId = jsonobject.optString("certificateNumber");
        certificate.accountId = jsonobject.optString("accountId");
        String s = jsonobject.optString("issuedDate");
        if (s != null && s.compareTo("") != 0)
        {
            certificate.issuedDate = gv.b.parse(s);
        }
        s = jsonobject.optString("expiredDate");
        if (s != null && s.compareTo("") != 0)
        {
            certificate.expiredDate = gv.b.parse(s);
        }
        certificate.amount = jsonobject.optString("amount");
        certificate.status = jsonobject.optString("status");
        certificate.barcode = jsonobject.optString("barcodeNumber");
        return certificate;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public String getAmount()
    {
        return amount;
    }

    public String getBarcode()
    {
        return barcode;
    }

    public String getCertId()
    {
        return certId;
    }

    public Date getExpiredDate()
    {
        return expiredDate;
    }

    public Date getIssuedDate()
    {
        return issuedDate;
    }

    public String getStatus()
    {
        return status;
    }

}
