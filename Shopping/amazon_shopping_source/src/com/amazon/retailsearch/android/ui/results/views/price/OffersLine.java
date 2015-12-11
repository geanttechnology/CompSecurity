// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.android.util.ResUtils;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            OffersLineModel

public class OffersLine extends TextView
    implements RetailSearchResultView
{

    private static final String ATTR_IS_PRICE_BACKUP = "Rs.Results.Offers.IsPriceBackup";
    private static final String PRICE_STYLED_TEXT = "HIGHLIGHT";
    private final boolean isPriceBackup;

    public OffersLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isPriceBackup = ResUtils.getAttributeBooleanValue(attributeset, "Rs.Results.Offers.IsPriceBackup", false);
    }

    public void buildView(OffersLineModel offerslinemodel, ViewType viewtype)
    {
        if (offerslinemodel == null)
        {
            setVisibility(8);
            return;
        }
        viewtype = new StyledSpannableString(viewtype, getContext());
        for (offerslinemodel = offerslinemodel.getStyledText().iterator(); offerslinemodel.hasNext();)
        {
            StyledText styledtext = (StyledText)offerslinemodel.next();
            if ("HIGHLIGHT".equals(styledtext.getStyle()))
            {
                viewtype.append(styledtext.getText(), com.amazon.retailsearch.R.style.Results_OffersPrice);
            } else
            {
                viewtype.append(styledtext.getText());
            }
        }

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
        buildView((OffersLineModel)obj, viewtype);
    }

    public boolean getIsPriceBackup()
    {
        return isPriceBackup;
    }
}
