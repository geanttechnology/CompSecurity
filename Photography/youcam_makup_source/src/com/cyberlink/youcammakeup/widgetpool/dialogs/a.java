// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            b

public class a extends w.a.a
{

    private View a;
    private View b;
    private Activity c;
    private TextView d;
    private b e;
    private final android.content.DialogInterface.OnDismissListener f = new android.content.DialogInterface.OnDismissListener() {

        final a a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            a.a(a).a();
        }

            
            {
                a = a.this;
                super();
            }
    };

    public a(Activity activity, boolean flag)
    {
        super(activity, flag);
        c = activity;
    }

    static b a(a a1)
    {
        return a1.e;
    }

    protected int a()
    {
        return 0x7f03010f;
    }

    protected void a(View view)
    {
        d = (TextView)view.findViewById(0x7f0c056d);
        a = view.findViewById(0x7f0c056e);
        b = view.findViewById(0x7f0c056f);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view1)
            {
                a.a(a).b();
                a.dismiss();
            }

            
            {
                a = a.this;
                super();
            }
        });
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view1)
            {
                a.a(a).a();
                a.dismiss();
            }

            
            {
                a = a.this;
                super();
            }
        });
        super.setOnDismissListener(f);
    }

    public void a(b b1)
    {
        e = b1;
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        throw new UnsupportedOperationException("Cannot override the listener.");
    }
}
