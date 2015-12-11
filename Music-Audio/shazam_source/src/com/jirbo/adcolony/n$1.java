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
//            n, k, q, ac, 
//            ar

final class 
    implements android.view..OnTouchListener
{

    final n a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i == 0)
        {
            view = new float[3];
            Color.colorToHSV(a.al, view);
            view[2] = view[2] * 0.8F;
            a.O.setBackgroundColor(Color.HSVToColor(view));
        } else
        {
            if (i == 3)
            {
                a.O.setBackgroundColor(a.al);
                return true;
            }
            if (i == 1)
            {
                if (a.C)
                {
                    a.af = k.c;
                    a.p = true;
                    return true;
                }
                if (a.R.equals("install") || a.R.equals("url"))
                {
                    q.c.d.a("native_overlay_click", null, a.D);
                    try
                    {
                        view = new Intent("android.intent.action.VIEW", Uri.parse(a.Q));
                        q.b().startActivity(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        Toast.makeText(q.b(), "Unable to open store.", 0).show();
                    }
                }
                a.O.setBackgroundColor(a.al);
                return true;
            }
        }
        return true;
    }

    t(n n1)
    {
        a = n1;
        super();
    }
}
