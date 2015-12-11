// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ax, ad, n

class c
    implements android.widget.rView.OnItemClickListener
{

    final c a;
    final String b;
    final Dialog c;
    final ax d;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ad.d((new StringBuilder()).append("Position setOnItemClickListener").append(i).toString());
        a.(i);
        if (b != null)
        {
            adapterview = d.a.d().c(b);
            if (adapterview != null)
            {
                d.a(adapterview);
                d.b(adapterview);
            }
        }
        ax.a(d, true);
        c.dismiss();
    }

    ener(ax ax1, ener ener, String s, Dialog dialog)
    {
        d = ax1;
        a = ener;
        b = s;
        c = dialog;
        super();
    }
}
