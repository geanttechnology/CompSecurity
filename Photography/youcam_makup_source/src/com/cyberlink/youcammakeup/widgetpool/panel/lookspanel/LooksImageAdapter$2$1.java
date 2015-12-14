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
    implements Runnable
{

    final fyDataSetChanged a;

    public void run()
    {
        a.a.notifyDataSetChanged();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/lookspanel/LooksImageAdapter$2

/* anonymous class */
    class LooksImageAdapter._cls2
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
            (new Handler(Looper.getMainLooper())).post(new LooksImageAdapter._cls2._cls1(this));
        }

        public void b(Object obj)
        {
        }

        public void c(Object obj)
        {
        }

            
            {
                a = looksimageadapter;
                super();
            }
    }

}
