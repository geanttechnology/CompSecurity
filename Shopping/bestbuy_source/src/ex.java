// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bestbuy.android.api.lib.models.solr.SortOption;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.List;

public class ex extends ArrayAdapter
{

    private List a;
    private LayoutInflater b;
    private String c;

    public ex(Activity activity, int i, List list, String s)
    {
        super(activity, i, list);
        a = list;
        c = s;
        b = activity.getLayoutInflater();
    }

    public int a(SortOption sortoption)
    {
        return a.indexOf(sortoption);
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
        return a((SortOption)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = new ey();
        viewgroup = b.inflate(0x7f0300c2, viewgroup, false);
        view.a = (BBYTextView)viewgroup.findViewById(0x7f0c0315);
        view.b = (ImageView)viewgroup.findViewById(0x7f0c0316);
        ((ey) (view)).a.setText(((SortOption)a.get(i)).getDisplayName());
        if (c.equals(((SortOption)a.get(i)).getDisplayName()))
        {
            ((ey) (view)).b.setVisibility(0);
        }
        return viewgroup;
    }
}
