// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            fc, he, gb

public final class fd extends fc
{

    private Object k;
    private PopupWindow l;
    private boolean m;

    fd(Context context, gb.a a1, he he1, fb.a a2)
    {
        super(context, a1, he1, a2);
        k = new Object();
        m = false;
    }

    private void d()
    {
        synchronized (k)
        {
            m = true;
            if ((c instanceof Activity) && ((Activity)c).isDestroyed())
            {
                l = null;
            }
            if (l != null)
            {
                if (l.isShowing())
                {
                    l.dismiss();
                }
                l = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void a(gb gb)
    {
        d();
        super.a(gb);
    }

    public final void b()
    {
        d();
        super.b();
    }

    protected final void c()
    {
        FrameLayout framelayout;
        if (c instanceof Activity)
        {
            obj = ((Activity)c).getWindow();
        } else
        {
            obj = null;
        }
        while (obj == null || ((Window) (obj)).getDecorView() == null || ((Activity)c).isDestroyed()) 
        {
            return;
        }
        framelayout = new FrameLayout(c);
        framelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        framelayout.addView(d.getWebView(), -1, -1);
        synchronized (k)
        {
            if (!m)
            {
                break MISSING_BLOCK_LABEL_108;
            }
        }
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        l = new PopupWindow(framelayout, 1, 1, false);
        l.setOutsideTouchable(true);
        l.setClippingEnabled(false);
        com.google.android.gms.ads.internal.util.client.b.a(3);
        l.showAtLocation(((Window) (obj)).getDecorView(), 0, -1, -1);
_L1:
        obj1;
        JVM INSTR monitorexit ;
        return;
        obj;
        l = null;
          goto _L1
    }
}
