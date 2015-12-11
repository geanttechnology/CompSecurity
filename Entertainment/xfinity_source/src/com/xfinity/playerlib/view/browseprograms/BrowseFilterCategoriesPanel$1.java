// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoriesPanel, DibicProgramFilter

class this._cls0
    implements FilterChangeListener
{

    final BrowseFilterCategoriesPanel this$0;

    public void onFilterChange(DibicProgramFilter dibicprogramfilter)
    {
        updateCategoriesList(dibicprogramfilter);
        updateDownloadableCheckbox(dibicprogramfilter.isDownloadableOn());
        updateHideLockedCheckbox(dibicprogramfilter.isHideLockOn());
    }

    public volatile void onFilterChange(Object obj)
    {
        onFilterChange((DibicProgramFilter)obj);
    }

    ()
    {
        this$0 = BrowseFilterCategoriesPanel.this;
        super();
    }
}
