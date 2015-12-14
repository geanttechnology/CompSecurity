// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest;

import com.amazon.insights.core.idresolver.Id;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.insights.abtest:
//            DefaultVariation

public static class onSource.DEFAULT
{

    private String applicationKey;
    private Date appliedDate;
    private long experimentId;
    private Date expirationDate;
    private String projectName;
    private onSource source;
    private Id uniqueId;
    private Map variables;
    private long variationId;
    private String variationName;

    public DefaultVariation build()
    {
        return new DefaultVariation(this);
    }

    public onSource getAllocationSource()
    {
        return source;
    }

    public String getApplicationKey()
    {
        return applicationKey;
    }

    public long getExperimentId()
    {
        return experimentId;
    }

    public Date getExpirationDate()
    {
        return new Date(expirationDate.getTime());
    }

    public String getProjectName()
    {
        return projectName;
    }

    public Id getUniqueId()
    {
        return uniqueId;
    }

    public Map getVariables()
    {
        return variables;
    }

    public long getVariationId()
    {
        return variationId;
    }

    public String getVariationName()
    {
        return variationName;
    }

    public void setAllocationSource(onSource onsource)
    {
        source = onsource;
    }

    public source setApplicationKey(String s)
    {
        if (s != null)
        {
            applicationKey = s;
        }
        return this;
    }

    public applicationKey setExperimentId(long l)
    {
        experimentId = l;
        return this;
    }

    public experimentId setExpirationDate(Date date)
    {
        if (date != null)
        {
            expirationDate = new Date(date.getTime());
        }
        return this;
    }

    public expirationDate setProjectName(String s)
    {
        if (s != null)
        {
            projectName = s;
        }
        return this;
    }

    public projectName setUniqueId(Id id)
    {
        if (id != null)
        {
            uniqueId = id;
        }
        return this;
    }

    public uniqueId setVariables(Map map)
    {
        if (map != null)
        {
            variables = new ConcurrentHashMap(map);
        }
        return this;
    }

    public variables setVariationId(long l)
    {
        variationId = l;
        return this;
    }

    public variationId setVariationName(String s)
    {
        if (s != null)
        {
            variationName = s;
        }
        return this;
    }

    public onSource()
    {
        projectName = "";
        applicationKey = "";
        experimentId = 0L;
        variationId = 0L;
        variationName = "DEFAULT";
        uniqueId = Id.getEmptyId();
        variables = new ConcurrentHashMap();
        expirationDate = new Date(0L);
        appliedDate = new Date(0L);
        source = onSource.DEFAULT;
    }
}
