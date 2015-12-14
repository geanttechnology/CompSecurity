// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.socialin.android.util.Utils;
import java.util.ArrayList;

public final class d extends ArrayAdapter
{

    private int a[];
    private Context b;

    public d(Context context, ArrayList arraylist)
    {
        super(context, 0x7f030239, arraylist);
        a = null;
        a = null;
        b = context;
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        int j;
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(b).inflate(0x7f03024f, null);
            view.setEllipsize(android.text.TextUtils.TruncateAt.END);
        } else
        {
            view = (TextView)view;
        }
        j = (int)Utils.a(40F, b);
        viewgroup = view.getLayoutParams();
        if (viewgroup == null)
        {
            viewgroup = new android.widget.AbsListView.LayoutParams(-1, j);
        } else
        {
            viewgroup.width = -1;
            viewgroup.height = j;
        }
        view.setLayoutParams(viewgroup);
        view.setText((CharSequence)getItem(i));
        return view;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(b).inflate(0x7f0300e0, viewgroup, false);
            view.setClickable(false);
            return view;
        } else
        {
            return (TextView)view;
        }
    }
}
