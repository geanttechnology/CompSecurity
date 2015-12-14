// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;


// Referenced classes of package com.amazon.gallery.framework.data.dao.filter:
//            DaoFilter, DataSource

public class DataSourceFilter
    implements DaoFilter
{

    private static final String CLOUD_ONLY_WHERE = String.format("%s is NULL", new Object[] {
        "local_path"
    });
    private static final String HAS_CLOUD_WHERE = String.format("%s != 0", new Object[] {
        "object_id_hi"
    });
    private static final String HAS_LOCAL_WHERE = String.format("%s is NOT NULL", new Object[] {
        "local_path"
    });
    private static final String LOCAL_ONLY_WHERE = String.format("%s = 0", new Object[] {
        "object_id_hi"
    });
    private DataSource filter;

    public DataSourceFilter()
    {
        filter = null;
    }

    public DataSource getFilter()
    {
        return filter;
    }

    public volatile Object getFilter()
    {
        return getFilter();
    }

    public String getWhereClause()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$data$dao$filter$DataSource[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$data$dao$filter$DataSource = new int[DataSource.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$filter$DataSource[DataSource.ONLY_CLOUD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$filter$DataSource[DataSource.ONLY_LOCAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$filter$DataSource[DataSource.HAS_CLOUD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$data$dao$filter$DataSource[DataSource.HAS_LOCAL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.data.dao.filter.DataSource[filter.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return CLOUD_ONLY_WHERE;

        case 2: // '\002'
            return LOCAL_ONLY_WHERE;

        case 3: // '\003'
            return HAS_CLOUD_WHERE;

        case 4: // '\004'
            return HAS_LOCAL_WHERE;
        }
    }

    public boolean isSet()
    {
        return filter != null;
    }

}
