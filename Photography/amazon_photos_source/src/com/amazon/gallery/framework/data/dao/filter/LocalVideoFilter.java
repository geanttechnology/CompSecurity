// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;

import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.data.dao.filter:
//            DaoFilter

public class LocalVideoFilter
    implements DaoFilter
{

    public static final String WHERE_CLAUSE;

    public LocalVideoFilter()
    {
    }

    public Object getFilter()
    {
        return null;
    }

    public String getWhereClause()
    {
        return WHERE_CLAUSE;
    }

    public boolean isSet()
    {
        return false;
    }

    static 
    {
        WHERE_CLAUSE = (new StringBuilder()).append("(type=").append(MediaType.PHOTO.ordinal()).append(" OR ").append("local_path").append(" IS NOT NULL)").toString();
    }
}
