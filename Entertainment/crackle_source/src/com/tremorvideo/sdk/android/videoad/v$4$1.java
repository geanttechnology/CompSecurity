// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, aw

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.m.removeView(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/v$4

/* anonymous class */
    class v._cls4
        implements android.view.View.OnClickListener
    {

        final View a;
        final aw b;
        final v c;

        public void onClick(View view)
        {
            c.m.post(new v._cls4._cls1(this));
            v.c(c, b);
            c.s = 0x7fffffffffffffffL;
            c.o = false;
            v.a(c, v.a(c));
            v.a(c, true);
            v.d(c, 0);
        }

            
            {
                c = v1;
                a = view;
                b = aw;
                super();
            }
    }

}
