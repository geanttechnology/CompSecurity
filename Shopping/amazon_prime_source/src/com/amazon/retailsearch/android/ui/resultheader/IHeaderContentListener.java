// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import com.amazon.retailsearch.android.ui.refinements.IRefinementsMenuListener;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;

public interface IHeaderContentListener
    extends IRefinementsMenuListener
{

    public abstract void onDepartmentLabelUpdated();

    public abstract void onFilterCountUpdated();

    public abstract void onResultCountUpdated();

    public abstract void onResultLayoutTypeUpdated(ResultLayoutType resultlayouttype);
}
