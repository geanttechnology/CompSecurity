// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.view.View;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewCompositeController;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

class this._cls0
    implements android.view.kListener
{

    final ViewFragment this$0;

    public boolean onLongClick(View view)
    {
        if (mScreenModeManager.isFullScreen())
        {
            exitFullScreen();
        }
        int i = ((android.support.v7.widget.ewHolder)view.getTag()).getPosition();
        boolean flag = ViewFragment.access$300(ViewFragment.this).onLongClick(view, i);
        if (flag)
        {
            mAdapter.notifyItemChanged(i);
        }
        return flag;
    }

    pter()
    {
        this$0 = ViewFragment.this;
        super();
    }
}
