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
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import java.util.Iterator;
import java.util.List;

public class RelatedSearchesView extends LinearLayout
    implements ModelView
{

    private static String newLineSeparator = System.getProperty("line.separator");
    private final TextView header;
    private RetailSearchLogger retailSearchLogger;
    UserInteractionListener userInteractionListener;

    public RelatedSearchesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_related_searches, this);
        header = (TextView)findViewById(com.amazon.retailsearch.R.id.related_searches_text);
    }

    public void build(RelatedSearches relatedsearches)
    {
        if (relatedsearches == null || TextUtils.isEmpty(relatedsearches.getLabel()) || relatedsearches.getAltQueries() == null)
        {
            setVisibility(8);
            return;
        }
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(relatedsearches.getLabel());
        relatedsearches = relatedsearches.getAltQueries().iterator();
        do
        {
            if (!relatedsearches.hasNext())
            {
                break;
            }
            Link link = (Link)relatedsearches.next();
            if (link != null && !TextUtils.isEmpty(link.getText()) && !TextUtils.isEmpty(link.getUrl()))
            {
                spannablestringbuilder.append(newLineSeparator).append(link.getText());
                spannablestringbuilder.setSpan(new SearchLinkSpan(link) {

                    final RelatedSearchesView this$0;
                    final Link val$relatedSearch;

                    public void onClick(View view)
                    {
                        userInteractionListener.search(relatedSearch.getUrl());
                        retailSearchLogger.recordRelatedSearchesInvoked();
                    }

            
            {
                this$0 = RelatedSearchesView.this;
                relatedSearch = link;
                super(final_resources);
            }
                }, spannablestringbuilder.length() - link.getText().length(), spannablestringbuilder.length(), 0);
            }
        } while (true);
        header.setText(spannablestringbuilder);
        header.setVisibility(0);
        header.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public volatile void build(Object obj)
    {
        build((RelatedSearches)obj);
    }


}
