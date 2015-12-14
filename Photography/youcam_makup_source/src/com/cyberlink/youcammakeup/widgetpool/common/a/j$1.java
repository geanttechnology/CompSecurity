// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            j, i

class b extends AsyncTask
{

    BeautyMode a;
    final j b;

    protected transient Void a(Void avoid[])
    {
        avoid = b.f();
        b.d(a);
        if (b.g != null)
        {
            com.cyberlink.youcammakeup.database.more.i.d d = h.b().a(b.g.b(), b.g.a());
            b.k = new i(b.getActivity(), avoid, b.l, d);
            return null;
        } else
        {
            b.k = new i(b.getActivity(), avoid, b.l, null);
            return null;
        }
    }

    protected void a(Void void1)
    {
        b.j.setAlpha(0.0F);
        b.j.setVisibility(0);
        b.j.setAdapter(b.k);
        b.j.animate().alpha(1.0F);
        if (b.m != null)
        {
            b.a(b.m, true);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        a = StatusManager.j().s();
        b.j.setVisibility(8);
        if (a == null || a == BeautyMode.D)
        {
            return;
        }
        if (a == BeautyMode.s || a == BeautyMode.x)
        {
            b.a.setBackgroundColor(0);
            return;
        } else
        {
            b.a.setBackgroundColor(Color.parseColor("#FFE1E1E1"));
            return;
        }
    }

    Manager(j j1)
    {
        b = j1;
        super();
    }
}
