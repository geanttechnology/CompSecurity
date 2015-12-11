// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ads;

import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry;

// Referenced classes of package com.amazon.retailsearch.android.ads:
//            AdWidgetView, AdModel

public class AdViewEntry extends ModelViewEntry
{

    private AdWidgetView adWidget;

    private AdViewEntry(Class class1, Object obj)
    {
        super(22, class1, obj);
    }

    public static AdViewEntry create(AdModel admodel)
    {
        return new AdViewEntry(com/amazon/retailsearch/android/ads/AdWidgetView, admodel);
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        if (adWidget == null)
        {
            adWidget = (AdWidgetView)super.createView(viewgroup);
        }
        buildView(adWidget);
        adWidget.initView(viewgroup);
        return adWidget;
    }

    public boolean isEnabled()
    {
        return true;
    }
}
