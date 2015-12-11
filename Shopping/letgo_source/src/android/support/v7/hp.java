// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.Category;
import java.util.List;

public class hp extends BaseAdapter
    implements SpinnerAdapter
{

    private LayoutInflater a;
    private List b;

    public hp(Context context, List list)
    {
        a = LayoutInflater.from(context);
        b = list;
    }

    public Category a(int i)
    {
        return (Category)b.get(i);
    }

    public int getCount()
    {
        return b.size();
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = a.inflate(0x7f040031, viewgroup, false);
        ((TextView)view.findViewById(0x7f1000ec)).setText(((Category)b.get(i)).getName());
        return view;
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = a.inflate(0x7f04002d, viewgroup, false);
        ((TextView)view.findViewById(0x7f1000ec)).setText(((Category)b.get(i)).getName());
        return view;
    }
}
