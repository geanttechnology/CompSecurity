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
import com.amazon.retailsearch.util.Utils;
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
    private final LinearLayout noResultLayout;
    private final TextView noResultMessage1;
    private final TextView noResultMessage2;
    UserPreferenceManager preferencesManager;
    UserInteractionListener userInteractionListener;

    public FkmrHeader(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        setOrientation(1);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_fkmr_header, this);
        noResultLayout = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_no_results);
        noResultMessage1 = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_no_results_message1);
        noResultMessage2 = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_no_results_message2);
        keywords = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_keywords);
        link = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_fkmr_see_all);
    }

    private void populateMessage(TextView textview, List list)
    {
        if (textview == null || Utils.isEmpty(list))
        {
            textview.setVisibility(8);
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
        for (list = list.iterator(); list.hasNext();)
        {
            StyledText styledtext = (StyledText)list.next();
            if ("HIGHLIGHT".equals(styledtext.getStyle()))
            {
                styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Corrections_FKMR_NoResult_Highlight);
            } else
            {
                styledspannablestring.append(styledtext, com.amazon.retailsearch.R.style.Rs);
            }
        }

        textview.setText(styledspannablestring);
        textview.setVisibility(0);
    }

    public void build(FKMR fkmr)
    {
        byte byte0 = 8;
        if (fkmr == null || fkmr.getKeywords() == null)
        {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        populateMessage(noResultMessage1, fkmr.getStyledText());
        populateMessage(noResultMessage2, fkmr.getMessage());
        Object obj = noResultLayout;
        if (noResultMessage1.getVisibility() != 8 || noResultMessage2.getVisibility() != 8)
        {
            byte0 = 0;
        }
        ((LinearLayout) (obj)).setVisibility(byte0);
        obj = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
        for (Iterator iterator = fkmr.getKeywords().iterator(); iterator.hasNext();)
        {
            StyledText styledtext = (StyledText)iterator.next();
            if ("HIGHLIGHT".equals(styledtext.getStyle()))
            {
                ((StyledSpannableString) (obj)).append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Corrections_FKMR_Header_Keywords_Span);
            } else
            {
                ((StyledSpannableString) (obj)).append(styledtext, com.amazon.retailsearch.R.style.Rs);
            }
        }

        keywords.setText(((CharSequence) (obj)));
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
