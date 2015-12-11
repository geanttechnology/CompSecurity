// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

public class FkmrHeader extends LinearLayout
    implements ModelView
{

    private static final String HIGHLIGHT = "HIGHLIGHT";
    private final TextView keywords;
    private final TextView link;
    private final TextView noResultHeader;
    UserPreferenceManager preferencesManager;
    UserInteractionListener userInteractionListener;

    public FkmrHeader(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        setOrientation(1);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_fkmr_header, this);
        noResultHeader = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_no_results);
        keywords = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_keywords);
        link = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_see_all);
    }

    public void build(FKMR fkmr)
    {
        if (fkmr == null || fkmr.getKeywords() == null)
        {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        StyledSpannableString styledspannablestring1;
        if (fkmr.getStyledText() != null && !fkmr.getStyledText().isEmpty())
        {
            noResultHeader.setVisibility(0);
            StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getViewType(), getContext());
            styledspannablestring.append(fkmr.getStyledText(), com.amazon.retailsearch.R.style.Rs);
            noResultHeader.setText(styledspannablestring);
        } else
        {
            noResultHeader.setVisibility(8);
        }
        styledspannablestring1 = new StyledSpannableString(preferencesManager.getViewType(), getContext());
        for (Iterator iterator = fkmr.getKeywords().iterator(); iterator.hasNext();)
        {
            StyledText styledtext = (StyledText)iterator.next();
            if ("HIGHLIGHT".equals(styledtext.getStyle()))
            {
                styledspannablestring1.append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Corrections_FKMR_Keywords_Span);
            } else
            {
                styledspannablestring1.append(styledtext, com.amazon.retailsearch.R.style.Rs);
            }
        }

        keywords.setText(styledspannablestring1);
        if (fkmr.getSeeAllLink() == null || TextUtils.isEmpty(fkmr.getSeeAllLink().getText()) || TextUtils.isEmpty(fkmr.getSeeAllLink().getUrl()))
        {
            link.setText("");
            return;
        } else
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(fkmr.getSeeAllLink().getText());
            spannablestringbuilder.setSpan(new SearchLinkSpan(fkmr) {

                final FkmrHeader this$0;
                final FKMR val$fkmr;

                public void onClick(View view)
                {
                    userInteractionListener.search(fkmr.getSeeAllLink().getUrl());
                }

            
            {
                this$0 = FkmrHeader.this;
                fkmr = fkmr1;
                super(final_resources);
            }
            }, 0, spannablestringbuilder.length(), 0);
            link.setText(spannablestringbuilder);
            link.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((FKMR)obj);
    }
}
