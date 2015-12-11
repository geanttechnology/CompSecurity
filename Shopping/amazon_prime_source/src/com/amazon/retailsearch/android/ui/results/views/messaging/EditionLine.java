// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            EditionLineModel

public class EditionLine extends TextView
    implements RetailSearchResultView
{

    public EditionLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(EditionLineModel editionlinemodel, ResultLayoutType resultlayouttype)
    {
        if (editionlinemodel == null || TextUtils.isEmpty(editionlinemodel.getEditionText()))
        {
            setVisibility(8);
            return;
        } else
        {
            setText(editionlinemodel.getEditionText());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((EditionLineModel)obj, resultlayouttype);
    }
}
