// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import com.wantu.model.res.pip.TDFSceneInfo;
import java.util.List;
import yy;

// Referenced classes of package com.wantu.view:
//            TPipStyleListScrollView

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

    ner(ner ner, View view)
    {
        b = ner;
        a = view;
        super();
    }

    // Unreferenced inner class com/wantu/view/TPipStyleListScrollView$1

/* anonymous class */
    public class TPipStyleListScrollView._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final TPipStyleListScrollView a;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (TPipStyleListScrollView.access$200(a) != null)
            {
                a.cancelSelected();
                TPipStyleListScrollView.access$300(a, view, true);
                TPipStyleListScrollView.access$102(a, i);
                TPipStyleListScrollView.access$200(a).a((TDFSceneInfo)TPipStyleListScrollView.access$400(a).get(i));
                (new Handler()).postAtTime(new TPipStyleListScrollView._cls1._cls1(this, view), 700L);
            }
        }

            
            {
                a = tpipstylelistscrollview;
                super();
            }
    }

}
