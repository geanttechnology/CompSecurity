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

public class a
    implements android.widget.tener
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
            (new Handler()).postAtTime(new Runnable(view) {

                final View a;
                final TPipStyleListScrollView._cls1 b;

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
                b = TPipStyleListScrollView._cls1.this;
                a = view;
                super();
            }
            }, 700L);
        }
    }

    _cls1.a(TPipStyleListScrollView tpipstylelistscrollview)
    {
        a = tpipstylelistscrollview;
        super();
    }
}
