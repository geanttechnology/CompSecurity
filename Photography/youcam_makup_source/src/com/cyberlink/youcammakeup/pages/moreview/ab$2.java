// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ab, s, u

class c
    implements e
{

    final int a;
    final int b;
    final u c;
    final ab d;

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        if (list != null && list.size() > 0)
        {
            for (int i = a; i < a + list.size(); i++)
            {
                ((s)ab.f(d).get(i)).b = (MakeupItemMetadata)list.get(i - a);
            }

            ((Activity)com.cyberlink.youcammakeup.pages.moreview.ab.e(d)).runOnUiThread(new Runnable(list) {

                final List a;
                final ab._cls2 b;

                public void run()
                {
                    if (a.size() != b.b)
                    {
                        b.c.c();
                    }
                    ((ExtraDownloadActivity)com.cyberlink.youcammakeup.pages.moreview.ab.e(b.d)).k();
                }

            
            {
                b = ab._cls2.this;
                a = list;
                super();
            }
            });
        }
    }

    public void b(Object obj)
    {
        m.e("ExtrasGridViewAdapter", (new StringBuilder()).append("[getViewMetadata] error: ").append(obj.toString()).toString());
        c.c();
    }

    public void c(Object obj)
    {
        m.b("ExtrasGridViewAdapter", (new StringBuilder()).append("[getViewMetadata] cancel: ").append(obj.toString()).toString());
        c.c();
    }

    _cls1.a(ab ab1, int i, int j, u u1)
    {
        d = ab1;
        a = i;
        b = j;
        c = u1;
        super();
    }
}
