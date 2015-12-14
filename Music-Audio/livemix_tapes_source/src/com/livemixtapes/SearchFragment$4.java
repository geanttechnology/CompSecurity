// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.livemixtapes.ui.widgets.SearchView;

// Referenced classes of package com.livemixtapes:
//            SearchFragment

class this._cls0
    implements android.view.ner
{

    final SearchFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!(new Rect(searchView.getLeft(), searchView.getTop(), searchView.getRight(), searchView.getBottom())).contains(view.getLeft() + (int)motionevent.getX(), view.getTop() + (int)motionevent.getY()))
        {
            searchView.setExpand(false);
        }
        return false;
    }

    View()
    {
        this$0 = SearchFragment.this;
        super();
    }
}
