// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;

public class SpellCorrectedHeader extends LinearLayout
    implements ModelView
{

    private final TextView details;
    private final TextView header;
    UserPreferenceManager preferencesManager;

    public SpellCorrectedHeader(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_spell_corrected, this);
        header = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_spell_corrected_text);
        details = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_spell_corrected_detail);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void build(SpellCorrected spellcorrected)
    {
        if (spellcorrected == null || spellcorrected.getStyledText() == null)
        {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getViewType(), getContext());
        styledspannablestring.append(spellcorrected.getStyledText(), com.amazon.retailsearch.R.style.Rs);
        header.setText(styledspannablestring);
        if (spellcorrected.getDetailedStyledText() != null)
        {
            StyledSpannableString styledspannablestring1 = new StyledSpannableString(preferencesManager.getViewType(), getContext());
            styledspannablestring1.append(spellcorrected.getDetailedStyledText(), com.amazon.retailsearch.R.style.Rs);
            details.setText(styledspannablestring1);
            details.setVisibility(0);
            return;
        } else
        {
            details.setVisibility(8);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((SpellCorrected)obj);
    }
}
