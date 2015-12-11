// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, dv, he, gm, 
//            ec, du, aq, gd, 
//            dx, dw, gn

public final class ck
    implements ce
{

    static final Map a;
    private final e b;
    private final dv c;

    public ck(e e1, dv dv1)
    {
        b = e1;
        c = dv1;
    }

    public final void a(he he1, Map map)
    {
        int i;
        byte byte0;
        byte0 = -1;
        String s = (String)map.get("a");
        i = ((Integer)a.get(s)).intValue();
        if (i != 5 && b != null && !b.a())
        {
            b.a(null);
            return;
        }
        i;
        JVM INSTR tableswitch 1 6: default 104
    //                   1 110
    //                   2 104
    //                   3 1566
    //                   4 1412
    //                   5 1829
    //                   6 1933;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6
_L1:
        com.google.android.gms.ads.internal.util.client.b.a(4);
        return;
_L2:
        dv dv1 = c;
        he1 = ((he) (dv1.j));
        he1;
        JVM INSTR monitorenter ;
        if (dv1.l == null)
        {
            dv1.a("Not an activity context. Cannot resize.");
            return;
        }
          goto _L7
        map;
        he1;
        JVM INSTR monitorexit ;
        throw map;
_L7:
        if (dv1.k.h() != null) goto _L9; else goto _L8
_L8:
        dv1.a("Webview is not yet available, size is not set.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L9:
        if (!dv1.k.h().e) goto _L11; else goto _L10
_L10:
        dv1.a("Is interstitial. Cannot resize an interstitial.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L11:
        if (!dv1.k.m()) goto _L13; else goto _L12
_L12:
        dv1.a("Cannot resize an expanded banner.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L13:
        if (!TextUtils.isEmpty((CharSequence)map.get("width")))
        {
            p.e();
            dv1.i = com.google.android.gms.d.gm.b((String)map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("height")))
        {
            p.e();
            dv1.f = com.google.android.gms.d.gm.b((String)map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("offsetX")))
        {
            p.e();
            dv1.g = com.google.android.gms.d.gm.b((String)map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("offsetY")))
        {
            p.e();
            dv1.h = com.google.android.gms.d.gm.b((String)map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("allowOffscreen")))
        {
            dv1.c = Boolean.parseBoolean((String)map.get("allowOffscreen"));
        }
        map = (String)map.get("customClosePosition");
        if (!TextUtils.isEmpty(map))
        {
            dv1.b = map;
        }
        Object obj;
        Object obj1;
        String s2;
        int j;
        boolean flag;
        if (dv1.i >= 0 && dv1.f >= 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0) goto _L15; else goto _L14
_L14:
        dv1.a("Invalid width and height options. Cannot resize.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L15:
        obj = dv1.l.getWindow();
        if (obj == null) goto _L17; else goto _L16
_L16:
        if (((Window) (obj)).getDecorView() != null) goto _L18; else goto _L17
_L17:
        dv1.a("Activity context is not ready, cannot get window or decor view.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L18:
        map = dv1.a();
        if (map != null) goto _L20; else goto _L19
_L19:
        dv1.a("Resize location out of screen or close button is not visible.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L20:
        m.a();
        i = com.google.android.gms.ads.internal.util.client.a.a(dv1.l, dv1.i);
        m.a();
        j = com.google.android.gms.ads.internal.util.client.a.a(dv1.l, dv1.f);
        obj1 = dv1.k.getWebView().getParent();
        if (obj1 == null) goto _L22; else goto _L21
_L21:
        if (!(obj1 instanceof ViewGroup)) goto _L22; else goto _L23
_L23:
        ((ViewGroup)obj1).removeView(dv1.k.getWebView());
        if (dv1.q != null) goto _L25; else goto _L24
_L24:
        dv1.s = (ViewGroup)obj1;
        p.e();
        obj1 = com.google.android.gms.d.gm.a(dv1.k.getWebView());
        dv1.n = new ImageView(dv1.l);
        dv1.n.setImageBitmap(((android.graphics.Bitmap) (obj1)));
        dv1.m = dv1.k.h();
        dv1.s.addView(dv1.n);
_L33:
        dv1.r = new RelativeLayout(dv1.l);
        dv1.r.setBackgroundColor(0);
        dv1.r.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, j));
        p.e();
        dv1.q = com.google.android.gms.d.gm.a(dv1.r, i, j);
        dv1.q.setOutsideTouchable(true);
        dv1.q.setTouchable(true);
        obj1 = dv1.q;
        if (!dv1.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((PopupWindow) (obj1)).setClippingEnabled(flag);
        dv1.r.addView(dv1.k.getWebView(), -1, -1);
        dv1.o = new LinearLayout(dv1.l);
        m.a();
        i = com.google.android.gms.ads.internal.util.client.a.a(dv1.l, 50);
        m.a();
        obj1 = new android.widget.RelativeLayout.LayoutParams(i, com.google.android.gms.ads.internal.util.client.a.a(dv1.l, 50));
        s2 = dv1.b;
        s2.hashCode();
        JVM INSTR lookupswitch 6: default 1948
    //                   -1364013995: 1142
    //                   -1012429441: 1100
    //                   -655373719: 1163
    //                   1163912186: 1205
    //                   1288627767: 1184
    //                   1755462605: 1121;
           goto _L26 _L27 _L28 _L29 _L30 _L31 _L32
_L36:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
_L35:
        dv1.o.setOnClickListener(new dv._cls1(dv1));
        dv1.o.setContentDescription("Close button");
        dv1.r.addView(dv1.o, ((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = dv1.q;
        obj = ((Window) (obj)).getDecorView();
        m.a();
        i = com.google.android.gms.ads.internal.util.client.a.a(dv1.l, map[0]);
        m.a();
        ((PopupWindow) (obj1)).showAtLocation(((android.view.View) (obj)), 0, i, com.google.android.gms.ads.internal.util.client.a.a(dv1.l, map[1]));
        if (dv1.p != null)
        {
            dv1.p.y();
        }
        dv1.k.a(new AdSizeParcel(dv1.l, new d(dv1.i, dv1.f)));
        dv1.a(map[0], map[1]);
        dv1.b("resized");
        he1;
        JVM INSTR monitorexit ;
        return;
_L25:
        dv1.q.dismiss();
          goto _L33
_L22:
        dv1.a("Webview is detached, probably in the middle of a resize or expand.");
        he1;
        JVM INSTR monitorexit ;
        return;
_L28:
        i = byte0;
        if (s2.equals("top-left"))
        {
            i = 0;
        }
          goto _L34
_L32:
        i = byte0;
        if (s2.equals("top-center"))
        {
            i = 1;
        }
          goto _L34
_L27:
        i = byte0;
        if (s2.equals("center"))
        {
            i = 2;
        }
          goto _L34
_L29:
        i = byte0;
        if (s2.equals("bottom-left"))
        {
            i = 3;
        }
          goto _L34
_L31:
        i = byte0;
        if (s2.equals("bottom-center"))
        {
            i = 4;
        }
          goto _L34
_L30:
        i = byte0;
        if (s2.equals("bottom-right"))
        {
            i = 5;
        }
          goto _L34
_L37:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
          goto _L35
_L38:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
          goto _L35
_L39:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
          goto _L35
_L40:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
          goto _L35
_L41:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
          goto _L35
_L42:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
          goto _L35
        map;
        dv1.a((new StringBuilder("Cannot show popup window: ")).append(map.getMessage()).toString());
        dv1.r.removeView(dv1.k.getWebView());
        if (dv1.s != null)
        {
            dv1.s.removeView(dv1.n);
            dv1.s.addView(dv1.k.getWebView());
            dv1.k.a(dv1.m);
        }
        he1;
        JVM INSTR monitorexit ;
        return;
_L4:
        he1 = new du(he1, map);
        if (((du) (he1)).a == null)
        {
            he1.a("Activity context is not available.");
            return;
        }
        p.e();
        if (!com.google.android.gms.d.gm.d(((du) (he1)).a).b())
        {
            he1.a("This feature is not available on the device.");
            return;
        } else
        {
            p.e();
            map = gm.c(((du) (he1)).a);
            map.setTitle(p.h().a(com.google.android.gms.a.b.create_calendar_title, "Create calendar event"));
            map.setMessage(p.h().a(com.google.android.gms.a.b.create_calendar_message, "Allow Ad to create a calendar event?"));
            map.setPositiveButton(p.h().a(com.google.android.gms.a.b.accept, "Accept"), new du._cls1(he1));
            map.setNegativeButton(p.h().a(com.google.android.gms.a.b.decline, "Decline"), new du._cls2(he1));
            map.create().show();
            return;
        }
_L3:
        he1 = new dx(he1, map);
        if (((dx) (he1)).b == null)
        {
            he1.a("Activity context is not available");
            return;
        }
        p.e();
        if (!com.google.android.gms.d.gm.d(((dx) (he1)).b).a())
        {
            he1.a("Feature is not supported by the device.");
            return;
        }
        map = (String)((dx) (he1)).a.get("iurl");
        if (TextUtils.isEmpty(map))
        {
            he1.a("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(map))
        {
            he1.a((new StringBuilder("Invalid image url: ")).append(map).toString());
            return;
        }
        String s1 = Uri.parse(map).getLastPathSegment();
        p.e();
        if (!gm.c(s1))
        {
            he1.a((new StringBuilder("Image type not recognized: ")).append(s1).toString());
            return;
        } else
        {
            p.e();
            android.app.AlertDialog.Builder builder = gm.c(((dx) (he1)).b);
            builder.setTitle(p.h().a(com.google.android.gms.a.b.store_picture_title, "Save image"));
            builder.setMessage(p.h().a(com.google.android.gms.a.b.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(p.h().a(com.google.android.gms.a.b.accept, "Accept"), new dx._cls1(he1, map, s1));
            builder.setNegativeButton(p.h().a(com.google.android.gms.a.b.decline, "Decline"), new dx._cls2(he1));
            builder.create().show();
            return;
        }
_L5:
        he1 = new dw(he1, map);
        if (((dw) (he1)).a == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        if ("portrait".equalsIgnoreCase(((dw) (he1)).c))
        {
            i = p.g().b();
        } else
        if ("landscape".equalsIgnoreCase(((dw) (he1)).c))
        {
            i = p.g().a();
        } else
        if (((dw) (he1)).b)
        {
            i = -1;
        } else
        {
            i = p.g().c();
        }
        ((dw) (he1)).a.setRequestedOrientation(i);
        return;
_L6:
        c.a(true);
        return;
_L26:
        i = byte0;
_L34:
        i;
        JVM INSTR tableswitch 0 5: default 1992
    //                   0 1226
    //                   1 1243
    //                   2 1260
    //                   3 1270
    //                   4 1287
    //                   5 1304;
           goto _L36 _L37 _L38 _L39 _L40 _L41 _L42
    }

    static 
    {
        HashMap hashmap = new HashMap();
        a = hashmap;
        hashmap.put("resize", Integer.valueOf(1));
        a.put("playVideo", Integer.valueOf(2));
        a.put("storePicture", Integer.valueOf(3));
        a.put("createCalendarEvent", Integer.valueOf(4));
        a.put("setOrientationProperties", Integer.valueOf(5));
        a.put("closeResizedAd", Integer.valueOf(6));
    }
}
