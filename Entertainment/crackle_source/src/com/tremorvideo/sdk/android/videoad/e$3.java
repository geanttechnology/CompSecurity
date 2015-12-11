// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e, aw

class b
    implements android.view..OnClickListener
{

    final View a;
    final aw b;
    final e c;

    public void onClick(View view)
    {
        c.q.post(new Runnable() {

            final e._cls3 a;

            public void run()
            {
                a.c.q.removeView(a.a);
            }

            
            {
                a = e._cls3.this;
                super();
            }
        });
        e.c(c, b);
        c.w = 0x7fffffffffffffffL;
        c.s = false;
        e.a(c, e.a(c));
        e.a(c, true);
        e.d(c, 0);
    }

    _cls1.a(e e1, View view, aw aw)
    {
        c = e1;
        a = view;
        b = aw;
        super();
    }
}
