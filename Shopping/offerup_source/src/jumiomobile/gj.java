// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.jumio.netverify.sdk.core.vo.Country;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package jumiomobile:
//            bg, mf, gk

public class gj extends BaseAdapter
    implements ListAdapter, SectionIndexer
{

    private Activity a;
    private SparseArray b;
    private String c;
    private List d;
    private List e;
    private android.graphics.BitmapFactory.Options f;
    private android.view.View.OnClickListener g;

    public gj(Activity activity, List list)
    {
        c = "";
        f = null;
        a = activity;
        e = list;
        d = b("");
        b();
    }

    private List b(String s)
    {
        if (s != null)
        {
            Locale locale = Locale.getDefault();
            s = s.toUpperCase(locale);
            ArrayList arraylist = new ArrayList();
            Iterator iterator = e.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Country country = (Country)iterator.next();
                if (country.c().toUpperCase(locale).indexOf(s) >= 0)
                {
                    arraylist.add(country);
                }
            } while (true);
            d = arraylist;
        }
        return d;
    }

    private void b()
    {
        int j = d.size();
        b = new SparseArray();
        int i = 0;
        while (i < j) 
        {
            String s1 = ((Country)d.get(i)).c().substring(0, 1);
            String s;
            if (s1.compareToIgnoreCase("\304") == 0)
            {
                s = "A";
            } else
            if (s1.compareToIgnoreCase("\305") == 0)
            {
                s = "A";
            } else
            if (s1.compareToIgnoreCase("\334") == 0)
            {
                s = "U";
            } else
            {
                s = s1;
                if (s1.compareToIgnoreCase("\326") == 0)
                {
                    s = "O";
                }
            }
            if (c(s) < 0)
            {
                b.append(b.size() + i, s);
            }
            i++;
        }
        b.size();
    }

    private int c(String s)
    {
        int j = -1;
        for (int i = 0; i < b.size(); i++)
        {
            if (((String)b.get(b.keyAt(i))).equals(s))
            {
                j = i;
            }
        }

        return j;
    }

    public void a()
    {
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        g = onclicklistener;
    }

    public void a(String s)
    {
        if (!c.equals(s))
        {
            c = s;
            d = b(s);
            b();
            notifyDataSetChanged();
        }
    }

    public int getCount()
    {
        return d.size() + b.size();
    }

    public Object getItem(int i)
    {
        return d.get(i - getSectionForPosition(i) - 1);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return b.indexOfKey(i) >= 0 ? 0 : 1;
    }

    public int getPositionForSection(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        i = j;
        if (j > b.size() - 1)
        {
            i = b.size() - 1;
        }
        return b.keyAt(i);
    }

    public int getSectionForPosition(int i)
    {
        int k;
        for (int j = 0; j < b.size(); j++)
        {
            int l = b.keyAt(j);
            if (j + 1 < b.size())
            {
                k = b.keyAt(j + 1);
            } else
            {
                k = getCount();
            }
            if (i >= l && i < k)
            {
                return j;
            }
        }

        return -1;
    }

    public Object[] getSections()
    {
        String as[] = new String[b.size()];
        for (int i = 0; i < b.size(); i++)
        {
            as[i] = (String)b.valueAt(i);
        }

        return as;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (getItemViewType(i) == 0)
        {
            if (view == null || (view instanceof RelativeLayout))
            {
                int j = (int)bg.a(a, 10F);
                view = new TextView(a);
                view.setPadding(j, j / 2, j, j / 2);
                view.setTypeface(Typeface.DEFAULT_BOLD);
                view.setTextColor(0xff333333);
            } else
            {
                view = (TextView)view;
            }
            view.setText((CharSequence)b.valueAt(getSectionForPosition(i)));
            view1 = view;
        } else
        {
            Country country;
            if (view == null || (view instanceof TextView))
            {
                view = mf.c(a);
                viewgroup = new gk(this);
                viewgroup.b = (TextView)view.findViewById(mf.i);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (gk)view.getTag();
            }
            view.setOnClickListener(g);
            country = (Country)getItem(i);
            view1 = view;
            if (country != null)
            {
                ((gk) (viewgroup)).b.setText(country.c());
                if (f == null)
                {
                    f = new android.graphics.BitmapFactory.Options();
                    f.inJustDecodeBounds = true;
                    i = (int)Math.ceil((float)f.outWidth / bg.a(a, 30F));
                    if (i > 1)
                    {
                        f.inSampleSize = i;
                    }
                    f.inJustDecodeBounds = false;
                }
                viewgroup.a = country;
                return view;
            }
        }
        return view1;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }
}
