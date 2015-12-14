// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photopage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.pages.librarypicker.PickedFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.a;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photopage:
//            b, PhotoView, a

public class c extends BaseAdapter
{

    private final PhotoView a;
    private final ArrayList b = new ArrayList();
    private final ThreadPoolExecutor c = Globals.d().h();
    private Long d;
    private final ExecutorService e = Executors.newFixedThreadPool(1);
    private final Activity f;

    public c(Activity activity, PhotoView photoview)
    {
        f = activity;
        a = photoview;
    }

    private b a(com.cyberlink.youcammakeup.pages.librarypicker.photopage.a a1)
    {
        b b1 = new b(a.getContext(), a1);
        b(b1, a1);
        (new a(b1, a1.b())).executeOnExecutor(c, new Void[0]);
        return b1;
    }

    static Long a(c c1, Long long1)
    {
        c1.d = long1;
        return long1;
    }

    static ArrayList a(c c1)
    {
        return c1.b;
    }

    static PhotoView b(c c1)
    {
        return c1.a;
    }

    private void b(b b1, com.cyberlink.youcammakeup.pages.librarypicker.photopage.a a1)
    {
        if (f != null && b1 != null && a1 != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = f.getFragmentManager().findFragmentById(0x7f0c0157)) != null && (obj instanceof PickedFragment))
        {
            b1.a(false);
            obj = (PickedFragment)obj;
            a1 = com.cyberlink.youcammakeup.c.f().a(a1.b());
            if (a1 != null)
            {
                Long along[] = ((PickedFragment) (obj)).b();
                int j = along.length;
                int i = 0;
                while (i < j) 
                {
                    Long long1 = along[i];
                    if (long1 == null || com.cyberlink.youcammakeup.c.f().a(long1.longValue()).longValue() != a1.longValue())
                    {
                        i++;
                    } else
                    {
                        b1.a(true);
                        return;
                    }
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public com.cyberlink.youcammakeup.pages.librarypicker.photopage.a a(int i)
    {
        return (com.cyberlink.youcammakeup.pages.librarypicker.photopage.a)b.get(i);
    }

    public void a(long l, int i)
    {
        (new AsyncTask(l, i) {

            final long a;
            final int b;
            final c c;

            protected transient ArrayList a(Void avoid[])
            {
                avoid = new ArrayList();
                long al[] = com.cyberlink.youcammakeup.c.c().b(a);
                int k = al.length;
                for (int j = 0; j < k; j++)
                {
                    avoid.add(new com.cyberlink.youcammakeup.pages.librarypicker.photopage.a(-1L, al[j]));
                }

                return avoid;
            }

            protected void a(ArrayList arraylist)
            {
                com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.a(c, Long.valueOf(a));
                com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.a(c).clear();
                com.cyberlink.youcammakeup.pages.librarypicker.photopage.c.a(c).addAll(arraylist);
                c.notifyDataSetChanged();
                c.b(c).setSelection(b);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((ArrayList)obj);
            }

            
            {
                c = c.this;
                a = l;
                b = i;
                super();
            }
        }).executeOnExecutor(e, new Void[0]);
    }

    public void a(b b1, com.cyberlink.youcammakeup.pages.librarypicker.photopage.a a1)
    {
        com.cyberlink.youcammakeup.pages.librarypicker.photopage.a a2 = b1.getItem();
        b(b1, a1);
        if (a2.b() == a1.b() && (a2.c() == com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.b || a2.c() == com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.a))
        {
            return;
        } else
        {
            b1.a(a1);
            (new a(b1, a1.b())).executeOnExecutor(c, new Void[0]);
            return;
        }
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return a(i).b();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = a(i);
        view = (b)view;
        if (view == null)
        {
            return a(viewgroup);
        } else
        {
            a(view, viewgroup);
            return view;
        }
    }
}
