// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;

public class WordSplitterView extends LinearLayout
    implements ModelView
{

    private TextView header;
    UserPreferenceManager preferencesManager;

    public WordSplitterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_spell_corrected, this);
        header = (TextView)ViewHolder.get(this, com.amazon.retailsearch.R.id.rs_spell_corrected_text);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void build(SpellCorrected spellcorrected)
    {
        if (spellcorrected == null || spellcorrected.getStyledText() == null)
        {
            setVisibility(8);
            return;
        } else
        {
            StyledSpannableString styledspannablestring = new StyledSpannableString(preferencesManager.getResultLayoutType(), getContext());
            styledspannablestring.append(spellcorrected.getStyledText(), com.amazon.retailsearch.R.style.Rs);
            header.setText(styledspannablestring);
            setVisibility(0);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((SpellCorrected)obj);
    }
}
