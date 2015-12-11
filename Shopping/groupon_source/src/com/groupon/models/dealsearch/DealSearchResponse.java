// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealsearch;

import com.groupon.models.division.json.Division;
import java.util.ArrayList;
import java.util.List;

public class DealSearchResponse
{

    public String announcementTitle;
    public boolean dealImpression;
    public List displayOptions;
    public Division division;
    public String id;
    public boolean isSoldOut;
    public String largeImageUrl;
    public List options;
    public String status;
    public String title;
    public String type;
    public String uuid;

    public DealSearchResponse()
    {
        status = "closed";
        announcementTitle = "";
        displayOptions = new ArrayList();
        options = new ArrayList();
    }

    public String toString()
    {
        return (new StringBuilder()).append("DealSearchResponse{, type='").append(type).append('\'').append(", status='").append(status).append('\'').append(", uuid='").append(uuid).append('\'').append(", id='").append(id).append('\'').append(", title='").append(title).append('\'').append(", division=").append(division).append(", announcementTitle='").append(announcementTitle).append('\'').append(", largeImageUrl='").append(largeImageUrl).append('\'').append(", isSoldOut=").append(isSoldOut).append(", displayOptions=").append(displayOptions).append(", options=").append(options).append(", dealImpression=").append(dealImpression).append('}').toString();
    }
}
