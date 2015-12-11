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
import android.view.LayoutInflater;
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

    private final TextView header;
    private RetailSearchLogger retailSearchLogger;
    UserInteractionListener userInteractionListener;

    public RelatedSearchesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        header = (TextView)LayoutInflater.from(getContext()).inflate(com.amazon.retailsearch.R.layout.rs_related_searches, this, false);
        setOrientation(1);
    }

    public void build(RelatedSearches relatedsearches)
    {
        if (relatedsearches == null || TextUtils.isEmpty(relatedsearches.getLabel()) || relatedsearches.getAltQueries() == null)
        {
            setVisibility(8);
            return;
        }
        removeAllViews();
        header.setText(relatedsearches.getLabel());
        addView(header);
        relatedsearches = relatedsearches.getAltQueries().iterator();
        do
        {
            if (!relatedsearches.hasNext())
            {
                break;
            }
            Object obj = (Link)relatedsearches.next();
            if (obj != null && !TextUtils.isEmpty(((Link) (obj)).getText()) && !TextUtils.isEmpty(((Link) (obj)).getUrl()))
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                spannablestringbuilder.append(((Link) (obj)).getText());
                spannablestringbuilder.setSpan(new SearchLinkSpan(((Link) (obj))) {

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
                }, spannablestringbuilder.length() - ((Link) (obj)).getText().length(), spannablestringbuilder.length(), 0);
                obj = (TextView)LayoutInflater.from(getContext()).inflate(com.amazon.retailsearch.R.layout.rs_related_searches, this, false);
                ((TextView) (obj)).setText(spannablestringbuilder);
                ((TextView) (obj)).setId(com.amazon.retailsearch.R.id.related_searches_text);
                ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
                addView(((View) (obj)));
            }
        } while (true);
        setVisibility(0);
        int i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_3px);
        setPadding(i, i, i, i);
    }

    public volatile void build(Object obj)
    {
        build((RelatedSearches)obj);
    }

}
