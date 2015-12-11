// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, ad, n, be

public class d extends a
{

    public d(a.a a1, Activity activity, n n1)
    {
        super(a1, activity);
        activity.addContentView(new View(activity), new android.widget.TableLayout.LayoutParams(-1, -1));
        ad.a(c, d.i());
        a1 = be.a(activity, n1.q(), n1.u(), d);
        a1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final d a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                a.d.a(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
        a1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final d a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.d.a(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
        activity = n1.u().a(aw.b.P);
        if (activity != null)
        {
            d.a(activity);
        }
        a1.show();
    }

    public void a()
    {
    }

    public void d()
    {
        super.d();
        if (d.j() != -1)
        {
            ad.a(c, d.j());
        }
    }

    public a.b n()
    {
        return a.b.c;
    }
}
