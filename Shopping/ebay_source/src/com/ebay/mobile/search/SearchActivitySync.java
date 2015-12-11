// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.os.Bundle;
import android.util.SparseIntArray;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.net.api.search.ISearchEventTracker;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.dcs.DcsHelper;

public interface SearchActivitySync
{

    public static final int NUMBER_SEARCH_VIEWS = 2;
    public static final int VIEW_TYPE_LIST = 0;
    public static final int VIEW_TYPE_TILE = 1;
    public static final SparseIntArray viewIconsSelected = new SparseIntArray() {

            
            {
                put(0, 0x7f020246);
                put(1, 0x7f020244);
            }
    };
    public static final SparseIntArray viewIconsUnselected = new SparseIntArray() {

            
            {
                put(0, 0x7f020245);
                put(1, 0x7f020243);
            }
    };
    public static final SparseIntArray viewModeAccessibilityStrings = new SparseIntArray() {

            
            {
                put(0, 0x7f070120);
                put(1, 0x7f070121);
            }
    };

    public abstract boolean areSearchParametersReady();

    public abstract EbayCguidPersister getCguidPersister();

    public abstract DcsHelper getDeviceConfiguration();

    public abstract SearchParameters getSearchParameters();

    public abstract ISearchEventTracker getSearchTracker(SearchParameters searchparameters, Bundle bundle);

    public abstract int getSearchViewType();

    public abstract Bundle getTrackingBundle();

    public abstract String getUser();

    public abstract boolean isCategoryRefinementSupported();

    public abstract boolean isFollowBarEnabled();

    public abstract boolean isFollowing();

    public abstract boolean isGbhSearch();

    public abstract boolean isNearEnabled();

    public abstract boolean isRelatedSearchesEnabled();

    public abstract boolean isSignedIn();

    public abstract boolean isUseMyLocationEnabled();

    public abstract void resetSearchParameters(String s);

    public abstract void setSearchViewType(int i);

}
