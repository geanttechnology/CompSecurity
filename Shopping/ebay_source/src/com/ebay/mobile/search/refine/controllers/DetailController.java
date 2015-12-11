// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.os.Bundle;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import java.util.List;

public interface DetailController
{

    public abstract RefineOptionAdapter getAdapter();

    public abstract List getContentSyncKeys();

    public abstract DetailMode getDetailMode();

    public abstract Bundle getStateExtras();

    public abstract String getTitle();

    public abstract boolean isMainHeaderVisible();

    public abstract boolean isOneShot();

    public abstract void notifyHeaderClicked();

    public abstract void onBackClicked();

    public abstract void onDoneClicked();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram);

    public abstract void onUpClicked();

    public abstract void setOneShot(boolean flag);

    public abstract void setStateExtras(Bundle bundle);
}
