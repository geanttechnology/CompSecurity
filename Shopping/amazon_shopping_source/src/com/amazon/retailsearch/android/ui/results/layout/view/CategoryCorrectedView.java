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
import com.amazon.searchapp.retailsearch.entity.StyledTextEntity;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.ArrayList;
import java.util.List;

public class CategoryCorrectedView extends LinearLayout
    implements ModelView
{

    private TextView header;
    UserPreferenceManager preferencesManager;

    public CategoryCorrectedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_spell_corrected, this);
        header = (TextView)ViewHolder.get(this, com.amazon.retailsearch.R.id.rs_spell_corrected_text);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void build(CategoryCorrected categorycorrected)
    {
        setVisibility(8);
        if (categorycorrected != null)
        {
            List list = categorycorrected.getStyledText();
            Link link = categorycorrected.getSeeMoreLink();
            categorycorrected = list;
            if (list == null)
            {
                categorycorrected = list;
                if (link != null)
                {
                    categorycorrected = list;
                    if (!TextUtils.isEmpty(link.getText()))
                    {
                        categorycorrected = list;
                        if (!TextUtils.isEmpty(link.getUrl()))
                        {
                            StyledTextEntity styledtextentity = new StyledTextEntity();
                            styledtextentity.setStyle(RetailSearchResultStyles.STYLE_LINK);
                            styledtextentity.setText(link.getText());
                            styledtextentity.setUrl(link.getUrl());
                            categorycorrected = new ArrayList();
                            categorycorrected.add(styledtextentity);
                        }
                    }
                }
            }
            if (categorycorrected != null)
            {
                StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getViewType(), getContext());
                styledspannablestring.append(categorycorrected, com.amazon.retailsearch.R.style.Rs);
                header.setText(styledspannablestring);
                header.setMovementMethod(LinkMovementMethod.getInstance());
                setVisibility(0);
                return;
            }
        }
    }

    public volatile void build(Object obj)
    {
        build((CategoryCorrected)obj);
    }
}
