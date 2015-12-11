// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.DisplaySettingsUtil;
import com.amazon.retailsearch.userpreferences.UserPreferenceChangeListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ViewSelector, ViewType

public class MultiViewToggle extends LinearLayout
    implements ViewSelector, UserPreferenceChangeListener
{
    private static class Button
    {

        private ImageView image;
        private int imageId;
        private int selectedImageId;
        private ViewType viewType;





        private Button(MultiViewToggle multiviewtoggle, ViewType viewtype, int i, int j, int k)
        {
            image = new ImageView(multiviewtoggle.getContext());
            int l = multiviewtoggle.getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.padding_b);
            image.setPadding(l, l, l, l);
            image.setOnClickListener(new ClickListener(multiviewtoggle, viewtype));
            image.setContentDescription(multiviewtoggle.getResources().getString(k));
            viewType = viewtype;
            imageId = i;
            selectedImageId = j;
        }

    }

    private static class ClickListener
        implements android.view.View.OnClickListener
    {

        private final MultiViewToggle selector;
        private final ViewType type;

        public void onClick(View view)
        {
            view = selector.preferencesManager.getViewType();
            if (view != type)
            {
                selector.preferencesManager.setViewType(type);
                if (view != null)
                {
                    selector.retailSearchLogger.recordLayoutSwitch(view.getName(), type.getName());
                    return;
                }
            }
        }

        private ClickListener(MultiViewToggle multiviewtoggle, ViewType viewtype)
        {
            selector = multiviewtoggle;
            type = viewtype;
        }

    }


    private final List buttons = new ArrayList(3);
    FeatureConfiguration featureConfig;
    UserPreferenceManager preferencesManager;
    private RetailSearchLogger retailSearchLogger;

    public MultiViewToggle(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        preferencesManager.addUserPreferenceChangeListener(this);
        buttons.add(new Button(this, ViewType.ListView, com.amazon.retailsearch.R.drawable.list_view_option, com.amazon.retailsearch.R.drawable.list_view_option_selected, com.amazon.retailsearch.R.string.list_view_description));
        buttons.add(new Button(this, ViewType.GridView, com.amazon.retailsearch.R.drawable.grid_view_option, com.amazon.retailsearch.R.drawable.grid_view_option_selected, com.amazon.retailsearch.R.string.grid_view_description));
        buttons.add(new Button(this, ViewType.GalleryView, com.amazon.retailsearch.R.drawable.gallery_view_option, com.amazon.retailsearch.R.drawable.gallery_view_option_selected, com.amazon.retailsearch.R.string.image_view_description));
        for (Iterator iterator = buttons.iterator(); iterator.hasNext(); addView(((Button)iterator.next()).image)) { }
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
        for (Iterator iterator = buttons.iterator(); iterator.hasNext();)
        {
            Button button = (Button)iterator.next();
            if (button.viewType.equals(viewtype))
            {
                button.image.setImageDrawable(getResources().getDrawable(button.selectedImageId));
            } else
            {
                button.image.setImageDrawable(getResources().getDrawable(button.imageId));
            }
        }

    }

}
