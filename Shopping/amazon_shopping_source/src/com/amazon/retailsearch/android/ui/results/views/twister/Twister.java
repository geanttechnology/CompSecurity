// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.InteractiveRetailSearchResultView;
import com.amazon.retailsearch.android.util.ResUtils;
import com.amazon.searchapp.retailsearch.model.EditionsMetadata;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterModel, TwisterDialog

public class Twister extends TextView
    implements InteractiveRetailSearchResultView
{

    private static final String ATTR_SHOW_EDITIONS_DETAIL = "Rs.Results.Twister.ShowEditionsDetail";
    private static final boolean DEFAULT_SHOW_EDITIONS_DETAIL = true;
    private TwisterModel model;
    private boolean showEditionsDetail;

    public Twister(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        showEditionsDetail = ResUtils.getAttributeBooleanValue(attributeset, "Rs.Results.Twister.ShowEditionsDetail", true);
    }

    public void buildView(TwisterModel twistermodel, ViewType viewtype)
    {
        model = twistermodel;
        if (twistermodel == null || twistermodel.getEditionsMetadata() == null)
        {
            setVisibility(8);
            return;
        }
        java.util.List list = twistermodel.getEditionsMetadata().getLabel();
        twistermodel = twistermodel.getEditionsMetadata().getTypesLabel();
        if (list == null || twistermodel == null)
        {
            setVisibility(8);
            return;
        }
        viewtype = new StyledSpannableString(viewtype, getContext());
        if (showEditionsDetail)
        {
            viewtype.append(list, com.amazon.retailsearch.R.style.Results_Twister);
            viewtype.append((new StringBuilder()).append(getResources().getString(com.amazon.retailsearch.R.string.twister_colon)).append(" ").toString(), com.amazon.retailsearch.R.style.Results_Twister);
            viewtype.append(twistermodel, com.amazon.retailsearch.R.style.Results_Twister);
        } else
        {
            viewtype.append(list, com.amazon.retailsearch.R.style.Results_TwisterLink);
        }
        setText(viewtype);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((TwisterModel)obj, viewtype);
    }

    public View getView()
    {
        return this;
    }

    public void handleSingleTap()
    {
        TwisterDialog twisterdialog = new TwisterDialog(getContext());
        twisterdialog.init(model);
        twisterdialog.show();
    }
}
