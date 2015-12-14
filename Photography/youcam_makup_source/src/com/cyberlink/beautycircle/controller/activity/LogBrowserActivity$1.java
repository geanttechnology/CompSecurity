// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.g;
import java.io.File;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            LogBrowserActivity

class a extends ArrayAdapter
{

    final LogBrowserActivity a;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x1090003, new LinearLayout(getContext()));
            view = (TextView)view1.findViewById(0x1020014);
            view.setTextColor(a.getResources().getColor(g.bc_color_black));
            view1.setTag(view);
            viewgroup = view;
        } else
        {
            viewgroup = (TextView)view.getTag();
            view1 = view;
        }
        viewgroup.setText(((File)getItem(i)).getName());
        return view1;
    }

    I(LogBrowserActivity logbrowseractivity, Context context, int i, File afile[])
    {
        a = logbrowseractivity;
        super(context, i, afile);
    }
}
