// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            RetailSearchResultView

public interface InteractiveRetailSearchResultView
    extends RetailSearchResultView
{

    public abstract View getView();

    public abstract void handleSingleTap();
}
