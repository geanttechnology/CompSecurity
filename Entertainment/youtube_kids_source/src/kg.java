// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import java.util.ArrayList;

class kg extends kc
    implements jh
{

    private jg o;
    private jj p;

    public kg(Context context, kl kl)
    {
        super(context, kl);
    }

    protected void a(ke ke1, ig ig1)
    {
        super.a(ke1, ig1);
        if (!((android.media.MediaRouter.RouteInfo)ke1.a).isEnabled())
        {
            ig1.a(false);
        }
        if (a(ke1))
        {
            ig1.a.putBoolean("connecting", true);
        }
        ke1 = ((android.media.MediaRouter.RouteInfo)ke1.a).getPresentationDisplay();
        if (ke1 != null)
        {
            ig1.f(ke1.getDisplayId());
        }
    }

    protected boolean a(ke ke1)
    {
        if (p == null)
        {
            p = new jj();
        }
        return p.a(ke1.a);
    }

    protected void b()
    {
        jg jg1;
        super.b();
        if (o == null)
        {
            o = new jg(super.a, super.c);
        }
        jg1 = o;
        int i;
        if (l)
        {
            i = k;
        } else
        {
            i = 0;
        }
        if ((i & 2) == 0) goto _L2; else goto _L1
_L1:
        if (jg1.c) goto _L4; else goto _L3
_L3:
        if (jg1.b == null) goto _L6; else goto _L5
_L5:
        jg1.c = true;
        jg1.a.post(jg1);
_L4:
        return;
_L6:
        Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
        return;
_L2:
        if (jg1.c)
        {
            jg1.c = false;
            jg1.a.removeCallbacks(jg1);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    protected final Object c()
    {
        return new ji(this);
    }

    public final void f(Object obj)
    {
        int i = g(obj);
        if (i >= 0)
        {
            ke ke1 = (ke)n.get(i);
            obj = ((android.media.MediaRouter.RouteInfo)obj).getPresentationDisplay();
            if (obj != null)
            {
                i = ((Display) (obj)).getDisplayId();
            } else
            {
                i = -1;
            }
            if (i != ke1.c.m())
            {
                ke1.c = (new ig(ke1.c)).f(i).a();
                a();
            }
        }
    }
}
