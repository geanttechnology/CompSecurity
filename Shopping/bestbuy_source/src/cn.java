// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.bestbuy.android.api.lib.models.registry.AliasesList;
import java.util.ArrayList;
import java.util.List;

public class cn extends ArrayAdapter
{

    public List a;
    Activity b;

    public cn(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i);
        b = activity;
        a = arraylist;
    }

    public int getCount()
    {
        return a.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        AliasesList aliaseslist;
        if (view == null)
        {
            view = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(0x7f030007, viewgroup, false);
            viewgroup = new co();
            viewgroup.a = (TextView)view.findViewById(0x7f0c004b);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (co)view.getTag();
        }
        aliaseslist = (AliasesList)a.get(i);
        ((co) (viewgroup)).a.setText(aliaseslist.getDescription());
        return view;
    }
}
