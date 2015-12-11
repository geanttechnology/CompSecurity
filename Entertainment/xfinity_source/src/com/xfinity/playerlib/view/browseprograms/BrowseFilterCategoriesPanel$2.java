// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.widget.CompoundButton;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoriesPanel, FilterEventListener

class this._cls0
    implements android.widget.Listener
{

    final BrowseFilterCategoriesPanel this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        BrowseFilterCategoriesPanel.access$000(BrowseFilterCategoriesPanel.this).onSubscriptionOnlyChanged(flag);
    }

    ()
    {
        this$0 = BrowseFilterCategoriesPanel.this;
        super();
    }
}
