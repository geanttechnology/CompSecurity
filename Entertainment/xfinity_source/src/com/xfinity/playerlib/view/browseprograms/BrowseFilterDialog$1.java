// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterDialog, BrowseFilterCategoriesPanel, DibicProgramFilter

class this._cls0
    implements android.app.kStackChangedListener
{

    final BrowseFilterDialog this$0;

    public void onBackStackChanged()
    {
        BrowseFilterCategoriesPanel browsefiltercategoriespanel = (BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG);
        if (!isDualPanel)
        {
            if (browsefiltercategoriespanel != null && browsefiltercategoriespanel.isVisible())
            {
                browsefiltercategoriespanel.updateCategoriesList(getPendingFilter());
                BrowseFilterDialog.access$000(BrowseFilterDialog.this).setVisibility(4);
                BrowseFilterDialog.access$100(BrowseFilterDialog.this).setText(getString(com.xfinity.playerlib.));
                BrowseFilterDialog.access$100(BrowseFilterDialog.this).setContentDescription(getString(com.xfinity.playerlib.));
                getPendingFilter().registerOnChangeListener(browsefiltercategoriespanel.getFilterChangeListener());
            }
            resetFocus();
        }
    }

    sPanel()
    {
        this$0 = BrowseFilterDialog.this;
        super();
    }
}
