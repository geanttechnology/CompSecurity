// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.view.View;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ViewToggle, ResultLayoutType

private class <init>
    implements android.view.ults.ViewToggle.ClickListener
{

    final ViewToggle this$0;

    public void onClick(View view)
    {
        ResultLayoutType resultlayouttype = preferencesManager.getResultLayoutType();
        if (resultlayouttype == ResultLayoutType.GridView)
        {
            view = ResultLayoutType.GalleryView;
        } else
        if (resultlayouttype == ResultLayoutType.GalleryView)
        {
            view = ResultLayoutType.ListView;
        } else
        {
            view = ResultLayoutType.GridView;
        }
        preferencesManager.setResultLayoutType(view);
        if (resultlayouttype != null)
        {
            ViewToggle.access$100(ViewToggle.this).recordLayoutSwitch(resultlayouttype.getName(), view.getName());
        }
    }

    private I()
    {
        this$0 = ViewToggle.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
