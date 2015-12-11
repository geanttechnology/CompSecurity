// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

final class gb extends ArrayAdapter
    implements android.widget.AdapterView.OnItemClickListener
{

    private final LayoutInflater a;
    private fz b;

    public gb(fz fz1, Context context, List list)
    {
        b = fz1;
        super(context, 0, list);
        a = LayoutInflater.from(context);
    }

    public final boolean areAllItemsEnabled()
    {
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = a.inflate(0x7f040046, viewgroup, false);
        }
        view = (iz)getItem(i);
        Object obj = (TextView)view1.findViewById(0x1020014);
        viewgroup = (TextView)view1.findViewById(0x1020015);
        ((TextView) (obj)).setText(((iz) (view)).c);
        obj = ((iz) (view)).d;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            viewgroup.setVisibility(8);
            viewgroup.setText("");
        } else
        {
            viewgroup.setVisibility(0);
            viewgroup.setText(((CharSequence) (obj)));
        }
        view1.setEnabled(((iz) (view)).e);
        return view1;
    }

    public final boolean isEnabled(int i)
    {
        return ((iz)getItem(i)).e;
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (iz)getItem(i);
        if (((iz) (adapterview)).e)
        {
            adapterview.c();
            b.dismiss();
        }
    }
}
