// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.albumpage;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.b;
import com.cyberlink.youcammakeup.pages.librarypicker.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.albumpage:
//            b, a

public class c extends BaseAdapter
{

    private final Context a;
    private final ArrayList b = new ArrayList();
    private final ThreadPoolExecutor c = Globals.d().h();
    private final ExecutorService d = Executors.newFixedThreadPool(1);

    public c(Context context)
    {
        a = context;
    }

    private com.cyberlink.youcammakeup.pages.librarypicker.albumpage.b a(com.cyberlink.youcammakeup.pages.librarypicker.albumpage.a a1)
    {
        com.cyberlink.youcammakeup.pages.librarypicker.albumpage.b b1 = new com.cyberlink.youcammakeup.pages.librarypicker.albumpage.b(a, a1);
        (new a(b1, a1.b())).executeOnExecutor(c, new Void[0]);
        return b1;
    }

    static ArrayList a(c c1)
    {
        return c1.b;
    }

    public com.cyberlink.youcammakeup.pages.librarypicker.albumpage.a a(int i)
    {
        return (com.cyberlink.youcammakeup.pages.librarypicker.albumpage.a)b.get(i);
    }

    public void a()
    {
        (new AsyncTask() {

            final c a;

            protected transient ArrayList a(Void avoid[])
            {
                avoid = new ArrayList();
                for (Iterator iterator = com.cyberlink.youcammakeup.c.c().a(true).iterator(); iterator.hasNext(); avoid.add(new com.cyberlink.youcammakeup.pages.librarypicker.albumpage.a((b)iterator.next()))) { }
                return avoid;
            }

            protected void a(ArrayList arraylist)
            {
                com.cyberlink.youcammakeup.pages.librarypicker.albumpage.c.a(a).clear();
                com.cyberlink.youcammakeup.pages.librarypicker.albumpage.c.a(a).addAll(arraylist);
                a.notifyDataSetChanged();
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
                a = c.this;
                super();
            }
        }).executeOnExecutor(d, new Void[0]);
    }

    public void a(com.cyberlink.youcammakeup.pages.librarypicker.albumpage.b b1, com.cyberlink.youcammakeup.pages.librarypicker.albumpage.a a1)
    {
        com.cyberlink.youcammakeup.pages.librarypicker.albumpage.a a2 = b1.getItem();
        if (a2.b() == a1.b() && a2.g() == a1.g() && (a2.c() == com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.b || a2.c() == com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.a))
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
        return a(i).e();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = a(i);
        view = (com.cyberlink.youcammakeup.pages.librarypicker.albumpage.b)view;
        if (view == null)
        {
            view = a(viewgroup);
        } else
        {
            a(view, viewgroup);
        }
        if (i == getCount() - 1)
        {
            i = 4;
        } else
        {
            i = 0;
        }
        view.setDividerVisibility(i);
        return view;
    }
}
