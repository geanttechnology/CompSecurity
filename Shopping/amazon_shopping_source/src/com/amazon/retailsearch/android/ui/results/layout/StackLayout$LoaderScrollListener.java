// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.listview.PredictiveScrollListener;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, ResultsController

protected class <init> extends PredictiveScrollListener
{

    final StackLayout this$0;

    protected List getLoadersFor(int i)
    {
        return results.getLoadersFor(i);
    }

    private (ResourceProvider resourceprovider)
    {
        this$0 = StackLayout.this;
        super(resourceprovider);
    }

    this._cls0(ResourceProvider resourceprovider, this._cls0 _pcls0)
    {
        this(resourceprovider);
    }
}
