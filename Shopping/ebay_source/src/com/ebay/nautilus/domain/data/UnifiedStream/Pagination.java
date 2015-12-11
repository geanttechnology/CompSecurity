// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            ContentSourceEnum

public class Pagination
{

    public ContentSourceEnum contentSource;
    public String cursor;
    public Integer entriesPerPage;

    public Pagination()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("Pagination(").append(contentSource).append(",").append(entriesPerPage).append(",").append(cursor).append(")").toString();
    }
}
