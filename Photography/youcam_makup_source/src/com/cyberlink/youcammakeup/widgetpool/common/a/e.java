// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.ba;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            c, f, k

public class e extends c
{

    private List e;
    private List f;

    public e(Context context, String s, List list, List list1)
    {
        super(context, s);
        e = list;
        f = list1;
    }

    public at a(int i)
    {
        if (e != null)
        {
            e.get(i);
        }
        if (f != null)
        {
            f.get(i);
        }
        return null;
    }

    protected f a(BeautyMode beautymode)
    {
        return new f(a, beautymode);
    }

    public void a()
    {
        if (e != null)
        {
            e.clear();
        }
        if (f != null)
        {
            f.clear();
        }
    }

    public int getCount()
    {
        if (e != null)
        {
            return e.size();
        }
        if (f != null)
        {
            return f.size();
        } else
        {
            return 0;
        }
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
        viewgroup = StatusManager.j().s();
        view = a(view, viewgroup);
        if (e != null && e.size() > i)
        {
            at at1 = (at)e.get(i);
            if (at1 instanceof k)
            {
                view.b(true);
            } else
            {
                view.b(false);
                if (viewgroup == BeautyMode.y)
                {
                    view.a(d, VenusHelper.a().a(at1));
                } else
                {
                    view.setColor(at1);
                }
            }
        }
        if (f != null && f.size() > i)
        {
            viewgroup = (ba)f.get(i);
            view.setColor(viewgroup);
            view.setColorNumber(viewgroup.p());
            view.a(((ba)f.get(i)).q());
        }
        return view;
    }
}
