// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.am;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            c, h, f

public class a extends c
{

    private am e;

    public a(Context context, String s, am am1)
    {
        super(context, s);
        e = am1;
    }

    protected f a(BeautyMode beautymode)
    {
        return new h(a, beautymode, null, null);
    }

    public List a(int i)
    {
        return e.c(i);
    }

    public void a()
    {
        e.b();
    }

    public int getCount()
    {
        return e.a();
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
        view = (h)a(view, StatusManager.j().s());
        view.setColors(a(i));
        return view;
    }
}
