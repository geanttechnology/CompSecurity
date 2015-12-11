// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SDKUtils;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

private class <init>
    implements android.view.ebViewTouchListener
{

    final SupersonicWebView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        f = motionevent.getX();
        f1 = motionevent.getY();
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("X:").append((int)f).append(" Y:").append((int)f1).toString());
        j1 = SDKUtils.getDeviceWidth();
        i1 = SDKUtils.getDeviceHeight();
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("Width:").append(j1).append(" Height:").append(i1).toString());
        k = SDKUtils.dpToPx(SupersonicWebView.access$400(SupersonicWebView.this));
        l = SDKUtils.dpToPx(SupersonicWebView.access$500(SupersonicWebView.this));
        i = 0;
        j = 0;
        if (!"top-right".equalsIgnoreCase(SupersonicWebView.access$600(SupersonicWebView.this))) goto _L4; else goto _L3
_L3:
        i = j1 - (int)f;
        j = (int)f1;
_L6:
        if (i <= k && j <= l)
        {
            SupersonicWebView.access$702(SupersonicWebView.this, false);
            if (SupersonicWebView.access$800(SupersonicWebView.this) != null)
            {
                SupersonicWebView.access$800(SupersonicWebView.this).cancel();
            }
            SupersonicWebView.access$802(SupersonicWebView.this, (new CountDownTimer(2000L, 500L) {

                final SupersonicWebView.SupersonicWebViewTouchListener this$1;

                public void onFinish()
                {
                    Logger.i(SupersonicWebView.access$300(this$0), "Close Event Timer Finish");
                    if (SupersonicWebView.access$700(this$0))
                    {
                        SupersonicWebView.access$702(this$0, false);
                        return;
                    } else
                    {
                        engageEnd("forceClose");
                        return;
                    }
                }

                public void onTick(long l1)
                {
                    Logger.i(SupersonicWebView.access$300(this$0), (new StringBuilder()).append("Close Event Timer Tick ").append(l1).toString());
                }

            
            {
                this$1 = SupersonicWebView.SupersonicWebViewTouchListener.this;
                super(l, l1);
            }
            }).start());
        }
_L2:
        return false;
_L4:
        if ("top-left".equalsIgnoreCase(SupersonicWebView.access$600(SupersonicWebView.this)))
        {
            i = (int)f;
            j = (int)f1;
        } else
        if ("bottom-right".equalsIgnoreCase(SupersonicWebView.access$600(SupersonicWebView.this)))
        {
            i = j1 - (int)f;
            j = i1 - (int)f1;
        } else
        if ("bottom-left".equalsIgnoreCase(SupersonicWebView.access$600(SupersonicWebView.this)))
        {
            i = (int)f;
            j = i1 - (int)f1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private _cls1.this._cls1()
    {
        this$0 = SupersonicWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
