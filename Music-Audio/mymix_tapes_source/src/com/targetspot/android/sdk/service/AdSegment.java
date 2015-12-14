// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import java.util.Date;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdData, AdLink, AdLog

public class AdSegment
{

    String accountId;
    String adId;
    String additionalInfo;
    AdData audioFile;
    AdLink clickDownload;
    AdLink clickThrough;
    String companyName;
    int duration;
    AdLog impressionLog[];
    Date lastModified;
    int order;
    AdData visualFile;

    public AdSegment(String s, String s1, int i, int j, Date date, AdData addata, AdData addata1, 
            AdLink adlink, AdLink adlink1, AdLog aadlog[], String s2, String s3)
    {
        adId = s;
        accountId = s1;
        order = i;
        duration = j;
        lastModified = date;
        audioFile = addata;
        visualFile = addata1;
        clickThrough = adlink;
        clickDownload = adlink1;
        impressionLog = aadlog;
        companyName = s2;
        additionalInfo = s3;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public String getAdId()
    {
        return adId;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    public AdData getAudioFile()
    {
        return audioFile;
    }

    public AdLink getClickThrough()
    {
        return clickThrough;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getDurationMillis()
    {
        return duration * 1000;
    }

    public AdLog[] getImpressionLog()
    {
        return impressionLog;
    }

    public Date getLastModified()
    {
        return lastModified;
    }

    public int getOrder()
    {
        return order;
    }

    public AdData getVisualFile()
    {
        return visualFile;
    }
}
