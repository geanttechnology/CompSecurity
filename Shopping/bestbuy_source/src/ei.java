// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bestbuy.android.api.lib.models.pdp.ContractOption;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class ei extends ArrayAdapter
{

    private ArrayList a;
    private LayoutInflater b;
    private boolean c;

    public ei(Context context, int i, ArrayList arraylist, boolean flag)
    {
        super(context, i, arraylist);
        a = arraylist;
        c = flag;
        b = LayoutInflater.from(context);
    }

    public int a(ContractOption contractoption)
    {
        return a.indexOf(contractoption);
    }

    public ContractOption a(int i)
    {
        return (ContractOption)a.get(i);
    }

    public int getCount()
    {
        return a.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public int getPosition(Object obj)
    {
        return a((ContractOption)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ContractOption contractoption;
        if (view == null)
        {
            view = b.inflate(0x7f030093, viewgroup, false);
            viewgroup = new ej();
            viewgroup.a = (BBYTextView)view.findViewById(0x7f0c0070);
            viewgroup.b = (BBYTextView)view.findViewById(0x7f0c0243);
            viewgroup.c = (ImageView)view.findViewById(0x7f0c004c);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ej)view.getTag();
        }
        contractoption = a(i);
        ((ej) (viewgroup)).a.setText(contractoption.getType());
        if (c)
        {
            ((ej) (viewgroup)).c.setVisibility(8);
            ((ej) (viewgroup)).b.setVisibility(0);
            ((ej) (viewgroup)).b.setText(contractoption.getPrice());
            return view;
        } else
        {
            ((ej) (viewgroup)).c.setVisibility(0);
            ((ej) (viewgroup)).b.setVisibility(8);
            return view;
        }
    }
}
