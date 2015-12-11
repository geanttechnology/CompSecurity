// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import java.util.List;

public class NoResultsSetView extends LinearLayout
    implements ModelView
{

    private final TextView header;
    private final TextView label;
    UserPreferenceManager preferenceManager;

    public NoResultsSetView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_no_results, this);
        header = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_no_result_header);
        label = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_no_result_label);
    }

    public void build(NoResultsSet noresultsset)
    {
        if (noresultsset == null || TextUtils.isEmpty(noresultsset.getLabel()) && noresultsset.getStyledText() == null && noresultsset.getStyledText().isEmpty())
        {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferenceManager.getViewType(), getContext());
        styledspannablestring.append(noresultsset.getStyledText(), com.amazon.retailsearch.R.style.Rs);
        if (!TextUtils.isEmpty(styledspannablestring))
        {
            header.setText(styledspannablestring);
            header.setVisibility(0);
        } else
        {
            header.setVisibility(8);
        }
        if (!TextUtils.isEmpty(noresultsset.getLabel()))
        {
            label.setText(noresultsset.getLabel());
            label.setVisibility(0);
            return;
        } else
        {
            label.setVisibility(8);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((NoResultsSet)obj);
    }
}
