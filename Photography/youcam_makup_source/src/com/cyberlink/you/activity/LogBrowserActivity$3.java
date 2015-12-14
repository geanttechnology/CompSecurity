// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cyberlink.you.l;
import java.io.File;

// Referenced classes of package com.cyberlink.you.activity:
//            LogBrowserActivity

class a extends ArrayAdapter
{

    final LogBrowserActivity a;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x1090003, null);
            view = (TextView)view1.findViewById(0x1020014);
            view.setTextColor(a.a().getResources().getColor(l.you_color_normal));
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

    (LogBrowserActivity logbrowseractivity, Context context, int i, File afile[])
    {
        a = logbrowseractivity;
        super(context, i, afile);
    }
}
