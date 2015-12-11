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

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            SubscribeAndSaveModel

public class SubscribeAndSave extends TextView
    implements RetailSearchResultView
{

    private static final String ATTR_SHOW_SAVE_MORE_TEXT = "Rs.Results.SubscribeAndSave.ShowSaveMoreText";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private boolean showSaveMoreText;

    public SubscribeAndSave(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        showSaveMoreText = ResUtils.getAttributeBooleanValue(attributeset, "Rs.Results.SubscribeAndSave.ShowSaveMoreText", false);
    }

    public void buildView(SubscribeAndSaveModel subscribeandsavemodel, ViewType viewtype)
    {
        if (subscribeandsavemodel == null)
        {
            setVisibility(8);
            return;
        }
        viewtype = new StyledSpannableString(viewtype, getContext());
        viewtype.append((new StringBuilder()).append(subscribeandsavemodel.getPrice()).append(" ").toString(), com.amazon.retailsearch.R.style.Results_PriceSpan);
        viewtype.append(subscribeandsavemodel.getPriceLabel(), com.amazon.retailsearch.R.style.Results_SubscribeAndSavePriceLabel);
        if (!TextUtils.isEmpty(subscribeandsavemodel.getSaveMoreText()))
        {
            viewtype.append(NEW_LINE);
            viewtype.append(subscribeandsavemodel.getSaveMoreText());
        }
        setText(viewtype, android.widget.TextView.BufferType.SPANNABLE);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((SubscribeAndSaveModel)obj, viewtype);
    }

    public boolean getShowSaveMoreText()
    {
        return showSaveMoreText;
    }

}
