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

class a
    implements Runnable
{

    final View a;
    final llBy b;

    public void run()
    {
        int i = a.getLeft();
        int j = a.getRight();
        int k = b.b.getWidth();
        int l = b.b.getChildAt(b.b.getChildCount() - 1).getWidth();
        if (i - l < 0)
        {
            b.b.scrollBy(-l);
        }
        if (j + l > k)
        {
            b.b.scrollBy(l);
        }
    }

    ( , View view)
    {
        b = ;
        a = view;
        super();
    }

    // Unreferenced inner class com/fotoable/fotoproedit/activity/filter/TFilterListScrollView$1

/* anonymous class */
    public class TFilterListScrollView._cls1
        implements android.widget.AdapterView.OnItemClickListener
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
                (new Handler()).postAtTime(new TFilterListScrollView._cls1._cls1(this, view), 300L);
            }
        }

            
            {
                a = tfilterlistscrollview;
                super();
            }
    }

}
