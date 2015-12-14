// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;

import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.data.dao.filter:
//            DaoFilter

public class MediaTypeFilter
    implements DaoFilter
{

    private MediaType filter;

    public MediaTypeFilter()
    {
        filter = null;
    }

    public MediaTypeFilter(MediaType mediatype)
    {
        filter = mediatype;
    }

    public MediaType getFilter()
    {
        return filter;
    }

    public volatile Object getFilter()
    {
        return getFilter();
    }

    public String getWhereClause()
    {
        return (new StringBuilder()).append("type = ").append(getFilter().ordinal()).toString();
    }

    public boolean isSet()
    {
        return filter != null;
    }
}
