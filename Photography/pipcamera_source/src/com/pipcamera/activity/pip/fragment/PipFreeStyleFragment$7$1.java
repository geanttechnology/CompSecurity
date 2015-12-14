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

class a
    implements Runnable
{

    final android.view.wListener a;
    final a b;

    public void run()
    {
        b.b.getViewTreeObserver().removeOnPreDrawListener(a);
    }

    ( , android.view.wListener wlistener)
    {
        b = ;
        a = wlistener;
        super();
    }

    // Unreferenced inner class com/pipcamera/activity/pip/fragment/PipFreeStyleFragment$7

/* anonymous class */
    class PipFreeStyleFragment._cls7
        implements android.view.ViewTreeObserver.OnPreDrawListener
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
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)a.getLayoutParams();
            if (f > b)
            {
                layoutparams.width = (int)(b * (float)j);
            } else
            {
                layoutparams.height = (int)((float)i / b);
            }
            a.setLayoutParams(layoutparams);
            (new Handler()).post(new PipFreeStyleFragment._cls7._cls1(this, this));
            return true;
        }

            
            {
                c = pipfreestylefragment;
                a = framelayout;
                b = f;
                super();
            }
    }

}
