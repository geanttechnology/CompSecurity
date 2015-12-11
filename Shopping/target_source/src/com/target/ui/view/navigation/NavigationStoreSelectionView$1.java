// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.view.View;

// Referenced classes of package com.target.ui.view.navigation:
//            NavigationStoreSelectionView

class this._cls0
    implements android.view.eSelectionView._cls1
{

    final NavigationStoreSelectionView this$0;

    public void onClick(View view)
    {
        if (NavigationStoreSelectionView.a(NavigationStoreSelectionView.this) == null)
        {
            return;
        }
        if (NavigationStoreSelectionView.b(NavigationStoreSelectionView.this) != null)
        {
            NavigationStoreSelectionView.a(NavigationStoreSelectionView.this).a(NavigationStoreSelectionView.b(NavigationStoreSelectionView.this));
            return;
        } else
        {
            NavigationStoreSelectionView.a(NavigationStoreSelectionView.this).e();
            return;
        }
    }

    ()
    {
        this$0 = NavigationStoreSelectionView.this;
        super();
    }
}
