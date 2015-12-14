// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import java.util.ArrayList;
import java.util.List;

public class n extends BaseAdapter
{

    protected BeautyMode a;
    protected List b;
    protected int c;
    protected ag d;
    private Context e;

    public n(Context context, BeautyMode beautymode)
    {
        c = 0;
        e = context;
        a = beautymode;
        b = new ArrayList();
        d = new ag(context);
        beautymode = new k(context, null);
        beautymode.g = false;
        beautymode.a(0.15F);
        d.a(((Activity)context).getFragmentManager(), beautymode);
        a();
    }

    public p a(int i)
    {
        if (i < 0 || i >= b.size())
        {
            return null;
        } else
        {
            return (p)b.get(i);
        }
    }

    protected void a()
    {
        PanelDataCenter paneldatacenter = PanelDataCenter.a();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(paneldatacenter.c(a, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a));
        arraylist.addAll(paneldatacenter.c(a, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b));
        for (int i = 0; i < arraylist.size(); i++)
        {
            ax ax1 = PanelDataCenter.a().p((String)arraylist.get(i));
            if (ax1 != null)
            {
                b.add(new p(ax1.c(), ax1.a(), ax1.d(), ax1.e().booleanValue(), ax1.i()));
            }
        }

    }

    public void a(int i, boolean flag)
    {
        p p1 = a(i);
        p1.e = flag;
        if (p1.d != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
        {
            return;
        } else
        {
            PanelDataCenter.a().p(p1.c).a(Boolean.valueOf(flag));
            return;
        }
    }

    public int b()
    {
        return c;
    }

    public void b(int i)
    {
        if (i < 0 || i >= getCount())
        {
            c = -1;
            return;
        } else
        {
            c = i;
            return;
        }
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (TemplateButton)view;
        } else
        {
            view = new TemplateButton(e, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton.LayoutType.b, a, true);
        }
        view.setTag(Integer.valueOf(i));
        view.a(d, a(i).b);
        view.a(a(i).e);
        view.d(false);
        view.c(false);
        view.e(false);
        return view;
    }
}
