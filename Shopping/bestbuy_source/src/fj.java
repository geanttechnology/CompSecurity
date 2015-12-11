// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bestbuy.android.api.lib.models.dnm.DNMSortOption;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.List;

public class fj extends ArrayAdapter
{

    private List a;
    private LayoutInflater b;
    private String c;

    public fj(Activity activity, int i, List list, String s)
    {
        super(activity, i, list);
        a = list;
        c = s;
        b = activity.getLayoutInflater();
    }

    public int a(DNMSortOption dnmsortoption)
    {
        return a.indexOf(dnmsortoption);
    }

    public void a(String s)
    {
        c = s;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return a.size();
    }

    public int getPosition(Object obj)
    {
        return a((DNMSortOption)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            fk fk1 = new fk();
            view = b.inflate(0x7f0300c2, viewgroup, false);
            fk1.a = (BBYTextView)view.findViewById(0x7f0c0315);
            fk1.b = (ImageView)view.findViewById(0x7f0c0316);
            view.setTag(fk1);
            viewgroup = fk1;
        } else
        {
            viewgroup = (fk)view.getTag();
        }
        ((fk) (viewgroup)).a.setText(((DNMSortOption)a.get(i)).getDisplayName());
        if (c.equals(((DNMSortOption)a.get(i)).getDisplayName()))
        {
            ((fk) (viewgroup)).b.setVisibility(0);
        }
        return view;
    }
}
