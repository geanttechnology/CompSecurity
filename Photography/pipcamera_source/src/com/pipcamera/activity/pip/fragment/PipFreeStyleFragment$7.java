// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.os.Handler;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class b
    implements android.view.rawListener
{

    final FrameLayout a;
    final float b;
    final PipFreeStyleFragment c;

    public boolean onPreDraw()
    {
        int i = a.getWidth();
        int j = a.getHeight();
        float f = (float)i / (float)j;
        Log.v("PipFreeStyleFragment", (new StringBuilder()).append("PipFreeStyleFragmentframeRatio:").append(f).toString());
        if (f == b)
        {
            return true;
        }
        android.widget.rams rams = (android.widget.rams)a.getLayoutParams();
        if (f > b)
        {
            rams.width = (int)(b * (float)j);
        } else
        {
            rams.height = (int)((float)i / b);
        }
        a.setLayoutParams(rams);
        (new Handler()).post(new Runnable(this) {

            final android.view.ViewTreeObserver.OnPreDrawListener a;
            final PipFreeStyleFragment._cls7 b;

            public void run()
            {
                b.a.getViewTreeObserver().removeOnPreDrawListener(a);
            }

            
            {
                b = PipFreeStyleFragment._cls7.this;
                a = onpredrawlistener;
                super();
            }
        });
        return true;
    }

    _cls1.a(PipFreeStyleFragment pipfreestylefragment, FrameLayout framelayout, float f)
    {
        c = pipfreestylefragment;
        a = framelayout;
        b = f;
        super();
    }
}
