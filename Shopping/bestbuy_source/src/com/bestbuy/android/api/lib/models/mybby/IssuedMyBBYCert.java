// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import java.io.Serializable;
import org.json.JSONObject;

public class IssuedMyBBYCert
    implements Serializable
{

    private String certNumber;
    private String certStatus;
    private String certValue;
    private String expirationDate;
    private String issueDate;
    private String legacyCertNumber;
    private String pointBalance;

    public IssuedMyBBYCert()
    {
    }

    public static IssuedMyBBYCert loadData(JSONObject jsonobject, JSONObject jsonobject1)
    {
        IssuedMyBBYCert issuedmybbycert = new IssuedMyBBYCert();
        issuedmybbycert.certNumber = jsonobject.optString("certNumber", "");
        issuedmybbycert.certStatus = jsonobject.optString("certStatus", "");
        issuedmybbycert.certValue = jsonobject.optString("certValue", "");
        issuedmybbycert.expirationDate = jsonobject.optString("expirationDate", "");
        issuedmybbycert.issueDate = jsonobject.optString("issueDate", "");
        issuedmybbycert.legacyCertNumber = jsonobject.optString("legacyCertNumber", "");
        issuedmybbycert.setPointBalance(jsonobject1.optString("pointsBalance", ""));
        return issuedmybbycert;
    }

    public String getCertNumber()
    {
        return certNumber;
    }

    public String getCertStatus()
    {
        return certStatus;
    }

    public String getCertValue()
    {
        return certValue;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public String getIssueDate()
    {
        return issueDate;
    }

    public String getLegacyCertNumber()
    {
        return legacyCertNumber;
    }

    public String getPointBalance()
    {
        return pointBalance;
    }

    public void setCertNumber(String s)
    {
        certNumber = s;
    }

    public void setCertStatus(String s)
    {
        certStatus = s;
    }

    public void setCertValue(String s)
    {
        certValue = s;
    }

    public void setExpirationDate(String s)
    {
        expirationDate = s;
    }

    public void setIssueDate(String s)
    {
        issueDate = s;
    }

    public void setLegacyCertNumber(String s)
    {
        legacyCertNumber = s;
    }

    public void setPointBalance(String s)
    {
        pointBalance = s;
    }
}
