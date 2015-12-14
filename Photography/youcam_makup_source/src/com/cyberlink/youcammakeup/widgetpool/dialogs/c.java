// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.youcammakeup.clflurry.YMKPopupChangeEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import w.a.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            d

public class c extends a
{

    private View a;
    private View b;
    private Activity c;
    private TextView d;
    private d e;
    private final android.content.DialogInterface.OnDismissListener f = new android.content.DialogInterface.OnDismissListener() {

        final c a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            com.cyberlink.youcammakeup.widgetpool.dialogs.c.a(a).a();
        }

            
            {
                a = c.this;
                super();
            }
    };

    public c(Activity activity, boolean flag)
    {
        super(activity, flag);
        c = activity;
    }

    static d a(c c1)
    {
        return c1.e;
    }

    protected int a()
    {
        return 0x7f030110;
    }

    protected void a(View view)
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKPopupChangeEvent(com.cyberlink.youcammakeup.clflurry.YMKPopupChangeEvent.Operation.a));
        d = (TextView)view.findViewById(0x7f0c056d);
        a = view.findViewById(0x7f0c056e);
        b = view.findViewById(0x7f0c056f);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view1)
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.c.a(a).a();
                a.dismiss();
            }

            
            {
                a = c.this;
                super();
            }
        });
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view1)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKPopupChangeEvent(com.cyberlink.youcammakeup.clflurry.YMKPopupChangeEvent.Operation.b));
                com.cyberlink.youcammakeup.widgetpool.dialogs.c.a(a).b();
                a.dismiss();
            }

            
            {
                a = c.this;
                super();
            }
        });
        super.setOnDismissListener(f);
    }

    public void a(d d1)
    {
        e = d1;
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        throw new UnsupportedOperationException("Cannot override the listener.");
    }
}
