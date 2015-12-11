// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
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
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.Link;
import java.util.List;

public class DidYouMeanView extends LinearLayout
    implements ModelView
{

    private final TextView details;
    private final TextView header;
    UserPreferenceManager preferencesManager;
    UserInteractionListener userInteractionListener;

    public DidYouMeanView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_did_you_mean, this);
        header = (TextView)findViewById(com.amazon.retailsearch.R.id.did_you_mean_text);
        details = (TextView)findViewById(com.amazon.retailsearch.R.id.did_you_mean_detailed_text);
        RetailSearchDaggerGraphController.inject(this);
    }

    private void highConfidence(DidYouMean didyoumean)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getViewType(), getContext());
        styledspannablestring.append(didyoumean.getFormattedLabel(), com.amazon.retailsearch.R.style.Rs);
        header.setText(styledspannablestring);
        header.setMovementMethod(LinkMovementMethod.getInstance());
        if (didyoumean.getFormattedOriginalQueryLabel() != null && !didyoumean.getFormattedOriginalQueryLabel().isEmpty())
        {
            StyledSpannableString styledspannablestring1 = new StyledSpannableString(preferencesManager.getViewType(), getContext());
            styledspannablestring1.append(didyoumean.getFormattedOriginalQueryLabel(), com.amazon.retailsearch.R.style.Rs);
            details.setText(styledspannablestring1);
            details.setMovementMethod(LinkMovementMethod.getInstance());
            details.setVisibility(0);
            return;
        } else
        {
            details.setVisibility(8);
            return;
        }
    }

    private void lowConfidence(DidYouMean didyoumean)
    {
        if (didyoumean.getLabel() == null || didyoumean.getCorrectedQuery() == null || didyoumean.getCorrectedQuery().isEmpty())
        {
            setVisibility(8);
            return;
        } else
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(didyoumean.getLabel());
            Object obj = (Link)didyoumean.getCorrectedQuery().get(0);
            didyoumean = new SearchLinkSpan(((Link) (obj))) {

                final DidYouMeanView this$0;
                final Link val$correctedQuery;

                public void onClick(View view)
                {
                    if (userInteractionListener != null && correctedQuery.getUrl() != null)
                    {
                        userInteractionListener.search(correctedQuery.getUrl());
                    }
                }

            
            {
                this$0 = DidYouMeanView.this;
                correctedQuery = link;
                super(final_resources);
            }
            };
            obj = (new StringBuilder()).append("\"").append(((Link) (obj)).getText()).append("\"").toString();
            spannablestringbuilder.append(((CharSequence) (obj)));
            spannablestringbuilder.setSpan(didyoumean, spannablestringbuilder.length() - ((String) (obj)).length(), spannablestringbuilder.length(), 0);
            header.setText(spannablestringbuilder);
            header.setMovementMethod(LinkMovementMethod.getInstance());
            details.setVisibility(8);
            return;
        }
    }

    public void build(DidYouMean didyoumean)
    {
        if (didyoumean == null)
        {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (didyoumean.getFormattedLabel() != null && !didyoumean.getFormattedLabel().isEmpty())
        {
            highConfidence(didyoumean);
            return;
        } else
        {
            lowConfidence(didyoumean);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((DidYouMean)obj);
    }
}
