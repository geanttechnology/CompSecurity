// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import com.groupon.models.search.domain.SortMethodWrapper;

public interface OnSearchFilterUpdatedListener
{

    public abstract void facetValueSelectionChanged(Facet facet, FacetValue facetvalue, boolean flag);

    public abstract void reset();

    public abstract void sortValueSelected(SortMethodWrapper sortmethodwrapper);
}
