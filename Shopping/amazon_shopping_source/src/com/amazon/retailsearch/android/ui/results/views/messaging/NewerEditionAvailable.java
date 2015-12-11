// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.InteractiveRetailSearchResultView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            NewerEditionAvailableModel

public class NewerEditionAvailable extends TextView
    implements InteractiveRetailSearchResultView
{

    private NewerEditionAvailableModel model;
    UserInteractionListener userInteractionListener;

    public NewerEditionAvailable(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void buildView(NewerEditionAvailableModel newereditionavailablemodel, ViewType viewtype)
    {
        model = newereditionavailablemodel;
        if (newereditionavailablemodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            setText(newereditionavailablemodel.getNewerVersionText());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((NewerEditionAvailableModel)obj, viewtype);
    }

    public View getView()
    {
        return this;
    }

    public void handleSingleTap()
    {
        com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem retailsearchresultitem = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(model.getAsin(), model.getNewerVersionUrl(), model.getProductGroup());
        userInteractionListener.resultItemSelected(retailsearchresultitem, DetailPageType.NEWER_EDITION);
    }
}
