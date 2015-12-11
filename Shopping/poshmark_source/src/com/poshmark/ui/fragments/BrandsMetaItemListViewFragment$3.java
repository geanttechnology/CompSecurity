// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.EditText;
import com.poshmark.ui.customviews.DrawableOnTouchListener;
import com.poshmark.ui.customviews.PMEditText;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandsMetaItemListViewFragment

class this._cls0 extends DrawableOnTouchListener
{

    final BrandsMetaItemListViewFragment this$0;

    public boolean onDrawableTouch(MotionEvent motionevent)
    {
        if (searchText != null && searchText.length() > 0)
        {
            itemClick = false;
            motionevent = getActivity();
            if (motionevent != null)
            {
                motionevent.onBackPressed();
            }
            searchEditText.setText("");
            hideKeyboard();
        }
        return false;
    }

    (EditText edittext)
    {
        this$0 = BrandsMetaItemListViewFragment.this;
        super(edittext);
    }
}
