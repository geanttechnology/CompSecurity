// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            FavoriteDealTypeItem, AutoDismissPopupWindow

class this._cls0
    implements android.view.m._cls1
{

    final FavoriteDealTypeItem this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (FavoriteDealTypeItem.access$000().isShowing())
        {
            FavoriteDealTypeItem.access$000().dismiss();
        }
        return false;
    }

    ()
    {
        this$0 = FavoriteDealTypeItem.this;
        super();
    }
}
