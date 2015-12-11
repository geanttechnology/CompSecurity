// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// Referenced classes of package com.jirbo.adcolony:
//            ad, z, ak, be, 
//            db

class a
    implements android.view.OnTouchListener
{

    final ad a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i == 0)
        {
            view = new float[3];
            Color.colorToHSV(a.am, view);
            view[2] = view[2] * 0.8F;
            a.P.setBackgroundColor(Color.HSVToColor(view));
        } else
        {
            if (i == 3)
            {
                a.P.setBackgroundColor(a.am);
                return true;
            }
            if (i == 1)
            {
                if (a.B)
                {
                    a.ag = z.c;
                    a.p = true;
                    return true;
                }
                if (a.S.equals("install") || a.S.equals("url"))
                {
                    ak.c.d.b("native_overlay_click", a.C);
                    try
                    {
                        view = new Intent("android.intent.action.VIEW", Uri.parse(a.R));
                        ak.b().startActivity(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        Toast.makeText(ak.b(), "Unable to open store.", 0).show();
                    }
                }
                a.P.setBackgroundColor(a.am);
                return true;
            }
        }
        return true;
    }

    (ad ad1)
    {
        a = ad1;
        super();
    }
}
