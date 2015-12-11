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
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ShippingLineModel

public class ShippingLine extends TextView
    implements RetailSearchResultView
{

    Context context;

    public ShippingLine(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(ShippingLineModel shippinglinemodel, ResultLayoutType resultlayouttype)
    {
        if (shippinglinemodel == null)
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, context);
        for (shippinglinemodel = shippinglinemodel.getStyledText().iterator(); shippinglinemodel.hasNext();)
        {
            StyledText styledtext = (StyledText)shippinglinemodel.next();
            if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
            {
                resultlayouttype.append(styledtext, com.amazon.retailsearch.R.style.Results_ShippingLineHighlight);
            } else
            {
                resultlayouttype.append(styledtext, com.amazon.retailsearch.R.style.Results_ShippingLine);
            }
        }

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
        buildView((ShippingLineModel)obj, resultlayouttype);
    }
}
