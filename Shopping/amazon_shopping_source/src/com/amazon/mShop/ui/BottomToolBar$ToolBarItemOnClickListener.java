// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.view.View;

// Referenced classes of package com.amazon.mShop.ui:
//            BottomToolBar

private class mItem
    implements android.view.stener
{

    mItem mItem;
    final BottomToolBar this$0;

    public void onClick(View view)
    {
        if (BottomToolBar.access$000(BottomToolBar.this) != null)
        {
            BottomToolBar.access$000(BottomToolBar.this).Selected(mItem);
        }
    }

    public ( )
    {
        this$0 = BottomToolBar.this;
        super();
        mItem = ;
    }
}
