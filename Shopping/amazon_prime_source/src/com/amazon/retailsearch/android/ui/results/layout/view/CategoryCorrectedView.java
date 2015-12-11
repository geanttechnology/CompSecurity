// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

public class CategoryCorrectedView extends LinearLayout
    implements ModelView
{

    private TextView detail;
    private TextView header;
    UserPreferenceManager preferencesManager;

    public CategoryCorrectedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_spell_corrected, this);
        header = (TextView)ViewHolder.get(this, com.amazon.retailsearch.R.id.rs_spell_corrected_text);
        detail = (TextView)ViewHolder.get(this, com.amazon.retailsearch.R.id.rs_spell_corrected_detail);
        detail.setVisibility(8);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void build(CategoryCorrected categorycorrected)
    {
        setVisibility(8);
        if (categorycorrected == null || Utils.isEmpty(categorycorrected.getStyledText()))
        {
            return;
        }
        Object obj = categorycorrected.getStyledText();
        categorycorrected = categorycorrected.getSeeMoreLink();
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
        obj = ((List) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            StyledText styledtext = (StyledText)((Iterator) (obj)).next();
            if (RetailSearchResultStyles.STYLE_LINK.equals(styledtext.getStyle()))
            {
                if (categorycorrected != null && !TextUtils.isEmpty(categorycorrected.getUrl()))
                {
                    styledtext.setUrl(categorycorrected.getUrl());
                } else
                {
                    styledtext.setStyle(RetailSearchResultStyles.STYLE_PLAIN);
                    styledtext.setUrl(null);
                }
            }
            styledspannablestring.append(styledtext, com.amazon.retailsearch.R.style.Rs);
        }
        header.setText(styledspannablestring);
        header.setMovementMethod(LinkMovementMethod.getInstance());
        setVisibility(0);
    }

    public volatile void build(Object obj)
    {
        build((CategoryCorrected)obj);
    }
}
