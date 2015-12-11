// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.view.View;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoriesPanel, FilterEventListener

private class <init>
    implements android.view.anel.CategoryOnClickListener
{

    final BrowseFilterCategoriesPanel this$0;

    public void onClick(View view)
    {
        if (view.isSelected())
        {
            return;
        } else
        {
            setSelectedCategoryView(view);
            BrowseFilterCategoriesPanel.access$000(BrowseFilterCategoriesPanel.this).onCategoryChanged((this._cls0)view.getTag());
            return;
        }
    }

    private ()
    {
        this$0 = BrowseFilterCategoriesPanel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
