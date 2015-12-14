// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends BaseAdapter
{

    protected List a;
    protected h b;
    protected ag c;
    protected int d;

    a(Context context, String s)
    {
        a = null;
        b = null;
        c = null;
        a = new ArrayList();
        b = h.b();
        d = -1;
        Iterator iterator = b.b("eye_shadow").iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (Long)iterator.next();
            obj = b.a("eye_shadow", ((Long) (obj)));
            if (((d) (obj)).e().equals(s))
            {
                a.add(obj);
            }
        } while (true);
        c = new ag(context);
        s = new k(context, null);
        s.g = false;
        s.a(0.15F);
        c.a(((Activity)context).getFragmentManager(), s);
    }

    public d a(int i)
    {
        return (d)a.get(i);
    }

    public void b(int i)
    {
        d = i;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return a.size();
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
        d d1 = a(i);
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301fc, viewgroup, false);
        }
        view = (ImageView)view1.findViewById(0x7f0c08cb);
        viewgroup = (TextView)view1.findViewById(0x7f0c08cd);
        View view2 = view1.findViewById(0x7f0c08cc);
        String s = SkuTemplateUtils.a(d1.d(), "eye_shadow");
        c.a(s, view);
        viewgroup.setText(d1.c());
        boolean flag;
        if (i == d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view2.setSelected(flag);
        return view1;
    }
}
