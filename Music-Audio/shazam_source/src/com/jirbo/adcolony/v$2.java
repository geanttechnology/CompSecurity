// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import com.immersion.hapticmediasdk.a;
import com.immersion.hapticmediasdk.b;

// Referenced classes of package com.jirbo.adcolony:
//            v, e, q, g, 
//            x, aj, AdColonyBrowser, ad, 
//            ac

final class t> extends Handler
{

    final v a;

    public final void handleMessage(Message message)
    {
_L2:
        return;
        if (a.d.isFinishing() || a.d.B == null) goto _L2; else goto _L1
_L1:
        v v1;
        int i;
        v1 = a;
        i = message.what;
        if (!v1.C && i != 10) goto _L2; else goto _L3
_L3:
        try
        {
            v1.C = false;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            v1.C = true;
            return;
        }
        i;
        JVM INSTR tableswitch 1 10: default 727
    //                   1 147
    //                   2 283
    //                   3 419
    //                   4 693
    //                   5 112
    //                   6 112
    //                   7 112
    //                   8 112
    //                   9 112
    //                   10 715;
           goto _L4 _L5 _L6 _L7 _L8 _L4 _L4 _L4 _L4 _L4 _L9
_L9:
        break MISSING_BLOCK_LABEL_715;
_L4:
        v1.t = 0;
_L10:
        (new Handler()).postDelayed(new <init>(v1), 1500L);
        return;
_L5:
label0:
        {
            v1.t = 0;
            com.jirbo.adcolony.q.a("info", (new StringBuilder("{\"ad_slot\":")).append(q.A.c.k.c).append("}").toString(), v1.d.D);
            message = q.g("info_url");
            com.jirbo.adcolony.aj.b.a("INFO ").b(message);
            if (!message.startsWith("market:") && !message.startsWith("amzn:"))
            {
                break label0;
            }
            v1.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
        }
          goto _L10
        com.jirbo.adcolony.AdColonyBrowser.a = message;
        v1.d.startActivity(new Intent(v1.d, com/jirbo/adcolony/AdColonyBrowser));
          goto _L10
_L6:
label1:
        {
            v1.t = 0;
            com.jirbo.adcolony.q.a("download", (new StringBuilder("{\"ad_slot\":")).append(q.A.c.k.c).append("}").toString(), v1.d.D);
            message = q.g("download_url");
            com.jirbo.adcolony.aj.b.a("DOWNLOAD ").b(message);
            if (!message.startsWith("market:") && !message.startsWith("amzn:"))
            {
                break label1;
            }
            v1.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
        }
          goto _L10
        com.jirbo.adcolony.AdColonyBrowser.a = message;
        v1.d.startActivity(new Intent(v1.d, com/jirbo/adcolony/AdColonyBrowser));
          goto _L10
_L7:
        boolean flag;
        v1.t = 0;
        com.jirbo.adcolony.q.a("replay", v1.d.D);
        e.e = true;
        e.d = false;
        com.jirbo.adcolony.e.a = 0;
        v1.Q = false;
        message = new View(v1.d);
        message.setBackgroundColor(0xff000000);
        v1.d.K.addView(message, new android.widget.eLayout.LayoutParams(v1.d.s, v1.d.t, 17));
        (new Handler()).postDelayed(new <init>(v1, message), 900L);
        v1.d.B.start();
        flag = v1.d.G;
        if (!flag) goto _L12; else goto _L11
_L11:
        v1.d.E = b.a(v1.d);
        v1.d.E.a(v1.d.F);
_L13:
        if (v1.d.E == null)
        {
            v1.d.G = false;
        }
        if (v1.d.G)
        {
            v1.d.E.c();
        }
_L12:
        q.c.a(v1.d.D);
        v1.d.B.requestFocus();
        v1.d.B.setBackgroundColor(0);
        v1.d.B.setVisibility(0);
        v1.a(false);
        v1.invalidate();
          goto _L10
        message;
        v1.d.G = false;
          goto _L13
_L8:
        v1.t = 0;
        v1.d.B.a();
        v1.c();
          goto _L10
        v1.t = 0;
        v1.d();
          goto _L10
    }

    ion(v v1)
    {
        a = v1;
        super();
    }
}
