// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestbuy.android.api.lib.models.registry.ListTypes;
import java.util.ArrayList;

public class cp extends ArrayAdapter
{

    ArrayList a;
    Activity b;

    public cp(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i, arraylist);
        b = activity;
        a = arraylist;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(0x7f030116, viewgroup, false);
            viewgroup = new cq();
            viewgroup.a = (TextView)view.findViewById(0x7f0c040d);
            viewgroup.b = (ImageView)view.findViewById(0x7f0c040c);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (cq)view.getTag();
        }
        ((cq) (viewgroup)).a.setText(((ListTypes)a.get(i)).getDescription());
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Back To School"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f020017);
            return view;
        }
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Holiday"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f0200e4);
            return view;
        }
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Birthday"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f020044);
            return view;
        }
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Anniversary"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f02000c);
            return view;
        }
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Graduation"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f0200df);
            return view;
        }
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Moving"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f02011a);
            return view;
        }
        if (((ListTypes)a.get(i)).getDescription().equalsIgnoreCase("Wedding"))
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f0201b7);
            return view;
        } else
        {
            ((cq) (viewgroup)).b.setImageResource(0x7f0200ab);
            return view;
        }
    }
}
