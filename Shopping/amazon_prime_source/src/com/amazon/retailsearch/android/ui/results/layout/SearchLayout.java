// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElement, UserState, FilterRequestListener

public interface SearchLayout
{

    public abstract void addProductAfter(LayoutElement layoutelement, Product product, String s);

    public abstract void changeOrientation(int i, UserState userstate);

    public abstract UserState disable();

    public abstract void disableTouchEvents();

    public abstract void enable(UserState userstate);

    public abstract void enableTouchEvents();

    public abstract int[] getCoordinates();

    public abstract UserState getUserState();

    public abstract void pause();

    public abstract void resume();

    public abstract void scrollToResultsModel(Object obj, int i);

    public abstract void setEntryGroupAsin(String s);

    public abstract void setFilterRequestListener(FilterRequestListener filterrequestlistener);
}
