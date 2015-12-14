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
    implements android.view.eListener
{

    final MeTabScrollView a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (MeTabScrollView.b(a) != a.getWidth())
        {
            MeTabScrollView.a(a, a.getWidth());
            view.post(new Runnable() {

                final MeTabScrollView._cls2 a;

                public void run()
                {
                    int l2 = MeTabScrollView.c(a.a).getChildCount();
                    if (l2 > 0)
                    {
                        int k2 = a.a.getWidth();
                        int i2 = k2;
                        if (MeTabScrollView.d(a.a).size() > 0)
                        {
                            i2 = k2 / l2;
                        }
                        k2 = Math.max(i2, MeTabScrollView.e(a.a));
                        for (int j2 = 0; j2 < MeTabScrollView.d(a.a).size(); j2++)
                        {
                            ((j)MeTabScrollView.c(a.a).getChildAt(j2)).setMinimumWidth(k2);
                        }

                        a.a.setVisibility(0);
                        if (MeTabScrollView.a(a.a) != null)
                        {
                            MeTabScrollView.a(a.a).removeCallbacks(MeTabScrollView.f(a.a));
                            MeTabScrollView.a(a.a).postDelayed(MeTabScrollView.f(a.a), 10L);
                        }
                    }
                }

            
            {
                a = MeTabScrollView._cls2.this;
                super();
            }
            });
        }
    }

    _cls1.a(MeTabScrollView metabscrollview)
    {
        a = metabscrollview;
        super();
    }
}
