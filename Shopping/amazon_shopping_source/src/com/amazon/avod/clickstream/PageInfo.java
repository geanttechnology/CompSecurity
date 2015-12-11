// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.clickstream;

import java.util.Map;

// Referenced classes of package com.amazon.avod.clickstream:
//            PageType, PageTypeIDSource, SubPageType

public interface PageInfo
{

    public abstract PageType getPageType();

    public abstract String getPageTypeID();

    public abstract PageTypeIDSource getPageTypeIDSource();

    public abstract Map getReportableData();

    public abstract SubPageType getSubPageType();
}
