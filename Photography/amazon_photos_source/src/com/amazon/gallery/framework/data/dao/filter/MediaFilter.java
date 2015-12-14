// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;


// Referenced classes of package com.amazon.gallery.framework.data.dao.filter:
//            MediaTypeFilter, DataSourceFilter, DaoFilter

public class MediaFilter
{

    private DaoFilter dataSourceFilter;
    private DaoFilter mediaTypeFilter;

    public MediaFilter()
    {
        mediaTypeFilter = new MediaTypeFilter();
        dataSourceFilter = new DataSourceFilter();
    }

    public String getWhereClause()
    {
        this;
        JVM INSTR monitorenter ;
        String s = "";
        if (!mediaTypeFilter.isSet()) goto _L2; else goto _L1
_L1:
        String s1 = mediaTypeFilter.getWhereClause();
        s = s1;
        if (dataSourceFilter.isSet())
        {
            s = (new StringBuilder()).append(s1).append(" AND ").append(dataSourceFilter.getWhereClause()).toString();
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (dataSourceFilter.isSet())
        {
            s = dataSourceFilter.getWhereClause();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isSet()
    {
        this;
        JVM INSTR monitorenter ;
        if (mediaTypeFilter.isSet()) goto _L2; else goto _L1
_L1:
        boolean flag = dataSourceFilter.isSet();
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void setMediaTypeFilter(DaoFilter daofilter)
    {
        this;
        JVM INSTR monitorenter ;
        mediaTypeFilter = daofilter;
        this;
        JVM INSTR monitorexit ;
        return;
        daofilter;
        throw daofilter;
    }
}
