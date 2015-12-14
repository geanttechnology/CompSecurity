// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fotoable.beautyui.SlideSwitch;
import java.util.ArrayList;
import java.util.HashMap;

public class so extends BaseAdapter
{

    Context a;
    ArrayList b;
    sr c;

    public so(ArrayList arraylist, Context context, sr sr)
    {
        b = arraylist;
        a = context;
        c = sr;
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(a).inflate(0x7f03005b, null);
            viewgroup = new sq(this, null);
            sq.a(viewgroup, (TextView)view.findViewById(0x7f0d0200));
            sq.a(viewgroup, (SlideSwitch)view.findViewById(0x7f0d0201));
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (sq)view.getTag();
        }
        sq.a(viewgroup).setText((String)((HashMap)b.get(i)).get("itemContentText"));
        sq.b(viewgroup).setState(((Boolean)((HashMap)b.get(i)).get("itemIsChecked")).booleanValue(), false);
        sq.b(viewgroup).setSlideListener(new sp(this, i));
        return view;
    }
}
