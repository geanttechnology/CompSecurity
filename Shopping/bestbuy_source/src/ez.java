// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bestbuy.android.api.lib.models.product.ProductOffer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class ez extends ArrayAdapter
{

    private ArrayList a;
    private LayoutInflater b;

    public ez(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i, arraylist);
        a = arraylist;
        b = activity.getLayoutInflater();
    }

    public int a(ProductOffer productoffer)
    {
        return a.indexOf(productoffer);
    }

    public int getCount()
    {
        return a.size();
    }

    public int getPosition(Object obj)
    {
        return a((ProductOffer)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view = new fa();
            view1 = b.inflate(0x7f0300d6, viewgroup, false);
            view.a = (BBYTextView)view1.findViewById(0x7f0c0353);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (fa)view.getTag();
            view1 = view;
        }
        ((fa) (viewgroup)).a.setText(((ProductOffer)a.get(i)).getName());
        return view1;
    }
}
