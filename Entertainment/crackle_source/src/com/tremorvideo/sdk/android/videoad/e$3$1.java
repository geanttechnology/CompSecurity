// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e, aw

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.q.removeView(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/e$3

/* anonymous class */
    class e._cls3
        implements android.view.View.OnClickListener
    {

        final View a;
        final aw b;
        final e c;

        public void onClick(View view)
        {
            c.q.post(new e._cls3._cls1(this));
            e.c(c, b);
            c.w = 0x7fffffffffffffffL;
            c.s = false;
            e.a(c, e.a(c));
            e.a(c, true);
            e.d(c, 0);
        }

            
            {
                c = e1;
                a = view;
                b = aw;
                super();
            }
    }

}
