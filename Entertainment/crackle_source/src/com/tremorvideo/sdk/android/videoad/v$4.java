// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, aw

class b
    implements android.view..OnClickListener
{

    final View a;
    final aw b;
    final v c;

    public void onClick(View view)
    {
        c.m.post(new Runnable() {

            final v._cls4 a;

            public void run()
            {
                a.c.m.removeView(a.a);
            }

            
            {
                a = v._cls4.this;
                super();
            }
        });
        v.c(c, b);
        c.s = 0x7fffffffffffffffL;
        c.o = false;
        v.a(c, v.a(c));
        v.a(c, true);
        v.d(c, 0);
    }

    _cls1.a(v v1, View view, aw aw)
    {
        c = v1;
        a = view;
        b = aw;
        super();
    }
}
