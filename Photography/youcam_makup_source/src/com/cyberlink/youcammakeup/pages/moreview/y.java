// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.idunnololz.widgets.a;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            q, DownloadItemUtility, v, u, 
//            r, z, af

public class y extends a
    implements q
{

    private Context a;
    private DownloadItemUtility b;
    private ag c;
    private CategoryType d;
    private List e;
    private List f;
    private List g;
    private int h;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType i;
    private v j;

    public y(Context context, CategoryType categorytype, Boolean boolean1, Object obj, ag ag, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, 
            com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        h = 30;
        a = context;
        d = categorytype;
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        c = ag;
        i = displaymakeuptype;
        b = new DownloadItemUtility(this, null, com.cyberlink.youcammakeup.Globals.ActivityType.d, i);
        b.a(ag);
        b.a(onclicklistener);
        b.b(onclicklistener1);
        b.a(CategoryType.a(categorytype));
        j = new v(((Activity)a).findViewById(0x7f0c057f));
    }

    static List a(y y1)
    {
        return y1.e;
    }

    private void a(u u1)
    {
        int j1 = u1.a;
        int l = u1.b;
        u1.b();
        int k = l;
        if (j1 + l > e.size())
        {
            k = l - ((j1 + l) - e.size());
        }
        ArrayList arraylist = new ArrayList();
        for (int i1 = j1; i1 < j1 + k; i1++)
        {
            arraylist.add(a(i1).a);
        }

        b.a(arraylist, new e(j1, k, u1) {

            final int a;
            final int b;
            final u c;
            final y d;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (list == null || list.size() == 0)
                {
                    return;
                }
                for (int k1 = a; k1 < a + list.size(); k1++)
                {
                    ((r)com.cyberlink.youcammakeup.pages.moreview.y.a(d).get(k1)).b = (com.cyberlink.youcammakeup.database.more.makeup.a)list.get(k1 - a);
                }

                ((Activity)y.b(d)).runOnUiThread(new Runnable(this, list) {

                    final List a;
                    final _cls1 b;

                    public void run()
                    {
                        if (a.size() != b.b)
                        {
                            b.c.c();
                        }
                        b.d.notifyDataSetChanged();
                    }

            
            {
                b = _pcls1;
                a = list;
                super();
            }
                });
            }

            public void b(Object obj)
            {
                m.e("DownloadItemExpandableListAdapter", obj.toString());
                c.c();
            }

            public void c(Object obj)
            {
                m.b("DownloadItemExpandableListAdapter", obj.toString());
                c.c();
            }

            
            {
                d = y.this;
                a = k;
                b = l;
                c = u1;
                super();
            }
        });
    }

    static Context b(y y1)
    {
        return y1.a;
    }

    static List c(y y1)
    {
        return y1.f;
    }

    static com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType d(y y1)
    {
        return y1.i;
    }

    static ag e(y y1)
    {
        return y1.c;
    }

    static CategoryType f(y y1)
    {
        return y1.d;
    }

    static v g(y y1)
    {
        return y1.j;
    }

    public Context a()
    {
        return a;
    }

    public View a(int k, int l, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            if (d == CategoryType.b || d == CategoryType.c)
            {
                view = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030206, viewgroup, false);
            } else
            {
                view = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030205, viewgroup, false);
            }
            viewgroup.post(new Runnable((HorizontalGridView)view.findViewById(0x7f0c08e0), k) {

                final HorizontalGridView a;
                final int b;
                final y c;

                public void run()
                {
                    z z1 = new z(c, a, b);
                    y.c(c).add(z1);
                    a.setAdapter(z1);
                    a.setSelector(0x106000d);
                }

            
            {
                c = y.this;
                a = horizontalgridview;
                b = k;
                super();
            }
            });
        }
        if (k == 0)
        {
            view.findViewById(0x7f0c08e1).setVisibility(0);
            return view;
        } else
        {
            view.findViewById(0x7f0c08e1).setVisibility(8);
            return view;
        }
    }

    public r a(int k)
    {
        return (r)e.get(k);
    }

    public void a(List list)
    {
        int l = 0;
        int i1;
        if (i == com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c)
        {
            MakeupItemTreeManager makeupitemtreemanager = MakeupItemTreeManager.a();
            ArrayList arraylist = new ArrayList();
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                r r1 = (r)iterator.next();
                if (makeupitemtreemanager.d(i, r1.a()).size() > 0)
                {
                    arraylist.add(r1);
                }
            } while (true);
            e.addAll(arraylist);
        } else
        {
            e.addAll(list);
        }
        if (list.size() != 0)
        {
            notifyDataSetChanged();
        } else
        {
            ((ExtraDownloadCategoryActivity)a).l();
        }
        i1 = (int)Math.ceil((double)e.size() / (double)h);
        for (int k = 0; k < i1; k++)
        {
            list = new u();
            list.a = l;
            list.b = h;
            g.add(list);
            l += h;
        }

    }

    public int a_(int k)
    {
        return k >= 2 ? 0 : 1;
    }

    public long b()
    {
        return CategoryType.a(d);
    }

    public MakeupItemMetadata b(int k)
    {
        return null;
    }

    public String c(int k)
    {
        return a(k).b().b();
    }

    public CategoryType d()
    {
        return d;
    }

    public boolean d(int k)
    {
        return a(k).b() != null;
    }

    public void e()
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((z)iterator.next()).c()) { }
        b.a();
        b.a(Long.valueOf(CategoryType.a(d)));
    }

    public void f_()
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((z)iterator.next()).notifyDataSetChanged()) { }
    }

    public Object getChild(int k, int l)
    {
        return a(k).c().get(l);
    }

    public long getChildId(int k, int l)
    {
        return (long)getChild(k, l).hashCode();
    }

    public Object getGroup(int k)
    {
        return a(k);
    }

    public int getGroupCount()
    {
        return e.size();
    }

    public long getGroupId(int k)
    {
        return a(k).a();
    }

    public int getGroupType(int k)
    {
        return k >= 2 ? 1 : 0;
    }

    public int getGroupTypeCount()
    {
        return 2;
    }

    public View getGroupView(int k, boolean flag, View view, ViewGroup viewgroup)
    {
        View view1;
        view1 = view;
        TextView textview;
        ImageView imageview;
        Object obj;
        long l;
        if (view == null)
        {
            if (getGroupType(k) == 0)
            {
                view1 = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301f0, viewgroup, false);
            } else
            {
                view1 = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301ef, viewgroup, false);
            }
        }
        textview = (TextView)view1.findViewById(0x7f0c0893);
        imageview = (ImageView)view1.findViewById(0x7f0c0891);
        view = view1.findViewById(0x7f0c0892);
        viewgroup = (Long)view1.getTag();
        obj = Long.valueOf(getGroupId(k));
        l = a(k).a();
        if (((Long) (obj)).equals(viewgroup)) goto _L2; else goto _L1
