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
//            ViewSelector, ResultLayoutType

public class MultiViewToggle extends LinearLayout
    implements ViewSelector, UserPreferenceChangeListener
{
    private static class Button
    {

        private String description;
        private ImageView image;
        private int imageId;
        private ResultLayoutType resultLayoutType;
        private int selectedImageId;






        private Button(MultiViewToggle multiviewtoggle, ResultLayoutType resultlayouttype, int i, int j, int k)
        {
            image = new ImageView(multiviewtoggle.getContext());
            description = multiviewtoggle.getResources().getString(k);
            k = multiviewtoggle.getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.padding_b);
            image.setPadding(k, k, k, k);
            image.setOnClickListener(new ClickListener(multiviewtoggle, resultlayouttype));
            image.setContentDescription(description);
            resultLayoutType = resultlayouttype;
            imageId = i;
            selectedImageId = j;
        }

    }

    private static class ClickListener
        implements android.view.View.OnClickListener
    {

        private final MultiViewToggle selector;
        private final ResultLayoutType type;

        public void onClick(View view)
        {
            view = selector.preferencesManager.getResultLayoutType();
            if (view != type)
            {
                selector.preferencesManager.setResultLayoutType(type);
                if (view != null)
                {
                    selector.retailSearchLogger.recordLayoutSwitch(view.getName(), type.getName());
                    return;
                }
            }
        }

        private ClickListener(MultiViewToggle multiviewtoggle, ResultLayoutType resultlayouttype)
        {
            selector = multiviewtoggle;
            type = resultlayouttype;
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
        buttons.add(new Button(this, ResultLayoutType.ListView, com.amazon.retailsearch.R.drawable.list_view_option, com.amazon.retailsearch.R.drawable.list_view_option_selected, com.amazon.retailsearch.R.string.list_view_description));
        buttons.add(new Button(this, ResultLayoutType.GridView, com.amazon.retailsearch.R.drawable.grid_view_option, com.amazon.retailsearch.R.drawable.grid_view_option_selected, com.amazon.retailsearch.R.string.grid_view_description));
        buttons.add(new Button(this, ResultLayoutType.GalleryView, com.amazon.retailsearch.R.drawable.gallery_view_option, com.amazon.retailsearch.R.drawable.gallery_view_option_selected, com.amazon.retailsearch.R.string.image_view_description));
        for (Iterator iterator = buttons.iterator(); iterator.hasNext(); addView(((Button)iterator.next()).image)) { }
    }

    protected void onFinishInflate()
    {
        ResultLayoutType resultlayouttype;
        if (DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
        {
            resultlayouttype = null;
        } else
        {
            resultlayouttype = preferencesManager.getResultLayoutType();
        }
        updateView(resultlayouttype);
    }

    public void onResultLayoutTypeUpdated(ResultLayoutType resultlayouttype)
    {
        updateView(resultlayouttype);
    }

    public void updateView(ResultLayoutType resultlayouttype)
    {
        for (Iterator iterator = buttons.iterator(); iterator.hasNext();)
        {
            Button button = (Button)iterator.next();
            if (button.resultLayoutType.equals(resultlayouttype))
            {
                button.image.setImageDrawable(getResources().getDrawable(button.selectedImageId));
                button.image.setContentDescription((new StringBuilder()).append(button.description).append(". ").append(getResources().getString(com.amazon.retailsearch.R.string.refine_selected)).toString());
            } else
            {
                button.image.setImageDrawable(getResources().getDrawable(button.imageId));
                button.image.setContentDescription(button.description);
            }
        }

    }

}
