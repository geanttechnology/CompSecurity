// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.ViewSelector;
import com.amazon.retailsearch.experiment.DisplaySettingsUtil;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.DisplaySettings;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            SearchResultView

private class <init> extends com.amazon.retailsearch.data.TaskListener
{

    final SearchResultView this$0;

    public void displaySettings(DisplaySettings displaysettings)
    {
        if (displaysettings != null && !SearchResultView.access$200(SearchResultView.this) && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
        {
            if ((displaysettings = ResultLayoutType.findByNameIgnoreCase(displaysettings.getResultLayout())) != null)
            {
                SearchResultView.access$202(SearchResultView.this, true);
                preferencesManager.setResultLayoutType(displaysettings);
                return;
            }
        }
    }

    public void endPage()
    {
        ViewSelector viewselector = SearchResultView.access$100(SearchResultView.this).getViewSelector();
        if (viewselector != null && !SearchResultView.access$200(SearchResultView.this) && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
        {
            SearchResultView.access$202(SearchResultView.this, true);
            viewselector.updateView(preferencesManager.getResultLayoutType());
        }
    }

    private ()
    {
        this$0 = SearchResultView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
