// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            SuperSaverShippingModel

public class SuperSaverShipping extends TextView
    implements RetailSearchResultView
{

    Context context;

    public SuperSaverShipping(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(SuperSaverShippingModel supersavershippingmodel, ViewType viewtype)
    {
        if (supersavershippingmodel == null)
        {
            setVisibility(8);
            return;
        }
        viewtype = new StyledSpannableString(viewtype, context);
        viewtype.append(supersavershippingmodel.getSuperSaverShippingStyledText(), com.amazon.retailsearch.R.style.Results_SuperSaverShipping);
        if (TextUtils.isEmpty(viewtype))
        {
            setVisibility(8);
            return;
        } else
        {
            setText(viewtype);
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((SuperSaverShippingModel)obj, viewtype);
    }
}
