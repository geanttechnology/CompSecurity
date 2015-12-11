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
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.StyledText;

public class SpellCorrectedFooter extends LinearLayout
    implements ModelView
{

    UserPreferenceManager preferencesManager;
    private TextView textView;

    public SpellCorrectedFooter(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_spell_corrected_footer, this);
        textView = (TextView)ViewHolder.get(this, com.amazon.retailsearch.R.id.rs_spell_corrected_footer_text);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void build(SpellCorrected spellcorrected)
    {
        setVisibility(8);
        Object obj;
        if (spellcorrected != null)
        {
            if ((obj = spellcorrected.getSeeMoreLink()) != null && !TextUtils.isEmpty(((Link) (obj)).getUrl()) && !TextUtils.isEmpty(((Link) (obj)).getText()))
            {
                spellcorrected = new StyledTextEntity();
                spellcorrected.setStyle(RetailSearchResultStyles.STYLE_LINK);
                spellcorrected.setText(((Link) (obj)).getText());
                spellcorrected.setUrl(((Link) (obj)).getUrl());
                obj = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
                ((StyledSpannableString) (obj)).append(spellcorrected, com.amazon.retailsearch.R.style.Rs);
                textView.setText(((CharSequence) (obj)));
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                setVisibility(0);
                return;
            }
        }
    }

    public volatile void build(Object obj)
    {
        build((SpellCorrected)obj);
    }
}
