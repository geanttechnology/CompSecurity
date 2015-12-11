// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.e;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.be;
import com.google.android.gms.d.ci;
import com.google.android.gms.d.dg;
import com.google.android.gms.d.dh;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gn;
import com.google.android.gms.d.he;
import com.google.android.gms.d.hf;
import com.google.android.gms.d.hg;
import com.google.android.gms.d.x;

// Referenced classes of package com.google.android.gms.ads.internal:
//            c, q, p, o, 
//            InterstitialAdParameterParcel, d, e

public final class k extends c
    implements ci
{

    protected transient boolean i;

    public k(Context context, AdSizeParcel adsizeparcel, String s, dg dg, VersionInfoParcel versioninfoparcel, d d)
    {
        super(context, adsizeparcel, s, dg, versioninfoparcel, d);
        i = false;
    }

    private void A()
    {
        if (c.c())
        {
            c.a();
            c.j = null;
            c.E = false;
            i = false;
        }
    }

    private void a(Bundle bundle)
    {
        com.google.android.gms.ads.internal.p.e();
        gm.b(c.c, c.e.b, "gmob-apps", bundle, false);
    }

    protected final he a(com.google.android.gms.d.gb.a a1, com.google.android.gms.ads.internal.e e1)
    {
        com.google.android.gms.ads.internal.p.f();
        he he1 = hg.a(c.c, c.i, c.d, c.e, f);
        hf hf1 = he1.i();
        com.google.android.gms.d.au au = ay.S;
        hf1.a(this, null, this, this, ((Boolean)com.google.android.gms.ads.internal.p.n().a(au)).booleanValue(), this, this, e1, null);
        he1.b(a1.a.z);
        return he1;
    }

    public final boolean a(AdRequestParcel adrequestparcel, be be)
    {
        if (c.j != null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        } else
        {
            return super.a(adrequestparcel, be);
        }
    }

    protected final boolean a(AdRequestParcel adrequestparcel, gb gb1, boolean flag)
    {
        if (c.c() && gb1.b != null)
        {
            com.google.android.gms.ads.internal.p.g().a(gb1.b.getWebView());
        }
        return b.d;
    }

    public final boolean a(gb gb1, gb gb2)
    {
        if (!super.a(gb1, gb2))
        {
            return false;
        }
        if (!c.c() && c.B != null && gb2.j != null)
        {
            e.a(c.i, gb2, c.B);
        }
        return true;
    }

    public final void a_()
    {
        A();
        super.a_();
    }

    public final void b(boolean flag)
    {
        c.E = flag;
    }

    public final void b_()
    {
        q();
        super.b_();
    }

    public final void f()
    {
        w.b("showInterstitial must be called on the main UI thread.");
        if (c.j != null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.b.a(5);
_L4:
        return;
_L2:
        com.google.android.gms.d.au au = ay.ae;
        boolean flag;
        if (((Boolean)com.google.android.gms.ads.internal.p.n().a(au)).booleanValue())
        {
            Object obj;
            if (c.c.getApplicationContext() != null)
            {
                obj = c.c.getApplicationContext().getPackageName();
            } else
            {
                obj = c.c.getPackageName();
            }
            if (!i)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                Bundle bundle = new Bundle();
                bundle.putString("appid", ((String) (obj)));
                bundle.putString("action", "show_interstitial_before_load_finish");
                a(bundle);
            }
            com.google.android.gms.ads.internal.p.e();
            if (!gm.e(c.c))
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                Bundle bundle1 = new Bundle();
                bundle1.putString("appid", ((String) (obj)));
                bundle1.putString("action", "show_interstitial_app_not_in_foreground");
                a(bundle1);
            }
        }
        if (c.C == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L4; else goto _L3
_L3:
        boolean flag2;
        if (c.j.k)
        {
            try
            {
                c.j.m.b();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
            A();
            return;
        }
        if (c.j.b == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        if (c.j.b.m())
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        c.j.b.b(true);
        if (c.j.j != null)
        {
            e.a(c.i, c.j);
        }
        flag2 = c.E;
        if (!(c.c instanceof Activity)) goto _L6; else goto _L5
_L5:
        Object obj1 = ((Activity)c.c).getWindow();
        if (obj1 != null && ((Window) (obj1)).getDecorView() != null) goto _L8; else goto _L7
_L7:
        boolean flag1 = false;
_L10:
        obj1 = new InterstitialAdParameterParcel(flag2, flag1);
        int l = c.j.b.getRequestedOrientation();
        int j = l;
        if (l == -1)
        {
            j = c.j.g;
        }
        obj1 = new AdOverlayInfoParcel(this, this, this, c.j.b, j, c.e, c.j.v, ((InterstitialAdParameterParcel) (obj1)));
        com.google.android.gms.ads.internal.p.c();
        e.a(c.c, ((AdOverlayInfoParcel) (obj1)), true);
        return;
_L8:
        Rect rect = new Rect();
        Rect rect1 = new Rect();
        ((Window) (obj1)).getDecorView().getGlobalVisibleRect(rect, null);
        ((Window) (obj1)).getDecorView().getWindowVisibleDisplayFrame(rect1);
        if (rect.bottom != 0 && rect1.bottom != 0 && rect.top == rect1.top)
        {
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        flag1 = false;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected final boolean p()
    {
        if (super.p())
        {
            i = true;
            return true;
        } else
        {
            return false;
        }
    }
}
