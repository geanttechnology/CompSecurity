// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.MeTabItem;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            MeTabScrollView

public class j extends LinearLayout
{

    final MeTabScrollView a;
    private TextView b;
    private TextView c;
    private MeTabItem d;

    public j(MeTabScrollView metabscrollview, Context context, int i)
    {
        a = metabscrollview;
        super(context);
        a(context, i);
    }

    private void a()
    {
        if (d != null)
        {
            if (d.count != null && b != null)
            {
                b.setText(String.valueOf(d.count));
            }
            int i;
            if (d.count != null)
            {
                i = d.count.intValue();
            } else
            {
                i = 0;
            }
            if (c != null)
            {
                c.setText(getResources().getQuantityString(d.fieldNameRes, i));
            }
        }
    }

    private void a(Context context, int i)
    {
        setBackgroundResource(i);
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        context.inflate(k.bc_widget_tab_count, this);
        context.inflate(k.bc_widget_tab_name, this);
        b = (TextView)findViewById(com.cyberlink.beautycircle.j.tab_status_number);
        c = (TextView)findViewById(com.cyberlink.beautycircle.j.tab_status_fieldname);
    }

    static void a(j j1)
    {
        j1.a();
    }

    public MeTabItem getItem()
    {
        return d;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    public void setItem(MeTabItem metabitem)
    {
        d = metabitem;
        a();
    }
}
