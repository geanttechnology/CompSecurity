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
import com.amazon.retailsearch.android.ui.results.layout.model.MixedCorrectionsModel;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.QuartzBacklink;
import java.util.List;

public class MixedCorrectionsView extends LinearLayout
    implements ModelView
{

    private final TextView dymHeader;
    private final LinearLayout dymLayout;
    private final TextView dymSubheader;
    UserPreferenceManager preferencesManager;
    private final TextView quartz;
    UserInteractionListener userInteractionListener;

    public MixedCorrectionsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_mixed, this);
        dymLayout = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_corrections_mixed_dym_layout);
        dymHeader = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_corrections_mixed_dym_header);
        dymSubheader = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_corrections_mixed_dym_subheader);
        quartz = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_corrections_mixed_quartz);
        RetailSearchDaggerGraphController.inject(this);
    }

    private void buildDidYouMean(DidYouMean didyoumean, boolean flag)
    {
        if (didyoumean == null)
        {
            dymLayout.setVisibility(8);
            return;
        }
        int i;
        if (didyoumean.getFormattedLabel() != null && !didyoumean.getFormattedLabel().isEmpty())
        {
            highConfidence(didyoumean);
        } else
        {
            lowConfidence(didyoumean);
        }
        if (flag)
        {
            i = 0;
        } else
        {
            i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_corrections_padding_bottom);
        }
        dymLayout.setPadding(dymLayout.getPaddingLeft(), dymLayout.getPaddingTop(), dymLayout.getPaddingRight(), i);
        dymLayout.setVisibility(0);
    }

    private void buildQuartz(QuartzBacklink quartzbacklink, boolean flag)
    {
        if (quartzbacklink == null || Utils.isEmpty(quartzbacklink.getFormattedLabel()))
        {
            quartz.setVisibility(8);
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
        quartzbacklink = quartzbacklink.getFormattedLabel();
        int i;
        if (flag)
        {
            i = com.amazon.retailsearch.R.style.Rs_Corrections_Mixed_Layout_QUARTZ_Secondary;
        } else
        {
            i = com.amazon.retailsearch.R.style.Rs_Corrections_Mixed_Layout_QUARTZ;
        }
        styledspannablestring.append(quartzbacklink, i);
        quartz.setText(styledspannablestring);
        quartz.setMovementMethod(LinkMovementMethod.getInstance());
        quartz.setVisibility(0);
    }

    private boolean highConfidence(DidYouMean didyoumean)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
        styledspannablestring.append(didyoumean.getFormattedLabel(), com.amazon.retailsearch.R.style.Rs);
        if (didyoumean.getFormattedOriginalQueryLabel() != null && !didyoumean.getFormattedOriginalQueryLabel().isEmpty())
        {
            styledspannablestring.append(" ", com.amazon.retailsearch.R.style.Rs);
            styledspannablestring.append(didyoumean.getFormattedOriginalQueryLabel(), com.amazon.retailsearch.R.style.Rs);
        }
        dymHeader.setText(styledspannablestring);
        dymHeader.setMovementMethod(LinkMovementMethod.getInstance());
        dymSubheader.setVisibility(8);
        return true;
    }

    private boolean lowConfidence(DidYouMean didyoumean)
    {
        if (didyoumean.getLabel() == null || didyoumean.getCorrectedQuery() == null || didyoumean.getCorrectedQuery().isEmpty())
        {
            return false;
        }
        Object obj;
        SpannableStringBuilder spannablestringbuilder;
        Object obj1;
        if (!Utils.isEmpty(didyoumean.getDetailLabel()))
        {
            obj = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
            ((StyledSpannableString) (obj)).append(didyoumean.getDetailLabel(), com.amazon.retailsearch.R.style.Rs);
            dymHeader.setText(((CharSequence) (obj)));
            obj = dymSubheader;
            dymSubheader.setVisibility(0);
        } else
        {
            obj = dymHeader;
            dymSubheader.setVisibility(8);
        }
        spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(didyoumean.getLabel());
        obj1 = (Link)didyoumean.getCorrectedQuery().get(0);
        didyoumean = new SearchLinkSpan(((Link) (obj1))) {

            final MixedCorrectionsView this$0;
            final Link val$correctedQuery;

            public void onClick(View view)
            {
                if (userInteractionListener != null && correctedQuery.getUrl() != null)
                {
                    userInteractionListener.search(correctedQuery.getUrl());
                }
            }

            
            {
                this$0 = MixedCorrectionsView.this;
                correctedQuery = link;
                super(final_resources);
            }
        };
        obj1 = (new StringBuilder()).append("\"").append(((Link) (obj1)).getText()).append("\"").toString();
        spannablestringbuilder.append(((CharSequence) (obj1)));
        spannablestringbuilder.setSpan(didyoumean, spannablestringbuilder.length() - ((String) (obj1)).length(), spannablestringbuilder.length(), 0);
        ((TextView) (obj)).setText(spannablestringbuilder);
        ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
        return true;
    }

    public void build(MixedCorrectionsModel mixedcorrectionsmodel)
    {
        boolean flag1 = true;
        if (mixedcorrectionsmodel == null || mixedcorrectionsmodel.isEmpty())
        {
            setVisibility(8);
            return;
        }
        DidYouMean didyoumean = mixedcorrectionsmodel.getDidYouMean();
        mixedcorrectionsmodel = mixedcorrectionsmodel.getQuartzBacklink();
        boolean flag;
        if (didyoumean != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mixedcorrectionsmodel == null)
        {
            flag1 = false;
        }
        buildDidYouMean(didyoumean, flag1);
        buildQuartz(mixedcorrectionsmodel, flag);
        setVisibility(0);
    }

    public volatile void build(Object obj)
    {
        build((MixedCorrectionsModel)obj);
    }
}
