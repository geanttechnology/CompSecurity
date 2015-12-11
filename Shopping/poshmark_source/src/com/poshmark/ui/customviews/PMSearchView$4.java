// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import com.poshmark.controllers.SavedSearchController;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMSearchView

class this._cls0
    implements android.view.tener
{

    final PMSearchView this$0;

    public void onClick(View view)
    {
        SavedSearchController.getGlobalSavedSearchController().clearAll();
        setQuery(getQuery(), false);
    }

    ler()
    {
        this$0 = PMSearchView.this;
        super();
    }
}
