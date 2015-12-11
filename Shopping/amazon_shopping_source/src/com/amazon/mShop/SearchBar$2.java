// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.amazon.mShop:
//            SearchBar

class this._cls0
    implements android.view.Listener
{

    final SearchBar this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            doBarcodeScan();
            SearchBar.access$100(SearchBar.this).setBackgroundResource(com.amazon.mShop.android.lib.sparent);
            return true;
        } else
        {
            SearchBar.access$100(SearchBar.this).setBackgroundResource(com.amazon.mShop.android.lib.ction_bar_icon_round_corner_pressed);
            return true;
        }
    }

    R.drawable()
    {
        this$0 = SearchBar.this;
        super();
    }
}
