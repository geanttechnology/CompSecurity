// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.os.Handler;
import android.os.Looper;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bo;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            LooksImageAdapter

class a
    implements e
{

    final LooksImageAdapter a;

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        if (list == null)
        {
            return;
        }
        LooksImageAdapter.a(a, list.size());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
            if (makeupitemmetadata.w() && !LooksImageAdapter.a(a, makeupitemmetadata.m()))
            {
                as as2 = bo.a(makeupitemmetadata);
                if (makeupitemmetadata.w())
                {
                    int i = a.a(makeupitemmetadata.b());
                    if (i == -1)
                    {
                        a.f.add(0, as2);
                    } else
                    {
                        as as1 = (as)a.f.get(i);
                        a.f.remove(i);
                        a.f.add(0, as1);
                    }
                }
            }
        } while (true);
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final LooksImageAdapter._cls2 a;

            public void run()
            {
                a.a.notifyDataSetChanged();
            }

            
            {
                a = LooksImageAdapter._cls2.this;
                super();
            }
        });
    }

    public void b(Object obj)
    {
    }

    public void c(Object obj)
    {
    }

    _cls1.a(LooksImageAdapter looksimageadapter)
    {
        a = looksimageadapter;
        super();
    }
}
