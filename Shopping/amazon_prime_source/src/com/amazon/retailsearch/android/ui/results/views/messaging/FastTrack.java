// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            FastTrackModel

public class FastTrack extends TextView
    implements RetailSearchResultView
{

    Context context;

    public FastTrack(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(FastTrackModel fasttrackmodel, ResultLayoutType resultlayouttype)
    {
        if (fasttrackmodel == null)
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, context);
        resultlayouttype.append(fasttrackmodel.getFastTrackSyledText(), com.amazon.retailsearch.R.style.Results_FastTrack);
        if (TextUtils.isEmpty(resultlayouttype))
        {
            setVisibility(8);
            return;
        } else
        {
            setText(resultlayouttype);
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((FastTrackModel)obj, resultlayouttype);
    }
}
