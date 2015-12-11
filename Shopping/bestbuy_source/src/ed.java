// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.List;

public class ed extends ArrayAdapter
{

    private List a;
    private LayoutInflater b;
    private Context c;
    private int d;

    public ed(Context context, int i, List list)
    {
        super(context, i, list);
        a = list;
        c = context;
        d = nf.a(context);
        b = LayoutInflater.from(context);
    }

    public int a(Category category)
    {
        return a.indexOf(category);
    }

    public Category a(int i)
    {
        return (Category)a.get(i);
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
        return a((Category)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Category category = a(i);
        View view1;
        if (view == null)
        {
            view1 = b.inflate(0x7f030018, viewgroup, false);
            view = new ee();
            view.a = (BBYTextView)view1.findViewById(0x7f0c0070);
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (ee)view.getTag();
            view1 = view;
        }
        if (d > 600)
        {
            i = 26;
        } else
        {
            i = 17;
        }
        if (!category.getWidgetType().equalsIgnoreCase("group"))
        {
            ((ee) (viewgroup)).a.setTextColor(getContext().getResources().getColor(0x7f0b0000));
            ((ee) (viewgroup)).a.setTextAppearance(c, 0x7f0e0037);
            ((ee) (viewgroup)).a.setBackgroundColor(getContext().getResources().getColor(0x7f0b0036));
            ((ee) (viewgroup)).a.setPadding(nf.b(10F, c), nf.b(i, c), nf.b(10F, c), nf.b(i, c));
            if (d > 600)
            {
                ((ee) (viewgroup)).a.setTextSize(2, 19F);
            } else
            {
                ((ee) (viewgroup)).a.setTextSize(2, 16F);
            }
        }
        ((ee) (viewgroup)).a.setText(category.getName());
        if (category.getWidgetType().equalsIgnoreCase("group"))
        {
            ((ee) (viewgroup)).a.setText(category.getName().toUpperCase());
            ((ee) (viewgroup)).a.setTextColor(getContext().getResources().getColor(0x7f0b0006));
            ((ee) (viewgroup)).a.setTextAppearance(c, 0x7f0e003f);
            ((ee) (viewgroup)).a.setBackgroundColor(getContext().getResources().getColor(0x7f0b0009));
            ((ee) (viewgroup)).a.setPadding(nf.b(10F, c), nf.b(3F, c), nf.b(10F, c), nf.b(3F, c));
        }
        return view1;
    }
}
