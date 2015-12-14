// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.database.more.types.a;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.w;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            q, y, r, DownloadItemUtility, 
//            u, s, DownloadGridItem, p, 
//            v

class z extends BaseAdapter
    implements q
{

    HorizontalGridView a;
    List b;
    Map c;
    List d;
    DownloadGridItem.LayoutTypeInfo.LayoutType e;
    DownloadItemUtility f;
    long g;
    int h;
    final y i;
    private android.view.View.OnClickListener j;

    z(y y1, HorizontalGridView horizontalgridview, int k)
    {
        i = y1;
        super();
        h = 30;
        j = new android.view.View.OnClickListener() {

            final z a;

            public void onClick(View view)
            {
                view = (DownloadGridItem)view.getTag();
                int j1 = ((p)view.getTag()).a();
                Object obj = Long.valueOf(a.a(j1).a);
                if (a.c.containsKey(obj))
                {
                    obj = (MakeupItemMetadata)a.c.get(obj);
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Operation.e, ((MakeupItemMetadata) (obj)).b(), null));
                    y.g(a.i).a(((MakeupItemMetadata) (obj)), view, com.cyberlink.youcammakeup.pages.moreview.y.e(a.i), y.d(a.i));
                }
            }

            
            {
                a = z.this;
                super();
            }
        };
        a = horizontalgridview;
        b = y1.a(k).c();
        c = new HashMap();
        g = y1.a(k).a();
        f = new DownloadItemUtility(this, null, com.cyberlink.youcammakeup.Globals.ActivityType.d, y.d(y1));
        f.a(com.cyberlink.youcammakeup.pages.moreview.y.e(y1));
        if (y.f(y1) != CategoryType.b && y.f(y1) != CategoryType.c) goto _L2; else goto _L1
_L1:
        e = com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.e;
_L4:
        int i1 = (int)Math.ceil((double)b.size() / (double)h);
        d = new ArrayList();
        k = 0;
        int l = 0;
        for (; k < i1; k++)
        {
            y1 = new u();
            y1.a = l;
            y1.b = h;
            d.add(y1);
            l += h;
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (y.f(y1) == CategoryType.i || y.f(y1) == CategoryType.m)
        {
            e = DownloadGridItem.LayoutTypeInfo.LayoutType.h;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (d.size() > 0)
        {
            a((u)d.get(0));
        }
        return;
    }

    private void a(u u1)
    {
        int i1 = u1.a;
        int k = u1.b;
        u1.b();
        if (i1 + k > b.size())
        {
            k -= (i1 + k) - b.size();
        }
        ArrayList arraylist = new ArrayList();
        for (int l = i1; l < i1 + k; l++)
        {
            arraylist.add(((s)b.get(l)).a);
        }

        f.b(arraylist, new e(k, u1) {

            final int a;
            final u b;
            final z c;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (list != null && list.size() > 0)
                {
                    MakeupItemMetadata makeupitemmetadata;
                    for (Iterator iterator = list.iterator(); iterator.hasNext(); c.c.put(Long.valueOf(makeupitemmetadata.a()), makeupitemmetadata))
                    {
                        makeupitemmetadata = (MakeupItemMetadata)iterator.next();
                    }

                    ((Activity)com.cyberlink.youcammakeup.pages.moreview.y.b(c.i)).runOnUiThread(new Runnable(this, list) {

                        final List a;
                        final _cls2 b;

                        public void run()
                        {
                            if (a.size() != b.a)
                            {
                                b.b.c();
                            }
                            b.c.a.o();
                        }

            
            {
                b = _pcls2;
                a = list;
                super();
            }
                    });
                }
            }

            public void b(Object obj)
            {
                m.e("DownloadItemExpandableListAdapter", (new StringBuilder()).append("[getViewMetadata] error: ").append(obj.toString()).toString());
                b.c();
            }

            public void c(Object obj)
            {
                m.b("DownloadItemExpandableListAdapter", (new StringBuilder()).append("[getViewMetadata] cancel: ").append(obj.toString()).toString());
                b.c();
            }

            
            {
                c = z.this;
                a = k;
                b = u1;
                super();
            }
        });
    }

    public Context a()
    {
        return a.getContext();
    }

    public w a(int k)
    {
        return ((s)b.get(k)).a;
    }

    public void a(List list)
    {
    }

    public long b()
    {
        return g;
    }

    public MakeupItemMetadata b(int k)
    {
        return (MakeupItemMetadata)c.get(Long.valueOf(getItemId(k)));
    }

    public void c()
    {
        f.a(Long.valueOf(g));
    }

    public CategoryType d()
    {
        return y.f(i);
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int k)
    {
        return a(k);
    }

    public long getItemId(int k)
    {
        return a(k).a;
    }

    public View getView(int k, View view, ViewGroup viewgroup)
    {
        Long long1;
        if (view != null)
        {
            view = (DownloadGridItem)view;
        } else
        {
            view = new a(OrderType.a, y.f(i));
            view = new DownloadGridItem(viewgroup.getContext(), e, view);
            view.setOnDownloadClickListener(f.a);
            view.setTag(new p());
        }
        ((p)view.getTag()).a(k);
        long1 = Long.valueOf(a(k).a);
        f.a(view);
        if (!c.containsKey(long1)) goto _L2; else goto _L1
_L1:
        ((p)view.getTag()).a(long1);
        if (c.get(long1) != null)
        {
            viewgroup = ((MakeupItemMetadata)c.get(long1)).c();
        } else
        {
            viewgroup = "";
        }
        view.setTitle(viewgroup);
        f.a((MakeupItemMetadata)c.get(long1), view, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a);
        f.a(long1, Long.valueOf(g), view);
        if (((MakeupItemMetadata)c.get(long1)).k())
        {
            view.c(true);
            view.d(false);
        } else
        {
            view.c(false);
        }
        if (e == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.e)
        {
            view.setEditMode(((MakeupItemMetadata)c.get(long1)).w());
            view.setLiveMode(((MakeupItemMetadata)c.get(long1)).x());
        }
        view.setDisplayMakeupType(y.d(i));
_L4:
        viewgroup = view.findViewById(0x7f0c057d);
        if (viewgroup != null)
        {
            viewgroup.setTag(view);
            viewgroup.setOnClickListener(j);
        }
        return view;
_L2:
        k /= h;
        if (((u)d.get(k)).a())
        {
            a((u)d.get(k));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
