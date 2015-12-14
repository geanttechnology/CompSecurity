// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.Context;
import android.view.View;
import w.a.a;

public class u extends a
{

    private View a;
    private android.view.View.OnClickListener b;

    public u(Context context, boolean flag)
    {
        super(context, flag);
        b = new android.view.View.OnClickListener() {

            final u a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = u.this;
                super();
            }
        };
    }

    protected int a()
    {
        return 0x7f030154;
    }

    protected void a(View view)
    {
        a = view.findViewById(0x7f0c0619);
        a.setOnClickListener(b);
    }
}
