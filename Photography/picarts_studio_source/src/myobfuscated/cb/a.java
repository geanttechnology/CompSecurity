// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// Referenced classes of package myobfuscated.cb:
//            c

public final class a extends ArrayAdapter
{

    public ArrayList a;
    ListView b;
    public int c;
    private Context d;
    private d e;

    public a(Context context, ListView listview)
    {
        super(context, -1);
        d = null;
        a = new ArrayList();
        c = 0;
        d = context;
        b = listview;
        e = new d(context);
    }

    static Context a(a a1)
    {
        return a1.d;
    }

    public final c a(int i)
    {
        return (c)a.get(i);
    }

    public final void a()
    {
        sort(new Comparator() {

            private a a;

            public final int compare(Object obj, Object obj1)
            {
                obj = (c)obj;
                obj1 = (c)obj1;
                if (!((c) (obj)).e.equals(a.a(a).getResources().getString(0x7f0800ae))) goto _L2; else goto _L1
_L1:
                return -1;
_L2:
                if (((c) (obj1)).e.equals(a.a(a).getResources().getString(0x7f0800ae)))
                {
                    return 1;
                }
                if (((c) (obj)).e.equals(a.a(a).getResources().getString(0x7f0800b5))) goto _L1; else goto _L3
_L3:
                if (((c) (obj1)).e.equals(a.a(a).getResources().getString(0x7f0800b5)))
                {
                    return 1;
                }
                if (!((c) (obj)).o || !((c) (obj1)).o)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (((c) (obj)).k == null && ((c) (obj1)).k == null || ((c) (obj)).k != null && ((c) (obj1)).k != null)
                {
                    return 0;
                }
                if (((c) (obj)).k != null) goto _L1; else goto _L4
_L4:
                return 1;
                if (((c) (obj)).o) goto _L1; else goto _L5
_L5:
                return !((c) (obj1)).o ? 0 : 1;
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    public final void a(c c1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            c c2 = (c)iterator.next();
            if (c2.e != null && c2.e.equals(c1.e))
            {
                return;
            }
        }

        a.add(c1);
        c1.y = new WeakReference(this);
    }

    public final boolean areAllItemsEnabled()
    {
        return true;
    }

    public final void clear()
    {
        super.clear();
        a.clear();
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int i)
    {
        return a(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        c c1 = (c)a.get(i);
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(d).inflate(0x7f030060, viewgroup, false);
        }
        view = a.iterator();
        do
        {
            if (!view.hasNext())
            {
                break;
            }
            viewgroup = (c)view.next();
            View view2 = viewgroup.a();
            if (view2 != null && view2 == view1)
            {
                viewgroup.a(null);
            }
        } while (true);
        c1.a(view1);
        ((TextView)view1.findViewById(0x7f10027b)).setText(c1.e);
        if (c1.w == 0)
        {
            view1.findViewById(0x7f10027c).setVisibility(8);
        } else
        {
            view = (TextView)view1.findViewById(0x7f10027c);
            view.setVisibility(0);
            view.setText(c1.n);
        }
        view = (ImageView)view1.findViewById(0x7f100279);
        if (c1.f != null)
        {
            view.setImageDrawable(c1.f);
        } else
        if (c1.g != null)
        {
            e.a(c1.g, view, (e)com.bumptech.glide.request.e.b(l.e).a(0x7f0206c6));
        }
        if (c == i)
        {
            view1.setBackgroundResource(0x7f02055a);
        } else
        {
            view1.setBackgroundResource(0x7f02055b);
        }
        view = (ImageView)view1.findViewById(0x7f10027d);
        if (c1.o)
        {
            view.setVisibility(8);
            return view1;
        }
        if (!c1.o && c1.r || c1.p.data.price == 0)
        {
            view.setVisibility(0);
            view.setImageResource(0x7f0201a8);
            return view1;
        } else
        {
            view.setVisibility(0);
            view.setImageResource(0x7f020568);
            return view1;
        }
    }

    public final void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    public final void sort(Comparator comparator)
    {
        super.sort(comparator);
        Collections.sort(a, comparator);
    }
}
