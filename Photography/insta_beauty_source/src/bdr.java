// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.instamag.activity.library.model.TFilterMenuItemType;
import com.instamag.activity.library.view.LibraryFilterMenuItemView;
import com.instamag.activity.library.view.LibraryFilterMenuView;
import java.util.ArrayList;
import java.util.List;

public class bdr extends BaseAdapter
{

    final LibraryFilterMenuView a;
    private List b;
    private TFilterMenuItemType c;
    private int d;

    public bdr(LibraryFilterMenuView libraryfiltermenuview)
    {
        a = libraryfiltermenuview;
        super();
        b = new ArrayList();
        d = 0;
    }

    public void a(int i)
    {
        d = i;
        notifyDataSetChanged();
    }

    public void a(List list, TFilterMenuItemType tfiltermenuitemtype)
    {
        b = list;
        c = tfiltermenuitemtype;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (b != null)
        {
            return b.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (b != null && i < b.size())
        {
            return b.get(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = new LibraryFilterMenuItemView(a.getContext());
        }
        ((LibraryFilterMenuItemView)view).setLisener(a.lisener, c, i);
        if (i < b.size())
        {
            ((LibraryFilterMenuItemView)view).setDisplayText((String)b.get(i));
            viewgroup = (LibraryFilterMenuItemView)view;
            boolean flag;
            if (i == d)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            viewgroup.setSelected(flag);
        }
        return view;
    }
}
