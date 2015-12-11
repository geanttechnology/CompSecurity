// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class cw extends ArrayAdapter
{

    Activity a;
    private ArrayList b;
    private LayoutInflater c;

    public cw(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i);
        a = activity;
        b = arraylist;
        if (activity != null)
        {
            c = LayoutInflater.from(activity);
        }
    }

    public int getCount()
    {
        return b.size();
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = c.inflate(0x7f0300e1, viewgroup, false);
            view = new cx();
            view.a = (BBYTextView)view1.findViewById(0x7f0c0366);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (cx)view.getTag();
            view1 = view;
        }
        if (b != null)
        {
            ((cx) (viewgroup)).a.setText((String)b.get(i));
        }
        return view1;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
