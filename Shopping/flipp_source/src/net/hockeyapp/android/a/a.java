// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.hockeyapp.android.c.c;

public final class a extends BaseAdapter
{

    public ArrayList a;
    private Context b;
    private SimpleDateFormat c;
    private SimpleDateFormat d;
    private Date e;
    private TextView f;
    private TextView g;
    private TextView h;

    public a(Context context, ArrayList arraylist)
    {
        b = context;
        a = arraylist;
        c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        d = new SimpleDateFormat("d MMM h:mm a");
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int i)
    {
        return a.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (c)a.get(i);
        if (view == null)
        {
            view = new net.hockeyapp.android.f.a(b);
        } else
        {
            view = (net.hockeyapp.android.f.a)view;
        }
        if (viewgroup != null)
        {
            f = (TextView)view.findViewById(12289);
            g = (TextView)view.findViewById(12290);
            h = (TextView)view.findViewById(12291);
            try
            {
                e = c.parse(((c) (viewgroup)).f);
                g.setText(d.format(e));
            }
            catch (ParseException parseexception)
            {
                parseexception.printStackTrace();
            }
            f.setText(((c) (viewgroup)).l);
            h.setText(((c) (viewgroup)).b);
        }
        if (i % 2 == 0)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        view.setFeedbackMessageViewBgAndTextColor(i);
        return view;
    }
}
