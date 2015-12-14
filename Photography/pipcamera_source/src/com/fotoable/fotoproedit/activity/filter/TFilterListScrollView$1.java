// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.filter;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import gx;
import gy;
import java.util.List;

// Referenced classes of package com.fotoable.fotoproedit.activity.filter:
//            TFilterListScrollView

public class a
    implements android.widget.istener
{

    final TFilterListScrollView a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (TFilterListScrollView.access$200(a) != null)
        {
            a.cancelSelected();
            TFilterListScrollView.access$300(a, view, true);
            TFilterListScrollView.access$102(a, i);
            TFilterListScrollView.access$200(a).a(((gy)TFilterListScrollView.access$400(a).get(i)).b);
            a.requestLayout();
            (new Handler()).postAtTime(new Runnable(view) {

                final View a;
                final TFilterListScrollView._cls1 b;

                public void run()
                {
                    int j = a.getLeft();
                    int k = a.getRight();
                    int i1 = b.a.getWidth();
                    int j1 = b.a.getChildAt(b.a.getChildCount() - 1).getWidth();
                    if (j - j1 < 0)
                    {
                        b.a.scrollBy(-j1);
                    }
                    if (k + j1 > i1)
                    {
                        b.a.scrollBy(j1);
                    }
                }

            
            {
                b = TFilterListScrollView._cls1.this;
                a = view;
                super();
            }
            }, 300L);
        }
    }

    _cls1.a(TFilterListScrollView tfilterlistscrollview)
    {
        a = tfilterlistscrollview;
        super();
    }
}
