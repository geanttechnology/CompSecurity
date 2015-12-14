// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;


// Referenced classes of package com.amazon.gallery.framework.data.dao.filter:
//            DataSourceFilter, DataSource

static class 
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