_L1:
        textview.setText(null);
        if (view != null)
        {
            if (com.cyberlink.youcammakeup.pages.moreview.af.a(MoreMakeupActivity.a, Long.valueOf(l).longValue()))
            {
                view.setVisibility(0);
            } else
            {
                view.setVisibility(4);
            }
        }
        if (a(k).b() == null) goto _L4; else goto _L3
_L3:
        view1.setTag(obj);
        obj = a(k).b();
        viewgroup = ((com.cyberlink.youcammakeup.database.more.makeup.a) (obj)).b();
        if (!viewgroup.equals("New")) goto _L6; else goto _L5
_L5:
        view = a().getString(0x7f070524);
_L9:
        textview.setText(view);
        if (imageview != null)
        {
            b.a(((com.cyberlink.youcammakeup.database.more.makeup.a) (obj)), imageview);
        }
_L2:
        return view1;
_L6:
        view = viewgroup;
        if (viewgroup.equals("Top"))
        {
            view = a().getString(0x7f07052c);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        k /= h;
        if (!((u)g.get(k)).a()) goto _L2; else goto _L7
_L7:
        a((u)g.get(k));
        return view1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int k, int l)
    {
        return false;
    }

    public void notifyDataSetChanged()
    {
        ((ExtraDownloadCategoryActivity)a).k();
        super.notifyDataSetChanged();
    }
}
