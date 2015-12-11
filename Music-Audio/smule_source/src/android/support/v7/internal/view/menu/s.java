// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            r, MenuBuilder, j, ListMenuItemView

class s extends BaseAdapter
{

    final r a;
    private MenuBuilder b;
    private int c;

    public s(r r1, MenuBuilder menubuilder)
    {
        a = r1;
        super();
        c = -1;
        b = menubuilder;
        a();
    }

    static MenuBuilder a(s s1)
    {
        return s1.b;
    }

    public j a(int i)
    {
        ArrayList arraylist;
        int k;
        if (r.access$100(a))
        {
            arraylist = b.l();
        } else
        {
            arraylist = b.i();
        }
        k = i;
        if (c >= 0)
        {
            k = i;
            if (i >= c)
            {
                k = i + 1;
            }
        }
        return (j)arraylist.get(k);
    }

    void a()
    {
        j j1 = r.access$300(a).r();
        if (j1 != null)
        {
            ArrayList arraylist = r.access$300(a).l();
            int k = arraylist.size();
            for (int i = 0; i < k; i++)
            {
                if ((j)arraylist.get(i) == j1)
                {
                    c = i;
                    return;
                }
            }

        }
        c = -1;
    }

    public int getCount()
    {
        ArrayList arraylist;
        if (r.access$100(a))
        {
            arraylist = b.l();
        } else
        {
            arraylist = b.i();
        }
        if (c < 0)
        {
            return arraylist.size();
        } else
        {
            return arraylist.size() - 1;
        }
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = r.access$200(a).inflate(r.ITEM_LAYOUT, viewgroup, false);
        }
        viewgroup = (MenuView.ItemView)view;
        if (a.mForceShowIcon)
        {
            ((ListMenuItemView)view).setForceShowIcon(true);
        }
        viewgroup.initialize(a(i), 0);
        return view;
    }

    public void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
