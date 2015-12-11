// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

public class NoResultsSetView extends LinearLayout
    implements ModelView
{

    private final View cover;
    private final View divider;
    private final TextView header;
    private final TextView label;
    private final Button linkButton;
    UserPreferenceManager preferenceManager;
    UserInteractionListener userInteractionListener;

    public NoResultsSetView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_corrections_no_results, this);
        header = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_no_result_header);
        label = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_no_result_label);
        divider = findViewById(com.amazon.retailsearch.R.id.rs_no_result_divider);
        cover = findViewById(com.amazon.retailsearch.R.id.rs_no_result_divider_cover);
        linkButton = (Button)findViewById(com.amazon.retailsearch.R.id.rs_no_result_link_button);
    }

    private void buildLinkButton(StyledText styledtext)
    {
        if (linkButton == null || divider == null || cover == null)
        {
            return;
        }
        if (styledtext == null || TextUtils.isEmpty(styledtext.getText()) || TextUtils.isEmpty(styledtext.getUrl()))
        {
            linkButton.setVisibility(8);
            divider.setVisibility(8);
            cover.setVisibility(8);
            return;
        } else
        {
            linkButton.setVisibility(0);
            divider.setVisibility(0);
            cover.setVisibility(0);
            final String url = styledtext.getUrl();
            linkButton.setOnClickListener(new android.view.View.OnClickListener() {

                final NoResultsSetView this$0;
                final String val$url;

                public void onClick(View view)
                {
                    userInteractionListener.search(url);
                }

            
            {
                this$0 = NoResultsSetView.this;
                url = s;
                super();
            }
            });
            linkButton.setText(styledtext.getText());
            return;
        }
    }

    public void build(NoResultsSet noresultsset)
    {
        if (noresultsset == null || TextUtils.isEmpty(noresultsset.getLabel()) && noresultsset.getStyledText() == null && noresultsset.getStyledText().isEmpty())
        {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        StyledText styledtext = null;
        StyledSpannableString styledspannablestring = new StyledSpannableString(preferenceManager.getResultLayoutType(), getContext());
        for (Iterator iterator = noresultsset.getStyledText().iterator(); iterator.hasNext();)
        {
            StyledText styledtext1 = (StyledText)iterator.next();
            if (!RetailSearchResultStyles.STYLE_LINK.equals(styledtext1.getStyle()))
            {
                styledspannablestring.append(styledtext1, com.amazon.retailsearch.R.style.Rs);
            } else
            {
                styledtext = styledtext1;
            }
        }

        if (!TextUtils.isEmpty(styledspannablestring))
        {
            header.setText(styledspannablestring);
            header.setMovementMethod(LinkMovementMethod.getInstance());
            header.setVisibility(0);
        } else
        {
            header.setVisibility(8);
        }
        if (!TextUtils.isEmpty(noresultsset.getLabel()))
        {
            label.setText(noresultsset.getLabel());
            label.setVisibility(0);
        } else
        {
            label.setVisibility(8);
        }
        buildLinkButton(styledtext);
    }

    public volatile void build(Object obj)
    {
        build((NoResultsSet)obj);
    }
}
