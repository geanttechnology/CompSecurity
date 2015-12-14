// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            MeTabScrollView, j

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        int i1 = MeTabScrollView.c(a.a).getChildCount();
        if (i1 > 0)
        {
            int l = a.a.getWidth();
            int i = l;
            if (MeTabScrollView.d(a.a).size() > 0)
            {
                i = l / i1;
            }
            l = Math.max(i, MeTabScrollView.e(a.a));
            for (int k = 0; k < MeTabScrollView.d(a.a).size(); k++)
            {
                ((j)MeTabScrollView.c(a.a).getChildAt(k)).setMinimumWidth(l);
            }

            a.a.setVisibility(0);
            if (MeTabScrollView.a(a.a) != null)
            {
                MeTabScrollView.a(a.a).removeCallbacks(MeTabScrollView.f(a.a));
                MeTabScrollView.a(a.a).postDelayed(MeTabScrollView.f(a.a), 10L);
            }
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/view/widgetpool/common/MeTabScrollView$2

/* anonymous class */
    class MeTabScrollView._cls2
        implements android.view.View.OnLayoutChangeListener
    {

        final MeTabScrollView a;

        public void onLayoutChange(View view, int i, int k, int l, int i1, int j1, int k1, 
                int l1, int i2)
        {
            if (MeTabScrollView.b(a) != a.getWidth())
            {
                MeTabScrollView.a(a, a.getWidth());
                view.post(new MeTabScrollView._cls2._cls1(this));
            }
        }

            
            {
                a = metabscrollview;
                super();
            }
    }

}
