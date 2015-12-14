// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            DiscoverTabScrollView

class a
    implements android.view.ner
{

    final DiscoverTabScrollView a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (DiscoverTabScrollView.a(a) != DiscoverTabScrollView.b(a))
        {
            DiscoverTabScrollView.a(a, DiscoverTabScrollView.b(a));
            view.post(new Runnable() {

                final DiscoverTabScrollView._cls1 a;

                public void run()
                {
                    int k2 = DiscoverTabScrollView.c(a.a).getChildCount();
                    if (k2 > 0)
                    {
                        int i2;
                        int j2;
                        if (k2 <= 4)
                        {
                            i2 = DiscoverTabScrollView.a(a.a) / k2;
                        } else
                        {
                            i2 = (int)((float)DiscoverTabScrollView.a(a.a) / 3.5F);
                        }
                        for (j2 = 0; j2 < k2; j2++)
                        {
                            ((android.widget.LinearLayout.LayoutParams)((LinearLayout)DiscoverTabScrollView.c(a.a).getChildAt(j2)).getLayoutParams()).width = i2;
                        }

                    }
                }

            
            {
                a = DiscoverTabScrollView._cls1.this;
                super();
            }
            });
        }
    }

    _cls1.a(DiscoverTabScrollView discovertabscrollview)
    {
        a = discovertabscrollview;
        super();
    }
}
