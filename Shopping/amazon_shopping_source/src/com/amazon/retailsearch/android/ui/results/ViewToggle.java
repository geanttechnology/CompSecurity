// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.DisplaySettingsUtil;
import com.amazon.retailsearch.userpreferences.UserPreferenceChangeListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ViewSelector, ViewType

public class ViewToggle extends ImageView
    implements ViewSelector, UserPreferenceChangeListener
{
    private class ClickListener
        implements android.view.View.OnClickListener
    {

        final ViewToggle this$0;

        public void onClick(View view)
        {
            ViewType viewtype = preferencesManager.getViewType();
            if (viewtype == ViewType.GridView)
            {
                view = ViewType.GalleryView;
            } else
            if (viewtype == ViewType.GalleryView)
            {
                view = ViewType.ListView;
            } else
            {
                view = ViewType.GridView;
            }
            preferencesManager.setViewType(view);
            if (viewtype != null)
            {
                retailSearchLogger.recordLayoutSwitch(viewtype.getName(), view.getName());
            }
        }

        private ClickListener()
        {
            this$0 = ViewToggle.this;
            super();
        }

    }


    FeatureConfiguration featureConfig;
    UserPreferenceManager preferencesManager;
    private RetailSearchLogger retailSearchLogger;

    public ViewToggle(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        int i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.padding_b);
        setPadding(i, i, i, i);
        preferencesManager.addUserPreferenceChangeListener(this);
        setOnClickListener(new ClickListener());
    }

    protected void onFinishInflate()
    {
        ViewType viewtype;
        if (DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
        {
            viewtype = null;
        } else
        {
            viewtype = preferencesManager.getViewType();
        }
        updateView(viewtype);
    }

    public void onViewTypeUpdated(ViewType viewtype)
    {
        updateView(viewtype);
    }

    public void updateView(ViewType viewtype)
    {
        if (viewtype == null)
        {
            setVisibility(4);
            return;
        }
        setVisibility(0);
        if (viewtype == ViewType.GridView)
        {
            setImageDrawable(getResources().getDrawable(com.amazon.retailsearch.R.drawable.grid_view_option));
            setContentDescription(getResources().getString(com.amazon.retailsearch.R.string.grid_view_description));
            return;
        }
        if (viewtype == ViewType.GalleryView)
        {
            setImageDrawable(getResources().getDrawable(com.amazon.retailsearch.R.drawable.gallery_view_option));
            setContentDescription(getResources().getString(com.amazon.retailsearch.R.string.image_view_description));
            return;
        } else
        {
            setImageDrawable(getResources().getDrawable(com.amazon.retailsearch.R.drawable.list_view_option));
            setContentDescription(getResources().getString(com.amazon.retailsearch.R.string.list_view_description));
            return;
        }
    }

}
