// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements android.view.Listener
{

    final Runnable a;
    final BeautyToolPanel b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        BeautyToolPanel.p(b).removeOnLayoutChangeListener(this);
        if (l - j > 0 && BeautyToolPanel.p(b) != null)
        {
            view = BeautyToolPanel.r(b).findViewById(0x7f0c0726);
            j = BeautyToolPanel.p(b).getHeight();
            k = BeautyToolPanel.r(b).getHeight() - j;
            i = k - b.j.getHeight();
            if (i <= 0 || BeautyToolPanel.p(b).getAdapter().getCount() >= 9)
            {
                i = k / 2;
                view.setTranslationY(0.0F);
                view.setBackgroundColor(Color.parseColor("#BFFFFFFF"));
            } else
            {
                view.setTranslationY(-b.j.getHeight());
                if (i < j / BeautyToolPanel.p(b).getAdapter().getCount())
                {
                    view.setBackgroundColor(Color.parseColor("#BFFFFFFF"));
                } else
                {
                    view.setBackgroundColor(0);
                }
            }
            BeautyToolPanel.p(b).getAdapter().getCount();
            BeautyToolPanel.p(b).setY(i);
        }
        a.run();
    }

    (BeautyToolPanel beautytoolpanel, Runnable runnable)
    {
        b = beautytoolpanel;
        a = runnable;
        super();
    }
}
