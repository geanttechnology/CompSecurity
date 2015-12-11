// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import com.ebay.common.model.search.EbayCategorySummary;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CategoryRefinementController

public static interface 
{

    public abstract void clearAspects();

    public abstract void fetchParentChain(long l);

    public abstract Long getCategoryParent(long l);

    public abstract EbayCategorySummary getCategorySummary(long l);

    public abstract void setCategoryParentHeader(String s, Boolean boolean1, Boolean boolean2, Boolean boolean3);
}
