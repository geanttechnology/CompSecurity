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
//            SubtitleModel

public class Subtitle extends TextView
    implements RetailSearchResultView
{

    public Subtitle(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(SubtitleModel subtitlemodel, ResultLayoutType resultlayouttype)
    {
        if (subtitlemodel == null || TextUtils.isEmpty(subtitlemodel.getText()))
        {
            setVisibility(8);
            return;
        } else
        {
            setText(subtitlemodel.getText());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((SubtitleModel)obj, resultlayouttype);
    }
}
