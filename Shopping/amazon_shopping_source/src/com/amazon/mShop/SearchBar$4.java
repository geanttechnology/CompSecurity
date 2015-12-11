// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.MotionEvent;
import android.view.View;

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
            goToSearchEntry(null, true);
            logRefMarker();
            SearchBar.access$300(SearchBar.this).setPressed(false);
            SearchBar.access$002(SearchBar.this, true);
            return true;
        } else
        {
            SearchBar.access$300(SearchBar.this).setPressed(true);
            return true;
        }
    }

    ener()
    {
        this$0 = SearchBar.this;
        super();
    }
}
