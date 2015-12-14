// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.view.Listener
{

    final ch a;
    final EditViewActivity b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        EditViewActivity.m(b).removeOnLayoutChangeListener(this);
        EditViewActivity.m(b).setAlpha(0.5F);
        EditViewActivity.m(b).setY(EditViewActivity.m(b).getHeight());
        EditViewActivity.m(b).animate().alpha(1.0F).y(0.0F).setDuration(300L).setListener(a);
    }

    (EditViewActivity editviewactivity, ch ch)
    {
        b = editviewactivity;
        a = ch;
        super();
    }
}
