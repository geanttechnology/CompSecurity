// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.smule.pianoandroid.utils.o;

class ax
    implements android.view.View.OnClickListener
{

    private android.view.View.OnClickListener a;
    private Context b;

    private ax(Context context, android.view.View.OnClickListener onclicklistener)
    {
        a = onclicklistener;
        b = context;
    }

    ax(Context context, android.view.View.OnClickListener onclicklistener, aw._cls1 _pcls1)
    {
        this(context, onclicklistener);
    }

    static android.view.View.OnClickListener a(ax ax1)
    {
        return ax1.a;
    }

    public void onClick(View view)
    {
        o.a((FragmentActivity)b, new Runnable(view) {

            final View a;
            final ax b;

            public void run()
            {
                ax.a(b).onClick(a);
            }

            
            {
                b = ax.this;
                a = view;
                super();
            }
        }, null, b.getResources().getString(0x7f0c0218), b.getResources().getString(0x7f0c0217));
    }
}
