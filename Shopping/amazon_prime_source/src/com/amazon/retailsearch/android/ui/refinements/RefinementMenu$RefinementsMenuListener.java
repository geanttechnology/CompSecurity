// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import com.amazon.searchapp.retailsearch.model.Refinements;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            IRefinementsMenuListener, RefinementMenu, SpinnerHiderRelativeLayout

private class <init>
    implements IRefinementsMenuListener
{

    final RefinementMenu this$0;

    public void OnClearAllClick()
    {
    }

    public void onHide()
    {
        if (RefinementMenu.access$300(RefinementMenu.this) != null)
        {
            RefinementMenu.access$300(RefinementMenu.this).onHide();
        }
    }

    public void onRefinementClick(String s)
    {
        RefinementMenu.access$400(RefinementMenu.this).show();
        if (RefinementMenu.access$300(RefinementMenu.this) != null)
        {
            RefinementMenu.access$300(RefinementMenu.this).onRefinementClick(s);
        }
    }

    public void onUpdate(Refinements refinements)
    {
        updateDialogHeight();
        if (RefinementMenu.access$300(RefinementMenu.this) != null)
        {
            RefinementMenu.access$300(RefinementMenu.this).onUpdate(refinements);
        }
        RefinementMenu.access$400(RefinementMenu.this).hide();
    }

    public void onViewSizeChanged()
    {
        updateDialogHeight();
        if (RefinementMenu.access$300(RefinementMenu.this) != null)
        {
            RefinementMenu.access$300(RefinementMenu.this).onViewSizeChanged();
        }
    }

    private ()
    {
        this$0 = RefinementMenu.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
